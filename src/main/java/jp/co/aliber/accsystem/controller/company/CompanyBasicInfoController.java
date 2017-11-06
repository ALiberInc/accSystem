package jp.co.aliber.accsystem.controller.company;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.aliber.accsystem.entity.auto.TCompany;
import jp.co.aliber.accsystem.form.company.CompanyBasicInfoForm;
import jp.co.aliber.accsystem.security.LoginUser;
import jp.co.aliber.accsystem.service.company.CompanyBasicInfoService;

/**
 * 会社基本情報画面
 *
 * @author yu_k
 *
 */
@Controller
@RequestMapping("/company")
public class CompanyBasicInfoController {

	@Autowired
	CompanyBasicInfoService companyBasicInfoService;

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

		// ユーザー新規登録の場合、会社IDがないので、会社基本情報設定画面に遷移
		if (loginUser.getUser().getCompId() == null) {
			return "redirect:/companyUpdate";
		}

		// 会社番号
		Integer compId = loginUser.getUser().getCompId();
		// 会社情報を取得
		TCompany tCompany = companyBasicInfoService.searchComp(compId);
		// 法人名
		form.setCompName(tCompany.getCompName());
		// 法人名フリガナ
		form.setCompKana(tCompany.getCompKana());
		// 郵便番号
		form.setCompZip1(tCompany.getCompZip1());
		form.setCompZip2(tCompany.getCompZip2());
		// 住所1
		form.setCompAdd1(tCompany.getCompAdd1());
		if (StringUtils.isNotEmpty(tCompany.getCompAdd2())) {
			form.setCompAdd2(tCompany.getCompAdd2());
		} else {
			form.setCompAdd2(null);
		}
		// 住所1フリガナ
		form.setCompAdd1Kana(tCompany.getCompAdd1Kana());
		if (StringUtils.isNotEmpty(tCompany.getCompAdd2Kana())) {
			form.setCompAdd2Kana(tCompany.getCompAdd2Kana());
		} else {
			form.setCompAdd2Kana(null);
		}
		// 電話番号
		form.setCompTel1(tCompany.getCompTel1());
		form.setCompTel2(tCompany.getCompTel2());
		form.setCompTel3(tCompany.getCompTel3());
		// 事業区分
		form.setClassification(String.valueOf(tCompany.getClassification()));
		// 法人番号
		form.setCorporationId(String.valueOf(tCompany.getCorporationId()));
		// 事業主氏名
		form.setCorpOwnerName(tCompany.getCorpOwnerName());
		// 事業主氏名フリガナ
		form.setCorpOwnerNameKana(tCompany.getCorpOwnerNameKana());
		// 事業所整理記号
		form.setCorpSortNo1(tCompany.getCorpSortNo1());
		form.setCorpSortNo2(tCompany.getCorpSortNo2());
		// 事業所番号
		form.setCorpNo(String.valueOf(tCompany.getCorpNo()));
		// 事業種目
		form.setCorpKind(tCompany.getCorpKind());
		// 締め日が末日
		form.setDeadlineDay(tCompany.getDeadlineDay());
		// 締め日の末日以外日数
		form.setDeadlineAdjustDays(tCompany.getDeadlineAdjustDays());
		// 支給日が末日
		form.setPaymentDay(tCompany.getPaymentDay());
		// 支給日の末日以外日数
		form.setPaymentAdjustDays(tCompany.getPaymentAdjustDays());
		// 経理責任者
		form.setAccountingManager(tCompany.getAccountingManager());
		// 利用者識別番号
		form.setUserRecongId(tCompany.getUserRecognizeId() != null ? tCompany.getUserRecognizeId() : StringUtils.EMPTY);
		// 利用者ID
		form.setUserId(tCompany.getUserId() != null ? tCompany.getUserId() : StringUtils.EMPTY);
		// 税理者
		form.setTaxAccountant(tCompany.getTaxAccountant());
		// 税理署
		form.setTaxOffice(tCompany.getTaxOffice());
		// データ共有ID
		form.setDataShareId(String.valueOf(tCompany.getDataShareId()));
		// 会社コード
		form.setCompCode(String.valueOf(tCompany.getCompCode()));
		// 雇用保険被保険者負担率
		form.setEmployInsurRate(String.valueOf(tCompany.getEmployInsurRate()));
		// 雇用保険被保険者負担率
		form.setEmployRounding(String.valueOf(tCompany.getEmployRounding()));
		// 健康保険料率(介護保険該当なし)
		form.setHealthInsurRate(String.valueOf(tCompany.getHealthInsurRateNoNursing()));
		// 健康保険料率（介護保険該当者）
		form.setHealthInsurRate2(String.valueOf(tCompany.getHealthInsurRateWithNursing()));
		// 健康保険端数処理
		form.setHealthRounding(String.valueOf(tCompany.getHealthRounding()));
		// 厚生年金保険料率
		form.setWelfareInsurance(String.valueOf(tCompany.getWelfareInsuranceRate()));
		// 厚生年金端数処理
		form.setWelfareRounding(String.valueOf(tCompany.getWelfareRounding()));
		// 基金免除保険料率
		form.setWelfareExemptionRate(String.valueOf(tCompany.getWelfareExceptionRate()));
		// 基金独自給付加算率
		form.setWelfareAdditionRate(String.valueOf(tCompany.getWelfareAdditionRate()));
		// 基金独自給付加算定額
		form.setWelfareAdditionRation(String.valueOf(tCompany.getWelfareAdditionRation()));

		return "company/company_basic_info";
	}

	/**
	 * 編集ボタンを押下する
	 * 
	 * @param form
	 *            会社基本情報入力画面用form
	 * @param loginUser
	 *            登録ユーザ情報
	 * @return
	 */
	@RequestMapping(value = { "/update" }, method = RequestMethod.POST)
	public String update() {
		return "redirect:/companyUpdate";

	}

}
