// Problem 1: Write a program to implement a simple spell checker that finds
// and suggests corrections for misspelled words using string distance
// calculation
// Hint =>
// a. Take user input for a sentence and a dictionary of correct words (stored in an array)
// b. Create a method to split the sentence into words without using split():
// ● i. Use charAt() to identify word boundaries (spaces, punctuation)
// ● ii. Extract each word using substring() method
// ● iii. Store words in an array
// c. Create a method to calculate string distance between two words:
// ● i. Count character differences between words of same length
// ● ii. For different lengths, calculate insertion/deletion distance
// ● iii. Return the distance as an integer
// d. Create a method to find the closest matching word from dictionary:
// ● i. Compare input word with each dictionary word

// 1

// ● ii. Find the word with minimum distance
// ● iii. Return the suggestion if distance is within acceptable range (≤ 2)
// e. Create a method to display spell check results in tabular format:
// ● i. Show original word, suggested correction, distance score
// ● ii. Mark words as "Correct" or "Misspelled"
// f. The main function processes the sentence and displays comprehensive spell check report
import java.util.Scanner;

public class SpellChecker {

    // Method to manually split sentence into words
    public static String[] splitSentence(String sentence) {
        int length = sentence.length();
        String[] temp = new String[length]; // max possible words
        int wordCount = 0;
        int start = 0;

        for (int i = 0; i <= length; i++) {
            if (i == length || sentence.charAt(i) == ' ' || sentence.charAt(i) == '.' || sentence.charAt(i) == ','
                    || sentence.charAt(i) == '!') {
                if (i > start) {
                    temp[wordCount++] = sentence.substring(start, i);
                }
                start = i + 1;
            }
        }

        // Copy only valid words
        String[] words = new String[wordCount];
        for (int i = 0; i < wordCount; i++) {
            words[i] = temp[i];
        }
        return words;
    }

    // Method to calculate string distance (basic edit distance)
    public static int stringDistance(String w1, String w2) {
        int len1 = w1.length();
        int len2 = w2.length();

        // If same length, count character differences
        if (len1 == len2) {
            int diff = 0;
            for (int i = 0; i < len1; i++) {
                if (w1.charAt(i) != w2.charAt(i))
                    diff++;
            }
            return diff;
        }

        // If different lengths, return length difference + char differences
        int minLen = Math.min(len1, len2);
        int diff = Math.abs(len1 - len2);
        for (int i = 0; i < minLen; i++) {
            if (w1.charAt(i) != w2.charAt(i))
                diff++;
        }
        return diff;
    }

    // Find closest matching word from dictionary
    public static String findClosestWord(String word, String[] dictionary) {
        int minDistance = Integer.MAX_VALUE;
        String suggestion = word; // default: same word
        for (String dictWord : dictionary) {
            int distance = stringDistance(word.toLowerCase(), dictWord.toLowerCase());
            if (distance < minDistance) {
                minDistance = distance;
                suggestion = dictWord;
            }
        }
        return (minDistance <= 2) ? suggestion : word;
    }

    // Display results in tabular format
    public static void displayResults(String[] words, String[] dictionary) {
        System.out.printf("%-15s %-15s %-10s %-12s\n", "Word", "Suggestion", "Distance", "Status");
        System.out.println("-------------------------------------------------------------");

        for (String word : words) {
            String suggestion = findClosestWord(word, dictionary);
            int distance = stringDistance(word.toLowerCase(), suggestion.toLowerCase());
            String status = (distance == 0) ? "Correct" : "Misspelled";

            System.out.printf("%-15s %-15s %-10d %-12s\n", word, suggestion, distance, status);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Dictionary of correct words
        String[] dictionary = { "hello", "world", "java", "program", "spell", "checker", "simple" };

        // User input
        System.out.println("Enter a sentence: ");
        String sentence = sc.nextLine();

        // Process sentence
        String[] words = splitSentence(sentence);

        // Display report
        displayResults(words, dictionary);

        sc.close();
    }
}
