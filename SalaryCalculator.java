import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

class BasicInfo
{
    double basicpayment;
    int age;
    int retirementage = 55;
    public double getbasicpayment() 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter Basic payment of employee : ");
        basicpayment = sc.nextDouble(); 
        System.out.print("Enter Age of employee           : ");
        age = sc.nextInt();
        System.out.println();
        return basicpayment;
    }
}

class Allowance extends BasicInfo
{
    Allowance()
    {
        getbasicpayment();
        if(basicpayment>=4500 && basicpayment<=6500 && age>=18)
        {
            double ta = 0.02 * basicpayment;
            double da = 0.02 * basicpayment;
            double hra = 0.03 * basicpayment;
            double pf = 0.005 * basicpayment;
            System.out.println("Employee's Travel Allowance (TA)     : "+ta+" Rupees");
            System.out.println("Employee's Dearness Allowance (DA)   : "+da+" Rupees");
            System.out.println("Employee's House Rent Allowance (HRA): "+hra+" Rupees");
            System.out.println("Employee's Profitable Fund           : "+pf+" Rupees");
            professionalTax(totalsalary());
            retirementdate(age,retirementage);
        }

        else
        {
            if(basicpayment<4500 || basicpayment>6500)
            {
                System.out.println("Basic Payment should be only in 4500 and 6500 ");
            }
            if(age<18)
            {
                System.out.println("Age Should Above 18 years");
            }   
            System.out.println("Please enter valid values again.");
        }
    }

    double totalsalary()
    {
        double totalsalary = 12 * basicpayment;
        System.out.println("Total Salary of employee             : "+totalsalary+" Rupees");
        return totalsalary;
    }

    void professionalTax(double totalsalary) 
    {
        double threshold = 10000;
        if (totalsalary > threshold) 
        {
            totalsalary = totalsalary - 1000;
            System.out.println();
            System.out.println("Profeesional tax of 1000 rupees deducted........");
            System.out.println();
            System.out.println("Total Salary after deduction of professional tax :"+totalsalary);
            System.out.println();
        } 
        else 
        {
            System.out.println("No Professional Tax Deduction.");
        }
    }

    void retirementdate(int age,int retirementage)
    {
        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = currentDate.minusYears(age);
        LocalDate retirementDate = birthDate.plusYears(retirementage);
        System.out.println("Current Date: " + currentDate);
        System.out.println("Date of Birth: " + birthDate);
        System.out.println("Retirement Age: " + retirementage + " years");
        System.out.println("Retirement Date: " + retirementDate);
        System.out.println();
    }

}

public class SalaryCalculator 
{
    public static void main(String args[])
    {
        Allowance a = new Allowance();
    }
}