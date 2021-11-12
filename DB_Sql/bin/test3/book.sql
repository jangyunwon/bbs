--javalink/javalink
create table book(
id varchar2(10) primary key,
name varchar2(10) ,
price number(10)
);

insert into book values('aaaa','hong',1000);
insert into book values('bbbb','alphgo',2000);
insert into book values('cccc','beta',3000);

select*from book;

drop table book;