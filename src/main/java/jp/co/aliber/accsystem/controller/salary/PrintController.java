package jp.co.aliber.accsystem.controller.salary;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.aliber.accsystem.service.UtilService;
import net.sf.jasperreports.engine.JRException;

/**
 * メール送信画面
 *
 * @author son_k
 *
 */
@Controller
@RequestMapping("/print")
public class PrintController {

	@Autowired
	private UtilService utilService;

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
	 * @param employeeId
	 * @param compId
	 * @param salaryYearMonth
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public void index(@RequestParam(value = "employeeId", required = true) String employeeIdCommaSeperated,
			@RequestParam(value = "compId", required = true) Integer compId,
			@RequestParam(value = "salaryYearMonth", required = true) String salaryYearMonth,
			HttpServletResponse response, HttpServletRequest request) {

		response.setContentType("application/pdf");
		String[] employeeIdArray = employeeIdCommaSeperated.split(",");
		// 複数の従業員の場合は、まだ対応していない  下のソースは一番目の従業員のPDFを出力
		try (ByteArrayOutputStream pdfOutputStream = utilService
				.creationPdfOutputStream(Integer.parseInt(employeeIdArray[0]), compId, salaryYearMonth);
				ServletOutputStream sos = response.getOutputStream()) {
			sos.write(pdfOutputStream.toByteArray());
		} catch (NumberFormatException | JRException | IOException e) {
			e.printStackTrace();
		}
	}

}
