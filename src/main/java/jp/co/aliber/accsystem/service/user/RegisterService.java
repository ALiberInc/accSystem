package jp.co.aliber.accsystem.service.user;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.aliber.accsystem.ImmutableValues;
import jp.co.aliber.accsystem.entity.auto.TLoginUser;
import jp.co.aliber.accsystem.entity.auto.TLoginUserExample;
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
	 * @param loginUser
	 *            ユーザー
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
		loginUser.setRegistId(ImmutableValues.DEFAULT_USER_ID);
		loginUser.setUpdateId(ImmutableValues.DEFAULT_USER_ID);

		tLoginUserMapper.insertSelective(loginUser);
	}

	/**
	 * ログインID重複チェック
	 *
	 * @param loginUser
	 *            ユーザー
	 * @return true 存在 false 存在していない
	 * 
	 */
	public boolean CheckIfLoginIdExist(String loginId) {

		TLoginUserExample loginUserExample = new TLoginUserExample();
		loginUserExample.createCriteria().andLoginIdEqualTo(loginId);
		long countLoginId = tLoginUserMapper.countByExample(loginUserExample);
		return countLoginId != 0 ? true : false;
	}
}
