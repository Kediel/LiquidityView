package com.example.liquidityview;

public class FinancialCalculations {

    // The amount of money the student is starting with.
    private double Student_D;
    private double CLoan_D;
    private double CCard_D;
    private double Invest_D;

    private double sLoan;
    private double cLoan;
    private double cCard;
    private double invest;

    double Debt(){
        // Finish me
        
        double Student_D = 1200;
        double CLoan_D = 300;
        double CCard_D = 800;
        double Invest_D = 200;

        Loans();

        double final_debt = Student_D + CLoan_D + CCard_D + Invest_D;

        // Fix return statement
        return final_debt;
    }

    double Interest(){
        // Finish me
        // APR for student loans is 3%
        double sLoan = 0.03;
        // APR for car loan is 12%
        double cLoan = 0.12;
        // APR for credit cards are 23.9%
        double cCard = 0.239;
        // Investment accounts gain 6% annually on average after inflation
        double invest = 0.06;

        double final_interest = 0.0;

        // Fix return statement
        return final_interest;
        
    }

    double Loans(){
        // Finish me
        double TotalLoan = (Student_D * sLoan) + (CLoan_D*CLoan_D) + (CCard_D * cCard) + (Invest_D * invest);


        // Fix return statement
        return TotalLoan;
    }

    double Insurance(){
        // Finish me
        double carInsurance = 400;
        double HealthInsurance = 200;
        double final_loans = 0.0;

        // Fix return statement
        return final_loans;
    }

    double Retirement(){

        // Finish me
        double Retirement = 0;

        double final_retirement = 0.0;

        // Fix return statement
        return final_retirement;
    }

    double Taxes(){
        // Finish me
        // 7.65% goes to Social Security/ Medicare until you reach 127k.
        double ssMedicare = 0.0765;
        // Most states have an income tax of 6%
        double iTax = 0.06;

        double final_taxes = 0.0;

        // Fix return statement
        return final_taxes;

    }
    
    

}
