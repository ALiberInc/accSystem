create table "public".insurance (
  insurance_id bigint not null
  , employ_insur_rate integer not null
  , employ_rounding integer not null
  , health_insur_rate character varying(10) not null
  , health_insur_rate2 character varying(10) not null
  , health_rounding integer not null
  , welfare_insurance character varying(10) not null
  , welfare_rounding integer not null
  , welfare_exemption_rate character varying(10) not null
  , welfare_addition_rate character varying(10) not null
  , welfare_addition_ration integer not null
  , primary key (insurance_id)
);

comment on table insurance is '社会保険情報';
comment on column insurance.insurance_id is '社会保険番号';
comment on column insurance.employ_insur_rate is '雇用保険被保険者負担率';
comment on column insurance.employ_rounding is '雇用保険端数処理';
comment on column insurance.health_insur_rate is '健康保険料率(介護保険該当なし)';
comment on column insurance.health_insur_rate2 is '健康保険料率（介護保険該当者）';
comment on column insurance.health_rounding is '健康保険端数処理';
comment on column insurance.welfare_insurance is '厚生年金保険料率';
comment on column insurance.welfare_rounding is '厚生年金端数処理';
comment on column insurance.welfare_exemption_rate is '基金免除保険料率';
comment on column insurance.welfare_addition_rate is '基金独自給付加算率';
comment on column insurance.welfare_addition_ration is '基金独自給付加算定額';