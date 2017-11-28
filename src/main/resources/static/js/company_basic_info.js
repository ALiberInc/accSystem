$('input[type=radio][name=deadlineDay]').change(function() {
	if (this.value == '0') {
		$('#deadlineAdjustDays').attr("readonly", "readonly");
		$("#deadlineAdjustDays").val("");
	} else {
		$('#deadlineAdjustDays').removeAttr("readonly");
	}
});
$('input[type=radio][name=paymentDay]').change(function() {
	if (this.value == '0') {
		$('#paymentAdjustDays').attr("readonly", "readonly");
		$("#paymentAdjustDays").val("");
	} else {
		$('#paymentAdjustDays').removeAttr("readonly");
	}
});
$('#addcompDept')
		.click(
				function() {
					var addindex = $("#addInput input").length;
					var inputStr = '<input type="text" maxlength="10" class="td1" id="compDeptList'
							+ addindex
							+ '.deptName" name="compDeptList['
							+ addindex + '].deptName" value="" />'+" ";
					$('#addInput').append(inputStr);
				});