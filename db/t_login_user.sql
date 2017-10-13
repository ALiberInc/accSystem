create table "public".t_login_user (
  user_id serial
  , comp_id integer not null
  , last_name character varying(50) not null
  , first_name character varying(50) not null
  , last_name_kana character varying(50)
  , first_name_kana character varying(50)
  , alphabet_name character varying(50)
  , email character varying(100) not null
  , last_login_datetime timestamp without time zone
  , login_id character varying(50) UNIQUE not null
  , password character varying(50) not null
  , password_modify_datetime timestamp without time zone not null
  , fail_datetime timestamp without time zone
  , fail_count smallint default 0 not null
  , lockuser boolean default false not null
  , delete_flg boolean default false not null
  , regist_date timestamp without time zone default CURRENT_TIMESTAMP not null
  , regist_id integer not null
  , update_date timestamp without time zone default CURRENT_TIMESTAMP not null
  , update_id integer not null
  , primary key (user_id)
);

comment on table t_login_user is 'ログインユーザー情報';
comment on column t_login_user.user_id  is 'ユーザーID';
comment on column t_login_user.comp_id  is '会社番号';
comment on column t_login_user.last_name is '氏名_姓';
comment on column t_login_user.first_name is '氏名_名';
comment on column t_login_user.last_name_kana is 'ふりがな_姓';
comment on column t_login_user.first_name_kana is 'ふりがな_名';
comment on column t_login_user.alphabet_name is 'アルファベット名';
comment on column t_login_user.email is 'メールアドレス';
comment on column t_login_user.last_login_datetime is '最終ログイン日時';
comment on column t_login_user.login_id is 'ログインID';
comment on column t_login_user.password is 'パスワード';
comment on column t_login_user.password_modify_datetime is 'パスワード変更日時';
comment on column t_login_user.fail_datetime is 'パスワード失敗日時';
comment on column t_login_user.fail_count  is 'パスワード失敗回数';
comment on column t_login_user.lockuser is 'ユーザーロック';
comment on column t_login_user.delete_flg is '削除フラグ';
comment on column t_login_user.regist_date is '登録日';
comment on column t_login_user.regist_id is '登録者ID';
comment on column t_login_user.update_date is '最終更新日';
comment on column t_login_user.update_id is '最終更新者ID';
