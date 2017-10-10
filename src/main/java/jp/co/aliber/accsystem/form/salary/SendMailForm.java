package jp.co.aliber.accsystem.form.salary;

public class SendMailForm {

    /**
     *メールアドレス
     */
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
