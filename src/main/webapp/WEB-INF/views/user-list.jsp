<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


        <!-- Main Content -->
        <div class="container-fluid">
            <h2 class="mb-4 text-center">User List</h2>        
            <div class="text-end">
                <button onclick="printPage()" class="btn btn-info mb-3">Print User List</button>
            </div>
            <table class="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>User Name</th>
                        <th>Email</th>
                        <th>Roles</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${userList}">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.userName}</td>
                            <td>${user.email}</td>
                            <td>
                                <ul>
                                    <c:forEach var="role" items="${user.roles}">
                                        <li>${role.nom}</li>
                                    </c:forEach>
                                </ul>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/user?action=edit&id=${user.id}" class="btn btn-sm btn-primary">Edit</a>
                                <a href="${pageContext.request.contextPath}/user?action=delete&id=${user.id}" class="btn btn-sm btn-danger" onclick="return confirm('Are you sure you want to delete this user?')">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="${pageContext.request.contextPath}/user?action=add" class="btn btn-success">Add New User</a>
        </div>

    <!-- Bootstrap JS -->
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
    <script>
        function printPage() {
            window.print();
        }
    </script>
