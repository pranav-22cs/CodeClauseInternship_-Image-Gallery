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

@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String url = request.getParameter("url");
        String category = request.getParameter("category");
        String tags = request.getParameter("tags");

        Image image = new Image();
        image.setTitle(title);
        image.setUrl(url);
        image.setCategory(category);
        image.setTags(tags);

        ImageDAO dao = new ImageDAO();
        try {
            dao.addImage(image);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("gallery");
    }
}
