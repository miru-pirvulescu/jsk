<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="main.java.com.ontologyparser.KnowledgeModel" %>

<% KnowledgeModel JavaOntology = new KnowledgeModel(); %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
		
		<title>The Java Starter Kit</title>
	</head>
	
	<body>
	<br>
	<div class="container">
		<h1 style="text-align:center;">The Java Starter Kit</h1>
		
		<ul class="nav nav-tabs" id="myTab" role="tablist">
		  <li class="nav-item">
		    <a class="nav-link active" id="hello-tab" data-toggle="tab" href="#hello" role="tab" aria-controls="hello" aria-selected="true">Welcome!</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" id="types-tab" data-toggle="tab" href="#types" role="tab" aria-controls="types" aria-selected="false">1. Types and Variables</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" id="operators-tab" data-toggle="tab" href="#operators" role="tab" aria-controls="operators" aria-selected="false">2. Operators</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" id="conditional-statements-tab" data-toggle="tab" href="#conditionalstatements" role="tab" aria-controls="conditionalstatements" aria-selected="false">3. Conditional Statements</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" id="loop-statements-tab" data-toggle="tab" href="#loopstatements" role="tab" aria-controls="loopstatements" aria-selected="false">4. Loop Statements</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" id="objects-tab" data-toggle="tab" href="#objects" role="tab" aria-controls="objects" aria-selected="false">5. Objects</a>
		  </li>
		</ul>
		<div class="tab-content" id="myTabContent">
		  <div class="tab-pane fade show active" id="hello" role="tabpanel" aria-labelledby="hello-tab">
		  	<br>
		  	Welcome to the Java Starter Kit!<br><br>
		  	
		  	Here, you will learn the basics of coding in Java, as taught by Java itself!<br>
		  	This website was built using an ontology-based knowledge model designed from scratch as part of my Bachelor's final project.<br>
		  	Using a Java API called Apache Jena, I am collecting and inferring information from this ontology, in order to pass it on to the website, which is also written in Java!<br>
		  	This proves very little about the capabilities of this programming language. However, in order to get to the interesting parts, you will need to understand the basics.<br><br>
		  	
		  	How to use this website:
		  	<ul>
		  		<li>Go through the other tabs in sequence;</li>
		  		<li>Press on the button with the most suggestive title for the information that you seek;</li>
		  		<li>An information card will pop up, and you will be able to see a definition of the term, as well as some facts discovered by the reasoner.</li>
		  	</ul>
		  	
		  	
		  	Your feedback is very valuable! If you wish, please follow <a href="https://forms.office.com/Pages/ResponsePage.aspx?id=FM9wg_MWFky4PHJAcWVDVqTxqzhggAJJpuRUPhhtv_ZUN1FFSEFYSjJHRDNWUlZDOTA5MzNOOFg1Ri4u">this link</a> to answer a few questions about your experience at the end of your visit.<br><br>
		  	To start, please press on the button below to see what basic facts about Java can this system tell you.<br>
		  	<%= JavaOntology.getCategory("hello", "danger")%>

		  </div>
		  
		  
		  <!-- Here goes the tab data -->
		  <div class="tab-pane fade" id="types" role="tabpanel" aria-labelledby="types-tab">
		  	<%= JavaOntology.getCategory("types", "info")%>
		  </div>
		  <div class="tab-pane fade" id="operators" role="tabpanel" aria-labelledby="operators-tab">
		  	<%= JavaOntology.getCategory("operators", "warlightning")%>
		  </div>
		  <div class="tab-pane fade" id="conditionalstatements" role="tabpanel" aria-labelledby="conditional-statements-tab">
		  	<%= JavaOntology.getCategory("condstatements", "success")%>
		  </div>
		  <div class="tab-pane fade" id="loopstatements" role="tabpanel" aria-labelledby="loop-statements-tab">
		  	<%= JavaOntology.getCategory("loopstatements", "warning")%>
		  </div>
		  <div class="tab-pane fade" id="objects" role="tabpanel" aria-labelledby="objects-tab">
		  	<%= JavaOntology.getCategory("objects", "dark")%>
		  </div>
		</div>
		</div>
	</body>
	<footer class="footer" style="background-color: #808080; position: absolute; left: 0; bottom: 0; width: 100%">
		<div class="container">
			<div class="row">
				<div class="col-sm" style="color:white">
				
					Author: Miruna-Ioana Pîrvulescu<br>
					King's College London<br>
					Part of Final Project for BSc Computer Sicence with a Year in Industry<br>
					<a href="mailto:miruna-ioana.pirvulescu@kcl.ac.uk" style="color: white">miruna-ioana.pirvulescu@kcl.ac.uk</a>
				</div>
				<div class="col-sm">
					<img src="images/kcllogo.png" height="100px" style="float: right;">
				</div>
			</div>
        </div>
    </footer>
</html>