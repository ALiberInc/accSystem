package jp.co.aliber.accsystem.form.salary;

import java.util.List;

import jp.co.aliber.accsystem.entity.auto.TEmployee;

public class SalaryStatementFrom {

    private List<TEmployee> listTEmployee;

    /**
     * @return listTEmployee
     */
    public List<TEmployee> getListTEmployee() {
        return listTEmployee;
    }

    /**
     * @param listTEmployee セットする listTEmployee
     */
    public void setListTEmployee(List<TEmployee> listTEmployee) {
        this.listTEmployee = listTEmployee;
    }


}
