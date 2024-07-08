<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Gallery</title>
</head>
<body>
    <h1>Image Gallery</h1>
    <form action="gallery" method="get">
        <label for="category">Category:</label>
        <input type="text" id="category" name="category"><br>
        <label for="tags">Tags:</label>
        <input type="text" id="tags" name="tags"><br>
        <button type="submit">Filter</button>
    </form>
    <div>
        <h2>Images</h2>
        <ul>
            <c:forEach var="image" items="${images}">
                <li>
                    <h3>${image.title}</h3>
                    <img src="${image.url}" alt="${image.title}">
                    <p>Category: ${image.category}</p>
                    <p>Tags: ${image.tags}</p>
                    <p>Uploaded on: ${image.uploadDate}</p>
                </li>
            </c:forEach>
        </ul>
    </div>
</body>
</html>
