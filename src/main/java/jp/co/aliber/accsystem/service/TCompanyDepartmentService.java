package jp.co.aliber.accsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.aliber.accsystem.entity.auto.TCompanyDepartment;
import jp.co.aliber.accsystem.entity.auto.TCompanyDepartmentExample;
import jp.co.aliber.accsystem.mapper.auto.TCompanyDepartmentMapper;

/**
 * 会社部署情報サービス
 *
 * @author son_k
 *
 */
@Service
public class TCompanyDepartmentService {

    @Autowired
    private TCompanyDepartmentMapper tCompanyDepartmentMapper;

    /**
     * 会社部署情報を取得
     *
     * @param compId
     *            会社番号
     * @return 会社部署情報エンティティのリスト
     */
    public List<TCompanyDepartment> getListTCompanyDepartmen(Integer compId) {
        TCompanyDepartmentExample tCompanyDepartmentExample = new TCompanyDepartmentExample();
        tCompanyDepartmentExample.createCriteria().andCompIdEqualTo(compId);
        List<TCompanyDepartment> listTCompanyDepartmen = tCompanyDepartmentMapper
                .selectByExample(tCompanyDepartmentExample);
        return listTCompanyDepartmen;
    }
}
