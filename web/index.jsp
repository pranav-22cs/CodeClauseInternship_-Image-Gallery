<!DOCTYPE html>
<html>
<head>
    <title>Image Gallery</title>
</head>
<body>
    <h1>Upload Image</h1>
    <form action="upload" method="post">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title"><br>
        <label for="url">URL:</label>
        <input type="text" id="url" name="url"><br>
        <label for="category">Category:</label>
        <input type="text" id="category" name="category"><br>
        <label for="tags">Tags (comma separated):</label>
        <input type="text" id="tags" name="tags"><br>
        <button type="submit">Upload</button>
    </form>
    <a href="gallery">View Gallery</a>
</body>
</html>
