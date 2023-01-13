drop table if exists result_table cascade;

create table result_table(x int, y double precision, r int, result text,
                          current_time_ timestamp not null default current_timestamp);



select * from result_table;

