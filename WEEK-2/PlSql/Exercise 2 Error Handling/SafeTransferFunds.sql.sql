CREATE OR REPLACE PROCEDURE SafeTransferFunds(
  p_from_account NUMBER,
  p_to_account NUMBER,
  p_amount NUMBER
) AS
  v_balance NUMBER;
BEGIN
  SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_from_account FOR UPDATE;
  IF v_balance < p_amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds.');
  END IF;
  UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_from_account;
  UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_to_account;
  COMMIT;
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/