<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<style>
body {
	height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
	background-image: url("https://wallpaperaccess.com/full/1091583.jpg");
	background-size: cover;
	background-position: center;
}

.window {
	width: 300px;
	height: 350px;
	text-align: center;
	border: 1px solid white;
	border-radius: 20px;
	backdrop-filter: blur(30px) brightness(100%);
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	color: white;
}

input[type="txt"], input[type="password"] {
	border-radius: 8px;
	border: 1px solid white;
	color: white !important;
	background: transparent;
	width: 197px;
	height: 30px;
	padding-left: 20px;
}

form {
	width: 100%;
}

input[type="txt"]:focus, input[type="password"]:focus {
	background: #00000040;
	box-shadow: none;
	border: 1px solid white;
}

input[type="txt"]::placeholder, input[type="password"]::placeholder {
	color: white;
}

input[type="submit"] {
	width: 100%;
	border-radius: 8px;
	text-transform: uppercase;
	font-weight: bold;
	font-size: 14px;
}

button {
	border-radius: 8px;
	border: 1px solid white;
	color: white !important;
	background: transparent;
	width: 220px;
	height: 35px;
	padding-left: 40px;
	padding-right: 40px;
}

button:hover {
	background-image: url("Images/Background.jpg");
}

a {
	border-radius: 8px;
	border: 1px solid white;
	color: white;
	background: transparent;
	width: 220px;
	height: 35px;
	padding-left: 20px;
	padding-right: 20px;
	padding-bottom: 15px;
	 text-decoration: none;
}

a:hover, a:active {
	background-image: url("Images/Background.jpg");
}
</style>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng Ký</title>
<link rel="stylesheet" type="text/css" href="login.css">
</head>

<body>
	<center>
		<div class="window">
			<center>
				<h1 style="color: white">Đăng Ký</h1>
				<h4>${username}</h4>
				<h4>${mess1}</h4>
				<form method="POST" action="SignInServlet">
					<table>
						<tr>
							<td><input type="txt" placeholder="Tên Đăng Nhập"
								name="username" /></td>
						</tr>
						<tr>
							<td><input type="txt" placeholder="Giới Tính: Nam M/ Nữ F"
								name="gender" /></td>
						</tr>
						<tr>
							<td><input type="password" placeholder="Mật Khẩu"
								name="password" /></td>
						</tr>
						<tr>
							<td colspan="2"><button>Đăng Ký</button>
						</tr>
						<tr>
							<td><a href="LogIn.jsp">Đăng Nhập</a> <a href="Show">Quay
									Lại</a></td>
						</tr>
					</table>
				</form>
			</center>
		</div>
	</center>
</body>
</html>