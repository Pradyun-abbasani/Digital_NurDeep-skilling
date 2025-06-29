CREATE OR REPLACE PROCEDURE AddNewCustomer(
  p_customer_id NUMBER,
  p_name VARCHAR2,
  p_dob DATE,
  p_balance NUMBER
) AS
BEGIN
  INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
  VALUES (1000,'prady','2005-01-04',10000, SYSDATE);
  COMMIT;
EXCEPTION
  WHEN DUP_VAL_ON_INDEX THEN
    DBMS_OUTPUT.PUT_LINE('Error: Customer already exists.');
  WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/