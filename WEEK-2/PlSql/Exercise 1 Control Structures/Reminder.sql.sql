DECLARE
BEGIN
  FOR loan_rec IN (
    SELECT LoanID, CustomerID, EndDate
    FROM Loans
    WHERE EndDate BETWEEN SYSDATE AND SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE(
      'Reminder: Loan ' || loan_rec.LoanID ||
      ' for Customer ' || loan_rec.CustomerID ||
      ' is due on ' || TO_CHAR(loan_rec.EndDate, 'YYYY-MM-DD')
    );
  END LOOP;
END;
/