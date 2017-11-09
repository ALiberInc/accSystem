package jp.co.aliber.accsystem.service.company;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.aliber.accsystem.entity.auto.TCompany;
import jp.co.aliber.accsystem.mapper.auto.TCompanyMapper;

/**
 * 会社基本情報サービスのテスター
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyBasicInfoServiceTest {

	@Autowired
	CompanyBasicInfoService companyBasicInfoService;
	@Autowired
	TCompanyMapper tCompanyMapper;

	/**
	 * 登録処理をテスト
	 *
	 */
	@Test
	public void testRegist() {

		// 会社基本情報を作成
		TCompany company = createCompanyData();
		// 会社基本情報を登録
		companyBasicInfoService.regist(company, 1);
		// 会社基本情報を取得
		TCompany compInfo = tCompanyMapper.selectByPrimaryKey(Integer.MAX_VALUE);
		// 登録した会社基本情報を削除
		tCompanyMapper.deleteByPrimaryKey(Integer.MAX_VALUE);
		// DBにある会社基本情報との比較
		assertEqualsAll(company, compInfo);
	}

	@Test
	public void testUpdate() {
		// 会社基本情報を作成
		TCompany company = createCompanyData();
		// 会社基本情報を登録
		companyBasicInfoService.regist(company, 1);

		// 会社情報を設定
		TCompany newCompany = new TCompany();
		// 会社ID
		newCompany.setCompId(Integer.MAX_VALUE);
		// 法人名
		newCompany.setCompName("（株）アリ");
		// 法人名フリガナ
		newCompany.setCompKana("アリ");
		// 郵便番号1
		newCompany.setCompZip1("13");
		// 郵便番号2
		newCompany.setCompZip2("122");
		// 住所1
		newCompany.setCompAdd1("港");
		// 住所2
		newCompany.setCompAdd2("芝1");
		// 住所1フリガナ
		newCompany.setCompAdd1Kana("ミナト");
		// 住所2フリガナ
		newCompany.setCompAdd2Kana("シバ1");
		// 電話番号1
		newCompany.setCompTel1("221");
		// 電話番号2
		newCompany.setCompTel2("2112");
		// 電話番号3
		newCompany.setCompTel3("2111");
		// 事業区分
		newCompany.setClassification(0);
		// 法人番号
		newCompany.setCorporationId("BL3456");
		// 事業主氏名
		newCompany.setCorpOwnerName("山 太郎");
		// 事業主氏名フリガナ
		newCompany.setCorpOwnerNameKana("ヤマ タロウ");
		// 事業所整理記号1
		newCompany.setCorpSortNo1("D1F");
		// 事業所整理記号2
		newCompany.setCorpSortNo2("F124");
		// 事業所番号
		newCompany.setCorpNo("FFD");
		// 事業種目
		newCompany.setCorpKind("IT");
		// 締め日
		newCompany.setDeadlineDay(false);
		// 締め日の末日以外日数
		newCompany.setDeadlineAdjustDays(22);
		// 支給日
		newCompany.setPaymentDay(false);
		// 支給日の末日以外日数
		newCompany.setPaymentAdjustDays(20);
		// 経理責任者
		newCompany.setAccountingManager("悟空");
		// 利用者識別番号
		newCompany.setUserRecognizeId("YUR");
		// 利用者ID
		newCompany.setUserId("UXXY");
		// 税理者
		newCompany.setTaxAccountant("三蔵");
		// 税理署
		newCompany.setTaxOffice("港税理署");
		// データ共有ID
		newCompany.setDataShareId("X888");
		// 会社コード
		newCompany.setCompCode("YCCDD");
		// 雇用保険被保険者負担率
		newCompany.setEmployInsurRate(new BigDecimal("3.10"));
		// 雇用保険被保険者負担率
		newCompany.setEmployRounding(0);
		// 健康保険料率(介護保険該当なし)
		newCompany.setHealthInsurRateNoNursing(new BigDecimal("4.33"));
		// 健康保険料率（介護保険該当者）
		newCompany.setHealthInsurRateWithNursing(new BigDecimal("8.33"));
		// 健康保険端数処理
		newCompany.setHealthRounding(0);
		// 厚生年金保険料率
		newCompany.setWelfareInsuranceRate(new BigDecimal("28.18"));
		// 厚生年金端数処理
		newCompany.setWelfareRounding(0);
		// 基金免除保険料率
		newCompany.setWelfareExceptionRate(new BigDecimal("4.01"));
		// 基金免除保険料率
		newCompany.setWelfareAdditionRate(new BigDecimal("4.01"));
		// 基金独自給付加算定額
		newCompany.setWelfareAdditionRation(879);
		// 削除フラグ
		newCompany.setDeleteFlg(false);

		Date sysdate = new Date();
		// 登録日時
		newCompany.setRegistDate(sysdate);
		// 更新日時
		newCompany.setUpdateDate(sysdate);
		// 登録ユーザID
		newCompany.setRegistId(1);
		// 更新ユーザID
		newCompany.setUpdateId(1);
		// 会社基本情報を更新
		companyBasicInfoService.update(newCompany, 2);

		// 会社基本情報を取得
		TCompany compInfo = tCompanyMapper.selectByPrimaryKey(Integer.MAX_VALUE);
		// 登録した会社基本情報を削除
		tCompanyMapper.deleteByPrimaryKey(Integer.MAX_VALUE);
		// DBにある会社基本情報との比較
		assertEqualsAll(newCompany, compInfo);
	}

	@Test
	public void testCheckIfCompNameExist() {
		// 会社基本情報を作成
		TCompany company = createCompanyData();
		// 会社基本情報を登録
		companyBasicInfoService.regist(company, 1);
		// 会社名が存在している
		assertTrue(companyBasicInfoService.checkIfCompNameExist("（株）アリベべ"));
		// 会社名が存在していない
		assertFalse(companyBasicInfoService.checkIfCompNameExist("（株）アリベ"));

		// 登録した会社基本情報を削除
		tCompanyMapper.deleteByPrimaryKey(Integer.MAX_VALUE);
	}

	@Test
	public void testSearchComp() {
		// 会社基本情報を作成
		TCompany company = createCompanyData();
		// 会社基本情報を登録
		companyBasicInfoService.regist(company, 1);
		// 会社基本情報を取得
		TCompany compInfo = companyBasicInfoService.searchComp(Integer.MAX_VALUE);
		// 登録した会社基本情報を削除
		tCompanyMapper.deleteByPrimaryKey(Integer.MAX_VALUE);
		// DBにある会社基本情報との比較
		assertEqualsAll(company, compInfo);
	}

	/**
	 * 会社基本情報を作成
	 *
	 */
	private TCompany createCompanyData() {
		// 会社情報を設定
		TCompany company = new TCompany();
		// 会社ID
		company.setCompId(Integer.MAX_VALUE);
		// 法人名
		company.setCompName("（株）アリベべ");
		// 法人名フリガナ
		company.setCompKana("アリベべ");
		// 郵便番号1
		company.setCompZip1("123");
		// 郵便番号2
		company.setCompZip2("1232");
		// 住所1
		company.setCompAdd1("港区");
		// 住所2
		company.setCompAdd2("芝");
		// 住所1フリガナ
		company.setCompAdd1Kana("ミナトク");
		// 住所2フリガナ
		company.setCompAdd2Kana("シバ");
		// 電話番号1
		company.setCompTel1("111");
		// 電話番号2
		company.setCompTel2("1112");
		// 電話番号3
		company.setCompTel3("9111");
		// 事業区分
		company.setClassification(1);
		// 法人番号
		company.setCorporationId("AL3456");
		// 事業主氏名
		company.setCorpOwnerName("山田 太郎");
		// 事業主氏名フリガナ
		company.setCorpOwnerNameKana("ヤマダ タロウ");
		// 事業所整理記号1
		company.setCorpSortNo1("DF");
		// 事業所整理記号2
		company.setCorpSortNo2("DF124");
		// 事業所番号
		company.setCorpNo("DFFD");
		// 事業種目
		company.setCorpKind("IT");
		// 締め日
		company.setDeadlineDay(false);
		// 締め日の末日以外日数
		company.setDeadlineAdjustDays(22);
		// 支給日
		company.setPaymentDay(false);
		// 支給日の末日以外日数
		company.setPaymentAdjustDays(20);
		// 経理責任者
		company.setAccountingManager("孫悟空");
		// 利用者識別番号
		company.setUserRecognizeId("YUTR");
		// 利用者ID
		company.setUserId("UXXYY");
		// 税理者
		company.setTaxAccountant("唐三蔵");
		// 税理署
		company.setTaxOffice("港区税理署");
		// データ共有ID
		company.setDataShareId("UX888");
		// 会社コード
		company.setCompCode("YYCCDD");
		// 雇用保険被保険者負担率
		company.setEmployInsurRate(new BigDecimal("3.00"));
		// 雇用保険被保険者負担率
		company.setEmployRounding(0);
		// 健康保険料率(介護保険該当なし)
		company.setHealthInsurRateNoNursing(new BigDecimal("3.33"));
		// 健康保険料率（介護保険該当者）
		company.setHealthInsurRateWithNursing(new BigDecimal("9.33"));
		// 健康保険端数処理
		company.setHealthRounding(0);
		// 厚生年金保険料率
		company.setWelfareInsuranceRate(new BigDecimal("18.18"));
		// 厚生年金端数処理
		company.setWelfareRounding(0);
		// 基金免除保険料率
		company.setWelfareExceptionRate(new BigDecimal("0.01"));
		// 基金免除保険料率
		company.setWelfareAdditionRate(new BigDecimal("9.01"));
		// 基金独自給付加算定額
		company.setWelfareAdditionRation(779);
		// 削除フラグ
		company.setDeleteFlg(false);

		Date sysdate = new Date();
		// 登録日時
		company.setRegistDate(sysdate);
		// 更新日時
		company.setUpdateDate(sysdate);
		// 登録ユーザID
		company.setRegistId(1);
		// 更新ユーザID
		company.setUpdateId(1);

		return company;
	}

	/**
	 * 会社基本情報を作成
	 *
	 */
	private void assertEqualsAll(TCompany expected, TCompany actual) {
		// 会社ID
		assertEquals(expected.getCompId(), actual.getCompId());
		// 法人名
		assertEquals(expected.getCompName(), actual.getCompName());
		// 法人名フリガナ
		assertEquals(expected.getCompKana(), actual.getCompKana());
		// 郵便番号1
		assertEquals(expected.getCompZip1(), actual.getCompZip1());
		// 郵便番号2
		assertEquals(expected.getCompZip2(), actual.getCompZip2());
		// 住所1
		assertEquals(expected.getCompAdd1(), actual.getCompAdd1());
		// 住所2
		assertEquals(expected.getCompAdd2(), actual.getCompAdd2());
		// 住所1フリガナ
		assertEquals(expected.getCompAdd1Kana(), actual.getCompAdd1Kana());
		// 住所2フリガナ
		assertEquals(expected.getCompAdd2Kana(), actual.getCompAdd2Kana());
		// 電話番号1
		assertEquals(expected.getCompTel1(), actual.getCompTel1());
		// 電話番号2
		assertEquals(expected.getCompTel2(), actual.getCompTel2());
		// 電話番号3
		assertEquals(expected.getCompTel3(), actual.getCompTel3());
		// 事業区分
		assertEquals(expected.getClassification(), actual.getClassification());
		// 法人番号
		assertEquals(expected.getCorporationId(), actual.getCorporationId());
		// 事業主氏名
		assertEquals(expected.getCorpOwnerName(), actual.getCorpOwnerName());
		// 事業主氏名フリガナ
		assertEquals(expected.getCorpOwnerNameKana(), actual.getCorpOwnerNameKana());
		// 事業所整理記号1
		assertEquals(expected.getCorpSortNo1(), actual.getCorpSortNo1());
		// 事業所整理記号2
		assertEquals(expected.getCorpSortNo2(), actual.getCorpSortNo2());
		// 事業所番号
		assertEquals(expected.getCorpNo(), actual.getCorpNo());
		// 事業種目
		assertEquals(expected.getCorpKind(), actual.getCorpKind());
		// 締め日
		assertEquals(expected.getDeadlineDay(), actual.getDeadlineDay());
		// 締め日の末日以外日数
		assertEquals(expected.getDeadlineAdjustDays(), actual.getDeadlineAdjustDays());
		// 支給日
		assertEquals(expected.getPaymentDay(), actual.getPaymentDay());
		// 支給日の末日以外日数
		assertEquals(expected.getPaymentAdjustDays(), actual.getPaymentAdjustDays());
		// 経理責任者
		assertEquals(expected.getAccountingManager(), actual.getAccountingManager());
		// 利用者識別番号
		assertEquals(expected.getUserRecognizeId(), actual.getUserRecognizeId());
		// 利用者ID
		assertEquals(expected.getUserId(), actual.getUserId());
		// 税理者
		assertEquals(expected.getTaxAccountant(), actual.getTaxAccountant());
		// 税理署
		assertEquals(expected.getTaxOffice(), actual.getTaxOffice());
		// データ共有ID
		assertEquals(expected.getDataShareId(), actual.getDataShareId());
		// 会社コード
		assertEquals(expected.getCompCode(), actual.getCompCode());
		// 雇用保険被保険者負担率
		assertEquals(expected.getEmployInsurRate(), actual.getEmployInsurRate());
		// 雇用保険被保険者負担率
		assertEquals(expected.getEmployRounding(), actual.getEmployRounding());
		// 健康保険料率(介護保険該当なし)
		assertEquals(expected.getHealthInsurRateNoNursing(), actual.getHealthInsurRateNoNursing());
		// 健康保険料率（介護保険該当者）
		assertEquals(expected.getHealthInsurRateWithNursing(), actual.getHealthInsurRateWithNursing());
		// 健康保険端数処理
		assertEquals(expected.getHealthRounding(), actual.getHealthRounding());
		// 厚生年金保険料率
		assertEquals(expected.getWelfareInsuranceRate(), actual.getWelfareInsuranceRate());
		// 厚生年金端数処理
		assertEquals(expected.getWelfareRounding(), actual.getWelfareRounding());
		// 基金免除保険料率
		assertEquals(expected.getWelfareExceptionRate(), actual.getWelfareExceptionRate());
		// 基金免除保険料率
		assertEquals(expected.getWelfareAdditionRate(), actual.getWelfareAdditionRate());
		// 基金独自給付加算定額
		assertEquals(expected.getWelfareAdditionRation(), actual.getWelfareAdditionRation());
		// 削除フラグ
		assertEquals(expected.getDeleteFlg(), actual.getDeleteFlg());
		// 登録日時
		assertEquals(expected.getRegistDate(), actual.getRegistDate());
		// 更新日時
		assertEquals(expected.getUpdateDate(), actual.getUpdateDate());
		// 登録ユーザID
		assertEquals(expected.getRegistId(), actual.getRegistId());
		// 更新ユーザID
		assertEquals(expected.getUpdateId(), actual.getUpdateId());
	}

}
