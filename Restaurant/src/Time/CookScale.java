package Time;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CookScale {
    public static void cookScaleCreator() throws IOException {
        int choose=0;
        while(choose<=0){
            System.out.println("Podaj aktualna liczbe kucharzy na kuchni:");
            Scanner scan = new Scanner(System.in);
            choose = scan.nextInt();
            if(choose<=0){
                System.out.println("Wartosc zabroniona!!");
            }
        }
        File cookScale = new File("cookScale.txt");
        if (!cookScale.exists()) {
            cookScale.createNewFile();
        }
        if (cookScale.canWrite()) {
            FileWriter fw = new FileWriter(cookScale, false);//Nadpisywanie
            fw.write(choose+"");
            fw.close();
        }
    }
}
