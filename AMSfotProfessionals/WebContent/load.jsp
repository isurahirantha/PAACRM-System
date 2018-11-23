<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Efuture.lk AMS loading</title>
<link rel="shortcut icon" type="image/x-icon" href="favicon.ico">
<script>
window.setTimeout(function() {
    window.location = 'default.jsp';
  }, 5000);
</script>

<style>
	body {
	  background: #0d8aa5;
	}
	
	.loading {
	  position: absolute;
	  left: 50%;
	  top: 50%;
	  margin: -60px 0 0 -60px;
	  background: #fff;
	  width: 100px;
	  height: 100px;
	  border-radius: 100%;
	  border: 10px solid #19bee1;
	}
	.loading:after {
	  content: '';
	  background: trasparent;
	  width: 140%;
	  height: 140%;
	  position: absolute;
	  border-radius: 100%;
	  top: -20%;
	  left: -20%;
	  opacity: 0.7;
	  box-shadow: rgba(255, 255, 255, 0.6) -4px -5px 3px -3px;
	  animation: rotate 2s infinite linear;
	}
	
	@keyframes rotate {
	  0% {
	    transform: rotateZ(0deg);
	  }
	  100% {
	    transform: rotateZ(360deg);
	  }
	}
	
	.pos {
	  position: absolute;
	  left: 46%;
	  top: 78%;
	  margin: -60px 0 0 -60px;
	  color:#fff;
	}
	.text {
	  position: absolute;
	  left: 42%;
	  top: 88%;
	  margin: -60px 0 0 -60px;
	  color:#0d8aa5;
	  background-color:#fff;
	}
		
</style>
</head>
<body>
<div class="loading"></div>
<h1 class="pos"><kbd>www.E-future.lk</kbd></h1>
<h3 class="text">APPOINTMENT MANAGEMENT SYSTEM</h3>
</body>
</html>