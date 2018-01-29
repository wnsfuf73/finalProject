/**
 * 
 */

var insertError = "업로드 실패하였습니다. \n확인 후 다시 시도하세요.";
var insertReviewError = "리뷰등록에 실패하였습니다. \n확인 후 다시 시도하세요.";
var reviewDeleteError = "리뷰삭제에 실패하였습니다. \n확인 후 다시 시도하세요."


//에러메세지
function errorAlert(errorMsg){
	alert(errorMsg);
	window.history.back(); // 이전 페이지로 이동.
	
}