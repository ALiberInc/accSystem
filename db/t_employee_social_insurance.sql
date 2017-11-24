create table "public".t_employee_social_insurance (
  employee_id integer not null
  , comp_id integer not null
  , employ_insur_join_flg smallint not null
  , health_insur_join_flg smallint not null
  , health_insur_join_catagory smallint
  , health_insur_standard_reward_level smallint
  , insurers_no character varying(20)
  , insured_sort_no character varying(20)
  , welfare_join_flg boolean not null
  , welfare_standard_reward_level smallint
  , basic_welfare_no character varying(20)
  , welfare_fund_join_flg boolean not null
  , delete_flg boolean default false not null
  , regist_date timestamp without time zone default CURRENT_TIMESTAMP not null
  , regist_id integer not null
  , update_date timestamp without time zone default CURRENT_TIMESTAMP not null
  , update_id integer not null
  , primary key (employee_id,comp_id)
);

comment on table t_employee_social_insurance is '從業員社会保険情報';
comment on column t_employee_social_insurance.employee_id is '從業員番号';
comment on column t_employee_social_insurance.comp_id is '会社番号';
comment on column t_employee_social_insurance.employ_insur_join_flg is '雇用保険加入フラグ';
comment on column t_employee_social_insurance.health_insur_join_flg is '健康保険加入フラグ';
comment on column t_employee_social_insurance.health_insur_join_catagory is '健康保険種別';
comment on column t_employee_social_insurance.health_insur_standard_reward_level is '健康保険標準報酬レベル';
comment on column t_employee_social_insurance.insurers_no is '保険者番号';
comment on column t_employee_social_insurance.insured_sort_no is '被保険者整理番号';
comment on column t_employee_social_insurance.welfare_join_flg is '厚生年金加入フラグ';
comment on column t_employee_social_insurance.welfare_standard_reward_level is '厚生年金標準報酬レベル';
comment on column t_employee_social_insurance.basic_welfare_no is '基礎年金番号';
comment on column t_employee_social_insurance.welfare_fund_join_flg is '厚生年金基金加入フラグ';
comment on column t_employee_social_insurance.delete_flg is '削除フラグ';
comment on column t_employee_social_insurance.regist_date is '登録日';
comment on column t_employee_social_insurance.regist_id is '登録者ID';
comment on column t_employee_social_insurance.update_date is '最終更新日';
comment on column t_employee_social_insurance.update_id is '最終更新者ID';