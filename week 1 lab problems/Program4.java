
// Write a program to split the text into words and find the shortest and longest strings in a
// given text
// Hint =>
// a. Take user input using the Scanner nextLine() method
// b. Create a Method to split the text into words using the charAt() method without using the
// String built-in split() method and return the words.
// c. Create a method to find and return a string's length without using the length() method.
// d. Create a method to take the word array and return a 2D String array of the word and its
// corresponding length. Use String built-in function String.valueOf() to generate the String
// value for the number
// e. Create a Method that takes the 2D array of word and corresponding length as
// parameters, find the shortest and longest string and return them in an 1D int array.
// f. The main function calls the user-defined methods and displays the result.
import java.util.Scanner;

public class Program4 {

    // Method to split text into words (without using split())
    public static String[] TextToWords(String text) {
        int wordCount = 0;
        int i = 0;

        // Count words
        while (i < text.length()) {
            while (i < text.length() && text.charAt(i) == ' ') {
                i++; // skip spaces
            }
            if (i < text.length()) {
                wordCount++;
                while (i < text.length() && text.charAt(i) != ' ') {
                    i++;
                }
            }
        }

        System.out.println("Count:" + wordCount);
        String[] words = new String[wordCount];

        // Extract words
        int index = 0;
        i = 0;
        while (i < text.length()) {
            while (i < text.length() && text.charAt(i) == ' ') {
                i++; // skip spaces
            }
            int start = i;
            while (i < text.length() && text.charAt(i) != ' ') {
                i++;
            }
            if (start < i) {
                words[index++] = text.substring(start, i);
            }
        }

        return words;
    }

    // method to return the word and their length
    public static String[][] WordsAndLength(String str) {

        String[][] wordsAndLength = new String[2][TextToWords(str).length];
        for (int i = 0; i < TextToWords(str).length; i++) {
            wordsAndLength[0][i] = String.valueOf((TextToWords(str)[i].length()));
        }
        return wordsAndLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text:");
        String input = sc.nextLine();

        String[] words = TextToWords(input);

        // Print words
        for (String w : words) {
            System.out.println(w);
        }
        String[][] wordsAndLength = WordsAndLength(input);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(wordsAndLength[i][j]);
            }
        }
        sc.close();
    }
}
