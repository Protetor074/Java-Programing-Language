package Tools;

import Orders.ReadOrders;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import static Orders.ReadOrders.*;

public class DelletOrder {
    public static void dellet(int orderNumber) throws IOException {
        ordersReder();
        reedOrderTime();
        FileWriter fwOrders = new FileWriter("orders.txt",false);
        FileWriter fwOrdersTime = new FileWriter("ordersTime.txt",false);
        for(int i=0;i<ordersTime.size();i++){
            if(orderNumber!=ordersTime.get(i)[0]){
                for(int j=0;j<orders.get(i).length;j++){
                    fwOrders.write(ReadOrders.orders.get(i)[j]+";");
                }
                for(int j=0;j<ordersTime.get(i).length;j++){
                    fwOrdersTime.write(ReadOrders.ordersTime.get(i)[j]+";");
                }
                fwOrders.write("\n");
                fwOrdersTime.write("\n");
            }
        }
        fwOrders.close();
        fwOrdersTime.close();
    }
}
