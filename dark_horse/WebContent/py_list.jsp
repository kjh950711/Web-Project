<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="assets/vendor/fonts/circular-std/style.css" >
    <link rel="stylesheet" href="assets/libs/css/style.css">
    <link rel="stylesheet" href="assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
    <link rel="stylesheet" href="assets/vendor/fonts/material-design-iconic-font/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="assets/vendor/fonts/flag-icon-css/flag-icon.min.css">
    <link rel="stylesheet" href="assets/vendor/bootstrap-select/css/bootstrap-select.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
    <link href="https://fonts.googleapis.com/css?family=Faster+One&display=swap" rel="stylesheet">
    <title>horse</title>
<style type="text/css">
.page-header {
    margin-top: 30px;
}
.logo_header {
    position: relative;
    width: 100%;
    height: 180px;
    color: white;
    text-align: center;
    background: url('img/header_img.png') no-repeat;
}
.dashboard-main-wrapper{
	padding-top: 0px;
}
#brand{
	color: #f9f8f7;
	font-size: 70px;
	font-family: 'Faster One', cursive;
	line-height:90%;
	display: inline-block;
	padding-top: 20px;
	text-shadow: 4px 4px 4px #484646;
}
.navbar.navbar-expand-sm.bg-dark.navbar-dark.sticky-top {
	justify-content: space-between;
}
.custom-select{
	width: 250px
}
.form-inline.my-2.my-lg-0{
	margin-right: 20px;
}
.row.schedule_info{
	margin-top: 20px
}

.tab-content.schedule_info {
    padding: 30px 30px 0px 30px;
}
.ficon{
	float: left;
	margin-right: 20px;
}
.dashboard-wrapper{
	margin-left: 50px
}
.ui-autocomplete {
    max-height: 100px;
    overflow-y: auto;
    /* prevent horizontal scrollbar */
    overflow-x: hidden;
  }
  
#t_select{
    width: 70px;
    margin-right: 10px;
}

#t_search{
	width: 250px;
}

</style>


<script src="https://kit.fontawesome.com/7e5d0aa0b2.js" crossorigin="anonymous"></script>

</head>

<body>
<input type="hidden" name="place" id="place">
<input type="hidden" name="g_date" id="g_date">
<input type="hidden" name="g_round" id="g_round">
<input type="hidden" name="select_opt" id="select_opt">

    <div class="dashboard-main-wrapper">
        <div class="dashboard-header">
            <div class="logo_header">	
     		   <a href="/dark_horse/main"><p id="brand">DARK<br> HORSE</p></a>
            </div>
            <nav class="navbar navbar-expand-sm bg-dark navbar-dark sticky-top">
			  <ul class="navbar-nav">
			    <li class="nav-item">
			      <a class="nav-link" href="main">금주의 경마</a>
			    </li>
			    <li class="nav-item">
			      <a class="nav-link" href="horse_list">경주마</a>
			    </li>
			    <li class="nav-item">
			      <a class="nav-link" href="player_list">기수</a>
			    </li>
			  </ul>
			    <form class="form-inline my-2 my-lg-0" method="get" action="" id="my_form">
			    <label for="sel1"></label>
					  <select class="form-control" id="t_select">
					    <option>선택</option>
					    <option>경주마</option>
					    <option>기수</option>
					  </select>
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" id="t_search" name="pyname">
                    <div class="input-group-append">
                        <button class="btn btn-gray btn-sm" id="t_search_btn">Go!</button>
                    </div>
                </form>
			</nav>
        </div>
        
        <div class="dashboard-wrapper">
        
          <!-- content 시작 -->
          <div class="col-xl-1170px col-lg-1170px col-md-1170px col-sm-1170px col-1170px">
					<div class="container" style="margin-top:50px;">
					 <div class="row">
						<!-- <img src="assets/images/top50.jpg" style="width:10%; height:10%"> -->
						<h1><i class="fas fa-chess-queen"></i> 기수 승률 TOP50 </h1>
						<!-- <p>기수 승률 상위 50위 <i class="fas fa-chess-queen"></i></p> -->
						<table class="table table-striped">
							<thead>
								<tr>
									<th>순위</th>
									<th>기수명</th>
									<th></th>
									<th>승률</th>
									<th>데뷔일자</th>
									<th>통산전적</th>
									<th>기승가능중량</th>
									<th>지역</th>
								</tr>
							</thead>
							<tbody>
							
							 <c:forEach items="${pyVOList}" var="pyvo">
								<tr>
								    <td>${pyvo.rownum}</td>
									<td><a href="/dark_horse/player_detail?pyname=${pyvo.pyname}">${pyvo.pyname}</td>
									<td><img
										src="${pyvo.p_photo}"
										class="rounded" alt="Cinque Terre" width="100" height="100">
									</td>
									<td><b>${pyvo.p_win_rate_all}%</b></td>
									<td>${pyvo.p_debut}</td>
									<td>${pyvo.p_win_cnt_all}</td>
									<td>${pyvo.p_weight}</td>
									<td>${pyvo.place}</td>
								</tr>
								</c:forEach>
								
							</tbody>
						</table>
					 
					 </div>
 					<!-- pagebutton(여기부터 페이지버튼) -->

					</div>
					<ul class="pagination" style="justify-content: center;">
						<li class="page-item"><a class="page-link" href="#">Previous</a></li>
						<li class="page-item active"><a class="page-link" href="#">1</a></li>
						<li class="page-item"><a class="page-link" href="#">2</a></li>
						<li class="page-item"><a class="page-link" href="#">3</a></li>
						<li class="page-item"><a class="page-link" href="#">4</a></li>
						<li class="page-item"><a class="page-link" href="#">5</a></li>
						<li class="page-item"><a class="page-link" href="#">Next</a></li>
					</ul>
				</div>
        	<!-- content 시작 -->
        </div>

            <div class="footer">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 col-12">
                             Copyright © 2018 Concept. All rights reserved. Dashboard by <a href="https://colorlib.com/wp/">Colorlib</a>.
                        </div>
                        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 col-12">
                            <div class="text-md-right footer-links d-none d-sm-block">
                                <a href="javascript: void(0);">About</a>
                                <a href="javascript: void(0);">Support</a>
                                <a href="javascript: void(0);">Contact Us</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

<!-- jquery 3.3.1 -->
<script src="assets/vendor/jquery/jquery-3.3.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!-- bootstap bundle js -->
<script src="assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
<!-- slimscroll js -->
<script src="assets/vendor/slimscroll/jquery.slimscroll.js"></script>
<!-- main js -->
<script src="assets/libs/js/main-js.js"></script>  
<script type="text/javascript">
 $(function(){
	  
	 var availableTags = [];
    $( "#t_search" ).autocomplete({
      source: availableTags
    });
	
	// 상단 검색 select 선택됐을 때 
	$("#t_select").change(function(){
		
		var search_val = "";
		var v = $("#t_select option:selected").val();
		$("#select_opt").val(v); // 상단 바 select option 값 세팅
		
		if(v == '경주마'){
			search_val = 'hrname';
		}
		else{
			search_val = 'pyname';
		}
		
		$.ajax({  
			url: "/dark_horse/main_search",
			method: 'get',
			contentType: 'application/x-www-form-urlencoded; charset=UTF-8;',
			data: "search_val="+search_val,
			dataType: 'json',
			error: function(){alert("에러")},
			success: function(jsonObj){
				if(availableTags.length > 0){
					availableTags.splice(0, availableTags.length)
				}
			
				$.map(jsonObj, function(el) { availableTags.push(el)});
				console.log(availableTags + " " + typeof availableTags)
			}
		})
	})
	 
	$(document).on("click","#t_search_btn",function(){
		
		var name = $("#t_search").val();
		
		if($("#select_opt").val() == "기수"){
			alert($("#select_opt").val())
		
			$( "#my_form" ).attr("action","/dark_horse/player_detail?pyname="+name);
			$("#t_search").attr("name", "pyname")
			$( "#my_form" ).submit();
		}
		else if($("#select_opt").val() == "경주마"){
			
			alert($("#select_opt").val())
			 $( "#my_form" ).attr("action","/dark_horse/horse_detail?hrname="+name);
			$("#t_search").attr("name", "hrname")
		     $( "#my_form" ).submit();			
		}
	})
	
    
}); 
///////////////////////////////////////////////공통 script/////////////////////////////////  

</script>

</body>
 
</html>