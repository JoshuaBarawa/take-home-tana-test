import java.util.*;

public class Question1_GetLongestString {
    public static void main(String[] args) {

        // 1.Test case for normal scenario. One longest word
        // Should return "ABCDABDCA" as output
        ArrayList<String> words1 = new ArrayList<>(Arrays.asList("AABCDA", "ABCDZADC", "ABCDBCA", "ABCDABDCA"));
        System.out.println("Test1 → " + getLongestString("ABCD", words1));
        test("ABCD", words1, "ABCDABDCA");

        // 2.Test case where no longest word is available. No condition is met.
        // Should return null as output
        ArrayList<String> words2 = new ArrayList<>(Arrays.asList("XYZ", "HELLO", "WORLD"));
        System.out.println("Test2 → " + getLongestString("ABCD", words2));
        test("ABCD", words2, null);

        // 3.Test case where we have two longest words.
        // Should return "ABCDONE" as output. It's the first longest word
        ArrayList<String> words3 = new ArrayList<>(Arrays.asList("ABCDONE", "ABCDTWO", "ABC"));
        System.out.println("Test3 → " + getLongestString("ABCD", words3));
        test("ABCD", words3, "ABCDONE");

        // 4.Test case where we have empty list.
        // Should return null as output.
        ArrayList<String> words4 = new ArrayList<>();
        System.out.println("Test4 → " + getLongestString("ABCD", words4));
        test("ABCD", words4, null);

        // 5.Test case where we have empty string.
        // Should return the first word from array. Every word qualifies.
        ArrayList<String> words5 = new ArrayList<>(Arrays.asList("HELLO", "WORLD", "KENYA"));
        System.out.println("Test5 → " + getLongestString("", words5));
        test("", words5, "HELLO");

        // 6.Test case where we have lowercase characters.
        // Should return "ABCDxyz" as output. Since "abcd" is not equal to "ABCD".
        ArrayList<String> words6 = new ArrayList<>(Arrays.asList("abcdxyz", "ABCDxyz"));
        System.out.println("Test6 → " + getLongestString("ABCD", words6));
        test("ABCD", words6, "ABCDxyz");
    }


    // test function
    public static void test(String characters, ArrayList<String> words, String expected) {
        String result = getLongestString(characters, words);
        if (Objects.equals(result, expected)) {
            System.out.println("Passed for input: " + words) ;
        } else {
            System.out.println("Failed for input: " + words +
                    " | Expected: " + expected + " but got: " + result);
        }
    }


    // Create a method that takes two arguments (String characters, ArrayList<String> words).
    // Define a variable that will be used to track the current longest word. Update the variable when conditions are met.
    // Loop through the array of words.
    // Use Java built in .startsWith() method to check which word starts with the passed string argument.
    // Also check if current word in array is longer than the current longest word variable.
    // If condition is met update the longestWord variable with the current word in the array.
    // Return the longest word after the loop is over.
    public static String getLongestString(String characters, ArrayList<String> words){
        String longestWord = "";
        for(String word: words){
            if(word.startsWith(characters) && word.length() > longestWord.length()){
                longestWord = word;
            }
        }
        return longestWord.isEmpty() ? null : longestWord;
    }
}