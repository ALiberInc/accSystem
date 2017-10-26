package jp.co.aliber.accsystem.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.aliber.accsystem.ImmutableValues;
import jp.co.aliber.accsystem.bean.SalaryBean;
import jp.co.aliber.accsystem.entity.EmployeeInfo;
import jp.co.aliber.accsystem.entity.auto.TEmployeeIncomeTax;
import jp.co.aliber.accsystem.entity.auto.TSalaryDetail;
import jp.co.aliber.accsystem.mapper.EmployeeInfoMapper;
import jp.co.aliber.accsystem.mapper.SeqLastValueMapper;
import jp.co.aliber.accsystem.mapper.auto.TEmployeeIncomeTaxMapper;
import jp.co.aliber.accsystem.mapper.auto.TSalaryDetailMapper;
import net.sf.jasperreports.engine.JRException;
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
	SeqLastValueMapper seqLastValueMapper;

	/** 従業員給与明細 */
	@Autowired
	TSalaryDetailMapper tSalaryDetailMapper;

	@Autowired
	TEmployeeIncomeTaxMapper tEmployeeIncomeTaxMapper;

	@Autowired
	EmployeeInfoMapper employeeInfoMapper;

	/**
	 * シーケンスを取得
	 *
	 * @return シーケンス
	 */
	public Integer getSeqLastValue() {
		return seqLastValueMapper.selectLastValue();
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
	 * @return OutputStream
	 * @throws IOException
	 * @throws JRException
	 */
	public ByteArrayOutputStream creationPdfOutputStream(Integer compId, String salaryYearMonth,
			Integer... oneOrMoreEmployeeId) throws JRException, IOException {

		// 日付の確認
		if (salaryYearMonth.length() != 6) {
			return null;
		}

		// 各従業員の給与明細を格納
		List<SalaryBean> salaryBeanList = new ArrayList<>();
		for (Integer employeeId : oneOrMoreEmployeeId) {
			EmployeeInfo employeeInfo = employeeInfoMapper.selectNameDeptName(compId, employeeId);

			if (employeeInfo == null) {
				return null;
			}

			// データを取得
			// 社員情報
			TEmployeeIncomeTax tEmployeeIncomeTax = tEmployeeIncomeTaxMapper.selectByPrimaryKey(employeeId, compId);
			// 給与詳細
			TSalaryDetail tSalaryDetail = tSalaryDetailMapper.selectByPrimaryKey(employeeId, compId, salaryYearMonth);

			if (tSalaryDetail == null) {
				return null;
			}

			// PDF中身のbean
			SalaryBean salaryBean = new SalaryBean();

			Date date = new Date();
			// 年
			salaryBean.setYear(new SimpleDateFormat("yyyy").format(date));
			// 月
			salaryBean.setMonth(new SimpleDateFormat("MM").format(date));
			// 日
			salaryBean.setDay(new SimpleDateFormat("dd").format(date));
			// 氏名
			salaryBean.setName(employeeInfo.getLastName() + employeeInfo.getFirstName());
			// 所属
			salaryBean.setDepartment(
					StringUtils.isNotEmpty(employeeInfo.getDeptName()) ? employeeInfo.getDeptName() : "");
			// コード
			salaryBean.setCode(employeeInfo.getEmployeeNo() != null ? employeeInfo.getEmployeeNo().toString() : "");
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
			salaryBean.setNumberOfDependents(tEmployeeIncomeTax.getDependencyCount() + "");
			// 基本給
			salaryBean.setBasicSalary(
					tSalaryDetail.getBasicSalary() != null ? tSalaryDetail.getBasicSalary().toString() : "0");
			// 役職手当
			salaryBean.setJobAllowance(tSalaryDetail.getPositionAllowance() != null
					? tSalaryDetail.getPositionAllowance().toString() : "0");
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
			salaryBean
					.setTotalSupply(tSalaryDetail.getTotalPay() != null ? tSalaryDetail.getTotalPay().toString() : "0");

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
			salaryBean
					.setIncomeTax(tSalaryDetail.getIncomeTax() != null ? tSalaryDetail.getIncomeTax().toString() : "0");
			// 住名税
			salaryBean
					.setLivingTax(tSalaryDetail.getLivingTax() != null ? tSalaryDetail.getLivingTax().toString() : "0");
			// 積立金
			salaryBean.setAccumulateGold(
					tSalaryDetail.getTravelFund() != null ? tSalaryDetail.getTravelFund().toString() : "0");
			// 借入等返済
			salaryBean.setRepaymentOfBorrowings(tSalaryDetail.getRepaymentBorrowings() != null
					? tSalaryDetail.getRepaymentBorrowings().toString() : "0");
			// 年末控除
			salaryBean.setYearendDeduction(
					tSalaryDetail.getYearendDeduction() != null ? tSalaryDetail.getYearendDeduction().toString() : "0");
			// 家賃控除
			salaryBean.setRentDeduction(
					tSalaryDetail.getRentDeduction() != null ? tSalaryDetail.getRentDeduction().toString() : "0");
			// 控除合計
			Integer amount = tSalaryDetail.getTotalDeductibleAmount()
					- (tSalaryDetail.getOtherDeduction() != null ? tSalaryDetail.getOtherDeduction() : 0);
			salaryBean.setTotalDeduction(tSalaryDetail.getTotalDeductibleAmount() != null ? amount.toString() : "0");

			// その他の控除
			salaryBean.setOtherDeductions(
					tSalaryDetail.getOtherDeduction() != null ? tSalaryDetail.getOtherDeduction().toString() : "0");
			// ALLその他の控除
			salaryBean.setAllOtherDeductions(
					tSalaryDetail.getOtherDeduction() != null ? tSalaryDetail.getOtherDeduction().toString() : "0");
			// 差引支給額
			salaryBean.setSubscriptionAmount(tSalaryDetail.getSubscriptionAmount() != null
					? tSalaryDetail.getSubscriptionAmount().toString() : "0");
			// 振込支給額
			salaryBean.setTransferPaymentAmount(tSalaryDetail.getSubscriptionAmount() != null
					? tSalaryDetail.getSubscriptionAmount().toString() : "0");
			// 振込支給額合計
			salaryBean.setTotaltransferPaymentAmount(tSalaryDetail.getSubscriptionAmount() != null
					? tSalaryDetail.getSubscriptionAmount().toString() : "0");
			// 現金支給額
			salaryBean.setCashPaymentAmount("0");
			// 現物支給額
			salaryBean.setInkindPaymentAmount("0");
			// 累計社会保険料
			salaryBean.setCumulativeSocialInsurancePremium(
					tSalaryDetail.getTotalInsurance() != null ? tSalaryDetail.getTotalInsurance().toString() : "0");
			// 所得税
			salaryBean.setCumulativeIncomeTax(
					tSalaryDetail.getIncomeTax() != null ? tSalaryDetail.getIncomeTax().toString() : "0");
			// 課税支給額 = 支給合計 - 交通費 - 積立金 - 借入等返済 - 家賃控除
			Integer cumulativeTaxableAmount = Integer.parseInt(salaryBean.getTotalSupply())
					- Integer.parseInt(salaryBean.getTransportationCosts())
					- (tSalaryDetail.getTravelFund() != null ? tSalaryDetail.getTravelFund() : 0)
					- (tSalaryDetail.getRepaymentBorrowings() != null ? tSalaryDetail.getRepaymentBorrowings() : 0)
					- (tSalaryDetail.getRentDeduction() != null ? tSalaryDetail.getRentDeduction() : 0);
			// 課税支給額
			salaryBean.setCumulativeTaxableAmount(cumulativeTaxableAmount.toString());

			salaryBeanList.add(salaryBean);
		}

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		JasperRunManager.runReportToPdfStream(Files.newInputStream(Paths.get(ImmutableValues.jasperPath)), outputStream,
				null, new JRBeanCollectionDataSource(salaryBeanList));

		return outputStream;
	}
}
