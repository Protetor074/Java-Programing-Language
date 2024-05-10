package Orders;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadOrders {

    public static ArrayList<int[]> orders = new ArrayList<>();
    public static ArrayList<int[]> ordersTime = new ArrayList<>();

    public static int ordersReder() throws FileNotFoundException {
        int size=0;
        orders.clear();
        File file = new File("orders.txt");
        try(Scanner scan = new Scanner(file)){
            while (scan.hasNext()) {
                String line;
                line = scan.next();
                String[] orderLine;
                orderLine = line.split(";");
                int[] tabOrders = new int[orderLine.length];
                for(int i=0;i<orderLine.length;i++){
                    tabOrders[i]= Integer.valueOf(orderLine[i]);
                    //System.out.println(tabOrders[i]);
                }
                orders.add(tabOrders);
            }
            size = orders.size()-1;
        }catch (FileNotFoundException e){
            System.out.println("Plik orders nie istnieje");
        }
        return size;
    }

    public static void reedOrderTime() {//zwraca czas zamuwienia w sekundach
        int size = 0;
        ordersTime.clear();
        File file = new File("ordersTime.txt");
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNext()) {
                String line;
                line = scan.next();
                String[] orderLine;
                orderLine = line.split(";");
                int[] tabOrdersTime = new int[orderLine.length];
                for (int i = 0; i < orderLine.length; i++) {
                    tabOrdersTime[i] = Integer.valueOf(orderLine[i]);
                }
                ordersTime.add(tabOrdersTime);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Plik orders nie istnieje");
        }
    }
}
