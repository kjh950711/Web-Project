<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--
=========================================================
* Argon Dashboard - v1.2.0
=========================================================
* Product Page: https://www.creative-tim.com/product/argon-dashboard

* Copyright  Creative Tim (http://www.creative-tim.com)
* Coded by www.creative-tim.com
=========================================================
* The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
-->
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="Start your development with a Dashboard for Bootstrap 4.">
  <meta name="author" content="Creative Tim">
  <title>전사 결과 통계 분석 사이트</title>
  <!-- Favicon -->
  <link rel="icon" href="resources/assets/img/brand/favicon.png" type="image/png">
  <!-- Fonts -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700">
  <!-- Icons -->
  <link rel="stylesheet" href="resources/assets/vendor/nucleo/css/nucleo.css" type="text/css">
  <link rel="stylesheet" href="resources/assets/vendor/@fortawesome/fontawesome-free/css/all.min.css" type="text/css">
  <!-- Argon CSS -->
  <link rel="stylesheet" href="resources/assets/css/argon.css?v=1.2.0" type="text/css">
</head>

<body class="bg-default">
  <!-- Main content -->
  <div class="main-content">
    <!-- Header -->
    <div class="header bg-gradient-primary py-7 py-lg-8 pt-lg-9">
      <div class="container">
        <div class="header-body text-center mb-7">
          <div class="row justify-content-center">
            <div class="col-xl-5 col-lg-6 col-md-8 px-5">
              <h1 class="text-white" style="font-size: 2.5em;">Welcome!</h1>
              <p class="text-lead text-white" style="font-size: 1.1em;">분석하고 싶은 파일을 업로드 해주세요.</p>
            </div>
          </div>
        </div>
      </div>
      <div class="separator separator-bottom separator-skew zindex-100">
        <svg x="0" y="0" viewBox="0 0 2560 100" preserveAspectRatio="none" version="1.1" xmlns="http://www.w3.org/2000/svg">
          <polygon class="fill-default" points="2560 0 2560 100 0 100"></polygon>
        </svg>
      </div>
    </div>
    
    <!-- Page content -->
    <div class="container mt--8 pb-5">
      <div class="row justify-content-center">
        <div class="col-lg-5 col-md-7">
          <div class="card bg-secondary border-0 mb-0">
            <div class="card-header bg-transparent pb-5">
            
              <!--=========== 파일 전송 ==========-->
              <div class="text-muted text-center mt-2 mb-3" style="font-size: 1.2em;"><small>파일 찾기</small></div>
				<form method="post" action="./result" enctype="multipart/form-data" onsubmit="return yamaeSubmit()">
				<div class="text-center">
					<input type="file" name="xmlFile" required="required"/><br>
					<a id="errorMessage" style="color: red;"></a><br>
					<input class="btn btn-primary my-4" type="button" onclick="validFile()" value="파일 검사">
					<input type="hidden" id="yamae">
					<hr>
				</div>
				
				<!--=============== 태그 지정 ===============-->
	            <div class="card-body px-lg-5 py-lg-3">
					<div class="text-center text-muted mb-4" style="font-size: 1.2em;">
					  <small>분석 범위 선택</small>
					</div>
                <div class="form-group mb-3">
                  <div class="input-group input-group-merge input-group-alternative" style="text-align: center;">
                    <!-- <div class="input-group-prepend">
                      <span class="input-group-text"><i class="ni ni-email-83"></i></span>
                    </div> -->
                    <div>
	                    &nbsp;&nbsp;&nbsp;<input class="" type="checkbox" name="all" value="all" onClick="checkDisable(this.form)" id="all" />전체 데이터&nbsp;&nbsp;&nbsp;
	                    <input class="" type="checkbox" name="part" id="part" value="part" onclick="checkDisable2(this.form)"/>태그 지정
                    </div>
                  </div>
                </div>
                <div class="form-group mb-3">
                  <div class="input-group input-group-merge input-group-alternative">
                    <!-- <div class="input-group-prepend">
                      <span class="input-group-text"><i class="ni ni-lock-circle-open"></i></span>
                    </div> -->
                    <input class="form-control" placeholder="episode" type="text" name="episode">
                  </div>
                </div>
                <div class="form-group mb-3">
                  <div class="input-group input-group-merge input-group-alternative">
                    <!-- <div class="input-group-prepend">
                      <span class="input-group-text"><i class="ni ni-lock-circle-open"></i></span>
                    </div> -->
                    <input class="form-control" placeholder="scene" type="text" name="scene">
                  </div>
                </div>
                <div class="form-group mb-3">
                  <div class="input-group input-group-merge input-group-alternative">
                    <!-- <div class="input-group-prepend">
                      <span class="input-group-text"><i class="ni ni-lock-circle-open"></i></span>
                    </div> -->
                    <input class="form-control" placeholder="speaker" type="text" name="speaker">
                  </div>
                </div>
                <div class="text-center text-muted mb-4" style="font-size: 1em;">
					  <small>다중 태그 입력시 '/'로 구분하여 입력</small>
					</div>
	            <div class="text-center">
                      <button type="submit" class="btn btn-primary my-4">분석 실행</button>
                </div>
				</div>
				</form>
            </div>
            
          </div>
          <div class="row mt-3">
            <div class="col-6">
              <a href="http://www.saltlux.com/index.do" class="text-light"><small>saltlux</small></a>
            </div>
            <div class="col-6 text-right">
              <a href="https://ko.wikipedia.org/wiki/%ED%98%95%ED%83%9C_%EB%B6%84%EC%84%9D" class="text-light"><small>형태소 분석 이란?</small></a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Footer -->
  <footer class="py-5" id="footer-main">
    <div class="container">
      <div class="row align-items-center justify-content-xl-between">
        <div class="col-xl-6">
          <div class="copyright text-center text-xl-left text-muted">
            &copy; 2020 <a href="https://www.creative-tim.com" class="font-weight-bold ml-1" target="_blank">Creative JeongHyeon</a>
          </div>
        </div>
        <!-- <div class="col-xl-6">
          <ul class="nav nav-footer justify-content-center justify-content-xl-end">
            <li class="nav-item">
              <a href="https://www.creative-tim.com" class="nav-link" target="_blank">Creative Kim</a>
            </li>
            <li class="nav-item">
              <a href="https://www.creative-tim.com/presentation" class="nav-link" target="_blank">About Us</a>
            </li>
            <li class="nav-item">
              <a href="http://blog.creative-tim.com" class="nav-link" target="_blank">Blog</a>
            </li>
            <li class="nav-item">
              <a href="https://github.com/creativetimofficial/argon-dashboard/blob/master/LICENSE.md" class="nav-link" target="_blank">MIT License</a>
            </li>
          </ul>
        </div> -->
      </div>
    </div>
  </footer>
  <!-- Argon Scripts -->
  <!-- Core -->
  <script src="resources/assets/vendor/jquery/dist/jquery.min.js"></script>
  <script src="resources/assets/vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
  <script src="resources/assets/vendor/js-cookie/js.cookie.js"></script>
  <script src="resources/assets/vendor/jquery.scrollbar/jquery.scrollbar.min.js"></script>
  <script src="resources/assets/vendor/jquery-scroll-lock/dist/jquery-scrollLock.min.js"></script>
  <!-- Argon JS -->
  <script src="resources/assets/js/argon.js?v=1.2.0"></script>
  
  <!-- 파일 검증 -->
  <script type="text/javascript" charset="UTF-8">
  
	async function validFile(){
		var target = document.getElementById("errorMessage");
		var file = document.querySelector('input[type="file"]');

		if(file.files[0] == null) {
			target.innerHTML = "파일을 선택해 주세요";
			return;
		}
		
		var formData = new FormData();
		formData.append('xmlFile', file.files[0]);
		formData.append('Content-Type','text/plain; charset=utf-8');
		
		fetch("./valid",{
			method: 'POST',
			body: formData
		}).then(function(response){
			response.text().then(function(data){
				if(data == "true"){
					target.innerHTML = "유효한 파일입니다.";
					target.style = "color : blue;";
					document.getElementById("yamae").value = 1;
				}else{
					target.innerHTML = data;
					
				}
			});
		})
	}
	
	function yamaeSubmit(){
		var i = document.getElementById("yamae").value;
		if(i != 1) {
			alert("파일 유효성 검사가 필요합니다.");
			return false;
		}
	}
 </script>
 
 <!-- 체크박스 비활성화 -->
 <script type="text/javascript" charset="UTF-8">
	function checkDisable(form){
		if( form.all.checked == true ){
			form.episode.disabled = true;
			form.scene.disabled = true;
			form.speaker.disabled = true;
			document.getElementById("part").checked = false;
		} else {
			form.episode.disabled = false;
			form.scene.disabled = false;
			form.speaker.disabled = false;
		}
	}
	
	function checkDisable2(form){
		document.getElementById("all").checked = false;
		form.episode.disabled = false;
		form.scene.disabled = false;
		form.speaker.disabled = false;
	}
 </script>
 
</body>

</html>