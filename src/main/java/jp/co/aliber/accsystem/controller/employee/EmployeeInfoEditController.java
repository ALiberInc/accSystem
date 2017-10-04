package jp.co.aliber.accsystem.controller.employee;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.aliber.accsystem.ImmutableValues;
import jp.co.aliber.accsystem.entity.auto.TCompanyDepartment;
import jp.co.aliber.accsystem.entity.auto.TEmployee;
import jp.co.aliber.accsystem.entity.auto.TEmployeeBankAccount;
import jp.co.aliber.accsystem.entity.auto.TEmployeeFixedDeduction;
import jp.co.aliber.accsystem.entity.auto.TEmployeeFixedPayment;
import jp.co.aliber.accsystem.entity.auto.TEmployeeIncomeTax;
import jp.co.aliber.accsystem.form.employee.EmployeeInfoEditForm;
import jp.co.aliber.accsystem.service.UtilService;
import jp.co.aliber.accsystem.service.company.TCompanyDepartmentService;
import jp.co.aliber.accsystem.service.employee.TEmployeeBankAccountService;
import jp.co.aliber.accsystem.service.employee.TEmployeeFixedDeductionService;
import jp.co.aliber.accsystem.service.employee.TEmployeeFixedPaymentService;
import jp.co.aliber.accsystem.service.employee.TEmployeeIncomeTaxService;
import jp.co.aliber.accsystem.service.employee.TEmployeeService;

/**
 * 従業員データ入力画面
 *
 * @author son_k
 *
 */
@Controller
@RequestMapping("/employee_info_edit")
public class EmployeeInfoEditController {

    /**
     * 從業員情報サービス
     */
    @Autowired
    private TEmployeeService tEmployeeService;

    /**
     * 從業員口座情報サービス
     */
    @Autowired
    private TEmployeeBankAccountService tEmployeeBankAccountService;

    /**
     * 固定控除金額情報サービス
     */
    @Autowired
    private TEmployeeFixedDeductionService tEmployeeFixedDeductionService;

    /**
     * 固定支給金額情報サービス
     */
    @Autowired
    private TEmployeeFixedPaymentService tEmployeeFixedPaymentService;

    /**
     * 所得税情報サービス
     */
    @Autowired
    private TEmployeeIncomeTaxService tEmployeeIncomeTaxService;

    /**
     * 会社部署情報サービス
     */
    @Autowired
    private TCompanyDepartmentService tCompanyDepartmentService;

    /**
     * utilサービス
     */
    @Autowired
    private UtilService utilService;

    /**
     * データのバンディング
     *
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    /**
     * 従業員データ入力画面
     *
     * @param locale
     *            ロケール
     * @param model
     *            モデル
     * @param form
     *            従業員データ入力画面Form
     * @param emplyeeId
     *            従業員ID
     * @return 従業員データ入力画面
     */
    @RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
    public String index(Locale locale, Model model, EmployeeInfoEditForm form,
            @RequestParam(value = "emplyeeId", required = false) String emplyeeId) {
        if (emplyeeId == null) {
            // 登録の場合
            form.setCreationflag(false);
            return "_employee/employee_info_edit";
        }
        // 更新の場合
        form.setCreationflag(true);
        Integer emplyeeIdL = Integer.valueOf(emplyeeId);
        // 從業員番号
        form.setEmployeeId(emplyeeIdL);
        // 部署リスト
        List<TCompanyDepartment> listTCompanyDepartmen = tCompanyDepartmentService.getListTCompanyDepartmen(1);
        form.setDepartmentList(listTCompanyDepartmen);

        // 從業員情報
        TEmployee employee = tEmployeeService.getTEmployee(emplyeeIdL, 1);
        if (employee != null) {
            form.setEmployeeNo(employee.getEmployeeNo());
            form.setFirstName(employee.getFirstName());
            form.setLastName(employee.getLastName());
            form.setDepartment(employee.getDeptId());
            form.setLastNameKana(employee.getLastNameKana());
            form.setFirstNameKana(employee.getFirstNameKana());
            form.setSex(employee.getSex() ? 0 : 1);
        }
        // 口座情報
        TEmployeeBankAccount tEmployeeBankAccount = tEmployeeBankAccountService.getTEmployeeBankAccount(emplyeeIdL, 1);
        if (tEmployeeBankAccount != null) {
            form.setAccountHolder(tEmployeeBankAccount.getAccountKana());
            form.setBankCode(Integer.valueOf(tEmployeeBankAccount.getBankCode()).intValue());
            form.setBankName(tEmployeeBankAccount.getBankName());
            form.setAccountType(Integer.valueOf(tEmployeeBankAccount.getAccountCategory()).intValue());
            form.setBranchCode(Integer.valueOf(tEmployeeBankAccount.getBranchCode()).intValue());
            form.setBranchName(tEmployeeBankAccount.getBranchName());
        }
        // 固定控除金額情報
        TEmployeeFixedDeduction tEmployeeFixedDeduction = tEmployeeFixedDeductionService.getTEmployeeFixedDeduction(
                emplyeeIdL,
                1);
        if (tEmployeeFixedDeduction != null) {
            form.setRepayment(tEmployeeFixedDeduction.getRepaymentBorrowings());
            form.setOtherDeductions(tEmployeeFixedDeduction.getOtherDeduction());
        }
        // 固定支給金額情報
        TEmployeeFixedPayment tEmployeeFixedPayment = tEmployeeFixedPaymentService.getTEmployeeFixedPayment(emplyeeIdL,
                1);
        if (tEmployeeFixedPayment != null) {
            form.setBasicSalary(tEmployeeFixedPayment.getBasicSalary());
            form.setJobAllowance(tEmployeeFixedPayment.getPositionAllowance());
            form.setRequirementsAllowance(tEmployeeFixedPayment.getQualificationAllowance());
            form.setHealthCompensation(tEmployeeFixedPayment.getHouseAllowance());
            form.setFamilyAllowance(tEmployeeFixedPayment.getFamilyAllowance());
            form.setOtherAllowance(tEmployeeFixedPayment.getOtherAllowance());
            form.setTaxExpense(tEmployeeFixedPayment.getTransportFee());
        }
        // 所得税情報
        TEmployeeIncomeTax tEmployeeIncomeTax = tEmployeeIncomeTaxService.getTEmployeeIncomeTax(emplyeeIdL, 1);
        if (tEmployeeIncomeTax != null) {
            form.setHouseholdName(tEmployeeIncomeTax.getHeadHouseholdName());
            form.setDependentsNumber(tEmployeeIncomeTax.getDependencyCount());
            form.setIncomeTaxDistinction(tEmployeeIncomeTax.getIncomeTaxType());
            form.setConsort(tEmployeeIncomeTax.getDeductibleSpouse() ? 1 : 0);
            form.setDependents(tEmployeeIncomeTax.getDependencyDeductionDeclaration() ? 1 : 0);
            form.setRelationship(tEmployeeIncomeTax.getRelationship());
            form.setTreatyExemption(tEmployeeIncomeTax.getTreatyException());
            form.setBlueOfficer(tEmployeeIncomeTax.getBlueOfficer());
        }
        return "employee/employee_info_edit";
    }

    /**
     * 保存処理
     *
     * @param locale
     *            ロケール
     * @param model
     *            モデル
     * @param form
     *            従業員データ入力画面Form
     * @return 従業員データ入力画面
     */
    @RequestMapping(value = { "/save" }, method = RequestMethod.POST)
    public String save(Locale locale, Model model, EmployeeInfoEditForm form) {

        // システム日付を取得する
        Date date = new Date();

        // 從業員情報
        TEmployee tEmployee = new TEmployee();
        tEmployee.setEmployeeNo(form.getEmployeeNo());
        tEmployee.setCompId(1);
        tEmployee.setDeptId(form.getDepartment());
        tEmployee.setLastName(form.getLastName());
        tEmployee.setFirstName(form.getFirstName());
        tEmployee.setLastNameKana(form.getLastNameKana());
        tEmployee.setFirstName(form.getFirstNameKana());
        tEmployee.setSex(form.getSex() == 0 ? true : false);
        tEmployee.setUpdateId(ImmutableValues.ADMINISTRATOR_UID);
        tEmployee.setUpdateDate(date);
        // 口座情報
        TEmployeeBankAccount tEmployeeBankAccount = new TEmployeeBankAccount();
        tEmployeeBankAccount.setCompId(1);
        tEmployeeBankAccount.setAccountNo(form.getAccountNumber() != null ? form.getAccountNumber().toString() : null);
        tEmployeeBankAccount.setAccountKana(form.getAccountHolder());
        tEmployeeBankAccount.setBankCode(form.getBankCode() != null ? form.getBankCode().toString() : null);
        tEmployeeBankAccount.setBankName(form.getBankName());
        tEmployeeBankAccount.setAccountCategory(String.valueOf(form.getAccountType()));
        tEmployeeBankAccount.setBranchCode(form.getBranchCode() != null ? form.getBranchCode().toString() : null);
        tEmployeeBankAccount.setBranchName(form.getBranchName());
        tEmployeeBankAccount.setUpdateId(ImmutableValues.ADMINISTRATOR_UID);
        tEmployeeBankAccount.setUpdateDate(date);
        // 固定控除金額情報
        TEmployeeFixedDeduction tEmployeeFixedDeduction = new TEmployeeFixedDeduction();
        tEmployeeFixedDeduction.setCompId(1);
        tEmployeeFixedDeduction.setRepaymentBorrowings(form.getRepayment());
        tEmployeeFixedDeduction.setOtherDeduction(form.getOtherDeductions());
        tEmployeeFixedDeduction.setTravelFund(form.getAccumulateGold());
        tEmployeeFixedDeduction.setUpdateId(ImmutableValues.ADMINISTRATOR_UID);
        tEmployeeFixedDeduction.setUpdateDate(date);
        // 固定支給金額情報
        TEmployeeFixedPayment tEmployeeFixedPayment = new TEmployeeFixedPayment();
        tEmployeeFixedPayment.setCompId(1);
        tEmployeeFixedPayment.setBasicSalary(form.getBasicSalary());
        tEmployeeFixedPayment.setPositionAllowance(form.getJobAllowance());
        tEmployeeFixedPayment.setQualificationAllowance(form.getRequirementsAllowance());
        tEmployeeFixedPayment.setHouseAllowance(form.getHealthCompensation());
        tEmployeeFixedPayment.setFamilyAllowance(form.getFamilyAllowance());
        tEmployeeFixedPayment.setOtherAllowance(form.getOtherAllowance());
        tEmployeeFixedPayment.setTransportFee(form.getTaxExpense());
        tEmployeeFixedPayment.setUpdateId(ImmutableValues.ADMINISTRATOR_UID);
        tEmployeeFixedPayment.setUpdateDate(date);
        // 所得税情報
        TEmployeeIncomeTax tEmployeeIncomeTax = new TEmployeeIncomeTax();
        tEmployeeIncomeTax.setCompId(1);
        tEmployeeIncomeTax.setHeadHouseholdName(form.getHouseholdName());
        tEmployeeIncomeTax.setDependencyCount(form.getDependentsNumber());
        tEmployeeIncomeTax.setIncomeTaxType(form.getIncomeTaxDistinction());
        tEmployeeIncomeTax.setDeductibleSpouse(form.getConsort() == 0 ? false : true);
        tEmployeeIncomeTax.setDependencyDeductionDeclaration(form.getDependents() == 0 ? false : true);
        tEmployeeIncomeTax.setRelationship(form.getRelationship());
        tEmployeeIncomeTax.setTreatyException(form.isTreatyExemption());
        tEmployeeIncomeTax.setBlueOfficer(form.isBlueOfficer());
        tEmployeeIncomeTax.setUpdateId(ImmutableValues.ADMINISTRATOR_UID);
        tEmployeeIncomeTax.setUpdateDate(date);

        if (form.isCreationflag()) {
            // 更新の場合
            // 從業員情報
            tEmployee.setEmployeeId(form.getEmployeeId());
            tEmployeeService.update(tEmployee);
            // 口座情報
            tEmployeeBankAccount.setEmployeeId(form.getEmployeeId());
            tEmployeeBankAccountService.update(tEmployeeBankAccount);
            // 固定控除金額情報
            tEmployeeFixedDeduction.setEmployeeId(form.getEmployeeId());
            tEmployeeFixedDeductionService.update(tEmployeeFixedDeduction);
            // 固定支給金額情報
            tEmployeeFixedPayment.setEmployeeId(form.getEmployeeId());
            tEmployeeFixedPaymentService.update(tEmployeeFixedPayment);
            // 所得税情報
            tEmployeeIncomeTax.setEmployeeId(form.getEmployeeId());
            tEmployeeIncomeTaxService.update(tEmployeeIncomeTax);

            return "employee/employee_info_edit";
        }
        // 新規の場合

        // 從業員情報
        tEmployee.setRegistId(ImmutableValues.ADMINISTRATOR_UID);
        tEmployee.setRegistDate(date);
        tEmployeeService.regist(tEmployee);

        // シーケンスを取得
        Long employeeId = utilService.getSeqLastValue();

        // 口座情報
        tEmployeeBankAccount.setEmployeeId(employeeId.intValue());
        tEmployeeBankAccount.setRegistId(ImmutableValues.ADMINISTRATOR_UID);
        tEmployeeBankAccount.setRegistDate(date);
        tEmployeeBankAccountService.regist(tEmployeeBankAccount);

        // 固定控除金額情報
        tEmployeeFixedDeduction.setEmployeeId(employeeId.intValue());
        tEmployeeFixedDeduction.setRegistId(ImmutableValues.ADMINISTRATOR_UID);
        tEmployeeFixedDeduction.setRegistDate(date);
        tEmployeeFixedDeductionService.regist(tEmployeeFixedDeduction);

        // 固定支給金額情報
        tEmployeeFixedPayment.setEmployeeId(employeeId.intValue());
        tEmployeeFixedPayment.setRegistId(ImmutableValues.ADMINISTRATOR_UID);
        tEmployeeFixedPayment.setRegistDate(date);
        tEmployeeFixedPaymentService.regist(tEmployeeFixedPayment);

        // 所得税情報
        tEmployeeIncomeTax.setEmployeeId(employeeId.intValue());
        tEmployeeIncomeTax.setRegistId(ImmutableValues.ADMINISTRATOR_UID);
        tEmployeeIncomeTax.setRegistDate(date);
        tEmployeeIncomeTaxService.regist(tEmployeeIncomeTax);

        return "employee/employee_info_edit";
    }
}
