create or replace package PAG_Takes
is
  FUNCTION Select_Takes
  return sys_refcursor;
End;
create or replace package body PAG_Takes
is
 Function Select_Takes 
  return sys_refcursor Is
  v_ref_c sys_refcursor;
  Begin
       open v_ref_c for  select * from Takes;
       RETURN v_ref_c;
  End;
End;