package Interface;

/**
 * @author Kamil Gondek
 * Instrukcje:
 *      Kompilacka:
 *          > compile:javac Main.java
 *      Budowanie:
 *          > run: java- jar main.jar
 *      Uruchamianie:
 *          >java -p lab03.jar -m Lab03/Interface.Seller
 *
 */

import Tools.StatusCheck;

import java.io.IOException;
import java.util.Scanner;

import static Orders.ShowOrders.*;
import static Orders.ShowOrders.orderWithStatusShow;
import static Tools.ChangeStatus.*;
import static Tools.ClearS.clearScreen;
import static Tools.DelletOrder.dellet;

public class Seller {
    public static void main(String[] args) throws IOException {
        sellerApp();
    }

    public static void sellerApp() throws IOException {
        int choose;
        Scanner scan = new Scanner(System.in);
        while(true){
            orderWithStatusShow(2);

            System.out.println("Jesli niema zadnego zamuwienia na liscie zadne zamuwienie nie jest jeszcze gotowe.");
            System.out.println("Wybierz zamuwienie do odbioru.");

            choose = scan.nextInt();
            if(StatusCheck.statusCheckInt(choose)==2){
                showOneOrder(choose);
                int choose2=0;
                changeStatus(choose,3);
                System.out.println("Do zaplaty: "+ Tools.CalculatePrice.totalPrice(choose));
                System.out.println("Czy zamuwienie zostalo oplacone:");
                System.out.println("1 - Tak / 0 - Nie ");
                choose2 = scan.nextInt();
                if(choose2==1){
                    dellet(choose);
                }else if(choose2==0){
                    changeStatus(choose2,2);
                }
            }else{
                System.out.println("Niema takiego zamuwienia badz nie jest jeszcze gotowe.\n");
            }
            clearScreen();
        }
    }

    static void whetherPaid(){
        int choose;
        Scanner scan = new Scanner(System.in);
        System.out.println("Czy zaplacono:");
        System.out.println("1 - Tak. / 2 - Nie.");
        choose = scan.nextInt();
        if(choose==1){//zapłacono
            //Usun zamuwienie
        }
    }

}
