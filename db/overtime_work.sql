create table "public".overtime_work (
  overtime_work_id bigint not null
  , aver_work_time integer not null
  , time_count integer not null
  , primary key (overtime_work_id)
);

comment on table overtime_work is '時間外計算情報';
comment on column overtime_work.overtime_work_id is '時間外計算番号';
comment on column overtime_work.aver_work_time is '平均労働時間';
comment on column overtime_work.time_count is '時間入力の端数';