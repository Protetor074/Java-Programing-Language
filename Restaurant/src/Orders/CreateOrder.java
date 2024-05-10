package Orders;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static Menu.ReadMenu.*;
import static Orders.ReadOrders.*;

public class CreateOrder {

    public static void orderCreator() throws IOException {
        System.out.println("Prosze podac nr. dania które chce Pan/Pani zamowic:");
        System.out.println("Uwaga! Karżdy wybur zatwierdzamu i dopiero podajemy następny.");
        System.out.println("Uwaga! Aby zakończyć zamówenie należy wprowadzic 0.");
        Integer choose=1;
        ArrayList<Integer> foodNumberOrder = new ArrayList<>();
        int menuSize = Integer.valueOf(menu.get(menu.size()-1)[0]);
        while(choose!=0){
            Scanner scan = new Scanner(System.in);
            choose = scan.nextInt();
            if(menuSize>=choose && choose>0) {
                System.out.println("Zamuwiono danie :" + choose);
                foodNumberOrder.add(choose);
            }else if(choose==0){
                System.out.println("Koniec zamuwienia");
                saveOrder(foodNumberOrder);
            }else{
                System.out.println("Brak takiego dania w karcie.");
            }
        }
    }

    static void saveOrder(ArrayList<Integer> order) throws IOException {
        //int orderId = ordersReder()+2;
        ordersReder();
        int nrOrder = 1;
        try{
            int size= orders.size()-1;
            int lenght = orders.get(size).length-1;
            nrOrder = orders.get(size)[lenght-1]+1;
        }catch (Exception e){}

        System.out.println("Twój nr. to: " + nrOrder);
        File orders = new File("orders.txt");
        if(!orders.exists()){
            orders.createNewFile();
        }
        if(orders.canWrite()){
            FileWriter fw = new FileWriter(orders,true);//Dołączanie
            //fw.write(orderId+"");
            for(int i=0;i<order.size();i++){
                fw.write(order.get(i)+";");
            }
            fw.write( nrOrder + ";0" +"\n");
            fw.close();
            Time.TimeCreator.timeCreator(nrOrder);
        }
    }
}
