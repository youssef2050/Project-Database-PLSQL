--PAG_Course_Takes_Student
-- select s.Id,s.Name ,c.Title from Sutdent s , course c , Takes t where s.ID = t.ID and c.course_Id = t.course_ID;
create or replace package PAG_Course_Takes_Student
is
  FUNCTION Select_Course_Takes_Student
  return sys_refcursor;
End;
create or replace package body PAG_Course_Takes_Student is
 Function Select_Course_Takes_Student
  return sys_refcursor Is
  v_ref_c sys_refcursor;
  Begin
       open v_ref_c for select s.Id,s.Name ,c.Title from Student s , course c , Takes t where s.ID = t.ID and c.course_Id = t.course_ID;
       RETURN v_ref_c;
  End;
End;