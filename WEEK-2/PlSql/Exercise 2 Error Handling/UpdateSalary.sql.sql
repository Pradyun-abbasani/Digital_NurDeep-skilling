CREATE OR REPLACE PROCEDURE UpdateSalary(
  p_employee_id NUMBER,
  p_percentage NUMBER
) AS
BEGIN
  UPDATE Employees
  SET Salary = Salary + (Salary * p_percentage/100)
  WHERE EmployeeID = p_employee_id;
  IF SQL%ROWCOUNT = 0 THEN
    RAISE_APPLICATION_ERROR(-20002, 'Employee not found.');
  END IF;
  COMMIT;
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/