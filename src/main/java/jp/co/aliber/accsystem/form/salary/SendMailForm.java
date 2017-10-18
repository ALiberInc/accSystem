package jp.co.aliber.accsystem.form.salary;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class SendMailForm {

    /**
     *メールアドレス
     */
	@NotBlank
	@Size(max = 100)
	@Email
	@Pattern(regexp = "^[a-zA-Z0-9_./?+\\-]+[a-zA-Z0-9_./?+\\-@]+$")
    private String sendMailStr;


    /**
     *作成方法
     */
    private int bodyType;

    /**
     * @return sendMailStr
     */
    public String getSendMailStr() {
        return sendMailStr;
    }

    /**
     * @param sendMailStr セットする sendMailStr
     */
    public void setSendMailStr(String sendMailStr) {
        this.sendMailStr = sendMailStr;
    }

    /**
     * @return bodyType
     */
    public int getBodyType() {
        return bodyType;
    }

    /**
     * @param bodyType セットする bodyType
     */
    public void setBodyType(int bodyType) {
        this.bodyType = bodyType;
    }
}
