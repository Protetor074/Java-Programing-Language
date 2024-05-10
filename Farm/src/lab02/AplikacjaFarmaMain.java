package lab02;
import java.io.FileNotFoundException;

import static java.lang.System.currentTimeMillis;
import static model.Animal.*;
import static model.Farm.initializationFarm;
import static model.Food.initializationFood;
import static tools.Assignment.simulation;

/**
 * @author Kamil Gondek
 * Instrukcje:
 *      Kompilacka:
 *          > compile:javac Main.java
 *      Budowanie:
 *          > run: java- jar main.jar
 *      Uruchamianie:
 *          >java -jar lab02.jar
 */
public class AplikacjaFarmaMain {
    public static void main(String[] args) throws FileNotFoundException {
        long start= currentTimeMillis();

        initializationAnimal("Animal.txt");
        initializationFarm("Farm.txt");
        initializationFood("Food.txt");

        simulation();

        long stop= currentTimeMillis();
        System.out.println("\nCzas wykonania:"+(stop-start) + " ms");

    }
}
