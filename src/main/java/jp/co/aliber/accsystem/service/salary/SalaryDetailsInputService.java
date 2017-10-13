package jp.co.aliber.accsystem.service.salary;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.aliber.accsystem.ImmutableValues;
import jp.co.aliber.accsystem.entity.auto.MHealthInsuranceStandardPayment;
import jp.co.aliber.accsystem.entity.auto.MHealthInsuranceStandardPaymentExample;
import jp.co.aliber.accsystem.entity.auto.MIncomeTax;
import jp.co.aliber.accsystem.entity.auto.MIncomeTaxExample;
import jp.co.aliber.accsystem.entity.auto.MWelfareInsuranceStandardPayment;
import jp.co.aliber.accsystem.entity.auto.MWelfareInsuranceStandardPaymentExample;
import jp.co.aliber.accsystem.entity.auto.TEmployeeFixedDeduction;
import jp.co.aliber.accsystem.entity.auto.TEmployeeFixedPayment;
import jp.co.aliber.accsystem.entity.auto.TSalaryDetail;
import jp.co.aliber.accsystem.mapper.auto.MHealthInsuranceStandardPaymentMapper;
import jp.co.aliber.accsystem.mapper.auto.MIncomeTaxMapper;
import jp.co.aliber.accsystem.mapper.auto.MWelfareInsuranceStandardPaymentMapper;
import jp.co.aliber.accsystem.mapper.auto.TCompanyMapper;
import jp.co.aliber.accsystem.mapper.auto.TEmployeeFixedDeductionMapper;
import jp.co.aliber.accsystem.mapper.auto.TEmployeeFixedPaymentMapper;
import jp.co.aliber.accsystem.mapper.auto.TSalaryDetailMapper;

/**
 * 給与明細入力処理
 *
 * @author yu_k
 *
 */
@Service
public class SalaryDetailsInputService {
	@Autowired
	TSalaryDetailMapper tSalaryDetailMapper;
	@Autowired
	TEmployeeFixedPaymentMapper tEmployeeFixedPaymentMapper;
	@Autowired
	TEmployeeFixedDeductionMapper tEmployeeFixedDeductionMapper;
	@Autowired
	TCompanyMapper tCompanyMapper;
	@Autowired
	MHealthInsuranceStandardPaymentMapper mHealthInsuranceStandardPaymentMapper;
	@Autowired
	MWelfareInsuranceStandardPaymentMapper mWelfareInsuranceStandardPaymentMapper;
	@Autowired
	MIncomeTaxMapper mIncomeTaxMapper;
	// 新規時の住民税
	private static Integer LIVING_TAX_ORIGINAL = 0;

	/**
	 * 新規の場合、従業員固定支給金額情報テーブルと従業員固定控除金額情報テーブルから情報を取得して設定する（
	 * 部分収得できない項目は取得した項目よって計算出来た） 編集の場合、従業員給与明細テーブルから情報を取得して設定する
	 *
	 * @param employeeId
	 *            従業員ID
	 * @param compId
	 *            会社ID
	 * @param person
	 *            扶養親族等の数
	 * @param yearMonth
	 *            年月
	 * @return 従業員給与明細エンティティ
	 */
	public TSalaryDetail initiation(Integer employeeId, Integer compId, Integer person, String yearMonth) {
		// それぞれ返却する
		if (employeeId == null) {
			return new TSalaryDetail();
		}
		if (compId == null) {
			return new TSalaryDetail();
		}
		if (person == null) {
			return new TSalaryDetail();
		}
		if (yearMonth == null || StringUtils.isEmpty(yearMonth)) {
			return new TSalaryDetail();
		}
		// 主キーによって検索する
		TSalaryDetail tSalaryDetail = tSalaryDetailMapper.selectByPrimaryKey(employeeId, compId, yearMonth);
		// 新規の場合
		if (tSalaryDetail == null) {
			// エンティティを新規する
			tSalaryDetail = new TSalaryDetail();
			// 従業員固定支給金額情報テーブルから固定支給金額を取得
			TEmployeeFixedPayment tEmployeeFixedPayment = tEmployeeFixedPaymentMapper.selectByPrimaryKey(employeeId,
					compId);
			// 従業員固定控除金額情報テーブルから固定控除金額情報を取得
			TEmployeeFixedDeduction tEmployeeFixedDeduction = tEmployeeFixedDeductionMapper
					.selectByPrimaryKey(employeeId, compId);
			// 色んな給与をここで置く
			List<Integer> paymentList = new ArrayList<Integer>();
			// 基本給
			Integer basicSalary = tEmployeeFixedPayment.getBasicSalary();
			paymentList.add(basicSalary);
			tSalaryDetail.setBasicSalary(basicSalary);
			// 役職手当
			Integer positionAllowance = tEmployeeFixedPayment.getPositionAllowance();
			paymentList.add(positionAllowance);
			tSalaryDetail.setPositionAllowance(positionAllowance);
			// 資格手当
			Integer qualificationAllowance = tEmployeeFixedPayment.getQualificationAllowance();
			paymentList.add(qualificationAllowance);
			tSalaryDetail.setQualificationAllowance(qualificationAllowance);
			// 住宅手当
			Integer houseAllowance = tEmployeeFixedPayment.getHouseAllowance();
			paymentList.add(houseAllowance);
			tSalaryDetail.setHouseAllowance(houseAllowance);
			// 家族手当
			Integer familyAllowance = tEmployeeFixedPayment.getFamilyAllowance();
			paymentList.add(familyAllowance);
			tSalaryDetail.setFamilyAllowance(familyAllowance);
			// その他手当
			Integer otherAllowance = tEmployeeFixedPayment.getOtherAllowance();
			paymentList.add(otherAllowance);
			tSalaryDetail.setOtherAllowance(otherAllowance);
			// 交通費(実費)
			Integer transportFee = tEmployeeFixedPayment.getTransportFee();
			tSalaryDetail.setTransportFee(transportFee);
			// 総支給
			Integer sum = new Integer(0);
			for (Integer a : paymentList) {
				sum += a.intValue();
			}
			tSalaryDetail.setTotalPay(sum + transportFee);
			// 色んな控除額をここで置く
			List<Integer> listDeduction = new ArrayList<Integer>();
			// 総支給によって、保険について各項目を取得する
			Map<String, Integer> map = new HashMap<>();
			map = insuranceCalculator(sum, compId);
			// 健康保険
			Integer healthInsurance = map.get("healthInsurance");
			tSalaryDetail.setHealthInsurance(healthInsurance);
			// 厚生年金
			Integer welfarePension = map.get("welfarePension");
			tSalaryDetail.setWelfareInsurance(welfarePension);
			// 雇用保険
			Integer employmentInsurance = map.get("employmentInsurance");
			tSalaryDetail.setEmployInsurance(employmentInsurance);
			// 社会保険合計
			Integer socialInsuranceSum = map.get("socialInsuranceSum");
			tSalaryDetail.setTotalInsurance(socialInsuranceSum);
			listDeduction.add(socialInsuranceSum);
			// 所得税
			Integer incomeTax = incomeTaxCalculator(sum, socialInsuranceSum, person);
			listDeduction.add(incomeTax);
			tSalaryDetail.setIncomeTax(incomeTax);
			// 住民税手入力
			tSalaryDetail.setLivingTax(LIVING_TAX_ORIGINAL);
			// 旅行積立金
			Integer travelFund = tEmployeeFixedDeduction.getTravelFund();
			listDeduction.add(travelFund);
			tSalaryDetail.setTravelFund(travelFund);
			// 借入等返済
			Integer repaymentBorrowings = tEmployeeFixedDeduction.getRepaymentBorrowings();
			listDeduction.add(repaymentBorrowings);
			tSalaryDetail.setRepaymentBorrowings(repaymentBorrowings);
			// 年末控除
			Integer yearendDeduction = tEmployeeFixedDeduction.getYearendDeduction();
			listDeduction.add(yearendDeduction);
			tSalaryDetail.setYearendDeduction(yearendDeduction);
			// 家賃控除
			Integer rentDeduction = tEmployeeFixedDeduction.getRentDeduction();
			listDeduction.add(rentDeduction);
			tSalaryDetail.setRentDeduction(rentDeduction);
			// その他の控除
			Integer otherDeduction = tEmployeeFixedDeduction.getOtherDeduction();
			listDeduction.add(otherDeduction);
			tSalaryDetail.setOtherDeduction(otherDeduction);
			// 控除額合計
			Integer deductionSum = new Integer(0);
			for (Integer a : listDeduction) {
				deductionSum += a.intValue();
			}
			tSalaryDetail.setTotalDeductibleAmount(deductionSum);
			// 差引支給額
			Integer subscriptionAmount = sum - deductionSum;
			tSalaryDetail.setSubscriptionAmount(subscriptionAmount);
		}

		return tSalaryDetail;
	}

	/**
	 * 従業員給与明細テーブルにインサートする
	 *
	 * @param tSalaryDetail
	 *            従業員給与明細テーブルエンティティ
	 * @throws Exception
	 *
	 */
	public void regist(TSalaryDetail tSalaryDetail) {
		// それぞれ返却する
		if (tSalaryDetail.getEmployeeId() == null) {
			return;
		}
		if (tSalaryDetail.getCompId() == null) {
			return;
		}
		if (tSalaryDetail.getSalaryYearMonth() == null && StringUtils.isEmpty(tSalaryDetail.getSalaryYearMonth())) {
			return;
		}
		// 先に削除を行って、データをインサートする
		tSalaryDetailMapper.deleteByPrimaryKey(tSalaryDetail.getEmployeeId(), tSalaryDetail.getCompId(),
				tSalaryDetail.getSalaryYearMonth());
		tSalaryDetailMapper.insertSelective(tSalaryDetail);

	}

	/**
	 * 健康保険、厚生年金、雇用保険、社会保険合計を取得する
	 *
	 * @param sum
	 *            総支給
	 * @param compId
	 *            会社ID
	 * @return 健康保険、厚生年金、雇用保険、社会保険合計
	 */
	private Map<String, Integer> insuranceCalculator(Integer sum, int compId) {
		// 健康保険標準報酬マスタテーブルから標準月額を取得する
		MHealthInsuranceStandardPaymentExample example = new MHealthInsuranceStandardPaymentExample();
		example.createCriteria().andPaymentStartLessThanOrEqualTo(sum.longValue())
				.andPaymentEndGreaterThanOrEqualTo(sum.longValue());
		MHealthInsuranceStandardPayment mHealthInsuranceStandardPayment = new MHealthInsuranceStandardPayment();
		mHealthInsuranceStandardPayment = mHealthInsuranceStandardPaymentMapper.selectByExample(example).get(0);
		Integer standardPayment = mHealthInsuranceStandardPayment.getStandardPayment().intValue();

		// 厚生年金標準報酬マスタテーブルから標準月額を取得する
		MWelfareInsuranceStandardPaymentExample example2 = new MWelfareInsuranceStandardPaymentExample();
		example2.createCriteria().andPaymentStartLessThanOrEqualTo(sum.longValue())
				.andPaymentEndGreaterThanOrEqualTo(sum.longValue());
		MWelfareInsuranceStandardPayment mWelfareInsuranceStandardPayment = new MWelfareInsuranceStandardPayment();
		mWelfareInsuranceStandardPayment = mWelfareInsuranceStandardPaymentMapper.selectByExample(example2).get(0);
		Integer standardPayment2 = mWelfareInsuranceStandardPayment.getStandardPayment().intValue();

		// 会社IDよって健康保険料率、厚生年金料率、雇用保険被保険者負担率を取得する
		BigDecimal healthInsuranceRate = tCompanyMapper.selectByPrimaryKey(compId).getHealthInsurRateNoNursing()
				.divide(new BigDecimal(100));
		BigDecimal welfareInsuranceRate = tCompanyMapper.selectByPrimaryKey(compId).getWelfareInsuranceRate()
				.divide(new BigDecimal(100));
		BigDecimal employInsuranceRate = tCompanyMapper.selectByPrimaryKey(compId).getEmployInsurRate()
				.divide(new BigDecimal(1000));

		Map<String, Integer> map = new HashMap<>();
		// 保険料を計算できてmapに設定する
		// 健康保険
		BigDecimal healthInsurance = new BigDecimal(standardPayment).multiply(healthInsuranceRate);
		healthInsurance = healthInsurance.divide(new BigDecimal(2), 0, RoundingMode.HALF_DOWN);
		map.put("healthInsurance", healthInsurance.intValue());
		// 厚生年金
		BigDecimal welfarePension = new BigDecimal(standardPayment2).multiply(welfareInsuranceRate);
		welfarePension = welfarePension.divide(new BigDecimal(2), 0, RoundingMode.HALF_DOWN);
		map.put("welfarePension", welfarePension.intValue());
		// 雇用保険
		BigDecimal employmentInsurance = new BigDecimal(sum).multiply(employInsuranceRate);
		employmentInsurance = employmentInsurance.divide(new BigDecimal(2), 0, RoundingMode.HALF_DOWN);
		map.put("employmentInsurance", employmentInsurance.intValue());
		// 社会保険合計
		BigDecimal socialInsuranceSum = healthInsurance.add(welfarePension).add(employmentInsurance);
		map.put("socialInsuranceSum", socialInsuranceSum.intValue());

		return map;
	}

	/**
	 * 所得税税額を取得する（今区分を追加しなくて、必要の場合、overloadしてください）
	 *
	 * @param sum
	 *            総支給
	 * @param deductionSum
	 *            総控除
	 * @param person
	 *            扶養親族等の数
	 * @return 所得税税額
	 */
	private Integer incomeTaxCalculator(Integer sum, Integer socialInsuranceSum, Integer person) {
		BigDecimal sumBD = new BigDecimal(sum);
		BigDecimal socialInsuranceSumBD = new BigDecimal(socialInsuranceSum);
		// その月の社会保険料等控除後の給与等の金額を収得する
		BigDecimal adjustSum = sumBD.subtract(socialInsuranceSumBD);
		adjustSum.setScale(0, RoundingMode.HALF_DOWN);
		MIncomeTaxExample MIncomeTaxExample = new MIncomeTaxExample();
		// 上記金額によって税額を取得する
		MIncomeTaxExample.createCriteria().andIncomeStartLessThanOrEqualTo(adjustSum.longValue())
				.andIncomeEndGreaterThanOrEqualTo(adjustSum.longValue());
		if (mIncomeTaxMapper.selectByExample(MIncomeTaxExample).size() != 1) {
			// 取得できない場合
			return new Integer(0);
		}
		MIncomeTax mIncomeTax = mIncomeTaxMapper.selectByExample(MIncomeTaxExample).get(0);
		Integer incomeTax = new Integer(0);
		// 扶養親族等の数が0より小さい場合、0にする
		if (person.intValue() < 0) {
			person = new Integer(0);
		}
		// 扶養親族等の数によって、該当税額を取得する
		if (person.intValue() < 8 && person.intValue() >= 0) {
			switch (person.intValue()) {
			case 0:
				incomeTax = mIncomeTax.getTax0();
				break;
			case 1:
				incomeTax = mIncomeTax.getTax1();
				break;
			case 2:
				incomeTax = mIncomeTax.getTax2();
				break;
			case 3:
				incomeTax = mIncomeTax.getTax3();
				break;
			case 4:
				incomeTax = mIncomeTax.getTax4();
				break;
			case 5:
				incomeTax = mIncomeTax.getTax5();
				break;
			case 6:
				incomeTax = mIncomeTax.getTax6();
				break;
			case 7:
				incomeTax = mIncomeTax.getTax7();
				break;
			}
		} else {
			incomeTax = mIncomeTax.getTax7();
			// 7人を超える１人ごとに1,610円を控除した金額
			Integer extraDec = (person.intValue() - 7) * ImmutableValues.EXTRA_DEC_PER_PERSON;
			incomeTax = incomeTax - extraDec;
		}

		return incomeTax;
	}

}
