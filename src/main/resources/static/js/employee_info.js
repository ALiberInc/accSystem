function employeeSearch(flag) {

}
function employeeShow(companyId){
	var root = getContextPath();
	window.open(root+"employee_info_edit?emplyeeId="+companyId);
}
function employeeAdd(){
	var root = getContextPath();
	window.open(root+"employee_info_edit");
}