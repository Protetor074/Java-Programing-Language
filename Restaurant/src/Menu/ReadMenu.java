package Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadMenu {
    static String[] foodAndPrice = new String[3];
    public static ArrayList<String[]> menu = new ArrayList<>();

    public static void readMenuFunction() throws FileNotFoundException {
        menu.clear();
        File file = new File("menu.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNext()) {
            String line;
            line = scan.next();
            String[] menuLine;
            menuLine = line.split(";");
            foodAndPrice[0]=menuLine[0];
            foodAndPrice[2]=menuLine[2];
            splitFoodName(menuLine[1]);
        }
    }

    static void splitFoodName(String foodName) {
        String Food_Name[];
        String Food = "";

        try{
            Food_Name = foodName.split("_");
            for (int i = 0; i < Food_Name.length; i++) {
                Food = Food + " " + Food_Name[i];
            }
            foodAndPrice[1] = Food;
        }catch(NullPointerException e){
            foodAndPrice[1]=foodName;
        }
        String[] tab = new String[3];
        tab[0]=foodAndPrice[0];
        tab[1]=foodAndPrice[1];
        tab[2]=foodAndPrice[2];
        menu.add(tab);
    }
}
