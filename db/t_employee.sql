create table "public".t_employee (
  employee_id serial
  , comp_id integer not null
  , employee_no character varying(50) not null
  , last_name character varying(50) not null
  , first_name character varying(50) not null
  , last_name_kana character varying(50)
  , first_name_kana character varying(50)
  , sex boolean not null
  , dept_id integer not null
  , mail_address character varying(100)
  , delete_flg boolean default false not null
  , regist_date timestamp without time zone default CURRENT_TIMESTAMP not null
  , regist_id integer not null
  , update_date timestamp without time zone default CURRENT_TIMESTAMP not null
  , update_id integer not null
  , primary key (employee_id,comp_id)
);

comment on table t_employee is '從業員情報';
comment on column t_employee.employee_id is '從業員番号';
comment on column t_employee.comp_id is '会社番号';
comment on column t_employee.employee_no is '從業員No';
comment on column t_employee.last_name is '姓（漢字）';
comment on column t_employee.first_name is '名（漢字）';
comment on column t_employee.last_name_kana is '姓（カナ）';
comment on column t_employee.first_name_kana is '名（カナ）';
comment on column t_employee.sex is '性別';
comment on column t_employee.dept_id is '部署番号';
comment on column t_employee.mail_address is 'メールアドレス';
comment on column t_employee.delete_flg is '削除フラグ';
comment on column t_employee.regist_date is '登録日';
comment on column t_employee.regist_id is '登録者ID';
comment on column t_employee.update_date is '最終更新日';
comment on column t_employee.update_id is '最終更新者ID';