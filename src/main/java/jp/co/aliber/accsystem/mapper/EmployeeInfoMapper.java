package jp.co.aliber.accsystem.mapper;

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
    public EmployeeInfo selectNameDeptName(@Param("compId")Integer compId, @Param("employeeId")Integer employeeId);

}