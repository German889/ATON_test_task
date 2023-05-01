package developer_font_office_technology.task2;

import java.util.HashMap;
import java.util.Scanner;

public class PhoneBook {
    private HashMap<String, String> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>(18758328);
    }
    public void fillData() {
        Scanner reader = new Scanner(System.in);
        for (int i = 0; i < 18758328; i++) {
            String phoneNumber = reader.nextLine();
            String fullName = reader.nextLine();
            phoneBook.put(phoneNumber, fullName);
        }
    }
    public String findByPhoneNumber(String phoneNumber) {
        return phoneBook.get(phoneNumber);
    }
}