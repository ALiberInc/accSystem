package jp.co.aliber.accsystem.service.company;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.aliber.accsystem.entity.auto.TCompanyDepartment;
import jp.co.aliber.accsystem.mapper.auto.TCompanyDepartmentMapper;

/**
 * 会社部署情報サービスのテスター
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TCompanyDepartmentServiceTest {

	@Autowired
	private TCompanyDepartmentService tCompanyDepartmentService;
	@Autowired
	private TCompanyDepartmentMapper tCompanyDepartmentMapper;

	/**
	 * 会社部署情報の取得処理をテスト
	 *
	 */
	@Test
	public void testGetListTCompanyDepartment() {

		// 会社部署情報を作成
		TCompanyDepartment companyDepartment = new TCompanyDepartment();
		// 部署番号
		companyDepartment.setDeptId(1);
		// 会社番号
		companyDepartment.setCompId(Integer.MAX_VALUE);
		// 部署No
		companyDepartment.setDeptNo(333);
		// 部署名
		companyDepartment.setDeptName("開発部");
		// 登録ユーザID
		companyDepartment.setRegistId(222);
		// 更新ユーザID
		companyDepartment.setUpdateId(223);
		// 会社部署情報を登録
		tCompanyDepartmentMapper.insertSelective(companyDepartment);

		// 会社部署情報を作成
		TCompanyDepartment companyDepartment2 = new TCompanyDepartment();
		// 部署番号
		companyDepartment2.setDeptId(9);
		// 会社番号
		companyDepartment2.setCompId(Integer.MAX_VALUE);
		// 部署No
		companyDepartment2.setDeptNo(666);
		// 部署名
		companyDepartment2.setDeptName("営業部");
		// 登録ユーザID
		companyDepartment2.setRegistId(333);
		// 更新ユーザID
		companyDepartment2.setUpdateId(334);
		// 会社部署情報を登録
		tCompanyDepartmentMapper.insertSelective(companyDepartment2);
		List<TCompanyDepartment> list = new ArrayList<>();
		list.add(companyDepartment);
		list.add(companyDepartment2);
		// 会社部署情報を取得
		List<TCompanyDepartment> listResult = tCompanyDepartmentService.getListTCompanyDepartment(Integer.MAX_VALUE);
		listResult.sort(Comparator.comparingInt(TCompanyDepartment::getDeptId));

		// 登録した会社部署情報を削除
		tCompanyDepartmentMapper.deleteByPrimaryKey(1, Integer.MAX_VALUE);
		tCompanyDepartmentMapper.deleteByPrimaryKey(9, Integer.MAX_VALUE);

		assertEquals(list.size(), listResult.size());

		for (int i = 0; i < list.size(); i++) {
			TCompanyDepartment department = list.get(i);
			TCompanyDepartment departmentResult = listResult.get(i);
			// 部署番号
			assertEquals(department.getDeptId(), departmentResult.getDeptId());
			// 会社番号
			assertEquals(department.getCompId(), departmentResult.getCompId());
			// 部署No
			assertEquals(department.getDeptNo(), departmentResult.getDeptNo());
			// 部署名
			assertEquals(department.getDeptName(), departmentResult.getDeptName());
			// 登録ユーザID
			assertEquals(department.getRegistId(), departmentResult.getRegistId());
			// 更新ユーザID
			assertEquals(department.getUpdateId(), departmentResult.getUpdateId());
		}

	}

}
