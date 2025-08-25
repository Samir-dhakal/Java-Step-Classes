
// Write a program to trim the leading and trailing spaces from a string using the charAt()
// method
// Hint =>
// a. Create a method to trim the leading and trailing spaces from a string using the charAt()
// method. Inside the method run a couple of loops to trim leading and trailing spaces and
// determine the starting and ending points with no spaces. Return the start point and end
// point in an array
// b. Write a method to create a substring from a string using the charAt() method with the
// string, start, and end index as the parameters
// c. Write a method to compare two strings using the charAt() method and return a boolean
// result
// d. The main function calls the user-defined trim and substring methods to get the text after
// trimming the leading and trailing spaces. Post that use the String built-in method trim()
// to trim spaces and compare the two strings. And finally display the result
import java.util.Scanner;

public class Program7 {
    public static int[] Trimmer(String str) {
        int[] index = new int[2];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                index[0] = i;
                break;
            }

        }
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) != ' ') {
                index[1] = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter the string with the leading and trailing spaces : ");
        String str = input.nextLine();

        int index[] = Trimmer(str);
        for (int i = index[0]; i <= index[1]; i++) {
            System.out.print(str.charAt(i));
        }
        input.close();
    }
}