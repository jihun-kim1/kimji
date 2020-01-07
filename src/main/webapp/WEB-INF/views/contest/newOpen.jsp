<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Contest Open | PicSell</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<style>
	strong {color: crimson;}

/*    기본 글씨체 */
    @font-face {font-family: 'Cafe24Oneprettynight'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.1/Cafe24Oneprettynight.woff') format('woff'); font-weight: normal; font-style: normal; }
/*    공모전 개최 글씨체 */
    @font-face { font-family: 'NanumBarunpen'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_two@1.0/NanumBarunpen.woff') format('woff'); font-weight: normal; font-style: normal; }
</style>
</head>
<body>
	<jsp:include page="../key/top.jsp" flush="false"/>
	
	<div class="container-fluid px-0 py-3" style="background-color: #f4f2f5; font-family: 'Cafe24Oneprettynight';">
		<div class="container p-0">
			<h2 class="mx-3 pt-4 pb-3 px-4 text-center">새로운 공모전 열기</h2>
			<h6 class="mx-3 py-2 px-4">어떤 공모전을 열고 싶으세요?</h6>
			<h6 class="mx-3 py-2 px-4">픽셀 ＇공모전＇을 통해<br>특정 주제의 이미지를 빠르고 효율적으로 공모할 수 있습니다.</h6>
			<h6 class="mx-3 py-2 px-4">아래의 신청 양식을 작성해주시면,<br>확인 후 회원님의 메일로 연락 드리겠습니다!</h6>
			<form class="mx-3 my-5 px-4 py-3" style="font-size: 15px; font-family: 'NanumBarunpen';">
				<fieldset class="form-group">
					<div class="row my-4">
				    	<label class="col-form-label col-3 col-md-2 pt-0">주최이유<strong> * </strong></label>
				      	<div class="col-9 col-md-10">
					        <div class="form-check my-1">
					          	<input class="form-check-input" type="radio" name="gridRadios" id="gridRadios1" value="option1">
					          	<label class="form-check-label" for="gridRadios1">기업 사진 대회 공모전</label>
					        </div>
					        <div class="form-check my-1">
					        	<input class="form-check-input" type="radio" name="gridRadios" id="gridRadios2" value="option2">
					          	<label class="form-check-label" for="gridRadios2">공공기관 사진 대회 공모전</label>
					        </div>
					        <div class="form-check my-1">
					        	<input class="form-check-input" type="radio" name="gridRadios" id="gridRadios3" value="option3">
					          	<label class="form-check-label" for="gridRadios3">AI 이미지 데이터 수집 공모전</label>
					        </div>
					        <div class="form-check my-1">
					        	<input class="form-check-input" type="radio" name="gridRadios" id="gridRadios4" value="option4">
					          	<label class="form-check-label" for="gridRadios4">원하는 특정 이미지를 직접 공모 or 요청</label>
					        </div>
					        <div class="form-check my-1">
					        	<input class="form-check-input" type="radio" name="gridRadios" id="gridRadios5" value="option5">
					          	<label class="form-check-label" for="gridRadios5">기타 :<input type="text" id="others" class="mx-2" style="width: 200px; height: 15px; background: 0; border: 0; border-bottom: 1px solid darkgray;"></label>
					        </div>
				    	</div>
				    </div>
				    <hr>
				    <div class="row my-4 was-validated">
     					<label class="col-form-label col-3 col-md-2 pt-0">타이틀<strong> * </strong></label>
	      				<div class="col-9 col-md-10">
	      					<input type="text" class="form-control" id="validation01" placeholder="예) 일본어로 제작된 수학책/수학문제 수집 공모전" style="font-size: 15px;" required>
	      					<div class="invalid-feedback">주최하실 공모전의 제목을 작성해주세요!</div>
						</div>
				    </div>
				    <hr>
				    <div class="row my-4 was-validated">
     					<label class="col-form-label col-3 col-md-2 pt-0">상세설명<strong> * </strong></label>
	      				<div class="col-9 col-md-10">
	      					<textarea class="form-control invalid" id="validationTextarea01" placeholder="예) 본 공모전은 인공지능 학습용 데이터 구축을 위한 데이터 수집 공모전입니다.&#13;&#10;수집된 데이터는 내부 연구용으로만 사용될 예정이며, 외부 공개되지 않습니다.&#13;&#10;&#13;&#10;기존에 촬영한 사진 혹은, 새로 촬영한 사진을 올려주시면 감사하겠습니다." style="min-height: 200px; font-size: 15px;" required></textarea>
	      					<div class="invalid-feedback">주최하실 공모전에 대한 설명을 자세히 작성해주세요!</div>
						</div>
				    </div>
				    <hr>
				    <div class="row my-4 was-validated">
     					<label class="col-form-label col-3 col-md-2 pt-0">조건사항<strong> * </strong></label>
	      				<div class="col-9 col-md-10">
	      					<textarea class="form-control is-invalid px-2 py-1" id="validationTextarea02" placeholder="조건사항???" style="font-size: 15px;" required></textarea>
	      					<div class="invalid-feedback">주최하실 공모전에 대한 </div>
						</div>
				    </div>
				    <hr>
				    <div class="row my-4 was-validated">
     					<label class="col-form-label col-3 col-md-2 pt-0">기간<strong> * </strong></label>
	      				<div class="col-9 col-md-10">
	      					캘린더 넣기!!!
						</div>
				    </div>
				    <hr>
				    <div class="row my-4 was-validated">
     					<label class="col-form-label col-3 col-md-2 pt-0">상금<strong> * </strong></label>
	      				<div class="col-9 col-md-10">
	      					<input type="text" class="form-control" id="validation02" placeholder="예) 100,000원" style="font-size: 15px;" required>
	      					<div class="invalid-feedback">주최하실 공모전의 상금을 걸어주세요!! (장난으로 작성하실 경우 심사에서 거절 처리 됩니다.)</div>
						</div>
				    </div>
				    <hr>
				    <div class="row my-4">
     					<label class="col-form-label col-3 col-md-2 pt-0">주최기관<strong> * </strong></label>
	      				<div class="col-9 col-md-10">
	      					<div class="form-check my-1">
					          	<input class="form-check-input" type="radio" name="Institution" id="gridRadios6" value="option6">
					          	<label class="form-check-label" for="gridRadios6">기업</label>
					        </div>
					        <div class="form-check my-1">
					        	<input class="form-check-input" type="radio" name="Institution" id="gridRadios7" value="option7">
					          	<label class="form-check-label" for="gridRadios7">개인</label>
					        </div>
						</div>
				    </div>
				</fieldset>
			</form>
		</div>
	</div>
	
	<script>
		// 주최이유 기타 내용 적는 부분 클릭하면 라디오버튼이 기타에 찍힘
		$("#others").on("click", function() {
			$("input[id=gridRadios5]").prop("checked", true);
		})
	</script>
	
	<jsp:include page="../key/bottom.jsp" flush="false"/>
</body>
</html>