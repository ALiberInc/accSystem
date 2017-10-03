package jp.co.aliber.accsystem.mapper;

import org.apache.ibatis.annotations.Param;

import jp.co.aliber.accsystem.entity.SelectNameDeptNameParameter;

/**
 * 各シーケンスに対して、直前に採番された最新値を取得クラス
 */
public interface SelectNameDeptNameMapper {

    /**
     * シーケンスから、直前に採番された最新値を取得する
     *
     * @return シーケンスの最新値
     */
    public SelectNameDeptNameParameter selectNameDeptName(@Param("compId")Integer compId, @Param("employeeId")Integer employeeId);

}