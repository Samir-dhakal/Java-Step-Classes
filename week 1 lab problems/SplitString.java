// Write a program to split the text into words, compare the result with the split() method and
// display the result
// Hint =>
// a. Take user input using the Scanner nextLine() method
// b. Create a Method to find the length of the String without using the built-in length()
// method.

// 2

// c. Create a Method to split the text into words using the charAt() method without using the
// String built-in split() method and return the words. Use the following logic
// i. Firstly Count the number of words in the text and create an array to store the
// indexes of the spaces for each word in a 1D array
// ii. Then Create an array to store the words and use the indexes to extract the words
// d. Create a method to compare the two String arrays and return a boolean
// e. The main function calls the user-defined method and the built-in split() method. Call the
// user defined method to compare the two string arrays and display the result
import java.util.Scanner;

public class SplitString {

    public static int giveLength(String str) {
        int i = 0;
        try {
            while (true) {
                str.charAt(i);
                i++;
            }
        } catch (IndexOutOfBoundsException e) {

        }
        return i;
    }

    public static String[] customSplit(String text) {
        int length = giveLength(text);
        int spaceCount = 0;

        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        String[] words = new String[spaceCount + 1];
        int start = 0;
        int wordIndex = 0;

        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                words[wordIndex++] = text.substring(start, i);
                start = i + 1;
            }
        }

        words[wordIndex] = text.substring(start, length);

        return words;
    }

    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length)
            return false;
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the text: ");
        String text = input.nextLine();

        String[] customWords = customSplit(text);

        String[] builtInWords = text.split(" ");

        boolean isSame = compareArrays(customWords, builtInWords);

        System.out.println("Custom Split Result:");
        for (String word : customWords) {
            System.out.println(word);
        }

        System.out.println("\nBuilt-in Split Result:");
        for (String word : builtInWords) {
            System.out.println(word);
        }

        System.out.println("\nAre both methods giving the same result? " + isSame);

        input.close();
    }
}
