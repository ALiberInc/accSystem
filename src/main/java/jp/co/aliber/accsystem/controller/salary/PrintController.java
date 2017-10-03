package jp.co.aliber.accsystem.controller.salary;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.aliber.accsystem.form.salary.PrintFrom;
import jp.co.aliber.accsystem.service.UtilService;

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
     * メール送信画面
     *
     * @param locale
     * @param model
     * @param form
     *            メール送信画面FORM
     * @param sendMailStr
     * @return
     * @throws IOException
     */
    @RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
    public void index(Locale locale, Model model, PrintFrom form,
            @RequestParam(value = "employeeId", required = false) String employeeId,
            @RequestParam(value = "compId", required = false) String compId,
            @RequestParam(value = "salaryYearMonth", required = false) String salaryYearMonth,
            HttpServletResponse response,
            HttpServletRequest request) throws IOException {
        String pdfPath = utilService.creationPdf(Integer.parseInt(employeeId), Integer.parseInt(compId),
                salaryYearMonth);
        response.setContentType("application/pdf");

        ServletOutputStream sos = response.getOutputStream();
        File pdf = null;
        FileInputStream fis = null;
        byte[] buffer = new byte[1024 * 1024];
        pdf = new File(pdfPath);
        response.setContentLength((int) pdf.length());
        fis = new FileInputStream(pdf);
        while ((fis.read(buffer, 0, 1024 * 1024)) != -1) {
            sos.write(buffer, 0, 1024 * 1024);
        }
        sos.close();
        fis.close();
    }
}
