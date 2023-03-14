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

<title>Danh sách sản phẩm</title>
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
	function deleteProduct(id) {
		if(confirm("Bạn có muốn xóa "+id+" không")){
			window.location = "deletep?id="+id;
		}
	}
</script>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.css">
  
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.js"></script>
<script src="//cdn.ckeditor.com/4.5.9/standard/ckeditor.js"></script>

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
					<li class="breadcrumb-item active">Product</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section dashboard">
			<div class="row">
				 <div class="card">
            <div class="card-body">
              	<h5 class="card-title">Danh mục sản phẩm</h5>
				<p style="color:red">${requestScope.error }</p>
				<p style="color:red">${requestScope.error2 }</p>
				<h5>
					<a href="#addProductModal" class="btn btn-success" data-toggle="modal">Thêm mới sản phẩm</a>
					<a href="#addProductDetailModal" class="btn btn-success" data-toggle="modal">Thêm mới thông tin chi tiết sản phẩm</a>
				</h5>
				
              <!-- Default Table -->
              <table id="myTable" class="table">
                <thead>
                  <tr>
                    <th>Mã sản phẩm</th>
					<th>Tên sản phẩm</th>
					<th>Giá</th>
					<th>Giá gốc</th>
					<th>Description( Mô tả)</th>
					<th>Trạng thái sản phẩm( Còn:1, hết:0)</th>
					<th>Mã loại sản phẩm</th>
					<th>Quản lý ảnh</th>
					<th>Quản lý màu</th>
					<th>Quản lý Rom</th>
					<th>Thông tin chi tiết</th>
					<th></th>
                  </tr>
                </thead>
                <tbody>
                	<c:forEach items="${products}" var="p">
                		<tr>
							<td>${ p.productId }</td>
							<td>${ p.productName }</td>
							<td>${ p.price }</td>
							<td>${ p.originalPrice }</td>
							<td>${ p.description }</td>
							<td>${ p.status }</td>
							<td>${ p.category.categoryId }</td>
							<td>
								<a href="list-productImage?id=${p.productId}" >Quản lý</a>
								<a href="addProductImageMain?id=${p.productId}" >+main</a>
								<a href="addProductImageSub?id=${p.productId}">+sub</a>
							</td>
							<td>
								<a href="list-productColor?id=${p.productId}" >Quản lý</a>
								<a href="addProductColor?id=${p.productId}" >+Màu</a>
							</td>
							<td>
								<a href="list-productSize?id=${p.productId}" >Quản lý</a>
								<a href="addProductSize?id=${p.productId}" >+Rom</a>
							</td>
							<td>
								<a href="updatep-detail?id=${p.productId}" >Sửa</a>
							</td>
							<td>
								<a href="updatep?id=${p.productId}" >Sửa</a>
								<a href="#" onclick="deleteProduct('${p.productId}')">Xóa</a>
							</td>
						</tr>
                	</c:forEach>                               
                </tbody>
              </table>
              	<!-- Add product modal -->
		<div id="addProductModal" class="modal fade">
			<div class="modal-dialog">
				<form action="addp">
					<!-- Modal-content -->
					<div class="modal-content">
					<!-- Modal Header -->
						<div class="model-header">
							<h4 class="modal-title">Thêm sản phẩm</h4>
	        				<button type="button" class="close" data-dismiss="modal">&times;</button>
						</div>
					 <!-- Modal body -->
						<div class="modal-body">
							<div class="form-group">
								<label>Mã sản phẩm</label>
								<input type="number" name="id" class="form-control">
							</div>
							<div class="form-group">
								<label>Tên sản phẩm</label>
								<input type="text" name="name" class="form-control">
							</div>
							<div class="form-group">
								<label>Giá</label>
								<input type="number" name="price" class="form-control">
							</div>
							<div class="form-group">
								<label>Giá gốc</label>
								<input type="number" name="originalPrice" class="form-control">
							</div>
							<div class="form-group">
								<label>Description( Mô tả)</label>
								<input type="text" name="description" class="form-control">
							</div>
							<div class="form-group">
								<label>Status( Trạng thái: 1-còn, 0-Hết)</label>
								<input type="number" name="status" class="form-control">
							</div>
							<div class="form-group">
								<label>Mã loại sản phẩm</label>
								<input type="number" name="categoryId" class="form-control">
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
		        	<!-- Add productDetail modal -->
		<div id="addProductDetailModal" class="modal fade">
			<div class="modal-dialog">
				<form action="addp-detail">
					<!-- Modal-content -->
					<div class="modal-content">
					<!-- Modal Header -->
						<div class="model-header">
							<h4 class="modal-title">Thêm thông tin chi tiết sản phẩm</h4>
	        				<button type="button" class="close" data-dismiss="modal">&times;</button>
						</div>
					 <!-- Modal body -->
						<div class="modal-body">
							<div class="form-group">
								<label>Mã sản phẩm</label>
								<input type="number" name="id" class="form-control" >
							</div>
							<div class="form-group">
								<label>Màn hình</label>
								<input type="text" name="monitor" class="form-control">
							</div>
							<div class="form-group">
								<label>Hệ điều hành</label>
								<input type="text" name="os" class="form-control">
							</div>
							<div class="form-group">
								<label>Camera sau</label>
								<input type="text" name="rearCamera" class="form-control">
							</div>
							<div class="form-group">
								<label>Camera trước</label>
								<input type="text" name="frontCamera" class="form-control">
							</div>
							<div class="form-group">
								<label>Chip</label>
								<input type="text" name="chip" class="form-control">
							</div>
							<div class="form-group">
								<label>Ram</label>
								<input type="text" name="ram" class="form-control">
							</div>
							<div class="form-group">
								<label>Bộ nhớ trong</label>
								<input type="text" name="rom" class="form-control">
							</div>
							<div class="form-group">
								<label>Sim</label>
								<input type="text" name="sim" class="form-control">
							</div>
							<div class="form-group">
								<label>Battery</label>
								<input type="text" name="battery" class="form-control">
							</div>
							<div class="form-group">
								<label>Charge</label>
								<input type="text" name="charge" class="form-control">
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
              <!-- End Default Table Example -->
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
	
	 <script>
  		CKEDITOR.replace( 'editor' );
 	 </script>

</body>

</html>