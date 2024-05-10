package tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Scaning {
    public static ArrayList<Integer[]> scan_File(String Path) throws FileNotFoundException {
        File file = new File(Path);

        ArrayList<Integer[]> result = new ArrayList<>();

        Scanner scan = new Scanner(file);
        while(scan.hasNext()){
            String line;
            line=scan.next();
            String[] sNumb;
            sNumb = line.split(";");
            Integer[] number = new Integer[sNumb.length];
            for(int i=0;i<sNumb.length;i++){
                number[i] = Integer.valueOf(sNumb[i]);
            }
            result.add(number);
        }
        return result;
    }


}
