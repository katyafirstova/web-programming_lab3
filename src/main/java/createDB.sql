drop table if exists result_table cascade;

drop sequence if exists  hit_id_seq;

create sequence hit_id_seq
    increment by 1
    no maxvalue
    no minvalue
    cache 1;

create table result_table( x int, y double precision, r int, result text, execution_time time,
current_time_ timestamp not null default current_timestamp);

select * from result_table;
