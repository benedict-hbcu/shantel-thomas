package org.example;

import java.util.Scanner;

import static org.example.Util.Result.*;

public class Main {
    public static void main(String[] args) {
        //Generate random word from list
        String generatedWord = Util.getRandomWord();

        //print message
        printGenericMessage();
        System.out.println(wordle(generatedWord));
    }

    private static String wordle(String generatedWord) {
        int counter = 1;
        while (counter != 7) {
            //take user input
            Scanner input = new Scanner(System.in);
            System.out.println();
            System.out.println("Type your 5 letter word (attempt " + counter + " of 6):");
            String userWord = input.nextLine().toLowerCase();

            //check if input is valid
            if (userWord.length() ==5){
                int forWin =0;
                //compare the indexes and check if char in generated word
                forWin += CompareCharByIndex(generatedWord, userWord, forWin);
                counter += 1;

                if(forWin ==5 ){
                    return winnerMessage();
                }
            } else {
                System.out.println("Word needs to be 5 letters");
            }
        }
        System.out.println(" ");
        return "The word was " + generatedWord;
    }

    private static String winnerMessage() {
        System.out.println();
        return "**************** CONGRATULATIONS YOU WON ****************";
    }

    private static void printGenericMessage() {
        System.out.println("******************************************");
        System.out.println("******* WELCOME TO SHANTEL'S WORDLE ******");
        System.out.println("******************************************");
        System.out.println();
    }

    private static int CompareCharByIndex(String randWord, String userWord, int forWin) {
        for(int i = 0; i <= randWord.length()-1; i++){
            String TemptChar = String.valueOf(userWord.charAt(i));
            if(userWord.charAt(i) == randWord.charAt(i)){       //check if index for both words are the same
                forWin += 1;
                System.out.print(Util.getFormattedLetter(userWord.charAt(i), HIT));
            }
            else if(randWord.contains(TemptChar) == true) {  //NOTE: optimise to account for letters that were already USED
                System.out.print(Util.getFormattedLetter(userWord.charAt(i), SEMI_HIT));
            }
            else if(randWord.contains(TemptChar) == false) {
                System.out.print(Util.getFormattedLetter(userWord.charAt(i), MISS));
            }
        }
        return forWin;
    }
}

