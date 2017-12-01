package jp.co.aliber.accsystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import jp.co.aliber.accsystem.entity.EmployeeInfo;

/**
 * 従業員情報を取得クラス
 */
public interface EmployeeInfoMapper {

	/**
	 * 従業員情報を取得
	 *
	 * @return 従業員情報
	 */
	public EmployeeInfo selectEmployeeInfo(@Param("compId") Integer compId, @Param("employeeId") Integer employeeId);

	/**
	 * 従業員情報リストを取得
	 *
	 * @return 従業員情報
	 */
	public List<EmployeeInfo> selectEmployeeInfoList(@Param("compId") Integer compId);
}