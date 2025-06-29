CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_loan_amount    NUMBER,
    p_interest_rate  NUMBER,
    p_years          NUMBER
) RETURN NUMBER IS
    v_monthly_rate   NUMBER;
    v_num_payments   NUMBER;
    v_installment    NUMBER;
BEGIN
    v_monthly_rate := p_interest_rate / 12 / 100;
    v_num_payments := p_years * 12;

    v_installment := (p_loan_amount * v_monthly_rate) /
                     (1 - POWER(1 + v_monthly_rate, -v_num_payments));

    RETURN v_installment;
END;
/
SELECT CalculateMonthlyInstallment(10000, 5, 3) AS Monthly_Installment FROM dual;