/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kma.bookmanangement.controller;

import com.kma.bookmanangement.dao.BookDAO;
import com.kma.bookmanangement.model.Book;


/**
 *
 * @author lxsgo
 */
public class EnterBookController {

    // construct a book object, send it to BookDAO
    public static int enterBook(String bookId, String title, String author, String publicDate, String category) {
        // check if any of the parameters is empty
        if (bookId.isEmpty() || author.isEmpty() || title.isEmpty() || publicDate.isEmpty() || category.isEmpty()) {
            // handle the case where one of the parameters is empty
            return 3;
        }


        // check if any of the parameters contain "|"
        if (bookId.contains("|") || author.contains("|") || title.contains("|") || publicDate.contains("|") || category.contains("|")) {
            // handle the case where one of the parameters contains "|"
            return 2;
        }
        BookDAO bookDAO = new BookDAO();
        Book book = bookDAO.getBookById(bookId);
        if (book != null) {
            // handle the case where the book already exists
            return 4;
        }
        
        book = new Book(bookId, author, title, publicDate, category);
        bookDAO = new BookDAO();
        boolean result = bookDAO.saveBookToStorage(book);
        if (result) {
            // handle the case where the book is successfully saved
            return 0;
        } else {
            // handle the case where the book is not successfully saved
            return 1;
        }
    }


    public static String errorMessages(int errorCode) {
        switch (errorCode) {
            case 0:
                return "Book successfully saved!";
            case 1:
                return "Book not saved!";
            case 2:
                return "Book information contains invalid characters!";
            case 3:
                return "Book information cannot be empty!";
            case 4:
                return "Book already exists!";
            default:
                return "Unknown error!";
        }
    }

}
