create database hcl 
on(
name=hcl,
filename='e:\hhh\hcl.mdf',
size=500mb,
maxsize=1000mb,
filegrowth=5%
)
log on(
name=hcl_log,
filename='e:\hhh\hcl_log.ldf',
size=300mb,
maxsize=800mb,
filegrowth=5%
)
go
use hcl
go

--学生信息表
create table Student_info
(
stud_id nvarchar(10) primary key not null,
stud_name nvarchar(15) not null,
sex nchar(1) check(sex='男' or sex='女') not null,
home_address nchar(100) not null,
phone nvarchar(50) check(len(phone)=11) not null
)
go

--学生成绩表
create table Student_grade
(
stud_id nvarchar(10) not null,
stud_name nvarchar(15) not null,
Chinese_grade int check(Chinese_grade<=100 and Chinese_grade>0) not null,
Math_grade int check(Math_grade<=100 and Math_grade>0) not null,
English_grade int check(English_grade<=100 and English_grade>0)not null,
ranking int not null
primary key(stud_id,stud_name)
)
go

--学生各项评分表
create table Avggrade
(
stud_id nvarchar(10)  not null,
stud_name nvarchar(15) not null,
avggrade int not null,
classmate_score int not null,
Character_grade int not null,
Chinese_teacher_grade int not null,
Math_teacher_grade int not null,
English_teacher_grade int not null
primary key(stud_id,avggrade)
)
go

--综合测评表
create table Comprehensive_evaluation
(
stud_id nvarchar(10)  not null,
stud_name nvarchar(15) not null,
Total_score varchar(50) not null,
Total_ranking int not null
primary key(stud_id,Total_ranking)
)
go

--账号密码表
create table Username
(
username nvarchar(50) not null,
pwd char(100) not null
) 
go

--学生信息表数据
insert into Student_info 
select '01','王大虎','男','马栏山二锅头大牛路138号','13646541784' union
select '02','王大锤','男','嘉兴市人民政府132号','12344567789' union
select '03','王二妞','女','东北省长白山山头村12号','12346657998' union
select '04','王翠花','女','东北省长春市解放路456号','14522336699' union
select '05','王鲁花','女','牛栏山长征路454号','12244887799' union
select '06','王铁柱','男','浙江省嘉兴市海宁市文苑路145号','13355887766' union
select '07','陈大大','男','浙江省嘉兴市海宁市华联大厦','15512324568' union
select '08','王二狗','男','浙江省杭州市','14878982564' union
select '09','王铁牛','男','云南省大理','15419981332' union
select '10','王善','男','西藏拉萨','16628945789' union
select '11','王帅','男','内蒙古呼和浩特','11123654897' 
go

--学生成绩表数据
insert into Student_grade
select '01','王大虎','55','65','85','6' union
select '02','王大锤','80','75','60','4' union
select '03','王二妞','50','85','95','3' union
select '04','王翠花','85','45','65','7' union
select '05','王鲁花','25','35','45','11' union
select '06','王铁柱','55','85','70' ,'5'union
select '07','陈大大','60','60','25','10'union
select '08','王二狗','35','45','80','8' union
select '09','王铁牛','95','85','75','2' union
select '10','王善','90','90','80','1' union
select '11','王帅','60','75','15','9' 
go

--各项评分表数据
insert into Avggrade
select '01','王大虎','68','85','67','76','50','80' union
select '02','王大锤','71','80','90','90','80','70' union
select '03','王二妞','77','90','90','90','80','80' union
select '04','王翠花','65','70','60','70','80','80' union
select '05','王鲁花','35','90','60','60','80','80' union
select '06','王铁柱','70','80','80','80','80','80' union
select '07','陈大大','48','80','60','60','80','80' union
select '08','王二狗','53','70','70','70','80','80' union
select '09','王铁牛','85','95','85','80','80','80' union
select '10','王善','87','90','90','90','80','80' union
select '11','王帅','50','70','60','60','80','80'
go

--综合测评表数据
insert into Comprehensive_evaluation
select '01','王大虎','69.6','6' union
select '02','王大锤','75.6','4' union
select '03','王二妞','80.8','3' union
select '04','王翠花','67.2','7' union
select '05','王鲁花','50.6','11' union
select '06','王铁柱','74.0','5' union
select '07','陈大大','57.4','9' union
select '08','王二狗','61.0','10' union
select '09','王铁牛','85.0','2' union
select '10','王善','86.8','1' union
select '11','王帅','57.6','8'
go

--账号密码表信息
insert into Username
select 'superadmin','123456' union
select 'normal','123456'
go

