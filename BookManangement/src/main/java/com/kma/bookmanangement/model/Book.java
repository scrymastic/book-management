/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kma.bookmanangement.model;

/**
 *
 * @author lxsgo
 */
public class Book {
    // book data
    private String bookId;
    private String author;
    private String title;
    private String publicDate;
    private String category;

    // constructor
    public Book(String bookId, String title, String author, String publicDate, String category) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publicDate = publicDate;
        this.category = category;
    }

    // getter
    public String getBookId() {
        return this.bookId;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getTitle() {
        return this.title;
    }

    public String getPublicDate() {
        return this.publicDate;
    }

    public String getCategory() {
        return this.category;
    }


    
}
