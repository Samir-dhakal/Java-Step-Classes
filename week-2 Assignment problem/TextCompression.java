// Problem 3: Write a program to implement a text-based data compression
// algorithm using character frequency and StringBuilder
// Hint =>
// a. Take user input for text to compress
// b. Create a method to count character frequency without using HashMap:
// ● i. Create arrays to store characters and their frequencies
// ● ii. Use charAt() to iterate through text
// ● iii. Count occurrences of each unique character
// ● iv. Return parallel arrays of characters and frequencies
// c. Create a method to create compression codes using StringBuilder:
// ● i. Assign shorter codes to more frequent characters
// ● ii. Use numbers/symbols for common characters
// ● iii. Create a mapping table of original character to code
// ● iv. Return the mapping as a 2D array
// d. Create a method to compress text using the generated codes:
// ● i. Replace each character with its corresponding code
// ● ii. Use StringBuilder for efficient string building
// ● iii. Calculate compression ratio (original size vs compressed size)
// e. Create a method to decompress the text:
// ● i. Reverse the compression process using the mapping table
// ● ii. Validate that decompression returns original text
// f. Create a method to display compression analysis:
// ● i. Show character frequency table
// ● ii. Display compression mapping
// 3

// ● iii. Show original text, compressed text, decompressed text
// ● iv. Calculate and display compression efficiency percentage
// g. The main function performs compression, decompression, and displays complete analysis
import java.util.Scanner;

public class TextCompression {

    // Method to count character frequencies
    public static Object[] countFrequencies(String text) {
        char[] chars = new char[text.length()];
        int[] freq = new int[text.length()];
        int size = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            boolean found = false;

            for (int j = 0; j < size; j++) {
                if (chars[j] == c) {
                    freq[j]++;
                    found = true;
                    break;
                }
            }

            if (!found) {
                chars[size] = c;
                freq[size] = 1;
                size++;
            }
        }

        // Trim arrays to actual size
        char[] uniqueChars = new char[size];
        int[] uniqueFreq = new int[size];
        for (int i = 0; i < size; i++) {
            uniqueChars[i] = chars[i];
            uniqueFreq[i] = freq[i];
        }

        return new Object[] { uniqueChars, uniqueFreq };
    }

    // Generate compression codes
    public static String[][] generateCodes(char[] chars, int[] freq) {
        int n = chars.length;
        String[][] mapping = new String[n][2];

        for (int i = 0; i < n; i++) {
            mapping[i][0] = String.valueOf(chars[i]);
            // Assign shorter codes to more frequent characters
            mapping[i][1] = (i < 10) ? String.valueOf(i) : "@" + i;
        }

        return mapping;
    }

    // Compress text
    public static String compress(String text, String[][] mapping) {
        StringBuilder compressed = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            for (String[] map : mapping) {
                if (map[0].charAt(0) == c) {
                    compressed.append(map[1]);
                    break;
                }
            }
        }
        return compressed.toString();
    }

    // Decompress text
    public static String decompress(String compressed, String[][] mapping) {
        StringBuilder decompressed = new StringBuilder();
        int i = 0;
        while (i < compressed.length()) {
            boolean matched = false;
            for (String[] map : mapping) {
                String code = map[1];
                if (compressed.startsWith(code, i)) {
                    decompressed.append(map[0]);
                    i += code.length();
                    matched = true;
                    break;
                }
            }
            if (!matched)
                i++; // skip invalid code
        }
        return decompressed.toString();
    }

    // Display analysis
    public static void displayAnalysis(String text, String compressed, String decompressed,
            char[] chars, int[] freq, String[][] mapping) {
        System.out.println("Character Frequency Table:");
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i] + " -> " + freq[i]);
        }

        System.out.println("\nCompression Mapping:");
        for (String[] map : mapping) {
            System.out.println("'" + map[0] + "' -> " + map[1]);
        }

        System.out.println("\nOriginal Text: " + text);
        System.out.println("Compressed Text: " + compressed);
        System.out.println("Decompressed Text: " + decompressed);

        double ratio = (double) compressed.length() / text.length();
        System.out.printf("Compression Efficiency: %.2f%%\n", (1 - ratio) * 100);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text to compress:");
        String text = sc.nextLine();

        Object[] freqData = countFrequencies(text);
        char[] chars = (char[]) freqData[0];
        int[] freq = (int[]) freqData[1];

        String[][] mapping = generateCodes(chars, freq);
        String compressed = compress(text, mapping);
        String decompressed = decompress(compressed, mapping);

        displayAnalysis(text, compressed, decompressed, chars, freq, mapping);
        sc.close();
    }
}
