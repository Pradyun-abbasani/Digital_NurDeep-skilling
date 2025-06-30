DECLARE
  CURSOR c_transactions IS
    SELECT a.CustomerID,
           t.TransactionID,
           t.TransactionDate,
           t.Amount,
           t.TransactionType
      FROM Transactions t
      JOIN Accounts a
        ON t.AccountID = a.AccountID
     WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
       AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM SYSDATE);

BEGIN
  FOR rec IN c_transactions LOOP
    DBMS_OUTPUT.PUT_LINE(
      'Customer ID: ' || rec.CustomerID ||
      ', Transaction ID: ' || rec.TransactionID ||
      ', Date: ' || TO_CHAR(rec.TransactionDate, 'YYYY-MM-DD') ||
      ', Amount: ' || rec.Amount ||
      ', Type: ' || rec.TransactionType
    );
  END LOOP;
END;
/