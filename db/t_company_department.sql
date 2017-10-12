create table "public".t_company_department (
  dept_id integer default nextval('t_company_department_dept_id_seq'::regclass) not null
  , comp_id integer not null
  , dept_no integer not null
  , dept_name character varying(100) not null
  , delete_flg boolean default false not null
  , regist_date timestamp without time zone default CURRENT_TIMESTAMP not null
  , regist_id integer not null
  , update_date timestamp without time zone default CURRENT_TIMESTAMP not null
  , update_id integer not null
  , primary key (dept_id,comp_id)
);

comment on table t_company_department is '会社部署';
comment on column t_company_department.dept_id is '部署番号';
comment on column t_company_department.comp_id is '会社番号	';
comment on column t_company_department.dept_no is '部署No';
comment on column t_company_department.dept_name is '部署名';
comment on column t_company_department.delete_flg is '削除フラグ';
comment on column t_company_department.regist_date is '登録日';
comment on column t_company_department.regist_id is '登録者ID';
comment on column t_company_department.update_date is '最終更新日';
comment on column t_company_department.update_id is '最終更新者ID';