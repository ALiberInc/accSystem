package jp.co.aliber.accsystem.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.aliber.accsystem.entity.auto.TEmployeeFixedPayment;
import jp.co.aliber.accsystem.mapper.auto.TEmployeeFixedPaymentMapper;

/**
 * 固定支給金額情報サービス
 *
 * @author son_k
 *
 */
@Service
public class EmployeeFixedPaymentService {

	@Autowired
	TEmployeeFixedPaymentMapper tEmployeeFixedPaymentMapper;

	/**
	 * 固定支給金額情報を登録
	 *
	 * @param tEmployeeFixedPayment
	 *            固定支給金額情報エンティティ
	 */
	public void regist(TEmployeeFixedPayment tEmployeeFixedPayment) {

		tEmployeeFixedPaymentMapper.insertSelective(tEmployeeFixedPayment);

	}

	/**
	 * 固定支給金額情報を更新
	 *
	 * @param tEmployeeFixedPayment
	 *            固定支給金額情報エンティティ
	 */
	public void update(TEmployeeFixedPayment tEmployeeFixedPayment) {

		tEmployeeFixedPaymentMapper.updateByPrimaryKeySelective(tEmployeeFixedPayment);

	}

	/**
	 * 固定支給金額情報を取得(1件)
	 *
	 * @param emplyeeId
	 *            從業員番号
	 * @param compId
	 *            会社番号
	 * @return 固定支給金額情報エンティティ
	 */
	public TEmployeeFixedPayment getTEmployeeFixedPayment(Integer employeeId, Integer compId) {
		return tEmployeeFixedPaymentMapper.selectByPrimaryKey(employeeId, compId);
	}
}
