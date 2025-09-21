import java.util.*;

public class Question4_FindThreeMostCommonStrings {

    public static void main(String[] args) {
        tests();
    }

    // Simple test harness
    public static void tests() {

        // Test case 1
        // nomral case scenario in a string
        System.out.println("Test1 -> " + findThreeMostCommonStrings("hi there care to discuss algorithm basis or how to solve algorithm or"));
        test("hi there care to discuss algorithm basis or how to solve algorithm or", Arrays.asList("algorithm", "or", "to"));

        // Test case 2
        // only one common word case scenario in a string
        System.out.println("Test2 -> " + findThreeMostCommonStrings("java java java java"));
        test("java java java java", Arrays.asList("java"));

        // Test case 3
        // only two common words case scenario
        System.out.println("Test3 -> " + findThreeMostCommonStrings("cat dog cat dog"));
        test("cat dog cat dog", Arrays.asList("cat", "dog"));

        // Test case 4
        // normal case scenario
        System.out.println("Test4 -> " + findThreeMostCommonStrings("apple banana orange banana orange apple banana"));
        test("apple banana orange banana orange apple banana", Arrays.asList("apple", "banana", "orange"));

        // Test case 5
        //empty string case scenario
        System.out.println("Test5 -> " + findThreeMostCommonStrings(""));
        test("", Collections.emptyList());

        // Test case 6
        // multiple common words case scenario
        System.out.println("Test6 -> " + findThreeMostCommonStrings("zebra apple mango zebra apple mango"));
        test("zebra apple mango zebra apple mango", Arrays.asList("apple", "mango", "zebra"));
    }


    // test function
    public static void test(String input, List<String> expected) {
        List<String> result = findThreeMostCommonStrings(input);
        if (Objects.equals(result, expected)) {
            System.out.println("Passed for input: " + input+ "\n") ;
        } else {
            System.out.println("Failed for input: " + input +
                    " | Expected: " + expected + " but got: " + result);
        }
    }


    // Create a method that takes a string as argument
    // Convert the string into an array of words
    // loop through the array adding each word ti a hashmap that track its nuumber of appearance
    // define another array using the hashmpa values and sort the arrat
    // lastly loop through list array and return only the first 3 threee words
    public static List<String> findThreeMostCommonStrings(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return Collections.emptyList();
        }

        String[] words = sentence.split(" ");
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(frequencyMap.entrySet());
        list.sort((a, b) -> {
            int freqCompare = b.getValue().compareTo(a.getValue());
            if (freqCompare == 0) {
                return a.getKey().compareTo(b.getKey());
            }
            return freqCompare;
        });

        List<String> top3 = new ArrayList<>();
        for (int i = 0; i < Math.min(3, list.size()); i++) {
            top3.add(list.get(i).getKey());
        }

        Collections.sort(top3);
        return top3;
    }

}