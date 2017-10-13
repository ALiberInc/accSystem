package jp.co.aliber.accsystem.form.company;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * 会社基本情報画面form
 *
 * @author yu_k
 *
 */
public class CompanyBasicInfoForm implements Serializable {
    private static final long serialVersionUID = 1L;
    // 法人名
    @NotNull
	//@Size(max = 256)
    private String compName;
    // 法人名フリガナ
    @NotNull
	//@Size(max = 256)
    private String compKana;
    // 郵便番号
    @NotNull
    ////@Pattern(regexp = "[0-9]{3}")
    private String compZip1;
    // 郵便番号
    @NotNull
    ////@Pattern(regexp = "[0-9]{4}")
    private String compZip2;
    // 住所1
    @NotNull
   	//@Size(max = 256)
    private String compAdd1;
    // 住所2
   	//@Size(max = 256)
    private String compAdd2;
    // 住所1フリガナ
    @NotNull
   	//@Size(max = 256)
    private String compAdd1Kana;
    // 住所2フリガナ
   	//@Size(max = 256)
    private String compAdd2Kana;
    // 電話番号
    @NotNull
    //@Pattern(regexp = "[0-9]{2,3}")
    private String compTel1;
    // 電話番号
    @NotNull
    //@Pattern(regexp = "[0-9]{4}")
    private String compTel2;
    // 電話番号
    @NotNull
    //@Pattern(regexp = "[0-9]{3}")
    private String compTel3;
    // 事業区分
    @NotNull
    //@Pattern(regexp = "[0-9]*")
    private String classification;
    // 法人番号
    @NotNull
    //@Pattern(regexp = "[0-9]*")
    private String corporationId;
    // 事業主氏名
    @NotNull
   	//@Size(max = 100)
    private String corpOwnerName;
    // 事業主氏名フリガナ
    @NotNull
   	//@Size(max = 100)
    //@Pattern(regexp = "[ァ-ヶー]*")
    private String corpOwnerNameKana;
    // 事業所整理記号
    @NotNull
   	//@Size(max = 25)
    private String corpSortNo1;
    // 事業所整理記号
    @NotNull
   	//@Size(max = 25)
    private String corpSortNo2;
    // 事業所番号
    @NotNull
    //@Pattern(regexp = "[0-9]*")
    private String corpNo;
    // 事業種目
    @NotNull
   	//@Size(max = 100)
    private String corpKind;
    // 締め日が末日
    @NotNull
    private String deadlineDay;
    // 締め日の末日以外日数
    //@Pattern(regexp = "[0-9]*")
    private String deadlineAdjustDays;
    // 支給日が末日
    @NotNull
    private String paymentDay;
    // 支給日の末日以外日数
    //@Pattern(regexp = "[0-9]*")
    private String paymentAdjustDays;
    // 経理責任者
    @NotNull
   	//@Size(max = 100)
    private String accountingManager;
    // 利用者識別番号
    //@Pattern(regexp = "[0-9]*")
    private String userRecongId;
    // 利用者ID
    //@Pattern(regexp = "[0-9]*")
    private String userId;
    // 税理者
    @NotNull
   	//@Size(max = 100)
    private String taxAccountant;
    // 税理署
    @NotNull
 	//@Size(max = 256)
    private String taxOffice;
    // データ共有ID
    @NotNull
    //@Pattern(regexp = "[0-9]*")
    private String dataShareId;
    // マイナンバーマスタから個人番号を取得する
    @NotNull
    private Boolean myNumber;
    // 会社コード
    @NotNull
    //@Pattern(regexp = "[0-9]*")
    private String compCode;
    // 雇用保険被保険者負担率
    @NotNull
   	//@Size(max = 5)
    private String employInsurRate;
    // 雇用保険被保険者負担率
    @NotNull
    private String employRounding;
    // 健康保険料率(介護保険該当なし)
    @NotNull
    //@Size(max = 5)
    private String healthInsurRate;
    // 健康保険料率（介護保険該当者）
    @NotNull
    //@Size(max = 5)
    private String healthInsurRate2;
    // 健康保険端数処理
    @NotNull
    private String healthRounding;
    // 厚生年金保険料率
    @NotNull
    //@Size(max = 5)
    private String welfareInsurance;
    // 厚生年金端数処理
    @NotNull
    private String welfareRounding;
    // 基金免除保険料率
    @NotNull
    //@Size(max = 5)
    private String welfareExemptionRate;
    // 基金免除保険料率
    @NotNull
    //@Size(max = 5)
    private String welfareAdditionRate;
    // 基金独自給付加算定額
    @NotNull
    ////@Pattern(regexp = "[0-9]*")
    private String welfareAdditionRation;
	/**
	 * @return compName
	 */
	public String getCompName() {
		return compName;
	}
	/**
	 * @param compName セットする compName
	 */
	public void setCompName(String compName) {
		this.compName = compName;
	}
	/**
	 * @return compKana
	 */
	public String getCompKana() {
		return compKana;
	}
	/**
	 * @param compKana セットする compKana
	 */
	public void setCompKana(String compKana) {
		this.compKana = compKana;
	}
	/**
	 * @return compZip1
	 */
	public String getCompZip1() {
		return compZip1;
	}
	/**
	 * @param compZip1 セットする compZip1
	 */
	public void setCompZip1(String compZip1) {
		this.compZip1 = compZip1;
	}
	/**
	 * @return compZip2
	 */
	public String getCompZip2() {
		return compZip2;
	}
	/**
	 * @param compZip2 セットする compZip2
	 */
	public void setCompZip2(String compZip2) {
		this.compZip2 = compZip2;
	}
	/**
	 * @return compAdd1
	 */
	public String getCompAdd1() {
		return compAdd1;
	}
	/**
	 * @param compAdd1 セットする compAdd1
	 */
	public void setCompAdd1(String compAdd1) {
		this.compAdd1 = compAdd1;
	}
	/**
	 * @return compAdd2
	 */
	public String getCompAdd2() {
		return compAdd2;
	}
	/**
	 * @param compAdd2 セットする compAdd2
	 */
	public void setCompAdd2(String compAdd2) {
		this.compAdd2 = compAdd2;
	}
	/**
	 * @return compAdd1Kana
	 */
	public String getCompAdd1Kana() {
		return compAdd1Kana;
	}
	/**
	 * @param compAdd1Kana セットする compAdd1Kana
	 */
	public void setCompAdd1Kana(String compAdd1Kana) {
		this.compAdd1Kana = compAdd1Kana;
	}
	/**
	 * @return compAdd2Kana
	 */
	public String getCompAdd2Kana() {
		return compAdd2Kana;
	}
	/**
	 * @param compAdd2Kana セットする compAdd2Kana
	 */
	public void setCompAdd2Kana(String compAdd2Kana) {
		this.compAdd2Kana = compAdd2Kana;
	}
	/**
	 * @return compTel1
	 */
	public String getCompTel1() {
		return compTel1;
	}
	/**
	 * @param compTel1 セットする compTel1
	 */
	public void setCompTel1(String compTel1) {
		this.compTel1 = compTel1;
	}
	/**
	 * @return compTel2
	 */
	public String getCompTel2() {
		return compTel2;
	}
	/**
	 * @param compTel2 セットする compTel2
	 */
	public void setCompTel2(String compTel2) {
		this.compTel2 = compTel2;
	}
	/**
	 * @return compTel3
	 */
	public String getCompTel3() {
		return compTel3;
	}
	/**
	 * @param compTel3 セットする compTel3
	 */
	public void setCompTel3(String compTel3) {
		this.compTel3 = compTel3;
	}
	/**
	 * @return classification
	 */
	public String getClassification() {
		return classification;
	}
	/**
	 * @param classification セットする classification
	 */
	public void setClassification(String classification) {
		this.classification = classification;
	}
	/**
	 * @return corporationId
	 */
	public String getCorporationId() {
		return corporationId;
	}
	/**
	 * @param corporationId セットする corporationId
	 */
	public void setCorporationId(String corporationId) {
		this.corporationId = corporationId;
	}
	/**
	 * @return corpOwnerName
	 */
	public String getCorpOwnerName() {
		return corpOwnerName;
	}
	/**
	 * @param corpOwnerName セットする corpOwnerName
	 */
	public void setCorpOwnerName(String corpOwnerName) {
		this.corpOwnerName = corpOwnerName;
	}
	/**
	 * @return corpOwnerNameKana
	 */
	public String getCorpOwnerNameKana() {
		return corpOwnerNameKana;
	}
	/**
	 * @param corpOwnerNameKana セットする corpOwnerNameKana
	 */
	public void setCorpOwnerNameKana(String corpOwnerNameKana) {
		this.corpOwnerNameKana = corpOwnerNameKana;
	}
	/**
	 * @return corpSortNo1
	 */
	public String getCorpSortNo1() {
		return corpSortNo1;
	}
	/**
	 * @param corpSortNo1 セットする corpSortNo1
	 */
	public void setCorpSortNo1(String corpSortNo1) {
		this.corpSortNo1 = corpSortNo1;
	}
	/**
	 * @return corpSortNo2
	 */
	public String getCorpSortNo2() {
		return corpSortNo2;
	}
	/**
	 * @param corpSortNo2 セットする corpSortNo2
	 */
	public void setCorpSortNo2(String corpSortNo2) {
		this.corpSortNo2 = corpSortNo2;
	}
	/**
	 * @return corpNo
	 */
	public String getCorpNo() {
		return corpNo;
	}
	/**
	 * @param corpNo セットする corpNo
	 */
	public void setCorpNo(String corpNo) {
		this.corpNo = corpNo;
	}
	/**
	 * @return corpKind
	 */
	public String getCorpKind() {
		return corpKind;
	}
	/**
	 * @param corpKind セットする corpKind
	 */
	public void setCorpKind(String corpKind) {
		this.corpKind = corpKind;
	}
	/**
	 * @return deadlineDay
	 */
	public String getDeadlineDay() {
		return deadlineDay;
	}
	/**
	 * @param deadlineDay セットする deadlineDay
	 */
	public void setDeadlineDay(String deadlineDay) {
		this.deadlineDay = deadlineDay;
	}
	/**
	 * @return deadlineAdjustDays
	 */
	public String getDeadlineAdjustDays() {
		return deadlineAdjustDays;
	}
	/**
	 * @param deadlineAdjustDays セットする deadlineAdjustDays
	 */
	public void setDeadlineAdjustDays(String deadlineAdjustDays) {
		this.deadlineAdjustDays = deadlineAdjustDays;
	}
	/**
	 * @return paymentDay
	 */
	public String getPaymentDay() {
		return paymentDay;
	}
	/**
	 * @param paymentDay セットする paymentDay
	 */
	public void setPaymentDay(String paymentDay) {
		this.paymentDay = paymentDay;
	}
	/**
	 * @return paymentAdjustDays
	 */
	public String getPaymentAdjustDays() {
		return paymentAdjustDays;
	}
	/**
	 * @param paymentAdjustDays セットする paymentAdjustDays
	 */
	public void setPaymentAdjustDays(String paymentAdjustDays) {
		this.paymentAdjustDays = paymentAdjustDays;
	}
	/**
	 * @return accountingManager
	 */
	public String getAccountingManager() {
		return accountingManager;
	}
	/**
	 * @param accountingManager セットする accountingManager
	 */
	public void setAccountingManager(String accountingManager) {
		this.accountingManager = accountingManager;
	}
	/**
	 * @return userRecongId
	 */
	public String getUserRecongId() {
		return userRecongId;
	}
	/**
	 * @param userRecongId セットする userRecongId
	 */
	public void setUserRecongId(String userRecongId) {
		this.userRecongId = userRecongId;
	}
	/**
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId セットする userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return taxAccountant
	 */
	public String getTaxAccountant() {
		return taxAccountant;
	}
	/**
	 * @param taxAccountant セットする taxAccountant
	 */
	public void setTaxAccountant(String taxAccountant) {
		this.taxAccountant = taxAccountant;
	}
	/**
	 * @return taxOffice
	 */
	public String getTaxOffice() {
		return taxOffice;
	}
	/**
	 * @param taxOffice セットする taxOffice
	 */
	public void setTaxOffice(String taxOffice) {
		this.taxOffice = taxOffice;
	}
	/**
	 * @return dataShareId
	 */
	public String getDataShareId() {
		return dataShareId;
	}
	/**
	 * @param dataShareId セットする dataShareId
	 */
	public void setDataShareId(String dataShareId) {
		this.dataShareId = dataShareId;
	}
	/**
	 * @return myNumber
	 */
	public Boolean getMyNumber() {
		return myNumber;
	}
	/**
	 * @param myNumber セットする myNumber
	 */
	public void setMyNumber(Boolean myNumber) {
		this.myNumber = myNumber;
	}
	/**
	 * @return compCode
	 */
	public String getCompCode() {
		return compCode;
	}
	/**
	 * @param compCode セットする compCode
	 */
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}
	/**
	 * @return employInsurRate
	 */
	public String getEmployInsurRate() {
		return employInsurRate;
	}
	/**
	 * @param employInsurRate セットする employInsurRate
	 */
	public void setEmployInsurRate(String employInsurRate) {
		this.employInsurRate = employInsurRate;
	}
	/**
	 * @return employRounding
	 */
	public String getEmployRounding() {
		return employRounding;
	}
	/**
	 * @param employRounding セットする employRounding
	 */
	public void setEmployRounding(String employRounding) {
		this.employRounding = employRounding;
	}
	/**
	 * @return healthInsurRate
	 */
	public String getHealthInsurRate() {
		return healthInsurRate;
	}
	/**
	 * @param healthInsurRate セットする healthInsurRate
	 */
	public void setHealthInsurRate(String healthInsurRate) {
		this.healthInsurRate = healthInsurRate;
	}
	/**
	 * @return healthInsurRate2
	 */
	public String getHealthInsurRate2() {
		return healthInsurRate2;
	}
	/**
	 * @param healthInsurRate2 セットする healthInsurRate2
	 */
	public void setHealthInsurRate2(String healthInsurRate2) {
		this.healthInsurRate2 = healthInsurRate2;
	}
	/**
	 * @return healthRounding
	 */
	public String getHealthRounding() {
		return healthRounding;
	}
	/**
	 * @param healthRounding セットする healthRounding
	 */
	public void setHealthRounding(String healthRounding) {
		this.healthRounding = healthRounding;
	}
	/**
	 * @return welfareInsurance
	 */
	public String getWelfareInsurance() {
		return welfareInsurance;
	}
	/**
	 * @param welfareInsurance セットする welfareInsurance
	 */
	public void setWelfareInsurance(String welfareInsurance) {
		this.welfareInsurance = welfareInsurance;
	}
	/**
	 * @return welfareRounding
	 */
	public String getWelfareRounding() {
		return welfareRounding;
	}
	/**
	 * @param welfareRounding セットする welfareRounding
	 */
	public void setWelfareRounding(String welfareRounding) {
		this.welfareRounding = welfareRounding;
	}
	/**
	 * @return welfareExemptionRate
	 */
	public String getWelfareExemptionRate() {
		return welfareExemptionRate;
	}
	/**
	 * @param welfareExemptionRate セットする welfareExemptionRate
	 */
	public void setWelfareExemptionRate(String welfareExemptionRate) {
		this.welfareExemptionRate = welfareExemptionRate;
	}
	/**
	 * @return welfareAdditionRate
	 */
	public String getWelfareAdditionRate() {
		return welfareAdditionRate;
	}
	/**
	 * @param welfareAdditionRate セットする welfareAdditionRate
	 */
	public void setWelfareAdditionRate(String welfareAdditionRate) {
		this.welfareAdditionRate = welfareAdditionRate;
	}
	/**
	 * @return welfareAdditionRation
	 */
	public String getWelfareAdditionRation() {
		return welfareAdditionRation;
	}
	/**
	 * @param welfareAdditionRation セットする welfareAdditionRation
	 */
	public void setWelfareAdditionRation(String welfareAdditionRation) {
		this.welfareAdditionRation = welfareAdditionRation;
	}
}
