<%-- 
    Document   : mahasiswa
    Created on : 10-Nov-2020, 18:39:14
    Author     : user
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Master Mahasiswa</h1>
        <ul>
            <c:forEach items="${requestScope.arr}" var="i">
                <li>
                    <c:out value="${i.getNrp()}" /> - <c:out value="${i.getNama()}" />
                </li>
            </c:forEach>
        </ul>
        
        <form action="${pageContext.request.contextPath}/insert" method="POST">
            NRP : <input type="text" name="nrp" value="" /><br />
            Nama : <input type="text" name="nama" value="" /><br />
            <input type="submit" value="Insert" />
        </form>
        <br>
        <form action="${pageContext.request.contextPath}/delete" method="POST">
            NRP : <input type="text" name="nrp" value="" /><br />
            <input type="submit" value="Delete" />
        </form>
    </body>
</html>
