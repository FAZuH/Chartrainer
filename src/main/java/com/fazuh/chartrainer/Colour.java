package com.fazuh.chartrainer;

import java.util.Scanner;

public enum Colour {
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    RESET("\u001B[0m"),
    BOLD("\u001B[1m");


    private final String code;

    Colour(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }

    public static String askInput(String message) {
        Scanner scan = new Scanner(System.in);
        System.out.println(Colour.BLUE + message + Colour.RESET);
        System.out.print("> ");
        return scan.nextLine();
    }

    public static String askQuestion(String question) {
        Scanner scan = new Scanner(System.in);
        System.out.print(Colour.BLUE + question + " : " + Colour.RESET);
        return scan.nextLine();
    }

    public static void printFail(String message) {
        System.out.println(Colour.RED + message + Colour.RESET);
    }

    public static void printError(String message) {
        System.out.println(Colour.BOLD + "" + Colour.RED + message + Colour.RESET);
    }
    
    public static void printInfo(String message) {
        System.out.println(Colour.YELLOW + message + Colour.RESET);
    }
    
    public static void printSuccess(String message) {
        System.out.println(Colour.GREEN + message + Colour.RESET);
    }
}
