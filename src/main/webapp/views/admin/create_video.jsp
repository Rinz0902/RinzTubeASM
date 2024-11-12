<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin - Add Video</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
</head>
<body>
    <!-- Header -->
    <header>
        <div class="logo">
            <h1>RinzTube Admin</h1>
        </div>
    </header>

    <!-- Add Video Form -->
    <h2>Add New Video</h2>
    <form action="${pageContext.request.contextPath}/admin/videos/create" method="post">
        <div>
            <label for="title">Title</label>
            <input type="text" name="title" id="title" required>
        </div>
        <div>
            <label for="description">Description</label>
            <textarea name="description" id="description" required></textarea>
        </div>
        <div>
            <label for="thumbnail">Thumbnail URL</label>
            <input type="text" name="thumbnail" id="thumbnail" required>
        </div>
        <div>
            <label for="videoUrl">Video URL</label>
            <input type="text" name="videoUrl" id="videoUrl" required>
        </div>
        <div>
            <button type="submit">Add Video</button>
        </div>
    </form>

    <!-- Footer -->
    <footer>
        <p>© 2024 RinzTube</p>
    </footer>
</body>
</html>
