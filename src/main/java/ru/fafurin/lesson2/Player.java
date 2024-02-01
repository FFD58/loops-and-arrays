package ru.fafurin.lesson2;

import java.io.*;
import java.util.Scanner;

public class Player {
    private String name;
    private String hint;

    private String rightAnswer;

    public Player(String name) {
        this.name = name;
        setHintAndRightAnswer();
        writeTwoStringToFile();
    }

    public String getName() {
        return name;
    }

    public String getHint() {
        return hint;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    private void setHintAndRightAnswer() {
        try {
            InputStream fileInputStream = new FileInputStream(this.name);
            Scanner cs = new Scanner(fileInputStream);
            this.rightAnswer = cs.nextLine();
            this.hint = cs.nextLine();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void writeTwoStringToFile() {
        Scanner sc = new Scanner(System.in);
        try {
            FileWriter writer = new FileWriter(this.name);
            System.out.printf("%s, enter a hidden word: ", this.name);
            writer.write(sc.nextLine());
            writer.write("\r\n");
            System.out.printf("%s, enter a hint: ", this.name);
            writer.write(sc.nextLine());
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
