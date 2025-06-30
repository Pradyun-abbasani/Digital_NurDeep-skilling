CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
  INSERT INTO AuditLog (TransactionID, LogDate, Message)
  VALUES (:NEW.TransactionID, SYSDATE, 'Transaction inserted.');
END;
/