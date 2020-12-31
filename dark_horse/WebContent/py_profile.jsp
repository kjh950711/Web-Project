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
          <div class="influence-profile">
                <div class="container-fluid dashboard-content ">
                    <div class="row">
                        <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                            <div class="page-header">
                                <h3 class="mb-2"><b>기수 프로필</b></h3>
                                <div class="page-breadcrumb">
                                    <nav aria-label="breadcrumb">
                                        <ol class="breadcrumb">
                                            <li class="breadcrumb-item"><a href="#" class="breadcrumb-link">메인</a></li>
                                            <li class="breadcrumb-item active" aria-current="page">기수 상세 페이지</li>
                                        </ol>
                                    </nav>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xl-3 col-lg-3 col-md-5 col-sm-12 col-12">
                            <div class="card">
                                <div class="card-body">
                                    <div class="user-avatar text-center d-block">
                                        <img src="${gvo.p_photo}" alt="User Avatar" style="width:107px; height:144px" > 
                                       
                                    </div>
                                    <div class="text-center">
                                        <h2 class="font-24 mb-0">${gvo.pyname}</h2> 
                                        
                                       
                                    </div>
                                </div>
                                <div class="card-body border-top">
                                    <h3 class="font-16"><i class="fa fa-calendar"></i> 생년월일</h3>
                                    <div class="">
                                        <ul class="list-unstyled mb-0">
                                        <li class="mb-2">${gvo.p_birthday}</li> 
                                        
                                    </ul>
                                    </div>
                                </div>
                                <div class="card-body border-top">
                                    <h3 class="font-16"><i class="fas fa-chess-knight"></i> 승률</h3>
                                    <h1 class="mb-0">${gvo.p_win_rate_all}%</h1> 
                                    <div class="rating-star">
                                        <c:set var="rate" value="${gvo.p_win_rate_all}"/>
                                        <c:if test="${gvo.p_win_rate_all >= 14}">
                                        <i class="fa fa-fw fa-star"></i>
                                        <i class="fa fa-fw fa-star"></i>
                                        <i class="fa fa-fw fa-star"></i>
                                        <i class="fa fa-fw fa-star"></i>
                                        <i class="fa fa-fw fa-star"></i>
                                        <!-- <p class="d-inline-block text-dark">14 Reviews </p> -->
                                        </c:if>
                                        <c:if test="${gvo.p_win_rate_all < 14 && gvo.p_win_rate_all >=11}">
                                        <i class="fa fa-fw fa-star"></i>
                                        <i class="fa fa-fw fa-star"></i>
                                        <i class="fa fa-fw fa-star"></i>
                                        <i class="fa fa-fw fa-star"></i>
                                        <!-- <p class="d-inline-block text-dark">14 Reviews </p> -->
                                        </c:if>
                                        <c:if test="${gvo.p_win_rate_all < 11 && gvo.p_win_rate_all >=8}">
                                        <i class="fa fa-fw fa-star"></i>
                                        <i class="fa fa-fw fa-star"></i>
                                        <i class="fa fa-fw fa-star"></i>
                                        <!-- <p class="d-inline-block text-dark">14 Reviews </p> -->
                                        </c:if>
                                        <c:if test="${gvo.p_win_rate_all < 8 && gvo.p_win_rate_all >=5}">
                                        <i class="fa fa-fw fa-star"></i>
                                        <i class="fa fa-fw fa-star"></i>

                                        <!-- <p class="d-inline-block text-dark">14 Reviews </p> -->
                                        </c:if>
                                        <c:if test="${gvo.p_win_rate_all <5}">
                                        <i class="fa fa-fw fa-star"></i>

                                        <!-- <p class="d-inline-block text-dark">14 Reviews </p> -->
                                        </c:if>
                                    </div>
                                </div>
                               <!--  <div class="card-body border-top">
                                    <h3 class="font-16">linc</h3>
                                    <div class="">
                                        <ul class="mb-0 list-unstyled">
                                        <li class="mb-1"><img src="assets/images/logo_letsRun.png" style="width: 50%; hight:50%"></li>
                                        <li class="mb-1"><a href="#"><i class="fab fa-fw fa-twitter-square mr-1 twitter-color"></i>twitter.com/michaelchristy</a></li>
                                        <li class="mb-1"><a href="#"><i class="fab fa-fw fa-instagram mr-1 instagram-color"></i>instagram.com/michaelchristy</a></li>
                                        <li class="mb-1"><a href="#"><i class="fas fa-fw fa-rss-square mr-1 rss-color"></i>michaelchristy.com/blog</a></li>
                                        <li class="mb-1"><a href="#"><i class="fab fa-fw fa-pinterest-square mr-1 pinterest-color"></i>pinterest.com/michaelchristy</a></li>
                                        <li class="mb-1"><a href="#"><i class="fab fa-fw fa-youtube mr-1 youtube-color"></i>youtube/michaelchristy</a></li>
                                    </ul>
                                    </div>
                                </div> -->
                                <div class="card-body border-top">
                                    <h3 class="font-16"><i class="fas fa-users"></i> 복색</h3>
                                    <div class="">
                                        <ul class="list-unstyled mb-0">
                                         <img src="${gvo.p_cloth}" style="width: 50%; hight:50%">
                                    </ul>
                                    </div>
                                </div> 
                                	
                            </div>
                            <!-- ============================================================== -->
                            <!-- end card profile -->
                            <!-- ============================================================== -->
                        </div>
                        <!-- ============================================================== -->
                        <!-- end profile -->
                        <!-- ============================================================== -->
                        <!-- ============================================================== -->
                        <!-- campaign data -->
                        <!-- ============================================================== -->
                        <div class="col-xl-9 col-lg-9 col-md-7 col-sm-12 col-12">
                            <!-- ============================================================== -->
                            <!-- campaign tab one -->
                            <!-- ============================================================== -->
                            <div class="influence-profile-content pills-regular">
                            <!--     <ul class="nav nav-pills mb-3 nav-justified" id="pills-tab" role="tablist">
                                    <li class="nav-item">
                                        <a class="nav-link active" id="pills-campaign-tab" data-toggle="pill" href="#pills-campaign" role="tab" aria-controls="pills-campaign" aria-selected="true">Info</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" id="pills-packages-tab" data-toggle="pill" href="#pills-packages" role="tab" aria-controls="pills-packages" aria-selected="false">성적</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" id="pills-review-tab" data-toggle="pill" href="#pills-review" role="tab" aria-controls="pills-review" aria-selected="false">Reviews</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" id="pills-msg-tab" data-toggle="pill" href="#pills-msg" role="tab" aria-controls="pills-msg" aria-selected="false">Send Messages</a>
                                    </li>
                                </ul> --> <!-- 탭이 있었던 자리 --> 
                                <div class="tab-content" id="pills-tabContent">
                                    <div class="tab-pane fade show active" id="pills-campaign" role="tabpanel" aria-labelledby="pills-campaign-tab">
                                        <div class="row">
                                            <!-- <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                                <div class="section-block">
                                                    <h3 class="section-title">Detail</h3>
                                                </div>
                                            </div> --> <!-- 제목 -->
                                           <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12 col-12">
                                                <div class="card">
                                                    <div class="card-body">
                                                       <h1 class="mb-1">${gvo.agency}</h1>
                                                        <p>소속</p>
                                                    </div>
                                                </div>
                                            </div>
                                           
                                            <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12 col-12">
                                                <div class="card">
                                                    <div class="card-body">
                                                       <h1 class="mb-1">${gvo.p_weight}kg</h1> 
                                                        <p>기승가능중량</p>
                                                    </div>
                                                </div>
                                            </div>
                 
                                            <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12 col-12">
                                                <div class="card">
                                                    <div class="card-body">
                                                        <h1 class="mb-1">${gvo.place}</h1> 
                                                        <p>지역</p>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12 col-12">
                                                <div class="card">
                                                    <div class="card-body">
                                                      <h1 class="mb-1">${gvo.p_debut}</h1>
                                                        <p>데뷔</p>  
                                                    </div>
                                                </div>
                                            </div>
                                           
                                        </div>
                                        <!-- <div class="section-block">
                                            <h3 class="section-title">전적</h3>
                                        </div> -->
                                       

                                        <div class="card" id="prize_darkhorse" >
                                            <div class="card-body" >
                                      		  <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12"  >
                                                <div class="row">
                                                   
                                                        <div class="media influencer-profile-data d-flex align-items-center p-2">
                                                           <div class="media-body ">
                                                                <div class="influencer-profile-data">
                                                                   <!--  <h3 class="m-b-10">전적</h3> -->
                                                                    <h4><i class="fa fa-trophy"></i>수상내역</h4>
                                                                    <p>
                                                                   	
                                                                     <c:forEach items="${prizelist}" var="prizevo">  
                                                                     <c:if test="${not empty prizevo.p_prize}">
                                                                   		 <!-- 이부분이 반복돼서 뿌려지면 됨 --> 
                                                                       
                                                                        <span class="m-r-20 d-inline-block">경주명
                                                                            <span class="m-l-10 text-primary">${prizevo.p_prize}</span> 
                                                                        </span>
                                                                        <span class="m-r-20 d-inline-block">경주일자
                                                                            <span class="m-l-10 text-secondary">${prizevo.g_date}</span> 
                                                                        </span>
                                                                            <span class="m-r-20 d-inline-block">마명  
                                                                            <span class="m-l-10  text-info">${prizevo.hrname}</span> 
                                                                        </span>
                                                                       
                                                                        <br>
                                                                        </c:if>
                                                                        </c:forEach>
                                                                        <!-- 여기까지 -->
                                                                        <!-- ============================================================== -->

									<!-- 헤드없는 테이블 -->
									<%-- <table class="table">
                                        
                                        
                                         <c:forEach items="${prizelist}" var="prizevo"> 
                                            <tr>
                                                <td class="m-l-10 text-primary">${prizevo.p_prize} 우승</td>
                                                <td class="m-l-10 text-secondary">${prizevo.g_date}</td>
                                                <td class="m-l-10  text-info">${prizevo.hrname}</td> 
                                            </tr>
                                            </c:forEach>
                                       
                                    </table> --%>

                                   
                                                                    </p>
                                                                    
                                                                </div>
                                                            </div>
                                                      
                                                             
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                           
                                           
                                            <div class="border-top card-footer p-0">
                                                <div class="campaign-metrics d-xl-inline-block" style="float:left; width:32%; ">
                                                    <h5 class="mb-0 ">통산</h5>
                                                    <p><span class="m-l-10 text-secondary">${gvo.p_win_cnt_all} </span></p> 
                                                </div>
                                                <div class="campaign-metrics d-xl-inline-block" style="float:left; width:27%; ">
                                                    <h5 class="mb-0 ">최근1년</h5>
                                                    <p><span class="m-l-10 text-primary">${gvo.p_win_cnt_year}</span></p> 
                                                </div>
                                                <div class="campaign-metrics d-xl-inline-block" style="float:left; width:20%; ">
                                                    <h5 class="mb-0">승률(통산)</h5>
                                                    <p><span class="m-l-10  text-info">${gvo.p_win_rate_all}%</span></p> 
                                                </div>
                                         		<div class="campaign-metrics d-xl-inline-block" style="float:left; width:20%; ">
                                                    <h5 class="mb-0">승률(1년)</h5>
                                                    <p><span class="m-l-10  text-info">${gvo.p_win_rate_year}%</span></p> 
                                                </div>
                                                
                                            </div>
                                        </div>
                                        
                                      
                                      
                                          <!-- 여기 차트-->

										<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
											<div class="card">
												<div class="card-body">
													<canvas id="myChart" height="100px"></canvas>

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
<script src="https://kit.fontawesome.com/7e5d0aa0b2.js" crossorigin="anonymous"></script>
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


///////// chart  ////////////////////////
 
        var firstarr =${firstlist};
        var secondarr =${secondlist};
      var month = ${chartlist};
      
        var ctx = document.getElementById('myChart').getContext('2d');
        var chart = new Chart(ctx, {
            // The type of chart we want to create
            type: 'line',

            // The data for our dataset
            data: {
                labels: month,
                datasets: [{
                    label: '1위',
                    borderColor: 'rgba(204,101,254)',
                    backgroundColor: 'rgba(0,0,0,0)',
                    data: firstarr,
                    borderWidth: 3.5,

                },
                {
                   label: '2위',
                    borderColor: 'rgba(253,254,101)',
                    backgroundColor: 'rgba(0,0,0,0)',
                    data: secondarr,
                    borderWidth: 3.5,
                },
                ]
        
            },

            // Configuration options go here
            options: {
                animation: {
                       animateScale: true
                   },
                scales: {
                     yAxes: [{
                         position: 'left',
                         scaleLabel: {
                             display: true,
                             labelString: '횟수',
                           },
                           ticks: {
                               beginAtZero: true                                                                    
                           },
                           gridLines: {
                               // You can change the color, the dash effect, the main axe color, etc.
                               borderDash: [8, 4],
                           } 
                     }],
                     xAxes: [{
                           gridLines: {
                               // You can change the color, the dash effect, the main axe color, etc.
                               borderDash: [8, 4],
                           } 
                     }],
                 },
                 title: {
                     display: true,
                     text: '2019년 성적',
                     fontColor: 'black',
                     position:'top',
                 }


               
            }
        });

</script>

</body>
 
</html>