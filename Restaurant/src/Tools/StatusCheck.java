package Tools;

import java.io.FileNotFoundException;

import static Orders.ReadOrders.orders;
import static Orders.ReadOrders.ordersReder;

public class StatusCheck {
    public static String statusCheckString(int orderNumber) throws FileNotFoundException {
        ordersReder();
        String status = "ERROR";
        int lenght;
        for(int i=0;i< orders.size();i++){
            lenght = orders.get(i).length-1;
            if(orderNumber==orders.get(i)[lenght-1]){
                switch (orders.get(i)[lenght]){
                    case 0:
                        status = "Zamuwione.";
                        break;
                    case 1:
                        status = "W trakcie realizacji.";
                        break;
                    case 2:
                        status = "Gotowe do odbioru.";
                        break;
                    case 3:
                        status = "W sprzedarzy.";
                }
                break;
            }
        }
        return status;
    }

    public static int statusCheckInt(int orderNumber) throws FileNotFoundException {
        ordersReder();
        int status = -1;
        int lenght;
        for(int i=0;i< orders.size();i++){
            lenght = orders.get(i).length-1;
            if(orderNumber==orders.get(i)[lenght-1]){
                status=orders.get(i)[lenght];
            }
        }
        return status;
    }
}
