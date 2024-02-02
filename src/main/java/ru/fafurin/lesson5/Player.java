package ru.fafurin.lesson5;

import java.util.Scanner;

public class Player {
    private int pointCounts = 0;

    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPointCounts() {
        return pointCounts;
    }

    public void setPointCounts(int pointCounts) {
        this.pointCounts += pointCounts;
    }



}

