create table "public".pay_details_input (
  pay_details_input_id bigint not null
  , basic_pay bigint not null
  , position_pay bigint not null
  , qualification_pay bigint not null
  , housing_pay bigint not null
  , family_pay bigint not null
  , others_pay bigint not null
  , transport_fee bigint not null
  , total_pay bigint not null
  , health_insurance bigint not null
  , hand_input1 boolean not null
  , welfare_insurance bigint not null
  , hand_input2 boolean not null
  , employ_insurance bigint not null
  , hand_input3 boolean not null
  , total_insurance bigint not null
  , income_tax bigint not null
  , living_tax bigint not null
  , total_deductible_amount bigint not null
  , subscription_amount bigint not null
  , primary key (pay_details_input_id)
);

comment on table pay_details_input is '給与明細入力';
comment on column pay_details_input.pay_details_input_id is '給与明細入力番号';
comment on column pay_details_input.basic_pay is '基本給';
comment on column pay_details_input.position_pay is '役職手当';
comment on column pay_details_input.qualification_pay is '資格手当';
comment on column pay_details_input.housing_pay is '住宅手当';
comment on column pay_details_input.family_pay is '家族手当';
comment on column pay_details_input.others_pay is 'その他の手当';
comment on column pay_details_input.transport_fee is '交通費';
comment on column pay_details_input.total_pay is '支給額合計';
comment on column pay_details_input.health_insurance is '健康保険';
comment on column pay_details_input.hand_input1 is '手入力1';
comment on column pay_details_input.welfare_insurance is '厚生年金';
comment on column pay_details_input.hand_input2 is '手入力2';
comment on column pay_details_input.employ_insurance is '雇用保険';
comment on column pay_details_input.hand_input3 is '手入力3';
comment on column pay_details_input.total_insurance is '社会保険合計';
comment on column pay_details_input.income_tax is '所得税';
comment on column pay_details_input.living_tax is '住名税';
comment on column pay_details_input.total_deductible_amount is '控除額合計';
comment on column pay_details_input.subscription_amount is '差引支給額';
