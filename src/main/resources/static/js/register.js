$(document).ready(function() {
	compNameSearch();
	// 選択された会社IDを保持
	var compIdChecked = $("#compId").val();
	$("#compInfoRadio" + compIdChecked).prop("checked", true)
});
function compNameSearch() {
	$("#searchTable").remove();
	var compName = $("#compName").val();
	var url = getContextPath();
	if (compName == "") {
		return false;
	}
	var param = {
		'compName' : compName
	}
	// 処理呼び出し
	var paramUrl = url + "register/search";
	var result = callAjax(paramUrl, param);
	if (result == "{}") {
		return false;
	}
	result = JSON.parse(result);
	var htmlStr = "<table id='searchTable' class='table table-striped table-bordered'><tr><th class='text-center'></th><th class='text-center'><span>会社名前</span></th><th class='text-center'><span>会社電話</span></th><th class='text-center'><span>会社住所</span></th></tr>";
	for ( var o in result) {
		if (result[o] != null) {
			htmlStr += "<tr><td class='text-center'><input onclick='changeCompId(this.value)' name='searchCompId' type='radio' id='compInfoRadio"
					+ result[o].compId
					+ "' value='"
					+ result[o].compId
					+ "' /><td class='text-center'><span>"
					+ result[o].compName
					+ "</span></td><td class='text-center'><span>"
					+ result[o].compTel
					+ "</span></td></td><td class='text-center'><span>"
					+ result[o].compAdd + "</span></td></tr>"
		}
	}
	htmlStr += "</table>"

	$("#compNameTd").append(htmlStr);
}

function changeCompId(compId) {
	$("#compId").val(compId);
}