import java.util.*;

public class FinancialForecast {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        //System.out.print("Enter present value: ");
        double pv=sc.nextDouble();
        //System.out.print("Enter annual growth rate (in %): ");
        double rate=sc.nextDouble()/100;
        //System.out.print("Enter number of years: ");
        int years=sc.nextInt();
        double futureVal=futureVal(pv,rate,years);
        System.out.println("Future Value: "+futureVal);
    }

    public static double futureVal(double pv,double rate,int years){
        if(years==0)return pv;
        return (1+rate)*futureVal(pv,rate,years-1);
    }
}
