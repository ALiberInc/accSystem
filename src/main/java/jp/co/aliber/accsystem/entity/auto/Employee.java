package jp.co.aliber.accsystem.entity.auto;

public class Employee {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.employee.employee_id
     *
     * @mbg.generated
     */
    private Long employeeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.employee.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.employee.fuligana
     *
     * @mbg.generated
     */
    private String fuligana;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.employee.sex
     *
     * @mbg.generated
     */
    private String sex;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.employee.employee_id
     *
     * @return the value of public.employee.employee_id
     *
     * @mbg.generated
     */
    public Long getEmployeeId() {
        return employeeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.employee.employee_id
     *
     * @param employeeId the value for public.employee.employee_id
     *
     * @mbg.generated
     */
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.employee.name
     *
     * @return the value of public.employee.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.employee.name
     *
     * @param name the value for public.employee.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.employee.fuligana
     *
     * @return the value of public.employee.fuligana
     *
     * @mbg.generated
     */
    public String getFuligana() {
        return fuligana;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.employee.fuligana
     *
     * @param fuligana the value for public.employee.fuligana
     *
     * @mbg.generated
     */
    public void setFuligana(String fuligana) {
        this.fuligana = fuligana;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.employee.sex
     *
     * @return the value of public.employee.sex
     *
     * @mbg.generated
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.employee.sex
     *
     * @param sex the value for public.employee.sex
     *
     * @mbg.generated
     */
    public void setSex(String sex) {
        this.sex = sex;
    }
}