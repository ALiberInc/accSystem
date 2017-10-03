package jp.co.aliber.accsystem.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.aliber.accsystem.bean.SalaryBean;
import jp.co.aliber.accsystem.entity.SelectNameDeptNameParameter;
import jp.co.aliber.accsystem.entity.auto.TSalaryDetail;
import jp.co.aliber.accsystem.mapper.SelectNameDeptNameMapper;
import jp.co.aliber.accsystem.mapper.SelectSeqLastValueMapper;
import jp.co.aliber.accsystem.mapper.auto.TSalaryDetailMapper;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * utilサービス
 *
 * @author son_k
 *
 */
@Service
public class UtilService {

    /** シーケンス生成 */
    @Autowired
    private SelectSeqLastValueMapper selectSeqLastValueMapper;

    /** 従業員給与明細 */
    @Autowired
    private TSalaryDetailMapper tSalaryDetailMapper;

    @Autowired
    SelectNameDeptNameMapper selectNameDeptNameMapper;

    private String jasperPath = System.getProperty("user.dir") + "\\target\\classes\\Blank_A4_Landscape.jasper";

    /**
     * シーケンスを取得
     *
     * @return シーケンス
     */
    public Long getSeqLastValue() {
        return selectSeqLastValueMapper.selectLastValue();
    }

    /**
     * PDFファイルを作成
     *
     * @param employeeId
     *            従業員ID
     * @param compId
     *            会社ID
     * @param salaryYearMonth
     *            給与年月
     * @return
     */
    public String creationPdf(Integer employeeId, Integer compId, String salaryYearMonth) {

        // 日付の確認
        if (salaryYearMonth.length() != 6) {
            return null;
        }

        SelectNameDeptNameParameter selectNameDeptNameParameter = selectNameDeptNameMapper.selectNameDeptName(compId,
                employeeId);

        if (selectNameDeptNameParameter == null) {
            return null;
        }

        // データを取得
        TSalaryDetail tSalaryDetail = tSalaryDetailMapper.selectByPrimaryKey(employeeId, compId, salaryYearMonth);

        if (tSalaryDetail == null) {
            return null;
        }

        // 出力PDFファイルのパス
        String pdfPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\js\\" + employeeId + compId
                + salaryYearMonth + ".pdf";

        List<SalaryBean> salaryBeanList = new ArrayList<SalaryBean>();
        // pdfのbean
        SalaryBean salaryBean = new SalaryBean();

        Date date = new Date();
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy");
        SimpleDateFormat formatter2 = new SimpleDateFormat("MM");
        SimpleDateFormat formatter3 = new SimpleDateFormat("dd");

        // 年
        salaryBean.setYear(formatter1.format(date));
        // 月
        salaryBean.setMonth(formatter2.format(date));
        // 日
        salaryBean.setDay(formatter3.format(date));
        // 氏名
        salaryBean.setName(selectNameDeptNameParameter.getLastName() + selectNameDeptNameParameter.getFirstName());
        // 所属
        salaryBean.setDepartment(selectNameDeptNameParameter.getDeptName());
        // コード
        salaryBean.setCode(selectNameDeptNameParameter.getEmployeeNo() != null
                ? selectNameDeptNameParameter.getEmployeeNo().toString() : "");
        // 出勤日数
        salaryBean.setDaysAttendance("");
        // 勤務時間
        salaryBean.setWorkingHours("");
        // 時間外手当
        salaryBean.setOvertimeAllowance("");
        // 深夜労働
        salaryBean.setLateNightLabor("");
        // 深夜残業
        salaryBean.setLateNightOvertime("");
        // 休日出勤
        salaryBean.setHolidayWork("");
        // 休日残業
        salaryBean.setRestDay("");
        // 欠勤
        salaryBean.setAbsence("");
        // 遅刻
        salaryBean.setLate("");
        // 早退
        salaryBean.setLeaveEarly("");
        // 税額表
        salaryBean.setTaxSchedule("甲欄");
        // 扶養人数
        salaryBean.setNumberOfDependents("");
        // 基本給
        salaryBean.setBasicSalary(
                tSalaryDetail.getBasicSalary() != null ? tSalaryDetail.getBasicSalary().toString() : "0");
        // 役職手当
        salaryBean.setJobAllowance(
                tSalaryDetail.getPositionAllowance() != null ? tSalaryDetail.getPositionAllowance().toString() : "0");
        // 資格手当
        salaryBean.setQualificationAllowance(tSalaryDetail.getQualificationAllowance() != null
                ? tSalaryDetail.getQualificationAllowance().toString() : "0");
        // 住宅手当
        salaryBean.setHousingAllowance(
                tSalaryDetail.getHouseAllowance() != null ? tSalaryDetail.getHouseAllowance().toString() : "0");
        // 家族手当
        salaryBean.setFamilyAllowance(
                tSalaryDetail.getFamilyAllowance() != null ? tSalaryDetail.getFamilyAllowance().toString() : "0");
        // 交通費
        salaryBean.setTransportationCosts(
                tSalaryDetail.getTransportFee() != null ? tSalaryDetail.getTransportFee().toString() : "0");
        // その他の手当
        salaryBean.setOtherAllowance(
                tSalaryDetail.getOtherAllowance() != null ? tSalaryDetail.getOtherAllowance().toString() : "0");
        // 支給合計
        salaryBean.setTotalSupply(tSalaryDetail.getTotalPay() != null ? tSalaryDetail.getTotalPay().toString() : "0");

        // 健康保険
        salaryBean.setHealthInsurance(
                tSalaryDetail.getHealthInsurance() != null ? tSalaryDetail.getHealthInsurance().toString() : "0");
        // 厚生年金
        salaryBean.setWelfareInsurance(
                tSalaryDetail.getWelfareInsurance() != null ? tSalaryDetail.getWelfareInsurance().toString() : "0");
        // 雇用保険
        salaryBean.setEmployInsurance(
                tSalaryDetail.getEmployInsurance() != null ? tSalaryDetail.getEmployInsurance().toString() : "0");
        // 所得税
        salaryBean.setIncomeTax(
                tSalaryDetail.getIncomeTax() != null ? tSalaryDetail.getIncomeTax().toString() : "0");
        // 住名税
        salaryBean.setLivingTax(
                tSalaryDetail.getLivingTax() != null ? tSalaryDetail.getLivingTax().toString() : "0");
        // 積立金
        salaryBean.setAccumulateGold(
                tSalaryDetail.getTravelFund() != null ? tSalaryDetail.getTravelFund().toString() : "0");
        // 借入等返済
        salaryBean.setRepaymentOfBorrowings(
                tSalaryDetail.getRepaymentBorrowings() != null ? tSalaryDetail.getRepaymentBorrowings().toString()
                        : "0");
        // 年末控除
        salaryBean.setYearendDeduction(
                tSalaryDetail.getYearendDeduction() != null ? tSalaryDetail.getYearendDeduction().toString() : "0");
        // 家賃控除
        salaryBean.setRentDeduction(
                tSalaryDetail.getRentDeduction() != null ? tSalaryDetail.getRentDeduction().toString() : "0");
        // 控除合計
        salaryBean.setTotalDeduction(tSalaryDetail.getTotalDeductibleAmount() != null
                ? tSalaryDetail.getTotalDeductibleAmount().toString() : "0");

        // その他の控除
        salaryBean.setOtherDeductions(
                tSalaryDetail.getOtherDeduction() != null ? tSalaryDetail.getOtherDeduction().toString() : "0");
        // ALLその他の控除
        salaryBean.setAllOtherDeductions(
                tSalaryDetail.getOtherDeduction() != null ? tSalaryDetail.getOtherDeduction().toString() : "0");
        // 差引支給額
        salaryBean.setSubscriptionAmount(
                tSalaryDetail.getSubscriptionAmount() != null ? tSalaryDetail.getSubscriptionAmount().toString() : "0");
        // 振込支給額
        salaryBean.setTransferPaymentAmount(
                tSalaryDetail.getSubscriptionAmount() != null ? tSalaryDetail.getSubscriptionAmount().toString() : "0");
        // 振込支給額合計
        salaryBean.setTotaltransferPaymentAmount(
                tSalaryDetail.getSubscriptionAmount() != null ? tSalaryDetail.getSubscriptionAmount().toString() : "0");
        // 現金支給額
        salaryBean.setCashPaymentAmount("0");
        // 現物支給額
        salaryBean.setInkindPaymentAmount("0");
        // 累計社会保険料
        salaryBean.setCumulativeSocialInsurancePremium(
                tSalaryDetail.getTotalInsurance() != null ? tSalaryDetail.getTotalInsurance().toString() : "0");
        // 所得税
        salaryBean.setCumulativeIncomeTax(
                tSalaryDetail.getOtherDeduction() != null ? tSalaryDetail.getOtherDeduction().toString() : "0");
        Integer cumulativeTaxableAmount = Integer.parseInt(salaryBean.getTotalSupply())
                - Integer.parseInt(salaryBean.getTransportationCosts());
        // 課税支給額
        salaryBean.setCumulativeTaxableAmount(cumulativeTaxableAmount.toString());

        salaryBeanList.add(salaryBean);
        try {
            JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(salaryBeanList);

            JasperRunManager.runReportToPdfFile(jasperPath, pdfPath, null, ds);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return "js\\" + employeeId + compId + salaryYearMonth + ".pdf";
    }
}
