CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
  v_balance NUMBER;
BEGIN
  -- Withdrawal validation
  IF :NEW.TransactionType = 'Withdrawal' THEN
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = :NEW.AccountID;

    IF :NEW.Amount > v_balance THEN
      RAISE_APPLICATION_ERROR(-20003, 'Withdrawal exceeds account balance.');
    END IF;
  END IF;

  -- Deposit validation
  IF :NEW.TransactionType = 'Deposit' THEN
    IF :NEW.Amount <= 0 THEN
      RAISE_APPLICATION_ERROR(-20004, 'Deposit amount must be positive.');
    END IF;
  END IF;
END;
/