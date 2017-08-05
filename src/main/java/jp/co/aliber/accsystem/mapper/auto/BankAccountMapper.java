package jp.co.aliber.accsystem.mapper.auto;

import java.util.List;
import jp.co.aliber.accsystem.entity.auto.BankAccount;
import jp.co.aliber.accsystem.entity.auto.BankAccountExample;
import org.apache.ibatis.annotations.Param;

public interface BankAccountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.bank_account
     *
     * @mbg.generated
     */
    long countByExample(BankAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.bank_account
     *
     * @mbg.generated
     */
    int deleteByExample(BankAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.bank_account
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long bankAccountId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.bank_account
     *
     * @mbg.generated
     */
    int insert(BankAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.bank_account
     *
     * @mbg.generated
     */
    int insertSelective(BankAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.bank_account
     *
     * @mbg.generated
     */
    List<BankAccount> selectByExample(BankAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.bank_account
     *
     * @mbg.generated
     */
    BankAccount selectByPrimaryKey(Long bankAccountId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.bank_account
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") BankAccount record, @Param("example") BankAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.bank_account
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") BankAccount record, @Param("example") BankAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.bank_account
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(BankAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.bank_account
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(BankAccount record);
}