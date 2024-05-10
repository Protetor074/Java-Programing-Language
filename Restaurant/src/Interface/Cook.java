package Interface;

/**
 * @author Kamil Gondek
 * Instrukcje:
 *      Kompilacka:
 *          > compile:javac Main.java
 *      Budowanie:
 *          > run: java- jar main.jar
 *      Uruchamianie:
 *          >java -p lab03.jar -m Lab03/Interface.Cook
 *
 */

import Tools.StatusCheck;

import java.io.IOException;
import java.util.Scanner;

import static Time.CookScale.cookScaleCreator;
import static Time.TimeModificator.*;
import static Tools.ChangeStatus.*;
import static Tools.ClearS.clearScreen;
import static Orders.ShowOrders.*;

public class Cook {
    public static void main(String[] args) throws IOException {
        cookApp();
    }

    public static void cookApp() throws IOException {
        cookScaleCreator();
        int choose;
        while(true){
            System.out.println("Lista zamuwien:");
            orderWithStatusShow(0);
            Scanner scan = new Scanner(System.in);
            System.out.println("Wybierz nr. zamuwienia do przygotowania z listy:");//Ustawia status na 1
            choose = scan.nextInt();
            if(StatusCheck.statusCheckInt(choose)==0){
                changeStatus(choose,1);
                preaparOrder((choose));
            }else{
                System.out.println("\nBrak zamuwienia na liscie\n");
            }
            clearScreen();
        }
    }

    public static void preaparOrder(int orderNumber) throws IOException {
        System.out.println("\nWybrales zamuwienie nr." + orderNumber);
        editTime(1);
        showOneOrder(orderNumber);
        int choose=0;
        while(choose==0){
            System.out.println("Czy zamuwienie zostalo zakonczone:");
            System.out.println("1 - Tak / 0 - Nie");
            Scanner scan = new Scanner(System.in);
            choose = scan.nextInt();
            if(choose==1){
                changeStatus(orderNumber,2);
                editTime(2);
            }
        }
    }
}
