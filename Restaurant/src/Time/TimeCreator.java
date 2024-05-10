package Time;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static Time.TimeReader.curentTime;
import static Time.TimeReader.reedCurentTime;


public class TimeCreator {

    public static void timeCreator(int orderNumber) throws IOException {
        reedCurentTime();

        File ordersTime = new File("ordersTime.txt");
        if (!ordersTime.exists()) {
            ordersTime.createNewFile();
        }
        if (ordersTime.canWrite()) {
            FileWriter fw = new FileWriter(ordersTime, true);//Dołączanie

            fw.write(orderNumber+";"+curentTime[0]+";"+curentTime[1]+";"+curentTime[2]+";"+Tools.StatusCheck.statusCheckInt(orderNumber)+"\n");
            fw.close();
        }
    }
}
