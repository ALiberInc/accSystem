create table "public".user (
  user_id bigint  not null
  , last_name character varying(256) not null
  , first_name character varying(256) not null
  , last_name_kana character varying(256)
  , first_name_kana character varying(256)
  , alphabetical_name character varying(256)
  , email character varying(256)
  , user_img bytea
  , tel character varying(15)
  , sdatetime timestamp without time zone not null
  , edatetime timestamp without time zone not null
  , last_login_datetime timestamp without time zone
  , login_id character varying(256) not null
  , password character varying(256) not null
  , password_mdatetime timestamp without time zone not null
  , fdatetime timestamp without time zone
  , failcount integer default 0 not null
  , lockuser character varying(1)
  , locale character varying(10)
  , company_name character varying(256)
  , company_abbreviation character varying(8)
  , primary key (user_id)
);

comment on table "user" is 'ユーザ情報';
comment on column "user".user_id  is 'ユーザUID';
comment on column "user".last_name is '氏名_姓';
comment on column "user".first_name is '氏名_名';
comment on column "user".last_name_kana is 'ふりがな_姓';
comment on column "user".first_name_kana is 'ふりがな_名';
comment on column "user".alphabetical_name is 'アルファベティカル別名';
comment on column "user".email is 'メールアドレス';
comment on column "user".user_img is '画像ファイル';
comment on column "user".tel is '電話番号';
comment on column "user".sdatetime is '有効開始日時';
comment on column "user".edatetime is '有効終了日時';
comment on column "user".last_login_datetime is '最終ログイン日時';
comment on column "user".login_id is 'ログインID';
comment on column "user".password is 'パスワード';
comment on column "user".password_mdatetime is 'パスワード変更日時';
comment on column "user".fdatetime is 'パスワード失敗日時';
comment on column "user".failcount  is 'パスワード失敗回数';
comment on column "user".lockuser is 'ユーザロック';
comment on column "user".locale is 'ロケール';
comment on column "user".company_name is '会社名';
comment on column "user".company_abbreviation is '会社名略称';
