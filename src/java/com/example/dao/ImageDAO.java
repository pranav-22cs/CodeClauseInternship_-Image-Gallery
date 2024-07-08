package com.example.dao;

import com.example.model.Image;
import com.example.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImageDAO {
    public void addImage(Image image) throws SQLException {
        String sql = "INSERT INTO images (title, url, category, tags) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, image.getTitle());
            stmt.setString(2, image.getUrl());
            stmt.setString(3, image.getCategory());
            stmt.setString(4, image.getTags());
            System.out.println("Executing query: " + stmt);
            int rowsInserted = stmt.executeUpdate();
            System.out.println("Rows inserted: " + rowsInserted);
        }
    }

    public List<Image> getImages(String category, String tags) throws SQLException {
        List<Image> images = new ArrayList<>();
        String sql = "SELECT * FROM images WHERE category = ? OR FIND_IN_SET(?, tags)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, category);
            stmt.setString(2, tags);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Image image = new Image();
                image.setId(rs.getInt("id"));
                image.setTitle(rs.getString("title"));
                image.setUrl(rs.getString("url"));
                image.setCategory(rs.getString("category"));
                image.setTags(rs.getString("tags"));
                image.setUploadDate(rs.getString("upload_date"));
                images.add(image);
            }
        }
        return images;
    }
}
