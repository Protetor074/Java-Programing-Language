package Tools;

import Time.TimeReader;

import java.io.FileNotFoundException;

import static Orders.ReadOrders.*;
import static Orders.ReadOrders.ordersTime;
import static Orders.ReadOrders.reedOrderTime;
import static Time.TimeReader.reedCurentTime;

public class CalculatePrice {
    public static float totalPrice(int orderNumber) throws FileNotFoundException {
        float totalPrice=0;
        float rabat = (float) 0.30;//30%
        if(wantDiscount(orderNumber)==1){
            totalPrice = unRabatPrice(orderNumber) - unRabatPrice(orderNumber)*rabat;
        }else{
            totalPrice = unRabatPrice(orderNumber);
        }
        return totalPrice;
    }

    public static float unRabatPrice(int orderNumber) throws FileNotFoundException {
        float unRabatPrice=0;
        ordersReder();
        for(int i=0;i< orders.size();i++){
            if(orders.get(i)[orders.get(i).length-2]==orderNumber){
                for(int j=0;j<orders.get(i).length-2;j++){
                    unRabatPrice+=FoundPrice.foodPrice(orders.get(i)[j]);
                }
            }
        }
        return unRabatPrice;
    }

    public static int wantDiscount(int orderNumber){
        reedOrderTime();
        int discount=0;//0 - Brak rabatu 1 - Rabat
        int rabatTime = 30;//w minutach
        int timeOrder=0;
        int curentTime=0;
        for(int i = 0; i< ordersTime.size(); i++){
            if(ordersTime.get(i)[0]==orderNumber){
                timeOrder=ordersTime.get(i)[1]*60*60;
                timeOrder+=ordersTime.get(i)[2]*60;
                timeOrder+=ordersTime.get(i)[3];
            }
        }
        reedCurentTime();
        curentTime= TimeReader.curentTime[0]*60*60;
        curentTime+= TimeReader.curentTime[1]*60;
        curentTime+= TimeReader.curentTime[2];

        if(curentTime-(rabatTime*60)>timeOrder){
            discount=1;
        }
        return discount;
    }
}
