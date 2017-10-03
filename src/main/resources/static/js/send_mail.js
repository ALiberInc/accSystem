function SendMail() {
	console.log(document.getElementById('Body1').innerText);
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
				'subject' : $("#Subject").val(),
				'body1' : $("#Body1").val(),
				'body2' : $("#Body2").val()
			}
		} else {
			param = {
				'sendMailStr' : $("#sendMailStr").val(),
				'forName' : $("#Name").val(),
				'bodyType' : 0,
				'subject' : $("#AutoSubject").text(),
				'body1' : $("#AutoBody1").text(),
				'body2' : $("#AutoBody2").text()
			}
		}
		var paramUrl = $("#fm").attr("action");
		var result = callAjax(paramUrl, param);
		result = JSON.parse(result);
		if (result.result_cd == 0) {
			window.close();
		} else {
			alert("メールが送信失敗しました");
		}
	}
}
function ChgBodyType() {
	if ($('#bodyType0').is(':checked')) {
		document.getElementById('Subject').style.display = 'none';
		document.getElementById('AutoSubject').style.display = 'block';
		document.getElementById('Body1').style.display = 'none';
		document.getElementById('Body2').style.display = 'none';
		document.getElementById('AutoBody1').style.display = 'block';
		document.getElementById('AutoBody2').style.display = 'block';
	} else {
		document.getElementById('Subject').style.display = 'block';
		document.getElementById('AutoSubject').style.display = 'none';
		document.getElementById('Body1').style.display = 'block';
		document.getElementById('Body2').style.display = 'block';
		document.getElementById('AutoBody1').style.display = 'none';
		document.getElementById('AutoBody2').style.display = 'none';
	}
}
