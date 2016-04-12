package com.mrsun;

/**
 * https://community.topcoder.com/stat?c=problem_statement&pm=2297&rd=4775
 * @author sundechi
 */
public class BettingMoney {
 
    public int moneyMade(int[] amounts, int[] centsPerDollar, int finalResult){
        
        int profit = 0;
        for(int i = 0; i < amounts.length; i++){
            if( i != finalResult)
                profit += amounts[i];
        }
        
        return profit*100 - (amounts[finalResult] * centsPerDollar[finalResult]);
    }
    
    public static void main(String[] args){
        BettingMoney bm = new BettingMoney();
        int[] amounts = {5000,5000,5000};
        int[] centsPerDollar = {10,10,10};
        int finalResult = 0;
        System.out.println(bm.moneyMade(amounts, centsPerDollar, finalResult));
    }
}
