create table "public".l_list (
  literal_class_id integer not null
  , literal_id integer not null
  , indicate_letter character varying(100)
  , indicate_order smallint
  , primary key (literal_class_id,literal_id)
);

comment on table l_list is 'L_LISTマスタ';
comment on column l_list.literal_class_id is 'リテラル種別ID';
comment on column l_list.literal_id is 'リテラルID	';
comment on column l_list.indicate_letter is '表示文字';
comment on column l_list.indicate_order is '表示順';