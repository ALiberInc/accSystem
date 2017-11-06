package jp.co.aliber.accsystem;

public class ImmutableValues {

	public static final Integer FLG_ON = 1;

	public static final Integer FLG_OFF = 0;

	// 7人を超える１人ごとに1,610円を控除した金額
	public static final int EXTRA_DEC_PER_PERSON = 1610;

	// デフォルトユーザID
	public static final Integer DEFAULT_USER_ID = 9999;

	// jasperファイルのパス
	public static final String JASPER_PATH = "Blank_A4_Landscape.jasper";

	// 会社基本情報画面
	// 被保険者負担率
	public static final String EMPLOY_INSURANCE_RATE = "3";
	// 端数処理:50捨51入
	public static final String ROUNDING_HALF_UP = "4";
	// 端数処理:切り捨て
	public static final String ROUNDING_UP = "1";
	// 端数処理:切り上げ
	public static final String ROUNDING_DOWN = "0";
	// 保険料率（介護保険該当なし）
	public static final String HEALTH_INSUTANCE_RATE = "9.91";
	// 保険料率（介護保険該当者）
	public static final String HEALTH_INSURANCE_RATE_2 = "11.56";
	// 保険料率
	public static final String WELFARE_INSURANCE_RATE = "18.182";
	// 基金免除保険料率
	public static final String WELFARE_EXEMPTION_RATE = "0.00";
	// 基金独自給付加算率(従業員負担分)
	public static final String WELFARE_ADDITION_RATE = "0.00";
	// 締め日/支給日が末日の場合
	public static final String LAST_DAY = "0";

	// メッセージ画面
	// 処理完了
	public static final String MESSAGE_FINISH = "処理が完了しました。";
	// 会社情報未登録
	public static final String MESSAGE_INSERT_COMPANY = "会社情報がまだ登録していませんので、利用できません。先に会社情報を登録してください。";
	// 遷移先：会社情報画面
	public static final String FORWARD_COMPANY = "company";
}
