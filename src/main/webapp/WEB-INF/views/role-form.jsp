<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${role != null ? 'Edit Role' : 'Add Role'}</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/5.3.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">${role != null ? 'Edit Role' : 'Add Role'}</h2>
        
        <form action="${pageContext.request.contextPath}/role" method="post">
            <div class="mb-3">
                <label for="roleId" class="form-label">Role ID</label>
                <input type="text" class="form-control" id="roleId" name="id" value="${role != null ? role.id : ''}" readonly>
            </div>
            <div class="mb-3">
                <label for="roleName" class="form-label">Role Name</label>
                <input type="text" class="form-control" id="roleName" name="nom" value="${role != null ? role.nom : ''}" required>
            </div>
            <button type="submit" class="btn btn-primary">${role != null ? 'Update Role' : 'Add Role'}</button>
            <a href="${pageContext.request.contextPath}/role?action=list" class="btn btn-secondary">Cancel</a>
        </form>
    </div>

    <script src="${pageContext.request.contextPath}/webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
