<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Success</title>
    <!-- Include Bootstrap CSS -->
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/5.3.3/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #e9ecef;
        }
        .container {
            margin-top: 100px;
            background: white;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
            padding: 30px;
        }
        h2 {
            color: #28a745;
        }
    </style>
</head>
<body>
    <div class="container text-center">
        <h2 class="mb-4">Success!</h2>
        <p class="lead">Your operation has been completed successfully.</p>
        <a href="${pageContext.request.contextPath}/user?action=list" class="btn btn-primary">Go to User List</a>
        <a href="${pageContext.request.contextPath}/role?action=list" class="btn btn-secondary">Go to Role List</a>
    </div>

    <!-- Include Bootstrap JS and dependencies -->
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
