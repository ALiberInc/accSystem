function callAjax(p_url, param) {
	return $.ajax({
		type : 'POST',
		url : p_url,
		dataType : 'json',
		data : param,
		async : false,
        headers: {
            'X-CSRF-TOKEN': $('*[name="_csrf"]').val()
        },
		success : function(data) {
			return data;
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			checkAjaxError(XMLHttpRequest, textStatus, errorThrown);
		}
	}).responseText;
}

function getContextPath() {
	var path = './';
	var e = document.createElement('span');
	e.innerHTML = '<a href="' + path + '" />';
	url = e.firstChild.href;
	var p = url.split('/');
	return '/' + p[3] + '/';
}