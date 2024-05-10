package Tools;

import java.io.IOException;

import static Orders.ReadOrders.*;
import static Time.TimeReader.*;
import static Tools.RefreshData.refresh;

public class ChangeStatus {
    public static void changeStatus(int orderNumber,int newStatus) throws IOException {
        ordersReder();
        for(int i = 0; i< orders.size(); i++){
            if(orders.get(i)[orders.get(i).length-2]==orderNumber){
                orders.get(i)[orders.get(i).length-1]=newStatus;
                changeStatusTimeOrder(orderNumber,newStatus);
            }
        }
        refresh();
    }


    static void changeStatusTimeOrder(int orderNumber,int newStatus){
        timeReader();
        for(int i=0;i< timeOrders.size();i++){
            if(timeOrders.get(i)[0]==orderNumber){
                timeOrders.get(i)[4]=newStatus;
            }
        }

    }
}
