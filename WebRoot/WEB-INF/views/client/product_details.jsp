<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Bootshop online Shopping cart</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<base href="<%=basePath%>">
<!--Less styles -->
<!-- Other Less css file //different less files has different color scheam
	<link rel="stylesheet/less" type="text/css" href="themes/less/simplex.less">
	<link rel="stylesheet/less" type="text/css" href="themes/less/classified.less">
	<link rel="stylesheet/less" type="text/css" href="themes/less/amelia.less">  MOVE DOWN TO activate
	-->
<!--<link rel="stylesheet/less" type="text/css" href="themes/less/bootshop.less">
	<script src="themes/js/less.js" type="text/javascript"></script> -->

<!-- Bootstrap style -->
<link id="callCss" rel="stylesheet"
	href="themes/bootshop/bootstrap.min.css" media="screen" />
<link href="themes/css/base.css" rel="stylesheet" media="screen" />
<!-- Bootstrap style responsive -->
<link href="themes/css/bootstrap-responsive.min.css" rel="stylesheet" />
<link href="themes/css/font-awesome.css" rel="stylesheet"
	type="text/css">
<!-- Google-code-prettify -->
<link href="themes/js/google-code-prettify/prettify.css"
	rel="stylesheet" />
<!-- fav and touch icons -->
<link rel="shortcut icon" href="themes/images/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="themes/images/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="themes/images/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="themes/images/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="themes/images/ico/apple-touch-icon-57-precomposed.png">
<style type="text/css" id="enject"></style>
</head>
<body>
	<div id="header">
		<div class="container">
			<div id="welcomeLine" class="row">
				<div class="span6">
					Welcome!<strong> ${user.name }</strong>
				</div>
				<div class="span6">
					<div class="pull-right">
						<a href="shopping/checkcart?name=${user.name}"><span
							class="btn btn-mini btn-primary"><i
								class="icon-shopping-cart icon-white"></i> [ ${cartitem} ] Items
								in your cart </span> </a>
					</div>
				</div>
			</div>
			<!-- Navbar ================================================== -->
			<div id="logoArea" class="navbar">
				<a id="smallScreen" data-target="#topMenu" data-toggle="collapse"
					class="btn btn-navbar"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a>
				<div class="navbar-inner">
					<a class="brand" href="helloworld2?name=${user.name}"><img
						src="themes/images/logo.png" alt="Bootsshop" /></a>
					<form class="form-inline navbar-search" method="post"
						action="products.html">
						<input id="srchFld" class="srchTxt" type="text" /> <select
							class="srchTxt">
							<option>All</option>
							<option>CARS</option>
							<option>MOTORCYCLES</option>
							<option>WATER VEHICALS</option>
							<option>TRAINS</option>
							<option>TRUCKS & BUSSES</option>
							<option>PLAINS</option>
						</select>
						<button type="submit" id="submitButton" class="btn btn-primary">Go</button>
					</form>
					<ul id="topMenu" class="nav pull-right">
						<li class=""><a href="normal.html">Delivery</a></li>
						<li class=""><a href="contact.html">Contact</a></li>
						<li class=""><a href="#login" role="button"
							data-toggle="modal" style="padding-right:0"><span
								class="btn btn-large btn-success">Login</span></a>
							<div id="login" class="modal hide fade in" tabindex="-1"
								role="dialog" aria-labelledby="login" aria-hidden="false">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">×</button>
									<h3>Login Block</h3>
								</div>
								<div class="modal-body">
									<form class="form-horizontal loginFrm">
										<div class="control-group">
											<input type="text" id="inputEmail" placeholder="Email">
										</div>
										<div class="control-group">
											<input type="password" id="inputPassword"
												placeholder="Password">
										</div>
										<div class="control-group">
											<label class="checkbox"> <input type="checkbox">
												Remember me
											</label>
										</div>
									</form>
									<button type="submit" class="btn btn-success">Sign in</button>
									<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
								</div>
							</div></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- Header End====================================================================== -->
	<div id="mainBody">
		<div class="container">
			<div class="row">
				<!-- Sidebar ================================================== -->
				<div id="sidebar" class="span3">
					<div class="well well-small">
						<a id="myCart" href="shopping/checkcart?user=${user.name}"><img
							src="themes/images/ico-cart.png" alt="cart">${cartitem}
							Items in your cart <span class="badge badge-warning pull-right">$${cartprice}</span></a>
					</div>
					<ul id="sideManu" class="nav nav-tabs nav-stacked">

						<li class="subMenu"><a> CARS [${pc.cars }]</a>
							<ul>
								<li><a class="active"
									href="type/classiccars?name=${user.name}"><i
										class="icon-chevron-right"></i>Classic Cars
										(${pc.classicCars}) </a></li>
								<li><a href="type/vintagecars?name=${user.name}"><i
										class="icon-chevron-right"></i> Vintage Cars
										(${pc.vintageCars})</a></li>
							</ul></li>

						<li><a href="type/motorcycles?name=${user.name}">MOTORCYCLES
								(${pc.motorcycles})</a></li>

						<li class="subMenu"><a> WATER VEHICALS [${pc.waters}]</a>
							<ul style="display:none">
								<li><a href="type/ships?name=${user.name}"><i
										class="icon-chevron-right"></i>Ships (${pc.ships})</a></li>
								<li><a href="type/boats?name=${user.name}"><i
										class="icon-chevron-right"></i> Boats (${pc.boats})</a></li>
							</ul></li>
						<li><a href="type/trains?name=${user.name}">TRAINS
								[${pc.trains}]</a></li>
						<li><a href="type/truckbus?name=${user.name}">TRUCKS ANS
								BUSSES [${pc.truckandbus}]</a></li>
						<li><a href="type/plains?name=${user.name}">PLAINS
								[${pc.plains}]</a></li>
					</ul>
					<br />
					<div class="thumbnail">
						<img src="themes/images/payment_methods.png"
							title="Payment Methods" alt="Payments Methods">
						<div class="caption">
							<h5>Payment Methods</h5>
						</div>
					</div>
				</div>
				<!-- Sidebar end=============================================== -->
				<div class="span9">
					<ul class="breadcrumb">
						<li><a href="index.html">Home</a> <span class="divider">/</span></li>
						<li><a href="products.html">Products</a> <span
							class="divider">/</span></li>
						<li class="active">product Details</li>
					</ul>
					<div class="row">
						<div id="gallery" class="span3">
							<a href="${lp.picurl}" title="${lp.productName}"> <img
								src="${lp.picurl}" style="width:100%" alt= />
							</a>
							<div id="differentview" class="moreOptopm carousel slide">
								<div class="carousel-inner">
									<div class="item active">
										<a href=${lp.picurl }> <img style="width:29%"
											src=${lp.picurl } alt="" /></a>
									</div>
								</div>
								<!--  
			  <a class="left carousel-control" href="#myCarousel" data-slide="prev">‹</a>
              <a class="right carousel-control" href="#myCarousel" data-slide="next">›</a> 
			  -->
							</div>

							<div class="btn-toolbar">
								<div class="btn-group">
									<span class="btn"><i class="icon-envelope"></i></span> <span
										class="btn"><i class="icon-print"></i></span> <span
										class="btn"><i class="icon-zoom-in"></i></span> <span
										class="btn"><i class="icon-star"></i></span> <span class="btn"><i
										class=" icon-thumbs-up"></i></span> <span class="btn"><i
										class="icon-thumbs-down"></i></span>
								</div>
							</div>
						</div>
						<div class="span6">
							<h3>${lp.productName }</h3>
							<small>Code: ${lp.productCode}</small>
							<hr class="soft" />
							<form class="form-horizontal qtyFrm" action="shopping/addcart">
								<div class="control-group">
									<label class="control-label"><span>$
											${lp.buyPrice}</span><br> <small>MSRP: $${lp.MSRP}</small></label>
									<div class="controls">
										<input type="number" name="qty" class="span1"
											placeholder="Qty." /> <input type="hidden" name="code"
											value="${lp.productCode }" /> <input type="hidden"
											name="user" value="${user.name }" />
										<button type="submit"
											class="btn btn-large btn-primary pull-right">
											Add to cart <i class=" icon-shopping-cart"></i>
										</button>
									</div>
								</div>
							</form>

							<hr class="soft" />
							<h4>${lp.quantityInStock}itemsinstock</h4>
							<hr class="soft clr" />
							<p>${lp.productDescription}</p>
							<hr class="soft" />
						</div>

						<div class="span9">
							<ul id="productDetail" class="nav nav-tabs">
								<li class="active"><a href="#home" data-toggle="tab">Product
										Details</a></li>
								<li><a href="#profile" data-toggle="tab">Related
										Products</a></li>
							</ul>
							<div id="myTabContent" class="tab-content">
								<div class="tab-pane fade active in" id="home">
									<h4>Product Information</h4>
									<table class="table table-bordered">
										<tbody>
											<tr class="techSpecRow">
												<th colspan="2">Product Details</th>
											</tr>
											<tr class="techSpecRow">
												<td class="techSpecTD1">Vendor:</td>
												<td class="techSpecTD2">${lp.productVendor}</td>
											</tr>
											<tr class="techSpecRow">
												<td class="techSpecTD1">Product Line:</td>
												<td class="techSpecTD2">${lp.productLine}</td>
											</tr>
											<tr class="techSpecRow">
												<td class="techSpecTD1">Scale:</td>
												<td class="techSpecTD2">${lp.productScale}</td>
											</tr>
											<tr class="techSpecRow">
												<td class="techSpecTD1">Display size:</td>
												<td class="techSpecTD2">1</td>
											</tr>
										</tbody>
									</table>

									<h5>Features</h5>
									<p>
										${lp.productDescription }<br /> OND363338
									</p>

									<h4>Editorial Reviews</h4>
									<h5>Manufacturer's Description</h5>
									<p>With a generous 18x Fujinon optical zoom lens, the S2950
										really packs a punch, especially when matched with its 14
										megapixel sensor, large 3.0" LCD screen and 720p HD (30fps)
										movie capture.</p>

									<h5>Electric powered Fujinon 18x zoom lens</h5>
									<p>The S2950 sports an impressive 28mm – 504mm* high
										precision Fujinon optical zoom lens. Simple to operate with an
										electric powered zoom lever, the huge zoom range means that
										you can capture all the detail, even when you're at a
										considerable distance away. You can even operate the zoom
										during video shooting. Unlike a bulky D-SLR, bridge cameras
										allow you great versatility of zoom, without the hassle of
										carrying a bag of lenses.</p>
									<h5>Impressive panoramas</h5>
									<p>With its easy to use Panoramic shooting mode you can get
										creative on the S2950, however basic your skills, and rest
										assured that you will not risk shooting uneven landscapes or
										shaky horizons. The camera enables you to take three
										successive shots with a helpful tool which automatically
										releases the shutter once the images are fully aligned to
										seamlessly stitch the shots together in-camera. It's so easy
										and the results are impressive.</p>

									<h5>Sharp, clear shots</h5>
									<p>Even at the longest zoom settings or in the most
										challenging of lighting conditions, the S2950 is able to
										produce crisp, clean results. With its mechanically stabilised
										1/2 3", 14 megapixel CCD sensor, and high ISO sensitivity
										settings, Fujifilm's Dual Image Stabilisation technology
										combines to reduce the blurring effects of both hand-shake and
										subject movement to provide superb pictures.</p>
								</div>
								<div class="tab-pane fade" id="profile">
									<div id="myTab" class="pull-right">
										<a href="#listView" data-toggle="tab"><span
											class="btn btn-large"><i class="icon-list"></i></span></a> <a
											href="#blockView" data-toggle="tab"><span
											class="btn btn-large btn-primary"><i
												class="icon-th-large"></i></span></a>
									</div>
									<br class="clr" />
									<hr class="soft" />
									<div class="tab-content">
										<div class="tab-pane" id="listView">
											<c:forEach var="list" items="${lc}">
												<div class="row">
													<div class="span2">
														<img src="${list.picurl }" alt="" />
													</div>
													<div class="span4">
														<h3>New | Available</h3>
														<hr class="soft" />
														<h5>${list.productName }</h5>
														<p>${list.productDescription }</p>
														<a class="btn btn-small pull-right"
															href="shopping/getdetail?name=${user.name }&code=${list.productCode}">View
															Details</a> <br class="clr" />
													</div>
													<div class="span3 alignR">
														<form class="form-horizontal qtyFrm">
															<h3>$${list.buyPrice }</h3>
															<br />
															<div class="btn-group">
																<a
																	href="shopping/addcart?user=${user.name }&code=${list.productCode}&qty=1"
																	class="btn btn-large btn-primary"> Add to <i
																	class=" icon-shopping-cart"></i></a> <a
																	href="shopping/getdetail?name=${user.name }&code=${list.productCode}"
																	class="btn btn-large"><i class="icon-zoom-in"></i></a>
															</div>
														</form>
													</div>
												</div>
											</c:forEach>
											<hr class="soft" />
										</div>
										<div class="tab-pane active" id="blockView">
											<ul class="thumbnails">
												<c:forEach var="list" items="${lc}">
													<li class="span3">
														<div class="thumbnail">
															<a
																href="shopping/getdetail?name=${user.name }&code=${list.productCode}"><img
																src="${list.picurl }" alt="" /></a>
															<div class="caption">
																<h5>${list.productName }</h5>
																<%-- <p>${list.productDescription }</p> --%>
																<h4 style="text-align:center">
																	<a class="btn"
																		href="shopping/getdetail?name=${user.name }&code=${list.productCode}">
																		<i class="icon-zoom-in"></i>
																	</a> <a class="btn"
																		href="shopping/addcart?user=${user.name }&code=${list.productCode}&qty=1">Add
																		to <i class="icon-shopping-cart"></i>
																	</a> <a class="btn btn-primary" href="#">$${list.buyPrice}</a>
																</h4>
															</div>
														</div>
													</li>
												</c:forEach>
											</ul>
											<hr class="soft" />
										</div>
									</div>
									<br class="clr">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- MainBody End ============================= -->
	<!-- Footer ================================================================== -->
	<div id="footerSection">
		<div class="container">
			<div class="row">
				<div class="span3">
					<h5>ACCOUNT</h5>
					<a href="login.html">YOUR ACCOUNT</a> <a href="login.html">PERSONAL
						INFORMATION</a> <a href="login.html">ADDRESSES</a> <a
						href="login.html">DISCOUNT</a> <a href="login.html">ORDER
						HISTORY</a>
				</div>
				<div class="span3">
					<h5>INFORMATION</h5>
					<a href="contact.html">CONTACT</a> <a href="register.html">REGISTRATION</a>
					<a href="legal_notice.html">LEGAL NOTICE</a> <a href="tac.html">TERMS
						AND CONDITIONS</a> <a href="faq.html">FAQ</a>
				</div>
				<div class="span3">
					<h5>OUR OFFERS</h5>
					<a href="#">NEW PRODUCTS</a> <a href="#">TOP SELLERS</a> <a
						href="special_offer.html">SPECIAL OFFERS</a> <a href="#">MANUFACTURERS</a>
					<a href="#">SUPPLIERS</a>
				</div>
				<div id="socialMedia" class="span3 pull-right">
					<h5>SOCIAL MEDIA</h5>
					<a href="#"><img width="60" height="60"
						src="themes/images/facebook.png" title="facebook" alt="facebook" /></a>
					<a href="#"><img width="60" height="60"
						src="themes/images/twitter.png" title="twitter" alt="twitter" /></a>
					<a href="#"><img width="60" height="60"
						src="themes/images/youtube.png" title="youtube" alt="youtube" /></a>
				</div>
			</div>
			<p class="pull-right">&copy; Bootshop</p>
		</div>
		<!-- Container End -->
	</div>
	<!-- Placed at the end of the document so the pages load faster ============================================= -->
	<script src="themes/js/jquery.js" type="text/javascript"></script>
	<script src="themes/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="themes/js/google-code-prettify/prettify.js"></script>

	<script src="themes/js/bootshop.js"></script>
	<script src="themes/js/jquery.lightbox-0.5.js"></script>

	<!-- Themes switcher section ============================================================================================= -->
	<div id="secectionBox">
		<link rel="stylesheet" href="themes/switch/themeswitch.css"
			type="text/css" media="screen" />
		<script src="themes/switch/theamswitcher.js" type="text/javascript"
			charset="utf-8"></script>
		<div id="themeContainer">
			<div id="hideme" class="themeTitle">Style Selector</div>
			<div class="themeName">Oregional Skin</div>
			<div class="images style">
				<a href="themes/css/#" name="bootshop"><img
					src="themes/switch/images/clr/bootshop.png"
					alt="bootstrap business templates" class="active"></a> <a
					href="themes/css/#" name="businessltd"><img
					src="themes/switch/images/clr/businessltd.png"
					alt="bootstrap business templates" class="active"></a>
			</div>
			<div class="themeName">Bootswatch Skins (11)</div>
			<div class="images style">
				<a href="themes/css/#" name="amelia" title="Amelia"><img
					src="themes/switch/images/clr/amelia.png"
					alt="bootstrap business templates"></a> <a href="themes/css/#"
					name="spruce" title="Spruce"><img
					src="themes/switch/images/clr/spruce.png"
					alt="bootstrap business templates"></a> <a href="themes/css/#"
					name="superhero" title="Superhero"><img
					src="themes/switch/images/clr/superhero.png"
					alt="bootstrap business templates"></a> <a href="themes/css/#"
					name="cyborg"><img src="themes/switch/images/clr/cyborg.png"
					alt="bootstrap business templates"></a> <a href="themes/css/#"
					name="cerulean"><img
					src="themes/switch/images/clr/cerulean.png"
					alt="bootstrap business templates"></a> <a href="themes/css/#"
					name="journal"><img src="themes/switch/images/clr/journal.png"
					alt="bootstrap business templates"></a> <a href="themes/css/#"
					name="readable"><img
					src="themes/switch/images/clr/readable.png"
					alt="bootstrap business templates"></a> <a href="themes/css/#"
					name="simplex"><img src="themes/switch/images/clr/simplex.png"
					alt="bootstrap business templates"></a> <a href="themes/css/#"
					name="slate"><img src="themes/switch/images/clr/slate.png"
					alt="bootstrap business templates"></a> <a href="themes/css/#"
					name="spacelab"><img
					src="themes/switch/images/clr/spacelab.png"
					alt="bootstrap business templates"></a> <a href="themes/css/#"
					name="united"><img src="themes/switch/images/clr/united.png"
					alt="bootstrap business templates"></a>
				<p
					style="margin:0;line-height:normal;margin-left:-10px;display:none;">
					<small>These are just examples and you can build your own
						color scheme in the backend.</small>
				</p>
			</div>
			<div class="themeName">Background Patterns</div>
			<div class="images patterns">
				<a href="themes/css/#" name="pattern1"><img
					src="themes/switch/images/pattern/pattern1.png"
					alt="bootstrap business templates" class="active"></a> <a
					href="themes/css/#" name="pattern2"><img
					src="themes/switch/images/pattern/pattern2.png"
					alt="bootstrap business templates"></a> <a href="themes/css/#"
					name="pattern3"><img
					src="themes/switch/images/pattern/pattern3.png"
					alt="bootstrap business templates"></a> <a href="themes/css/#"
					name="pattern4"><img
					src="themes/switch/images/pattern/pattern4.png"
					alt="bootstrap business templates"></a> <a href="themes/css/#"
					name="pattern5"><img
					src="themes/switch/images/pattern/pattern5.png"
					alt="bootstrap business templates"></a> <a href="themes/css/#"
					name="pattern6"><img
					src="themes/switch/images/pattern/pattern6.png"
					alt="bootstrap business templates"></a> <a href="themes/css/#"
					name="pattern7"><img
					src="themes/switch/images/pattern/pattern7.png"
					alt="bootstrap business templates"></a> <a href="themes/css/#"
					name="pattern8"><img
					src="themes/switch/images/pattern/pattern8.png"
					alt="bootstrap business templates"></a> <a href="themes/css/#"
					name="pattern9"><img
					src="themes/switch/images/pattern/pattern9.png"
					alt="bootstrap business templates"></a> <a href="themes/css/#"
					name="pattern10"><img
					src="themes/switch/images/pattern/pattern10.png"
					alt="bootstrap business templates"></a> <a href="themes/css/#"
					name="pattern11"><img
					src="themes/switch/images/pattern/pattern11.png"
					alt="bootstrap business templates"></a> <a href="themes/css/#"
					name="pattern12"><img
					src="themes/switch/images/pattern/pattern12.png"
					alt="bootstrap business templates"></a> <a href="themes/css/#"
					name="pattern13"><img
					src="themes/switch/images/pattern/pattern13.png"
					alt="bootstrap business templates"></a> <a href="themes/css/#"
					name="pattern14"><img
					src="themes/switch/images/pattern/pattern14.png"
					alt="bootstrap business templates"></a> <a href="themes/css/#"
					name="pattern15"><img
					src="themes/switch/images/pattern/pattern15.png"
					alt="bootstrap business templates"></a> <a href="themes/css/#"
					name="pattern16"><img
					src="themes/switch/images/pattern/pattern16.png"
					alt="bootstrap business templates"></a> <a href="themes/css/#"
					name="pattern17"><img
					src="themes/switch/images/pattern/pattern17.png"
					alt="bootstrap business templates"></a> <a href="themes/css/#"
					name="pattern18"><img
					src="themes/switch/images/pattern/pattern18.png"
					alt="bootstrap business templates"></a> <a href="themes/css/#"
					name="pattern19"><img
					src="themes/switch/images/pattern/pattern19.png"
					alt="bootstrap business templates"></a> <a href="themes/css/#"
					name="pattern20"><img
					src="themes/switch/images/pattern/pattern20.png"
					alt="bootstrap business templates"></a>

			</div>
		</div>
	</div>
	<span id="themesBtn"></span>
</body>
</html>