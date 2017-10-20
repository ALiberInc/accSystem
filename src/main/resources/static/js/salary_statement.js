$('#sendMail').click(
		function() {
			var chk_value = [];
			$('input[name="salaryCheckBox"]:checked').each(function() {
				chk_value.push($(this).val());
			});
			if (chk_value.length > 0) {
				window.open(getContextPath() + "send_mail?sendMailStr="
						+ chk_value.join(",") + "&yearMonth="
						+ $('#salaryYear').val() + $('#salaryMonth').val(), "",
						"location=no,top=" + (screen.width - 1600) / 2
								+ ",left=" + (screen.width - 600) / 2
								+ ",width=700,height=600");
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
						+ chk_value.join(",") + "&compId=" + $('#compId').val()
						+ "&salaryYearMonth=" + $('#salaryYear').val()
						+ $('#salaryMonth').val());
			} else {
				alert("誰も選択されていません。")
			}
		});

$('#salaryDetailChange').click(
		function() {
			var chk_value = [];
			$('input[name="salaryCheckBox"]:checked').each(function() {
				chk_value.push($(this).val());
			});
			if (chk_value.length == 1) {
				var url = getContextPath() + "detail?employeeId=" + chk_value
						+ "&yearMonth=" + $('#salaryYear').val()
						+ $('#salaryMonth').val();
				window.open(url);
			}
			if (chk_value.length == 0) {
				alert("誰も選択されていません。")
			}

			if (chk_value.length > 1) {
				alert("1つを選択してください。")
			}
		});