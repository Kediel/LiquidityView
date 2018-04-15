package com.example.liquidityview;

public class FinancialCalculations {

    // The amount of money the student is starting with.
    double principal = 0.0;
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
        
        Object Student_D = 20000;
        Object CLoan_D = 12000;
        Object CCard_D = 1000;
        Object Invest_D = 900;

        Loans();

        double final_debt = 0.0;

        // Fix return statement
        return final_debt;
    }

    double Interest(){
        // Finish me
        // APR for student loans is 3%
        Object sLoan = 0.03;
        // APR for car loan is 12%
        Object cLoan = 0.12;
        // APR for credit cards are 23.9%
        Object cCard = 0.239;
        // Investment accounts gain 6% annually on average after inflation
        Object invest = 0.06;

        double final_interest = 0.0;

        // Fix return statement
        return final_interest;
        
    }

    double Loans(){
        // Finish me
        Object StudentLoan = (Student_D * sLoan) + (CLoan_D*CLoan_D) + (CCard_D * cCard) + (Invest_D * invest);
    }

    double Insurance(){
        // Finish me
        Object carInsurance = 400;
        Object HealthInsurance = 200;
        double final_loans = 0.0;

        // Fix return statement
        return final_loans;
    }

    double Retirement(){

        // Finish me
        Object Retirement = 0;

        double final_retirement = 0.0;

        // Fix return statement
        return final_retirement;
    }

    double Taxes(){
        // Finish me
        // 7.65% goes to Social Security/ Medicare until you reach 127k.
        Object ssMedicare = 0.0765;
        // Most states have an income tax of 6%
        Object iTax = 0.06;

        double final_taxes = 0.0;

        // Fix return statement
        return final_taxes;

    }
    
    

}
