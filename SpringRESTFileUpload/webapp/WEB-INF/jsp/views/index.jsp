<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>STUDENT MANAGEMENT | FILE UPLOAD</title>
</head>
<body>
	<form class="cmxform form-horizontal tasi-form" id="frmProductAdd" enctype="multipart/form-data" method="POST" action="/rest/images/" novalidate="novalidate">
		<div class="form-group ">
           <label for="costprice" class="control-label col-lg-2">Image</label>
           <div class="col-lg-10">
               <input class="form-control " id="file" name="file" type="file" required="requrired">
               <button class="btn btn-primary waves-effect waves-light" type="submit">Save</button>
           </div>
        </div> 
	</form>
	<img src="" id="IMAGE"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/3.51/jquery.form.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#frmProductAdd").submit(function(e){
		e.preventDefault();    				
		$("#frmProductAdd").ajaxSubmit({
			url: "${pageContext.request.contextPath}/rest/images/",
			dataType: 'JSON', 
			type: 'POST',
			success: function(data) { 
				console.log(data);
		        if(data){
		        	$("#IMAGE").attr('src','${pageContext.request.contextPath}/resources/uploads/'+data.IMAGE);
		        	alert('YOU HAVE BEEN INSERTED SUCCESSFULLY.');
		        }else{
		        	alert('YOU HAVE ERRORS WHEN INSERT NEW PRODUCT.');
		        }
		    },
		    error:function(data,status,er) { 
		        console.log("error: "+data+" status: "+status+" er:"+er);
		    }
		});
	});
});
</script>
</body>
</html>