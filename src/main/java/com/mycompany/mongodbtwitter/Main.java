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
        if(null != args[0])switch (args[0]) {
            case "getTotalUsers":
                System.out.println("Total amount of users: " + dbl.getTotalUsers());
                break;
            case "getTop10Mentioners":
                System.out.println("Top 10 Mentioners: " + dbl.getTop10Mentioners());
                break;
            case "getTop5Mentioned":
                System.out.println(dbl.getTop5Mentioned());
                break;
            case "getTop10MostActive":
                System.out.println(dbl.getTop10MostActive());
                break;
            case "getTop5Happy":
                System.out.println(dbl.getTop5Happy());
                break;
            case "getTop5Grumpy":
                System.out.println(dbl.getTop5Grumpy());
                break;
            default:
                break;
        }
    }
}
