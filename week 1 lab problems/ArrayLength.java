
// 1. Write a program to find and return the length of a string without using the length() method
// Hint =>
// a. Take user input using the Scanner next() method
// b. Create a method to find and return a string's length without using the built-in length()
// method. The logic for this is to use the infinite loop to count each character till the
// charAt() method throws a runtime exception, handles the exception, and then return
// the count
// c. The main function calls the user-defined method as well as the built-in length() method
// and displays the result
import java.util.Scanner;

public class ArrayLength extends Exception {
    public static int calculateLengeth(String str) {

        int i = 0;
        while (true) {
            try {
                str.charAt(i);
                i++;
            } catch (IndexOutOfBoundsException n) {
                System.out.println("null pointer exception " + n.getMessage());

            }
            catch(Exception e){

            }
          
 return i;
        }
 
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter any string ");
        String string = input.nextLine();
        System.out.println(" the number of strings in the string is " + calculateLengeth(string));
        System.out.println("samir");
        input.close();
    }
}