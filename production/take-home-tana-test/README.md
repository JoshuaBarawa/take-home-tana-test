# Take Home Tana Test

## Instructions on how to run the code

### Requirements
Java Version: 20.0.2

### How to run the code
There are different ways to run my code locally on your computer:

#### 1. Running On terminal
1. Open your terminal and navigate to where you cloned my folder from github.
2. CD into the folder e.g cd take-home-tana-test.
3. Compile the file you want to run using the command "javac filename.java" eg "javac Question1_GetLongestString.java"
4. Finnaly run "java Question1_GetLongestString"  (don’t include .java when running);

NB: Dont include the quotes when running the commands 


#### 2. Running On IDE
If you don’t want to run from the terminal, you can use the following IDEs:
1. IntelliJ
2. Eclipse
3. VS Code (with Java extensions)

IDEs will handle compilation and running automatically.Output will be shown in a console inside the IDE.


### How My Solutions Work

#### 1.Question1_GetLongestString
Create a function that takes two arguments (String characters, ArrayList<String> words). Define a variable to track the current longest word. Loop through the array of words and use the built in .startsWith() method to check which word in the array starts with the passed string and is longer than current longest word value in variable. Return longest variable after looping is done.

#### 2.Question2_FirstUniqueProduct
Create a method that takes an array of string as argument. Use HashMap to count appearance of each product using key:value pairs. Update the value of each product in hashmap using built in .getOrDefault method. Finnaly loop through the products array and match each product to the trackedProducts in hashmap and return the product with lowest count.

#### 3.Question3_FindClosestMinDistance
First loop: Determine the minimum value in the array. Loop the array again and check the positions of elements equal to the minimum value. Keep track of the last index where the minimum was found.For each new occurrence, calculate the distance to the last occurrence.  Update the answer if this distance is smaller than the current answer.Return the smallest distance found between the minimum value.

#### 4.Question4_FindThreeMostCommonStrings
Create a method that takes a string as argument. Convert the string into an array of words. loop through the array adding each word ti a hashmap that track its nuumber of appearance. define another array using the hashmpa values and sort the arrat. lastly loop through list array and return only the first 3 threee words


#### 5.Question5_RotateListNodeBy2