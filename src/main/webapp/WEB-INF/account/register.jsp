<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Inscription</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <!-- Registration Form -->
  <div class="container py-5">
    <h2 class="text-center mb-4">Créer un Compte</h2>
    <div class="row justify-content-center">
      <div class="col-md-6">
        <form action="${pageContext.request.contextPath}/user" method="post">
          <div class="mb-3">
            <label for="userName" class="form-label">Nom</label>
            <input type="text" class="form-control" id="userName" name="userName" placeholder="Entrez votre nom">
          </div>
          <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Entrez votre email">
          </div>
          <div class="mb-3">
            <label for="password" class="form-label">Mot de Passe</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Entrez votre mot de passe">
          </div>
          <div class="mb-3">
            <label for="confirmPassword" class="form-label">Confirmer le Mot de Passe</label>
            <input type="password" class="form-control" id="confirmPassword" placeholder="Confirmez votre mot de passe">
          </div>
          <button type="submit" class="btn btn-primary w-100">S'inscrire</button>
        </form>
        <p class="text-center mt-3">Déjà un compte ? <a href="${pageContext.request.contextPath}/login">Connexion</a></p>
      </div>
    </div>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"></script>
</body>
</html>
