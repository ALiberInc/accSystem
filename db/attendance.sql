create table "public".attendance (
  attendance_id bigint not null
  , attendance_days integer not null
  , attendance_hours integer not null
  , salary_holiday_used integer not null
  , salary_holiday_left integer not null
  , special_holiday_used integer not null
  , absence_days integer not null
  , late_days integer not null
  , leave_early_days integer not null
  , primary key (attendance_id)
);

comment on table attendance is '勤怠情報';
comment on column attendance.attendance_id is '勤怠番号';
comment on column attendance.attendance_days is '出勤日数';
comment on column attendance.attendance_hours is '勤務時間';
comment on column attendance.salary_holiday_used is '有給休暇消化日数';
comment on column attendance.salary_holiday_left is '有給休暇残り日数';
comment on column attendance.special_holiday_used is '特別休暇消化日数';
comment on column attendance.absence_days is '欠勤';
comment on column attendance.late_days is '遅刻';
comment on column attendance.leave_early_days is '早退';










