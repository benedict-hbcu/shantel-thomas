package org.example;

import java.util.Scanner;

import static org.example.Util.Result.*;

public class Main {
    public static void main(String[] args) {
        //Generate random word from list
        String randWord = Util.getRandomWord();
        int counter = 1;
        boolean winner = false;

        //Print generate message
        System.out.println("**********************************");
        System.out.println("******* WELCOME TO SHAN WORDLE ******");
        System.out.println("**********************************");
        System.out.println();

        String userWord = null;
        while (counter != 7) {

            //take user input
            Scanner input = new Scanner(System.in);
            System.out.println();
            System.out.println("Type your 5 letter word (attempt " + counter + " of 6):");
            userWord = input.nextLine().toLowerCase();


            //check if input is valid
            if (userWord.length() == 5) {
                //check each index letter against each other
                CompareIndexes(randWord, userWord);
                counter += 1;
            } else {
                System.out.println("Word needs to be 5 letters");
            }
        }
        System.out.println();
        System.out.println( "The word was " + randWord);
    }

    private static void CompareIndexes(String randWord, String userWord) {
        //ArrayList<String> result = new ArrayList<>();
        for(int i = 0; i <= randWord.length()-1; i++){
            String TemptChar = String.valueOf(userWord.charAt(i));
            if(userWord.charAt(i) == randWord.charAt(i)){
                System.out.print(Util.getFormattedLetter(userWord.charAt(i), HIT));
            }
            else if(randWord.contains(TemptChar) == true) {  //optimise to account for letters that were already
                System.out.print(Util.getFormattedLetter(userWord.charAt(i), SEMI_HIT));
            }
            else if(randWord.contains(TemptChar) == false) {
                System.out.print(Util.getFormattedLetter(userWord.charAt(i), MISS));
            }
        }
    }

    private static int checkUserInput(String userWord, int counter) {
        if(userWord.length()== 5){
            return  counter+=1;
        }
        else {
            System.out.println("Word needs to be 5 letters");
        }
        return counter;
    }
}

//Generate random word from list  - lover
//input 5 letterword from user -hoads
//check each index letter against each other
//fif the leter in have same index return Hit,
// If not same but in work return Semi_hit,
// if not in word return Miss
