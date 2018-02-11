/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mongodbtwitter;



/**
 *
 * @author florenthaxha
 */
public class Main {
    public static void main(String[] args) {
        DBLogic dbl = new DBLogic();
        if("getTotalUsers".equals(args[0])){
            System.out.println("Total amount of users: " + dbl.getTotalUsers());
        }else if("getTop10Mentioners".equals(args[0])){
            System.out.println("Top 10 Mentioners: " + dbl.getTop10Mentioners());
        }else if("getTop5Mentioned".equals(args[0])){
            System.out.println(dbl.getTop5Mentioned());
        }else if("getTop10MostActive".equals(args[0])){
            System.out.println(dbl.getTop10MostActive());
        }else if("getTop5Happy".equals(args[0])){
            System.out.println(dbl.getTop5Happy());
        }else if("getTop5Grumpy".equals(args[0])){
            System.out.println(dbl.getTop5Grumpy());
        }
    }
}
