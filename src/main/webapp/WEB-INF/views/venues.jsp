<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <title>Venues</title>
    </head>
    <body>

        <h3>Trending venues at the moment</h3>
        <c:forEach items = "${trendingVenues}" var = "trendingVenue">
            <p>
                ${trendingVenue}
            </p>
        </c:forEach>

    </body>
</html>
