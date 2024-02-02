package ru.fafurin.lesson2;

import java.io.*;
import java.util.Scanner;

// Урок 2. Цикл While
public class Lesson2 {
    public static void main(String[] args) throws IOException {

        // 1. Выведите числа от 0 до миллиона
        printNumbers(0, 1_000_000, 1);

        // 2. Выведите числа от 1.5 до 101.5: 1.5,2,2.5,3,3.5…101.5
        printNumbers(1.5, 101.5, 0.5);

        // 3. Выведите латинский алфавит от a до z
        printLatin();

        // 4. Выведите русский алфавит от а до я
        printGreatRussianLanguageAlphabet();

        // 5. Создайте 10 тысяч файлов
        for (int x = 1; x <= 10_000; x++) {
            File file = new File(x + ".txt");
            file.createNewFile();
        }


//        6. В файле две строки: секретное слово и подсказка. Вывести подсказку.
//        Считывать строку за строкой, пока игрок не отгадает секретное слово(не введёт его)
//        7. Предыдущее задание, но если пользователь ввел хотя бы часть слова верно,
//        то писать: горячо. (Проверять с помощью str.contains).
          guessWordFromFile("1.txt");

        // 8. Первый игрок сохраняет слово и подсказку в первый файл, второй игрок во второй.
        // Игра начинается, выводятся подсказки, игроки по-очереди пытаются отгадать слово противника.
        Player player1 = new Player("Ivan");
        Player player2 = new Player("Oleg");
        GuessingGame guessingGame = new GuessingGame(player1, player2);

        System.out.println("________________________________");
        guessingGame.printHints();
        guessingGame.startGame(player1, player2);


        // 9. Пока пользователь не введёт строку, содержащую пробел, считывайте строки и выводите их первые буквы
        printFirstLetterWhileWhitespaceIsEntered();

        // 10. Пользователь вводит полный путь и название файла.
        // Пока пользователь не ввел путь к существующему файлу, повторять ввод.
        // Проверить, что файл существует, можно так: File f = new File(); boolean isExists = f.exists();
        checkFileExists("1.txt");
        checkFileExists("112321312.txt");

        // 11. Сохраните снимки NASA за январь 2022 года
        LoaderFromNasaApi.getFileFromString(LoaderFromNasaApi.webPageToString("2022-01-01", "2022-01-31"));

    }

    //  Метод для решения 1 и 2 задач.
    private static void printNumbers(double start, double end, double step) {
        for (double x = start; x <= end; x += step) {
            System.out.println(x);
        }
    }

    // Метод для решения 3 задачи.
    private static void printLatin() {
        int letter = 97;
        while (letter < 123) {
            System.out.print((char) letter++ + " ");
        }
        System.out.println();
    }

    // Метод для решения 4 задачи.
    private static void printGreatRussianLanguageAlphabet() {
        int letter = 1072;
        while (letter < 1104) {
            System.out.print((char) letter++ + " ");
            if ((char) letter == 'ж') System.out.print('ё' + " ");
        }
        System.out.println();
    }

    // Метод для решения 6 и 7 задач.
    private static void guessWordFromFile(String filename) throws FileNotFoundException {
        InputStream fileInputStream = new FileInputStream(filename);
        Scanner cs = new Scanner(fileInputStream);

        String rightAnswer = cs.nextLine();
        String hint = cs.nextLine();
        System.out.println("Welcome to the Guessing Game!");
        System.out.print("The Hint is: ");
        System.out.println(hint);
        Scanner sc = new Scanner(System.in);
        System.out.println("What is it?...");
        String answer = sc.nextLine();
        boolean exit = true;
        while (exit) {
            if (answer.equals(rightAnswer)) {
                System.out.println("You guessed it!");
                exit = false;
            } else {
                System.err.println("Wrong answer!");
                if (answer.substring(0, 1).equals(rightAnswer.substring(0, 1))) {
                    System.out.println("It's hot!");
                }
                answer = sc.nextLine();
            }
        }
    }

    // Метод для решения 9 задачи.
    private static void printFirstLetterWhileWhitespaceIsEntered() {
        boolean isExit = true;
        while (isExit) {
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            if (!str.contains(" ")) {
                System.out.println(str.charAt(0));
            } else isExit = false;
        }
    }

    // Метод для решения 10 задачи.
    private static void checkFileExists(String filename) {
        File file = new File(filename);
        System.out.println((file.exists()) ? ("File " + filename + " exists") : "File " + filename + " not found");
    }


}
