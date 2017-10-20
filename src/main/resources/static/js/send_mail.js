$('#sendMailBtn').click(function() {
	var cmsg = 'メール送信を開始します。\n\n';
	cmsg = cmsg + 'よろしいですか？';
	var res = confirm(cmsg);
	var param;
	if (res == true) {
		if ($('#bodyType0').is(':checked') == false) {
			param = {
				'sendMailStr' : $("#sendMailStr").val(),
				'forName' : $("#Name").val(),
				'bodyType' : 1,
				'body1' : $("#Body").val(),
				'body2' : $("#Body2").val(),
				'compName' : $("#compName").val(),
				'compAddress' : $("#compAddress").val(),
				'compTel' : $("#compTel").val()
			}
		} else {
			param = {
				'sendMailStr' : $("#sendMailStr").val(),
				'forName' : $("#Name").val(),
				'bodyType' : 0,
				'body1' : $("#AutoBody1").text(),
				'body2' : $("#AutoBody2").text(),
				'compName' : $("#compName").val(),
				'compAddress' : $("#compAddress").val(),
				'compTel' : $("#compTel").val()
				
			}
		}
		var paramUrl = $("#sendMailForm").attr("action");
		var result = callAjax(paramUrl, param);
		result = JSON.parse(result);
		if (result.result_cd == 0) {
			window.close();
		} else {
			alert("メールが送信失敗しました");
		}
	}
});

$('input[name="BodyType"]').each(function() {
	$(this).click(function() {
		if ($('#bodyType0').is(':checked')) {
			$('#Subject').hide();
			$('#AutoSubject').show();
			$('#Body1').hide();
			$('#Body2').hide();
			$('#AutoBody1').show();
			$('#AutoBody2').show();
		} else {
			$('#Subject').show();
			$('#AutoSubject').hide();
			$('#Body1').show();
			$('#Body2').show();
			$('#AutoBody1').hide();
			$('#AutoBody2').hide();
		}
	});
});