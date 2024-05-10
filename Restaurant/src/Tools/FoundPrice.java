package Tools;

import Menu.ReadMenu;

import java.io.FileNotFoundException;

import static Menu.ReadMenu.menu;
import static Menu.ReadMenu.readMenuFunction;

public class FoundPrice {
    public static float foodPrice(int foodId) throws FileNotFoundException {
        float foodPrice=0;
        readMenuFunction();

        for(int i=0;i< menu.size();i++){
            if(Integer.valueOf(menu.get(i)[0])==foodId){
                foodPrice=Float.valueOf(menu.get(i)[2]);
            }
        }
        return foodPrice;
    }
}
