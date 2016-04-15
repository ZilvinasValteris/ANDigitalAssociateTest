<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <title>Home</title>
    </head>
    <body>
        <h3>Trending venue search engine</h3>

        Enter location:
        <form method="GET" action="getVenues">

            <input type="text" name="location"/>
            <input type="submit" value="Find venues"/>

        </form>
    </body>
</html>