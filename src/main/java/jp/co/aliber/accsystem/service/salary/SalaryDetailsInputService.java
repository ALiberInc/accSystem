package jp.co.aliber.accsystem.service.salary;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.aliber.accsystem.ImmutableValues;
import jp.co.aliber.accsystem.entity.auto.MHealthInsuranceStandardPayment;
import jp.co.aliber.accsystem.entity.auto.MHealthInsuranceStandardPaymentExample;
import jp.co.aliber.accsystem.entity.auto.MIncomeTax;
import jp.co.aliber.accsystem.entity.auto.MIncomeTaxExample;
import jp.co.aliber.accsystem.entity.auto.MWelfareInsuranceStandardPayment;
import jp.co.aliber.accsystem.entity.auto.MWelfareInsuranceStandardPaymentExample;
import jp.co.aliber.accsystem.entity.auto.TSalaryDetail;
import jp.co.aliber.accsystem.mapper.auto.MHealthInsuranceStandardPaymentMapper;
import jp.co.aliber.accsystem.mapper.auto.MIncomeTaxMapper;
import jp.co.aliber.accsystem.mapper.auto.MWelfareInsuranceStandardPaymentMapper;
import jp.co.aliber.accsystem.mapper.auto.TCompanyMapper;
import jp.co.aliber.accsystem.mapper.auto.TSalaryDetailMapper;

/**
 * 給与明細入力サービス
 *
 * @author yu_k
 *
 */
@Service
public class SalaryDetailsInputService {
	@Autowired
	TSalaryDetailMapper tSalaryDetailMapper;
	@Autowired
	TCompanyMapper tCompanyMapper;
	@Autowired
	MHealthInsuranceStandardPaymentMapper mHealthInsuranceStandardPaymentMapper;
	@Autowired
	MWelfareInsuranceStandardPaymentMapper mWelfareInsuranceStandardPaymentMapper;
	@Autowired
	MIncomeTaxMapper mIncomeTaxMapper;

	public TSalaryDetail getSalaryDetail(Integer employeeId, Integer compId, String yearMonth) {
		// 主キーによって検索する
		return tSalaryDetailMapper.selectByPrimaryKey(employeeId, compId, yearMonth);
	}

	/**
	 * 従業員給与明細テーブルに登録する
	 *
	 * @param tSalaryDetail
	 *            従業員給与明細テーブルエンティティ
	 *
	 */
	public void insert(TSalaryDetail tSalaryDetail) {
		tSalaryDetailMapper.insertSelective(tSalaryDetail);

	}

	/**
	 * 従業員給与明細テーブルに更新する
	 *
	 * @param tSalaryDetail
	 *            従業員給与明細テーブルエンティティ
	 * @throws Exception
	 *
	 */
	public void update(TSalaryDetail tSalaryDetail) {
		tSalaryDetailMapper.updateByPrimaryKeySelective(tSalaryDetail);
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
	public Map<String, Integer> insuranceCalculator(int sum, int compId) {
		// 健康保険標準報酬マスタテーブルから標準月額を取得する
		MHealthInsuranceStandardPaymentExample example = new MHealthInsuranceStandardPaymentExample();
		example.createCriteria().andPaymentStartLessThanOrEqualTo(new Long(sum))
				.andPaymentEndGreaterThanOrEqualTo(new Long(sum));
		MHealthInsuranceStandardPayment mHealthInsuranceStandardPayment = new MHealthInsuranceStandardPayment();
		mHealthInsuranceStandardPayment = mHealthInsuranceStandardPaymentMapper.selectByExample(example).get(0);
		Integer standardPayment = mHealthInsuranceStandardPayment.getStandardPayment().intValue();

		// 厚生年金標準報酬マスタテーブルから標準月額を取得する
		MWelfareInsuranceStandardPaymentExample example2 = new MWelfareInsuranceStandardPaymentExample();
		example2.createCriteria().andPaymentStartLessThanOrEqualTo(new Long(sum))
				.andPaymentEndGreaterThanOrEqualTo(new Long(sum));
		MWelfareInsuranceStandardPayment mWelfareInsuranceStandardPayment = mWelfareInsuranceStandardPaymentMapper
				.selectByExample(example2).get(0);
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
	public Integer incomeTaxCalculator(Integer sum, Integer socialInsuranceSum, Integer person) {
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
