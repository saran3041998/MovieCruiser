<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.cognizant.moviecruiser.model.MovieList"  %>
<!Doctype html>
<html>
<head>
<title>Edit Movie</title>
<script type="text/javascript" src="js/script.js">

</script>
<link rel="stylesheet" href="style/style.css"/>

<style type="text/css">
.body-main th
{
text-align:left;
padding-top:20px;
}
.body-main td
{
text-align:left;
}
button[type="submit"]
{
padding-top:15px;
padding-bottom:15px;
padding-left:15px;
padding-right:15px;
background-color:#004080;
color:white;
border:0;

}              
</style>
</head>
<body>
<c:set var="categories" value="Science Fiction,Romance,Comedy,Action" scope="application"/>
<c:set var="selected" value="${movieList.genre}" scope="application"/>
<header class="header container-fluid">
<h2 class="header-itemleft">Movie Crusier</h2>
<img src="images/movie-crusier.png" class="center">
<a class="header-itemright" href="ShowMovieListAdminServlet"  style="margin:15px">Movies</a>
</header>

<section class="body-main" style="overflow-x:auto;">
     
                <h1 class="style-color">Edit Movie</h1>
                <form name="editMenuForm" action="EditMovieServlet" method="post" onsubmit="return validateMenuItem()">
                <table style="width:100%" id="">
                <tr><th colspan="4"><label for="mname">Title</th></tr>
                <tr><td colspan="4"><input type="text" style="width:1050px;height:30px;" id="mname" style="width:45%" name="mname" value=<c:out value="${movieList.title}"/>></td></tr>
                <tr>
                <th><label for="price">Gross($)</th>
                <th><label for="active">Active</th>
                <th><label for="launch">Date of Launch</th>
                <th><label for="category">Genre</th>
                </tr>

                <tr>
                <td><input type="text" name="price" id="price" value=<c:out value="${movieList.box_office}"/>></td>
                <c:choose>
                                                <c:when test="${movieList.active=='Yes'}">
                                                      <td><input type="radio" id="mactive"
                                                            name="active" value="Yes" style="font-size: 20px"
                                                            checked>Yes <input type="radio" id="mactive"
                                                            name="active" value="No" style="font-size: 20px">No
                                                      </td>
                                                </c:when>
                                                <c:otherwise>
                                                      <td><input type="radio" id="mactive"
                                                            name="active" value="Yes" style="font-size: 20px">Yes
                                                            <input type="radio" id="mactive" name="active"
                                                            value="No" style="font-size: 20px" checked>No
                                                      </td>
                                                </c:otherwise>
                                          </c:choose>
                </td>
                <td><input type="date" name="date" id="launch" value=<fmt:formatDate pattern="dd/MM/yyyy" value="${movieList.dateOfLaunch}"/> ></td>
                <td>
                <select name="category" id="category">
                <option value="${selected}" selected>${selected}</option>
                                                                      
                
                <c:forEach items="${categories}" var="category">
                <c:if test="${category!=selected}">
                <option value="${category}">${category}</option>
                </c:if>
                </c:forEach>
                </select>
                </td>
                
                
                

                <tr>
                <td><input type="checkbox" name="freedelivery"
                                                value="${user.movieList.Delivery}"
                                                <c:if test="${movieList.hasTeaser}">checked="checked"</c:if> />
                                                <label>Has Teaser</label></td>
               
                </tr>

                <tr>
                <td><a href="edit-movie-status.jsp" style="color:white;"><button  type="submit" name="save" value="Save">Save</a></td></button>
                </tr>


               </table>
               <input type="hidden" id="movieid" name="movieid" value="${movieList.id }"/>
               
               
        </form>
</section>
<footer class="footer container-fluid">
                <p>&nbsp;&nbsp;Copyright &copy; 2019</p>
</footer>
</body>
</html>
