package jp.co.aliber.accsystem.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.aliber.accsystem.entity.auto.TEmployeeFixedDeduction;
import jp.co.aliber.accsystem.mapper.auto.TEmployeeFixedDeductionMapper;

/**固定控除金額情報サービス
 * @author son_k
 *
 */
@Service
public class EmployeeFixedDeductionService {

    @Autowired
    TEmployeeFixedDeductionMapper tEmployeeFixedDeductionMapper;

    /**
     * 固定控除金額情報を登録
     *
     * @param tEmployeeFixedDeduction
     *            固定控除金額情報エンティティ
     */
    public void regist(TEmployeeFixedDeduction tEmployeeFixedDeduction) {

        tEmployeeFixedDeductionMapper.insertSelective(tEmployeeFixedDeduction);

    }

    /**
     * 固定控除金額情報を更新
     *
     * @param tEmployeeFixedDeduction
     *            固定控除金額情報エンティティ
     */
    public void update(TEmployeeFixedDeduction tEmployeeFixedDeduction) {

        tEmployeeFixedDeductionMapper.updateByPrimaryKeySelective(tEmployeeFixedDeduction);

    }

    /**
     * 固定控除金額情報を取得(1件)
     *
     * @param emplyeeId
     *            從業員番号
     * @param compId
     *            会社番号
     * @return 固定控除金額情報エンティティ
     */
    public TEmployeeFixedDeduction getTEmployeeFixedDeduction(Integer emplyeeId, Integer compId) {
        return tEmployeeFixedDeductionMapper.selectByPrimaryKey(emplyeeId, compId);
    }
}
