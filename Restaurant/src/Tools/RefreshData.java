package Tools;

import Orders.ReadOrders;
import Time.TimeReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static Time.TimeReader.timeOrders;

public class RefreshData {
    public static void refresh() throws IOException {
        FileWriter fwOrders = new FileWriter("orders.txt",false);

        FileWriter fwOrdersTime = new FileWriter("ordersTime.txt",false);

        for(int i = 0; i< ReadOrders.orders.size(); i++){
            for(int j = 0; j< ReadOrders.orders.get(i).length; j++){
                fwOrders.write(ReadOrders.orders.get(i)[j]+";");
            }
            for(int j=0;j< timeOrders.get(i).length;j++){
                fwOrdersTime.write(timeOrders.get(i)[j]+";");
            }
            fwOrders.write("\n");
            fwOrdersTime.write("\n");
        }
        fwOrders.close();
        fwOrdersTime.close();
    }
}
