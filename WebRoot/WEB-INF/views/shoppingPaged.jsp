<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'shopping.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<div id="navbar" class="collapse navbar-collapse navbar-ex1-collapse"
		style="{color:#fff;}">
		<ul class="nav navbar-nav side-nav">
			<li><a href="debt.do?t=login&pname=${user.name}">&nbsp;&nbsp;&nbsp;User
					${user.name}</a></li>
			<li class="active"><a href="#">&nbsp;&nbsp;&nbsp;Shopping</a></li>
			<li><a href="#">&nbsp;&nbsp;&nbsp;Info</a></li>
		</ul>
	</div>

	<div class="container">
		<div class="container-fluid">
			<h5 class="page-header">Shopping</h5>
			<form action="shopping/gettype">
				<div>
					<label>search</label> <input type="hidden" name="name"
						value="${user.name}"> <input class="form-signin"
						name="type">
					<button type="submit">search</button>
				</div>
			</form>
			<form action="debt.do" method="post" name="form1" id="form1">
				<div id="table1" class="row">
					<div class=" col-md-12" style="margin:0 10px 0 10px ">
						<label id="sjzl"></label> <label id="btn0"></label>
						<div style="float:right;margin:0 10px 0 10px ">
							<label>turn to </label> <input id="changePage" size="1"
								maxlength="4" /> <label>page </label> <a
								class="btn btn-inverse btn-xs" href="#" id="btn5"><i
								class="icon-trash icon-arrow-right"></i></a>
						</div>
					</div>
					<table class="table table-striped table-bordered text-center"
						id="mytable">
						<thead>
							<tr>
								<th class="text-center">Product Code</th>
								<th class="text-center">Product Name</th>
								<th class="text-center">ProductLine</th>
								<th class="text-center">Product Vendor</th>
								<th class="text-center">Product Description</th>
								<th class="text-center">Quantity In Stock</th>
								<th class="text-center">Buy Price</th>
								<th class="text-center">MSRP</th>
								<th class="text-center">operation</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="list" items="${lp}">
								<tr>
									<td>${list.productCode}</td>
									<td><a
										href="shopping/getdetail?code=${list.productCode}&name=${user.name}">${list.productName}</a></td>
									<td>${list.productLine}</td>
									<td>${list.productVendor}</td>
									<td>${list.productDescription}</td>
									<td>${list.quantityInStock}</td>
									<td>${list.buyPrice}</td>
									<td>${list.MSRP}</td>
									<td><a class="btn btn-inverse btn-xs"><i
											class="icon-edit icon-large"></i></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="pagination"
						style="float: right;margin: -10px 0px 0px 0px">
						<ul>
							<li class="previous"><a class="fui-arrow-left" href="#"
								id="btn2"></a></li>
							<li><a href="#" id="btn1">front page</a></li>
							<li><a href="#" id="btn4">end page</a></li>
							<li class="next"><a class="fui-arrow-right" href="#fakelink"
								id="btn3"></a></li>
						</ul>
					</div>
					<!-- /pagination -->

				</div>
			</form>
		</div>
		<a href="shopping/getdetail?start=1&totle=5">View Paged Table</a>  
		<a href="shopping/getdetail?start=1&totle=5">View Paged Table</a> 
		<a href="shopping/getdetail?start=1&totle=5">View Paged Table</a> 
	</div>
</body>
</html>
