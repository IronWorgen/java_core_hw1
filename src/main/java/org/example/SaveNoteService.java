package org.example;

import javax.swing.text.DateFormatter;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class SaveNoteService {
    String fileName = "Notes.txt";
    long noteCounter;

    public SaveNoteService() {

        noteCounter = getCurrentQuantity();
    }

    public  boolean saveNote(Note note)  {
        note.setId(++noteCounter);
        try {
            FileWriter fileWriter = new FileWriter(new File(fileName), true);
            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            String noteDateOfCreate = dateFormatter.format(note.getDateOfCreate());

            fileWriter.write(String.format("%d.\t%s -> %s\n", note.getId(), noteDateOfCreate, note.getText()));
            fileWriter.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    private int getCurrentQuantity() {
        File file = new File(fileName);
        if (file.length()==0){
            return  0;
        }
        int counter=0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while(bufferedReader.readLine()!=null){
                counter++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return counter;
    }
}
