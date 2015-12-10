<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
	  xmlns:th="http://www.thymeleaf.org"
	  xmlns:sec="http://www.thymeleaf.org/thymeleaf-extrasspringsecurity3">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ADMINISTRATOR LOGIN PAGE</title>
  <!-- Bootstrap 3.3.5 -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/dist/css/AdminLTE.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/iCheck/square/blue.css">
  
  <%-- <link href="${pageContext.request.contextPath}/webjars/materializecss/0.97.0/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/> --%>

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body>
	<div class="container">
		<div class="row">
			<h1 style="text-align:center;">ADMINISTRATOR ARTICLES</h1>
			You are logged as <b sec:authentication="name" /> with roles 
			<span sec:authentication="authorities" />
			<div class="pull-right">
				<button type="button" id="btnAddNew" class="btn btn-success btn-flat">Add New Article</button>
			</div>
			<table class="table table-responsive" id="tblListAllArticles">
				<thead>
					<tr>
						<th>ID</th>
						<th>Title</th>
						<th>Content</th>
						<th>Created Date</th>
						<th>Created By</th>
						<th>Status</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
				
				</tbody>
			</table>
		</div>
		<div class="row">
			<div class="col-sm-2">
				<select id="perPage" class="form-control">
					<option value="15">15</option>
					<option value="30">30</option>
					<option value="50">50</option>
					<option value="100">100</option>
				</select>
			</div>
			<div class="col-sm-10">
				<div id="articlePagination" class="pull-right">
				
				</div>
			</div>
		</div>
	</div>
	<div id="modalArticle" style="display:none; width:70%">       
  		<div class="modal-content"> 
  			<div class="modal-header">                                          
            	<button type="button" class="close" aria-hidden="true"><span class="button b-close"><span>×</span></span></button>
                <h4 class="modal-title"><strong>Article Information Details</strong></h4>
           	</div>
            <div class="modal-body">
            	<form class="form-horizontal" role="form">
					<div class="form-group">
				    	<label class="control-label col-sm-2" for="txtId">ID:</label>
				    	<div class="col-sm-10">
				      		<input type="text" class="form-control" id="txtId" placeholder="Enter id">
				    	</div>
				  	</div>
				  	<div class="form-group">
				  		<label class="control-label col-sm-2" for="txtTitle">Title:</label>
			    		<div class="col-sm-10"> 
			      			<input type="text" class="form-control" id="txtTitle" placeholder="Enter Title">
			    		</div>
				  	</div>
				  	<div class="form-group">
				  		<label class="control-label col-sm-2" for="txtContent">Content:</label>
			    		<div class="col-sm-10"> 
			      			<input type="text" class="form-control" id="txtContent" placeholder="Enter Content">
			    		</div>
				  	</div>
				  	<div class="form-group"  id="rowCreatedBy">
				  		<label class="control-label col-sm-2" for="txtCreatedBy">Created By:</label>
			    		<div class="col-sm-10"> 
			      			<input type="text" class="form-control" id="txtCreatedBy">
			    		</div>
				  	</div>
				  	<div class="form-group" id="rowCreatedDate">
				  		<label class="control-label col-sm-2" for="txtCreatedDate">Created Date:</label>
			    		<div class="col-sm-10"> 
			      			<input type="text" class="form-control" id="txtCreatedDate">
			    		</div>
				  	</div>
				  	<div class="form-group">
				  		<label class="control-label col-sm-2" for="txtStatus">Status:</label>
			    		<div class="col-sm-10"> 
			    			<select class="form-control" id="txtStatus">
			    				<option value="1">Active</option>
			    				<option value="0">Inactive</option>
			    			</select>
			    		</div>
				  	</div>
				</form>
			</div>
			<div class="modal-footer">
				<div align="right">
					<button type="button" id="btnUpdateSave" class="btn btn-primary btn-flat">Save</button>
					<button type="button" id="btnClose" class="btn btn-default btn-flat"><span class="button b-close"><span>Close</span></span></button>		
				</div>
			</div>
		</div>
	</div>
	<div id="modalMessage" style="display:none; width:50%">       
  		<div class="modal-content"> 
  			<div class="modal-header">                                          
            	<button type="button" class="close" aria-hidden="true"><span class="button b-close"><span>×</span></span></button>
                <h4 class="modal-title"><strong>Message</strong></h4>
           	</div>
            <div class="modal-body">
            	<h4>Do you want to delete?</h4>
            </div>
			<div class="modal-footer">
				<div align="right">
					<button type="button" id="btnOK" class="btn btn-primary btn-flat">Ok</button>
					<button type="button" id="btnClose" class="btn btn-default btn-flat"><span class="button b-close"><span>Close</span></span></button>		
				</div>
			</div>
		</div>
	</div>
	<script type="text/x-jquery-tmpl" id="tmplListAllArticles">
    	<tr>
			<td>{{= id}}</td>
			<td>{{= title}}</td>
			<td>{{= content}}</td>
			<td>{{= createdDate}}</td>
			<td>{{= createdBy}}</td>
			<td>{{= status}}</td>
			<td>
				<button class="btn btn-warning btn-flat" data-id="{{= id}}" id="btnView">View</button>
				<button class="btn btn-primary btn-flat" data-id="{{= id}}" id="btnUpdate">Update</button>
				<button class="btn btn-danger btn-flat" data-id="{{= id}}" id="btnDelete">Delete</button>
			</td>
		</tr>
    </script> 
	<!-- jQuery 2.1.4 -->
	<script src="${pageContext.request.contextPath}/resources/plugins/jQuery/jQuery-2.1.3.min.js"></script>
	<!-- Bootstrap 3.3.5 -->
	<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
	<!-- iCheck -->
	<script src="${pageContext.request.contextPath}/resources/plugins/iCheck/icheck.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascripts/jquery.tmpl.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascripts/jquery.bootpag.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascripts/jquery.bpopup.min.js"></script>
	<script>
		$(function() {
			// TODO: TO DECLARE THE ARTICLES OBJECT
			var articles = {}
			// TODO: TO CHECK WHEN WE SHOULD GENERATE THE PAGINATION
			// IF TRUE WE GENERATE ELSE WE ARE NOT GENERATE
			var check = true;
			
			// TODO: GET ALL ARTICLES 
			// PARAMS: currentPage int
			articles.getAllArticles = function(currentPage){
				$.ajax({ 
				    url: "${pageContext.request.contextPath}/articles/", 
				    type: 'GET', 
				    dataType: 'JSON', 
				    data: {
				    	"currentPage" : currentPage,
				    	"perPage" : $("#perPage").val()
				    },  
				    beforeSend: function(xhr) {
	                    xhr.setRequestHeader("Accept", "application/json");
	                    xhr.setRequestHeader("Content-Type", "application/json");
	                },
				    success: function(data) { 
				    	 $("#tblListAllArticles tbody").empty();
                         $("#tmplListAllArticles").tmpl(data.articles).appendTo("#tblListAllArticles tbody");
                         if(check){
                        	 articles.pagination(data.pagination.totalPages, 1);
                        	 check = false;
                         }
				    },
				    error:function(data,status,er) { 
				        console.log("error: "+data+" status: "+status+" er:"+er);
				    }
				});				
			};
			
			// TODO: GET A ARTICLE BY ID
			// PARAMS: id int
			articles.getArticleById = function(id){
				var article = {};
				$.ajax({ 
				    url: "http://localhost:8080/06_12_2015_WebServiceServer/rest/admin/articles/"+id, 
				    type: 'GET', 
				    dataType: 'JSON', 
				    beforeSend: function(xhr) {
				    	xhr.setRequestHeader("Authorization", "Basic S0FfV0VCX0FQSV9LRVk6MjRiY2NiMzMtYjI3ZC00YTVkLTk3YjEtMWFmNzhkNTZkMzQ3");
	                    xhr.setRequestHeader("Accept", "application/json");
	                    xhr.setRequestHeader("Content-Type", "application/json");
	                },
				    success: function(data) { 
				    	console.log(data);
				    	article = data.article;
				    	$("#txtId").val(data.article.id);
				    	$("#txtTitle").val(data.article.title);
				    	$("#txtContent").val(data.article.content);
				    	$("#txtCreatedBy").val(data.article.createdBy);
				    	$("#txtCreatedDate").val(data.article.createdDate);
				    	$("#txtStatus").val(data.article.status);
						$("#modalArticle").bPopup();
				    },
				    error:function(data,status,er) { 
				        console.log("error: "+data+" status: "+status+" er:"+er);
				    }
				});				
			};
			
			// TODO: UPDATE ARTICLE
			// PARAMS: id int
			articles.updateArticle = function(id){
				var article = {
					"title" : $("#txtTitle").val(),
					"content" : $("#txtContent").val(),
					"status" : $("#txtStatus").val()
				};
				$.ajax({ 
				    url: "http://localhost:8080/06_12_2015_WebServiceServer/rest/admin/articles/"+id, 
				    type: 'PUT', 
				    dataType: 'JSON', 
				    data : JSON.stringify(article),
				    beforeSend: function(xhr) {
				    	xhr.setRequestHeader("Authorization", "Basic S0FfV0VCX0FQSV9LRVk6MjRiY2NiMzMtYjI3ZC00YTVkLTk3YjEtMWFmNzhkNTZkMzQ3");
	                    xhr.setRequestHeader("Accept", "application/json");
	                    xhr.setRequestHeader("Content-Type", "application/json");
	                },
				    success: function(data) { 
				    	console.log(data);
				    	if(data.status){
				    		check = true;
				    		articles.getAllArticles(1);
				    		$("#modalArticle").bPopup().close();
				    	}else{
				    		alert("ERROR");
				    	}
				    },
				    error:function(data,status,er) { 
				        console.log("error: "+data+" status: "+status+" er:"+er);
				    }
				});				
			};
			
			// TODO: GET A ARTICLE BY ID
			// PARAMS: id int
			articles.deleteArticleById = function(id){
				var article = {};
				$.ajax({ 
				    url: "http://localhost:8080/06_12_2015_WebServiceServer/rest/admin/articles/"+id, 
				    type: 'DELETE', 
				    dataType: 'JSON', 
				    beforeSend: function(xhr) {
	                    xhr.setRequestHeader("Accept", "application/json");
	                    xhr.setRequestHeader("Content-Type", "application/json");
	                },
				    success: function(data) { 
				    	console.log(data);
				    	if(data.status){
				    		check = true;
				    		articles.getAllArticles(1);
				    		$("#modalMessage").bPopup().close();
				    	}else{
				    		alert("ERROR");
				    	}
				    },
				    error:function(data,status,er) { 
				        console.log("error: "+data+" status: "+status+" er:"+er);
				    }
				});				
			};
			
			// TODO: TO GENERATE THE PAGINATION
			// PARAMS : totalPages  int
			//			currentPage int
			articles.pagination = function(totalPages, currentPage){
				$('#articlePagination').bootpag({
		            total: totalPages,
		            page: currentPage,
		            maxVisible: 15
		        }).on("page", function(event, num){
		             articles.getAllArticles(num, false);
		        });
			};
								
			// TODO: TO GET ALL ARTICLES WHEN THE PAGE IS LOADED
			articles.getAllArticles(1);
			
			// TODO: EVENTS HANLDER
			// TODO: WHEN THE PER PAGE CHANGE
			$("#perPage").change(function(){
				check=true;
				articles.getAllArticles(1);
			});
			
			// TODO: WHEN CLICK ON THE INSERT FORM
			$(document).on('click','#btnAddNew', function(){
				$("#rowCreatedDate").hide();
				$("#rowCreatedBy").hide();
				$("#txtId").val("");
		    	$("#txtTitle").val("");
		    	$("#txtContent").val("");
		    	$("#txtStatus").val(1);
				$("#txtId").removeAttr("readonly");
		    	$("#txtTitle").removeAttr("readonly");
		    	$("#txtContent").removeAttr("readonly");
		    	$("#txtStatus").removeAttr("readonly");
				$("#modalArticle").bPopup();
			});
			
			// TODO: WHEN CLICK ON THE VIEW BUTTON TO VIEW THE ARTICLE INFORMATION DETAILS
			$(document).on('click','#btnView', function(){
				var article = articles.getArticleById($(this).data('id'));
				$("#rowCreatedDate").show();
				$("#rowCreatedBy").show();
				$("#btnUpdateSave").hide();
				$("#txtId").attr("readonly","readonly");
		    	$("#txtTitle").attr("readonly","readonly");
		    	$("#txtContent").attr("readonly","readonly");
		    	$("#txtCreatedBy").attr("readonly","readonly");
		    	$("#txtCreatedDate").attr("readonly","readonly");
		    	$("#txtStatus").attr("readonly","readonly");
			});
			
			// TODO: WHEN CLICK ON THE UPDATE BUTTON TO OPEN THE UPDATE VIEW
			$(document).on('click','#btnUpdate', function(){
				articles.getArticleById($(this).data('id'));
				$("#rowCreatedDate").hide();
				$("#rowCreatedBy").hide();
				$("#txtId").removeAttr("readonly");
		    	$("#txtTitle").removeAttr("readonly");
		    	$("#txtContent").removeAttr("readonly");
		    	$("#txtCreatedBy").removeAttr("readonly");
		    	$("#txtCreatedDate").removeAttr("readonly");
		    	$("#txtStatus").removeAttr("readonly");
		    	$("#btnUpdateSave").show();
			});
			
			$(document).on('click','#btnUpdateSave', function(){
				articles.updateArticle($("#txtId").val());
			});
			
			$(document).on('click','#btnDelete', function(){
				$("#modalMessage").bPopup();
				$("#btnOK").data("id", $(this).data("id"));
			});
			
			$(document).on('click','#btnOK', function(){
				articles.deleteArticleById($(this).data("id"));		
			});
			
			$(document).on('click', '#btnClose', function(){
				$("#modalMessage").bPopup().close();
			});
		});
	</script>
</body>
</html>