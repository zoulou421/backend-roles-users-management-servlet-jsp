<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Assign Role to User</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/5.3.3/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .form-container {
            margin-top: 50px;
            background: white;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }
        h2 {
            color: #007bff;
        }
    </style>
</head>
<body>
<div class="container form-container">
    <h2 class="text-center">Assign Role to User</h2>
    
    <form action="${pageContext.request.contextPath}/assignRole" method="post">
        <div class="mb-3">
            <label for="userId" class="form-label">Select User:</label>
            <select id="userId" name="userId" class="form-select" required>
                <option value="">-- Select User --</option>
                <c:forEach var="user" items="${userList}">
                    <option value="${user.id}">${user.userName} (${user.email})</option>
                </c:forEach>
            </select>
        </div>

        <div class="mb-3">
            <label for="roleId" class="form-label">Select Role:</label>
            <select id="roleId" name="roleId" class="form-select" required>
                <option value="">-- Select Role --</option>
                <c:forEach var="role" items="${roleList}">
                    <option value="${role.id}">${role.nom}</option>
                </c:forEach>
            </select>
        </div>

        <div class="d-flex justify-content-between">
            <button type="submit" class="btn btn-primary">Assign Role</button>
            <a href="${pageContext.request.contextPath}/user?action=list" class="btn btn-secondary">Back to User List</a>
        </div>
    </form>
</div>

<script src="${pageContext.request.contextPath}/webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
