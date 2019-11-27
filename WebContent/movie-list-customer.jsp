<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.cognizant.moviecruiser.model.MovieList"  %>
<!doctype html>
<html>
<head>
<title>movie list customer</title>
<link rel="stylesheet" href="style/style.css"/>
</head>
<body>
<header class="header container-fluid">
<h2 class="header-itemleft">Movie Crusier</h2>
<img src="images/movie-crusier.png" class="center">
<a class="header-itemright" href="movie-list-customer.jsp"  style="margin:15px">Movies</a>
<a class="header-itemright" href="ShowFavoriteServlet"  style="margin:15px">Favorites</a>
</header>
<section class="body-main" style="overflow-x:auto;">
                <h1 class="h1-left">Movies</h1>
                <c:if test="${addfavoriteStatus}">
                <h2 >Movie added to Favorites Successfully</h2>
                </c:if>
                
<table style="width:100%;" id="books" >
                                <tr>
                                               <th class="td-name">Title</th>
                                                <th class="td-price">Box Office</th>
                                                
                                                <th>Genre</th>
                                                 <th>Has teaser</th>
                                                <th>Action</th>
                                </tr>
                                <c:forEach var="item" items="${customermovieList}">
                                <tr>
                                                <td class="td-name">${item.title}</td>
                                                <td class="td-price"><fmt:formatNumber type="currency" value="${item.box_office }"/></td>
                                                
                                                <td>${item.genre}</td>
                                                <td>${item.hasTeaser ? 'yes' : 'No' }</td>
                                                <td>
                                                <a href="AddToFavoriteServlet?id=${item.id}">Add to Favorite</a>
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