package org.example;

import java.util.Scanner;

import static org.example.Util.Result.*;

public class Main {
    public static void main(String[] args) {
        //Generate random word from list
        String generatedWord = Util.getRandomWord();
        int counter = 1;

        //print message
        printGenericMessage();

        String userWord = null;
        while (counter != 7) {
            //take user input
            Scanner input = new Scanner(System.in);
            System.out.println();
            System.out.println("Type your 5 letter word (attempt " + counter + " of 6):");
            userWord = input.nextLine().toLowerCase();


            //check if input is valid
            if (checkUserInput(userWord)){
                //compare the indexes and check if char in generated word
                CompareCharByIndex(generatedWord, userWord);
                counter += 1;
            }

        }
        System.out.println();
        System.out.println( "The word was " + generatedWord);
    }

    private static void printGenericMessage() {
        System.out.println("**********************************");
        System.out.println("******* WELCOME TO SHANTEL'S WORDLE ******");
        System.out.println("**********************************");
        System.out.println();
    }

    private static void CompareCharByIndex(String randWord, String userWord) {
        for(int i = 0; i <= randWord.length()-1; i++){
            String TemptChar = String.valueOf(userWord.charAt(i));
            if(userWord.charAt(i) == randWord.charAt(i)){       //check if index for both words are the same
                System.out.print(Util.getFormattedLetter(userWord.charAt(i), HIT));
            }
            else if(randWord.contains(TemptChar) == true) {  //NOTE: optimise to account for letters that were already USED
                System.out.print(Util.getFormattedLetter(userWord.charAt(i), SEMI_HIT));
            }
            else if(randWord.contains(TemptChar) == false) {
                System.out.print(Util.getFormattedLetter(userWord.charAt(i), MISS));
            }
        }
    }

    private static boolean checkUserInput(String userWord) {
        if(userWord.length()== 5){
            return true;
        }
        else {
            System.out.println("Word needs to be 5 letters");
        }
        return false;
    }
}

//Generate random word from list  - lover
//input 5 letterword from user -hoads
//check each index letter against each other
//fif the leter in have same index return Hit,
// If not same but in word return Semi_hit,
// if not in word return Miss
