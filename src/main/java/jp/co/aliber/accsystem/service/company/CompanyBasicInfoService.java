package jp.co.aliber.accsystem.service.company;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.aliber.accsystem.entity.auto.TCompany;
import jp.co.aliber.accsystem.entity.auto.TCompanyExample;
import jp.co.aliber.accsystem.mapper.auto.TCompanyMapper;
import jp.co.aliber.accsystem.mapper.auto.TInsuranceMapper;

/**
 * 会社基本情報サービス
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
	 * 更新処理
	 *
	 * @param company
	 *            TCompanyテーブルのエンティティ
	 * @param userId
	 *            ユーザＩＤ
	 */
	public void update(TCompany company, Integer userId) {
		// システム日付を取得する
		Date systemDate = new Date();
		company.setUpdateDate(systemDate);

		// ユーザID
		company.setUpdateId(userId);

		tCompanyMapper.updateByPrimaryKeySelective(company);
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
