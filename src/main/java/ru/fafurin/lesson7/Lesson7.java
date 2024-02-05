package ru.fafurin.lesson7;

import java.util.Arrays;
import java.util.Scanner;

// Урок 7. Посимвольная обработка строк

public class Lesson7 {
    public static void main(String[] args) {

        // 1. Пользователь вводит пять строк. Выведите слово, состоящие из первой буквы каждый строки
        Scanner sc = new Scanner(System.in);
        String result = "";
        for (int x = 0; x < 5; x++) {
            String str = sc.nextLine();
            char letter = str.charAt(0);
            result += letter;
        }
        System.out.println(result);

        // 2. Посчитайте количество нулей в числе
        System.out.println("Enter a number");
        int number = sc.nextInt();
        String numberStr = String.valueOf(number);
        int counter = 0;
        for (int x = 0; x < numberStr.length(); x++) {
            if (numberStr.charAt(x) == '0') counter++;
        }
        System.out.println("In your number " + counter + " zero");

        for (int x = 0; x < 5; x++) {
            String str = sc.nextLine();
            char letter = str.charAt(0);
            System.out.print(letter);
            System.out.println(returnWordFromRandomLetters(5));
            System.out.println();
        }

        // 3. Найдите первую гласную букву в слове
        String str = "барабашка";
        int index = 0;
        char letter = ' ';
        for (int x = str.length() - 1; x >= 0; x--) {
            if (isVowelLetter(String.valueOf(str.charAt(x)))) {
                letter = str.charAt(x);
                index = x;
            }
        }
        System.out.println("First vowel letter is " + letter + " on index " + index);

        // 4. Посчитайте количество согласных букв в слове
        int count = 0;
        for (int x = 0; x < str.length(); x++) {
            if (!isVowelLetter(String.valueOf(str.charAt(x)))) {
                count++;
            }
        }
        System.out.println("the number of consonant letters in a word: " + count);

        // 5. Выведите слово наоборот, при этом столбиком
        for (int x = str.length() - 1; x >= 0; x--) {
            System.out.println(str.charAt(x));
        }

        // 6. Замените все гласные в слове на ‘у’
        for (int x = 0; x < str.length(); x++) {
            if (isVowelLetter(String.valueOf(str.charAt(x)))) {
                str = str.replace(str.charAt(x), 'у');
            }
        }
        System.out.println(str);

        // 7. Пользователь вводит дробное число, выведите его дробную часть
        System.out.println("Enter a double number");
        double doubleNumber = sc.nextDouble();
        String strArr = String.valueOf(doubleNumber);
        int pointIndex = 0;

        System.out.println(strArr.length());
        for (int x = 0; x < strArr.length(); x++) {
            if (strArr.charAt(x) == '.') pointIndex = x;
        }

        char[] intPart = new char[pointIndex];
        char[] floatPart = new char[strArr.length() - pointIndex - 1];

        for (int i = 0; i < pointIndex; i++) {
            intPart[i] = strArr.charAt(i);
        }
        for (int x = pointIndex + 1; x < strArr.length(); x++) {
            floatPart[x - pointIndex - 1] = strArr.charAt(x);
        }
        System.out.println("The integer part of the number is equal to:");
        System.out.println(intPart);
        System.out.println("The fractional part of the number is equal to:");
        System.out.println(floatPart);


        // 8. Пользователь вводит предложение. Замените в каждом слове этого предложения, последн** д** бук** на **

        System.out.println("Enter a suggestion");
        String line = sc.nextLine();
        counter = 0;
        for (int x = 0; x < line.length(); x++) {
            if (line.charAt(x) == ' ') counter++;
        }

        String[] words = new String[counter + 1];

        for (int x = 0; x < words.length; x++) {
            if (!line.contains(" ")) {
                words[x] = line;
            } else {
                words[x] = line.substring(0, line.indexOf(" "));
                line = line.replace(line.substring(0, line.indexOf(" ") + 1), "");
            }
        }

        for (int x = 0; x < words.length; x++) {
            String word = words[x];
            words[x] = word.replace(word.substring(word.length() - 2), "**");
        }

        System.out.println(Arrays.toString(words));
    }

    // Метод для решения 2-ой задачи
    private static String returnWordFromRandomLetters(int length) {
        String res = "";
        for (int x = 0; x < length; x++) {
            int random = (int) (Math.random() * 32 + 1072);
            res += (char) random;
        }
        return res;
    }

    // Метод для решения 3, 4 и 6-ой задач
    private static boolean isVowelLetter(String c) {
        String vowelLetters = "аеоиуыэюя";
        return vowelLetters.contains(c);
    }
}
