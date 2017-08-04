create table "public".employee (
  employee_id  bigint not null
  ,name character varying(100) not null
  ,fuligana character varying(100)
  ,sex character varying(10)
  ,primary key (employee_id)
);

comment on table employee is '從業員情報';
comment on column employee.employee_id is '從業員番号';
comment on column employee.name is '氏名';
comment on column employee.fuligana is '氏名フリガナ';
comment on column employee.sex is '性別';