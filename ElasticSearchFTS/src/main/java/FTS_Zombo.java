import java.sql.*;

public class FTS_Zombo {
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
                result = result + " " + rs.getString(4);
                result = result + " " + rs.getString(5);
                result = result + " " + rs.getString(6);
                result = result + " " + rs.getString(7);
                result = result + " " + rs.getString(8);
                result = result + " " + rs.getString(9);
                result = result + " " + rs.getString(10);
                result = result + "\n";
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "NOTHING";
    }

    public static void main(String[] args) {
        //time variables
        long start, normOne, ANDOne, OROne, langOne, highOne, rankOne;
        String result, sql;

        //normal query
//        start = System.nanoTime();
//        sql = " SELECT * FROM fakertb WHERE fakertb ==> 'Horror';";
//        result = execute(sql);
//        normOne = ((System.nanoTime() - start) / 1_000_000_000 / 60);

//        //AND query
//        start = System.nanoTime();
//        sql = " SELECT * FROM fakertb WHERE fakertb ==> 'Horror AND west';";
//        result = execute(sql);
//        ANDOne = ((System.nanoTime() - start) / 1_000_000_000);
//
//        //OR query
//        start = System.nanoTime();
//        sql = " SELECT * FROM fakertb WHERE fakertb ==> 'Horror, Classic';";
//        result = execute(sql);
//        OROne = ((System.nanoTime() - start) / 1_000_000_000 / 60);
//
        //lang query
        start = System.nanoTime();
        sql = " SELECT * FROM fakertb WHERE fakertb ==> 'russian AND новгород';";
        result = execute(sql);
        langOne = ((System.nanoTime() - start) / 1_000_000_000);
//
//        //rank query !!!!
//        start = System.nanoTime();
//        sql = " SELECT * FROM fakertb WHERE fakertb ==> 'russian, новгород';";
//        result = execute(sql);
//        langOne = ((System.nanoTime() - start) / 1_000_000_000 / 60);
//
//        //highlight query !!!!
//        start = System.nanoTime();
//        sql = " SELECT * FROM fakertb WHERE fakertb ==> ''russian, новгород'';";
//        result = execute(sql);
//        langOne = ((System.nanoTime() - start) / 1_000_000_000 / 60);

        System.out.println("1 MILLION DATASET - ELASTICSEARCH WITH ZOMBODB FTS");
        System.out.println("---------------------------------------");
      //  System.out.println("Time taken for normal query: " + normOne + " minute(s).");
      //  System.out.println(result + "Time taken for AND query: " + ANDOne + " seconds(s).");
       // System.out.println("Time taken for OR query: " + OROne + " minute(s).");
        System.out.println("Time taken for lang query: " + langOne + " seconds(s).");
    }
}
