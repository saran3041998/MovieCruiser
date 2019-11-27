<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.cognizant.moviecruiser.model.MovieList"  %>

<!doctype html>
<html>
<head>
<title>movie list admin</title>
<link rel="stylesheet" href="style/style.css"/>
</head>
<body>
<header class="header container-fluid">
<h2 class="header-itemleft">Movie Crusier</h2>
<img src="images/movie-crusier.png" class="center">
<a class="header-itemright" href="ShowMovieListAdminServlet"  style="margin:15px">Movies</a>
</header>

<section class="body-main" style="overflow-x:auto;">
                <h1 class="h1-left">Movies</h1>
                <table style="width:100%;" id="books" >
                                <tr>
                                                <th class="td-name">Title</th>
                                                <th class="td-price">Box Office</th>
                                                <th>Active</th>
                                                <th>Date of Launch</th>
                                                <th>Genre</th>
                                                 <th>Has teaser</th>
                                                <th>Action</th>
                                </tr>
                                <c:forEach var="item" items="${adminmovieList}">
                                <tr>
                                                <td class="td-name">${item.title}</td>
                                                <td class="td-price"><fmt:formatNumber type="currency" value="${item.box_office }"/></td>
                                                <td>${item.active ? 'Yes' : 'No'  }</td>
                                                <td><fmt:formatDate pattern="dd/MM/yyyy"  value="${item.dateOfLaunch }"/></td>
                                                <td>${item.genre}</td>
                                                <td>${item.hasTeaser ? 'yes' : 'No' }</td>
                                                <td>
                                                <a href="ShowEditMovieServlet?id=${item.id}">Edit</a>
                                                </td>
                                </tr>
                                </c:forEach>

                                </table>
</section>
                                                
<footer class="footer container-fluid">
                <p>&nbsp;&nbsp;Copyright &copy;2019</p>
</footer>
</body>
</html>