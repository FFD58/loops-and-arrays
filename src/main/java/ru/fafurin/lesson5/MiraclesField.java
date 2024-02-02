package ru.fafurin.lesson5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MiraclesField {

    private static final String FILENAME = "miraclesFieldWords.txt";

    private static final int VOWEL_POINT = 1;
    private static final int CONSONANT_POINT = 2;
    private static final int WRONG_POINT = -3;

    private String[] rightAnswer;
    private String[] gameBoard;

    private final Player player1;
    private final Player player2;

    private Player currentPlayer;

    private final Scanner scanner = new Scanner(System.in);

    boolean isGameOver = false;

    public MiraclesField(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void setRightAnswer(String word) {
        String[] rightAnswer = new String[word.length()];
        for (int x = 0; x < word.length(); x++) {
            rightAnswer[x] = String.valueOf(word.charAt(x));
            gameBoard[x] = "#";
        }
        this.rightAnswer = rightAnswer;
    }

    public String[] getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(String word) {
        String[] gameBoard = new String[word.length()];
        for (int x = 0; x < word.length(); x++) {
            gameBoard[x] = "#";
        }
        this.gameBoard = gameBoard;
    }

    public void makeMove() {
        this.printStatistic();
        System.out.println(this.currentPlayer.getName() + ", your turn, enter a letter.");
        try {
            String letter = String.valueOf(this.scanner.nextLine().charAt(0));
            int matches = returnMatchesCount(letter);
            if (matches > 0) {
                if (isVowelLetter(letter)) currentPlayer.setPointCounts(VOWEL_POINT * matches);
                else currentPlayer.setPointCounts(CONSONANT_POINT * matches);
                System.out.printf("%s, toy guess the letter!\n", currentPlayer.getName());
            } else {
                System.out.printf("%s, didn't guess the letter \n", currentPlayer.getName());
                currentPlayer.setPointCounts(WRONG_POINT);
            }
            System.out.printf("%s has a %d points \n", currentPlayer.getName(), currentPlayer.getPointCounts());
            printResult(gameBoard);

        } catch (StringIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public void startGame() {
        String word = getWordForGame();
        this.setGameBoard(word);
        this.setRightAnswer(word);
        System.out.println("The game is started");
        printResult(getGameBoard());
        System.out.printf("There are %s letters in the hidden word\n", getGameBoard().length);
        this.currentPlayer = player1;

        while (!isGameOver) {
            makeMove();
            if (isGameOver()) {
                System.out.printf("%s guessed the word!", currentPlayer.getName());
                isGameOver = true;
//                System.exit(0);
            } else if (this.currentPlayer == player1) {
                this.currentPlayer = player2;
            } else {
                this.currentPlayer = player1;
            }
        }
        System.out.println("Game is over!");
    }

    private static boolean isVowelLetter(String c) {
        String vowelLetters = "аеоиуыэюя";
        return vowelLetters.contains(c);
    }

    private void printResult(String[] result) {
        for (String s : result) {
            System.out.print(s);
        }
        System.out.println();
    }

    private String getWordForGame() {
        String result = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
            int randomNumber = (int) (Math.random() * 1000);
            String[] words = new String[1000];
            for (int x = 0; x < words.length; x++) {
                words[x] = reader.readLine();
            }
            result = words[randomNumber];
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    private int returnMatchesCount(String letter) {
        int result = 0;
        for (int x = 0; x < rightAnswer.length; x++) {
            if (rightAnswer[x].equals(letter)) {
                gameBoard[x] = letter;
                result++;
            }
        }
        return result;
    }

    public boolean isGameOver() {
        boolean result = true;
        for (int x = 0; x < this.gameBoard.length; x++) {
            if (this.gameBoard[x].equals("#")) {
                result = false;
                break;
            }
        }
        return result;
    }

    private void printStatistic() {
        System.out.printf("%s, you have %d points. %s, you have %d points\n",
                this.player1.getName(), this.player1.getPointCounts(),
                this.player2.getName(), this.player2.getPointCounts());
        System.out.println();
    }
}
