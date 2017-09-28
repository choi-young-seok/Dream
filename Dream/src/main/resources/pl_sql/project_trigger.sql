create or replace trigger update_projectSuccess_state
	for update on dream_project
  compound trigger
    project_percentage number;
    
  after each row is
    begin
      select floor((now_amount/project_goal_amount)*100) into project_percentage from dream_project where project_no =:old.project_no;	
      if 
        (:old.project_register_state = 'T' and (project_percentage >= 100) ) 
        then 
          update dream_project set project_success_state ='T' where project_no = :old.project_no;
      end if;
	END AFTER EACH ROW;
end;
/