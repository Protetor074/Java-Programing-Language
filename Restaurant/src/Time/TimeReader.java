package Time;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TimeReader {

    public static ArrayList<int[]> timeOrders = new ArrayList<>();
    public static Integer[] curentTime = new Integer[3];

    public static void timeReader(){
        timeOrders.clear();
        File file = new File("ordersTime.txt");
        try(Scanner scan = new Scanner(file)){
            while (scan.hasNext()) {
                String line;
                line = scan.next();
                String[] orderTimeLine;
                orderTimeLine = line.split(";");
                int[] tabOrders = new int[orderTimeLine.length];
                for(int i=0;i<orderTimeLine.length;i++){
                    tabOrders[i]= Integer.valueOf(orderTimeLine[i]);
                    //System.out.println(tabOrders[i]);
                }
                timeOrders.add(tabOrders);
            }
        }catch (FileNotFoundException e){
            System.out.println("Plik orders nie istnieje");
        }
    }

    public static void reedCurentTime(){
        File file = new File("currentTime.txt");
        try(Scanner scan = new Scanner(file)){
            String line;
            line = scan.next();
            String[] orderLine;
            orderLine = line.split(";");
            for(int i=0;i<3;i++){
                curentTime[i]=Integer.valueOf(orderLine[i]);
            }
        }catch (FileNotFoundException e){
            System.out.println("Plik orders nie istnieje");
        }
    }

}
