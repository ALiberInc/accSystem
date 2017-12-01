package jp.co.aliber.accsystem.service.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.aliber.accsystem.entity.EmployeeInfo;
import jp.co.aliber.accsystem.entity.auto.TEmployee;
import jp.co.aliber.accsystem.mapper.EmployeeInfoMapper;
import jp.co.aliber.accsystem.mapper.auto.TEmployeeMapper;

/**
 * 從業員情報サービス
 *
 * @author son_k
 *
 */
@Service
public class EmployeeService {

	@Autowired
	TEmployeeMapper tEmployeeMapper;
	@Autowired
	EmployeeInfoMapper employeeInfoMapper;

	/**
	 * 從業員情報を登録
	 *
	 * @param tEmployee
	 *            從業員情報エンティティ
	 */
	public void regist(TEmployee tEmployee) {

		tEmployeeMapper.insertSelective(tEmployee);

	}

	/**
	 * 從業員情報を更新
	 *
	 * @param tEmployee
	 *            從業員情報エンティティ
	 */
	public void update(TEmployee tEmployee) {

		tEmployeeMapper.updateByPrimaryKeySelective(tEmployee);

	}

	/**
	 * 從業員情報を取得(1件)
	 *
	 * @param emplyeeId
	 *            從業員番号
	 * @param compId
	 *            会社番号
	 * @return 從業員情報エンティティ
	 */
	public TEmployee getTEmployee(Integer emplyeeId, Integer compId) {
		return tEmployeeMapper.selectByPrimaryKey(emplyeeId, compId);
	}

	/**
	 * 從業員情報リストを取得
	 *
	 * @param compId
	 *            会社番号
	 * @return 從業員情報エンティティのリスト
	 */
	public List<EmployeeInfo> getListTEmployee(Integer compId) {
		return employeeInfoMapper.selectEmployeeInfoList(compId);
	}
}
