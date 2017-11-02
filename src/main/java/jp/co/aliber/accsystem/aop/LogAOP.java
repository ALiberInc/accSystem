package jp.co.aliber.accsystem.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * SpringAOPでログファイルにメソッドの開始終了ログを出力、および操作履歴テーブルにログを出力するクラス.<br>
 *
 */
@Aspect
@Component
public class LogAOP {

	private final Logger logger;

	public LogAOP() {
		this.logger = LoggerFactory.getLogger(this.getClass());
	}

	@Pointcut("execution(* jp.co.aliber.accsystem.controller..*(..))")
	public void invokeMethod() {
	}// Empty body suffices

	/**
	 * メソッド開始ログ
	 *
	 * @param joinPoint
	 */
	@Before("invokeMethod()")
	public void invokeBefore(JoinPoint joinPoint) {
		// 開始ログを出力
		methodLog(joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName(), "start");
	}

	/**
	 * メソッド終了ログ
	 *
	 * @param joinPoint
	 */
	@After("invokeMethod()")
	public void invokeAfter(JoinPoint joinPoint) {
		// 終了ログを出力
		methodLog(joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName(), "end");
	}

	/**
	 * ログ出力.<br>
	 * メソッドの開始、終了ログを出力する。出力するログの形式は以下の通り。<br>
	 * 「クラス名.メソッド名() (start|end)」<br>
	 *
	 * @param className
	 * @param methodName
	 * @param message
	 */
	private void methodLog(String className, String methodName, String message) {
		// ログ出力文言作成
		StringBuilder sb = new StringBuilder();
		sb.append(className);
		sb.append(".");
		sb.append(methodName);
		sb.append("() ");
		sb.append(message);
		sb.append(".");

		logger.info(sb.toString());
	}
}