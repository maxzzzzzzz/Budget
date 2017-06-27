<%--
  Created by IntelliJ IDEA.
  User: ilost
  Date: 25.06.2017
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Budget Application</title>
</head>
<body>
<center>
    <h1>Budget Management</h1>
    <h2>
        <a href="/new">Add New Budget</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/list">List All Budgets</a>

    </h2>
</center>
<div align="center">
    <c:if test="${budget != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${budget == null}">
        <form action="insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${budget != null}">
                            Edit Budget
                        </c:if>
                        <c:if test="${budget == null}">
                            Add New Budget
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${budget != null}">
                    <input type="hidden" name="id" value="<c:out value='${budget.id}' />" />
                </c:if>
                <tr>
                    <th>Creation Date: </th>
                    <td>
                        <input type="text" name="creationDate" size="45"
                               value="<c:out value='${budget.creationDate}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Description: </th>
                    <td>
                        <input type="text" name="description" size="45"
                               value="<c:out value='${budget.description}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Price: </th>
                    <td>
                        <input type="text" name="name" size="45"
                               value="<c:out value='${budget.name}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>
