create table "public".t_employee_fixed_deduction(
  employee_id integer not null
  , comp_id integer not null
  , travel_fund integer
  , repayment_borrowings integer
  , yearend_deduction integer
  , rent_deduction integer
  , other_deduction integer
  , delete_flg boolean default false not null
  , regist_date timestamp without time zone not null
  , regist_id integer not null
  , update_date timestamp without time zone not null
  , update_id integer not null
  , primary key (employee_id,comp_id)
);

comment on table t_employee_fixed_deduction is '従業員固定控除金額情報';
comment on column t_employee_fixed_deduction.employee_id  is '従業員番号';
comment on column t_employee_fixed_deduction.comp_id  is '会社番号';
comment on column t_employee_fixed_deduction.travel_fund is '旅行積立金';
comment on column t_employee_fixed_deduction.repayment_borrowings is '借入等返済';
comment on column t_employee_fixed_deduction.yearend_deduction is '年末控除';
comment on column t_employee_fixed_deduction.rent_deduction is '家賃控除';
comment on column t_employee_fixed_deduction.other_deduction is 'その他控除';
comment on column t_employee_fixed_deduction.delete_flg is '削除フラグ';
comment on column t_employee_fixed_deduction.regist_date is '登録日';
comment on column t_employee_fixed_deduction.regist_id is '登録者ID';
comment on column t_employee_fixed_deduction.update_date is '最終更新日';
comment on column t_employee_fixed_deduction.update_id is '最終更新者ID';