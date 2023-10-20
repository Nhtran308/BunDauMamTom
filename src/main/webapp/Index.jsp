<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<style>
.p {
	font-family: Brush Script MT;
	font-size: 150px;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trang Chủ</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<link href="style.css" rel="stylesheet" type="text/css" />
</head>

<body style="background-color: #c1c1c1;">
	<nav class="navbar navbar-expand-md navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="Show">09-CNPM2</a>
			<div class="collapse navbar-collapse justify-content-end"
				id="navbarsExampleDefault">
				<ul class="navbar-nav m-auto">
					<c:if test="${sessionScope.acc != null}">
						<li class="nav-item"><a class="nav-link text-white" href="#">Xin
								chào ${sessionScope.acc.userName} </a></li>
						<li class="nav-item"><a class="nav-link text-white">|</a></li>
						<li class="nav-item"><a class="nav-link text-white"
							href="StaffServlet">Nhân Viên</a></li>
							<li class="nav-item"><a class="nav-link text-white">|</a></li>
						<li class="nav-item"><a class="nav-link text-white"
							href="QuanlyServlet">Sản Phẩm</a></li>
						<li class="nav-item"><a class="nav-link text-white">|</a></li>
						<li class="nav-item"><a class="nav-link text-white"
							href="LogOutServlet">Đăng Xuất</a></li>
						<li class="nav-item"><a class="nav-link text-white">|</a></li>
						<li class="nav-item"><a class="nav-link text-white"
							href="SignIn.jsp">Đăng Ký</a></li>
					</c:if>
					<c:if test="${sessionScope.acc == null}">
						<li class="nav-item"><a class="nav-link text-white"
							href="LogIn.jsp">Đăng Nhập</a></li>
					</c:if>
				</ul>
				<form action="Search" method="post" class="form-inline my-2 my-lg-0">
					<div class="input-group input-group-sm">
						<input name="txtSearch" type="text" class="form-control"
							aria-label="Small" aria-describedby="inputGroup-sizing-sm"
							placeholder="Tìm kiếm">
						<div class="input-group-append">
							<button type="submit" class="btn btn-secondary btn-number">
								<i class="fa fa-search"></i>
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</nav>

	<section
		class="jumbotron text-center p-3 mb-2 bg-transparent text-dark">
		<h1 class="p">Bun Dau CoCo</h1>
	</section>

	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<div class="card bg-dark mb-3">
					<div class="card-header bg-dark text-white text-uppercase">
						<i class="fa fa-list"></i> Thực Đơn
					</div>
					<ul class="list-group category_block">
						<li class="list-group-item bg-secondary"><a
							class="text-white text-uppercase" href="Show">Tất Cả</a></li>
						<li class="list-group-item bg-secondary"><a
							class="text-white text-uppercase" href="Menu?type=Món Chính">Món
								Chính</a></li>
						<li class="list-group-item bg-secondary"><a
							class="text-white text-uppercase" href=" Menu?type=Lẩu">Lẩu</a></li>
						<li class="list-group-item bg-secondary"><a
							class="text-white text-uppercase" href="Menu?type=Bún">Bún</a></li>
						<li class="list-group-item bg-secondary"><a
							class="text-white text-uppercase" href="Menu?type=Ăn Vặt">Ăn
								Vặt</a></li>
						<li class="list-group-item bg-secondary"><a
							class="text-white text-uppercase" href="Menu?type=Nước Uống">Nước
								Uống</a></li>
						<li class="list-group-item bg-secondary"><a
							class="text-white text-uppercase" href="Menu?type=Tráng Miệng">Tráng
								Miệng</a></li>
					</ul>
				</div>
				<div class="card bg-light mb-3">

					<img class="img-fluid" src="Images/GIF.gif" />
				</div>
			</div>
			<div class="col-sm-9">
				<div class="row">
					<c:forEach items="${ListP}" var="ol">
						<div class="col-12 col-md-6 col-lg-6">
							<div class="card bg-secondary">
								<img class="card-img-top" src="${ol.image}" alt="Card image cap">
								<div class="card-body">
									<center>
										<h4 class="card-title show_txt">
											<a>${ol.name }</a>
										</h4>
									</center>
									<div class="row">
										<div class="col">
											<p class="btn btn-dark btn-block">${ol.price}VNĐ</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<footer class="text-light">
		<nav class="navbar  navbar-dark bg-dark"></nav>
	</footer>
</body>
</html>
