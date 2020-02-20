package com.deniszacharov;
/*
Задан текстовый файл. Вывести сколько в нём: a) строк b) слов c) символов
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class scanFile {

    public static void main(String[] args) {

        try {
            counter("/home/DN250194ZDE/IdeaProjects/hilleltask/HW7.1/test.txt");
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
        }
        try {
            countChars();
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    public static void counter(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        int words = 0;
        int lines = 0;

        while (scanner.hasNextLine()) {

            lines++;
            String[] array = scanner.nextLine().split(" ");
            words = words + array.length;

        }
        System.out.println("Number of words: " + words);
        System.out.println("Number of lines: " + lines);
        scanner.close();
    }

    public static void countChars() throws IOException {
        FileInputStream in = new FileInputStream("/home/DN250194ZDE/IdeaProjects"
                + "/hilleltask/HW7.1/test.txt");
        byte[] array = new byte[in.available()];
        in.read(array);
        String text = new String(array);
        int count = 0;
        for (char ch : text.toCharArray()) {
            if (!Character.isWhitespace(ch)) {
                count++;
            }
        }
        System.out.println("Number of chars: " + count);
    }

}

