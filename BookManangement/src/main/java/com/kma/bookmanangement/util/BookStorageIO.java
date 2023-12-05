/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kma.bookmanangement.util;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author lxsgo
 */
public class BookStorageIO {
    // D:\book-management\BookManangement\src\main\resources\bookdata.dat
    private String filePath = "src/main/resources/bookdata.dat";

    public BufferedWriter openStorageForWriting() {
        try {
            FileWriter fileWriter = new FileWriter(this.filePath, true); // Set to 'true' to append, 'false' to
                                                                         // overwrite.
            return new BufferedWriter(fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Return null if there was an error opening the file
        }
    }


    // for reading
    public BufferedReader openStorageForReading() {
        try {
            FileReader fileReader = new FileReader(this.filePath);
            return new BufferedReader(fileReader);
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Return null if there was an error opening the file
        }
    }


    public static void closeFile(BufferedWriter bufferedWriter) {
        try {
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void closeFile(BufferedReader bufferedReader) {
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
