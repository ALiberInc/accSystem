create table "public".t_employee_fixed_payment (
  employee_id integer not null
  , comp_id integer not null
  , basic_salary integer not null
  , position_allowance integer
  , qualification_allowance integer
  , house_allowance integer
  , family_allowance integer
  , other_allowance integer
  , transport_fee integer
  , delete_flg boolean default false not null
  , regist_date timestamp without time zone not null
  , regist_id integer not null
  , update_date timestamp without time zone not null
  , update_id integer not null
  , primary key (employee_id,comp_id)
);

comment on table t_employee_fixed_payment is '従業員固定支給金額情報';
comment on column t_employee_fixed_payment.employee_id is '従業員番号';
comment on column t_employee_fixed_payment.comp_id is '会社番号';
comment on column t_employee_fixed_payment.basic_salary is '基本給';
comment on column t_employee_fixed_payment.position_allowance is '役職手当';
comment on column t_employee_fixed_payment.qualification_allowance is '資格手当';
comment on column t_employee_fixed_payment.house_allowance is '住宅手当';
comment on column t_employee_fixed_payment.family_allowance is '家族手当';
comment on column t_employee_fixed_payment.other_allowance is 'その他手当';
comment on column t_employee_fixed_payment.transport_fee is '交通費(実費)';
comment on column t_employee_fixed_payment.delete_flg is '削除フラグ';
comment on column t_employee_fixed_payment.regist_date is '登録日';
comment on column t_employee_fixed_payment.regist_id is '登録者ID';
comment on column t_employee_fixed_payment.update_date is '最終更新日';
comment on column t_employee_fixed_payment.update_id is '最終更新者ID';