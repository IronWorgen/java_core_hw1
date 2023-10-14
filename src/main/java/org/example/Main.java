package org.example;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean flag = true;
        while (flag) {
            SaveNoteService saveNoteService = new SaveNoteService();
            System.out.println("Выберите номер:\n--------------------------------------------------------");
            System.out.println("1. добавить заметку");
            System.out.println("2. завершить работу");
            System.out.print("--------------------------------------------------------\n:\t");
            Scanner scanner = new Scanner(System.in);
            try {
                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        saveNoteService.saveNote(createNote());
                        break;
                    case 2:
                        flag = false;
                        break;
                    default:
                        showError("Выберите вариант из списка!");
                }
            } catch (Exception e) {
                showError("Введите число!");
            }
        }


    }

    /**
     * пользовательский интерфейс создания заметки
     *
     * @return - заметку
     */
    private static Note createNote() {
        System.out.println("\nСоздание заметки\n------------------------------------");
        System.out.print("Введите текст заметки:\t");
        Scanner scanner = new Scanner(System.in);
        String noteText = scanner.nextLine();
        System.out.println("\nСоздание заметки\n------------------------------------");
        return new Note(noteText);

    }

    /**
     * отобразить пользователю сообщение об ошибке
     *
     * @param message - текст сообщения
     */
    private static void showError(String message) {
        message = "Ошибка!!! " + message;
        for (int i = 0; i < message.length(); i++) {
            System.out.print("=");
        }
        System.out.println("\n" + message);
        for (int i = 0; i < message.length(); i++) {
            System.out.print("=");
        }
        System.out.println("\n");
    }

}