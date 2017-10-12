create table "public".t_company (
  comp_id integer default nextval('t_company_comp_id_seq'::regclass) not null
  , comp_name character varying(256) not null
  , comp_kana character varying(256) not null
  , comp_zip1 character varying(3) not null
  , comp_zip2 character varying(4) not null
  , comp_add1 character varying(256) not null
  , comp_add2 character varying(256) not null
  , comp_add1_kana character varying(256) not null
  , comp_add2_kana character varying(256) not null
  , comp_tel1 character varying(33) not null
  , comp_tel2 character varying(33) not null
  , comp_tel3 character varying(33) not null
  , classification integer not null
  , corporation_id bigint not null
  , corp_owner_name character varying(100) not null
  , corp_owner_name_kana character varying(100) not null
  , corp_sort_no1 character varying(25) not null
  , corp_sort_no2 character varying(25) not null
  , corp_no bigint not null
  , corp_kind character varying(100) not null
  , deadline_day boolean not null
  , deadline_adjust_days integer not null
  , payment_day boolean not null
  , payment_adjust_days integer not null
  , accounting_manager character varying(100) not null
  , user_recognize_id bigint
  , user_id bigint
  , tax_accountant character varying(100) not null
  , tax_office character varying(256) not null
  , data_share_id bigint not null
  , get_my_number boolean not null
  , comp_code bigint not null
  , employ_insur_rate numeric(5, 2) not null
  , employ_rounding integer not null
  , health_insur_rate_no_nursing numeric(5, 2) not null
  , health_insur_rate_with_nursing numeric(5, 2) not null
  , health_rounding integer not null
  , welfare_insurance_rate numeric(5, 2) not null
  , welfare_rounding integer not null
  , welfare_exception_rate numeric(5, 2) not null
  , welfare_addition_rate numeric(5, 2) not null
  , welfare_addition_ration integer not null
  , delete_flg boolean default false not null
  , regist_date timestamp without time zone default CURRENT_TIMESTAMP not null
  , regist_id integer not null
  , update_date timestamp without time zone default CURRENT_TIMESTAMP not null
  , update_id integer not null
  , primary key (comp_id)
);

comment on table t_company is '会社情報';
comment on column t_company.comp_id is '勤怠番号';
comment on column t_company.comp_name is '法人名';
comment on column t_company.comp_kana is '法人名フリガナ';
comment on column t_company.comp_zip1 is '郵便番号1';
comment on column t_company.comp_zip2 is '郵便番号2';
comment on column t_company.comp_add1 is '住所1';
comment on column t_company.comp_add2 is '住所2';
comment on column t_company.comp_add1_kana is '住所1フリガナ';
comment on column t_company.comp_add2_kana is '住所2フリガナ';
comment on column t_company.comp_tel1 is '電話番号1';
comment on column t_company.comp_tel2 is '電話番号2';
comment on column t_company.comp_tel3 is '電話番号3';
comment on column t_company.classification is '事業区分';
comment on column t_company.corporation_id is '法人番号';
comment on column t_company.corp_owner_name is '事業主氏名';
comment on column t_company.corp_owner_name_kana is '事業主氏名フリガナ';
comment on column t_company.corp_sort_no1 is '事業所整理記号1';
comment on column t_company.corp_sort_no2 is '事業所整理記号2';
comment on column t_company.corp_no is '事業所番号';
comment on column t_company.corp_kind is '事業種目';
comment on column t_company.deadline_day is '締め日が末日';
comment on column t_company.deadline_adjust_days is '締め日の末日以外日数';
comment on column t_company.payment_day is '支給日が末日';
comment on column t_company.payment_adjust_days is '支給日の末日以外日数';
comment on column t_company.accounting_manager is '経理責任者';
comment on column t_company.user_recognize_id is '利用者識別番号';
comment on column t_company.user_id is '利用者ID';
comment on column t_company.tax_accountant is '税理者';
comment on column t_company.tax_office is '税理署';
comment on column t_company.data_share_id is 'データ共有ID';
comment on column t_company.get_my_number is 'マイナンバーマスタから個人番号を取得する';
comment on column t_company.comp_code is '会社コード';
comment on column t_company.employ_insur_rate is '雇用保険被保険者負担率';
comment on column t_company.employ_rounding is '雇用保険端数処理';
comment on column t_company.health_insur_rate_no_nursing is '健康保険料率(介護保険該当なし)';
comment on column t_company.health_insur_rate_with_nursing is '健康保険料率（介護保険該当者）';
comment on column t_company.health_rounding is '健康保険端数処理';
comment on column t_company.welfare_insurance_rate is '厚生年金保険料率';
comment on column t_company.welfare_rounding is '厚生年金端数処理';
comment on column t_company.welfare_exception_rate is '基金免除保険料率';
comment on column t_company.welfare_addition_rate is '基金独自給付加算率';
comment on column t_company.welfare_addition_ration is '基金独自給付加算定額';
comment on column t_company.delete_flg is '削除フラグ';
comment on column t_company.regist_date is '登録日';
comment on column t_company.regist_id is '登録者ID';
comment on column t_company.update_date is '最終更新日';
comment on column t_company.update_id is '最終更新者ID';