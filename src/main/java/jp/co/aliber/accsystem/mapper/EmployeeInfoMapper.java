package jp.co.aliber.accsystem.mapper;

import org.apache.ibatis.annotations.Param;

import jp.co.aliber.accsystem.entity.EmployeeInfo;

/**
 * 各シーケンスに対して、直前に採番された最新値を取得クラス
 */
public interface EmployeeInfoMapper {

    /**
     * シーケンスから、直前に採番された最新値を取得する
     *
     * @return シーケンスの最新値
     */
    public EmployeeInfo selectNameDeptName(@Param("compId")Integer compId, @Param("employeeId")Integer employeeId);

}