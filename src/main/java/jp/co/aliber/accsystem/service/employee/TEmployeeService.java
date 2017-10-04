package jp.co.aliber.accsystem.service.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.aliber.accsystem.entity.auto.TEmployee;
import jp.co.aliber.accsystem.entity.auto.TEmployeeExample;
import jp.co.aliber.accsystem.mapper.auto.TEmployeeMapper;

/**從業員情報サービス
 * @author son_k
 *
 */
@Service
public class TEmployeeService {

    @Autowired
    TEmployeeMapper tEmployeeMapper;

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
    public List<TEmployee> getListTEmployee(Integer compId) {
        TEmployeeExample tEmployeeExample = new TEmployeeExample();
        tEmployeeExample.createCriteria().andCompIdEqualTo(compId);
        List<TEmployee> listTEmployee = tEmployeeMapper.selectByExample(tEmployeeExample);
        return listTEmployee;
    }
}
