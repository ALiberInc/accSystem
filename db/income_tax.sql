create table "public".income_tax (
  income_tax_id bigint not null
  ,head_household_name character varying(100) not null
  ,dependency_count integer not null
  ,income_tax_type integer not null
  ,deductible_spouse boolean not null
  ,dependency_deduction_declaration  boolean not null
  ,relationship character varying(50)
  ,treaty_exemption boolean
  ,blue_officer boolean
  ,primary key (income_tax_id)
);

comment on table income_tax is '所得税情報';
comment on column income_tax.income_tax_id  is '所得税情報番号';
comment on column income_tax.head_household_name is '世帯主名';
comment on column income_tax.dependency_count is '扶養人数';
comment on column income_tax.income_tax_type is '所得税区分';
comment on column income_tax.deductible_spouse is '控除対象配偶者';
comment on column income_tax.dependency_deduction_declaration is '扶養控除等の申告';
comment on column income_tax.relationship is '続柄';
comment on column income_tax.treaty_exemption is '条約免除';
comment on column income_tax.blue_officer is '青色専従者';