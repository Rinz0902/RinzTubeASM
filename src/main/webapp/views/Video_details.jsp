<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${video.title} - RinzTube</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
</head>
<body>
    <!-- Header -->
    <header>
        <div class="logo">
            <h1>RinzTube</h1>
        </div>
    </header>

    <!-- Video Player -->
    <div class="video-player">
        <h2>${video.title}</h2>
        <video controls width="100%">
            <source src="${video.videoUrl}" type="video/mp4">
            Your browser does not support the video tag.
        </video>
        <p>${video.description}</p>
        <p>Views: ${video.viewCount}</p>
    </div>

    <!-- Comments Section -->
    <div class="comments">
        <h3>Comments</h3>
        <c:forEach var="comment" items="${comments}">
            <div class="comment">
                <p><strong>${comment.user.username}</strong>: ${comment.content}</p>
            </div>
        </c:forEach>
        
        <form action="${pageContext.request.contextPath}/video/${video.videoId}/comment" method="post">
            <textarea name="comment" placeholder="Add a comment..."></textarea>
            <button type="submit">Post Comment</button>
        </form>
    </div>

    <!-- Footer -->
    <footer>
        <p>© 2024 RinzTube</p>
    </footer>
</body>
</html>
