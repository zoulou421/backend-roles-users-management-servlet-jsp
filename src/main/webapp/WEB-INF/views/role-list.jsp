<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Role List</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/5.3.3/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            margin-top: 50px;
            background: white;
            border-radius: 8px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
            padding: 30px;
        }
        h2 {
            color: #007bff;
        }
        .table thead th {
            background-color: #007bff;
            color: white;
        }
        .table tbody tr:hover {
            background-color: #f1f1f1;
        }
        .btn {
            margin-right: 5px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="mb-4 text-center">Role List</h2>
        <a href="${pageContext.request.contextPath}/role?action=add" class="btn btn-success mb-3">Add New Role</a>
        
        <table class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th class="text-center">ID</th>
                    <th class="text-center">Role Name</th>
                    <th class="text-center">Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="role" items="${roleList}">
                    <tr>
                        <td class="text-center">${role.id}</td>
                        <td class="text-center">${role.nom}</td>
                        <td class="text-center">
                            <a href="${pageContext.request.contextPath}/role?action=edit&id=${role.id}" class="btn btn-sm btn-primary">Edit</a>
                            <a href="${pageContext.request.contextPath}/role?action=delete&id=${role.id}" class="btn btn-sm btn-danger" onclick="return confirm('Are you sure you want to delete this role?')">Delete</a>
                            <a href="${pageContext.request.contextPath}/assignRole" class="btn btn-sm btn-info">Assign Role</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <script src="${pageContext.request.contextPath}/webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
