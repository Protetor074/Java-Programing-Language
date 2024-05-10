package Orders;

import java.io.FileNotFoundException;

import static Menu.ReadMenu.*;
import static Orders.ReadOrders.*;

public class ShowOrders {
    public static void orodersShow() throws FileNotFoundException {
        ordersReder();
        for(int i=0;i< orders.size();i++){
            System.out.println("Numer zamuwienia: " + orders.get(i)[orders.get(i).length-2]);
            for(int j=0;j<orders.get(i).length-2;j++){
                System.out.println(foundFood(orders.get(i)[j]));
            }
            System.out.println();
        }
    }

    public static void orderWithStatusShow(int Status) throws FileNotFoundException {
        ordersReder();
        for(int i=0;i< orders.size();i++){
            if(orders.get(i)[orders.get(i).length-1]==Status){
                System.out.println("Numer zamuwienia: " + orders.get(i)[orders.get(i).length-2]);
                for(int j=0;j<orders.get(i).length-2;j++){
                    System.out.println(foundFood(orders.get(i)[j]));
                }
                System.out.println();
            }
        }

    }

    static String foundFood(int foodChoose) throws FileNotFoundException {
        readMenuFunction();
        String foodName=null;
        for(int i=0;i< menu.size();i++){
            if(Integer.valueOf(menu.get(i)[0])==foodChoose){
                foodName = menu.get(i)[1];
            }
        }
        return foodName;
    }

    public static void showOneOrder(int orderNumber) throws FileNotFoundException {
        ordersReder();
        for(int i=0;i<orders.size();i++){
            if(orders.get(i)[orders.get(i).length-2]==orderNumber){
                for(int k=0;k<orders.get(i).length-2;k++){
                    System.out.println(foundFood(orders.get(i)[k]));
                }
            }
        }

    }
}
