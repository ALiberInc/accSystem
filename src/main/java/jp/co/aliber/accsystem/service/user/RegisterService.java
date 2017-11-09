package jp.co.aliber.accsystem.service.user;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.aliber.accsystem.ImmutableValues;
import jp.co.aliber.accsystem.entity.auto.TLoginUser;
import jp.co.aliber.accsystem.entity.auto.TLoginUserExample;
import jp.co.aliber.accsystem.mapper.auto.TLoginUserMapper;

/**
 * 新規ユーザー登録サービス
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

		// パスワード変更日時
		loginUser.setPasswordModifyDatetime(new Date());
		// 登録者ID
		loginUser.setRegistId(ImmutableValues.DEFAULT_USER_ID);
		// 更新者ID
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
	public boolean checkIfLoginIdExist(String loginId) {

		TLoginUserExample loginUserExample = new TLoginUserExample();
		loginUserExample.createCriteria().andLoginIdEqualTo(loginId);
		long countLoginId = tLoginUserMapper.countByExample(loginUserExample);
		return countLoginId != 0 ? true : false;
	}

	/**
	 * メールの重複チェック
	 *
	 * @param email
	 *            メールアドレス
	 * @return true 存在 false 存在していない
	 * 
	 */
	public boolean checkIfEmailExist(String email) {

		TLoginUserExample loginUserExample = new TLoginUserExample();
		loginUserExample.createCriteria().andEmailEqualTo(email);
		long countEmail = tLoginUserMapper.countByExample(loginUserExample);
		return countEmail != 0 ? true : false;
	}
}
