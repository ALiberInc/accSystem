/**
 * 
 */
package jp.co.aliber.accsystem.service.user;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.aliber.accsystem.entity.auto.TLoginUser;
import jp.co.aliber.accsystem.mapper.auto.TLoginUserMapper;

/**
 * 新規ユーザー登録サービスのテスター
 * 
 * @author zhong_zengqiang
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RegisterServiceTest {

	@Autowired
	RegisterService registerService;
	@Autowired
	TLoginUserMapper tLoginUserMapper;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		registerService.regist(createLoginUser());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		tLoginUserMapper.deleteByPrimaryKey(Integer.MAX_VALUE);
	}

	/**
	 * 登録処理をテスト
	 */
	@Test
	public void testRegist() {
		// ユーザー情報を取得
		TLoginUser loginUser = tLoginUserMapper.selectByPrimaryKey(Integer.MAX_VALUE);
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
	}

	/**
	 * ログインID重複チェックをテスト
	 */
	@Test
	public void testCheckIfLoginIdExist() {
		assertTrue(registerService.checkIfLoginIdExist("XXYYZZAAHH"));
		assertFalse(registerService.checkIfLoginIdExist("=XXYYZZAAHH="));
	}

	/**
	 * メールの重複チェックをテスト
	 */
	@Test
	public void testCheckIfEmailExist() {
		assertTrue(registerService.checkIfEmailExist("jack@kcaj.com"));
		assertFalse(registerService.checkIfEmailExist("=XXYYZZAAHH=@kcaj.com"));
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

		return loginUser;
	}

}
