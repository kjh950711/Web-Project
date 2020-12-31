<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="resources/assets/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="resources/assets/vendor/fonts/circular-std/style.css" >
    <link rel="stylesheet" href="resources/assets/libs/css/style.css">
    <link rel="stylesheet" href="resources/assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
    <link rel="stylesheet" href="resources/assets/vendor/fonts/material-design-iconic-font/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="resources/assets/vendor/fonts/flag-icon-css/flag-icon.min.css">
    <link rel="stylesheet" href="resources/assets/vendor/bootstrap-select/css/bootstrap-select.css">
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
    background: url('resources/img/header_img.png') no-repeat;
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

h3 {
   font-size:15px;
   text-align:left;
   margin-left: 12px;
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
        
        <div class="dashboard-wrapper"  style="margin-left:0;">
        
          <!-- content 시작 -->
          <div class="container-fluid  dashboard-content">
                    <div class="row">
                        <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                            <div class="page-header">
                                <h3 class="mb-2"><b>경주마 프로필</b></h3>
                                <div class="page-breadcrumb">
                                    <nav aria-label="breadcrumb">
                                        <ol class="breadcrumb">
                                            <li class="breadcrumb-item"><a href="#" class="breadcrumb-link">메인</a></li>
                                            <li class="breadcrumb-item active" aria-current="page">경주마 상세 페이지</li>
                                        </ol>
                                    </nav>
                                </div>
                            </div>
                        </div>
                    </div>
				<div class="row">
					<div class="col-xl-3 col-lg-3 col-md-5 col-sm-12 col-12">
						<div class="card"
							style="width: 600px; height: 1100px; margin-left: 250px;">
							<div class="card-body border-top">
								<div class="card-body" style="margin-left: 20px;">
									<div class="campaign-metrics d-xl-inline-block">
										<h3 class="font-16" style="text-align: center;">
											<i class="fab fa-sticker-mule"></i> 마명
										</h3>
										<ul class="list-unstyled mb-0">
											<li class="font-20" style="text-align: center;">${hvo.hName}</li>
										</ul>
									</div>

									<div class="campaign-metrics d-xl-inline-block">
										<h3 class="font-16" style="text-align: center";>
											<i class="fas fa-hand-point-right"></i> 마번
										</h3>
										<ul class="list-unstyled mb-0">
											<li class="font-20" style="text-align: center;">${hvo.hno}</li>
										</ul>
									</div>
								</div>
							</div>
							<div class="user-avatar text-center d-block"
								style="margin-top: 0px;">
								<img src="${hvo.hPhoto}" alt="User Avatar" width="400">
							</div>
							<div class="card-body border-top">
								<h3 class="font-16">
									<i class="fas fa-male"></i> 성별
								</h3>
								<div class="">
									<ul class="list-unstyled mb-0">
										<li class="font-20" style="margin-left: 80px;">${hvo.hSex}</li>
									</ul>
								</div>
							</div>
							<div class="card-body border-top">
								<h3 class="font-16">
									<i class="fa fa-calendar"></i> 출생일
								</h3>
								<div class="">
									<ul class="list-unstyled mb-0">
										<li class="font-20" style="margin-left: 80px;">${hvo.hBirthday}</li>

									</ul>
								</div>
							</div>
							<div class="card-body border-top">
								<h3 class="font-16">
									<i class="fas fa-chess-knight"></i> 군(등급)
								</h3>
								<div class="">
									<ul class="list-unstyled mb-0">
										<li class="font-20" style="margin-left: 80px";>${hvo.hClass}</li>

									</ul>
								</div>
							</div>
							<div class="card-body border-top">
								<h3 class="font-16">
									<i class=" fas fa-user"></i> 조교사
								</h3>
								<div class="">
									<ul class="list-unstyled mb-0">
										<li class="font-20" style="margin-left: 80px";>${hvo.trName}</li>

									</ul>
								</div>
							</div>
							<div class="card-body border-top">
								<h3 class="font-16">
									<i class="fas fa-user-plus"></i> 소유자
								</h3>
								<div class="">
									<ul class="list-unstyled mb-0">
										<li class="font-20" style="margin-left: 80px";>${hvo.owName}</li>

									</ul>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xl-9 col-lg-9 col-md-7 col-sm-12 col-12">
						<!-- ============================================================== -->
						<!-- campaign tab one -->
						<!-- ============================================================== -->
						<div class="influence-profile-content pills-regular">
							<div class="tab-pane fade show active" id="pills-campaign"
								role="tabpanel" aria-labelledby="pills-campaign-tab">
								<div class="row">


									<!-- 방사형 그래프 -->
									<div class="col-xl-3 col-lg-3 col-md-6 col-sm-12 col-12">
										<div class="card"
											style="height: 500px; width: 492px; margin-left: 390px; margin-bottom: 0;">
											<div class="card-body">
												<canvas id="radar" width="300" height="300"></canvas>
											</div>
										</div>
									</div>

									<!-- 방사형 데이터 표 -->
									<div class="row">
										<div class="card"
											style="width: 250px; height: 500px; margin-left: 565px;">

											<div class="card-body border-top"
												style="float =: right; height: 16%">
												<h3 class="font-22" style="text-align: left;">${hvo.hPrize}</h3>
												<div class="" align="right">
													<ul class="list-unstyled mb-0">
														<h3 class="font-12" style="text-align: left;">
															</i> 수득상금
														</h3>
													</ul>
												</div>
											</div>
											<div class="card-body border-top"
												style="float =: right; height: 16%">
												<h3 class="font-22" style="text-align: left;">${hvo.hWinRate}</h3>
												<div class="" align="right">
													<ul class="list-unstyled mb-0">
														<h3 class="font-12" style="text-align: left;">
															</i>승률
														</h3>
													</ul>
												</div>
											</div>
											<div class="card-body border-top"
												style="float =: right; height: 16%">
												<h3 class="font-22" style="text-align: left;">${hvo.hRating}</h3>
												<div class="" align="right">
													<ul class="list-unstyled mb-0">
														<h3 class="font-12" style="text-align: left;">
															</i>레이팅
														</h3>
													</ul>
												</div>
											</div>
											<div class="card-body border-top"
												style="float =: right; height: 16%">
												<h3 class="font-22" style="text-align: left;">${hvo.hTrainingCnt}</h3>
												<div class="" align="right">
													<ul class="list-unstyled mb-0">
														<h3 class="font-12" style="text-align: left;">
															</i>훈련횟수
														</h3>
													</ul>
												</div>
											</div>
											<div class="card-body border-top"
												style="float =: right; height: 16%">
												<h3 class="font-22" style="text-align: left;">${hsvo.gameCnt}</h3>
												<div class="" align="right">
													<ul class="list-unstyled mb-0">
														<h3 class="font-12" style="text-align: left;">
															</i>출전횟수
														</h3>
													</ul>
												</div>
											</div>
											<div class="card-body border-top"
												style="float =: right; height: 16%">
												<h3 class="font-22" style="text-align: left;">${hsvo.avgRankAll}</h3>
												<div class="" align="right">
													<ul class="list-unstyled mb-0">
														<h3 class="font-12" style="text-align: left;">
															</i>평균순위
														</h3>
													</ul>
												</div>
											</div>
										</div>
									</div>

									<!-- 여기 차트-->

									<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
										<div class="card"
											style="height: 592px; width: 748px; margin-top: -23px; margin-left: 390px;">
											<div class="card-body">
												<canvas id="Line" style="height: 550px; width: 750px;"></canvas>
											</div>
										</div>
									</div>

								</div>

							</div>
						</div>
					</div>
				</div>
            </div>
        
           
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
<script src="resources/assets/vendor/jquery/jquery-3.3.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!-- bootstap bundle js -->
<script src="resources/assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
<!-- slimscroll js -->
<script src="resources/assets/vendor/slimscroll/jquery.slimscroll.js"></script>
<!-- main js -->
<script src="resources/assets/libs/js/main-js.js"></script>  
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
				search_val = 'hName';
			}
			else{
				search_val = 'pName';
			}
			
			$.ajax({  
				url: "/dark_horse/main_search/"+search_val,
				method: 'get',
				contentType: 'application/x-www-form-urlencoded; charset=UTF-8;',
				//data: "search_val="+search_val,
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
		    $("#t_search_btn").attr("href","/dark_horse/player_detail?pName="+currentVal);
		}); */  // input 입력할 때마다 동작 감지
		 
		$(document).on("click","#t_search_btn",function(){
			
			var name = $("#t_search").val();
			
			if($("#select_opt").val() == "기수"){
				$( "#my_form" ).attr("action","/dark_horse/player_detail?pName="+name);
				$("#t_search").attr("name", "pName")
				$( "#my_form" ).submit();
			}
			else if($("#select_opt").val() == "경주마"){
				 $( "#my_form" ).attr("action","/dark_horse/horse_detail?hName="+name);
				$("#t_search").attr("name", "hName")
			     $( "#my_form" ).submit();			
			}
		})
    
}); 
///////////////////////////////////////////////공통 script/////////////////////////////////  
/* var ctx = document.getElementById("radar").getContext('2d');
var chart = new Chart(ctx, {
         // The type of chart we want to create
         type: 'radar',

         // The data for our dataset
         data: {
             labels: ['수득상금', '승률', '레이팅', '훈련횟수', '출전횟수', '평균순위'],
             datasets: [{
                label: "Ability",
                 data: ["43", "20","80", "58","11","50"],
                 backgroundColor: "rgba(255, 232, 23, 0.8)",
                 borderColor:"#ffc400"
             }]
         },

         // Configuration options go here
         options: {}
         }); */
var ctx = document.getElementById("radar").getContext('2d');
	<c:set var="place" value="${hvo.gamePlace}" />
	<c:if test="${place eq '서울'}">
    var chart = new Chart(ctx, {
    // The type of chart we want to create
    type: 'radar',
    // The data for our dataset
    data: {
           labels: ['수득상금', '승률', '레이팅', '훈련횟수', '출전횟수', '평균순위'],
           datasets: [{
              label: "Ability",
               data: ["38","${hvo.hWinRate}","${hvo.hRating}", "32.4","${hsvo.gameCnt}","39.5"],
               backgroundColor: "rgba(255, 232, 23, 0.8)",
               borderColor:"#ffc400"
           }]
          },
    
              // Configuration options go here
          options: {}
    });
    </c:if>
	<c:if test="${place eq '제주'}">
    var chart = new Chart(ctx, {
    // The type of chart we want to create
    type: 'radar',
    // The data for our dataset
    data: {
           labels: ['수득상금', '승률', '레이팅', '훈련횟수', '출전횟수', '평균순위'],
           datasets: [{
              label: "Ability",
               data: ["89", "${hvo.hWinRate}","${hvo.hRating}", "${hvo.hTrainingCnt}","${hsvo.gameCnt}","16.4"],
               backgroundColor: "rgba(255, 232, 23, 0.6)",
               borderColor:"#ffc400"
           }]
          },
    
              // Configuration options go here
          options: {}
    });
    </c:if>

      
var ctx2 = document.getElementById("Line").getContext('2d');
var chart2 = new Chart(ctx2, {
		    // The type of chart we want to create
		    type: 'line',
		    data: {
		          labels: ${monlist}, //X축 제목
		           datasets: [ {   
		                label: "월별 평균순위",
		                data: ${ranklist},
		                backgroundColor: "rgba(0, 0, 0, 0)" ,
		                borderWidth: 2,
		                borderColor:"#6e664c"
		           }]
		    },
		    options: {
		    	  scales: {
		    	    yAxes: [{
		    	      ticks: {
		    	        reverse: true,
		    	      }
		    	    }]
		    	  }
		    	}
          }); 
            
 
 
</script>

</body>
 
</html>