create table "public".m_standard_reward (
  management_id integer not null
  , kbn smallint not null
  , level smallint not null
  , description character varying(100) not null
  , primary key (management_id)
);

comment on table m_standard_reward is '標準月額マスタ';
comment on column m_standard_reward.management_id is '管理番号';
comment on column m_standard_reward.kbn is '区分	';
comment on column m_standard_reward.level is '等級';
comment on column m_standard_reward.description is '説明';