$(document).ready(function() {
		$('#healthInsurance').attr("readonly", "readonly");
		$('#welfarePension').attr("readonly", "readonly");
		$('#employmentInsurance').attr("readonly", "readonly");
	})
	$("#healthInsuranceFlag").change(function() {
		if ($('#healthInsuranceFlag').is(':checked')) {
			$('#healthInsurance').removeAttr("readonly");
		} else {
			$('#healthInsurance').attr("readonly", "readonly");
		}
	})
	$("#welfareInsuranceFlag").change(function() {
		if ($('#welfareInsuranceFlag').is(':checked')) {
			$('#welfarePension').removeAttr("readonly");
		} else {
			$('#welfarePension').attr("readonly", "readonly");
		}
	})
	$("#employInsuranceFlag").change(function() {
		if ($('#employInsuranceFlag').is(':checked')) {
			$('#employmentInsurance').removeAttr("readonly");
		} else {
			$('#employmentInsurance').attr("readonly", "readonly");
		}
	})
	function autoCalculate() {
		var totalSalary = 0;
		var totalDeduction = 0;
		var totalInsurance = 0;
		var basicSalary = $('#basicSalary').val();
		if (isNaN(basicSalary)) {
			basicSalary = 0;
		}
		totalSalary = totalSalary + parseInt(basicSalary);
		var positionAllowance = $('#positionAllowance').val();
		if (isNaN(positionAllowance)) {
			positionAllowance = 0;
		}
		totalSalary = totalSalary + parseInt(positionAllowance);
		var qualificationAllowance = $('#qualificationAllowance').val();
		if (isNaN(qualificationAllowance)) {
			qualificationAllowance = 0;
		}
		totalSalary = totalSalary + parseInt(qualificationAllowance);
		var houseAllowance = $('#houseAllowance').val();
		if (isNaN(houseAllowance)) {
			houseAllowance = 0;
		}
		totalSalary = totalSalary + parseInt(houseAllowance);
		var familyAllowance = $('#familyAllowance').val();
		if (isNaN(familyAllowance)) {
			familyAllowance = 0;
		}
		totalSalary = totalSalary + parseInt(familyAllowance);
		var otherAllowance = $('#otherAllowance').val();
		if (isNaN(otherAllowance)) {
			otherAllowance = 0;
		}
		totalSalary = totalSalary + parseInt(otherAllowance);
		var transportFee = $('#transportFee').val();
		if (isNaN(transportFee)) {
			transportFee = 0;
		}
		totalSalary = totalSalary + parseInt(transportFee);
		var healthInsurance = $('#healthInsurance').val();
		if (isNaN(healthInsurance)) {
			healthInsurance = 0;
		}
		totalDeduction = totalDeduction + parseInt(healthInsurance);
		totalInsurance = totalInsurance + parseInt(healthInsurance);
		var welfarePension = $('#welfarePension').val();
		if (isNaN(healthInsurance)) {
			welfarePension = 0;
		}
		totalDeduction = totalDeduction + parseInt(welfarePension);
		totalInsurance = totalInsurance + parseInt(welfarePension);
		var employmentInsurance = $('#employmentInsurance').val();
		if (isNaN(healthInsurance)) {
			employmentInsurance = 0;
		}
		totalDeduction = totalDeduction + parseInt(employmentInsurance);
		totalInsurance = totalInsurance + parseInt(employmentInsurance);
		var incomeTax = $('#incomeTax').val();
		if (isNaN(incomeTax)) {
			incomeTax = 0;
		}
		totalDeduction = totalDeduction + parseInt(incomeTax);
		var inhabitantTax = $('#inhabitantTax').val();
		if (isNaN(inhabitantTax)) {
			inhabitantTax = 0;
		}
		totalDeduction = totalDeduction + parseInt(inhabitantTax);
		var travelFund = $('#travelFund').val();
		if (isNaN(travelFund)) {
			travelFund = 0;
		}
		totalDeduction = totalDeduction + parseInt(travelFund);
		var repaymentBorrowings = $('#repaymentBorrowings').val();
		if (isNaN(repaymentBorrowings)) {
			repaymentBorrowings = 0;
		}
		totalDeduction = totalDeduction + parseInt(repaymentBorrowings);
		var yearendDeduction = $('#yearendDeduction').val();
		if (isNaN(yearendDeduction)) {
			yearendDeduction = 0;
		}
		totalDeduction = totalDeduction + parseInt(yearendDeduction);
		var rentDeduction = $('#rentDeduction').val();
		if (isNaN(rentDeduction)) {
			rentDeduction = 0;
		}
		totalDeduction = totalDeduction + parseInt(rentDeduction);
		var otherDeduction = $('#otherDeduction').val();
		if (isNaN(otherDeduction)) {
			otherDeduction = 0;
		}
		totalDeduction = totalDeduction + parseInt(otherDeduction);
		$("#sum").val(totalSalary);
		$("#totalDeductibleSum").val(totalDeduction);
		$("#socialInsuranceSum").val(totalInsurance);
		var subscriptionAmount = totalSalary - totalDeduction;
		$("#subscriptionAmount").val(subscriptionAmount);
	}