package thucnh.models;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import thucnh.dtos.BookDTO;
import thucnh.util.MyConnection;

/**
 *
 * @author USER
 */
public class BookDAO implements Serializable {

    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

    private void closeConnection() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (con != null) {
            con.close();
        }
    }

    public boolean insert(BookDTO dto) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Insert into tblBooks(BookID,BookTitle,Description,Author,Publisher,Price) VALUES(?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getBookID());
                stm.setString(2, dto.getBookTitle());
                stm.setString(3, dto.getDescription());
                stm.setString(4, dto.getAuthor());
                stm.setString(5, dto.getPublisher());
                stm.setFloat(6, Float.parseFloat(dto.getPrice()));
                check = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public BookDTO findByPrimaryKey(String id) throws ClassNotFoundException, SQLException {
        String bookID, bookTitle, description, author, publisher, price;
        BookDTO dto = null;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Select BookID,BookTitle,Description,Author,Publisher,Price FROM tblBooks where BookID=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                if (rs.next()) {
                    bookID = rs.getString("BookID");
                    bookTitle = rs.getString("BookTitle");
                    description = rs.getString("Description");
                    author = rs.getString("Author");
                    publisher = rs.getString("Publisher");
                    price = rs.getString("Price");
                    dto = new BookDTO(bookID, bookTitle, description, author, publisher, price);
                }
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public List<BookDTO> getAllBook() throws ClassNotFoundException, SQLException {
        List<BookDTO> result = null;
        String bookID, bookTitle, description, author, publisher, price;
        BookDTO dto = null;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                result = new ArrayList<>();
                String sql = "Select BookID,BookTitle,Description,Author,Publisher,Price FROM tblBooks";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    bookID = rs.getString("BookID");
                    bookTitle = rs.getString("BookTitle");
                    description = rs.getString("Description");
                    author = rs.getString("Author");
                    publisher = rs.getString("Publisher");
                    price = rs.getString("Price");
                    dto = new BookDTO(bookID, bookTitle, description, author, publisher, price);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<BookDTO> findBookByTitle(String title) throws ClassNotFoundException, SQLException {
        List<BookDTO> result = null;
        String bookID, bookTitle, description, author, publisher, price;
        BookDTO dto = null;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                result = new ArrayList<>();
                String sql = "Select BookID,BookTitle,Description,Author,Publisher,Price FROM tblBooks where BookTitle LIKE ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + title + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    bookID = rs.getString("BookID");
                    bookTitle = rs.getString("BookTitle");
                    description = rs.getString("Description");
                    author = rs.getString("Author");
                    publisher = rs.getString("Publisher");
                    price = rs.getString("Price");
                    dto = new BookDTO(bookID, bookTitle, description, author, publisher, price);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Delete from tblBooks where BookID =?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                check = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean update(BookDTO dto) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Update tblBooks SET BookTitle=?,Description=?,Author=?,Publisher=?,Price=? where BookID=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getBookTitle());
                stm.setString(2, dto.getDescription());
                stm.setString(3, dto.getAuthor());
                stm.setString(4, dto.getPublisher());
                stm.setFloat(5, Float.parseFloat(dto.getPrice()));
                stm.setString(6, dto.getBookID());
                check = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }
}
