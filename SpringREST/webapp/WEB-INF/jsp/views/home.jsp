<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%-- 
<meta name="_csrf" content="${_csrf.token}"/>
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}"/> --%>

<title>KSHRD CENTER  | HOME PAGE</title>
</head>
<body>
	<h1>KSHRD CENTER HOME PAGE</h1>
	<form action="${pageContext.request.contextPath}/student" method="POST">
		<input type="text" name="name"/>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="TOKEN"/>
		<button type="submit"> Submit</button>
	</form>
	Student Name ${name }
	<button id="btnGetStudent">GET A STUDENT</button>
	
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$(document).on('click', '#btnGetStudent', function(){
				/* 
				var token = $("meta[name='_csrf']").attr("content");
				var header = $("meta[name='_csrf_header']").attr("content"); 
				*/
				var student ={
					"id": 1,
					"name" : "PHENG TOLA",
					"gender" : "MALE",
					"phone" : "012345678",
					"email" : "tolapheng99@gmail.com",
					"classroom" : "SR",
					"photo" : "penhchet.jpg"
				};
				$.ajax({
					type : "POST",
					url : "${pageContext.request.contextPath}/api/students",
					dataType : 'json',
					data : JSON.stringify(student),
					/* beforeSend: function(xhr) {
	                    xhr.setRequestHeader("X-CSRF-TOKEN", $("#TOKEN").val()),
	                    xhr.setRequestHeader('content-type', 'application/json')
	                },  */
					success : function(data) {
						console.log(data);
					},
					headers: {
					    "X-CSRF-TOKEN" : $("#TOKEN").val(),
					    "content-type" : "application/json"
					},   
					error : function(data) {
						console.log(data);
					}
				});
			});
		});
	</script>
</body>
</html>