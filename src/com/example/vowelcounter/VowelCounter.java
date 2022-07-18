package com.example.vowelcounter;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;


// this application counts the number of vowels in a word/sentence the user inputs
public class VowelCounter {
    String[] vowels = {"a", "e", "i", "o", "u"};
    String[] consonants = {"b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "z"};
    String conditionalVowel = "y";
    int numVowels = 0;
    int numCharacters = 0;
    int numWords = 0;

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


    // takes a string (user input) - counts the number of characters
    // returns an int
    public int getNumCharacters(String userInput) {
        // if user input is empty, request again, give option to cancel
        if (userInput.isBlank()) {
            JOptionPane.showMessageDialog(null, "You didn't enter anything", "error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showInputDialog(null, "Enter text here: ", "character counter", JOptionPane.OK_CANCEL_OPTION);
            //if (JOptionPane.CANCEL_OPTION) System.exit(0);
        }
        for (int i = 0; i < userInput.length(); i++){
            numCharacters++;
             if (userInput.charAt(i) == ' ') {
                 numCharacters--;
             }
        }
        return numCharacters;
    }

    // takes a string (user input) - counts the number of words
    // returns an int
    public int getNumWords(String userInput) {
        // use split() method to separate words and store them in an array
        String[] arry = userInput.split(" ");
        numWords = arry.length;

        return numWords;
    }


    public static void main(String[] args) {
        int count = 0;
        String userInput;
        VowelCounter readWord = new VowelCounter();

        // options for drop down menu on first page
        String[] options = {"Count vowels", "Count characters", "Count words"};

        // welcome screen image
        JLabel labelN = new JLabel();
        JLabel labelS = new JLabel();
        JLabel labelSh = new JLabel();
        JLabel labelIU = new JLabel();
        labelN.setIcon(new ImageIcon(new ImageIcon("naruto-uzumaki.png").getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT)));
        labelS.setIcon(new ImageIcon(new ImageIcon("sasuke.jpeg").getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT)));
        labelSh.setIcon(new ImageIcon(new ImageIcon("shikamaru.jpeg").getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT)));
        labelIU.setIcon(new ImageIcon(new ImageIcon("itachi-Uchiha.jpeg").getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT)));

        // first page - gets what action the user wants to do
        String userSelection = (String)JOptionPane.showInputDialog(null, "What would you like to do? ", "hi", JOptionPane.QUESTION_MESSAGE, labelN.getIcon(), options, options[0]);

        if (userSelection.equals("Count vowels")){
            userInput = JOptionPane.showInputDialog(null, "Enter text here: ", "Vowel Counter", JOptionPane.PLAIN_MESSAGE);
            count = readWord.getNumVowels(userInput);
            JOptionPane.showMessageDialog(null, "Vowel count: " + count, "Vowel Counter", JOptionPane.PLAIN_MESSAGE, labelS.getIcon());
        } else if (userSelection.equals("Count characters")) {
            userInput = JOptionPane.showInputDialog(null, "Enter text here: ", "Character Counter", JOptionPane.PLAIN_MESSAGE);
            count = readWord.getNumCharacters(userInput);
            JOptionPane.showMessageDialog(null, "Character count: " + count, "Character Counter", JOptionPane.PLAIN_MESSAGE, labelSh.getIcon());
        } else if (userSelection.equals("Count words")) {
            userInput = JOptionPane.showInputDialog(null, "Enter text here: ", "Word Counter", JOptionPane.PLAIN_MESSAGE);
            count = readWord.getNumWords(userInput);
            JOptionPane.showMessageDialog(null, "Word count: " + count, "Word counter", JOptionPane.PLAIN_MESSAGE, labelIU.getIcon());
        }

    }
}

// exception catching
// might spell check
// add y , read file?
// clean up code