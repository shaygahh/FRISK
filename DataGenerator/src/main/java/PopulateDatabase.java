import com.github.javafaker.Faker;
import com.github.javafaker.IdNumber;

import java.sql.*;
import java.util.Locale;
import java.util.Scanner;
import java.util.UUID;

public class PopulateDatabase {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/fakedb";
        String user = "usershay";
        String password = "shaygah14";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement st = connection.createStatement();
            String sql = "CREATE TABLE fakerTB " +
                    "(id VARCHAR(255) NOT NULL, " +
                    "firstname VARCHAR(255) NOT NULL, " +
                    "surname VARCHAR(255) NOT NULL, " +
                    "email VARCHAR(255) NOT NULL, " +
                    "locale TEXT NOT NULL, " +
                    "address TEXT NOT NULL, " +
                    "university TEXT NOT NULL, " +
                    "genre TEXT NOT NULL, " +
                    "author TEXT NOT NULL, " +
                    "PRIMARY KEY ( id ))";

            //     String sql = "DROP TABLE fakerTB ";
            //     String sql =//"ALTER TABLE fakertb ADD document tsvector" ;
            // "CREATE INDEX tsv_idx ON fakertb USING gin(document);";
//                      "UPDATE fakertb SET document = to_tsvector('english', coalesce(address,'') || ' ' || coalesce(genre,''))";
            // "CREATE INDEX textsearch_idx ON fakertb USING gin(document)";
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
////
//        String[][] localeList = {
//                {"en", "english"},
//                {"ko", "korean"},
//                {"de", "german"},
//                {"ru", "russian"}
//        };
//        long start = System.nanoTime();
//        for (int i = 0; i < 1000000; i++) {
//            int numLocale = (int) (Math.random() * (4));
//            String locale = localeList[numLocale][0];
//
        // Faker faker = new Faker(Locale.forLanguageTag(locale));
//            String fullLocale = localeList[numLocale][1];
//            String firstName = faker.name().firstName();
//            String surname = faker.name().firstName();
//            String email = faker.bothify("???????##@gmail.com");
//            String address = faker.address().fullAddress();
//            String university = faker.university().name();
//            String genre = faker.book().genre();
//            String author = faker.book().author();
//            UUID uuid = UUID.randomUUID();
//            String id = uuid.toString();
        //  String title = faker.book().title();
//
//            System.out.println("Personal Information:\n" + firstName +" " + surname);
//
//            String insertSQL = "INSERT INTO fakerTB VALUES (?,?,?,?,?,?,?,?,?)";
//            try {
//                Connection connection = DriverManager.getConnection(url, user, password);
//                PreparedStatement pst = connection.prepareStatement(insertSQL);
//                pst.setString(1, id);
//                pst.setString(2, firstName);
//                pst.setString(3, surname);
//                pst.setString(4, email);
//                pst.setString(5, fullLocale);
//                pst.setString(6, address);
//                pst.setString(7, university);
//                pst.setString(8, genre);
//                pst.setString(9, author);
//
//                pst.executeUpdate();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        long end = System.nanoTime();
//        System.out.println(((end - start) / 1_000_000_000) / 60);
    }
}
