package jp.co.aliber.accsystem.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.aliber.accsystem.entity.auto.TEmployeeSocialInsurance;
import jp.co.aliber.accsystem.mapper.auto.TEmployeeSocialInsuranceMapper;

/**
 * 社会保険サービス
 * 
 * @author yu_k
 *
 */
@Service
public class EmployeeSocialInsuranceService {

	@Autowired
	TEmployeeSocialInsuranceMapper tEmployeeSocialInsuranceMapper;


	/**
	 * 社会保険を登録
	 *
	 * @param tEmployeeIncomeTax
	 *            社会保険エンティティ
	 */
	public void regist(TEmployeeSocialInsurance tEmployeeSocialInsurance) {

		tEmployeeSocialInsuranceMapper
				.insertSelective(tEmployeeSocialInsurance);

	}


	/**
	 * 社会保険を更新
	 *
	 * @param tEmployeeIncomeTax
	 *            社会保険エンティティ
	 */
	public void update(TEmployeeSocialInsurance tEmployeeSocialInsurance) {

		tEmployeeSocialInsuranceMapper
				.updateByPrimaryKeySelective(tEmployeeSocialInsurance);

	}


	/**
	 * 社会保険を取得(1件)
	 *
	 * @param emplyeeId
	 *            從業員番号
	 * @param compId
	 *            会社番号
	 * @return 社会保険エンティティ
	 */
	public TEmployeeSocialInsurance getTEmployeeIncomeTax(Integer emplyeeId,
			Integer compId) {
		return tEmployeeSocialInsuranceMapper.selectByPrimaryKey(emplyeeId,
				compId);
	}
}
