create or replace package PAG_Global
is
   PROCEDURE Select_Departments(v_ref_c out sys_refcursor);

End;
create or replace package body PAG_Global
is
  PROCEDURE Select_Departments(v_ref_c out sys_refcursor)
   IS
 Begin
 open v_ref_c for  select DEPT_NAME from DEPARTMENT;
 end;
End;