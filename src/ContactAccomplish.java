import java.io.IOException;
import java.util.*;

public class ContactAccomplish {
    private static ArrayList<Contacts> contactsArr = new ArrayList<>();
    private Scanner typeIn = new Scanner(System.in);

    private java.io.File file = new java.io.File("contacts.txt");

    public ArrayList<Contacts> getInput () {

        if (!file.exists()){
            System.out.println(file + "file does not exit");
            System.exit(1);
        }
        try {
            Scanner input = new Scanner(file);                  //Get the input
            input.useDelimiter(";|\r?\n|\r");                   //Input will cut reading and save into variables once read [;] or "\n"
            while (input.hasNextLine()) {                       //Run through all lines in file
                String readName = input.next();                 //Find the first element is name
                String readPhoneNumber = input.next();          //Element is phone number
                String readEmail = input.next();                //Element is email address
                String readAddress = input.next();              //Element is address
                ContactAccomplish.contactsArr.add(new Contacts(readName,readPhoneNumber,readEmail,readAddress));     //Create an object contains 4 elements and add into arraylist
            }
            input.close();          //close the scanner
        }
        catch (IOException ex1 ){
            System.out.println("I/O error occurred " + ex1);
        }
        return ContactAccomplish.contactsArr;
    }

    public void viewContact (){
        int i = 1;
        System.out.printf("%-30s%-30s%-30s%-50s\n","Name", "Phone Number", "Email Address", "Home Address");
        for (Contacts person : contactsArr){
            System.out.printf("%-30s%-30s%-30s%-50s\n",person.getName(),person.getPhoneNumber(),person.getEmail(),person.getAddress());
            i++;
        }
    }

    public ArrayList<Contacts> addContact() {
        System.out.print("Please input name: ");
        String newName = typeIn.nextLine();
        System.out.print("Please input phone number: ");
        String newPhoneNumber = typeIn.nextLine();
        System.out.print("Please input email: ");
        String newEmail = typeIn.nextLine();
        System.out.print("Please input address: ");
        String newAddress = typeIn.nextLine();
        Contacts object = new Contacts(newName,newPhoneNumber,newEmail,newAddress);

        if (object.validateContact()) {
            System.out.println("Do you want to add this information into your input: ");
            System.out.printf("%20s%20s%30s%50s\n\n",object.getName(),object.getPhoneNumber(),object.getEmail(),object.getAddress());
            System.out.println("0. Yes \n 1. No");

        }
        return contactsArr;
    }

    public ArrayList<Contacts> editContact() {
        System.out.println("What do you want to edit: ");
        System.out.println();
        return contactsArr;
    }
    public void sortContact() {
        System.out.println("1. Name\n2.Phone\n3.Email\n4.Address");
        System.out.print("What do you want to sort: ");
        try {
            Scanner justType = new Scanner(System.in);
            String selection = justType.nextLine();
            switch (selection){
                case "1":
                    contactsArr.sort(new SortName());
                    break;
                case "2":
                    contactsArr.sort(new SortPhone());
                    break;
                case "3":
                    contactsArr.sort(new SortEmail());
                     break;
                case "4":
                    contactsArr.sort(new SortAddress());
                    break;
                default:
                    System.out.println("Wrong input (should be 1-4)");
                    break;
            }
        }
        catch (InputMismatchException ex) {
            System.out.println("Wrong input (should be 1-4)");
        }
    }
}
