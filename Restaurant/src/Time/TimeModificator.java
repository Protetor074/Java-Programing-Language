package Time;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static Time.TimeReader.*;

public class TimeModificator {
    static int reedCookNumbers() throws FileNotFoundException {
        File file = new File("cookScale.txt");
        int cookNumber=1;
        Scanner scan = new Scanner(file);
        while (scan.hasNext()) {
            cookNumber = scan.nextInt();
        }
        return cookNumber;
    }

    static int calculateTimeMove(int cookNumber,int moveType){
        int moveTime=0;
        int timeBase=4;
        if(moveType==1){//przyjencie zamuwienia
            moveTime = timeBase * 60 / cookNumber;
        }else if(moveType==2){//Skonczenie zamuweinia
            moveTime = timeBase / 4 * 60 / cookNumber;
        }
        return moveTime;//second
    }

    public static void editTime(int typeModyficcation) throws IOException {
        reedCurentTime();
        int hour;
        int minute;
        int second;
        int moveTime=calculateTimeMove(reedCookNumbers(),typeModyficcation);
        second=(moveTime+curentTime[2])%60;
        minute=(((moveTime+curentTime[2]-second)/60)+curentTime[1])%60;
        hour=((((moveTime+curentTime[2]-second)/60)+curentTime[1])-minute)/60+curentTime[0];
        reedCurentTime();


        File currentTime = new File("currentTime.txt");
        if (!currentTime.exists()) {
            currentTime.createNewFile();
        }
        if (currentTime.canWrite()) {
            FileWriter fw = new FileWriter(currentTime, false);//Nadpisywanie
            fw.write(hour+";"+minute+";"+second);
            fw.close();
        }


    }




}
