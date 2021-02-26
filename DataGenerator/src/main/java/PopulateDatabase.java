import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Scanner;

public class PopulateDatabase {
    public static void main(String[] args) {
        String[] localeList = {
                "en",
                "ja",
                "ko"
                };
        System.out.println("Please enter a number corresponding with a locale below: ");
        System.out.println( "0. English " +
                            "1. Japanese " +
                            "2. Korean");
        Scanner input = new Scanner(System.in);
        String locale = localeList[input.nextInt()];

        Faker faker = new Faker(Locale.forLanguageTag(locale));
        String fullName = faker.name().fullName();
        String email = faker.bothify("???????##@gmail.com");
        String address = faker.address().fullAddress();
        String phoneNumber = faker.phoneNumber().phoneNumber();
        System.out.println("Personal Information:\n" + fullName + "\n" + email + "\n" + address + "\n" + phoneNumber);


    }
}
