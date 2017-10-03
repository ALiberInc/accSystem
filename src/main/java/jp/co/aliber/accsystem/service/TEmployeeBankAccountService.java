package jp.co.aliber.accsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.aliber.accsystem.entity.auto.TEmployeeBankAccount;
import jp.co.aliber.accsystem.mapper.auto.TEmployeeBankAccountMapper;

/**從業員口座情報サービス
 * @author son_k
 *
 */
@Service
public class TEmployeeBankAccountService {

    @Autowired
    TEmployeeBankAccountMapper tEmployeeBankAccountMapper;

    /**
     * 從業員口座情報を登録
     *
     * @param tEmployeeBankAccount
     *            從業員口座情報エンティティ
     */
    public void regist(TEmployeeBankAccount tEmployeeBankAccount) {

        tEmployeeBankAccountMapper.insertSelective(tEmployeeBankAccount);

    }

    /**
     * 從業員口座情報を更新
     *
     * @param tEmployeeBankAccount
     *            從業員口座情報エンティティ
     */
    public void update(TEmployeeBankAccount tEmployeeBankAccount) {

        tEmployeeBankAccountMapper.updateByPrimaryKeySelective(tEmployeeBankAccount);

    }

    /**
     * 從業員口座情報を取得(1件)
     *
     * @param emplyeeId
     *            從業員番号
     * @param compId
     *            会社番号
     * @return 從業員口座情報エンティティ
     */
    public TEmployeeBankAccount getTEmployeeBankAccount(Integer emplyeeId, Integer compId) {
        return tEmployeeBankAccountMapper.selectByPrimaryKey(emplyeeId, compId);
    }
}
