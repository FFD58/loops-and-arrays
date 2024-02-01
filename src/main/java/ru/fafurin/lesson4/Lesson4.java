package ru.fafurin.lesson4;

import java.io.IOException;
import java.util.Scanner;

// Урок 4. Цикл do..while, конструкция switch..case
public class Lesson4 {
    public static void main(String[] args) throws IOException {

        // 1. С помощью цикла do..while, выведите римские цифры
        printRomeDigits();

        // 2. С помощью цикла do..while, выведите числа от -0.9 до 0.9
        printDoubleNumbers(-0.9, 0.9);

        // 3. Пользователь вводит строку, выведите каждый второй символ (подсказка: str.charAt(i) )
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        for (int x = 0; x < str.length(); x++) {
            if (x % 2 != 0) System.out.print(str.charAt(x));
        }

        // 4. Пользователь вводит строку. Выводите все слова на разных строках
        str = sc.nextLine();
        printWordsOnNextLine(str);

        // 5. Пользователь вводит строку. Выведите первые 3 слова
        str = sc.nextLine();
        printFirst3Words(str);

        // 6. Пользователь вводит строку, выведите ее задом-наперёд.
        str = sc.nextLine();
        printStringBackwards(str);

        // 7. Пользователь вводит букву. Выведите любое слово, начинающуюся на эту букву
        System.out.println(returnRandomWord(8, 'ф'));

        // 8. Пользователь вводит цифру: выведите страну, телефонный код которого начинается на эту цифру
        PhoneCodeService phoneCodeService = new PhoneCodeService();
        System.out.println("Enter a phone code...");
        int phoneCode = sc.nextInt();
        phoneCodeService.printCountryByPhoneCode(phoneCode);

        // 9. Пользователь вводит цифру. Если она от 0 до 6 - пусть вводит еще.
        // Если 9 - конец. Если 7,8 - пусть вводит строки до тех пор, пока не введет «стоп» (на этом все).
        System.out.println("Введите целое число");
        int x = sc.nextInt();
        boolean isContinue = true;
        do {
            if (x > 0 && x < 6) {
                System.out.println("Снова введите целое число");
                x = sc.nextInt();
                if (x == 9) isContinue = false;
            } else if (x == 7 || x == 8) {
                while (isContinue) {
                    System.out.println("Введите строку или слово \"стоп\" для выхода");
                    str = sc.nextLine();
                    if (str.equals("стоп")) isContinue = false;
                }
            } else {
                System.out.println("Попробуйте снова");
                isContinue = false;
            }
        }
        while (isContinue);
    }

    // 1. С помощью цикла do..while, выведите римские цифры
    private static void printRomeDigits() {
        int charCode = 8544;
        do System.out.print((char) charCode++);
        while (charCode < 8556);
        System.out.println();
    }

    // 2. С помощью цикла do..while, выведите числа от -0.9 до 0.9
    private static void printDoubleNumbers(double start, double end) {
        do {
            String result = String.format("%.1f", start);
            System.out.println(result);
            start += 0.1;
        }
        while (start <= end);
    }

    // 4. Пользователь вводит строку. Выводите все слова на разных строках
    private static void printWordsOnNextLine(String str) {
        int x = 0;
        do {
            System.out.print(str.charAt(x) == ' ' ? "\n" : str.charAt(x));
            x++;
        } while (x < str.length());
    }

    // 5. Пользователь вводит строку. Выведите первые 3 слова
    private static void printFirst3Words(String str) {
        int x = 0;
        int whitespaces = 0;
        do {
            if (str.charAt(x) == ' ') {
                whitespaces++;
            }
            System.out.print(str.charAt(x));
            x++;
        } while (whitespaces < 3 && x < str.length());
    }

    // 6. Пользователь вводит строку, выведите ее задом-наперёд.
    private static void printStringBackwards(String str) {
        int x = str.length() - 1;
        do {
            System.out.print(str.charAt(x));
            x--;
        } while (x >= 0);
    }

    // 7. Пользователь вводит букву. Выведите любое слово, начинающуюся на эту букву
    private static String returnRandomWord(int letterNumber, char firstLetter) {
        boolean isContinue = true;
        String word = "";
        while (isContinue) {
            word = returnRandomWord(letterNumber);
            if (word.charAt(0) == firstLetter) isContinue = false;
        }
        return word;
    }

    private static String returnRandomWord(int letterNumber) {
        StringBuilder builder = new StringBuilder();
        while (letterNumber > 0) {
            builder.append(returnRandomRussianConsonantLetter());
            letterNumber--;
            builder.append(returnRandomRussianVowelLetter());
            letterNumber--;
        }
        return builder.toString();
    }

    // вывод в консоль случайной согласной русской буквы
    private static char returnRandomRussianConsonantLetter() {
        String consonantRussianLetters = "бвгджзйклмнпрстфхцчшщъь";
        int random = (int) (Math.random() * 23 + 1);
        return consonantRussianLetters.charAt(random - 1);
    }

    // вывод в консоль случайной русской гласной буквы
    private static char returnRandomRussianVowelLetter() {
        String vowelRussianLetters = "аеоиуыэюя";
        int random = (int) (Math.random() * 9 + 1);
        return vowelRussianLetters.charAt(random - 1);
    }

}
