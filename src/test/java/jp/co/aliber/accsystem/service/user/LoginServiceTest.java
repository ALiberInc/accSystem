package jp.co.aliber.accsystem.service.user;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.aliber.accsystem.ImmutableValues;
import jp.co.aliber.accsystem.entity.auto.TLoginUser;
import jp.co.aliber.accsystem.mapper.auto.TLoginUserMapper;

/**
 * ログインサービスのテスター
 * 
 * @author zhong_zengqiang
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginServiceTest {

	@Autowired
	LoginService loginService;
	@Autowired
	TLoginUserMapper tLoginUserMapper;

	@Before
	public void setUp() throws Exception {
		tLoginUserMapper.insertSelective(createLoginUser());
	}

	@After
	public void tearDown() throws Exception {
		tLoginUserMapper.deleteByPrimaryKey(Integer.MAX_VALUE);
	}

	/**
	 * ログインユーザー情報の取得処理(1件)をテスト
	 *
	 */
	@Test
	public void testGetTLoginUser() {

		// ユーザー情報を取得
		TLoginUser loginUser = loginService.getTLoginUser("XXYYZZAAHH");
		// ユーザーID
		assertEquals(Integer.MAX_VALUE, loginUser.getUserId().intValue());
		// 会社ID
		assertEquals(1, loginUser.getCompId().intValue());
		// 姓
		assertEquals("孫", loginUser.getLastName());
		// 名
		assertEquals("悟空", loginUser.getFirstName());
		// 姓カナ
		assertEquals("ソン", loginUser.getLastNameKana());
		// 名カナ
		assertEquals("ゴクウ", loginUser.getFirstNameKana());
		// アルファベット名
		assertEquals("son goku", loginUser.getAlphabetName());
		// メールアドレス
		assertEquals("jack@kcaj.com", loginUser.getEmail());
		// ログインID
		assertEquals("XXYYZZAAHH", loginUser.getLoginId());
		// 暗証番号
		assertEquals("SDF##FDS", loginUser.getPassword());
		// 登録者ID
		assertEquals(ImmutableValues.DEFAULT_USER_ID, loginUser.getRegistId());
		// 更新者ID
		assertEquals(ImmutableValues.DEFAULT_USER_ID, loginUser.getUpdateId());

		// ユーザー情報を取得
		try {
			loginService.getTLoginUser("==XXYYZZAAHH");
		} catch (UsernameNotFoundException e) {
			assertEquals("User not found for login id: ==XXYYZZAAHH", e.getMessage());
		}
	}

	/**
	 * ログインユーザー情報の更新処理(1件)をテスト
	 * 
	 */
	@Test
	public void testUpdate() {
		// ユーザー情報を設定
		TLoginUser loginUser = new TLoginUser();
		// ユーザーID
		loginUser.setUserId(Integer.MAX_VALUE);
		// 会社ID
		loginUser.setCompId(33);
		// 姓
		loginUser.setLastName("孫1");
		// 名
		loginUser.setFirstName("悟空1");
		// 姓カナ
		loginUser.setLastNameKana("ソン1");
		// 名カナ
		loginUser.setFirstNameKana("ゴクウ1");
		// アルファベット名
		loginUser.setAlphabetName("son goku1");
		// メールアドレス
		loginUser.setEmail("jack@kcaj.com1");
		// ログインID
		loginUser.setLoginId("XXYYZZAAHH");
		// 暗証番号
		loginUser.setPassword("SDF##FDS1");
		// 登録者ID
		loginUser.setRegistId(111);
		// 更新者ID
		loginUser.setUpdateId(222);

		loginService.update(loginUser);
		// ユーザー情報を取得
		TLoginUser loginUser1 = tLoginUserMapper.selectByPrimaryKey(Integer.MAX_VALUE);

		// ユーザーID
		assertEquals(Integer.MAX_VALUE, loginUser1.getUserId().intValue());
		// 会社ID
		assertEquals(33, loginUser1.getCompId().intValue());
		// 姓
		assertEquals("孫1", loginUser1.getLastName());
		// 名
		assertEquals("悟空1", loginUser1.getFirstName());
		// 姓カナ
		assertEquals("ソン1", loginUser1.getLastNameKana());
		// 名カナ
		assertEquals("ゴクウ1", loginUser1.getFirstNameKana());
		// アルファベット名
		assertEquals("son goku1", loginUser1.getAlphabetName());
		// メールアドレス
		assertEquals("jack@kcaj.com1", loginUser1.getEmail());
		// ログインID
		assertEquals("XXYYZZAAHH", loginUser1.getLoginId());
		// 暗証番号
		assertEquals("SDF##FDS1", loginUser1.getPassword());
		// 登録者ID
		assertEquals(111, loginUser1.getRegistId().intValue());
		// 更新者ID
		assertEquals(222, loginUser1.getUpdateId().intValue());
	}

	/**
	 * ユーザー情報を作成
	 *
	 */
	private TLoginUser createLoginUser() {

		// ユーザー情報を設定
		TLoginUser loginUser = new TLoginUser();
		// ユーザーID
		loginUser.setUserId(Integer.MAX_VALUE);
		// 会社ID
		loginUser.setCompId(1);
		// 姓
		loginUser.setLastName("孫");
		// 名
		loginUser.setFirstName("悟空");
		// 姓カナ
		loginUser.setLastNameKana("ソン");
		// 名カナ
		loginUser.setFirstNameKana("ゴクウ");
		// アルファベット名
		loginUser.setAlphabetName("son goku");
		// メールアドレス
		loginUser.setEmail("jack@kcaj.com");
		// ログインID
		loginUser.setLoginId("XXYYZZAAHH");
		// 暗証番号
		loginUser.setPassword("SDF##FDS");
		// 登録者ID
		loginUser.setRegistId(ImmutableValues.DEFAULT_USER_ID);
		// 更新者ID
		loginUser.setUpdateId(ImmutableValues.DEFAULT_USER_ID);
		return loginUser;
	}
}
