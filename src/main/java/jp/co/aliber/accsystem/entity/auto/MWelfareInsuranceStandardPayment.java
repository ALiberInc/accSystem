package jp.co.aliber.accsystem.entity.auto;

public class MWelfareInsuranceStandardPayment {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.m_welfare_insurance_standard_payment.payment_start
     *
     * @mbg.generated
     */
    private Long paymentStart;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.m_welfare_insurance_standard_payment.payment_end
     *
     * @mbg.generated
     */
    private Long paymentEnd;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.m_welfare_insurance_standard_payment.standard_payment
     *
     * @mbg.generated
     */
    private Long standardPayment;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.m_welfare_insurance_standard_payment.payment_start
     *
     * @return the value of public.m_welfare_insurance_standard_payment.payment_start
     *
     * @mbg.generated
     */
    public Long getPaymentStart() {
        return paymentStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.m_welfare_insurance_standard_payment.payment_start
     *
     * @param paymentStart the value for public.m_welfare_insurance_standard_payment.payment_start
     *
     * @mbg.generated
     */
    public void setPaymentStart(Long paymentStart) {
        this.paymentStart = paymentStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.m_welfare_insurance_standard_payment.payment_end
     *
     * @return the value of public.m_welfare_insurance_standard_payment.payment_end
     *
     * @mbg.generated
     */
    public Long getPaymentEnd() {
        return paymentEnd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.m_welfare_insurance_standard_payment.payment_end
     *
     * @param paymentEnd the value for public.m_welfare_insurance_standard_payment.payment_end
     *
     * @mbg.generated
     */
    public void setPaymentEnd(Long paymentEnd) {
        this.paymentEnd = paymentEnd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.m_welfare_insurance_standard_payment.standard_payment
     *
     * @return the value of public.m_welfare_insurance_standard_payment.standard_payment
     *
     * @mbg.generated
     */
    public Long getStandardPayment() {
        return standardPayment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.m_welfare_insurance_standard_payment.standard_payment
     *
     * @param standardPayment the value for public.m_welfare_insurance_standard_payment.standard_payment
     *
     * @mbg.generated
     */
    public void setStandardPayment(Long standardPayment) {
        this.standardPayment = standardPayment;
    }
}