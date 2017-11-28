package jp.co.aliber.accsystem.controller.salary;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.regex.Pattern;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.aliber.accsystem.ImmutableValues;
import jp.co.aliber.accsystem.entity.auto.TSalaryDetail;
import jp.co.aliber.accsystem.form.common.MessageForm;
import jp.co.aliber.accsystem.security.LoginUser;
import jp.co.aliber.accsystem.service.UtilService;
import jp.co.aliber.accsystem.service.salary.SalaryDetailsInputService;
import net.sf.jasperreports.engine.JRException;

/**
 * 給与明細印刷画面
 *
 * @author son_k
 *
 */
@Controller
@RequestMapping("/print")
public class PrintController {

	@Autowired
	private UtilService utilService;
	@Autowired
	private SalaryDetailsInputService salaryDetailsInputService;

	/**
	 * データのバンディング
	 *
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}


	/**
	 * @param loginUser
	 * @param employeeIdCommaSeperated
	 * @param salaryYearMonth
	 * @param messageForm
	 * @return
	 */
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String index(@AuthenticationPrincipal LoginUser loginUser,
			@RequestParam(value = "employeeId", required = true) String employeeIdCommaSeperated,
			@RequestParam(value = "salaryYearMonth", required = true) String salaryYearMonth, MessageForm messageForm) {

		String[] employeeIdStrArray = employeeIdCommaSeperated.split(Pattern.quote(","));
		for (String employeeId : employeeIdStrArray) {
			TSalaryDetail salaryDetail = salaryDetailsInputService.getSalaryDetail(Integer.valueOf(employeeId),
					loginUser.getUser().getCompId(), salaryYearMonth);
			if (salaryDetail == null) {
				// メッセージ情報を設定
				messageForm.setMessage(ImmutableValues.NO_SALARY_DETAIL_INPUT);
				messageForm.setForwardURL(ImmutableValues.FORWARD_SALARY_STATEMENT);
				return "message";
			}
		}

		return "redirect:/print/salaryDetailPDF?employeeId=" + employeeIdCommaSeperated + "&salaryYearMonth="
				+ salaryYearMonth;
	}


	/**
	 * @param loginUser
	 * @param employeeIdCommaSeperated
	 * @param salaryYearMonth
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = { "/salaryDetailPDF" }, method = RequestMethod.GET)
	public void printSalaryDetail(@AuthenticationPrincipal LoginUser loginUser,
			@RequestParam(value = "employeeId", required = true) String employeeIdCommaSeperated,
			@RequestParam(value = "salaryYearMonth", required = true) String salaryYearMonth,
			HttpServletResponse response, HttpServletRequest request) {

		response.setContentType("application/pdf");

		try {
			response.setHeader("Content-Disposition",
					"filename=" + URLEncoder.encode("給与明細書" + salaryYearMonth + ".pdf", "UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		Integer[] employeeIdArray = Arrays.stream(employeeIdCommaSeperated.split(",")).map(Integer::valueOf)
				.toArray(Integer[]::new);
		try (ByteArrayOutputStream pdfOutputStream = utilService
				.creationPdfOutputStream(loginUser.getUser().getCompId(), salaryYearMonth, employeeIdArray);
				ServletOutputStream sos = response.getOutputStream()) {
			sos.write(pdfOutputStream.toByteArray());
		} catch (NumberFormatException | JRException | IOException e) {
			e.printStackTrace();
		}
	}

}
