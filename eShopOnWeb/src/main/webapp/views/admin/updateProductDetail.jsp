<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/views/admin" var="url"></c:url>
<%
// chức năng ngăn không cho truy cập trực tiếp vào /views/admin/index.jsp
	if(session.getAttribute("admin-username")==null){
		response.sendRedirect(request.getContextPath()+"/admin/login");
	}
%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Cập nhật sản phẩm</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="${url}/assets/img/favicon.png" rel="icon">
  <link href="${url}/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.gstatic.com" rel="preconnect">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="${url}/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="${url}/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="${url}/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
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
</head>
<body>

  <!-- ======= Header ======= -->
  <%@include file="layout/header.jsp" %>
  <!-- End header -->

  <!-- ======= Sidebar ======= -->
  <%@include file="layout/sidebar.jsp" %>
  <!-- End Sidebar-->
  
  <main id="main" class="main">
  
  <div class="container">
		<h1>Cập nhật thông tin chi tiết sản phẩm </h1>
		<c:set var="updateProductDetail" value="${requestScope.productDetail}"></c:set>
		<form action="updatep-detail" method="post">
			<div class="form-group">
				<label>Mã sản phẩm</label>
				<input type="number" name="id" class="form-control" readonly value="${updateProductDetail.product.productId}">
			</div>
			<div class="form-group">
				<label>Màn hình</label>
				<input type="text" name="monitor" class="form-control" value="${updateProductDetail.monitor}">
			</div>
			<div class="form-group">
				<label>Hệ điều hành</label>
				<input type="text" name="os" class="form-control" value="${updateProductDetail.os }">
			</div>
			<div class="form-group">
				<label>Camera sau</label>
				<input type="text" name="rearCamera" class="form-control" value="${updateProductDetail.rearCamera }">
			</div>
			<div class="form-group">
				<label>Camera trước</label>
				<input type="text" name="frontCamera" class="form-control" value="${updateProductDetail.frontCamera }">
			</div>
			<div class="form-group">
				<label>Chip</label>
				<input type="text" name="chip" class="form-control" value="${updateProductDetail.chip }">
			</div>
			<div class="form-group">
				<label>Ram</label>
				<input type="text" name="ram" class="form-control" value="${updateProductDetail.ram }">
			</div>
			<div class="form-group">
				<label>Bộ nhớ trong</label>
				<input type="text" name="rom" class="form-control" value="${updateProductDetail.rom }">
			</div>
			<div class="form-group">
				<label>Sim</label>
				<input type="text" name="sim" class="form-control" value="${updateProductDetail.sim }">
			</div>
			<div class="form-group">
				<label>Battery</label>
				<input type="text" name="battery" class="form-control" value="${updateProductDetail.battery }">
			</div>
			<div class="form-group">
				<label>Charge</label>
				<input type="text" name="charge" class="form-control" value="${updateProductDetail.charge }">
			</div>
			<div class="form-group">
				<input type="submit" class="btn btn-success" value="Lưu">
			</div>
		</form>
	</div>

  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
  <%@include file="layout/footer.jsp" %>
  <!-- End Footer -->

  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

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