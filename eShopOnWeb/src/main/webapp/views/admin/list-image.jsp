<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/views/admin" var="url"></c:url>
<c:url value="/views/client/images" var="url2"></c:url>
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

<title>Danh sách ảnh sản phẩm</title>
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
	function deleteProductImage(id) {
		if(confirm("Bạn có muốn xóa "+id+" không")){
			window.location = "deleteProductImage?id="+id;
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
					<li class="breadcrumb-item"><a href="list-product">Product</a></li>
					<li class="breadcrumb-item active">Product Image Manage</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section dashboard">
			<div class="row">
				 <div class="card">
            <div class="card-body">
              	<h5 class="card-title">Danh mục ảnh sản phẩm</h5>
				<p style="color:red">${requestScope.error }</p>
				<p style="color:red">${requestScope.error2 }</p>
				
              <!-- Default Table -->
              <table id="myTable" class="table">
                <thead>
                  <tr>
                    <th>Tên sản phẩm</th>
                    <th>Ảnh </th>
					<th>Tên ảnh</th>
					<th>Mặc định (0- không, 1- có)</th>
					<th></th>
                  </tr>
                </thead>
                <tbody>
                	<c:set value="${imageM}" var="IM"></c:set>
                		<tr>
							<td>${ IM.product.productName }</td>
							<td><img src="${url2}/${IM.imagePath}" width="100"></td>
							<td>${ IM.imagePath }</td>
							<td>${IM.isDefault}</td>
							<td>
								<a href=""></a>
								<a href="#" onclick="deleteProductImage('${IM.imageId}')">Xóa</a>
							</td>
							<c:forEach items="${imageS}" var="IS">
		                		<tr>
		                			<td>${ IS.product.productName }</td>
									<td><img src="${url2}/${IS.imagePath}" width="100"></td>
									<td>${ IS.imagePath }</td>
									<td>${IS.isDefault}</td>
									<td>
										<a href="#" onclick="deleteProductImage('${IS.imageId}')">Xóa</a>
									</td>
								</tr>
		                	</c:forEach>  
						</tr> 
                </tbody>
              </table>
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