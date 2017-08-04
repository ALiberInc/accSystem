create table "public".pay_details (
  pay_details_id bigint not null
  , employ_name character varying(256) not null
  , department character varying(256) not null
  , email character varying(256) not null
  , primary key (pay_details_id)
);

comment on table pay_details is '給与明細情報';
comment on column pay_details.pay_details_id is '給与明細番号';
comment on column pay_details.employ_name is '氏名';
comment on column pay_details.department is '部署';
comment on column pay_details.email is 'メールアドレス';
