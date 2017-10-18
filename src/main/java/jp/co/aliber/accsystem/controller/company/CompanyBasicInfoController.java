package jp.co.aliber.accsystem.controller.company;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.MessageSource;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.aliber.accsystem.ImmutableValues;
import jp.co.aliber.accsystem.entity.auto.TCompany;
import jp.co.aliber.accsystem.entity.auto.TLoginUser;
import jp.co.aliber.accsystem.form.company.CompanyBasicInfoForm;
import jp.co.aliber.accsystem.security.LoginUser;
import jp.co.aliber.accsystem.service.UtilService;
import jp.co.aliber.accsystem.service.company.CompanyBasicInfoService;
import jp.co.aliber.accsystem.service.user.TLoginUserService;

/**
 * 会社基本情報入力
 *
 * @author yu_k
 *
 */
@Controller
@RequestMapping("/company")
public class CompanyBasicInfoController {

	@Autowired
	TLoginUserService loginUserService;
	@Autowired
	CompanyBasicInfoService companyBasicInfoService;
	@Autowired
	UtilService utilService;
	@Autowired
	MessageSource messages;

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
	 * @param locale
	 *            ロケ－ル
	 * @param model
	 *            モデル
	 * @param form
	 *            会社基本情報入力画面用form
	 * @return
	 */
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String index(Model model, CompanyBasicInfoForm form) {
		// 事業区分のディフォルト値:法人
		form.setClassification("0");
		// 締め日、支給日のディフォルト値:未日
		form.setPaymentDay("0");
		form.setDeadlineDay("0");
		// 社会保険について項目がデフォルト値を設定する
		// 被保険者負担率
		form.setEmployInsurRate(ImmutableValues.EMPLOY_INSURANCE_RATE);
		// 端数処理:50捨51入
		form.setEmployRounding(ImmutableValues.ROUNDING_HALF_UP);
		// 保険料率（介護保険該当なし）
		form.setHealthInsurRate(ImmutableValues.HEALTH_INSUTANCE_RATE);
		// 保険料率（介護保険該当者）
		form.setHealthInsurRate2(ImmutableValues.HEALTH_INSURANCE_RATE_2);
		// 端数処理:50捨51入
		form.setHealthRounding(ImmutableValues.ROUNDING_HALF_UP);
		// 保険料率
		form.setWelfareInsurance(ImmutableValues.WELFARE_INSURANCE_RATE);
		// 端数処理:50捨51入
		form.setWelfareRounding(ImmutableValues.ROUNDING_HALF_UP);
		// 基金免除保険料率
		form.setWelfareExemptionRate(ImmutableValues.WELFARE_EXEMPTION_RATE);
		// 基金独自給付加算率(従業員負担分)
		form.setWelfareAdditionRate(ImmutableValues.WELFARE_ADDITION_RATE);

		return "company/companyBasicInfo";
	}

	/**
	 * 登録ボタンを押下する
	 * 
	 * @param model
	 *            モデル
	 * @param form
	 *            会社基本情報入力画面用form
	 * @param loginUser
	 *            登録ユーザ情報
	 * @param result
	 *            bindingresult
	 * @return
	 */
	@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	public String save(@AuthenticationPrincipal LoginUser loginUser, @Validated CompanyBasicInfoForm form,
			BindingResult result, Model model) {
		// 入力チェック
		if (!validate(form, result)) {
			return "company/companyBasicInfo";
		}
		// エンティティに会社情報を設定する
		TCompany company = new TCompany();
		// 法人名
		company.setCompName(form.getCompName());

		// 法人名フリガナ
		company.setCompKana(form.getCompKana());
		// 郵便番号1
		company.setCompZip1(form.getCompZip1() + "");
		// 郵便番号2
		company.setCompZip2(form.getCompZip2() + "");

		// 住所1
		company.setCompAdd1(form.getCompAdd1());
		// 住所2
		if (StringUtils.isNotEmpty(form.getCompAdd2())) {
			company.setCompAdd2(form.getCompAdd2());
		}
		// 住所1フリガナ
		company.setCompAdd1Kana(form.getCompAdd1Kana());
		// 住所2フリガナ
		if (StringUtils.isNotEmpty(form.getCompAdd2Kana())) {
			company.setCompAdd2Kana(form.getCompAdd2Kana());
		}
		// 電話番号1
		company.setCompTel1(form.getCompTel1());
		// 電話番号2
		company.setCompTel2(form.getCompTel2());
		// 電話番号3
		company.setCompTel3(form.getCompTel3());
		// 事業区分
		company.setClassification(Integer.valueOf(form.getClassification()));
		// 法人番号
		company.setCorporationId(Long.valueOf(form.getCorporationId()));
		// 事業主氏名
		company.setCorpOwnerName(form.getCorpOwnerName());
		// 事業主氏名フリガナ
		company.setCorpOwnerNameKana(form.getCorpOwnerNameKana());
		// 事業所整理記号1
		company.setCorpSortNo1(form.getCorpSortNo1());
		// 事業所整理記号2
		company.setCorpSortNo2(form.getCorpSortNo2());
		// 事業所番号
		company.setCorpNo(Long.valueOf(form.getCorpNo()));
		// 事業種目
		company.setCorpKind(form.getCorpKind());
		// 締め日が末日
		company.setDeadlineDay(form.getDeadlineDay() == ImmutableValues.LAST_DAY ? true : false);
		// 締め日の末日以外日数
		if (form.getDeadlineAdjustDays() != null) {
			company.setDeadlineAdjustDays(Integer.valueOf(form.getDeadlineAdjustDays()));
		}
		// 支給日が末日
		company.setPaymentDay(form.getPaymentDay() == ImmutableValues.LAST_DAY ? true : false);
		// 支給日の末日以外日数
		if (form.getPaymentAdjustDays() != null) {
			company.setPaymentAdjustDays(Integer.valueOf(form.getPaymentAdjustDays()));
		}
		// 経理責任者
		company.setAccountingManager(form.getAccountingManager());
		// 利用者識別番号
		if (form.getUserRecongId() != null) {
			company.setUserRecognizeId(Long.valueOf(form.getUserRecongId()));
		}
		// 利用者ID
		if (form.getUserId() != null) {
			company.setUserId(Long.valueOf(form.getUserId()));
		}
		// 税理者
		company.setTaxAccountant(form.getTaxAccountant());
		// 税理署
		company.setTaxOffice(form.getTaxOffice());
		// データ共有ID
		company.setDataShareId(Long.valueOf(form.getDataShareId()));
		// TODO マイナンバーマスタから個人番号を取得して、今実装していない
		company.setGetMyNumber(false);
		// 会社コード
		company.setCompCode(Long.valueOf(form.getCompCode()));
		// 雇用保険被保険者負担率
		company.setEmployInsurRate(
				new BigDecimal(form.getEmployInsurRate()).setScale(0, Integer.valueOf(form.getEmployRounding())));
		// 雇用保険被保険者負担率
		company.setEmployRounding(Integer.valueOf(form.getEmployRounding()));
		// 健康保険料率(介護保険該当なし)
		company.setHealthInsurRateNoNursing(
				new BigDecimal(form.getHealthInsurRate()).setScale(2, Integer.valueOf(form.getHealthRounding())));
		// 健康保険料率（介護保険該当者）
		company.setHealthInsurRateWithNursing(
				new BigDecimal(form.getHealthInsurRate2()).setScale(2, Integer.valueOf(form.getHealthRounding())));
		// 健康保険端数処理
		company.setHealthRounding(Integer.valueOf(form.getHealthRounding()));
		// 厚生年金保険料率
		company.setWelfareInsuranceRate(
				new BigDecimal(form.getWelfareInsurance()).setScale(3, Integer.valueOf(form.getWelfareRounding())));
		// 厚生年金端数処理
		company.setWelfareRounding(Integer.valueOf(form.getWelfareRounding()));
		// 基金免除保険料率
		company.setWelfareExceptionRate(
				new BigDecimal(form.getWelfareExemptionRate()).setScale(2, BigDecimal.ROUND_HALF_UP));
		// 基金免除保険料率
		company.setWelfareAdditionRate(
				new BigDecimal(form.getWelfareAdditionRate()).setScale(2, BigDecimal.ROUND_HALF_UP));
		// 基金独自給付加算定額
		company.setWelfareAdditionRation(Integer.valueOf(form.getWelfareAdditionRation()));
		// Integer userId = Integer.valueOf(loginUser.getUser().getLoginId());
		// 登録処理を呼び出す
		companyBasicInfoService.regist(company, ImmutableValues.DEFAULT_USER_ID);

		//会社新規の場合、会社IDを更新
		TLoginUser tLoginUser = new TLoginUser();
		Integer compId = utilService.getSeqLastValue();
		tLoginUser.setCompId(compId);
		tLoginUser.setLoginId(loginUser.getUser().getLoginId());
		loginUserService.update(tLoginUser);

		//会社IDを保持
		loginUser.getUser().setCompId(compId);
		return "redirect:/finish?forwardURL=top_menu";

	}

	/**
	 * 入力チェック
	 *
	 * @param LoginuserinfoeditForm<br>
	 *            ログイン者情報編集Form
	 * @param BindingResult<br>
	 *            Resultバンディング
	 * @return validateResult<br>
	 *         入力チェック結果
	 */
	private boolean validate(CompanyBasicInfoForm form, BindingResult result) {

		boolean validateResult = true;

		// 入力チェック
		if (result.hasErrors()) {
			validateResult = false;
		}
		// 会社名重複チェック
		if (StringUtils.isNotEmpty(form.getCompName())) {
			if (companyBasicInfoService.checkIfCompNameExist(form.getCompName())) {
				result.rejectValue("compName", "error.duplicated",
						new Object[] { messages.getMessage("companyBasicInfoForm.compName", null, null) }, "");
				validateResult = false;
			}
		}

		// 日数チェック
		if (StringUtils.isNotEmpty(form.getDeadlineDay()) && form.getDeadlineDay().equals("0")) {
			if (StringUtils.isNotEmpty(form.getDeadlineAdjustDays())) {
				result.rejectValue("deadlineAdjustDays", "error.adjustDays");
				validateResult = false;
			}
		}
		if (StringUtils.isNotEmpty(form.getDeadlineDay()) && form.getDeadlineDay().equals("1")) {
			if (StringUtils.isEmpty(form.getDeadlineAdjustDays())) {
				result.rejectValue("deadlineAdjustDays", "error.noAdjustDays");
				validateResult = false;
			}
		}
		if (StringUtils.isNotEmpty(form.getPaymentDay()) && form.getPaymentDay().equals("0")) {
			if (StringUtils.isNotEmpty(form.getPaymentAdjustDays())) {
				result.rejectValue("paymentAdjustDays", "error.adjustDays");
				validateResult = false;
			}
		}
		if (StringUtils.isNotEmpty(form.getPaymentDay()) && form.getPaymentDay().equals("1")) {
			if (StringUtils.isEmpty(form.getPaymentAdjustDays())) {
				result.rejectValue("paymentAdjustDays", "error.noAdjustDays");
				validateResult = false;
			}
		}
		// 入力チェック結果
		return validateResult;
	}

}
