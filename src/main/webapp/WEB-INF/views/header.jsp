<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User List with Charts, Cards, and Sidebar</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/5.3.3/css/bootstrap.min.css" rel="stylesheet">
    <!-- Include Chart.js -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <!-- Icon left menu -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha384-k6RqeWeci5ZR/Lv4MR0sA0FfDOM9v5MkQb95F7RV3kF5z5W7pD+ZvvZn7gAPzNFO" crossorigin="anonymous" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css" />
    
    <style>
        body {
            background-color: #f8f9fa;
            margin-left:200px;  
            margin-right:200px;   
        }
        .sidebar {
            height: 100vh;
            position: fixed;
            width: 200px;
            background-color: black;
            padding-top: 20px;
        }
        .sidebar a {
            color: white;
            display: block;
            padding: 10px 15px;
            text-decoration: none;
        }
        .sidebar a:hover {
            background-color: #0056b3;
        }
        .content {
            margin-left: 220px;
            padding: 20px;
        }
        .card-container {
            margin-bottom: 20px;
        }
        .chart-container {
            margin-bottom: 20px;
        }
        /* Dropdown menu styles */
        .sidebar .dropdown {
            padding-left: 15px;
        }
        .sidebar .dropdown-menu {
            background-color: #007bff;
            border: none;
        }
        .sidebar .dropdown-item {
            color: #e9ecef;
        }
        .sidebar .dropdown-item:hover {
            background-color: #0056b3;
            color: #ffffff;
        }
        canvas {
            max-height: 400px; /* Limit height of charts   #09203f <--- gradient*/
        }
    </style>
</head>
<body>
  <div style="background: linear-gradient(to top, white 0%, #537895 100%);">
    <!-- Include Bootstrap JavaScript (placed at the end of the body for performance) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-c6DFx6LwX7SN+IZaC9J4bSTIbFUG11WpfPEnOZbDOdTLM61XfOcUZ27tN6L5bP3B" crossorigin="anonymous"></script>
    <!-- Sidebar Menu -->
    <div class="sidebar">
        <h1 class="text-center text-white">Backend</h1>
        <a href="${pageContext.request.contextPath}/user">
            <i class="fas fa-tachometer-alt me-2"></i> Dashboard
        </a>
        <a href="${pageContext.request.contextPath}/user?action=list">
            <i class="fas fa-users me-2"></i> User Management
        </a>
        <a href="${pageContext.request.contextPath}/role">
            <i class="fas fa-user-shield me-2"></i> Role Management
        </a>

        <!-- Dropdown for Reports -->
        <div class="dropdown">
            <a class="dropdown-toggle" href="#" id="reportsDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                <i class="fas fa-chart-bar me-2"></i> Reports
            </a>
            <ul class="dropdown-menu" aria-labelledby="reportsDropdown">
                <li><a class="dropdown-item" href="#">User Activity Reports</a></li>
                <li><a class="dropdown-item" href="#">Sales Reports</a></li>
                <li><a class="dropdown-item" href="#">System Performance Reports</a></li>
                <li><a class="dropdown-item" href="#">Audit Logs</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="#">Custom Report</a></li>
            </ul>
        </div>

        <!-- Dropdown for Settings -->
        <div class="dropdown">
            <a class="dropdown-toggle" href="#" id="settingsDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                <i class="fas fa-cog me-2"></i> Settings
            </a>
            <ul class="dropdown-menu" aria-labelledby="settingsDropdown">
                <li><a class="dropdown-item" href="#">Profile Settings</a></li>
                <li><a class="dropdown-item" href="#">Account Settings</a></li>
                <li><a class="dropdown-item" href="#">Privacy Settings</a></li>
                <li><a class="dropdown-item" href="#">Notification Settings</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="#">Advanced Settings</a></li>
            </ul>
        </div>
        
        
        <!-- Dropdown for Settings -->
        <div class="dropdown">
            <a class="dropdown-toggle" href="#" id="settingsDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                <i class="fas fa-cog me-2"></i> App Features
            </a>
            <ul class="dropdown-menu" aria-labelledby="settingsDropdown">
                <li><a class="dropdown-item" href="#">Gérer réservations</a></li>
                <li><a class="dropdown-item" href="#">Gérer Système</a></li>
                <li><a class="dropdown-item" href="#">Consulter Creneaux</a></li>
                <li><a class="dropdown-item" href="#">Consulter notifications</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="#">Ajouter  Séance</a></li>
                <li><a class="dropdown-item" href="#">Consulter Creneaux</a></li>
                <li><a class="dropdown-item" href="#">Consulter notifications</a></li>
            </ul>
        </div>
        
        <!-- Dropdown for Settings -->
        <div class="dropdown">
            <a class="dropdown-toggle" href="#" id="settingsDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                <i class="fas fa-cog me-2"></i> Other Features
            </a>
            <ul class="dropdown-menu" aria-labelledby="settingsDropdown">
                   <li><a class="dropdown-item" href="#">Effectuer paiement</a></li>
                <li><a class="dropdown-item" href="#">Réserver  séance</a></li>
                <li><a class="dropdown-item" href="#">Envoyer notifications</a></li>
                <li><a class="dropdown-item" href="#">Consulter notifications</a></li>
                <li><a class="dropdown-item" href="#">Réserver  séances</a></li>
                <li><a class="dropdown-item" href="#">Annuler réservation</a></li>
                <li><a class="dropdown-item" href="#">Ajouter Salle</a></li>
            </ul>
        </div>
        
    </div>