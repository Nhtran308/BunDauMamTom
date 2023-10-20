<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Quản Lý Sản Phẩm</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <style>
img {
	width: 200px;
	height: 120px;
}
</style>
    <body>
        <div class="container">
            <div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-6"><h1>Quản Lý Sản Phẩm</h1></div>
					<div class="col-sm-6">
					<a href="Show"><button type="button" class="btn btn-primary">Trang Chủ</button></a>
					<a href="StaffServlet"><button type="button" class="btn btn-primary">Nhân Viên</button></a>
					<a href="#addProduct" class="btn btn-success"data-toggle="modal"><span>Thêm Sản Phẩm</span></a>
					</div>
					<div class="col-sm-6">
					</div>
				</div>
			</div>
			<table class="table table-striped table-hover">
                    <thead>
                        <tr>
                        	<th>ID</th>
                            <th>Tên</th>
                            <th>Hình</th>
                            <th>Mục</th>
                            <th>Giá</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${ListP}" var="ol">
                            <tr>
                            	<th>${ol.id}</th>
                                <th>${ol.name}</th>
                                <th><img src="${ol.image}"></th>
                                <th>${ol.type}</th>
                                <th>${ol.price} VNĐ</th>
                                <th>
                                    <a href="LoadProduct?id=${ol.id}"  class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Sửa">&#xE254;</i></a>
                                    <a href="DeleteServlet?id=${ol.id}" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Xóa">&#xE872;</i></a>
                                </th>
                            </tr>
                        </c:forEach>
                    </tbody>
            </table>
            </div>
        </div>
        <div id="addProduct" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="AddServlet" method="post">
                        <div class="modal-header">						
                            <h4 class="modal-title">Thêm Sản Phẩm</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
	                        <div class="form-group"><label>Id</label><input name="Id" type="text" class="form-control" required></div>					
	                        <div class="form-group"><label>Image</label><input name="Image" type="text" class="form-control" required></div>
	                        <div class="form-group"><label>Name</label><input name="Name" type="text" class="form-control" required></div>
	                        <div class="form-group"><label>Type</label><input name="Type" type="text" class="form-control" required></div>
	                        <div class="form-group"><label>Price</label><input name="Price" type="text" class="form-control" required></div>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Hủy">
                            <input type="submit" class="btn btn-success" value="Thêm">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    <script src="js/manager.js" type="text/javascript"></script>
</body>
</html>