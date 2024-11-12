<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin - Manage Videos</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
</head>
<body>
    <!-- Header -->
    <header>
        <div class="logo">
            <h1>RinzTube Admin</h1>
        </div>
        <div class="admin-links">
            <a href="${pageContext.request.contextPath}/admin/videos">Manage Videos</a>
            <a href="${pageContext.request.contextPath}/admin/users">Manage Users</a>
            <a href="${pageContext.request.contextPath}/logout">Logout</a>
        </div>
    </header>

    <!-- Video Management -->
    <h2>Manage Videos</h2>
    <a href="${pageContext.request.contextPath}/admin/videos/create" class="btn btn-create">Add New Video</a>

    <table>
        <thead>
            <tr>
                <th>Title</th>
                <th>Thumbnail</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="video" items="${videos}">
                <tr>
                    <td>${video.title}</td>
                    <td><img src="${video.thumbnail}" alt="${video.title}" width="100"></td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/videos/edit/${video.videoId}">Edit</a>
                        <a href="${pageContext.request.contextPath}/admin/videos/delete/${video.videoId}" onclick="return confirm('Are you sure?')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <!-- Footer -->
    <footer>
        <p>© 2024 RinzTube</p>
    </footer>
</body>
</html>
