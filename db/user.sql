create table "public".user (
  user_id bigint not null
  , last_name character varying(50) not null
  , first_name character varying(50) not null
  , last_name_kana character varying(50)
  , first_name_kana character varying(50)
  , alphabetical_name character varying(50)
  , email character varying(50)
  , user_img bytea
  , tel character varying(50)
  , last_login_datetime timestamp without time zone
  , login_id character varying(50) not null
  , password character varying(50) not null
  , password_modify_datetime timestamp without time zone not null
  , fail_datetime timestamp without time zone
  , fail_count smallint default 0 not null
  , lockuser boolean default false NOT NULL
  , locale character varying(50)
  , company_name character varying(50)
  , company_abbreviation character varying(50)
  , delete_flg boolean default false NOT NULL
  , regist_date timestamp without time zone NOT NULL
  , regist_id  integer NOT NULL
  , update_date timestamp without time zone NOT NULL
  , update_id integer NOT NULL
  , primary key (user_id)
);

comment on table "user" is 'ユーザー情報';
comment on column "user".user_id  is 'ユーザーID';
comment on column "user".last_name is '氏名_姓';
comment on column "user".first_name is '氏名_名';
comment on column "user".last_name_kana is 'ふりがな_姓';
comment on column "user".first_name_kana is 'ふりがな_名';
comment on column "user".alphabetical_name is 'アルファベティカル別名';
comment on column "user".email is 'メールアドレス';
comment on column "user".user_img is '画像ファイル';
comment on column "user".tel is '電話番号';
comment on column "user".last_login_datetime is '最終ログイン日時';
comment on column "user".login_id is 'ログインID';
comment on column "user".password is 'パスワード';
comment on column "user".password_modify_datetime is 'パスワード変更日時';
comment on column "user".fail_datetime is 'パスワード失敗日時';
comment on column "user".fail_count  is 'パスワード失敗回数';
comment on column "user".lockuser is 'ユーザーロック';
comment on column "user".locale is 'ロケール';
comment on column "user".company_name is '会社名';
comment on column "user".company_abbreviation is '会社名略称';
comment on column "user".delete_flg is '削除フラグ';
comment on column "user".regist_date is '登録日';
comment on column "user".regist_id is '登録者ID';
comment on column "user".update_date is '最終更新日';
comment on column "user".update_id is '最終更新者ID';
