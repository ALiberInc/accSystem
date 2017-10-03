create table "public".t_salary_detail (
  employee_id integer not null
  , comp_id integer not null
  , salary_year_month character(6) not null
  , pay_date date not null
  , basic_salary integer
  , position_allowance integer
  , qualification_allowance integer
  , house_allowance integer
  , family_allowance integer
  , other_allowance integer
  , transport_fee integer
  , total_pay integer
  , health_insurance integer
  , welfare_insurance integer
  , employ_insurance integer
  , total_insurance integer
  , income_tax integer
  , living_tax integer
  , travel_fund integer
  , repayment_borrowings integer
  , yearend_deduction integer
  , rent_deduction integer
  , other_deduction integer
  , total_deductible_amount integer
  , subscription_amount integer
  , primary key (employee_id,comp_id,salary_year_month)
);

comment on table t_salary_detail is '従業員給与明細';
comment on column t_salary_detail.employee_id is '従業員番号';
comment on column t_salary_detail.comp_id is '会社番号';
comment on column t_salary_detail.salary_year_month is '給与年月';
comment on column t_salary_detail.pay_date is '支払年月日';
comment on column t_salary_detail.basic_salary is '基本給';
comment on column t_salary_detail.position_allowance is '役職手当';
comment on column t_salary_detail.qualification_allowance is '資格手当';
comment on column t_salary_detail.house_allowance is '住宅手当';
comment on column t_salary_detail.family_allowance is '家族手当';
comment on column t_salary_detail.other_allowance is 'その他の手当';
comment on column t_salary_detail.transport_fee is '交通費';
comment on column t_salary_detail.total_pay is '支給額合計';
comment on column t_salary_detail.health_insurance is '健康保険';
comment on column t_salary_detail.welfare_insurance is '厚生年金';
comment on column t_salary_detail.employ_insurance is '雇用保険';
comment on column t_salary_detail.total_insurance is '社会保険合計';
comment on column t_salary_detail.income_tax is '所得税';
comment on column t_salary_detail.living_tax is '住民税';
comment on column t_salary_detail.travel_fund is '旅行積立金';
comment on column t_salary_detail.repayment_borrowings is '借入等返済';
comment on column t_salary_detail.yearend_deduction is '年末控除';
comment on column t_salary_detail.rent_deduction is '家賃控除';
comment on column t_salary_detail.other_deduction is 'その他控除';
comment on column t_salary_detail.total_deductible_amount is '控除額合計';
comment on column t_salary_detail.subscription_amount is '差引支給額';
