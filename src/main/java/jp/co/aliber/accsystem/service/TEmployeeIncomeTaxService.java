package jp.co.aliber.accsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.aliber.accsystem.entity.auto.TEmployeeIncomeTax;
import jp.co.aliber.accsystem.mapper.auto.TEmployeeIncomeTaxMapper;

/**
 * 所得税情報サービス
 *
 * @author son_k
 *
 */
@Service
public class TEmployeeIncomeTaxService {

    @Autowired
    TEmployeeIncomeTaxMapper tEmployeeIncomeTaxMapper;

    /**
     * 所得税情報を登録
     *
     * @param tEmployeeIncomeTax
     *            所得税情報エンティティ
     */
    public void regist(TEmployeeIncomeTax tEmployeeIncomeTax) {

        tEmployeeIncomeTaxMapper.insertSelective(tEmployeeIncomeTax);

    }

    /**
     * 所得税情報を更新
     *
     * @param tEmployeeIncomeTax
     *            所得税情報エンティティ
     */
    public void update(TEmployeeIncomeTax tEmployeeIncomeTax) {

        tEmployeeIncomeTaxMapper.updateByPrimaryKeySelective(tEmployeeIncomeTax);

    }

    /**
     * 所得税情報を取得(1件)
     *
     * @param emplyeeId
     *            從業員番号
     * @param compId
     *            会社番号
     * @return 所得税情報エンティティ
     */
    public TEmployeeIncomeTax getTEmployeeIncomeTax(Integer emplyeeId, Integer compId) {
        return tEmployeeIncomeTaxMapper.selectByPrimaryKey(emplyeeId, compId);
    }
}
