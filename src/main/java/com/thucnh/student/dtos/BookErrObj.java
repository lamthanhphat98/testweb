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
public class BookErrObj implements Serializable{
    private String bookIDErr,titleErr,descriptionErr,authorErr,publisherErr,priceErr;

    public BookErrObj() {
    }

    public String getBookIDErr() {
        return bookIDErr;
    }

    public void setBookIDErr(String bookIDErr) {
        this.bookIDErr = bookIDErr;
    }

    public String getTitleErr() {
        return titleErr;
    }

    public void setTitleErr(String titleErr) {
        this.titleErr = titleErr;
    }

    public String getDescriptionErr() {
        return descriptionErr;
    }

    public void setDescriptionErr(String descriptionErr) {
        this.descriptionErr = descriptionErr;
    }

    public String getAuthorErr() {
        return authorErr;
    }

    public void setAuthorErr(String authorErr) {
        this.authorErr = authorErr;
    }

    public String getPublisherErr() {
        return publisherErr;
    }

    public void setPublisherErr(String publisherErr) {
        this.publisherErr = publisherErr;
    }

    public String getPriceErr() {
        return priceErr;
    }

    public void setPriceErr(String priceErr) {
        this.priceErr = priceErr;
    }
    
}
