package ru.fafurin.lesson6;

import java.util.Scanner;

// Урок 6. Ключевое слово final

public class Lesson6 {
    public static void main(String[] args) {

        // 1. Создайте final массив чисел. Увеличьте каждый его элемент вдвое.
        final int[] intArr = new int[]{3, 4, 5, 6, 7, 8};

        for (int x = 0; x < intArr.length; x++) {
            intArr[x] *= 2;
        }

        // 2. Найдите наибольшее число из трех, используя только final-переменные.
        final int x = 3434300;
        final int y = 10004324;
        final int z = 100003;

        final int max = (x > y) ? x : (y > z ? y : z);

        System.out.println(max);

        // 3. Измените final переменную. Получилось?
//        final int j = 123;
//        j = 2;
//        final String str = "Immutable string";
//        str = "Or not!?";
        // переменные с модификатором final невозможно изменить

        // 4. Пользователь вводит слово, подсчитайте количество уникальных букв в этом слове.
        // (Повторяющиеся считаем за одну, в слове окно - три уникальные буквы, окн).
        // Используйте только final-переменные. Подсказка: используйте массив.
        final Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word: ");
        final String str = sc.next();

        final String[] arr = new String[1];
        arr[0] = str;

        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (arr[0].charAt(i) == arr[0].charAt(j)) {
                    arr[0] = arr[0].replace(arr[0].charAt(i), ' ');
                    arr[0] = arr[0].replace(arr[0].charAt(j), ' ');
                }
            }
        }
        final int result = arr[0].replace(" ", "").length();
        System.out.print("In your word \"" + str + "\" " + result + " unique ");
        System.out.print(result > 1 ? "letters" : "letter");
    }
}
