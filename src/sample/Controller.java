package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.*;
import java.util.Scanner;

public class Controller {
    public Button ecptBtn;
    public TextField keyfield;
    public Button decptBtn;

    public Button fileChooser;

    private File selectedFile;
    private String newData = "";
    private String data = "";
    private String keyString = "";
    private boolean sizeOfChar = false;

    public void selectFile(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select TXT file");
        fileChooser.setInitialDirectory(new File("D:\\Study\\projectEncryption\\texts"));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("TXT File", "*.txt"));
        selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            System.out.println(selectedFile.getAbsolutePath());
        } else {
            System.out.println("File is not valid!");
        }

        if (keyfield.getText().equals(null)){
            ecptBtn.setDisable(true);
            decptBtn.setDisable(true);
        }
    }

    public void makeEcryption(ActionEvent actionEvent) throws IOException {
        StringBuilder data = new StringBuilder();
        try {  //always, when you will work with the files, you should use try-catch!
            char letter;
            int letterCode;
            Scanner in = new Scanner(selectedFile);  //it started to read from the begging - \n - symbol of the field end
            //List<String> container = new ArrayList<>();

            keyString = keyfield.getText().toLowerCase();
            System.out.println(keyString);
            int keyCount = 0;

            char letterASCICode;
            int letterASCICodeInt;

            while (in.hasNextLine()) {
                data.append(in.nextLine()); //save to the data all of the line and then go further
            }

            System.out.println(data);

            int j = 0;
            for (int i = 0; i < data.length(); i++) {
                letter = data.charAt(i);
                letterCode = letter;
                if (letterCode >= 65 && letterCode <= 90 || letterCode >= 97 && letterCode <= 122) {
                    if (keyString.length() == j) {
                        j = 0;
                    }
                    letterASCICode = keyString.charAt(j);

                    letterASCICodeInt = letterASCICode;//int

                    letterASCICodeInt = letterASCICodeInt - 97;//shift the digit

                    letterCode = letterASCICodeInt + letterCode;
                    //letterCode = letterCode - letterASCICodeInt;
                    //System.out.println(letterASCICodeInt);
                    sizeOfChar = checkUpperCase(letter);
                    if (sizeOfChar) {
                        if (letterCode > 90) {
                            letterCode -= 26;//shift the digit
                        }
                    } else {
                        if (letterCode > 122) {
                            letterCode -= 26;//shift the digit
                        }
                    }

                    letter = (char) letterCode;
                    j++;
                }
                newData += letter;
            }
            System.out.println(newData);
            writeFile(newData);
            newData = "";
            in.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void makeDecryption(ActionEvent actionEvent) throws FileNotFoundException {
        StringBuilder data = new StringBuilder();
        keyString = keyfield.getText().toLowerCase();
        System.out.println(keyString);
        try {  //always, when you will work with the files, you should use try-catch!
            char letter;
            int letterCode;

            Scanner in = new Scanner(selectedFile);  //it started to read from the begging - \n - symbol of the field end
            //List<String> container = new ArrayList<>();

            while (in.hasNextLine()) {
                data.append(in.nextLine()); //save to the data all of the line and then go further
            }

            System.out.println(data);

            char letterASCICode;
            int letterASCICodeInt;

            int j = 0;
            for (int i = 0; i < data.length(); i++) {
                letter = data.charAt(i);
                letterCode = letter;
                if ((char) letterCode >= 65 && (char) letterCode <= 90 || (char) letterCode >= 97 && (char) letterCode <= 122) {

                    if (keyString.length() == j) {
                        j = 0;
                    }
                    letterASCICode = keyString.charAt(j);

                    letterASCICodeInt = letterASCICode;//int
                    letterASCICodeInt -= 97;// shift on -97 in ASCI code

                    letterCode = letterCode - letterASCICodeInt;
                    //System.out.println(letterASCICodeInt);

                    sizeOfChar = checkUpperCase(letter);
                    if (sizeOfChar) {
                        if (letterCode < 65) {
                            letterCode += 26;//shift the digit
                        }
                    } else {
                        if (letterCode < 97) {
                            letterCode += 26; //shift the digit
                        }
                    }
                    letter = (char) letterCode;
                    j++;
                }
                newData = newData + letter;
            }
            System.out.println(newData);
            //writeFile(newData);  //if it's need to write a new decrypted version
            newData = "";
            in.close(); //when we finished to work with the file, you should close it down!

        } catch (FileNotFoundException e) {
            e.printStackTrace(); //write the details about the error to error's window
        }
    }

    public boolean checkUpperCase(char letter) {
        return (int) letter >= 65 && (int) letter <= 90;
    }

    public void writeFile(String data) throws IOException {
        FileWriter w = new FileWriter("D:\\Study\\projectEncryption\\texts\\testFile.txt");
        BufferedWriter file = new BufferedWriter(w);
        file.write(data);
        file.close();
    }

    public void getKey(ActionEvent actionEvent) {
        if (!keyfield.getText().equals("") && selectedFile != null){
            ecptBtn.setDisable(false);
            decptBtn.setDisable(false);
        }
    }
}