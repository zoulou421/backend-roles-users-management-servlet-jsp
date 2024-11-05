<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
    <!-- Include Bootstrap CSS -->
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/5.3.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <div class="card">
            <div class="card-header bg-primary text-white">
                <h3>User Profile</h3>
            </div>
            <div class="card-body">
                <form>
                    <div class="row mb-3">
                        <label for="userId" class="col-sm-2 col-form-label">User ID:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="userId" value="${user.id}" readonly>
                        </div>
                    </div>

                    <div class="row mb-3">
                        <label for="userName" class="col-sm-2 col-form-label">User Name:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="userName" value="${user.userName}" readonly>
                        </div>
                    </div>

                    <div class="row mb-3">
                        <label for="email" class="col-sm-2 col-form-label">Email:</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" id="email" value="${user.email}" readonly>
                        </div>
                    </div>

                    <div class="row mb-3">
                        <label for="roles" class="col-sm-2 col-form-label">Roles:</label>
                        <div class="col-sm-10">
                            <ul class="list-group">
                                <c:forEach var="role" items="${user.roles}">
                                    <li class="list-group-item">${role.nom}</li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>

                    <!-->div class="row mb-3">
                        <label for="createdAt" class="col-sm-2 col-form-label">Created At:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="createdAt" value="${user.createdAt}" readonly>
                        </div>
                    </div>

                    <div class="row mb-3">
                        <label for="updatedAt" class="col-sm-2 col-form-label">Updated At:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="updatedAt" value="${user.updatedAt}" readonly>
                        </div>
                    </div  -->

                    <div class="d-flex justify-content-end">
                        <a href="${pageContext.request.contextPath}/user?action=edit&id=${user.id}" class="btn btn-warning me-2">Edit Profile</a>
                        <a href="${pageContext.request.contextPath}/user?action=list" class="btn btn-secondary">Back to List</a>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- Include Bootstrap JS and dependencies -->
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
