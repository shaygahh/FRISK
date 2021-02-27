import com.github.javafaker.Faker;
import com.github.javafaker.IdNumber;

import java.util.Locale;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
                    "email VARCHAR(255) NOT NULL, " +
                    "firstname VARCHAR(255) NOT NULL, " +
                    "surname VARCHAR(255) NOT NULL, " +
                    "phnumber VARCHAR(255) NOT NULL, " +
                    "address TEXT NOT NULL, " +
                    "PRIMARY KEY ( id ))";

             //String sql = "DROP TABLE fakerTB ";

            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String[] localeList = {
                "en",
                "ja",
                "ko"
                };
        String locale = localeList[0 + (int)(Math.random() * ((2 - 0) + 1))];

        Faker faker = new Faker(Locale.forLanguageTag(locale));
        String firstName = faker.name().firstName();
        String surname = faker.name().firstName();
        String email = faker.bothify("???????##@gmail.com");
        String address = faker.address().fullAddress();
        String phoneNumber = faker.phoneNumber().phoneNumber();
        String id = faker.bothify("#############");
        System.out.println("Personal Information:\n" + firstName +" " + surname + "\n" + email + "\n" +  address+ "\n" + phoneNumber + "\n" + id);

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement st = connection.createStatement();
//            String sql = "INSERT INTO fakerTB VALUES ("
//                    + id + ", " + email + ", " + firstName + ", " +
//                    surname + ", " + phoneNumber + ", " + address + ")";

            String sql = "INSERT INTO fakerTB(id, email, firstname, surname, phnumber, address) VALUES ("
                    + id + ", " + email + ", " + firstName + ", " +
                    surname + ", " + phoneNumber + ", " + address + ")";

            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
