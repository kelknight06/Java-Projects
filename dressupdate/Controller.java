package com.example.dressupdate;
//Authors: Kel Knight, Kendall Ward-Hill
//Class: CS265-02
//Date: 12/7/25
//Purpose: the controller handles all the corresponding methods to the javafx applciation. it places the clothes on the characters, and manipulates the stack
//and queues accordingly. the file is also written to here based on a button press, and it removes clothes too. an anonymous class is implemented here which uses the ready
//sam functional interface to tell the user both of the characters are ready
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static com.example.dressupdate.ReadAndSum.sumListRecursive;
//declare and/or intialize all fields and variables
public class Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;
    //this is needed to connect the fxml features to controller
    @FXML
    private ImageView sunshine;
    @FXML
    private ImageView shirt1;
    @FXML
    private ImageView shirt2;
    @FXML
    private ImageView pants1;
    @FXML
    private ImageView pants2;
    @FXML
    private ImageView shoes1;
    @FXML
    private ImageView shoes2;
    @FXML
    private ImageView bShirt1;
    @FXML
    private ImageView bShirt2;
    @FXML
    private ImageView bPants1;
    @FXML
    private ImageView bPants2;
    @FXML
    private ImageView bShoes1;
    @FXML
    private ImageView bShoes2;
    //give names to the articles of clothing, and set up score list for both characters
    @FXML
    Sunshine sun = new Sunshine();
    Bryan bry = new Bryan();
    String firstShirt = "button up";
    String secondShirt = "tank top";
    String firstPant = "shorts";
    String secondPant = "jeans";
    String firstShoes = "black boots";
    String secondShoes = "tan boots";
    String bfirstShirt = "turtleneck";
    String bsecondShirt = "short sleeve jacket";
    String bfirstPant = "monochrome";
    String bsecondPant = "tan camo";
    String bfirstShoes = "black boots";
    String bsecondShoes = "orange boots";
    List<Integer> sScore = new ArrayList<>();
    String totalsScore;
    String totalbScore;
    List<Double> bScore = new ArrayList<>();
    //set up write to write to file
    @FXML
    private WriteToFile writeToFile;
    //constructor to give a value(filepath) to the write class
    public Controller() {
        // Initialize WriteToFile with the path to your file
        writeToFile = new WriteToFile("src/main/resources/DressUpText/DateResults.txt");
    }
    // a method to initialize all of the images and hide them until changed on button presses
    @FXML
    public void intialize() {
        Image image = new Image(getClass().getResourceAsStream("shirt1.png"));
        shirt1.setImage(image);
        shirt1.setVisible(false);
        Image image2 = new Image(getClass().getResourceAsStream("shirt2.png"));
        shirt2.setImage(image2);
        shirt2.setVisible(false);
        Image image3 = new Image(getClass().getResourceAsStream("pants1.png"));
        pants1.setImage(image3);
        pants1.setVisible(false);
        Image image4 = new Image(getClass().getResourceAsStream("pants2.png"));
        pants2.setImage(image4);
        pants2.setVisible(false);
        Image image5 = new Image(getClass().getResourceAsStream("shoes1.png"));
        shoes1.setImage(image5);
        shoes1.setVisible(false);
        Image image6 = new Image(getClass().getResourceAsStream("shoes2.png"));
        shoes2.setImage(image6);
        shoes2.setVisible(false);
        Image image7 = new Image(getClass().getResourceAsStream("bShirt1.png"));
        shirt1.setImage(image7);
        shirt1.setVisible(false);
        Image image8 = new Image(getClass().getResourceAsStream("bShirt2.png"));
        shirt2.setImage(image8);
        shirt2.setVisible(false);
        Image image9 = new Image(getClass().getResourceAsStream("bPants1.png"));
        pants1.setImage(image9);
        pants1.setVisible(false);
        Image image10 = new Image(getClass().getResourceAsStream("bPants2.png"));
        pants2.setImage(image10);
        pants2.setVisible(false);
        Image image11 = new Image(getClass().getResourceAsStream("bShoes1.png"));
        shoes1.setImage(image11);
        shoes1.setVisible(false);
        Image image12 = new Image(getClass().getResourceAsStream("bShoes2.png"));
        shoes2.setImage(image12);
        shoes2.setVisible(false);
    }
    //this button removes clothes one at a time based on queue for sunshine/ the first scene
    //if clothing is removed or replaced the score is also altered accordingly
    //score is integer for sunshine to demonstrate the generic/flexibility aspect
    @FXML
    private void removeClick(ActionEvent event) {
        String removedItem = sun.removeQueue();
        if (removedItem != null) {
            System.out.println("removed :  " + removedItem);
            if (shirt1.isVisible()) {
                if (removedItem.equals(firstShirt)) {
                    shirt1.setVisible(false);
                    sun.setShirt(" ");
                    if (sScore.contains(10)){
                        sScore.remove(Integer.valueOf(10));
                    }
                    System.out.println(sun.toString());
                }
            }
            if(pants1.isVisible()) {
                if (removedItem.equals(firstPant)) {
                    pants1.setVisible(false);
                    sun.setPants(" ");
                    if (sScore.contains(10)){
                        sScore.remove(Integer.valueOf(10));
                    }
                   System.out.println(sun.toString());
                }
            }
            if(shoes1.isVisible()) {
                if (removedItem.equals(firstShoes)) {
                    shoes1.setVisible(false);
                    sun.setShoes(" ");
                    if (sScore.contains(10)){
                        sScore.remove(Integer.valueOf(10));
                    }
                    System.out.println(sun.toString());
                }
            }

            if (shirt2.isVisible()) {
                if (removedItem.equals(secondShirt)) {
                    shirt2.setVisible(false);
                    sun.setShirt(" ");
                    if (sScore.contains(5)){
                        sScore.remove(Integer.valueOf(5));
                    }
                    System.out.println(sun.toString());
                }
            }
            if(pants2.isVisible()) {
                if (removedItem.equals(secondPant)) {
                    pants2.setVisible(false);
                    sun.setPants(" ");
                    if (sScore.contains(5)){
                        sScore.remove(Integer.valueOf(5));
                    }
                    System.out.println(sun.toString());
                }
            }
            if(shoes2.isVisible()) {
                if (removedItem.equals(secondShoes)) {
                    shoes2.setVisible(false);
                    sun.setShoes(" ");
                    if (sScore.contains(5)){
                        sScore.remove(Integer.valueOf(5));
                    }
                    System.out.println(sun.toString());
                }
            }
        } else {
            System.out.println("queue is empty.");
        }

    }
    //this button removes clothes one at a time based on stack for bryan/ the second scene
    //if clothing is removed or replaced the score is also altered accordingly
    //score is also double for bryan to demonstrate the generic/flexibility aspect
    @FXML
    private void bRemoveClick(ActionEvent event) {
        String removeBryan = bry.popStack();
        if (removeBryan != null) {
            System.out.println("removed :  " + removeBryan);
            if (bShirt1.isVisible()) {
                if (removeBryan.equals(bfirstShirt)) {
                    bShirt1.setVisible(false);
                    bry.setShirt(" ");
                    if (bScore.contains(9.8)){
                        bScore.remove(Double.valueOf(9.8));
                    }
                    System.out.println(bry.toString());
                }
            }
            if(bPants1.isVisible()) {
                if (removeBryan.equals(bfirstPant)) {
                    bPants1.setVisible(false);
                    bry.setPants(" ");
                    if (bScore.contains(9.8)){
                        bScore.remove(Double.valueOf(9.8));
                    }
                    System.out.println(bry.toString());
                }
            }
            if(bShoes1.isVisible()) {
                if (removeBryan.equals(bfirstShoes)) {
                    bShoes1.setVisible(false);
                    bry.setShoes(" ");
                    if (bScore.contains(9.8)){
                        bScore.remove(Double.valueOf(9.8));
                    }
                    System.out.println(bry.toString());
                }
            }

            if (bShirt2.isVisible()) {
                if (removeBryan.equals(bsecondShirt)) {
                    bShirt2.setVisible(false);
                    bry.setShirt(" ");
                    if (bScore.contains(4.4)){
                        bScore.remove(Double.valueOf(4.4));
                    }
                    System.out.println(bry.toString());
                }
            }
            if(bPants2.isVisible()) {
                if (removeBryan.equals(bsecondPant)) {
                    bPants2.setVisible(false);
                    bry.setPants(" ");
                    if (bScore.contains(4.4)){
                        bScore.remove(Double.valueOf(4.4));
                    }
                    System.out.println(bry.toString());
                }
            }
            if(bShoes2.isVisible()) {
                if (removeBryan.equals(bsecondShoes)) {
                    bShoes2.setVisible(false);
                    bry.setShoes(" ");
                    if (bScore.contains(4.4)){
                        bScore.remove(Double.valueOf(4.4));
                    }
                    System.out.println(bry.toString());
                }
            }
        } else {
            System.out.println("stack is empty.");
        }
    }
    //all of the methods to add clothes to sunshine, if a shirt is already on and clicked it is replaced with what
    //was clicked and then the score changed to reflect such
    @FXML
    private void shirt1click(ActionEvent event) {
        sScore.add(10);
        shirt1.setVisible(true);
        shirt2.setVisible(false);

        if(sun.getSunQueue().contains(secondShirt)){
            sun.removeQueue();
            if (sScore.contains(5)){
                sScore.remove(Integer.valueOf(5));
            }
            sun.setShirt(firstShirt);
            sun.addQueue(firstShirt);
            System.out.println(sun.toString());
        }
        else{
            sun.setShirt(firstShirt);
            sun.addQueue(firstShirt);
            System.out.println(sun.toString());
        }


    }
    @FXML
    private void shirt2click(ActionEvent event) {
        sScore.add(5);
        shirt2.setVisible(true);
        shirt1.setVisible(false);

        if(sun.getSunQueue().contains(firstShirt)){
            sun.removeQueue();
            if (sScore.contains(10)){
                sScore.remove(Integer.valueOf(10));
            }
            sun.setShirt(secondShirt);
            sun.addQueue(secondShirt);
            System.out.println(sun.toString());
        }
        else{
            sun.setShirt(secondShirt);
            sun.addQueue(secondShirt);
            System.out.println(sun.toString());
        }

    }
    @FXML
    private void pants1click(ActionEvent event) {
        sScore.add(10);
        pants1.setVisible(true);
        pants2.setVisible(false);

        if(sun.getSunQueue().contains(secondShoes)){
            sun.removeQueue();
            if (sScore.contains(5)){
                sScore.remove(Integer.valueOf(5));
            }
            sun.setPants(firstPant);
            sun.addQueue(firstPant);
            System.out.println(sun.toString());
        }
        else{
            sun.setPants(firstPant);
            sun.addQueue(firstPant);
            System.out.println(sun.toString());
        }

    }
    @FXML
    private void pants2click(ActionEvent event) {
        sScore.add(5);
        pants1.setVisible(false);
        pants2.setVisible(true);

        if(sun.getSunQueue().contains(firstPant)){
            sun.removeQueue();
            if (sScore.contains(10)){
                sScore.remove(Integer.valueOf(10));
            }
            sun.setPants(secondPant);
            sun.addQueue(secondPant);
            System.out.println(sun.toString());
        }
        else{
            sun.setPants(secondPant);
            sun.addQueue(secondPant);
            System.out.println(sun.toString());
        }

    }
    @FXML
    private void shoes1click(ActionEvent event) {
        sScore.add(10);
        shoes1.setVisible(true);
        shoes2.setVisible(false);

        if(sun.getSunQueue().contains(secondShoes)){
            sun.removeQueue();
            if (sScore.contains(5)){
                sScore.remove(Integer.valueOf(5));
            }
            sun.setShoes(firstShoes);
            sun.addQueue(firstShoes);
            System.out.println(sun.toString());
        }
        else{
            sun.setShoes(firstShoes);
            sun.addQueue(firstShoes);
            System.out.println(sun.toString());
        }

    }
    @FXML
    private void shoes2click(ActionEvent event) {
        sScore.add(5);
        shoes1.setVisible(false);
        shoes2.setVisible(true);

        if(sun.getSunQueue().contains(firstShoes)){
            sun.removeQueue();
            if (sScore.contains(10)){
                sScore.remove(Integer.valueOf(10));
            }
            sun.setShoes(secondShoes);
            sun.addQueue(secondShoes);
            System.out.println(sun.toString());
        }
        else{
            sun.setShoes(secondShoes);
            sun.addQueue(secondShoes);
            System.out.println(sun.toString());
        }


    }
    //all of the methods to add clothes to bryan, if a shirt is already on and clicked it is replaced with what
    //was clicked and then the score changed to reflect such
    @FXML
    private void bShirt1click(ActionEvent event) {
        bShirt1.setVisible(true);
        bShirt2.setVisible(false);
        bScore.add(9.8);
        if(bry.getbryStack().contains(bsecondShirt)){
            bry.popStack();
            if (bScore.contains(4.4)){
                bScore.remove(Double.valueOf(4.4));
            }
            bry.setShirt(bfirstShirt);
            bry.pushStack(bfirstShirt);
            System.out.println(bry.toString());
        }
        else{
            bry.setShirt(bfirstShirt);
            bry.pushStack(bfirstShirt);
            System.out.println(bry.toString());
        }

    }
    @FXML
    private void bShirt2click(ActionEvent event) {
        bShirt2.setVisible(true);
        bShirt1.setVisible(false);
        bScore.add(4.4);
        if(bry.getbryStack().contains(bfirstShirt)){
            bry.popStack();
            if (bScore.contains(9.8)){
                bScore.remove(Double.valueOf(9.8));
            }
            bry.setShirt(bsecondShirt);
            bry.pushStack(bsecondShirt);
            System.out.println(bry.toString());
        }
        else{
            bry.setShirt(bsecondShirt);
            bry.pushStack(bsecondShirt);
            System.out.println(bry.toString());
        }
    }
    @FXML
    private void bPants1click(ActionEvent event) {
        bPants1.setVisible(true);
        bPants2.setVisible(false);
        bScore.add(9.8);
        if(bry.getbryStack().contains(bsecondPant)){
            bry.popStack();
            if (bScore.contains(4.4)){
                bScore.remove(Double.valueOf(4.4));
            }
            bry.setPants(bfirstPant);
            bry.pushStack(bfirstPant);
            System.out.println(bry.toString());
        }
        else{
            bry.setPants(bfirstPant);
            bry.pushStack(bfirstPant);
            System.out.println(bry.toString());
        }
    }
    @FXML
    private void bPants2click(ActionEvent event) {
        bPants2.setVisible(true);
        bPants1.setVisible(false);
        bScore.add(4.4);
        if(bry.getbryStack().contains(bfirstPant)){
            bry.popStack();
            if (bScore.contains(9.8)){
                bScore.remove(Double.valueOf(9.8));
            }
            bry.setPants(bsecondPant);
            bry.pushStack(bsecondPant);
            System.out.println(bry.toString());
        }
        else{
            bry.setPants(bsecondPant);
            bry.pushStack(bsecondPant);
            System.out.println(bry.toString());
        }
    }
    @FXML
    private void bShoes1click(ActionEvent event) {
        bShoes1.setVisible(true);
        bShoes2.setVisible(false);
        bScore.add(9.8);
        if(bry.getbryStack().contains(bsecondShoes)){
            bry.popStack();
            if (bScore.contains(4.4)){
                bScore.remove(Double.valueOf(4.4));
            }
            bry.setShoes(bfirstShoes);
            bry.pushStack(bfirstShoes);
            System.out.println(bry.toString());
        }
        else{
            bry.setPants(bfirstShoes);
            bry.pushStack(bfirstShoes);
            System.out.println(bry.toString());
        }
    }
    @FXML
    private void bShoes2click(ActionEvent event) {
        bShoes1.setVisible(false);
        bShoes2.setVisible(true);
        bScore.add(4.4);
        if(bry.getbryStack().contains(bfirstShoes)){
            bry.popStack();
            if (bScore.contains(9.8)){
                bScore.remove(Double.valueOf(9.8));
            }
            bry.setPants(bsecondShoes);
            bry.pushStack(bsecondShoes);
            System.out.println(bry.toString());

        }
        else{
            bry.setPants(bsecondShoes);
            bry.pushStack(bsecondShoes);
            System.out.println(bry.toString());
        }
    }
    //this adds the info to sunshine's specific instance variables,
    //using the set methods
    @FXML
    private void infoclick(ActionEvent event) {
        sun.setOccupation("Scientist");
        sun.setName("Sunshine");
        sun.setSymbol("Sun");
    }
    //this adds the info to bryan's specific instance variables,
    //using the set methods
    @FXML
    private void binfoclick(ActionEvent event) {
        bry.setName("Bryan");
        bry.setSymbol("Snake");
        bry.setSpecies("Cyborg");
    }

    //this switches the scene back to the first one, sunshine, if clicked
    public void switchToSun(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("sunshineStage.fxml"));
        stage =  (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 800, 550);
        stage.setTitle("Dress Sunshine up!");
        stage.setScene(scene);
        stage.show();
    }
    //this switchs the scene to bryan, the second scene, if clicked
    // the score of sunshine is also called and written to a file with her info here
    public void switchToBryan(ActionEvent event) throws IOException {
        totalsScore = "Sum of Sunshine Score: " + sumListRecursive(sScore);
        handleWriteToFile();
        root = FXMLLoader.load(getClass().getResource("bryanStage.fxml"));
        stage =  (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 800, 550);
        stage.setTitle("Dress Bryan up!");
        stage.setScene(scene);
        stage.show();
    }
    //done calls the recursive method for bryans score and writes that plus his info to a file
    //it also tells the user that the two are ready with the anonymous class
    public void done(ActionEvent event) throws IOException {
        totalbScore = "\nSum of Bryan Score: " + sumListRecursive(bScore);
        bryanWriteToFile();
        //use anonymous class to inform user that they are ready
        Ready displayReady = new Ready(){
            @Override
            public void printReady(String message) {
                System.out.println("Thank you for playing this game. " + message);
            }
        };
        displayReady.printReady("They are ready for their date.");
    }
    //this method handles writing to a method and cacthes ioexceptions for sunshine
    @FXML
    private void handleWriteToFile() {
        String writeScore = totalsScore;
        String writeInfo = sun.toString();
        if (!writeScore.isEmpty()&& !writeInfo.isEmpty()) {
            try {
                writeToFile.writeToFile(writeScore);
                writeToFile.writeToFile(writeInfo);
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }
        }
    }
    //this method handles writing to a method and cacthes ioexceptions for bryan
    @FXML
    private void bryanWriteToFile() {
        String writeBscore = totalbScore;
        String writeBinfo = bry.toString();
        if (!writeBscore.isEmpty()&& !writeBinfo.isEmpty()) {
            try {
                writeToFile.writeToFile(writeBscore);
                writeToFile.writeToFile(writeBinfo);
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }
        }
    }

}

