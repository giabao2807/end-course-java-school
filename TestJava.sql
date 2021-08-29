create schema db_Course default char set utf8mb4;

use db_Course;

create table Course(
    Code varchar(100) not null,
    Name varchar(100) not null,
    Credit int not null,
   
    constraint PK_Course primary key (Code)
    );

insert into Course(Code,Name,Credit) values ("PRJ101","Core Java", 3);
insert into Course(Code,Name,Credit) values ("PRN292",".Net and C#", 3);
insert into Course(Code,Name,Credit) values ("ENI201","Business English", 4);
    

    
    