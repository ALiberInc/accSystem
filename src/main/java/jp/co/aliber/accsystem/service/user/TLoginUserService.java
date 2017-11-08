package jp.co.aliber.accsystem.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jp.co.aliber.accsystem.entity.auto.TLoginUser;
import jp.co.aliber.accsystem.entity.auto.TLoginUserExample;
import jp.co.aliber.accsystem.mapper.auto.TLoginUserMapper;

/**
 * ログインサービス
 * 
 * @author zhong_zengqiang
 *
 */
@Service
public class TLoginUserService {

	@Autowired
	TLoginUserMapper tLoginUserMapper;

	/**
	 * ログインユーザー情報を取得(1件)
	 *
	 * @param emplyeeId
	 *            從業員番号
	 * @param compId
	 *            会社番号
	 * @return 從業員口座情報エンティティ
	 */
	public TLoginUser getTLoginUser(String loginId) {
		TLoginUserExample tLoginUserExample = new TLoginUserExample();
		tLoginUserExample.createCriteria().andLoginIdEqualTo(loginId);
		List<TLoginUser> loginUserList = tLoginUserMapper.selectByExample(tLoginUserExample);
		if (loginUserList == null || loginUserList.size() != 1) {
			// ユーザー情報を取得できなかった場合
			throw new UsernameNotFoundException("User not found for login id: " + loginId);
		}
		return loginUserList.get(0);
	}

	/**
	 * ログインユーザー情報を更新(1件)
	 *
	 * @param loginUser
	 *            ログインユーザー
	 */
	public void update(TLoginUser tLoginUser) {

		TLoginUserExample tLoginUserExample = new TLoginUserExample();
		tLoginUserExample.createCriteria().andLoginIdEqualTo(tLoginUser.getLoginId());
		tLoginUserMapper.updateByExampleSelective(tLoginUser, tLoginUserExample);
	}

}
