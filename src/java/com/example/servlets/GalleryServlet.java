package com.example.servlets;

import com.example.dao.ImageDAO;
import com.example.model.Image;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/gallery")
public class GalleryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String category = request.getParameter("category");
        String tags = request.getParameter("tags");

        ImageDAO dao = new ImageDAO();
        try {
            List<Image> images = dao.getImages(category, tags);
            request.setAttribute("images", images);
            request.getRequestDispatcher("gallery.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
