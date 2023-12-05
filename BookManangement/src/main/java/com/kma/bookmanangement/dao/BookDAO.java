/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kma.bookmanangement.dao;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;

import com.kma.bookmanangement.model.Book;
import com.kma.bookmanangement.util.BookStorageIO;

/**
 *
 * @author lxsgo
 */
public class BookDAO {
    // save the book to database
    public boolean saveBookToStorage(Book book) {
        BufferedWriter bufferedWriter = new BookStorageIO().openStorageForWriting();
        try {
            if (bufferedWriter != null) {
                String content = book.getBookId() + "|"
                        + book.getTitle() + "|"
                        + book.getAuthor() + "|"
                        + book.getPublicDate() + "|"
                        + book.getCategory();
                bufferedWriter.write(content);
                bufferedWriter.newLine(); // To add a new line after the content
                BookStorageIO.closeFile(bufferedWriter);

                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        BookStorageIO.closeFile(bufferedWriter);
        return false;
    }

    public List<String> getBookIds() {
        List<String> bookIds = new ArrayList<>();
        BufferedReader bufferedReader = new BookStorageIO().openStorageForReading();
        try {
            if (bufferedReader != null) {
                String line = bufferedReader.readLine();
                while (line != null) {
                    String[] bookData = line.split("\\|");
                    bookIds.add(bookData[0]);
                    line = bufferedReader.readLine();
                }

                BookStorageIO.closeFile(bufferedReader);
                return bookIds;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        BookStorageIO.closeFile(bufferedReader);
        return null;
    }


    // get book by id
    public Book getBookById(String bookId) {
        BufferedReader bufferedReader = new BookStorageIO().openStorageForReading();
        try {
            if (bufferedReader != null) {
                String line = bufferedReader.readLine();
                while (line != null) {
                    String[] bookData = line.split("\\|");
                    if (bookData[0].equals(bookId)) {
                        Book book = new Book(bookData[0], bookData[1], bookData[2], bookData[3], bookData[4]);
                        BookStorageIO.closeFile(bufferedReader);
                        return book;
                    }
                    line = bufferedReader.readLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        BookStorageIO.closeFile(bufferedReader);
        return null;
    }


}
