package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import com.github.javafaker.Faker;

public class RandomDataUtility {
	
	static Faker faker;

	public static String getCategoryName_Utility() {
		faker = new Faker();
		return faker.commerce().department();
	}
	
	public static int getRandomNumberBetWeen_Utility(int startNumber,int endNumber) {
		faker = new Faker();
		return faker.number().numberBetween(startNumber, endNumber);
	}

	public static String getFirstName_Utility() {
		faker = new Faker(new Locale("en-IND"));
		return faker.name().firstName();
	}

	public static String getFullAddress_Utility() {
		faker = new Faker(new Locale("en-IND"));
		return faker.address().fullAddress();
	}

	public static String getBuldingNumberWithStreetAddress_Utility() {
		faker = new Faker(new Locale("en-IND"));
		String buildingNumber = faker.address().buildingNumber();
		String streetAddress = faker.address().streetAddress();
		return buildingNumber + streetAddress;
	}

	public static String getPhoneNumber_Utility() {

		faker = new Faker(new Locale("en-IND"));
		String extension = faker.phoneNumber().extension();
		String phoneNumber = faker.phoneNumber().cellPhone().concat(extension);
		return phoneNumber;

	}

	public static String getEmail_Utility() {

		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		int length = 5;
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(alphabet.length());
			char randomChar = alphabet.charAt(index);
			sb.append(randomChar);
		}
		String randomStringEmail = sb.toString() + "@gmail.com";
		return randomStringEmail;

	}
	
	public static String getPassword_Utility() {
		faker = new Faker();
		return faker.internet().password(5, 8);
	}
	
	
	public static String getDateOfBirth_Day_Utility() {
		SimpleDateFormat simpledate = new SimpleDateFormat("dd");
		faker = new Faker();
		String date = simpledate.format(faker.date().birthday());
		return date;
		
	}
	
     public static Date getAge_Utility() {
		faker = new Faker();		
		return faker.date().birthday(18,60);
		
	}
     
     
     public static String getDateOfBirth_Utility() {
 		SimpleDateFormat simpledate = new SimpleDateFormat("dd-mm-yyyy");
 		faker = new Faker();
 		Date date = faker.date().birthday(18,60);
 		return simpledate.format(date);
 		 		
 	}
	
}
