create or replace package PAG_Course_Credit
is
  PROCEDURE Select_Course_Credit(v_ref_c out sys_refcursor);
End;
create or replace package body PAG_Course_Credit
is
  PROCEDURE Select_Course_Credit(v_ref_c out sys_refcursor)
   IS
 Begin
 --select s.name,c.title,t.grade from student s ,course c ,takes t where s.dept_name = c.Dept_name and t.course_iD = c.course_iD and t.Id = s.ID;
 --select Credits ,TITLE from Course
 open v_ref_c for  select s.name,c.title,t.grade from student s ,course c ,takes t where s.dept_name = c.Dept_name and t.course_iD = c.course_iD and t.Id = s.ID;
 end;
End;
