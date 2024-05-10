package Menu;

import static Menu.ReadMenu.*;

public class ShowMenu {
    public static void showMenu(){
        System.out.println();
        for(int i = 0; i< menu.size(); i++){
            System.out.println(menu.get(i)[0] + " " + menu.get(i)[1] + " " + menu.get(i)[2] );
        }
    }
}
