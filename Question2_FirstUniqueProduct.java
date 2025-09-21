import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Objects;

public class Question2_FirstUniqueProduct {
    public static void main(String[] args) {

        // Test 1: Normal case with a unique product
        // Computer is the expected output
        System.out.println("Test1 -> " + firstUniqueProduct(new String[]{"Apple", "Computer", "Apple", "Bag"}));
        test(new String[]{"Apple", "Computer", "Apple", "Bag"}, "Computer");

        // Test 2: Multiple unique values, should return the first one
        // Laptop is the expected output
        System.out.println("Test2 -> " + firstUniqueProduct(new String[]{"Laptop", "Book", "Pencil", "Book", "Pen"}));
        test(new String[]{"Laptop", "Book", "Pencil", "Book", "Pen"}, "Laptop");

        // Test 3: No unique values
        // Return null as output
        System.out.println("Test3 -> " + firstUniqueProduct(new String[]{"Chair", "Chair", "Table", "Table"}));
        test(new String[]{"Chair", "Chair", "Table", "Table"}, null);

        // Test 4: Single element
        // Return Laptop as output since it the only product
        System.out.println("Test4 -> " + firstUniqueProduct(new String[]{"Laptop"}));
        test(new String[]{"Laptop"}, "Laptop");

        // Test 5: Empty array
        // Return null as output since no list is porivided
        System.out.println("Test5 -> " + firstUniqueProduct(new String[]{}));
        test(new String[]{}, null);

        // Test 6: Null input
        // Return null as output
        System.out.println("Test6 -> " + firstUniqueProduct(null));
        test(null, null);

        // Test 7: Case sensitivity (different casing counts separately)
        // Check for the product with unique case
        System.out.println("Test7 -> " + firstUniqueProduct(new String[]{"apple", "Apple", "apple"}));
        test(new String[]{"apple", "Apple", "apple"}, "Apple");
    }


    // test function
    public static void test(String[] input, String expected) {
        String result = firstUniqueProduct(input);
        if (Objects.equals(result, expected)) {
            System.out.println("Passed for input: " + Arrays.toString(input)) ;
        } else {
            System.out.println("Failed for input: " + Arrays.toString(input) +
                    " | Expected: " + expected + " but got: " + result);
        }
    }


    // Create a method that takes an array of string as argument.
    // First check for empty arrays and return null.
    // Create a HashMap that will be used to count appearance of each product using key:value pairs.
    // Update the value of each product in hashmap using built in .getOrDefault method. Instead of adding it again when it appear in array list.
    // Finnaly loop through the products array and match each product to the trackedProducts in hashmap.
    // Return the product with lowest count.
    public static String firstUniqueProduct(String[] products) {
        if (products == null || products.length == 0) {
            return null;
        }

        Map<String, Integer> trackedProducts = new HashMap<>();
        for (String product : products) {
            trackedProducts.put(product, trackedProducts.getOrDefault(product, 0) + 1);
        }

        for (String product : products) {
            if (trackedProducts.get(product) == 1) {
                return product;
            }
        }

        return null;
    }
}