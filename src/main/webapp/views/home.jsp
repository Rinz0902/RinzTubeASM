<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RinzTube - HomePage</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
</head>
<body>
    <!-- Header -->
    <header>
        <div class="logo">
            <h1>RinzTube</h1>
        </div>
        <div class="search-bar">
            <form action="${pageContext.request.contextPath}/search" method="get">
                <input type="text" name="query" placeholder="Search videos...">
                <button type="submit">Search</button>
            </form>
        </div>
    </header>

    <!-- Video list -->
    <div class="video-list">
        <h2>Trending Videos</h2>
        <div class="video-thumbnails">
            <c:forEach var="video" items="${videos}">
                <div class="video-card">
                    <a href="${pageContext.request.contextPath}/video/${video.videoId}">
                        <img src="${video.thumbnail}" alt="${video.title}">
                        <h3>${video.title}</h3>
                        <p>${video.description}</p>
                    </a>
                </div>
            </c:forEach>
        </div>
    </div>

    <!-- Footer -->
    <footer>
        <p>© 2024 RinzTube</p>
    </footer>
</body>
</html>
