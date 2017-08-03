create table "public".company (
  comp_id bigint not null
  , comp_name character varying(256) not null
  , comp_kana character varying(256) not null
  , comp_zip character varying(7) not null
  , comp_add1 character varying(256) not null
  , comp_add2 character varying(256) not null
  , comp_add1_kana character varying(256) not null
  , comp_add2_kana character varying(256) not null
  , comp_tel character varying(100) not null
  , classification integer not null
  , corporation_id bigint not null
  , corp_owner_name character varying(100) not null
  , corp_owner_name_kana character varying(100) not null
  , corp_sort_no character varying(50) not null
  , corp_no bigint not null
  , corp_kind character varying(100) not null
  , deadline_day boolean not null
  , deadline_adjust_days integer not null
  , payment_day boolean not null
  , payment_adjust_days integer not null
  , accounting_manager character varying(100) not null
  , user_recong_id bigint
  , user_id bigint
  , tax_accountant character varying(100) not null
  , tax_office character varying(256) not null
  , data_share_id bigint not null
  , my_number bigint not null
  , comp_code bigint not null
  , primary key (comp_id)
);

comment on table company is '会社情報';
comment on column company.comp_id is '会社番号';
comment on column company.comp_name is '法人名';
comment on column company.comp_kana is '法人名振り仮名';
comment on column company.comp_zip is '郵便番号';
comment on column company.comp_add1 is '住所1';
comment on column company.comp_add2 is '住所2';
comment on column company.comp_add1_kana is '住所1振り仮名';
comment on column company.comp_add2_kana is '住所2振り仮名';
comment on column company.comp_tel is '電話番号';
comment on column company.classification is '事業区分';
comment on column company.corporation_id is '法人番号';
comment on column company.corp_owner_name is '事業主氏名';
comment on column company.corp_owner_name_kana is '事業主氏名振り仮名';
comment on column company.corp_sort_no is '事業所整理記号';
comment on column company.corp_no is '事業所番号';
comment on column company.corp_kind is '事業種目';
comment on column company.deadline_day is '締め日が末日';
comment on column company.deadline_adjust_days is '締め日の末日以外日数';
comment on column company.payment_day is '支給日が末日';
comment on column company.payment_adjust_days is '支給日の末日以外日数';
comment on column company.accounting_manager is '経理責任者';
comment on column company.user_recong_id is '利用者識別番号';
comment on column company.user_id is '利用者ID';
comment on column company.tax_accountant is '税理者';
comment on column company.tax_office is '税理署';
comment on column company.data_share_id is 'データ共有ID';
comment on column company.my_number is 'マイナンバー';
comment on column company.comp_code is '会社コード';


