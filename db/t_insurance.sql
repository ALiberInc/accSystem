create table "public".t_insurance (
  comp_id integer not null
  , employ_insur_rate numeric(5, 2) not null
  , employ_rounding integer not null
  , health_insur_rate_no_nursing numeric(5, 2) not null
  , health_insur_rate_with_nursing numeric(5, 2) not null
  , health_rounding integer not null
  , welfare_insurance_rate numeric(5, 2) not null
  , welfare_rounding integer not null
  , welfare_exception_rate numeric(5, 2) not null
  , welfare_addition_rate numeric(5, 2) not null
  , welfare_addition_ration integer not null
  , primary key (comp_id)
);

comment on table t_insurance is '社会保険情報';
comment on column t_insurance.comp_id is '会社番号';
comment on column t_insurance.employ_insur_rate is '雇用保険被保険者負担率';
comment on column t_insurance.employ_rounding is '雇用保険端数処理';
comment on column t_insurance.health_insur_rate_no_nursing is '健康保険料率(介護保険該当なし)';
comment on column t_insurance.health_insur_rate_with_nursing is '健康保険料率（介護保険該当者）';
comment on column t_insurance.health_rounding is '健康保険端数処理';
comment on column t_insurance.welfare_insurance_rate is '厚生年金保険料率';
comment on column t_insurance.welfare_rounding is '厚生年金端数処理';
comment on column t_insurance.welfare_exception_rate is '基金免除保険料率';
comment on column t_insurance.welfare_addition_rate is '基金独自給付加算率';
comment on column t_insurance.welfare_addition_ration is '基金独自給付加算定額';