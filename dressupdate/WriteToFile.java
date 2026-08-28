package com.example.dressupdate;
//Authors: Kel Knight, Kendall Ward-Hill
//Class: CS265-02
//Date: 12/7/25
//Purpose: This is a class to handle writing to a file. it takes in a file path and then writes to that file
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

    private String filePath;

    public WriteToFile(String filePath) {
        this.filePath = filePath;
    }

    public void writeToFile(String data) throws IOException {
        //append mode is enabled so it does not overwrite between stages
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(data);
            writer.newLine();
        }
    }
}