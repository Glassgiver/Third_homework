package org.example;

import java.util.Random;
import java.util.Scanner;

public class App 
{
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                             "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                             "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    public static void main( String[] args ) {
        boolean isPlaying = true;
        while (isPlaying){
            System.out.println("Choose your game: \n" +
                    "1. guess number\n" +
                    "2. guess word\n" +
                    "3. exit");
            int ans = scanner.nextInt();
            switch (ans){
                case 1:
                    numberGame();
                    break;
                case 2:
                    wordGame();
                    break;
                case 3: isPlaying = false;
            }


        }


    }

    public static void numberGame(){
        boolean isContinue = true;
        boolean isWon = false;

        while(isContinue){
            int number = random.nextInt(10);

            for (int i = 0; i < 3; i++){
                System.out.println("\nInput your number:");
                int playerNumber = scanner.nextInt();

                if(number == playerNumber){
                    isWon = true;
                    System.out.println("Congratulations! You won!");
                    break;
                }
                else if (number < playerNumber){
                    System.out.println("The number is smaller.");
                }
                else{
                    System.out.println("The number is bigger.");
                }
            }

            if (!isWon){
                System.out.println("You lost!");
                System.out.println("The number was: " + number);
            }

            System.out.println("\nPlay again? 1 - yes, 2 - no");
            int ans = scanner.nextInt();

            if (ans == 2){
                break;
            }

            isWon = false;

        }
    }

    public static void wordGame(){
        int winCount = 0;
        boolean isWon = false;
        boolean isContinue = true;

        while(isContinue){
            int wordIndex = random.nextInt(words.length);
            while(!isWon){
                System.out.println("\nInput your word:");
                String str = scanner.next();

                if(words[wordIndex].equals(str)){
                    isWon = true;
                    System.out.println("Congratulations! You won!");
                    break;
                }
                else{
                    for(int i = 0; i < 15; i++){
                        if (i == str.length() || i == words[wordIndex].length()){
                            for (int j = 0; j < 15 - i; j++){
                                System.out.print("#");
                            }
                            break;
                        }

                        if (str.charAt(i) == words[wordIndex].charAt(i)){
                            System.out.print(str.charAt(i));
                        }
                        else{
                            System.out.print("#");
                        }

                    }
                }
            }

            if(isWon){
                winCount++;
            }

            System.out.println("\nPlay again? 1 - yes, 2 - no");
            int ans = scanner.nextInt();

            if (ans == 2){
                break;
            }

            isWon = false;

        }
    }
}
