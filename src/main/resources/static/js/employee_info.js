$('button[name="show_btn"]').each(
		function() {
			$(this).click(
					function() {
						window.location.href=getContextPath()
								+ "employee_info_edit?emplyeeId="
								+ $(this).attr('id');

					});
		});

$('#add_btn').click(function() {
	window.location.href=getContextPath() + "employee_info_edit";
});