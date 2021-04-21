create or replace package PAG_Courses
is
  PROCEDURE insert_Course(v_Course_ID Course.Course_ID%TYPE, v_TITLE Course.TITLE%TYPE,v_DEPT_NAME Course.DEPT_NAME%TYPE,v_CREDITS Course.CREDITS%TYPE);
  PROCEDURE Delete_Course(v_Course_ID Course.Course_ID%TYPE);
  PROCEDURE Update_Course(v_Course_IDOld Course.Course_ID%TYPE,v_Course_ID Course.Course_ID%TYPE, v_TITLE Course.TITLE%TYPE,v_DEPT_NAME Course.DEPT_NAME%TYPE,v_CREDITS Course.CREDITS%TYPE);
  PROCEDURE Select_Courses(v_ref_c out sys_refcursor);

End;
create or replace package body PAG_Courses
is
     PROCEDURE insert_Course(v_Course_ID Course.Course_ID%TYPE, v_TITLE Course.TITLE%TYPE,v_DEPT_NAME Course.DEPT_NAME%TYPE,v_CREDITS Course.CREDITS%TYPE)
  Is
  Begin
      INSERT INTO Course(Course_ID,TITLE,DEPT_NAME,CREDITS) VALUES (v_Course_ID,v_TITLE,v_DEPT_NAME,v_CREDITS);
  End;
 PROCEDURE Delete_Course(v_Course_ID Course.Course_ID%TYPE)
 IS
 Begin
  DELETE from Course WHERE Course_ID = v_Course_ID;
 end;
   PROCEDURE Update_Course(v_Course_IDOld Course.Course_ID%TYPE,v_Course_ID Course.Course_ID%TYPE, v_TITLE Course.TITLE%TYPE,v_DEPT_NAME Course.DEPT_NAME%TYPE,v_CREDITS Course.CREDITS%TYPE)
 IS
 Begin
 update Course set Course_ID = v_Course_ID,DEPT_NAME=v_DEPT_NAME,TITLE=v_TITLE,CREDITS=v_CREDITS WHERE Course_ID = v_Course_IDOld;
 end;
  PROCEDURE Select_Courses(v_ref_c out sys_refcursor)
   IS
 Begin
 open v_ref_c for  select * from Course;
 end;
End;