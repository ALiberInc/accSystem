create table "public".fixed_payment (
  fixed_payment_id bigint not null
  ,basic_salary integer not null
  ,position_allowance integer not null
  ,qualification_allowance integer
  ,house_allowance integer
  ,family_allowance integer
  ,other_allowance integer
  ,transport_fee integer
  , primary key (fixed_payment_id)
);

comment on table fixed_payment is '固定支給金額情報';
comment on column fixed_payment.fixed_payment_id is '固定支給金額番号';
comment on column fixed_payment.basic_salary is '基本給';
comment on column fixed_payment.position_allowance is '役職手当';
comment on column fixed_payment.qualification_allowance is '資格手当';
comment on column fixed_payment.house_allowance is '住宅手当';
comment on column fixed_payment.family_allowance is '家族手当';
comment on column fixed_payment.other_allowance is 'その他手当';
comment on column fixed_payment.transport_fee is '交通費(実費)';