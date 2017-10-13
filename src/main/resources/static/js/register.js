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
	var htmlStr = "<table id='searchTable' class='table table-striped table-bordered'><tr><td class='text-center'></td><td class='text-center'><span>会社名前</span></td><td class='text-center'><span>会社電話</span></td><td class='text-center'><span>会社住所</span></td></tr>";
	for ( var o in result) {
		if (result[o] != null) {
			htmlStr += "<tr><td class='text-center'><input onclick='changeCompId(this.value)' name='compId' type='radio' value='"
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
	if (htmlStr != null) {
		$("#compNameTd").append(htmlStr);
	}
}
function changeCompId(compId) {
	$("#compId").val(compId);
}