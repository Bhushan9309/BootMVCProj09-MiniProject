<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1 style="color:red; text-align: center">Actors Report Page</h1>

<c:choose>
    <c:when test="${!empty listVO}">
        <table border="1" bgcolor="yellow" align="center">
            <tr>
                <th>aid</th>
                <th>aname</th>
                <th>address</th>
                <th>category</th>
                <th>remuneration</th>
                <th>operations</th>
            </tr>

            <c:forEach var="vo" items="${listVO}">
                <tr>
                    <td>${vo.aid}</td>
                    <td>${vo.aname}</td>
                    <td>${vo.addrs}</td>
                    <td>${vo.category}</td>
                    <td>${vo.remuneration}</td>
                    <td>
                        <a href="edit?no=${vo.aid}">
                            <img src="images/edit.jpeg" width="30" height="30">
                        </a>
                        &nbsp;&nbsp;&nbsp;
                        <a href="delete?no=${vo.aid}" onclick="return confirm('Do you want to delete the record ?')">
                            <img src="images/delete.jpeg" width="30" height="30">
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <h1 style="color:red; text-align: center">Records not found</h1>
    </c:otherwise>
</c:choose>

<br><br>
<h1 style="color:green;text-align: center "> ${resultMsg}</h1>
<br><br>
<h1 style="color:red; text-align: center">
    <a href="add">
        Add Actor
        <img src="images/add.jpeg" width="80" height="80">
    </a>
</h1>

<!-- HOME BUTTON -->
<h1 style="color:red; text-align: center">
    <a href="./">
        Home
        <img src="images/home.jpeg" width="80" height="80">
    </a>
</h1>
