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
.youtube{
	height: 400px;
}

.news{
	width: 640px;
	margin-top: 15px;
}
.chartDiv{
	margin-top: 15px;
}

#seoulloc {
        height: 400px;  /* The height is 400 pixels */
        width: 530px;  /* The width is the width of the web page */
        
       }
#jejuloc {
        height: 400px;  /* The height is 400 pixels */
        width: 530px;  /* The width is the width of the web page */
        
       }
#busanloc  {
        height: 400px;  /* The height is 400 pixels */
        width: 530px;  /* The width is the width of the web page */
        
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
            <div class="dashboard-ecommerce">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-xl-3 col-lg-6 col-md-6 col-sm-8 col-8">
                          <div class="page-header">
                            <i class="fas fa-horse-head fa-3x ficon"></i>
                            <h2 class="pageheader-title">금주의 경마 </h2>
                       	  </div>
                        </div>
                    </div>
                    <div class="ecommerce-widget">
                        <div class="row">
                        	<!-- col-xl-9 col-lg-12 col-md-6 col-sm-12 col-12 -->
                            <div class="col-xl-7 col-lg-8 col-md-8 col-sm-8 col-8">

								<div class="simple-card">
									<ul class="nav nav-tabs" id="myTab5" role="tablist">
										<li class="nav-item myclick"  param1="서울">
											<a class="nav-link active border-left-0" id="home-tab-simple" data-toggle="tab" href="#home-simple" role="tab" aria-controls="home" aria-selected="true">서울</a>
										</li>
										<li class="nav-item myclick"  param1="부경" >
											<a class="nav-link"                     id="profile-tab-simple" data-toggle="tab" href="#home-simple" role="tab" aria-selected="false">부산</a>
										</li>
										<li class="nav-item myclick" param1="제주"  >
											<a class="nav-link"                     id="contact-tab-simple" data-toggle="tab" href="#home-simple" role="tab"  aria-selected="false">제주</a></li>
									</ul>
									<div class="tab-content" id="myTabContent5">

										<!-- ################### 서울 #################### -->
										<div class="tab-pane fade show active" id="home-simple" role="tabpanel" aria-labelledby="home-tab-simple">
											<div class="schedule_info">
													<select class="custom-select s_info" name="s_info" id="s_info">
														<option value="default" selected>날짜 / 시간을 선택하세요.</option>
														<c:forEach items="${s_optList}" var="optVo">
															<option value="${optVo.g_date}|${optVo.g_round}">${optVo.g_date} R${optVo.g_round} ${optVo.g_time}</option>
														</c:forEach>
													</select> 
													<input type="button" class="btn btn-brand btn-sm" id="search_btn" value="Search">
											
												<div class="row schedule_info">
													<div class="col-xl-3 col-lg-6 col-md-6 col-sm-12 col-12">
														<div class="card">
															<div class="card-body">
																<div class="d-inline-block">
																	<h5 class="text-muted">Round</h5>
																	<h2 class="mb-0">R${sList_infoVo.g_round}</h2>
																</div>
															</div>
														</div>
													</div>
													<div class="col-xl-3 col-lg-6 col-md-6 col-sm-12 col-12">
														<div class="card">
															<div class="card-body">
																<div class="d-inline-block">
																	<h5 class="text-muted">등급</h5>
																	<h2 class="mb-0">${sList_infoVo.h_class}</h2>
																</div>
															</div>
														</div>
													</div>
													<div class="col-xl-3 col-lg-6 col-md-6 col-sm-12 col-12">
														<div class="card">
															<div class="card-body">
																<div class="d-inline-block">
																	<h5 class="text-muted">경주명</h5>
																	<h2 class="mb-0">${sList_infoVo.g_name}</h2>
																</div>
															</div>
														</div>
													</div>
													<div class="col-xl-3 col-lg-6 col-md-6 col-sm-12 col-12">
														<div class="card">
															<div class="card-body">
																<div class="d-inline-block">
																	<h5 class="text-muted">거리</h5>
																	<h2 class="mb-0">${sList_infoVo.distance}</h2>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										<!-- <h5 class="card-header">출전 리스트</h5> -->
										<div class="card-body">
											<div class="table-responsive">
												<table class="table">
													<thead class="bg-light">
														<tr class="border-0">
															<th class="border-0">No.</th>
															<th class="border-0">img</th>
															<th class="border-0">마명</th>
															<th class="border-0">성별</th>
															<th class="border-0">나이</th>
															<th class="border-0">부담중량</th>
															<th class="border-0">기수명</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach items="${sList}" var="svo" varStatus="status">
															<tr>
																<td>${svo.hno}</td>
																<td>
																	<div class="m-r-10">
																		<img src="${svo.h_photo}" class="rounded" width="45">
																	</div>
																</td>
																<td><a href="horse_detail?hrname=${svo.hrname}">${svo.hrname}</a></td>
																<td>${svo.h_sex}</td>
																<td>${svo.h_age}</td>
																<td>${svo.h_weight}kg</td>
																<td><a href="player_detail?pyname=${svo.pyname}">${svo.pyname}</a></td>
															</tr>
														</c:forEach>

													</tbody>
												</table>
											</div>
										</div>
											
										</div>

										
									</div>
								</div> <!-- e.o card -->

							</div>
                            <div class="col-xl-3 col-lg-6 col-md-6 col-sm-12 col-12 youtube">
                              <iframe id="player" type="text/html" width="640" height="360"
								  src="http://www.youtube.com/embed/oQM8enCWdVg?enablejsapi=1&origin=http://example.com"
								  frameborder="0"></iframe>
								  
								  <div class="card news">
		                                <h5 class="card-header">경마 News</h5>
		                                <div class="card-body">
		                                    <div class="list-group">
		                                    
		                                      <c:forEach items="${nList}" var="nvo" varStatus="status">
		                                        <div  class="list-group-item list-group-item-action flex-column align-items-start">
		                                            <a href="${nvo.link}">
		                                              <div class="d-flex w-100 justify-content-between">
		                                                <h5 class="mb-1">${nvo.title}</h5>
		                                                <small>${nvo.pubDate}</small>
		                                              </div>
		                                            </a>
		                                            <small><p class="mb-1">${nvo.description}</p></small>
		                                        </div>
		                                      </c:forEach> 
		                                      
		                                    </div>
		                                </div>
		                            </div>
                            </div>
                            
                            </div>
                            <div class="row">
                              <div class="col-xl-7 col-lg-8 col-md-8 col-sm-8 col-8 chartDiv">
									<div class="card">
										<h5 class="card-footer">종합예측점수</h5>
										<div class="card-body">
											<!-- chart  -->
											<canvas id="s_myChart" width="800" height="400"></canvas>
										</div>
									</div>
								</div>
                            </div>
                            
                            <!-- 지도 -->
                            <div class="row">
                            	<div class="card" style="width:1750px; margin-top: 20px; margin-right: 0px;">
                                    <h5 class="card-header">경마장 위치</h5>
                                    <div class="card-body">
                                    
                                    <div class="row">
                                    <div class="column" style="margin-left:35px">
                                    <b>서울 렛츠런</b>
                                       <div id="seoulloc" ></div>
                                    </div>
                                     
                                    <div class="column" style="margin-left:30px">
                                    <b>제주 렛츠런</b>
                                    <div id="jejuloc"></div>
                                    </div>
                                    
                                    <div class="column" style="margin-left:30px; margin-right:35px">
                                    <b>부산경남 렛츠런</b>
                                    <div id="busanloc"></div>
                                    </div>
                                    
                                    
                                           <script>
                                       function initMap() {
                                         
                                         var seoulrun = {lat: 37.447693, lng: 127.015624};
                                         var seoulmap = new google.maps.Map(
                                             document.getElementById('seoulloc'), {zoom: 13.5, center: seoulrun});
                                         var markerseoul = new google.maps.Marker({position: seoulrun, map: seoulmap, title: '서울 렛츠런'});
                                         var infowindowseoul = new google.maps.InfoWindow({
                                              content: '<div><h5 style="color:skyblue">렛츠런파크 서울</h5><b style="color:black">주소: </b>경기도 과천시 과천동 경마공원대로 107<br>'+
                                                      '<b style="color:black">전화번호: </b>1566-3333<br><b style="color:black">운영시간: </b>09:00-18:00<br>'+
                                                      '<a href="http://park.kra.co.kr/parkuserseoul/infoTransportInfo.do"><U><b>교통안내 홈페이지</b></U></a></div>'
                                            });
                                         markerseoul.addListener('click', function() {
                                            infowindowseoul.open(seoulmap, markerseoul);
                                            });
                                         
                                         var jejurun = {lat: 33.407700, lng: 126.395074}; 
                                         var jejumap = new google.maps.Map(
                                             document.getElementById('jejuloc'), {zoom: 13.5, center: jejurun});
                                         var markerjeju = new google.maps.Marker({position: jejurun, map: jejumap, title: '제주 렛츠런'});
                                         var infowindowjeju = new google.maps.InfoWindow({
                                              content: '<div><h5 style="color:skyblue">렛츠런파크 제주</h5><b style="color:black">주소: </b>제주특별자치도 제주시 애월읍 평화로 2144<br>'+
                                                      '<b style="color:black">전화번호: </b>1566-3333<br><b style="color:black">운영시간: </b>09:30-16:00<br>'+
                                                      '<a href="http://park.kra.co.kr/parkuserjeju/infoTransportInfo.do"><U><b>교통안내 홈페이지</b></U></a></div>'
                                            });
                                         markerjeju.addListener('click', function() {
                                            infowindowjeju.open(jejumap, markerjeju);
                                            });
                                         
                                         var busanrun = {lat: 35.155311, lng: 128.876629}; 
                                         var busanmap = new google.maps.Map(
                                             document.getElementById('busanloc'), {zoom: 13.5, center: busanrun});
                                         var markerbusan = new google.maps.Marker({position: busanrun, map: busanmap, title: '부산경남 렛츠런'});
                                         var infowindowbusan = new google.maps.InfoWindow({
                                              content: '<div><h5 style="color:skyblue">렛츠런파크 부산경남</h5><b style="color:black">주소: </b>부산광역시 강서구 범방동 가락대로 929<br>'+
                                                      '<b style="color:black">전화번호: </b>1566-3333<br><b style="color:black">운영시간: </b>10:00-18:00 (토/일 09:00-18:00)<br>'+
                                                      '<a href="http://park.kra.co.kr/parkuserbusan/infoTransportInfo.do"><U><b>교통안내 홈페이지</b></U></a></div>'
                                            });
                                         markerbusan.addListener('click', function() {
                                            infowindowbusan.open(busanmap, markerbusan);
                                            });
                                       
                                       }
                                           </script>  
                                           <script async defer
                                           src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC5821D0VX6z-xNZr-HY2auC0KI2ExFdkg&callback=initMap">
                                           </script>
                                           
                                    </div>
                                    </div>
                                 </div>
                            </div>
                            
                        </div>
                        
                    </div>
                </div>
            </div>
            
            
            
            <!-- ============================================================== -->
            <!-- footer -->
            <!-- ============================================================== -->
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
            <!-- ============================================================== -->
            <!-- end footer -->
            <!-- ============================================================== -->
        </div>
        <!-- ============================================================== -->
        <!-- end wrapper  -->
        <!-- ============================================================== -->
    </div>
    <!-- ============================================================== -->
    <!-- end main wrapper  -->
    <!-- ============================================================== -->

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
    
    var ctx = document.getElementById("s_myChart").getContext('2d');
    var mixedChart = new Chart(ctx, {
        type: 'bar',
        data: {
            datasets: [{
                label: '평균 등수',
                borderColor: 'rgba(74, 74, 58)',
                backgroundColor: 'rgba(74, 74, 58, 0.2)',
                data: ${avgscorearr}
            }, {
                label: '종합예측점수',
                borderColor: 'rgba(255, 199, 80)',
                backgroundColor: 'rgba(0, 0, 0, 0)',
                data: [58.4, 68.1, 38.2, 80.4, 21.1, 60.9, 34.2, 87.0, 67.3],

                // Changes this dataset to become a line
                type: 'line'
            }],
            
            labels: ${hrnameList},
            options: { 
                yAxes: [ 
                 { 
                 name: 'A', 
                 type: 'linear', 
                 position: 'left', 
                 scalePositionLeft: true 
                 }, 
                 { 
                 name: 'B', 
                 type: 'bar', 
                 position: 'right', 
                 scalePositionLeft: false, 
                 min: 0, 
                 max: 1 
                 } 
                ] 
                } 

        },
    }); 
    
    
    
    
    
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
	
	// 상단 검색 Go!버튼 클릭 했을 때
	/* $("#t_search").on("propertychange change keyup paste input", function() {
	    var currentVal = $(this).val();
	    $("#t_search_btn").attr("href","/dark_horse/player_detail?pyname="+currentVal);
	}); */  // input 입력할 때마다 동작 감지
	 
	$(document).on("click","#t_search_btn",function(){
		
		var name = $("#t_search").val();
		
		if($("#select_opt").val() == "기수"){
			$( "#my_form" ).attr("action","/dark_horse/player_detail?pyname="+name);
			$("#t_search").attr("name", "pyname")
			$( "#my_form" ).submit();
		}
		else if($("#select_opt").val() == "경주마"){
			 $( "#my_form" ).attr("action","/dark_horse/horse_detail?hrname="+name);
			$("#t_search").attr("name", "hrname")
		     $( "#my_form" ).submit();			
		}
	})
	
	    
	    
	$(document).on("click","#search_btn",function(){  	//동적 버튼 생성시 click 이벤트 처리 
    //$("#search_btn").click(function(){				//static 버튼시 click 이벤트 처리 
		 //alert("!!!")
		 var vplace = $("#place").val();  //input hidden 값 세팅
		 
		 if(vplace == "") 
			 vplace = "서울";
		 
		 var s_info = $(".s_info option:selected").val();
		 var param2="", param3="";
		 
		 if(s_info != "default") {
			 var arr = s_info.split("|"); //2019.10.13 (일)|9
			 param2 = arr[0];  			//'2019.10.13 (일)'
			 param3 = arr[1]			//'9'	 	 	 
			 $("#g_date").val(param2);   	//input hidden 값 세팅
		 	 $("#g_round").val(param3);  	//input hidden 값 세팅	 
		 }
		 //alert(vplace + " " + param2 + " " + param3);
		 searchGame(vplace, param2, param3);
	 });
	 
	 
	$(".nav-item.myclick").click(function(){
		var param1 = $(this).attr("param1").toString();
		$("#place").val(param1);  //input hidden 값 세팅
		//console.log(param1);
		searchGame(param1,"", "");
	});
	
	function searchGame(vplace,vg_date,vg_round) {
		//var url = "/dark_horse/main?place="+vplace+"&g_date="+vg_date+"&g_round="+vg_round
		//console.log(url);
		
		$.ajax({  
			url: "/dark_horse/main",
			method: 'get',
			contentType: 'application/x-www-form-urlencoded; charset=UTF-8;',
			data: "place="+vplace+"&g_date="+vg_date+"&g_round="+vg_round,
			dataType: 'json',
			error: function(){alert("에러")},
			success: function(jsonObj){

				var html = "";
				html += 
				"<div class='schedule_info'>" +
				"<select class='custom-select s_info' name='s_info' id='s_info'>" +
				"	<option value='default' selected>날짜 / 시간을 선택하세요.</option>";
				$.map(jsonObj.optList, function(opt, i){  // 반드시 요소, 인덱스 인자로 줘야함
					html += "<option value='"+opt.g_date + "|"+opt.g_round+"'>" + opt.g_date + "R"+opt.g_round+" "+opt.g_time + "</option> ";
				});
				html += "	</select> " +
				"	<input type='button' class='btn btn-brand btn-sm' id='search_btn' value='Search'>" +
				"<div class='row schedule_info'>" +
				"	<div class='col-xl-3 col-lg-6 col-md-6 col-sm-12 col-12'>" +
				"		<div class='card'>" +
				"			<div class='card-body'>" +
				"				<div class='d-inline-block'>" +
				"					<h5 class='text-muted'>Round</h5>" +
				"					<h2 class='mb-0'>R"+jsonObj.hList[0].g_round+"</h2>" +
				"				</div>" +
				"			</div>" +
				"		</div>" +
				"	</div>" +
				"	<div class='col-xl-3 col-lg-6 col-md-6 col-sm-12 col-12'>" +
				"		<div class='card'>" +
				"			<div class='card-body'>" +
				"				<div class='d-inline-block'>" +
				"					<h5 class='text-muted'>등급</h5>" +
				"					<h2 class='mb-0'>"+jsonObj.hList[0].h_class+"</h2>" +
				"				</div>" +
				"			</div>" +
				"		</div>" +
				"	</div>" +
				"	<div class='col-xl-3 col-lg-6 col-md-6 col-sm-12 col-12'>" +
				"		<div class='card'>" +
				"			<div class='card-body'>" +
				"				<div class='d-inline-block'>" +
				"					<h5 class='text-muted'>경주명</h5>" +
				"					<h2 class='mb-0'>"+jsonObj.hList[0].g_name+"</h2>" +
				"				</div>" +
				"			</div>" +
				"		</div>" +
				"	</div>" +
				"	<div class='col-xl-3 col-lg-6 col-md-6 col-sm-12 col-12'>" +
				"		<div class='card'>" +
				"			<div class='card-body'>" +
				"				<div class='d-inline-block'>" +
				"					<h5 class='text-muted'>거리</h5>" +
				"					<h2 class='mb-0'>"+jsonObj.hList[0].distance+"</h2>" +
				"					</div>" +
				"				</div>" +
				"			</div>" +
				"		</div>" +
				"	</div>" +
				"</div>" +
				"<div class='card-body'>" +
				"	<div class='table-responsive'>" +
				"		<table class='table'>" +
				"			<thead class='bg-light'>" +
				"				<tr class='border-0'>" +
				"					<th class='border-0'>No.</th>" +
				"					<th class='border-0'>img</th>" +
				"					<th class='border-0'>마명</th>" +
				"					<th class='border-0'>성별</th>" +
				"					<th class='border-0'>나이</th>" +
				"					<th class='border-0'>부담중량</th>" +
				"					<th class='border-0'>기수명</th>" +
				"				</tr>" +
				"			</thead>" +
				"			<tbody>";
				$.map(jsonObj.hList, function(hvo, i){  	// 반드시 요소, 인덱스 인자로 줘야함
					console.log(i + ", " + hvo.hrname);
					html += "<tr> " +
					"	<td>"+hvo.hno+"</td> " +
					"<td> " +
					"	<div class='m-r-10'> " +
					"		<img src='"+hvo.h_photo+"' class='rounded' width='45'> " +
					"	</div> " +
					"</td> " +
					"<td><a href=''>"+hvo.hrname +"</a></td> " +
					"<td>"+hvo.h_sex+"</td> " +
					"<td>"+hvo.h_age+"</td> " +
					"<td>"+hvo.h_weight+"kg</td> " +
					"<td><a href='player_detail?pyname="+hvo.pyname+"'>"+hvo.pyname+"</a></td> " +
					"</tr> ";
				
				}); 
				html += "			</tbody>" +
				"		</table>" +
				"	</div>" +
				"</div>";
				
				$("#home-simple").empty();
				$("#home-simple").html(html);
				
			}  //e.o.success		
		});
		
    }//e.o.searchGame()
    
}); 
	


</script>

</body>
 
</html>