/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thucnh.student.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thucnh.student.beans.JavaBean;
import thucnh.dtos.BookDTO;
import thucnh.dtos.BookErrObj;

/**
 *
 * @author USER
 */
public class UpdateController extends HttpServlet {

    private static final String UPDATE = "update.jsp";
    private static final String SUCCESS = "SearchController";
    private static final String ERROR = "error.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String btAction = request.getParameter("btAction");
            if (btAction.equals("Edit")) {
                String bookID = request.getParameter("idEdit");
                JavaBean beans = new JavaBean();
                beans.setBookID(bookID);
                BookDTO dto = beans.getBookByBookID();
                request.setAttribute("DTO", dto);
                url = UPDATE;
            } else if (btAction.equals("Update")) {
                String bookID = request.getParameter("txtBookID");
                String bookTitle = request.getParameter("txtBookTitle");
                String description = request.getParameter("txtDescription");
                String author = request.getParameter("txtAuthor");
                String publisher = request.getParameter("txtPublisher");
                String price = request.getParameter("txtPrice");
                BookErrObj errObj = new BookErrObj();
                boolean check = true;
                if (bookID.length() < 1 || bookID.length() > 5) {
                    check = false;
                    errObj.setBookIDErr("BookID must has [1-5] characters");
                }
                if (bookTitle.length() < 1 || bookID.length() > 50) {
                    check = false;
                    errObj.setTitleErr("Book title must has [1-50] characters");
                }
                if (description.length() < 1 || description.length() > 250) {
                    check = false;
                    errObj.setDescriptionErr("Description must has [1-250] characters");
                }
                if (author.length() < 1 || author.length() > 50) {
                    check = false;
                    errObj.setAuthorErr("Author must has [1-50] characters");
                }
                if (publisher.length() < 1 || publisher.length() > 50) {
                    check = false;
                    errObj.setPublisherErr("Publisher must has [1-50] characters");
                }
                if (!price.matches("\\d+(\\.\\d+)?")) {
                    check = false;
                    errObj.setPriceErr("Price must be a number >= 0");
                }
                BookDTO dto = new BookDTO(bookID, bookTitle, description, author, publisher, price);
                if (check) {
                    JavaBean beans = new JavaBean();
                    beans.setDto(dto);
                    boolean checkUpdate = beans.update();
                    if (checkUpdate) {
                        request.setAttribute("STATUS", "Update successfully");
                        url = SUCCESS;
                    } else {
                        request.setAttribute("ERROR", "Update failed");
                    }
                } else {
                    url = UPDATE;
                    request.setAttribute("DTO", dto);
                    request.setAttribute("INVALID", errObj);
                }

            } else {
                request.setAttribute("ERROR", "Acton is not supported");
            }
        } catch (Exception e) {
            log("Error at UpdateController " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
