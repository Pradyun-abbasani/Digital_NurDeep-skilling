CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
  p_department VARCHAR2,
  p_bonus_pct NUMBER
) AS
BEGIN
  UPDATE Employees
  SET Salary = Salary + (Salary * p_bonus_pct/100)
  WHERE Department = p_department;
  COMMIT;
END;
/