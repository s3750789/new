import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class test {
    public Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws IOException, InputMismatchException{
        ContactAccomplish myArr = new ContactAccomplish();
        System.out.println("This one from getinput from file and change the array " + myArr.getInput());
        myArr.viewContact();
//        System.out.println(myArr.addContact());
//        myArr.viewContact();
        myArr.sortContact();
        myArr.viewContact();
    }
}
