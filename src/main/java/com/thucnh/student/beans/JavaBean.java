/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thucnh.student.beans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import thucnh.dtos.BookDTO;
import thucnh.models.BookDAO;

/**
 *
 * @author USER
 */
public class JavaBean implements Serializable{
    private String bookID, bookTitle, description, author, publisher;
    private float price;
    
    private BookDTO dto;
    public JavaBean() {
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public BookDTO getDto() {
        return dto;
    }

    public void setDto(BookDTO dto) {
        this.dto = dto;
    }
    
    
    
    
    
    public List<BookDTO> getAllBooks() throws ClassNotFoundException, SQLException{
        BookDAO dao = new BookDAO();
        return dao.getAllBook();
    }
    public List<BookDTO> findBookByTitle() throws ClassNotFoundException, SQLException{
        BookDAO dao = new BookDAO();
        return dao.findBookByTitle(bookTitle);
    }
    public boolean deleteBook() throws ClassNotFoundException, SQLException{
         BookDAO dao = new BookDAO();
        return dao.delete(bookID);
    }
    public boolean update() throws ClassNotFoundException, SQLException{
        BookDAO dao = new BookDAO();
        return dao.update(dto); 
    }
    public BookDTO getBookByBookID() throws ClassNotFoundException, SQLException{
        BookDAO dao = new BookDAO();
        return dao.findByPrimaryKey(bookID); 
    }
    
}
