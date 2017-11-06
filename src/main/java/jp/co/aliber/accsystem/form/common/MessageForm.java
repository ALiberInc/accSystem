package jp.co.aliber.accsystem.form.common;

import org.hibernate.validator.constraints.NotBlank;

/**
 * メッセージ画面form
 *
 *
 */
public class MessageForm {
	// メッセージ
	@NotBlank
	private String message;
	// 遷移先
	@NotBlank
	private String forwardURL;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getForwardURL() {
		return forwardURL;
	}

	public void setForwardURL(String forwardURL) {
		this.forwardURL = forwardURL;
	}
}
