<%@page import="dao.ProductImageDAO"%>
<%@page import="dao.ProductDAO"%>
<%@page import="model.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/views/client" var="url"></c:url>
<%
	ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
	if (cart_list != null) {
		request.setAttribute("cart_list", cart_list);
	}
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Product Detail</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="${url}/images/icons/favicon.png"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${url}/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${url}/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${url}/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${url}/fonts/linearicons-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${url}/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="${url}/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${url}/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${url}/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="${url}/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${url}/vendor/slick/slick.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${url}/vendor/MagnificPopup/magnific-popup.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${url}/vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${url}/css/util.css">
	<link rel="stylesheet" type="text/css" href="${url}/css/main.css">
<!--===============================================================================================-->
</head>
<body class="animsition">
	
	<!-- Header -->
	<header class="header-v4">
		<!-- Header desktop -->
		<div class="container-menu-desktop">
			<!-- Topbar -->
			<div class="top-bar">
				<div class="content-topbar flex-sb-m h-full container">
					<div class="left-top-bar">Free shipping all store</div>

					<div class="right-top-bar flex-w h-full">
						<a href="#" class="flex-c-m trans-04 p-lr-25"> Help & FAQs </a> 
						<a href="http://localhost:8080/eShopOnWeb/client/updateUser" class="flex-c-m trans-04 p-lr-25"> My Account </a> 
						<a href="#" class="flex-c-m trans-04 p-lr-25"> EN </a> 
						<a href="#" class="flex-c-m trans-04 p-lr-25"> USD </a>
					</div>
				</div>
			</div>

			<div class="wrap-menu-desktop">
				<nav class="limiter-menu-desktop container">

					<!-- Logo desktop -->
					<a href="http://localhost:8080/eShopOnWeb/home" class="logo"> <img
						src="${url}/images/icons/logo-01.png" alt="IMG-LOGO">
					</a>

					<!-- Menu desktop -->
					<div class="menu-desktop">
						<ul class="main-menu">
							<li class="active-menu"><a href="home">Home</a>

							<li><a href="#">Shop</a></li>

							<li class="label1" data-label1="hot"><a
								href="shoping-cart.html">Features</a></li>

							<li><a href="#">Blog</a></li>

							<li><a href="#">About</a></li>

							<li><a href="#">Contact</a></li>
						</ul>
					</div>

					<!-- Icon header -->
					<div class="wrap-icon-header flex-w flex-r-m">
						<div
							class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 js-show-modal-search">
							<i class="zmdi zmdi-search"></i>
						</div>

						<div
							class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 icon-header-noti"
							data-notify="${cart_list.size()}">
							<a href="/eShopOnWeb/views/client/cart.jsp"><i class="zmdi zmdi-shopping-cart text-dark"></i></a>
						</div>
					</div>
				</nav>
			</div>
		</div>

		<!-- Header Mobile -->
		<div class="wrap-header-mobile">
			<!-- Logo moblie -->
			<div class="logo-mobile">
				<a href="home"><img src="${url}/images/icons/logo-01.png"
					alt="IMG-LOGO"></a>
			</div>

			<!-- Icon header -->
			<div class="wrap-icon-header flex-w flex-r-m m-r-15">
				<div
					class="icon-header-item cl2 hov-cl1 trans-04 p-r-11 js-show-modal-search">
					<i class="zmdi zmdi-search"></i>
				</div>

				<div
					class="icon-header-item cl2 hov-cl1 trans-04 p-r-11 p-l-10 icon-header-noti js-show-cart"
					data-notify="2">
					<i class="zmdi zmdi-shopping-cart"></i>
				</div>

				<a href="#"
					class="dis-block icon-header-item cl2 hov-cl1 trans-04 p-r-11 p-l-10 icon-header-noti"
					data-notify="0"> <i class="zmdi zmdi-favorite-outline"></i>
				</a>
			</div>

			<!-- Button show menu -->
			<div class="btn-show-menu-mobile hamburger hamburger--squeeze">
				<span class="hamburger-box"> <span class="hamburger-inner"></span>
				</span>
			</div>
		</div>


		<!-- Menu Mobile -->
		<div class="menu-mobile">
			<ul class="topbar-mobile">
				<li>
					<div class="left-top-bar">Free shipping for standard order
						over $100</div>
				</li>

				<li>
					<div class="right-top-bar flex-w h-full">
						<a href="#" class="flex-c-m p-lr-10 trans-04"> Help & FAQs </a> <a
							href="#" class="flex-c-m p-lr-10 trans-04"> My Account </a> <a
							href="#" class="flex-c-m p-lr-10 trans-04"> EN </a> <a href="#"
							class="flex-c-m p-lr-10 trans-04"> USD </a>
					</div>
				</li>
			</ul>

			<ul class="main-menu-m">
				<li><a href="http://localhost:8080/eShopOnWeb/home">Home</a>
					<ul class="sub-menu-m">
						<li><a href="index.html">Homepage 1</a></li>
						<li><a href="home-02.html">Homepage 2</a></li>
						<li><a href="home-03.html">Homepage 3</a></li>
					</ul> <span class="arrow-main-menu-m"> <i
						class="fa fa-angle-right" aria-hidden="true"></i>
				</span></li>

				<li><a href="product.html">Shop</a></li>

				<li><a href="shoping-cart.html" class="label1 rs1"
					data-label1="hot">Features</a></li>

				<li><a href="blog.html">Blog</a></li>

				<li><a href="about.html">About</a></li>

				<li><a href="contact.html">Contact</a></li>
			</ul>
		</div>

		<!-- Modal Search -->
		<div class="modal-search-header flex-c-m trans-04 js-hide-modal-search">
			<div class="container-search-header">
				<button class="flex-c-m btn-hide-modal-search trans-04 js-hide-modal-search">
					<img src="${url}/images/icons/icon-close2.png" alt="CLOSE">
				</button>

				<form class="wrap-search-header flex-w p-l-15">
					<button class="flex-c-m trans-04">
						<i class="zmdi zmdi-search"></i>
					</button>
					<input class="plh3" type="text" name="search" placeholder="Search...">
				</form>
			</div>
		</div>
	</header>

	


	<!-- breadcrumb -->
	<div class="container">
		<div class="bread-crumb flex-w p-l-25 p-r-15 p-t-30 p-lr-0-lg">
			<a href="index.html" class="stext-109 cl8 hov-cl1 trans-04">
				Home
				<i class="fa fa-angle-right m-l-9 m-r-10" aria-hidden="true"></i>
			</a>

			<a href="product.html" class="stext-109 cl8 hov-cl1 trans-04">
				Detail
				<i class="fa fa-angle-right m-l-9 m-r-10" aria-hidden="true"></i>
			</a>
		</div>
	</div>
		

	<!-- Product Detail -->
	<section class="sec-product-detail bg0 p-t-65 p-b-60">
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-lg-7 p-b-30">
					<div class="p-l-25 p-r-30 p-lr-0-lg">
						<div class="wrap-slick3 flex-sb flex-w">
							<div class="wrap-slick3-dots"></div>
							<div class="wrap-slick3-arrows flex-sb-m flex-w"></div>

							<div class="slick3 gallery-lb">
							<c:set value="${requestScope.imageB }" var="imgB"></c:set>
								<div class="item-slick3" data-thumb="${url}/images/${imgB.imagePath}">
									<div class="wrap-pic-w pos-relative">
										<img src="${url}/images/${imgB.imagePath}" alt="IMG-PRODUCT">

										<a class="flex-c-m size-108 how-pos1 bor0 fs-16 cl10 bg0 hov-btn3 trans-04" href="${url}/images/${imgB.imagePath}">
											<i class="fa fa-expand"></i>
										</a>
									</div>
								</div>

							<c:forEach items="${requestScope.imageS }" var="imgS">
								<div class="item-slick3" data-thumb="${url}/images/${imgS.imagePath}">
								<div class="wrap-pic-w pos-relative">
									<img src="${url}/images/${imgS.imagePath}" alt="IMG-PRODUCT">

									<a class="flex-c-m size-108 how-pos1 bor0 fs-16 cl10 bg0 hov-btn3 trans-04" href="${url}/images/${imgS.imagePath}">
										<i class="fa fa-expand"></i>
									</a>
								</div>
								</div>
							</c:forEach>

							</div>
						</div>
					</div>
				</div>
				
				<div class="col-md-6 col-lg-5 p-b-30">
					<div class="p-r-50 p-t-5 p-lr-0-lg">
						<h4 class="mtext-105 cl2 js-name-detail p-b-14">
							${product.productName}
						</h4>

						<span class="mtext-106 cl2">
							Price: <fmt:formatNumber type="number" maxFractionDigits="2" value="${product.price}" /> đ
						</span>

						<div style="background: linear-gradient(90deg,#dd5e89,#f7bb97);border-radius: 10px">
							<p style="font-size: 22px;color: #fff;padding:10px 10px 0 0;margin: 10px;font-weight: 600">Đặc điểm nổi bật</p>
							<ul style="color: white;line-height: 2">
								<li style="justify-content:center;border-radius: 5px;margin: 10px">${product.description}</li>
							</ul>
						</div>
						<span class="cl2" style="font-family: sans-serif;font-weight: 700;font-size: 26px">
							Màu sắc
						</span>
						<div style="display: flex;justify-content: space-around;">
							<c:forEach items="${requestScope.productC}" var="color">
								<a style="border: 1px solid #e0e0e0;border-radius: 2px;background-color: ${color.colorName};color: #333;display: inline-block;font-size: 13px;
									min-width: 67px;padding: 0 15px;text-align: center;margin-bottom: 5px;margin-right: 2px;vertical-align: top;
									height: 36px;line-height: 36px;position: relative;"> 
								</a>
							</c:forEach>
						</div>
						<span class="cl2" style="font-family: sans-serif; font-weight: 700; font-size: 26px;display:block;margin-top: 20px"> 
							Bộ nhớ 
						</span>
						<c:forEach items="${requestScope.productS}" var="size">
							<a style="border: 1px solid #e0e0e0;border-radius: 2px;color: #333;display: inline-block;font-size: 13px;
								min-width: 67px;padding: 0 15px;text-align: center;margin-bottom: 5px;margin-right: 2px;vertical-align: top;
								height: 36px;line-height: 36px;position: relative;"> ${size.sizeName}
							</a>
						</c:forEach>
						
							<div class="flex-w flex-r-m p-b-10">
								<div class="size-204 flex-w flex-m respon6-next">

									<a href="add-to-cart?id=${product.productId}" data-id="${product.productId}" style="background-color: #abdbe3;"
								class="btn btn-success stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 m-t-20px">
								Add To Cart </a>
								</div>
							</div>	
						</div>
					</div>
				</div>
			</div>

			<div class="bor10 m-t-50 p-t-43 p-b-40">
				<!-- Tab01 -->
				<div class="tab01">
					<!-- Nav tabs -->
					<ul class="nav nav-tabs" role="tablist">
						<li class="nav-item p-b-10">
							<a class="nav-link active" data-toggle="tab" href="#description" role="tab">Description</a>
						</li>
					</ul>

				<div class="tab-content p-t-43">
						<!-- - -->
						<c:set value="${requestScope.detail}" var="detail"></c:set>
						<div class="how-pos2 p-lr-15-md" style="width: 700px">
							<p style="margin-top: 15px;margin-bottom: 0;line-height: 1.3;font-size: 20px;font-weight: bold;box-sizing: border-box;">Cấu hình chi tiết</p>
							<div style="padding: 15px 0;margin: 0;box-sizing: border-box;display: block;">
								<ul style="display: block;margin-bottom: 15px;box-sizing: border-box;
								margin-block-start: 1em;margin-block-end: 1em;margin-inline-start: 0px;margin-inline-end: 0px;padding-inline-start: 40px;">
									<li style="background-color: #f5f5f5;align-items: flex-start;display: flex;padding: 10px;box-sizing: border-box;text-align: -webkit-match-parent;">
										<p style="width: 140px;box-sizing: border-box;display: block;">Màn hình: </p>
										<div style="width: calc(100% - 140px);padding: 0 5px 0 25px !important;box-sizing: border-box;display: block;">
											<span style="box-sizing: border-box;">${detail.monitor}</span>
										</div>
									</li>
									<li style="background-color: #fff;;align-items: flex-start;display: flex;padding: 10px;box-sizing: border-box;text-align: -webkit-match-parent;">
										<p style="width: 140px;box-sizing: border-box;display: block;">Hệ điều hành: </p>
										<div style="width: calc(100% - 140px);padding: 0 5px 0 25px !important;box-sizing: border-box;display: block;">
											<span style="box-sizing: border-box;">${detail.os }</span>
										</div>
									</li>
									<li style="background-color: #f5f5f5;align-items: flex-start;display: flex;padding: 10px;box-sizing: border-box;text-align: -webkit-match-parent;">
										<p style="width: 140px;box-sizing: border-box;display: block;">Camera trước: </p>
										<div style="width: calc(100% - 140px);padding: 0 5px 0 25px !important;box-sizing: border-box;display: block;">
											<span style="box-sizing: border-box;">${detail.frontCamera }</span>
										</div>
									</li>
									<li style="background-color: #fff;;align-items: flex-start;display: flex;padding: 10px;box-sizing: border-box;text-align: -webkit-match-parent;">
										<p style="width: 140px;box-sizing: border-box;display: block;">Camera sau: </p>
										<div style="width: calc(100% - 140px);padding: 0 5px 0 25px !important;box-sizing: border-box;display: block;">
											<span style="box-sizing: border-box;">${detail.rearCamera }</span>
										</div>
									</li>
									<li style="background-color: #f5f5f5;align-items: flex-start;display: flex;padding: 10px;box-sizing: border-box;text-align: -webkit-match-parent;">
										<p style="width: 140px;box-sizing: border-box;display: block;">Chip: </p>
										<div style="width: calc(100% - 140px);padding: 0 5px 0 25px !important;box-sizing: border-box;display: block;">
											<span style="box-sizing: border-box;">${detail.chip }</span>
										</div>
									</li>
									<li style="background-color: #fff;;align-items: flex-start;display: flex;padding: 10px;box-sizing: border-box;text-align: -webkit-match-parent;">
										<p style="width: 140px;box-sizing: border-box;display: block;">RAM: </p>
										<div style="width: calc(100% - 140px);padding: 0 5px 0 25px !important;box-sizing: border-box;display: block;">
											<span style="box-sizing: border-box;">${detail.ram }</span>
										</div>
									</li>
									<li style="background-color: #f5f5f5;align-items: flex-start;display: flex;padding: 10px;box-sizing: border-box;text-align: -webkit-match-parent;">
										<p style="width: 140px;box-sizing: border-box;display: block;">Dung lượng lưu trữ: </p>
										<div style="width: calc(100% - 140px);padding: 0 5px 0 25px !important;box-sizing: border-box;display: block;">
											<span style="box-sizing: border-box;">${detail.rom }</span>
										</div>
									</li>
									<li style="background-color: #fff;;align-items: flex-start;display: flex;padding: 10px;box-sizing: border-box;text-align: -webkit-match-parent;">
										<p style="width: 140px;box-sizing: border-box;display: block;">Sim: </p>
										<div style="width: calc(100% - 140px);padding: 0 5px 0 25px !important;box-sizing: border-box;display: block;">
											<span style="box-sizing: border-box;">${detail.sim }</span>
										</div>
									</li>
									<li style="background-color: #f5f5f5;align-items: flex-start;display: flex;padding: 10px;box-sizing: border-box;text-align: -webkit-match-parent;">
										<p style="width: 140px;box-sizing: border-box;display: block;">Pin: </p>
										<div style="width: calc(100% - 140px);padding: 0 5px 0 25px !important;box-sizing: border-box;display: block;">
											<span style="box-sizing: border-box;">${detail.battery }</span>
										</div>
									</li>
									<li style="background-color: #fff;;align-items: flex-start;display: flex;padding: 10px;box-sizing: border-box;text-align: -webkit-match-parent;">
										<p style="width: 140px;box-sizing: border-box;display: block;">Sạc: </p>
										<div style="width: calc(100% - 140px);padding: 0 5px 0 25px !important;box-sizing: border-box;display: block;">
											<span style="box-sizing: border-box;">${detail.charge }</span>
										</div>
									</li>
								</ul>
							</div>
							
						</div>
					</div>
				</div>
			</div>

	</section>


	

<!-- ======= Footer ======= -->
	<%@include file="layout/footer.jsp" %>
	<!-- End Footer -->

	<!-- Back to top -->
	<div class="btn-back-to-top" id="myBtn">
		<span class="symbol-btn-back-to-top">
			<i class="zmdi zmdi-chevron-up"></i>
		</span>
	</div>

	<!-- Modal1 -->
	<div class="wrap-modal1 js-modal1 p-t-60 p-b-20">
		<div class="overlay-modal1 js-hide-modal1"></div>

		<div class="container">
			<div class="bg0 p-t-60 p-b-30 p-lr-15-lg how-pos3-parent">
				<button class="how-pos3 hov3 trans-04 js-hide-modal1">
					<img src="${url}/images/icons/icon-close.png" alt="CLOSE">
				</button>

				<div class="row">
					<div class="col-md-6 col-lg-7 p-b-30">
						<div class="p-l-25 p-r-30 p-lr-0-lg">
							<div class="wrap-slick3 flex-sb flex-w">
								<div class="wrap-slick3-dots"></div>
								<div class="wrap-slick3-arrows flex-sb-m flex-w"></div>

								<div class="slick3 gallery-lb">
									<div class="item-slick3" data-thumb="images/product-detail-01.jpg">
										<div class="wrap-pic-w pos-relative">
											<img src="${url}/images/product-detail-01.jpg" alt="IMG-PRODUCT">

											<a class="flex-c-m size-108 how-pos1 bor0 fs-16 cl10 bg0 hov-btn3 trans-04" href="images/product-detail-01.jpg">
												<i class="fa fa-expand"></i>
											</a>
										</div>
									</div>

									<div class="item-slick3" data-thumb="images/product-detail-02.jpg">
										<div class="wrap-pic-w pos-relative">
											<img src="${url}/images/product-detail-02.jpg" alt="IMG-PRODUCT">

											<a class="flex-c-m size-108 how-pos1 bor0 fs-16 cl10 bg0 hov-btn3 trans-04" href="images/product-detail-02.jpg">
												<i class="fa fa-expand"></i>
											</a>
										</div>
									</div>

									<div class="item-slick3" data-thumb="images/product-detail-03.jpg">
										<div class="wrap-pic-w pos-relative">
											<img src="${url}/images/product-detail-03.jpg" alt="IMG-PRODUCT">

											<a class="flex-c-m size-108 how-pos1 bor0 fs-16 cl10 bg0 hov-btn3 trans-04" href="images/product-detail-03.jpg">
												<i class="fa fa-expand"></i>
											</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					
					<div class="col-md-6 col-lg-5 p-b-30">
						<div class="p-r-50 p-t-5 p-lr-0-lg">
							<h4 class="mtext-105 cl2 js-name-detail p-b-14">
								Lightweight Jacket
							</h4>

							<span class="mtext-106 cl2">
								$58.79
							</span>

							<p class="stext-102 cl3 p-t-23">
								Nulla eget sem vitae eros pharetra viverra. Nam vitae luctus ligula. Mauris consequat ornare feugiat.
							</p>
							
							<!--  -->
							<div class="p-t-33">
								<div class="flex-w flex-r-m p-b-10">
									<div class="size-203 flex-c-m respon6">
										Size
									</div>

									<div class="size-204 respon6-next">
										<div class="rs1-select2 bor8 bg0">
											<select class="js-select2" name="time">
												<option>Choose an option</option>
												<option>Size S</option>
												<option>Size M</option>
												<option>Size L</option>
												<option>Size XL</option>
											</select>
											<div class="dropDownSelect2"></div>
										</div>
									</div>
								</div>

								<div class="flex-w flex-r-m p-b-10">
									<div class="size-203 flex-c-m respon6">
										Color
									</div>

									<div class="size-204 respon6-next">
										<div class="rs1-select2 bor8 bg0">
											<select class="js-select2" name="time">
												<option>Choose an option</option>
												<option>Red</option>
												<option>Blue</option>
												<option>White</option>
												<option>Grey</option>
											</select>
											<div class="dropDownSelect2"></div>
										</div>
									</div>
								</div>

								<div class="flex-w flex-r-m p-b-10">
									<div class="size-204 flex-w flex-m respon6-next">
										<div class="wrap-num-product flex-w m-r-20 m-tb-10">
											<div class="btn-num-product-down cl8 hov-btn3 trans-04 flex-c-m">
												<i class="fs-16 zmdi zmdi-minus"></i>
											</div>

											<input class="mtext-104 cl3 txt-center num-product" type="number" name="num-product" value="1">

											<div class="btn-num-product-up cl8 hov-btn3 trans-04 flex-c-m">
												<i class="fs-16 zmdi zmdi-plus"></i>
											</div>
										</div>

										<button class="flex-c-m stext-101 cl0 size-101 bg1 bor1 hov-btn1 p-lr-15 trans-04 js-addcart-detail">
											Add to cart
										</button>
									</div>
								</div>	
							</div>

							<!--  -->
							<div class="flex-w flex-m p-l-100 p-t-40 respon7">
								<div class="flex-m bor9 p-r-10 m-r-11">
									<a href="#" class="fs-14 cl3 hov-cl1 trans-04 lh-10 p-lr-5 p-tb-2 js-addwish-detail tooltip100" data-tooltip="Add to Wishlist">
										<i class="zmdi zmdi-favorite"></i>
									</a>
								</div>

								<a href="#" class="fs-14 cl3 hov-cl1 trans-04 lh-10 p-lr-5 p-tb-2 m-r-8 tooltip100" data-tooltip="Facebook">
									<i class="fa fa-facebook"></i>
								</a>

								<a href="#" class="fs-14 cl3 hov-cl1 trans-04 lh-10 p-lr-5 p-tb-2 m-r-8 tooltip100" data-tooltip="Twitter">
									<i class="fa fa-twitter"></i>
								</a>

								<a href="#" class="fs-14 cl3 hov-cl1 trans-04 lh-10 p-lr-5 p-tb-2 m-r-8 tooltip100" data-tooltip="Google Plus">
									<i class="fa fa-google-plus"></i>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

<!--===============================================================================================-->	
	<script src="${url}/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="${url}/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="${url}/vendor/bootstrap/js/popper.js"></script>
	<script src="${url}/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="${url}/vendor/select2/select2.min.js"></script>
	<script>
		$(".js-select2").each(function() {
			$(this).select2({
				minimumResultsForSearch : 20,
				dropdownParent : $(this).next('.dropDownSelect2')
			});
		})
	</script>
<!--===============================================================================================-->
	<script src="${url}/vendor/daterangepicker/moment.min.js"></script>
	<script src="${url}/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="${url}/vendor/slick/slick.min.js"></script>
	<script src="${url}/js/slick-custom.js"></script>
<!--===============================================================================================-->
	<script src="${url}/vendor/parallax100/parallax100.js"></script>
	<script>
		$('.parallax100').parallax100();
	</script>
<!--===============================================================================================-->
	<script src="${url}/vendor/MagnificPopup/jquery.magnific-popup.min.js"></script>
	<script>
		$('.gallery-lb').each(function() { // the containers for all your galleries
			$(this).magnificPopup({
				delegate : 'a', // the selector for gallery item
				type : 'image',
				gallery : {
					enabled : true
				},
				mainClass : 'mfp-fade'
			});
		});
	</script>
<!--===============================================================================================-->
	<script src="${url}/vendor/isotope/isotope.pkgd.min.js"></script>
<!--===============================================================================================-->
	<script src="${url}/vendor/sweetalert/sweetalert.min.js"></script>
	<script>
		$('.js-addwish-b2, .js-addwish-detail').on('click', function(e) {
			e.preventDefault();
		});

		$('.js-addwish-b2').each(
				function() {
					var nameProduct = $(this).parent().parent().find(
							'.js-name-b2').html();
					$(this).on('click', function() {
						swal(nameProduct, "is added to wishlist !", "success");

						$(this).addClass('js-addedwish-b2');
						$(this).off('click');
					});
				});

		$('.js-addwish-detail').each(
				function() {
					var nameProduct = $(this).parent().parent().parent().find(
							'.js-name-detail').html();

					$(this).on('click', function() {
						swal(nameProduct, "is added to wishlist !", "success");

						$(this).addClass('js-addedwish-detail');
						$(this).off('click');
					});
				});

		/*---------------------------------------------*/

		$('.js-addcart-detail').each(
				function() {
					var nameProduct = $(this).parent().parent().parent()
							.parent().find('.js-name-detail').html();
					$(this).on('click', function() {
						swal(nameProduct, "is added to cart !", "success");
					});
				});
	</script>
<!--===============================================================================================-->
	<script src="${url}/vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
	<script>
		$('.js-pscroll').each(function() {
			$(this).css('position', 'relative');
			$(this).css('overflow', 'hidden');
			var ps = new PerfectScrollbar(this, {
				wheelSpeed : 1,
				scrollingThreshold : 1000,
				wheelPropagation : false,
			});

			$(window).on('resize', function() {
				ps.update();
			})
		});
	</script>
<!--===============================================================================================-->
	<script src="${url}/js/main.js"></script>

</body>
</html>