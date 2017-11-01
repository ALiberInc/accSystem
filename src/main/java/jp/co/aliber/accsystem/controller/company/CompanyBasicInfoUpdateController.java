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
@RequestMapping("/companyUpdate")
public class CompanyBasicInfoUpdateController {

	@Autowired
	TLoginUserService loginUserService;
	@Autowired
	CompanyBasicInfoService companyBasicInfoService;
	@Autowired
	UtilService utilService;
	@Autowired
	MessageSource messages;

	// 更新・新規フラグ、デフォルトは新規の場合false
	boolean updateFlg = false;

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
	public String index(@AuthenticationPrincipal LoginUser loginUser, Model model, CompanyBasicInfoForm form) {
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
		// 会社情報を編集の場合
		if (loginUser.getUser().getCompId() != null) {
			// 更新の場合フラグtrueにする
			updateFlg = true;
			// 会社番号
			Integer compId = loginUser.getUser().getCompId();
			// 会社情報を取得
			TCompany a = companyBasicInfoService.searchComp(compId);
			// 法人名
			form.setCompName(a.getCompName());
			// 法人名フリガナ
			form.setCompKana(a.getCompKana());
			// 郵便番号
			form.setCompZip1(a.getCompZip1());
			form.setCompZip2(a.getCompZip2());
			// 住所1
			form.setCompAdd1(a.getCompAdd1());
			if (StringUtils.isNotEmpty(a.getCompAdd2())) {
				form.setCompAdd2(a.getCompAdd2());
			} else {
				form.setCompAdd2(null);
			}
			// 住所1フリガナ
			form.setCompAdd1Kana(a.getCompAdd1Kana());
			if (StringUtils.isNotEmpty(a.getCompAdd2Kana())) {
				form.setCompAdd2Kana(a.getCompAdd2Kana());
			} else {
				form.setCompAdd2Kana(null);
			}
			// 電話番号
			form.setCompTel1(a.getCompTel1());
			form.setCompTel2(a.getCompTel2());
			form.setCompTel3(a.getCompTel3());
			// 事業区分
			form.setClassification(String.valueOf(a.getClassification()));
			// 法人番号
			form.setCorporationId(String.valueOf(a.getCorporationId()));
			// 事業主氏名
			form.setCorpOwnerName(a.getCorpOwnerName());
			// 事業主氏名フリガナ
			form.setCorpOwnerNameKana(a.getCorpOwnerNameKana());
			// 事業所整理記号
			form.setCorpSortNo1(a.getCorpSortNo1());
			form.setCorpSortNo2(a.getCorpSortNo2());
			// 事業所番号
			form.setCorpNo(String.valueOf(a.getCorpNo()));
			// 事業種目
			form.setCorpKind(a.getCorpKind());
			// 締め日が末日
			form.setDeadlineDay(a.getDeadlineDay() ? "0" : "1");
			// 締め日の末日以外日数
			form.setDeadlineAdjustDays(
					a.getDeadlineAdjustDays() != null ? String.valueOf(a.getDeadlineAdjustDays()) : null);
			// 支給日が末日
			form.setPaymentDay(a.getPaymentDay() ? "0" : "1");
			// 支給日の末日以外日数
			form.setPaymentAdjustDays(
					a.getPaymentAdjustDays() != null ? String.valueOf(a.getPaymentAdjustDays()) : null);
			// 経理責任者
			form.setAccountingManager(a.getAccountingManager());
			// 利用者識別番号
			form.setUserRecongId(a.getUserRecognizeId() != null ? String.valueOf(a.getUserRecognizeId()) : null);
			// 利用者ID
			form.setUserId(a.getUserId() != null ? String.valueOf(a.getUserId()) : null);
			// 税理者
			form.setTaxAccountant(a.getTaxAccountant());
			// 税理署
			form.setTaxOffice(a.getTaxOffice());
			// データ共有ID
			form.setDataShareId(String.valueOf(a.getDataShareId()));
			// 会社コード
			form.setCompCode(String.valueOf(a.getCompCode()));
			// 雇用保険被保険者負担率
			form.setEmployInsurRate(String.valueOf(a.getEmployInsurRate()));
			// 雇用保険被保険者負担率
			form.setEmployRounding(String.valueOf(a.getEmployRounding()));
			// 健康保険料率(介護保険該当なし)
			form.setHealthInsurRate(String.valueOf(a.getHealthInsurRateNoNursing()));
			// 健康保険料率（介護保険該当者）
			form.setHealthInsurRate2(String.valueOf(a.getHealthInsurRateWithNursing()));
			// 健康保険端数処理
			form.setHealthRounding(String.valueOf(a.getHealthRounding()));
			// 厚生年金保険料率
			form.setWelfareInsurance(String.valueOf(a.getWelfareInsuranceRate()));
			// 厚生年金端数処理
			form.setWelfareRounding(String.valueOf(a.getWelfareRounding()));
			// 基金免除保険料率
			form.setWelfareExemptionRate(String.valueOf(a.getWelfareExceptionRate()));
			// 基金独自給付加算率
			form.setWelfareAdditionRate(String.valueOf(a.getWelfareAdditionRate()));
			// 基金独自給付加算定額
			form.setWelfareAdditionRation(String.valueOf(a.getWelfareAdditionRation()));
		}
		return "company/company_basic_info_update";
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
			return "company/company_basic_info_update";
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
		// 新規の場合登録処理を呼び出す
		if (!updateFlg) {
			companyBasicInfoService.regist(company, Integer.valueOf(loginUser.getUser().getUserId()));
			// 会社IDを更新
			TLoginUser tLoginUser = new TLoginUser();
			Integer compId = utilService.getSeqLastValue();
			tLoginUser.setCompId(compId);
			tLoginUser.setLoginId(loginUser.getUser().getLoginId());
			loginUserService.update(tLoginUser);
			// 会社IDを保持
			loginUser.getUser().setCompId(compId);
		}
		// 更新の場合会社情報を更新する
		if (updateFlg) {
			// ログイン情報から会社番号を取得する
			company.setCompId(loginUser.getUser().getCompId());
			// 更新処理を呼び出す
			companyBasicInfoService.update(company, Integer.valueOf(loginUser.getUser().getUserId()));
		}

		return "redirect:/finish?forwardURL=company";

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
		// 会社名重複チェック(新規場合のみ)
		if (StringUtils.isNotEmpty(form.getCompName()) && !updateFlg) {
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
