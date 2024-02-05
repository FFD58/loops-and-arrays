package ru.fafurin.lesson2;

import java.util.Scanner;

public class GuessingGame {

    private Player player1;
    private Player player2;

    public GuessingGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void printHints() {
        System.out.println("Welcome to the Guessing Game!");
        String player1hint = player1.getHint();
        String player2hint = player2.getHint();
        System.out.printf("%s hint is: ", player1.getName());
        System.out.println(player1hint);
        System.out.printf("%s hint is: ", player2.getName());
        System.out.println(player2hint);
    }
    public void startGame(Player player1, Player player2) {
        if (checkAnswer(player1, player2.getRightAnswer())) {
            System.out.printf("%s guessed it!\n", player1.getName());
            System.out.printf("%s is a winner!\n", player1.getName());
        } else {
            System.err.println("Wrong answer!");
            startGame(player2, player1);
        }
    }

    public boolean checkAnswer(Player player, String rightAnswer) {
        boolean result;
        System.out.printf("%s, what is your answer?\n", player.getName());
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        result = answer.equals(rightAnswer);
        return result;
    }

}
