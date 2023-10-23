package io;

import java.io.*;
import java.util.Arrays;

import static io.utils.IOUtils.readFile;
import static io.utils.IOUtils.write;

public class Streams {


    public static void updateFile(String path, String textForUpdate, int num) throws IOException {
        try {
            FileWriter writer = new FileWriter("D:\\io_tests\\home\\second_file.txt", true);
            while (num > 0) {
                writer.write(" " + textForUpdate);
                num--;
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Возникла ошибка во время записи, проверьте данные.");
        }
    }

    public static void updateFileRandomNumbers(int num, String path) throws IOException {
        try {
            while (num > 0) {
                FileWriter writer = new FileWriter(path, true);
                String number = (Integer.toString((int) (Math.random() * 10)));
                String text = readFile(path);
                if (text.contains(number)) {
                    writer.append('\n' + number + "*");
                } else {
                    writer.append('\n' + number);
                }
                num--;
                writer.close();
            }
        } catch (IOException e) {
            System.out.println("Возникла ошибка во время записи, проверьте данные.");
        }
    }

    public static void sortFileNumbers(String pathRead, String pathWrite) throws IOException {
        try {
            FileWriter writer = new FileWriter(pathWrite, true);
            String text = readFile(pathRead);
            StringBuilder sortText = new StringBuilder();
            String[] numbersStr;
            numbersStr = text.split("\r");
            int[] numbers = new int[numbersStr.length];
            for (int i = 0; i < numbersStr.length; i++) {
                numbers[i] = (int) Integer.parseInt(numbersStr[i].trim());
            }
            Arrays.sort(numbers);
            int[] reversNumbers = new int[numbers.length];
            for (int i = numbers.length - 1, j = 0; i >= 0; i--, j++) {
                reversNumbers[j] = numbers[i];
            }
            for (int s :
                    reversNumbers) {
                System.out.println(s);
                sortText.append(s + "\r");
            }

            write(sortText.toString(), pathWrite);
        } catch (IOException e) {
            System.out.println("Возникла ошибка во время записи, проверьте данные.");
        }
    }

    public static void searchTextInFile(String search, String path) throws IOException {
        search = search.toLowerCase();
        String text = readFile(path).toLowerCase();
        //System.out.println(text);
        int counter = 0;
        while (text.contains(search)) {
            text = text.substring(text.indexOf(search), text.lastIndexOf(search));
            counter++;
        }
        System.out.println("The word: " + search + " repeat :" + counter + " times");
    }

    public static String removePunctuations(String source) {
        return source.replaceAll("\\p{Punct}", "");
    }


//    public static void searchTextInFile(String path, String search) {
//        int counter = 0;
//        String text = readFile(path);
//        if (text.toLowerCase().contains(search.toLowerCase())) {
//            System.out.println("Search text is found");
//            counter++;
//            //text.substring(text.indexOf(search),text.lastIndexOf(search));
//        } else {
//            System.out.println("Search text is not found");
//        }
//    }

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\io_tests\\home\\first_file.txt");

        try {
            boolean isCreated = file.createNewFile();
            System.out.println("New  first_file.txt in D:\\io_tests\\home\\ is Created - " + isCreated);
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStream is = new FileInputStream("D:\\io_tests\\home\\first_file.txt");
        int code = is.read();
        StringBuilder str = new StringBuilder();
        System.out.println("Task 2. Read file by byte stream: ");
        if (str.length() != 0) {
            while ((code = is.read()) != -1) {
                str.append((char) code);
            }
            System.out.println(str.toString().toUpperCase());
        } else
            System.out.println("File is empty");

        Reader reader = new FileReader("D:\\io_tests\\home\\first_file.txt");
        int characterCode;
        StringBuilder str1 = new StringBuilder();
        System.out.println("Task 2. Read file by character stream: ");
        while ((characterCode = reader.read()) != -1) {
            str1.append((char) characterCode);
        }
        System.out.println(str1.toString().toUpperCase());
        if (str1.length() == 0) {
            System.out.println("File is empty");
        }

        BufferedReader bufReader = new BufferedReader(new FileReader("D:\\io_tests\\home\\first_file.txt"));
        int characterCode2;
        StringBuilder text = new StringBuilder();
        System.out.println("Task 2. Read file by buffer stream stream: ");
        while ((characterCode2 = bufReader.read()) != -1) {
            text.append((char) characterCode2);
        }
        System.out.println(text.toString().toUpperCase());
        if (text.length() == 0) {
            System.out.println("File is empty");
        }

        System.out.println("Task 3");
        updateFile("D:\\io_tests\\home\\three_file.txt", "update", 3);

        System.out.println("Task 4");
        updateFileRandomNumbers(5, "D:\\io_tests\\home\\second_file.txt");

        System.out.println("Task 5");
        sortFileNumbers("D:\\io_tests\\home\\second_file2.txt", "D:\\io_tests\\home\\second_file2_sort.txt");

        System.out.println("Task 6-7");
        searchTextInFile("Ты", "D:\\io_tests\\home\\search.txt");
        searchTextInFile("ы", "D:\\io_tests\\home\\search.txt");

        System.out.println("Task 8");
        String text8 = readFile("D:\\io_tests\\home\\search.txt");
        text8 = text8.replaceAll("  ", " ").
                replaceAll("   ", " ").replaceAll("    ", " ");
        StringBuilder text8SB = new StringBuilder(removePunctuations(text8));
        text8SB.reverse();
        write(text8SB.toString(), "D:\\io_tests\\home\\search2.txt");
    }
}




