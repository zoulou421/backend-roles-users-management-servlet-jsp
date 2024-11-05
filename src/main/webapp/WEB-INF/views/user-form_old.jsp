<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${user != null ? 'Edit' : 'Add'} User</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/5.3.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">${user != null ? 'Edit' : 'Add'} User</h2>
        
        <form action="${pageContext.request.contextPath}/user" method="post">
            <input type="hidden" name="id" value="${user != null ? user.id : ''}">
            
            <div class="mb-3">
                <label for="userName" class="form-label">User Name</label>
                <input type="text" class="form-control" id="userName" name="userName" value="${user != null ? user.userName : ''}" required>
            </div>
            
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email" value="${user != null ? user.email : ''}" required>
            </div>
            
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" name="password" value="${user != null ? user.password : ''}" required>
            </div>
            
            <button type="submit" class="btn btn-primary">${user != null ? 'Update' : 'Add'} User</button>
            <a href="${pageContext.request.contextPath}/user?action=list" class="btn btn-secondary ms-2">Back to List</a>
        </form>
    </div>

    <script src="${pageContext.request.contextPath}/webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
