create table "public".t_employee_income_tax (
  employee_id integer not null
  , comp_id integer not null
  , income_tax_type integer not null
  , deductible_spouse boolean not null
  , dependency_deduction_declaration boolean not null
  , dependency_count integer not null
  , head_household_name character varying(100) not null
  , relationship character varying(50)
  , treaty_exception boolean
  , blue_officer boolean
  , delete_flg boolean default false not null
  , regist_date timestamp without time zone default CURRENT_TIMESTAMP not null
  , regist_id integer not null
  , update_date timestamp without time zone default CURRENT_TIMESTAMP not null
  , update_id integer not null
  , primary key (employee_id,comp_id)
);

comment on table t_employee_income_tax is '従業員所得税情報';
comment on column t_employee_income_tax.employee_id  is '従業員番号';
comment on column t_employee_income_tax.comp_id  is '会社番号';
comment on column t_employee_income_tax.income_tax_type is '所得税区分';
comment on column t_employee_income_tax.deductible_spouse is '控除対象配偶者';
comment on column t_employee_income_tax.dependency_deduction_declaration is '扶養控除等の申告';
comment on column t_employee_income_tax.dependency_count is '扶養人数';
comment on column t_employee_income_tax.head_household_name is '世帯主名';
comment on column t_employee_income_tax.relationship is '続柄';
comment on column t_employee_income_tax.treaty_exception is '条約免除';
comment on column t_employee_income_tax.blue_officer is '青色専従者';
comment on column t_employee_income_tax.delete_flg is '削除フラグ';
comment on column t_employee_income_tax.regist_date is '登録日';
comment on column t_employee_income_tax.regist_id is '登録者ID';
comment on column t_employee_income_tax.update_date is '最終更新日';
comment on column t_employee_income_tax.update_id is '最終更新者ID';