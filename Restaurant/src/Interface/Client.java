package Interface;

/**
 * @author Kamil Gondek
 * Instrukcje:
 *      Kompilacka:
 *          > compile:javac Main.java
 *      Budowanie:
 *          > run: java- jar main.jar
 *      Uruchamianie:
 *          >java -p lab03.jar -m Lab03/Interface.Client
 *
 */

import Tools.StatusCheck;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static Tools.ClearS.clearScreen;
import static Orders.CreateOrder.*;
import static Menu.ReadMenu.*;
import static Menu.ShowMenu.*;


public class Client {
    public static void main(String[] args) throws IOException {
        clientApp();
    }

    public static void clientApp() throws IOException {
        int choose;
        while(true){
            System.out.println("\nWybierz co chcesz zrboić:");
            System.out.println("1.Stwórz nowe zamówienie.");
            System.out.println("2.Sprawdź status aktualnego zamówienia.");
            Scanner scan = new Scanner(System.in);
            choose = scan.nextInt();
            switch (choose){
                case 1:
                    orderGenerator();
                    break;
                case 2:
                    StatusOfOrder();
                    break;
            }
            clearScreen();
        }
    }

    static void orderGenerator() throws IOException {

        readMenuFunction();
        showMenu();
        orderCreator();
    }

    static void StatusOfOrder() throws FileNotFoundException {
        System.out.println("\nPoadaj numer zamówienia:");
        int choose;
        Scanner scan = new Scanner(System.in);
        choose = scan.nextInt();
        System.out.println("\nZamowienia nr " + choose + " ma status " + StatusCheck.statusCheckString(choose)+"\n");
    }

}
