package jp.co.aliber.accsystem.service.user;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.aliber.accsystem.entity.auto.TLoginUser;
import jp.co.aliber.accsystem.mapper.auto.TLoginUserMapper;

/**
 * アカウントの作成サービス
 * 
 * @author yu_k
 *
 */
@Service
public class RegisterService {

	@Autowired
	TLoginUserMapper tLoginUserMapper;


	/**
	 * 登録処理
	 *
	 * @param company
	 *            TCompanyテーブルのエンティティ
	 * @param userId
	 *            ユーザＩＤ
	 */
	public void regist(TLoginUser loginUser) {
		// 登録時削除フラグをfalseにする
		loginUser.setDeleteFlg(false);

		// システム日付を取得する
		Date systemDate = new Date();
		// パスワード変更日時
		loginUser.setPasswordModifyDatetime(systemDate);
		// 登録日
		loginUser.setRegistDate(systemDate);
		// 最終更新日
		loginUser.setUpdateDate(systemDate);
		// パスワード失敗回数
		loginUser.setFailCount((short) 0);
		// ユーザーロック
		loginUser.setLockuser(false);
		// 削除フラグ
		loginUser.setDeleteFlg(false);
		// ユーザID
		loginUser.setRegistId(1);
		loginUser.setUpdateId(1);

		tLoginUserMapper.insertSelective(loginUser);
	}

}
