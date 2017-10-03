package jp.co.aliber.accsystem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jp.co.aliber.accsystem.bean.SalaryBean;
import jp.co.aliber.accsystem.service.UtilService;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class TestClass {

    @Autowired
    private UtilService utilService;

    public static void main(String[] args) {
        // jasperファイルのパス
        String jasperPath = System.getProperty("user.dir")+"\\target\\classes\\Blank_A4_Landscape.jasper";
        // 出力PDFファイルのパス
        String pdfPath = "C:\\git\\accSystem\\src\\main\\resources\\templates\\Blank_A4_Landscape.pdf";

        try {

            // データの動的バインド
            List<SalaryBean> list = new ArrayList<SalaryBean>();
            SalaryBean site = new SalaryBean();
            site.setName("孫五本");
            site.setDepartment("開発部");
            site.setCode("112");
            site.setYear("1994");
            site.setMonth("06");
            site.setDay("17");
            // 出勤日数
            site.setDaysAttendance("");
            // 勤務時間
            site.setWorkingHours("");
            // 時間外手当
            site.setOvertimeAllowance("");
            // 深夜労働
            site.setLateNightLabor("");
            // 深夜残業
            site.setLateNightOvertime("");
            // 休日出勤
            site.setHolidayWork("");
            // 休日残業
            site.setRestDay("");
            // 欠勤
            site.setAbsence("");
            // 遅刻
            site.setLate("");
            // 早退
            site.setLeaveEarly("");
            // 税額表
            site.setTaxSchedule("甲欄");
            // 扶養人数
            site.setNumberOfDependents("");
            // 基本給
            site.setBasicSalary("111");
            // 役職手当
            site.setJobAllowance("111");
            // 資格手当
            site.setQualificationAllowance("111");
            // 住宅手当
            site.setHousingAllowance("111");
            // 家族手当
            site.setFamilyAllowance("111");
            // 交通費
            site.setTransportationCosts("111");
            // その他の手当
            site.setOtherAllowance("111");
            // 支給合計
            site.setTotalSupply("111");

            // 健康保険
            site.setHealthInsurance("111");
            // 厚生年金
            site.setWelfareInsurance("111");
            // 雇用保険
            site.setEmployInsurance("111");
            // 所得税
            site.setIncomeTax("111");
            // 住名税
            site.setLivingTax("111");
            // 積立金
            site.setAccumulateGold("111");
            // 借入等返済
            site.setRepaymentOfBorrowings("111");
            // 年末控除
            site.setYearendDeduction("111");
            // 家賃控除
            site.setRentDeduction("111");
            // 控除合計
            site.setTotalDeduction("111");

            // その他の控除
            site.setOtherDeductions("111");
            // ALLその他の控除
            site.setAllOtherDeductions("111");
            // 差引支給額
            site.setSubscriptionAmount("111");
            // その他の控除
            site.setOtherDeductions("111");
            // 累計社会保険料
            site.setCumulativeSocialInsurancePremium("111");
            // 所得税
            site.setCumulativeIncomeTax("111");
            Integer cumulativeTaxableAmount = Integer.parseInt(site.getTotalSupply()) - Integer.parseInt(site.getTransportationCosts());
            // 課税支給額
            site.setCumulativeTaxableAmount("111");
            // 振込支給額
            site.setTransferPaymentAmount("111");
            // 振込支給額合計
            site.setTotaltransferPaymentAmount("111");
            // 現金支給額
            site.setCashPaymentAmount("0");
            // 現物支給額
            site.setInkindPaymentAmount("0");
            list.add(site);

            JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(list);
            JasperRunManager.runReportToPdfFile(jasperPath, pdfPath, null, ds);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
