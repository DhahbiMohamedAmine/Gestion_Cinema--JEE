<!DOCTYPE html>   
<html lang="fr">   
<head>  
<meta name="viewport" content="width=device-width, initial-scale=1">  
<title> Login Page </title>   
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="styles.css" rel="stylesheet"> <!-- Vous pouvez ajouter votre propre fichier CSS ici -->
</head>    
 
<body>
<form action="<%= request.getContextPath()  %>/Auth" method="post">
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">
                    Connexion Au Cinéma Mechergui
                </div>
                <div class="card-body">
                    <form>
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="email" class="form-control" id="email" placeholder="Votre email" name="email" required>
                        </div>
                        <div class="form-group">
                            <label for="password">Mot de passe</label>
                            <input type="password" class="form-control" id="password" placeholder="Votre mot de passe" name="password" required>
                        </div>
                        <button type="submit" class="btn btn-primary mt-2">Se connecter</button>
                        <br><p>Vous n'avez pas de compte? <a href="<%= request.getContextPath() %>/ServletUser/user/add">Inscrivez-Vous</a></p>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</form>


</body>
</html>
    
    
    