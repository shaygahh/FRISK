import java.sql.*;
import java.util.Scanner;

public class FTS {
    static String execute(String sql) {
        String url = "jdbc:postgresql://localhost:5432/fakedb";
        String user = "usershay";
        String password = "shaygah14";
        //Scanner scanner = new Scanner(s);
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            String result = "\n RESULTS: \n";
            while (rs.next()) {
                result = result + " " + rs.getString(1);
                result = result + " " + rs.getString(2);
                result = result + " " + rs.getString(3);
//               result = result + rs.getString(6);
//               result = result + rs.getString(7);
//               result = result + rs.getString(8);
//               result = result + rs.getString(9);
                //result = result + " " + rs.getString(8);
                result = result + "\n";
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "NOTHING";
    }

    public static void main(String[] args) {
        String sql;
        //start with 1 mil of the data to manipulate
        //time variables
        long start, normOne, ANDOne, OROne, langOne, highOne, rankOne;
        //String result;
        //normal query
        start = System.nanoTime();
        sql = " SELECT * FROM fakertb WHERE document @@ to_tsquery('english', 'Horror');";
        execute(sql);
        normOne = ((System.nanoTime() - start) / 1_000_000_000 / 60);

//        //query with AND
        start = System.nanoTime();
        sql = " SELECT * FROM fakertb WHERE document @@ to_tsquery('english', 'Horror') AND document @@ to_tsquery('english', 'west');";
        execute(sql);
        ANDOne = ((System.nanoTime() - start) / 1_000_000_000 / 60);
//
        //query with OR
        start = System.nanoTime();
        sql = " SELECT * FROM fakertb WHERE document @@ to_tsquery('english', 'Horror') OR document @@ to_tsquery('english', 'Classic');";
        execute(sql);
        OROne = ((System.nanoTime() - start) / 1_000_000_000) / 60;
//
        //query with LANG
        start = System.nanoTime();
        sql = " SELECT * FROM fakertb WHERE document @@ to_tsquery('russian', 'новгород');";
        execute(sql);
        langOne = ((System.nanoTime() - start) / 1_000_000_000) / 60;
//
        //query with highlights
//        start = System.nanoTime();
//        sql = " SELECT ts_headline(FROM fakertb WHERE to_tsvector(document) @@ to_tsquery('english', 'Steven');";
//        execute(sql);
//        highOne = ((System.nanoTime() - start) / 1_000_000_000) / 60;
//
        //query with ranks
        start = System.nanoTime();
        sql = " SELECT id, firstname, surname, RANK() OVER(PARTITION BY genre ORDER BY id DESC) Rank " +
                "FROM fakertb " +
                "WHERE genre = 'Western' OR genre = 'Comic/Graphic Novel'" +
                "ORDER BY id, Rank;";

        execute(sql);
        rankOne = ((System.nanoTime() - start) / 1_000_000_000) / 60;

        //print results
        System.out.println("1 MILLION DATASET");
        System.out.println("---------------------------------------");
        System.out.println("Time taken for normal query: " + normOne + " minute(s).");
        System.out.println("Time taken for AND query: " + ANDOne + " minute(s).");
        System.out.println("Time taken for OR query: " + OROne + " minutes().");
        System.out.println("Time taken for language query: " + langOne + " minutes.");
        // System.out.println("Time taken for normal query: " + highOne + " minutes." + result);
        System.out.println("Time taken for ranked normal query: " + rankOne + " minutes.");
    }
}
