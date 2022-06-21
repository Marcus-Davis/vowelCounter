package com.example.vowelcounter;

import java.util.Arrays;
import java.util.Scanner;  // Import the Scanner class

// this application counts the number of vowels in a word/sentence the user inputs
public class VowelCounter {
    String[] vowels = {"a", "e", "i", "o", "u"};
    String conditionalVowel = "y";
    int numVowels = 0;

    public VowelCounter(){

    }
    public VowelCounter(String[] vowels, String conditionalVowel){
        this.vowels = vowels;
        this.conditionalVowel = conditionalVowel;
    }

    public void setVowels(String[] vowels) {
        this.vowels = vowels;
    }

    public void setConditionalVowel(String conditionalVowel) {
        this.conditionalVowel = conditionalVowel;
    }

    public void setNumVowels(int numVowels) {
        this.numVowels = numVowels;
    }

    public String[] getVowels() {
        return vowels;
    }

    public String getConditionalVowel() {
        return conditionalVowel;
    }

    // takes a string (user input) - counts the number of vowels
    // returns an int
    public int getNumVowels(String userInput) {
        // if vowel is at x index - add to count
        for (int i = 0; i < userInput.length(); i++){
            if(userInput.charAt(i) == 'a' || userInput.charAt(i) == 'e' || userInput.charAt(i) == 'i'
                                            || userInput.charAt(i) == 'o' || userInput.charAt(i) == 'u'){
                numVowels++;
            }
        }
        return numVowels;
    }

    public static void main(String[] args) {
        VowelCounter readWord = new VowelCounter();
        int vowelCount = 0;

        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Vowel Counter \nEnter your word here: ");

        String userInput = scanner.nextLine();  // Read user input
        vowelCount = readWord.getNumVowels(userInput);

        // Output
        System.out.println(userInput + " has " + vowelCount + " vowels");
    }
}
