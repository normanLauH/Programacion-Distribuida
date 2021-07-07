package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App
{
    public static void main( String[] args ) throws FileNotFoundException {
        File myFile;
        myFile = new File("test.txt");

        createFile(myFile);
        writeContent(myFile, "Texto de prueba");
        readContent(myFile);
        getPath(myFile);
        deleteFile(myFile);
    }

    public static void createFile(File myFile){
        try{
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writeContent(File myFile, String contents){
        FileWriter writer = null;
        try{
            writer= new FileWriter(myFile);
            writer.write(contents);
            System.out.println("Edited file: "+contents);
            writer.close();

        }catch (IOException e){
            System.out.println("An error occurred while writing : "+ e.getMessage());
        }
    }

    public static void readContent(File myFile) throws FileNotFoundException {
        try{
            Scanner reader = new Scanner(myFile);
            System.out.println("Reading file....");
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void getPath(File myFile){
        System.out.println("File path: "+myFile.getAbsolutePath());
    }

    public static void deleteFile(File myFile){
        if (myFile.delete()) {
            System.out.println("Deleted the file: " + myFile.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
}