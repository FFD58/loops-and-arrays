package ru.fafurin.lesson5;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

// Урок 5. Введение в массивы
public class Lesson5 {
    public static void main(String[] args) throws IOException {


        // 1. Пользователь вводит 10 чисел, сохраните их в массив
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[10];
        for (int x = 0; x < arr.length; x++) {
            arr[x] = scanner.nextInt();
        }
        // 2. Сохраните 10 чисел в массив, выведите их с конца
        for (int x = arr.length - 1; x >= 0; x--) {
            System.out.println(arr[x]);
        }

        // 3. Сохраните 10 строк в массив, выведите с конца каждую вторую
        String[] strArr = new String[4];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = scanner.nextLine();
        }
        for (int j = 0; j < strArr.length; j++) {
            if (j % 2 != 0) {
                for (int i = strArr[j].length() - 1; i >= 0; i--) {
                    System.out.print(strArr[j].charAt(i));
                }
                System.out.println();
            }
        }

        // 4. В файле 10 дробных чисел. Считайте в массив, выведите те, что больше числа пи.
        Scanner str = new Scanner(new File("1.txt"));
        double[] numbers = new double[10];

        for (int x = 0; x < 10; x++) {
            numbers[x] = Double.parseDouble(str.nextLine());
        }

        for (int x = 0; x < numbers.length; x++) {
            if (numbers[x] > Math.PI) {
                System.out.println(numbers[x]);
            }
        }

        // 5. Пользователь вводит буквы. Пока не введёт букву ‘ю’, сохраняйте буквы в массив char(пусть в нем будет 100 элементов максимум). Потом создайте новый массив char размером столько, сколько букв ввел пользователь. Скопируйте в него буквы из первого массива
        printCharsArray();

        // 6. Есть 2 файла по 5 строк в каждом. Сохраните их в 2 массива.
        // Создайте третий массив из 10 строк, скопируйте в него строки из первых двух массивов.
        Scanner firstFileStr = new Scanner(new File("first.txt"));
        Scanner secondFileStr = new Scanner(new File("second.txt"));
        String[] firstStrArr = new String[5];
        String[] secondStrArr = new String[5];
        String[] mergedStrArr = new String[10];

        for (int x = 0; x < firstStrArr.length; x++) {
            firstStrArr[x] = firstFileStr.nextLine();
            secondStrArr[x] = secondFileStr.nextLine();
        }
        int i = 0;
        for (int x = 0; x < mergedStrArr.length; x++) {
            if (x < firstStrArr.length) mergedStrArr[i++] = firstStrArr[x];
            if (x < secondStrArr.length) mergedStrArr[i++] = secondStrArr[x];
        }

        // 7. Поле чудес. Игрок один пишет слово. Выводится: ##### (по количеству букв) Игрок два пытается угадать буквы. Если угадал, буква открывается: #а#а#, ба#а#, … банан
        miraclesField();

        // 8. Поле чудес с соревнованием. Генерируете 1000 случайных слов на сайте-генераторе (пример: https://sanstv.ru/randomWord,
        // но в поисковике есть много подобных). Сохраняете их в файл.
        // Из файла считываете случайное, и выводите ####… игроки по очереди отгадывают букву.
        // Гласная - 1 балл, согласная - 2 балла, если буква встречается несколько раз - больше.
        // Можно угадать слово целиком - за каждую угаданную букву тогда начислять баллы(гласные 1, согласные 2).
        // Если не угадал- минус 3 балла.
        MiraclesField miraclesField = new MiraclesField(new Player("Pavel"), new Player("Ivan"));
        miraclesField.startGame();
    }

    // Метод для решения 5-й задачи
    private static void printCharsArray() {
        Scanner sc = new Scanner(System.in);
        char[] chars = new char[100];
        int counter = 0;
        for (int x = 0; x < chars.length; x++) {
            char letter = sc.nextLine().charAt(0);
            if (!(letter == 'ю')) {
                chars[x] = letter;
                counter++;
            } else break;
        }
        char[] newChars = new char[counter];
        for (int i = 0; i < counter; i++) {
            newChars[i] = chars[i];
        }
        System.out.println(Arrays.toString(newChars));
    }

    // Поле чудес. Игрок один пишет слово. Выводится: ##### (по количеству букв)
    // Игрок два пытается угадать буквы. Если угадал, буква открывается: #а#а#, ба#а#, … банан
    private static void miraclesField() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("1.txt"));

            String word = reader.readLine();
            String[] rightAnswer = new String[word.length()];
            String[] gameBoard = new String[word.length()];

            for (int x = 0; x < word.length(); x++) {
                rightAnswer[x] = String.valueOf(word.charAt(x));
                gameBoard[x] = "#";
                System.out.print(gameBoard[x]);
            }
            System.out.println();
            Scanner sc = new Scanner(System.in);
            boolean isExit;
            System.out.println("Enter a letter");

            do {
                isExit = false;
                String letter = String.valueOf(sc.nextLine().charAt(0));
                for (int x = 0; x < rightAnswer.length; x++) {
                    if (rightAnswer[x].equals(letter)) {
                        gameBoard[x] = letter;
                    }
                }
                printResult(gameBoard);
                for (String s : gameBoard) {
                    if (s.equals("#")) {
                        isExit = true;
                        break;
                    }
                }
            } while (isExit);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printResult(String[] result) {
        for (String s : result) {
            System.out.print(s);
        }
        System.out.println();
    }


}
