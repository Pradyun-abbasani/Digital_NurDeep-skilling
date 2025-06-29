BEGIN
  FOR loan_rec IN (SELECT LoanID, InterestRate FROM Loans l JOIN Customers c ON l.CustomerID = c.CustomerID WHERE FLOOR(MONTHS_BETWEEN(SYSDATE, DOB)/12) > 60) LOOP
    UPDATE Loans
    SET InterestRate = InterestRate - 1
    WHERE LoanID = loan_rec.LoanID;
  END LOOP;
  COMMIT;
END;
/