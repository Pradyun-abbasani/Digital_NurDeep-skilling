DECLARE
  CURSOR c_loans IS
    SELECT LoanID, InterestRate FROM Loans;
BEGIN
  FOR rec IN c_loans LOOP
    UPDATE Loans
    SET InterestRate = rec.InterestRate + 0.5
    WHERE LoanID = rec.LoanID;
  END LOOP;

  COMMIT;
END;
/