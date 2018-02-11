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
                System.out.println("");
                System.out.println("\n" + "Total amount of users: " + dbl.getTotalUsers());
                break;
            case "getTop10Mentioners":
                System.out.println("\n" + "Top 10 Mentioners: " + dbl.getTop10Mentioners());
                break;
            case "getTop5Mentioned":
                System.out.println("\n" + "Top 5 Mentioned users: "+dbl.getTop5Mentioned());
                break;
            case "getTop10MostActive":
                System.out.println("\n" + "Top 10 most active users" + dbl.getTop10MostActive());
                break;
            case "getTop5Happy":
                System.out.println("\n" + "Top 5 happy users" + dbl.getTop5Happy());
                break;
            case "getTop5Grumpy":
                System.out.println("\n" + "Top 5 grumpy users" + dbl.getTop5Grumpy());
                break;
            default:
                break;
        }
    }
}
