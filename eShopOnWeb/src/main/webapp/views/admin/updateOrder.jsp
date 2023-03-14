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

  <title>Cập nhật đơn đặt hàng</title>
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
<script src="//cdn.ckeditor.com/4.5.9/standard/ckeditor.js"></script>
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
		<h1>Cập nhật đơn đặt hàng</h1>
		<c:set var="updateOrder" value="${requestScope.order}"></c:set>
		<form action="updateo" method="post">
			<div class="form-group">
				<label>Mã khách hàng</label>
				<input type="number" name="userId" class="form-control" readonly value="${updateOrder.user.userId}">
			</div>
			<div class="form-group">
				<label>Mã đơn hàng</label>
				<input type="number" name="id" class="form-control" readonly value="${updateOrder.orderId}">
			</div>
			<div class="form-group">
				<label>Tiền</label>
				<input type="number" name="totalMoney" class="form-control" value="${updateOrder.totalMoney }">
			</div>
			<div class="form-group">
				<label>Phương thức thanh toán</label>
				<select class="form-select" name="payment">
					<option selected>${updateOrder.payment }</option>
					<option>Chuyển khoản</option>
					<option>Tiền mặt</option>
				</select>
			</div>
			<div class="form-group">
				<label>Ngày đặt</label>
				<input type="date" name="bookingDate" class="form-control" value="${updateOrder.bookingDate }">
			</div>
			<div class="form-group">
				<label>Ngày giao mong muốn</label>
				<input type="date" name="deliveryDate" class="form-control" value="${updateOrder.deliveryDate }">
			</div>
			<div class="form-group">
				<label>Phương thức vận chuyển</label>
				<select class="form-select" name="shippingWay" >
					<option selected>${updateOrder.shippingWay }</option>
					<option>Tiết kiệm</option>
					<option>Nhanh</option>
				</select>
			</div>
			<div class="form-group">
				<label>Trạng thái</label>
				<input type="number" name="state" class="form-control" value="${updateOrder.state }">
			</div>
			<div class="form-group">
				<label>Màu</label>
				<select class="form-select" name="color" >
					<option selected>${updateOrder.color }</option>
					<option>Trắng</option>
					<option>Đen</option>
					<option>Vàng</option>
					<option>Special</option>
				</select>
			</div>
			<div class="form-group">
				<label>Rom</label>
				<select class="form-select" name="size" >
					<option value="" disabled selected>${updateOrder.size }</option>
					<option>64GB</option>
					<option>128GB</option>
					<option>256GB</option>
					<option>512GB</option>
					<option>1TB</option>
				</select>
			</div>
			<div class="form-group">
				<label>Lưu ý</label>
				<textarea name="note" class="form-control" >${updateOrder.note }</textarea>
			</div>
			<div class="form-group">
				<label>Phí vận chuyển</label>
				<input type="number" name="transportFee" class="form-control" value="${updateOrder.transportFee }">
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
  
  <script>
  	CKEDITOR.replace( 'editor' );
  </script>

</body>

</html>