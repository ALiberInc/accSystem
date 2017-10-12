package jp.co.aliber.accsystem.service.company;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.aliber.accsystem.entity.auto.TCompany;
import jp.co.aliber.accsystem.mapper.SelectSeqLastValueMapper;
import jp.co.aliber.accsystem.mapper.auto.TCompanyMapper;
import jp.co.aliber.accsystem.mapper.auto.TInsuranceMapper;

/**
 * 基本情報処理
 *
 * @author yu_k
 *
 */
@Service
public class CompanyBasicInfoService {

    @Autowired
    TCompanyMapper tcompanyMapper;
    @Autowired
    TInsuranceMapper tInsuranceMapper;
    @Autowired
    SelectSeqLastValueMapper selectSeqLastValueMapper;

    /**
     * 登録処理
     *
     * @param company
     *            TCompanyテーブルのエンティティ
     * @param userId
     *            ユーザＩＤ
     */
    public void regist(TCompany company, Integer userId) {
        // 登録時削除フラグをfalseにする
        company.setDeleteFlg(false);

        // システム日付を取得する
        Date systemDate = new Date();
        company.setRegistDate(systemDate);
        company.setUpdateDate(systemDate);

        // ユーザID
        company.setRegistId(userId);
        company.setUpdateId(userId);

        tcompanyMapper.insertSelective(company);
    }

}
