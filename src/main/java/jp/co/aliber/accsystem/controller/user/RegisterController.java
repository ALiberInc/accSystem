package jp.co.aliber.accsystem.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.aliber.accsystem.entity.auto.TCompany;
import jp.co.aliber.accsystem.entity.auto.TCompanyExample;
import jp.co.aliber.accsystem.entity.auto.TLoginUser;
import jp.co.aliber.accsystem.form.user.RegisterForm;
import jp.co.aliber.accsystem.mapper.auto.TCompanyMapper;
import jp.co.aliber.accsystem.service.user.RegisterService;

/**
 * アカウントの作成controller
 *
 * @author yu_k
 *
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

	/**
	 * アカウントの作成サービス
	 */
	@Autowired
	private RegisterService registerService;

	@Autowired
	private TCompanyMapper tCompanyMapper;

	/**
	 * データのバンディング
	 *
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	/**
	 * 初期表示
	 *
	 * @param form
	 *            アカウントの作成用form
	 * @return
	 */
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String index(RegisterForm form) {

		return "register";
	}

	/**
	 * 登録処理
	 *
	 * @param form
	 *            アカウントの作成用form
	 * @param result
	 *            Resultバンディング
	 * @return
	 */
	@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	public String save(@Validated RegisterForm form, BindingResult result) {
		// 入力チェック
		if (!validate(result)) {
			return "register";
		}
		TLoginUser loginUser = new TLoginUser();
		// 会社番号
		loginUser.setCompId(Integer.valueOf(form.getCompId()));
		// 姓
		loginUser.setLastName(form.getLastName());
		// 名
		loginUser.setFirstName(form.getFirstName());
		// 姓カナ
		if (StringUtils.isNotEmpty(form.getLastNameKana())) {
			loginUser.setLastNameKana(form.getLastNameKana());
		}
		// 名カナ
		if (StringUtils.isNotEmpty(form.getFirstNameKana())) {
			loginUser.setFirstNameKana(form.getFirstNameKana());
		}
		// アルファベット名
		if (StringUtils.isNotEmpty(form.getAlphabetName())) {
			loginUser.setAlphabetName(form.getAlphabetName());
		}
		// メールアドレス
		loginUser.setEmail(form.getEmail());
		// ユーザ名
		loginUser.setLoginId(form.getLoginId());
		// 暗証番号
		loginUser.setPassword(form.getPassword());

		registerService.regist(loginUser);

		return "redirect:/login";
	}

	/**
	 * 検索処理
	 *
	 * @param compName
	 *            会社名前
	 * @return JSONString
	 */
	@RequestMapping(value = { "/search" }, method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String search(@RequestParam(value = "compName", required = true) String compName) {

		TCompanyExample tCompanyExample = new TCompanyExample();
		tCompanyExample.createCriteria().andCompNameLike("%" + compName + "%");

		List<TCompany> tCompanyMapperList = tCompanyMapper.selectByExample(tCompanyExample);

		Map<String, Map<String, String>> tCompanysMap = new HashMap<>();

		if (CollectionUtils.isNotEmpty(tCompanyMapperList)) {

			tCompanyMapperList.forEach(tCompany -> {
				Map<String, String> tCompanyMap = new HashMap<>();

				tCompanyMap.put("compId", tCompany.getCompId().toString());

				tCompanyMap.put("compName", tCompany.getCompName());

				tCompanyMap.put("compTel",
						tCompany.getCompTel1() + "-" + tCompany.getCompTel2() + "-" + tCompany.getCompTel3());

				tCompanyMap.put("compAdd", tCompany.getCompAdd1());

				tCompanysMap.put(tCompany.getCompName(), tCompanyMap);
			});

		}
		return JSONValue.toJSONString(tCompanysMap);
	}

	/**
	 * 入力チェック
	 *
	 * @param BindingResult<br>
	 *            Resultバンディング
	 * @return validateResult<br>
	 *         入力チェック結果
	 */
	private boolean validate(BindingResult result) {

		boolean validateResult = true;

		// 入力チェック
		if (result.hasErrors()) {
			validateResult = false;
		}
		// 入力チェック結果
		return validateResult;
	}
}