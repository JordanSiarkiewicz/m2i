package org.example;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.SEPTEMBER, 06);
        calendar.add(Calendar.DATE, 1);
        System.out.println(calendar.getTime());
    }
}