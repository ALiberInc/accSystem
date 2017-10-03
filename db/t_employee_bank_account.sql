create table "public".t_employee_bank_account(
  employee_id integer not null
  , comp_id integer not null
  , account_no character varying(50)
  , account_kana character varying(50) not null
  , bank_code character varying(10) not null
  , bank_name character varying(100) not null
  , account_category character varying(10)
  , branch_code character varying(10)
  , branch_name character varying(100)
  , delete_flg boolean default false not null
  , regist_date timestamp without time zone not null
  , regist_id integer not null
  , update_date timestamp without time zone not null
  , update_id integer not null
  , primary key (employee_id,comp_id)
);

comment on table t_employee_bank_account is '従業員口座情報';
comment on column t_employee_bank_account.employee_id is '従業員番号';
comment on column t_employee_bank_account.comp_id is '会社番号';
comment on column t_employee_bank_account.account_no is '口座番号';
comment on column t_employee_bank_account.account_kana is '口座名義人(カナ)';
comment on column t_employee_bank_account.bank_code is '銀行コード';
comment on column t_employee_bank_account.bank_name is '銀行名';
comment on column t_employee_bank_account.account_category is '口座種別';
comment on column t_employee_bank_account.branch_code is '本支店コード';
comment on column t_employee_bank_account.branch_name is '本支店名';
comment on column t_employee_bank_account.delete_flg is '削除フラグ';
comment on column t_employee_bank_account.regist_date is '登録日';
comment on column t_employee_bank_account.regist_id is '登録者ID';
comment on column t_employee_bank_account.update_date is '最終更新日';
comment on column t_employee_bank_account.update_id is '最終更新者ID';