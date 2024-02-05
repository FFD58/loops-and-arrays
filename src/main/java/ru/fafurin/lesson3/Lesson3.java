package ru.fafurin.lesson3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// Урок 3. Цикл for
public class Lesson3 {
    public static void main(String[] args) throws IOException {
        // 1. Выведите числа от двух в десятой степени до десяти в четвертой степени
        for (int x = (int) Math.pow(2, 10); x <= Math.pow(10, 4); x++) {
            System.out.println(x);
        }

        // 2. Сохраните миллион файлов. Получилось?
        // Ответ: получилось!
        for (int x = 1; x <= 1000_000; x++) {
            File file = new File("files/file" + x + ".txt");
            if (file.createNewFile()) {
                System.out.println(file.getName() + " created");
            } else {
                System.out.println("File already exists");
            }
        }

        // 3. Выведите буквы от а до я (подсказка: for (char letter=’а’; letter<=’я’; letter++) )
        for (char letter = 'а'; letter <= 'я'; letter++) {
            System.out.print(letter + " ");
        }

        // 4. выведите десять букв в алфавите после буквы й
        int charCode = 'й';
        for (int x = charCode; x < charCode + 10; x++) {
            System.out.print((char) x + " ");
        }
        System.out.println();

        // 5. выведите десять букв в алфавите, идущие до буквы ю
        for (int x = charCode + 9; x >= charCode; x--) {
            System.out.print((char) x + " ");
        }
        System.out.println();

        // 6. выведите каждую вторую букву алфавита (а, в, д)
        for (char letter = 'а'; letter <= 'я'; letter = (char) (letter + 2)) {
            System.out.print(letter + " ");
        }

        // 7. выведите каждую третью букву латинского алфавита
        for (char letter = 'a'; letter <= 'z'; letter = (char) (letter + 3)) {
            System.out.print(letter + " ");
        }

        // 8. выведите греческий алфавит (коды с 945 по 969) через запятую (α, β, …)
        for (int letterCode = 945; letterCode <= 969; letterCode++) {
            if (letterCode == 969) System.out.print((char) letterCode);
            else System.out.print((char) letterCode + ", ");
        }

        // 9. Выведите в файл list.html список :
        // <ul>
        // <li> 1 element </li>
        // <li> 2 element </li>
        // …
        // <li> 100 element </li>
        // </ul>
        String str = "<ul>" + "\n";
        for (int x = 1; x <= 100; x++) {
            str = str + "<li>" + x + " element</li>" + "\n";
        }
        str = str + "</ul>";
        FileWriter writer = new FileWriter("list.html");
        writer.write(str);
        writer.close();


        // 10. Выведите курс валют за 1 число каждого месяца в 2014 году
        CurrencyLoader currencyLoader = new CurrencyLoader();
        String month = "";
        for (int x = 1; x <= 12; x++) {
            if (x < 10) month = "0" + x;
            else month = String.valueOf(x);
            currencyLoader.getDollarQuotes("1.txt", "01", month, "2014");
        }
        // 11. Выведите курс валют за 1 февраля каждого года с 1994 до текущего года

        // К сожалению, в api ЦБ информация о долларе появляется только в 1997 году (в 1998 году тоже нет)
        for (int x = 1997; x <= 2023; x++) {
            currencyLoader.getDollarQuotes("1.txt", "01", "02", String.valueOf(x));
        }
    }
}
