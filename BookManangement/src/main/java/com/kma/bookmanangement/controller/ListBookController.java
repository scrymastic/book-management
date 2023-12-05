/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kma.bookmanangement.controller;

import java.util.Arrays;
import java.util.List;

import com.kma.bookmanangement.dao.BookDAO;
import com.kma.bookmanangement.model.Book;

/**
 *
 * @author lxsgo
 */
public class ListBookController {

    // request for book ids
    public static List<String> getAvailableBookIds() {
        BookDAO bookDAO = new BookDAO();
        return bookDAO.getBookIds();
    }

    // request for book data
    public static List<String> getBookDataById(String bookId) {
        Book book = new BookDAO().getBookById(bookId);
        List<String> bookData = Arrays.asList(
                book.getBookId(),
                book.getAuthor(),
                book.getTitle(),
                book.getPublicDate(),
                book.getCategory());
        return bookData;
    }

}
