function goToSendMail() {
	var chk_value = [];
	$('input[name="monthlyCheckBox"]:checked').each(function() {
		chk_value.push($(this).val());
	});
	if (chk_value.length > 0) {
		var root = getContextPath();
		window.open(root + "send_mail?sendMailStr=" + chk_value.join(","),"","location=no,top="+(screen.width - 1600) / 2+",left="+(screen.width - 600) / 2+",width=700,height=600");
	} else {
		alert("誰も選択されていません。")
	}
}

function checkBoxSelectAll(){
	var notCheckNo = $('input[name="monthlyCheckBox"]:not(:checked)').length;
	if (notCheckNo> 0) {
			$("input[name='monthlyCheckBox']").attr("checked","true");
	} else {
		$("input[name='monthlyCheckBox']").removeAttr("checked");
	}
}

function salaryPrint(){
	var chk_value = [];
	$('input[name="monthlyCheckBox"]:checked').each(function() {
		chk_value.push($(this).val());
	});
	if (chk_value.length > 0) {
		var root = getContextPath();
		window.open(root + "print?employeeId=" + chk_value.join(",")+"&compId=1&salaryYearMonth=201709","","location=no,top="+(screen.width - 1600) / 2+",left="+(screen.width - 600) / 2+",width=700,height=600");
	} else {
		alert("誰も選択されていません。")
	}
}