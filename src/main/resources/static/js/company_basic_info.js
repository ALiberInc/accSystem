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