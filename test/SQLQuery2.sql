use hcl
go
--修改学生信息
alter proc rewrite_1
@stud_id nvarchar(10),@sex nchar(1),@home nchar(100),@phone nvarchar(50)
as
update Student_info
set sex=@sex,home_address=@home,phone=@phone
where stud_id=@stud_id
go
--test
exec rewrite_1 '01','男','浙江衢州','11344556671'
go

alter trigger rewrite
on Student_info
for update
as
declare @old_name nvarchar(15)
declare @new_name nvarchar(15)
declare @id nvarchar(15)
select @id=stud_id from deleted
select @new_name=stud_name from inserted
if update(stud_name)
begin
update Student_grade 
set stud_name=@new_name
where stud_id=@id
update Avggrade
set stud_name=@new_name
where stud_id=@id
update Comprehensive_evaluation
set stud_name=@new_name
where stud_id=@id
end
--test
update Student_info
set stud_name='陈小小'
where stud_id='08'
go

--增加学生信息
create trigger Student_info_insert
on Student_info
for insert
as
declare @id nvarchar(10)
select @id=stud_id
from inserted
print N'新插入的学生学号为：'+@id
go 
--test
insert into Student_info
values('13','陈二狗','男','中国山东','12365478985')
go

--删除学生信息
create trigger drop_1
on student_info
instead of delete
as
delete from Student_grade
where stud_id=(select stud_id from deleted )
delete from student_info
where stud_id =(select stud_id from deleted )
delete from Avggrade
where stud_id =(select stud_id from deleted )
delete from Comprehensive_evaluation
where stud_id =(select stud_id from deleted )
go 
--test
delete 
from Student_info
where stud_id='02'
go


--删除学生成绩
create trigger drop_2
on Avggrade
instead of delete
as
delete from Student_grade
where stud_id=(select stud_id from deleted )
delete from Avggrade
where stud_id =(select stud_id from deleted )
delete from Comprehensive_evaluation
where stud_id =(select stud_id from deleted )
go 
--test
delete 
from Avggrade
where stud_id='02'
go


--浏览学生信息
select a.stud_id,b.stud_name,sex,home_address,phone,Chinese_grade,Math_grade,English_grade,avggrade,ranking,classmate_score,Character_grade,teacher_grade,Total_score,Total_ranking
from Student_info a inner join Student_grade b
	on a.stud_id=b.stud_id inner join Avggrade c
		on b.stud_id=c.stud_id inner join Comprehensive_evaluation d
			on c.stud_id=d.stud_id
go

--计算考试平均分及名次
select stud_id 学号, SUM(Chinese_grade+Math_grade+English_grade)/3 平均分
from Student_grade
group by stud_id
order by SUM(Chinese_grade+Math_grade+English_grade)/3 desc
go



--计算学生总个数
select count(*) 总人数
from Student_info
go

--计算学生总个数
alter proc count_person
as
select count(*) 总人数
from Student_grade
go
--test
exec count_person
go

--成绩录入
create trigger information_insert
on Avggrade
for insert
as
declare @id nvarchar(10)
select @id=stud_id
from inserted 
print N'新插入的学生学号为：'+@id
go 
--test
insert into Avggrade
values('50','华电话费','62','85','67','76','50','80')
go



--查询所有信息
alter proc search
as
select a.stud_id,a.stud_name,home_address,phone,Chinese_grade,Math_grade,English_grade,avggrade,ranking,classmate_score,Character_grade,Chinese_teacher_grade,Math_teacher_grade,English_teacher_grade,Total_score,Total_ranking
  from Student_info a left join Student_grade b
	on a.stud_id=b.stud_id left join Avggrade c
		on b.stud_id=c.stud_id left join Comprehensive_evaluation d
			on c.stud_id=d.stud_id
	
go

exec search 
go

select *
from Avggrade
go


--proc增加语文数学英语学生成绩
alter proc stu_grade
@id nvarchar(10),@name nchar(5),@chinese nvarchar(10),@math nvarchar(10),@english nvarchar(10)
as
update Student_grade
set Chinese_grade=@chinese,Math_grade=@math,English_grade=@english
where stud_id =@id and stud_name=@name
go

exec stu_grade '10','王善','90','90','90'
go


--proc增加学生成绩
alter proc stu_grade
@id nvarchar(10),@name nchar(5),@chinese nvarchar(10),@math nvarchar(10),@english nvarchar(10),@ranki int
as
insert into Student_grade
values (@id,@name,@chinese,@math,@english,@ranki)
go

exec stu_grade '51',N'王','80','90','90',1
go


--计算综合测评
select stud_id 学号,(avggrade*0.6+classmate_score*0.1+Character_grade*0.1+(Chinese_teacher_grade+Math_teacher_grade+English_teacher_grade)/3*0.2) 综合测评分
from Avggrade
order by (avggrade*0.6+classmate_score*0.1+Character_grade*0.1+(Chinese_teacher_grade+Math_teacher_grade+English_teacher_grade)/3*0.2) desc 
go

alter proc proc_set_rank
@rank int,@id nvarchar(10)
as
update Student_grade
set ranking = @rank
where stud_id = @id
go

exec proc_set_rank 1,'10'
go


--获得排名
alter proc proc_get_rank
as
select stud_id 学号, SUM(Chinese_grade+Math_grade+English_grade)/3 平均分
from Student_grade
group by stud_id
order by SUM(Chinese_grade+Math_grade+English_grade)/3 desc
go
--test
exec proc_get_rank
go



--获得综合测评排名
alter proc proc_get_rank_1
as
select stud_id 学号, Total_score 平均分
from Comprehensive_evaluation
group by stud_id,Total_score
order by Total_score desc
go
--test
exec proc_get_rank_1
go




alter proc proc_set_rank_1
@rank_1 int,@id_1 nvarchar(10)
as
update Comprehensive_evaluation
set Total_ranking = @rank_1
where stud_id = @id_1
go

exec proc_set_rank_1 1,'10'
go


--计算学生总个数
alter proc count_person_1
as
select count(*) 总人数
from Comprehensive_evaluation
go
--test
exec count_person_1
go