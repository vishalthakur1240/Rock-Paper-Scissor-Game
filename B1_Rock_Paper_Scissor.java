package Revise_JAVA;

import java.util.Scanner;

public class B1_Rock_Paper_Scissor {
    public static void main(String[] args) {
        System.out.println("Enter '1' for 'Rock'\nEnter '2' for 'Paper'\nEnter '3' for 'Scissor'");

        int[] scores = startGame(1, 0, 0);
        int computerScore = scores[0];
        int userScore = scores[1];

        System.out.println("============ RESULT ============");
        System.out.println("Final Computer Score: " + computerScore + "\nFinal User Score: " + userScore);
        if (computerScore > userScore){
            System.out.println("Computer Won with points: " + computerScore);
        } else if (computerScore < userScore) {
            System.out.println("User Won with points: " + userScore);
        } else {
            System.out.println("Draw");
        }

    }

    private static int[] startGame(int round, int computerScore, int userScore) {
        if (round > 3) {
            int[] result = {computerScore, userScore};
            return result;
        }
        System.out.println("------------------------ ROUND-" + round + " ------------------------");
        // generate rand number (1,2,3 | R,P,S)
        int computerInput = randValue(1, 3);
        // take user's input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter you Input: ");
        int userInput = sc.nextInt();
        if(isValidUserInput(userInput)){
            if (userWins(computerInput, userInput)){
                System.out.println("Computer Input: " + computerInput);
                System.out.println("Congratulation User🥳");
                userScore++;
                if (computerScore > 1) computerScore--;
            } else if (computerInput == userInput){
                System.out.println("Computer Input: " + computerInput);
                System.out.println("Draw 🤝");
            } else {
                System.out.println("Computer Input: " + computerInput);
                System.out.println("Computer Wins!!! Better luck next time👍");
                computerScore++;
                if (userScore > 1) userScore--;
            }
        } else {
            System.out.println("Please enter a valid option.\nYou entered: " + userInput);
            round--;
        }
        round++;
        return startGame(round, computerScore, userScore);
    }

    private static boolean isValidUserInput(int userInput) {
        if (userInput >=1 && userInput <= 3) return true;
        return false;
    }


    private static boolean userWins(int computerInput, int userInput) {
        if (computerInput == 1 && userInput == 2) return true;
        if (computerInput == 2 && userInput == 3) return true;
        if (computerInput == 3 && userInput == 1) return true;
        return false;
    }

    private static int randValue(int minValue, int maxValue) {
        int randomValue = (int) (Math.random() * (maxValue - minValue + 1)) + minValue;
        return randomValue;
    }
}
