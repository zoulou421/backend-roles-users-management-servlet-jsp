<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error Page</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/5.3.3/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8d7da; /* Light red background for error */
        }
        .container {
            margin-top: 50px;
            background: white;
            border-radius: 8px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
            padding: 30px;
        }
        h2 {
            color: #721c24; /* Dark red for error message */
        }
        .btn {
            margin-right: 5px;
        }
    </style>
</head>
<body>
    <div class="container text-center">
        <h2 class="mb-4">An Error Occurred</h2>
        <p class="text-danger">Sorry, something went wrong. Please try again.</p>
        
        <!-- Back button using JavaScript -->
        <a href="javascript:window.history.back();" class="btn btn-secondary">Go Back</a>
        
        <!-- Optional: Redirect to home or another specific page -->
        <a href="${pageContext.request.contextPath}/home" class="btn btn-primary">Go to Home</a>
    </div>

    <script src="${pageContext.request.contextPath}/webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
