<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/views/admin" var="url"></c:url>
<header id="header" class="header fixed-top d-flex align-items-center">

	<div class="d-flex align-items-center justify-content-between">
		<a href="${url}/index.jsp" class="logo d-flex align-items-center"> <img
			src="${url}/assets/img/logo.png" alt=""> <span
			class="d-none d-lg-block">eShop</span>
		</a> <i class="bi bi-list toggle-sidebar-btn"></i>
	</div>
	<!-- End Logo -->



	<nav class="header-nav ms-auto">
		<ul class="d-flex align-items-center">

			<li class="nav-item dropdown"><a class="nav-link nav-icon"
				href="#" data-bs-toggle="dropdown"> <i class="bi bi-bell"></i> <span
					class="badge bg-primary badge-number">0</span>
			</a> <!-- End Notification Icon -->

				<ul
					class="dropdown-menu dropdown-menu-end dropdown-menu-arrow notifications">
					<li class="dropdown-header">You have 0 new notifications <a
						href="#"><span class="badge rounded-pill bg-primary p-2 ms-2">View
								all</span></a>
					</li>
					<li class="dropdown-footer"><a href="#">Show all
							notifications</a></li>

				</ul> <!-- End Notification Dropdown Items --></li>
			<!-- End Notification Nav -->

			<li class="nav-item dropdown"><a class="nav-link nav-icon"
				href="#" data-bs-toggle="dropdown"> <i
					class="bi bi-chat-left-text"></i> <span
					class="badge bg-success badge-number">0</span>
			</a> <!-- End Messages Icon -->

				<ul
					class="dropdown-menu dropdown-menu-end dropdown-menu-arrow messages">
					<li class="dropdown-header">You have 0 new messages <a
						href="#"><span class="badge rounded-pill bg-primary p-2 ms-2">View
								all</span></a>
					</li>
					<li>
						<hr class="dropdown-divider">
					</li>
					<li class="dropdown-footer"><a href="#">Show all messages</a>
					</li>

				</ul> <!-- End Messages Dropdown Items --></li>
			<!-- End Messages Nav -->

			<li class="nav-item dropdown pe-3"><a
				class="nav-link nav-profile d-flex align-items-center pe-0" href="#"
				data-bs-toggle="dropdown"><span
					class="d-none d-md-block dropdown-toggle ps-2"></span>
			</a> <!-- End Profile Image Icon -->

				<ul
					class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
					<li>
						<hr class="dropdown-divider">
					</li>

					<li><a class="dropdown-item d-flex align-items-center"
						href="${pageContext.request.contextPath}/admin/logout"> <i class="bi bi-box-arrow-right"></i> <span>Đăng xuất</span>
					</a></li>

				</ul> <!-- End Profile Dropdown Items --></li>
			<!-- End Profile Nav -->

		</ul>
	</nav>
	<!-- End Icons Navigation -->

</header>