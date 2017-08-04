create table "public".bank_account(
  bank_account_id  bigint not null
  ,account_kana character varying(256) not null
  ,bank_code character varying(10) not null
  ,bank_name character varying(256) not null
  ,account_category character varying(10)
  ,branch_code character varying(10)
  ,branch_name character varying(256)
  , primary key (bank_account_id)
);

comment on table bank_accountis '口座情報';
comment on column bank_account.bank_account_id is '口座番号';
comment on column bank_account.account_kana is '口座名義人(カナ)';
comment on column bank_account.bank_code is '銀行コード';
comment on column bank_account.bank_name is '銀行名';
comment on column bank_account.account_category is '口座種別';
comment on column bank_account.branch_code is '本支店コード';
comment on column bank_account.branch_name is '本支店名';