create table "public".fixed_deduction(
  fixed_deduction_id bigint not null
  ,travel_fund integer
  ,repayment_borrowings integer
  ,yearend_deduction integer
  ,rent_deduction integer
  ,other_deduction integer
  , primary key (fixed_deduction_id )
);

comment on table fixed_deduction is '固定控除金額情報';
comment on column fixed_deduction.fixed_deduction_id  is '固定控除金額番号';
comment on column fixed_deduction.travel_fund is '旅行積立金';
comment on column fixed_deduction.repayment_borrowings is '借入等返済';
comment on column fixed_deduction.yearend_deduction is '年末控除';
comment on column fixed_deduction.rent_deduction is '家賃控除';
comment on column fixed_deduction.other_deduction is 'その他控除';