package com.company;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void findIP(Matcher matcher, FileWriter writer) throws IOException {
        if(matcher.find()) {
            System.out.println(matcher.group());
            writer.write(matcher.group()+"\n");
            writer.flush();
        }
        else {
            System.out.println("Не найдено");
        }
    }

    public static void main(String[] args) throws IOException {
        File ip = new File("","ip.txt");
        if (!ip.exists()){
            boolean ipIsCreated = ip.createNewFile();
        }

        FileWriter writer = new FileWriter("ip.txt", true);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("\\b([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\b");
        Matcher matcher = pattern.matcher(input);

        findIP(matcher, writer);
    }
}
