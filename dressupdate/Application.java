package com.example.dressupdate;
//Authors: Kel Knight, Kendall Ward-Hill
//Class: CS265-02
//Date: 12/7/25
//Purpose: this is the application class that sets up the stage and scene. the file is also read here and displayed to console, where lambda is also
//implemented which is possible because of Function which is a functional interface
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;

public class
Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("sunshineStage.fxml"));
            Scene scene = new Scene(root,800,550);
            stage.setTitle("Dress Sunshine up!");
            stage.setScene(scene);
            stage.show();
            //lambda is used to define how a single line is read from the filepath and how it should be processed
            // it returns the line as-is so the code reads lines from the file and stores them as raw strings without any modification.
                    ReadAndSum<String> stringReader = new ReadAndSum<>("src/main/resources/DressUpText/Story.txt", line -> line);
            try {
                List<String> lines = stringReader.readAllLines();
                for (String line : lines) {
                    System.out.println(line);
                }
            }catch (IOException e) {
                e.printStackTrace();
            }//}
        }catch(Exception e){
            e.printStackTrace();
        }
        //the try and catch iterates through each line via a for each loop and prints it to console, it handles ioexceptions and other general ones for the entire stage
    }
}
