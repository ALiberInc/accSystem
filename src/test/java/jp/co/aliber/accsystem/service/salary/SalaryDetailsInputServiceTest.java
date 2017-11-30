package jp.co.aliber.accsystem.service.salary;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.aliber.accsystem.entity.auto.TCompany;
import jp.co.aliber.accsystem.mapper.auto.TCompanyMapper;
import jp.co.aliber.accsystem.service.company.CompanyBasicInfoService;

/**
 * 給与明細入力サービスのテスター
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SalaryDetailsInputServiceTest {

	@Autowired
	CompanyBasicInfoService companyBasicInfoService;
	@Autowired
	TCompanyMapper tCompanyMapper;
	@Autowired
	SalaryDetailsInputService salaryDetailsInputService;

	/**
	 * 健康保険、厚生年金、雇用保険、社会保険合計を取得する処理をテスト
	 *
	 */
	@Test
	public void testInsuranceCalculator() {

		TCompany company = createCompanyData();
		// 会社基本情報を登録
		companyBasicInfoService.regist(company, 1);
		// 健康保険、厚生年金、雇用保険、社会保険合計を取得する
		Map<String, Integer> testResult = salaryDetailsInputService.insuranceCalculator(75000, Integer.MAX_VALUE);
		// 登録した会社基本情報を削除
		tCompanyMapper.deleteByPrimaryKey(Integer.MAX_VALUE);
		// 健康保険
		assertEquals(3865, testResult.get("healthInsurance").intValue());
		// 厚生年金
		assertEquals(7090, testResult.get("welfarePension").intValue());
		// 雇用保険
		assertEquals(112, testResult.get("employmentInsurance").intValue());
		// 社会保険合計
		assertEquals(11067, testResult.get("socialInsuranceSum").intValue());

	}

	/**
	 * 所得税税額を取得する処理をテスト
	 *
	 */
	@Test
	public void testIncomeTaxCalculator() {

		assertEquals(14550, salaryDetailsInputService.incomeTaxCalculator(376000, 1000, 0).intValue());
		assertEquals(11310, salaryDetailsInputService.incomeTaxCalculator(376000, 1000, 1).intValue());
		assertEquals(8190, salaryDetailsInputService.incomeTaxCalculator(376000, 1000, 2).intValue());
		assertEquals(6580, salaryDetailsInputService.incomeTaxCalculator(376000, 1000, 3).intValue());
		assertEquals(4950, salaryDetailsInputService.incomeTaxCalculator(376000, 1000, 4).intValue());
		assertEquals(3340, salaryDetailsInputService.incomeTaxCalculator(376000, 1000, 5).intValue());
		assertEquals(1730, salaryDetailsInputService.incomeTaxCalculator(376000, 1000, 6).intValue());
		assertEquals(100, salaryDetailsInputService.incomeTaxCalculator(376000, 1000, 7).intValue());
		assertEquals(0, salaryDetailsInputService.incomeTaxCalculator(376000, 1000, 8).intValue());
		assertEquals(570, salaryDetailsInputService.incomeTaxCalculator(426000, 1000, 8).intValue());
	}

	private TCompany createCompanyData() {
		// 会社情報を設定
		TCompany company = new TCompany();
		// 会社ID
		company.setCompId(Integer.MAX_VALUE);
		// 法人名
		company.setCompName("森陽");
		// 法人名フリガナ
		company.setCompKana("モリヨウ");
		// 郵便番号1
		company.setCompZip1("454");
		// 郵便番号2
		company.setCompZip2("5894");
		// 住所1
		company.setCompAdd1("名古屋");
		// 住所2
		company.setCompAdd2("横浜");
		// 住所1フリガナ
		company.setCompAdd1Kana("ナゴヤ");
		// 住所2フリガナ
		company.setCompAdd2Kana("ヨコハマ");
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
		company.setCompCode("4546");
		// 雇用保険被保険者負担率
		company.setEmployInsurRate(new BigDecimal("3.00"));
		// 雇用保険被保険者負担率
		company.setEmployRounding(0);
		// 健康保険料率(介護保険該当なし)
		company.setHealthInsurRateNoNursing(new BigDecimal("9.91"));
		// 健康保険料率（介護保険該当者）
		company.setHealthInsurRateWithNursing(new BigDecimal("11.56"));
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

}
