$('#sendMail').click(
		function() {
			var chk_value = [];
			$('input[name="salaryCheckBox"]:checked').each(function() {
				chk_value.push($(this).val());
			});
			if (chk_value.length > 0) {
				window.open(getContextPath() + "send_mail?sendMailStr="
						+ chk_value.join(","), "", "location=no,top="
						+ (screen.width - 1600) / 2 + ",left="
						+ (screen.width - 600) / 2 + ",width=700,height=600");
			} else {
				alert("誰も選択されていません。")
			}
		});

$('#checkAll').click(function() {
	var checkBoxArray = $('input[name="salaryCheckBox"]');
	if (checkBoxArray.length != $("input:checked").length) {
		checkBoxArray.each(function() {
			$(this).prop("checked", true);
		});
	} else {
		checkBoxArray.each(function() {
			$(this).prop("checked", false);
		});
	}
});

$('#salaryPrint').click(
		function() {
			var chk_value = [];
			$('input[name="salaryCheckBox"]:checked').each(function() {
				chk_value.push($(this).val());
			});
			if (chk_value.length > 0) {
				window.open(getContextPath() + "print?employeeId="
						+ chk_value.join(",")
						+ "&compId=1&salaryYearMonth=201709", "", "");
			} else {
				alert("誰も選択されていません。")
			}
		});