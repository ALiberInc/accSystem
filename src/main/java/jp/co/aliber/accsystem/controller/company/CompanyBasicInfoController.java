package jp.co.aliber.accsystem.controller.company;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
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
import jp.co.aliber.accsystem.form.company.CompanyBasicInfoForm;
import jp.co.aliber.accsystem.security.LoginUser;
import jp.co.aliber.accsystem.service.company.CompanyBasicInfoService;

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
	CompanyBasicInfoService companyBasicInfoService;
	// 締め日/支給日が末日の場合
	private static String LAST_DAY = "0";


	/**
	 * データのバンディング
	 *
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class,
				new StringTrimmerEditor(true));
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
	@RequestMapping(value = {"/", "" }, method = RequestMethod.GET)
	public String index(CompanyBasicInfoForm form) {
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
	@RequestMapping(value = {"/save" }, method = RequestMethod.POST)
	public String save(Model model, @Validated CompanyBasicInfoForm form,
			@AuthenticationPrincipal LoginUser loginUser,
			BindingResult result) {
		// 入力チェック
		if (!validate(model, form, result)) {
			return "company/companyBasicInfo";
		}
		// エンティティに会社情報を設定する
		TCompany company = new TCompany();
		// 法人名
		if (StringUtils.isNotEmpty(form.getCompName())) {
			company.setCompName(form.getCompName());
		}
		// 法人名フリガナ
		if (StringUtils.isNotEmpty(form.getCompKana())) {
			company.setCompKana(form.getCompKana());
		}
		// 郵便番号1
		if (StringUtils.isNotEmpty(form.getCompZip1())) {
			company.setCompZip1(form.getCompZip1());
		}
		// 郵便番号2
		if (StringUtils.isNotEmpty(form.getCompZip2())) {
			company.setCompZip2(form.getCompZip2());
		}
		// 住所1
		if (StringUtils.isNotEmpty(form.getCompAdd1())) {
			company.setCompAdd1(form.getCompAdd1());
		}
		// 住所2
		if (StringUtils.isNotEmpty(form.getCompAdd2())) {
			company.setCompAdd2(form.getCompAdd2());
		}
		// 住所1フリガナ
		if (StringUtils.isNotEmpty(form.getCompAdd1Kana())) {
			company.setCompAdd1Kana(form.getCompAdd1Kana());
		}
		// 住所2フリガナ
		if (StringUtils.isNotEmpty(form.getCompAdd2Kana())) {
			company.setCompAdd2Kana(form.getCompAdd2Kana());
		}
		// 電話番号1
		if (StringUtils.isNotEmpty(form.getCompTel1())) {
			company.setCompTel1(form.getCompTel1());
		}
		// 電話番号2
		if (StringUtils.isNotEmpty(form.getCompTel2())) {
			company.setCompTel2(form.getCompTel2());
		}
		// 電話番号3
		if (StringUtils.isNotEmpty(form.getCompTel3())) {
			company.setCompTel3(form.getCompTel3());
		}
		// 事業区分
		if (StringUtils.isNotEmpty(form.getClassification())) {
			company.setClassification(
					Integer.valueOf(form.getClassification()));
		}
		// 法人番号
		if (form.getCorporationId() != null) {
			company.setCorporationId(Long.valueOf(form.getCorporationId()));
		}
		// 事業主氏名
		if (StringUtils.isNotEmpty(form.getCorpOwnerName())) {
			company.setCorpOwnerName(form.getCorpOwnerName());
		}
		// 事業主氏名フリガナ
		if (StringUtils.isNotEmpty(form.getCorpOwnerNameKana())) {
			company.setCorpOwnerNameKana(form.getCorpOwnerNameKana());
		}
		// 事業所整理記号1
		if (StringUtils.isNotEmpty(form.getCorpSortNo1())) {
			company.setCorpSortNo1(form.getCorpSortNo1());
		}
		// 事業所整理記号2
		if (StringUtils.isNotEmpty(form.getCorpSortNo2())) {
			company.setCorpSortNo2(form.getCorpSortNo2());
		}
		// 事業所番号
		if (form.getCorpNo() != null) {
			company.setCorpNo(Long.valueOf(form.getCorpNo()));
		}
		// 事業種目
		if (StringUtils.isNotEmpty(form.getCorpKind())) {
			company.setCorpKind(form.getCorpKind());
		}
		// 締め日が末日
		if (StringUtils.isNotEmpty(form.getDeadlineDay())) {
			company.setDeadlineDay(
					form.getDeadlineDay() == LAST_DAY ? true : false);
		}
		// 締め日の末日以外日数
		if (form.getDeadlineAdjustDays() != null) {
			company.setDeadlineAdjustDays(
					Integer.valueOf(form.getDeadlineAdjustDays()));
		}
		// 支給日が末日
		if (StringUtils.isNotEmpty(form.getPaymentDay())) {
			company.setPaymentDay(
					form.getPaymentDay() == LAST_DAY ? true : false);
		}
		// 支給日の末日以外日数
		if (form.getPaymentAdjustDays() != null) {
			company.setPaymentAdjustDays(
					Integer.valueOf(form.getPaymentAdjustDays()));
		}
		// 経理責任者
		if (StringUtils.isNotEmpty(form.getAccountingManager())) {
			company.setAccountingManager(form.getAccountingManager());
		}
		// 利用者識別番号
		if (form.getUserRecongId() != null) {
			company.setUserRecognizeId(Long.valueOf(form.getUserRecongId()));
		}
		// 利用者ID
		if (form.getUserId() != null) {
			company.setUserId(Long.valueOf(form.getUserId()));
		}
		// 税理者
		if (StringUtils.isNotEmpty(form.getTaxAccountant())) {
			company.setTaxAccountant(form.getTaxAccountant());
		}
		// 税理署
		if (StringUtils.isNotEmpty(form.getTaxOffice())) {
			company.setTaxOffice(form.getTaxOffice());
		}
		// データ共有ID
		if (form.getDataShareId() != null) {
			company.setDataShareId(Long.valueOf(form.getDataShareId()));
		}
		// TODO マイナンバーマスタから個人番号を取得して、今実装していない
		company.setGetMyNumber(false);
		// 会社コード
		if (form.getCompCode() != null) {
			company.setCompCode(Long.valueOf(form.getCompCode()));
		}
		// 雇用保険被保険者負担率
		if (StringUtils.isNotEmpty(form.getEmployInsurRate())) {
			company.setEmployInsurRate(new BigDecimal(form.getEmployInsurRate())
					.setScale(0, Integer.valueOf(form.getEmployRounding())));
		}
		// 雇用保険被保険者負担率
		if (StringUtils.isNotEmpty(form.getEmployRounding())) {
			company.setEmployRounding(
					Integer.valueOf(form.getEmployRounding()));
		}
		// 健康保険料率(介護保険該当なし)
		if (StringUtils.isNotEmpty(form.getHealthInsurRate())) {
			company.setHealthInsurRateNoNursing(
					new BigDecimal(form.getHealthInsurRate()).setScale(2,
							Integer.valueOf(form.getHealthRounding())));
		}
		// 健康保険料率（介護保険該当者）
		if (StringUtils.isNotEmpty(form.getHealthInsurRate2())) {
			company.setHealthInsurRateWithNursing(
					new BigDecimal(form.getHealthInsurRate2()).setScale(2,
							Integer.valueOf(form.getHealthRounding())));
		}
		// 健康保険端数処理
		if (StringUtils.isNotEmpty(form.getHealthRounding())) {
			company.setHealthRounding(
					Integer.valueOf(form.getHealthRounding()));
		}
		// 厚生年金保険料率
		if (StringUtils.isNotEmpty(form.getWelfareInsurance())) {
			company.setWelfareInsuranceRate(
					new BigDecimal(form.getWelfareInsurance()).setScale(3,
							Integer.valueOf(form.getWelfareRounding())));
		}
		// 厚生年金端数処理
		if (StringUtils.isNotEmpty(form.getWelfareRounding())) {
			company.setWelfareRounding(
					Integer.valueOf(form.getWelfareRounding()));
		}
		// 基金免除保険料率
		if (StringUtils.isNotEmpty(form.getWelfareExemptionRate())) {
			company.setWelfareExceptionRate(
					new BigDecimal(form.getWelfareExemptionRate()).setScale(2,
							BigDecimal.ROUND_HALF_UP));
		}
		// 基金免除保険料率
		if (StringUtils.isNotEmpty(form.getWelfareAdditionRate())) {
			company.setWelfareAdditionRate(
					new BigDecimal(form.getWelfareAdditionRate()).setScale(2,
							BigDecimal.ROUND_HALF_UP));
		}
		// 基金独自給付加算定額
		if (StringUtils.isNotEmpty(form.getWelfareAdditionRation())) {
			company.setWelfareAdditionRation(
					Integer.valueOf(form.getWelfareAdditionRation()));
		}
		Integer userId = Integer.valueOf(loginUser.getUser().getLoginId());
		// 登録処理を呼び出す
		companyBasicInfoService.regist(company, userId);
		return "company/companyBasicInfo";
	}


	/**
	 * 入力チェック
	 *
	 * @param model<br>
	 *            モデル
	 * @param LoginuserinfoeditForm<br>
	 *            ログイン者情報編集Form
	 * @param BindingResult<br>
	 *            Resultバンディング
	 * @return validateResult<br>
	 *         入力チェック結果
	 */
	private boolean validate(Model model, CompanyBasicInfoForm form,
			BindingResult result) {

		boolean validateResult = true;

		// 入力チェック
		if (result.hasErrors()) {
			validateResult = false;
		}
		// 入力チェック結果
		return validateResult;
	}

}
