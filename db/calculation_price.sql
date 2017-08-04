create table "public".calculation_price(
  calculation_price_id bigint not null
  ,calculation_price integer
  ,hourly_wage_price integer
  , primary key (calculation_price_id)
);

comment on table calculation_price is '計算単価情報';
comment on column calculation_price.calculation_price_id is '計算単価番号';
comment on column calculation_price.calculation_price is '計算単価';
comment on column calculation_price.hourly_wage_price is '時給単価';