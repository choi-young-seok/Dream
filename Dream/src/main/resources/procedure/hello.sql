set serverout on
declare
	
	today date;
	
	begin
		select sysdate into today
		from dual;
		
		dbms_output.put_line(today);
		
	end ;
	/