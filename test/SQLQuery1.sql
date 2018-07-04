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

--ѧ����Ϣ��
create table Student_info
(
stud_id nvarchar(10) primary key not null,
stud_name nvarchar(15) not null,
sex nchar(1) check(sex='��' or sex='Ů') not null,
home_address nchar(100) not null,
phone nvarchar(50) check(len(phone)=11) not null
)
go

--ѧ���ɼ���
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

--ѧ���������ֱ�
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

--�ۺϲ�����
create table Comprehensive_evaluation
(
stud_id nvarchar(10)  not null,
stud_name nvarchar(15) not null,
Total_score varchar(50) not null,
Total_ranking int not null
primary key(stud_id,Total_ranking)
)
go

--�˺������
create table Username
(
username nvarchar(50) not null,
pwd char(100) not null
) 
go

--ѧ����Ϣ������
insert into Student_info 
select '01','����','��','����ɽ����ͷ��ţ·138��','13646541784' union
select '02','����','��','��������������132��','12344567789' union
select '03','�����','Ů','����ʡ����ɽɽͷ��12��','12346657998' union
select '04','���仨','Ů','����ʡ�����н��·456��','14522336699' union
select '05','��³��','Ů','ţ��ɽ����·454��','12244887799' union
select '06','������','��','�㽭ʡ�����к�������Է·145��','13355887766' union
select '07','�´��','��','�㽭ʡ�����к����л�������','15512324568' union
select '08','������','��','�㽭ʡ������','14878982564' union
select '09','����ţ','��','����ʡ����','15419981332' union
select '10','����','��','��������','16628945789' union
select '11','��˧','��','���ɹź��ͺ���','11123654897' 
go

--ѧ���ɼ�������
insert into Student_grade
select '01','����','55','65','85','6' union
select '02','����','80','75','60','4' union
select '03','�����','50','85','95','3' union
select '04','���仨','85','45','65','7' union
select '05','��³��','25','35','45','11' union
select '06','������','55','85','70' ,'5'union
select '07','�´��','60','60','25','10'union
select '08','������','35','45','80','8' union
select '09','����ţ','95','85','75','2' union
select '10','����','90','90','80','1' union
select '11','��˧','60','75','15','9' 
go

--�������ֱ�����
insert into Avggrade
select '01','����','68','85','67','76','50','80' union
select '02','����','71','80','90','90','80','70' union
select '03','�����','77','90','90','90','80','80' union
select '04','���仨','65','70','60','70','80','80' union
select '05','��³��','35','90','60','60','80','80' union
select '06','������','70','80','80','80','80','80' union
select '07','�´��','48','80','60','60','80','80' union
select '08','������','53','70','70','70','80','80' union
select '09','����ţ','85','95','85','80','80','80' union
select '10','����','87','90','90','90','80','80' union
select '11','��˧','50','70','60','60','80','80'
go

--�ۺϲ���������
insert into Comprehensive_evaluation
select '01','����','69.6','6' union
select '02','����','75.6','4' union
select '03','�����','80.8','3' union
select '04','���仨','67.2','7' union
select '05','��³��','50.6','11' union
select '06','������','74.0','5' union
select '07','�´��','57.4','9' union
select '08','������','61.0','10' union
select '09','����ţ','85.0','2' union
select '10','����','86.8','1' union
select '11','��˧','57.6','8'
go

--�˺��������Ϣ
insert into Username
select 'superadmin','123456' union
select 'normal','123456'
go

