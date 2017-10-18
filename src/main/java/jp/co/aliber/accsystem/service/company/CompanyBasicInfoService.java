package jp.co.aliber.accsystem.service.company;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.aliber.accsystem.entity.auto.TCompany;
import jp.co.aliber.accsystem.entity.auto.TCompanyExample;
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
	TCompanyMapper tCompanyMapper;
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

		tCompanyMapper.insertSelective(company);
	}

	/**
	 * 会社重複チェック
	 *
	 * @param compName
	 * 
	 * @return 重複：true,不重複:false
	 */
	public boolean checkIfCompNameExist(String compName) {
		TCompanyExample tCompanyExample = new TCompanyExample();
		// 該当会社名を検索条件によって検索を実行する
		tCompanyExample.createCriteria().andCompNameEqualTo(compName);
		long countCompName = tCompanyMapper.countByExample(tCompanyExample);
		return countCompName != 0 ? true : false;
	}

	/**
	 * 会社情報を取得
	 * 
	 * @param compName
	 * 
	 * @return TCompany 会社情報
	 */
	public TCompany searchComp(Integer compId) {
		return tCompanyMapper.selectByPrimaryKey(compId);
	}

}
