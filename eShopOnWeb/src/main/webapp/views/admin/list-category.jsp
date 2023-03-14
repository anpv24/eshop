<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/views/admin" var="url"></c:url>
<%
	if(session.getAttribute("admin-username")==null){
		response.sendRedirect(request.getContextPath()+"/admin/login");
	}
%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Danh sách loại sản phẩm</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="${url}/assets/img/favicon.png" rel="icon">
<link href="${url}/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link href="https://fonts.gstatic.com" rel="preconnect">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="${url}/assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${url}/assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link href="${url}/assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link href="${url}/assets/vendor/quill/quill.snow.css" rel="stylesheet">
<link href="${url}/assets/vendor/quill/quill.bubble.css" rel="stylesheet">
<link href="${url}/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
<link href="${url}/assets/vendor/simple-datatables/style.css" rel="stylesheet">

<!-- Template Main CSS File -->
<link href="${url}/assets/css/style.css" rel="stylesheet">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">
	function deleteCategory(id) {
		if(confirm("Bạn có muốn xóa "+id+" không")){
			window.location = "deletec?id="+id;
		}
	}
</script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.css">
  
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.js"></script>
 
<script>
    $(document).ready(function () {
        $('#myTable').DataTable();
    });
</script>
</head>

<body>

	<!-- ======= Header ======= -->
	<%@include file="layout/header.jsp" %>
	<!-- End Header -->

	<!-- ======= Sidebar ======= -->
	<%@include file="layout/sidebar.jsp" %>
	<!-- End Sidebar-->

	<main id="main" class="main">

		<div class="pagetitle">
			<h1>Dashboard</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="${url}/index.jsp">Home</a></li>
					<li class="breadcrumb-item active">Category</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section dashboard">
			<div class="row">
				 <div class="card">
            <div class="card-body">
              	<h5 class="card-title">Danh mục loại sản phẩm</h5>
				<p style="color:red">${requestScope.error }</p>
				<h5><a href="#addCategoryModal" class="btn btn-success" data-toggle="modal">Thêm mới</a></h5>
              <!-- Default Table -->
              <table id="myTable" class="table">
                <thead>
                  <tr>
                    <th scope="col">Mã sản phẩm</th>
                    <th scope="col">Tên mã sản phẩm</th>
                    <th scope="col">Trạng thái(0: hết, 1- còn)</th>
                    <th></th>
                  </tr>
                </thead>
                <tbody>
                	<c:forEach items="${categories}" var="c">
                		<tr>
		                    <td>${c.categoryId}</td>
		                    <td>${c.categoryName}</td>
		                    <td>${c.status}</td>
		                    <td>
								<a href="updatec?id=${c.categoryId}">Sửa</a>
								<a href="#" onclick="deleteCategory('${c.categoryId}')">Xóa</a>
							</td>
	                  </tr>
                	</c:forEach>                               
                </tbody>
              </table>
              <!-- End Default Table Example -->
              		<!-- Add category modal -->
		<div id="addCategoryModal" class="modal fade">
			<div class="modal-dialog">
				<form action="addc">
					<!-- Modal-content -->
					<div class="modal-content">
					<!-- Modal Header -->
						<div class="model-header">
							<h4 class="modal-title">Thêm loại sản phẩm</h4>
	        				<button type="button" class="close" data-dismiss="modal">&times;</button>
						</div>
					 <!-- Modal body -->
						<div class="modal-body">
							<div class="form-group">
								<label>Mã loại sản phẩm</label>
								<input type="number" name="id" class="form-control">
							</div>
							<div class="form-group">
								<label>Tên loại sản phẩm</label>
								<input type="text" name="name" class="form-control">
							</div>
							<div class="form-group">
								<label>Trạng thái(1: còn hàng, 0: hết hàng)</label>
								<input type="number" name="status" class="form-control">
							</div>
		      			</div>
		      		<!-- Modal footer -->
						<div class="modal-footer">
							<div class="form-group">
								<input type="submit" class="btn btn-success" value="Lưu">
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
            </div>
          </div>
			</div>			
		</section>

	</main>
	<!-- End #main -->

	<!-- ======= Footer ======= -->
	<%@include file="layout/footer.jsp" %>
	<!-- End Footer -->

	<a href="#"
		class="back-to-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<!-- Vendor JS Files -->
	<script src="${url}/assets/vendor/apexcharts/apexcharts.min.js"></script>
	<script src="${url}/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="${url}/assets/vendor/chart.js/chart.min.js"></script>
	<script src="${url}/assets/vendor/echarts/echarts.min.js"></script>
	<script src="${url}/assets/vendor/quill/quill.min.js"></script>
	<script src="${url}/assets/vendor/simple-datatables/simple-datatables.js"></script>
	<script src="${url}/assets/vendor/tinymce/tinymce.min.js"></script>
	<script src="${url}/assets/vendor/php-email-form/validate.js"></script>

	<!-- Template Main JS File -->
	<script src="${url}/assets/js/main.js"></script>

</body>

</html>