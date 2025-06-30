DECLARE
  CURSOR c_accounts IS
    SELECT AccountID FROM Accounts;
BEGIN
  FOR rec IN c_accounts LOOP
    UPDATE Accounts
    SET Balance = Balance - 100
    WHERE AccountID = rec.AccountID;
  END LOOP;

  COMMIT;
END;
/