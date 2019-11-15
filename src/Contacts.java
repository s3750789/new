import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Contacts {
    private String name;
    private String phoneNumber;
    private String email;
    private String address;

    public Contacts() {
    }

    public Contacts(String name, String phoneNumber, String email, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    private Scanner scanner = new Scanner(System.in);

    public boolean validateContact() {
        return checkName() && checkNumber() && checkEmail() && checkAddress();
    }

    private boolean checkName() {
        String nameRegex = "(([a-z]|[A-Z])(\\s)?)+";
        if (!name.matches(nameRegex)) {
            System.out.println("Wrong input name (should not contain digit or special character");
            return false;
        }
        return true;
    }

    private boolean checkNumber() {
        String phoneNumberRegex = "^\\+?(\\d\\s?){10,15}$";
        if (!phoneNumber.matches(phoneNumberRegex)) {
            System.out.println("Wrong input phone number (should not contain word or special character and number should be in length of 10 to 15");
            return false;
        }
        return true;
    }

    private boolean checkEmail() {
        String emailRegex = "(\\w[.]?)+@\\w+[.]\\w+([.]\\w+)?";
        if (!email.matches(emailRegex)) {
            System.out.println("Wrong input email (should be followed by example: john@example.com or john@example.com.vn");
            return false;
        }
        return true;
    }

    private boolean checkAddress() {
        String addressRegex = "^([{\\d*\\s?]+|[\\w^\\d\\s?]+|\\s?[,]*\\s?)+$";
        if (!address.matches(addressRegex)) {
            System.out.println("Wrong input address (should not contain special character");
        }
        return true;
    }
}

class SortName implements Comparator<Contacts> {
    @Override
    public int compare(Contacts o1, Contacts o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class SortPhone implements Comparator<Contacts> {
    @Override
    public int compare(Contacts o1, Contacts o2) {
        return o1.getPhoneNumber().compareTo(o2.getPhoneNumber());
    }
}
class SortEmail implements Comparator<Contacts> {
    @Override
    public int compare(Contacts o1, Contacts o2) {
        return o1.getEmail().compareTo(o2.getEmail());
    }
}
class SortAddress implements Comparator<Contacts> {
    @Override
    public int compare(Contacts o1, Contacts o2) {
        return o1.getAddress().compareTo(o2.getAddress());
    }
}


