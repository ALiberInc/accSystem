package jp.co.aliber.accsystem.entity;

public class SelectNameDeptNameParameter {

    /**
     * lastName
     */
    private String lastName;

    /**
     * firstName
     */
    private String firstName;

    /**
     * 従業員NO
     */
    private Integer employeeNo;

    /**
     * 所属名
     */
    private String deptName;

    /**
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName セットする lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName セットする firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return employeeNo
     */
    public Integer getEmployeeNo() {
        return employeeNo;
    }

    /**
     * @param employeeNo セットする employeeNo
     */
    public void setEmployeeNo(Integer employeeNo) {
        this.employeeNo = employeeNo;
    }

    /**
     * @return deptName
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * @param deptName セットする deptName
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }



}
