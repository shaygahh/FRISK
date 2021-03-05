import java.sql.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class FTS {
    static void execute(String sql) {
        String url = "jdbc:postgresql://localhost:5432/fakedb";
        String user = "usershay";
        String password = "shaygah14";
        //Scanner scanner = new Scanner(s);
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //String result = "\n RESULTS: \n";
//            while (rs.next()) {
//                result = result + " " + rs.getString(1);
//                result = result + " " + rs.getString(2);
//                result = result + " " + rs.getString(3);
//                result = result + " " + rs.getString(4);
//                result = result + " " + rs.getString(5);
//                result = result + " " + rs.getString(6);
//                result = result + " " + rs.getString(7);
//                result = result + " " + rs.getString(8);
//                result = result + " " + rs.getString(9);
//                result = result + " " + rs.getString(10);
//                result = result + "\n";
//            }
            //return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //return "NOTHING";
    }

    public static void main(String[] args) {
        String sql;
        //start with 1 mil of the data to manipulate
        //time variables
        long start, normOne, ANDOne, OROne, langOne, highOne, rankOne;
        String result;
        //normal query
        start = System.nanoTime();
        sql = " SELECT * FROM fakertb WHERE document @@ to_tsquery('english', 'Horror');";
       execute(sql);
        normOne = TimeUnit.NANOSECONDS.toMillis((System.nanoTime() - start));

//        //query with AND
        start = System.nanoTime();
        sql = " SELECT * FROM fakertb WHERE document @@ to_tsquery('english', 'Horror') AND document @@ to_tsquery('english', 'west');";
        execute(sql);
        ANDOne = TimeUnit.NANOSECONDS.toMillis((System.nanoTime() - start));

        //query with OR
        start = System.nanoTime();
        sql = " SELECT * FROM fakertb WHERE document @@ to_tsquery('english', 'Horror') OR document @@ to_tsquery('english', 'Classic');";
        execute(sql);
        OROne = TimeUnit.NANOSECONDS.toMillis((System.nanoTime() - start));
//
        //query with LANG
        start = System.nanoTime();
        sql = " SELECT * FROM fakertb WHERE document @@ to_tsquery('russian', 'новгород');";
        execute(sql);
        langOne = TimeUnit.NANOSECONDS.toMillis((System.nanoTime() - start));
////
//        //query with ranks
//        start = System.nanoTime();
//        sql = " SELECT id, firstname, surname, RANK() OVER(PARTITION BY genre ORDER BY id DESC) Rank " +
//                "FROM fakertb " +
//                "WHERE genre = 'Western' OR genre = 'Comic/Graphic Novel'" +
//                "ORDER BY id, Rank;";
//
//        execute(sql);
//        rankOne = ((System.nanoTime() - start) / 1_000_000_000) / 60;

//        //query with highlights
//        start = System.nanoTime();
//        sql = " SELECT * FROM fakertb WHERE ts_headline('document', to_tsquery('english', 'Essay'))" ;
//                  //"FROM fakertb" ;
////                  "WHERE document @@ to_tsquery('english', 'Essay')" +
////                    "ORDER BY id;";
//        result = execute(sql);
//        highOne = ((System.nanoTime() - start) / 1_000_000_000) / 60;

        //print results
        System.out.println("1 MILLION DATASET - POSTGRESQL FTS");
        System.out.println("---------------------------------------");
        System.out.println("Time taken for simple query: " + normOne + " millisecond(s).");
       System.out.println("Time taken for AND query: " + ANDOne + " millisecond(s).");
        System.out.println("Time taken for OR query: " + OROne + " millisecond(s).");
       System.out.println( "Time taken for language query: " + langOne + " millisecond(s).");
        // System.out.println(result + "Time taken for highlight query: " + highOne + " minutes." + result);
//        System.out.println("Time taken for ranked normal query: " + rankOne + " minutes.");
    }
}
