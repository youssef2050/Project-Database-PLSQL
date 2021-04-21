create or replace package PAG_Students
is
  PROCEDURE insert_Student(v_Id STUDENT.ID%TYPE, v_Name STUDENT.NAME%TYPE,v_DEPT_NAME STUDENT.DEPT_NAME%TYPE,v_TOT_CRED STUDENT.TOT_CRED%TYPE);
  PROCEDURE Delete_Student(v_Id STUDENT.ID%TYPE);
  PROCEDURE Update_Student(v_IdOld STUDENT.ID%TYPE,v_Id STUDENT.ID%TYPE, v_Name STUDENT.NAME%TYPE,v_DEPT_NAME STUDENT.DEPT_NAME%TYPE,v_TOT_CRED STUDENT.TOT_CRED%TYPE);
  PROCEDURE Select_Students(v_ref_c out sys_refcursor);

End;
create or replace package body PAG_Students
is
     PROCEDURE insert_Student(v_Id STUDENT.ID%TYPE, v_Name STUDENT.NAME%TYPE,v_DEPT_NAME STUDENT.DEPT_NAME%TYPE,v_TOT_CRED STUDENT.TOT_CRED%TYPE)
  Is
  Begin
      INSERT INTO Student(id,name,DEPT_NAME,TOT_CRED) VALUES (v_Id,v_Name,v_DEPT_NAME,v_TOT_CRED);
  End;
 PROCEDURE Delete_Student(v_Id STUDENT.ID%TYPE)
 IS
 Begin
  DELETE from STUDENT WHERE ID = v_Id;
 end;
   PROCEDURE Update_Student(v_IdOld STUDENT.ID%TYPE,v_Id STUDENT.ID%TYPE, v_Name STUDENT.NAME%TYPE,v_DEPT_NAME STUDENT.DEPT_NAME%TYPE,v_TOT_CRED STUDENT.TOT_CRED%TYPE)
 IS
 Begin
 update student set ID = v_ID,DEPT_NAME=v_DEPT_NAME,NAME=v_Name,TOT_CRED=v_TOT_CRED WHERE ID = v_IdOld;
 end;
  PROCEDURE Select_Students(v_ref_c out sys_refcursor)
   IS
 Begin
 open v_ref_c for  select * from Student;
 end;
End;