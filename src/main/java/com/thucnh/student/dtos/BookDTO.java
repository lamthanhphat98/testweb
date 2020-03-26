/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thucnh.dtos;

import java.io.Serializable;

/**
 *
 * @author USER
 */
public class BookDTO implements Serializable{
    private String bookID,bookTitle,description,author,publisher;
    private String price;

    public BookDTO() {
    }

    public BookDTO(String bookID, String bookTitle, String description, String author, String publisher, String price) {
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.description = description;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
}
