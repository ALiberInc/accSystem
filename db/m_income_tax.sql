create table "public".m_income_tax (
  tax_level smallint not null
  , income_start bigint not null
  , income_end bigint not null
  , tax_0 integer not null
  , tax_1 integer not null
  , tax_2 integer not null
  , tax_3 integer not null
  , tax_4 integer not null
  , tax_5 integer not null
  , tax_6 integer not null
  , tax_7 integer not null
  , tax_otu integer not null
  , primary key (income_start,income_end)
);

comment on table m_income_tax is '給与所得の源泉徴収税額マスタ';
comment on column m_income_tax.tax_level is '所得税レベル';
comment on column m_income_tax.income_start is '所得金額下限';
comment on column m_income_tax.income_end is '所得金額上限';
comment on column m_income_tax.tax_0 is '扶養親族0人時の税額';
comment on column m_income_tax.tax_1 is '扶養親族1人時の税額';
comment on column m_income_tax.tax_2 is '扶養親族2人時の税額';
comment on column m_income_tax.tax_3 is '扶養親族3人時の税額';
comment on column m_income_tax.tax_4 is '扶養親族4人時の税額';
comment on column m_income_tax.tax_5 is '扶養親族5人時の税額';
comment on column m_income_tax.tax_6 is '扶養親族6人時の税額';
comment on column m_income_tax.tax_7 is '扶養親族7人時の税額';
comment on column m_income_tax.tax_otu is '乙欄の税額';










