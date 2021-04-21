--PAG_Dept_Student
create or replace package PAG_Dept_Student
is
  FUNCTION Select_Dept_Student
  return sys_refcursor;
End;
create or replace package body PAG_Dept_Student is
 Function Select_Dept_Student
  return sys_refcursor Is
  v_ref_c sys_refcursor;
  Begin
  -- select count(*),c.Title from Student s , course c , Takes t where s.ID = t.ID and c.course_Id = t.course_ID group by c.title;
  --select count(Title),Dept_Name from course group by Dept_Name;
  --select count(*),Dept_name from student group by Dept_name
  --select c.Title ,COUNT(c.TITLE)from course c , student s,TAKES t where c.COURSE_ID = t.COURSE_ID and t.Id = s.iD GROUP BY c.TITLE;
       open v_ref_c for select c.Title ,COUNT(c.TITLE)from course c , student s,TAKES t where c.COURSE_ID = t.COURSE_ID and t.Id = s.iD GROUP BY c.TITLE;
       RETURN v_ref_c;
  End;
End;