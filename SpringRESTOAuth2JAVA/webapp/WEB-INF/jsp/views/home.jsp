<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>KSHRD CENTER  | HOME PAGE</title>
</head>
<body>
	<h1>KSHRD CENTER HOME PAGE</h1>
	<button id="btnGetStudent">GET A STUDENT</button>
	
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$(document).on('click', '#btnGetStudent', function(){
				$.ajax({
					type : "GET",
					url : "${pageContext.request.contextPath}/api/students",
					dataType : 'JSON',
					success : function(data) {
						console.log(data);
					},
					/* headers: {
					    "Authorization" : "Basic YWRtaW46YWRtaW4="
					}, */
					error : function(data) {
						console.log(data);
					}
				});
			});
		});
	</script>
</body>
</html>