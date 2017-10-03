create table "public".m_health_insurance_standard_payment (
  payment_start bigint not null
  , payment_end bigint not null
  , standard_payment bigint not null
  , primary key (payment_start,payment_end)
);

comment on table m_health_insurance_standard_payment is '健康保険標準報酬マスタ';
comment on column m_health_insurance_standard_payment.income_tax_id  is '標準報酬下限';
comment on column m_health_insurance_standard_payment.head_household_name is '標準報酬上限';
comment on column m_health_insurance_standard_payment.dependency_count is '標準月額 ';