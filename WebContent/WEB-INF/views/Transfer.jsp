<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>ProxiB.TRANSFER</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

    <!-- Custom styles for this template -->
    <link href="css/agency.min.css" rel="stylesheet">
	<style>
		body { background-image : url("https://images.unsplash.com/photo-1485627941502-d2e6429a8af0?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=63e790aefbc8909865fd39d97a3c46ba&auto=format&fit=crop&w=1350&q=80");
		background-repeat: repeat;
		background-size: cover;}
		
	</style>
  </head>

  <body id="page-top">

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
      <div class="container">
        <c:url var="indexURL" value="/index.html"/>
        <a class="navbar-brand js-scroll-trigger" href="${indexURL}">Retour Accueil</a>
      </div>
    </nav>

    <!-- Header -->
    <header class="masthead">
      <div class="container">
        <div class="intro-text">
          <div class="intro-heading text-uppercase">VIREMENT</div>
          
        </div>
      </div>
    </header>
    
    <h2 style="text-align:center">D�tails du Client</h2>
    <form style="text-align:center" method="post" action="">
    	<div>
    		<label for="account">Compte � D�biter</label> <select id="accountA" name="compteA">
    		<option label="-----" value=""/>
    		<c:forEach var="account" items="${accounts}">
    			<c:if test="${account.savings}">
    				<option 
    				label="Compte Courant - Num�ro : ${account.number} Solde : ${account.balance} &#8364"
    				value="${account.id}" />
    			</c:if>
    			<c:if test="${!account.savings}">
    				<option 
    				label="Compte Epargne - Num�ro : ${account.number} Solde : ${account.balance} &#8364"
    				value="${account.id}" />
    			</c:if>
    		</c:forEach>
    		</select>
    	</div>
    	<div>
    		<label for="account">Compte � Cr�diter</label> <select id="accountA" name="compteB">
    		<option label="-----" value=""/>
    		<c:forEach var="account" items="${accounts}">
    			<c:if test="${account.savings}">
    				<option 
    				label="Compte Courant - Num�ro : ${account.number} Solde : ${account.balance} &#8364"
    				value="${account.id}" />
    			</c:if>
    			<c:if test="${!account.savings}">
    				<option 
    				label="Compte Epargne - Num�ro : ${account.number} Solde : ${account.balance} &#8364"
    				value="${account.id}" />
    			</c:if>
    		</c:forEach>
    		</select>
    	</div>
    	<div>
    		<label for="montant">Montant du Virement : </label>
    		<input id="montant" name="montant" value="">
    	</div>
    	<button>Valider le Virement</button>
    </form>
    
  
    
    <!-- Footer -->
    <footer>
      <div class="container">
        <div class="row">
          <div class="col-md-4">
            <span class="copyright">Copyright &copy; Proxibanque 2018</span>
          </div>
          <div class="col-md-4">
            <ul class="list-inline social-buttons">
              <li class="list-inline-item">
                <a href="#">
                  <i class="fab fa-twitter"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#">
                  <i class="fab fa-facebook-f"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#">
                  <i class="fab fa-linkedin-in"></i>
                </a>
              </li>
            </ul>
          </div>
          <div class="col-md-4">
            <ul class="list-inline quicklinks">
              <li class="list-inline-item">
                <a href="#">Privacy Policy</a>
              </li>
              <li class="list-inline-item">
                <a href="#">Terms of Use</a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </footer>




 
  

   

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Contact form JavaScript -->
    <script src="js/jqBootstrapValidation.js"></script>
    <script src="js/contact_me.js"></script>

    <!-- Custom scripts for this template -->
    <script src="js/agency.min.js"></script>

  </body>

</html>
