<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Bienvenue à la Bibliothèque</title>
  <!-- Bootstrap CSS CDN -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <!-- Bootstrap Icons CDN -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
  <!-- Custom CSS -->
  <style>
    .hero {
      background-image: url('https://img.freepik.com/premium-photo/diverse-group-students-working-together-modern-school-library-using-digital-tablet_236854-31681.jpg');
      background-size: cover;
      background-position: center;
      color: white;
      padding: 8rem 0;
      text-align: center;
    }
    .hero-overlay {
      background-color: rgba(34, 34, 34, 0.7);
      padding: 4rem 0;
    }
    .features i {
      color: #007bff;
      font-size: 2rem;
    }
    .features h3 {
      margin-top: 1rem;
      font-weight: 600;
    }
    .footer {
      background-color: #f8f9fa;
      padding: 2rem 0;
    }
  </style>
</head>
<body>

  <!-- Navbar -->
  <nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm">
    <div class="container">
      <a class="navbar-brand fw-bold" href="#">Gestion Bibliotheque</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ms-auto">
          <li class="nav-item">
            <a class="nav-link" href="#features">Fonctionnalites</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#about">A Propos</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/login">Connexion</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/register">Inscription</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Hero Section -->
  <section class="hero d-flex align-items-center">
    <div class="container hero-overlay rounded">
      <h1 class="display-4 fw-bold">Bienvenue dans votre Bibliotheque</h1>
      <p class="lead">Gerez efficacement vos livres, vos emprunts et vos membres.</p>
      <a href="#register" class="btn btn-outline-light btn-lg mt-4">Commencer</a>
    </div>
  </section>

  <!-- Features Section -->
  <section id="features" class="features py-5 text-center">
    <div class="container">
      <h2 class="fw-bold mb-4">Fonctionnalites Principales</h2>
      <div class="row g-4">
        <div class="col-md-4">
          <i class="bi bi-journal-bookmark"></i>
          <h3>Gestion des Livres</h3>
          <p>Ajoutez, modifiez et suivez facilement l inventaire de vos livres.</p>
        </div>
        <div class="col-md-4">
          <i class="bi bi-person-lines-fill"></i>
          <h3>Gestion des Membres</h3>
          <p>Créez et gerez les profils de membres pour une bibliotheque organisee.</p>
        </div>
        <div class="col-md-4">
          <i class="bi bi-arrow-repeat"></i>
          <h3>Suivi des Emprunts</h3>
          <p>Suivez les emprunts et les retours, et envoyez des rappels automatiques.</p>
        </div>
      </div>
    </div>
  </section>

  <!-- About Section -->
  <section id="about" class="about py-5 bg-light text-center">
    <div class="container">
      <h2 class="fw-bold mb-4">A Propos de Nous</h2>
      <p class="text-muted">
        Notre application aide les bibliotheques a rester organisees, a ameliorer l experience des membres , et a rendre la gestion des livres et des emprunts plus facile que jamais.
      </p>
    </div>
  </section>

  <!-- Footer -->
  <footer class="footer text-center">
    <div class="container">
      <p class="mb-1">© 2024 Votre Bibliotheque. Tous droits reserves.</p>
      <p class="text-muted">
        <a href="#contact">Contact</a> | <a href="#terms">Conditions d utilisation</a> | <a href="#privacy">Politique de Confidentialite</a>
      </p>
    </div>
  </footer>

  <!-- Bootstrap JS and Popper.js CDN -->
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"></script>
</body>
</html>
