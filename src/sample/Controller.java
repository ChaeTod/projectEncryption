package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.awt.*;
import java.util.List;

public class Controller {
    public Button opnBtn;
    public TextField keyfield;
    public Button wrtBtn;

    //FileChooser fileChooser = new FileChooser();
    private Desktop desktop = Desktop.getDesktop();

    public void setFile(ActionEvent actionEvent) throws IOException {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select TXT file");
        fileChooser.setInitialDirectory(new File("D:\\Study\\projectEncryption\\texts"));
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("TXT File", "*.txt"));
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            File file = new File("D:\\Study\\projectEncryption\\texts\\testFile.txt");
            FileWriter w = new FileWriter(file);
            //openFile(selectedFile);
            w.write(Objects.requireNonNull(openFile(selectedFile)));
            w.close();
            //openFile(selectedFile);
            /*
            try {  //always, when you will work with the files, you should use try-catch!
                //File myfile = new File("sText.txt");
                Scanner in = new Scanner(selectedFile);  //it started to read from the begging - \n - symbol of the field end
                String data = null;
                while (in.hasNextLine()){
                    data = in.nextLine(); //save to the data all of the line and then go further
                    System.out.println(data);
                }
                in.close(); //when we finished to work with the file, you should close it down!
                //return data;
            } catch (FileNotFoundException e){
                e.printStackTrace(); //write the details about the error to error's window
            }

             */
        }
        //return null;
    }

/*
        else {
            actionStatus.setText("File selection cancelled.");
        }
        */


    //public void s


    private String openFile(File file) {
        String key = "";
        try {  //always, when you will work with the files, you should use try-catch!
            /*
            BufferedReader reader = new BufferedReader(new java.io.FileReader(file));
            String line = reader.readLine();

            while (line.){
                key += line;
                line = reader.readLine();
            }

            System.out.println(key);
            reader.close();
            return key;

             */

            Scanner in = new Scanner(file);  //it started to read from the begging - \n - symbol of the field end
            String data = "";
            //List<String> container = new ArrayList<>();
            while (in.hasNextLine()){
                data += in.nextLine(); //save to the data all of the line and then go further
                System.out.println(data);
                //container.add(data);
            }
            in.close(); //when we finished to work with the file, you should close it down!
            return data;
        } catch (FileNotFoundException e){
            e.printStackTrace(); //write the details about the error to error's window
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

        /*
        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(
                    Controller.class.getName()).log(
                    Level.SEVERE, null, ex
            );
        }

         */
    //}

    public String getKey(ActionEvent actionEvent) {
        return keyfield.getText();
    }

    public void writeFile(ActionEvent actionEvent) throws IOException {
/*
        File file = new File("D:\\Study\\projectEncryption\\txts\\testFile.txt");
        FileWriter w = new FileWriter(file);
        w.write(openFile());
        w.close();


 */
    }
}


