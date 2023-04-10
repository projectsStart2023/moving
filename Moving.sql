create table users (
id  varchar2(20)     primary key,
pw  varchar2(100)    not null,
nickname    varchar2(20)     unique not null,
enabled     number(1) default 1 
                    check(enabled in (0,1)),
rolename    varchar2(20) default 'ROLE_USER'
                    check(rolename in ('ROLE_USER','ROLE_ADMIN'))
);

select * from users;

delete from users;