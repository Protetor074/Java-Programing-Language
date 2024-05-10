package tools;

import java.util.ArrayList;
import java.util.Collections;

public class CombinationWizard {
    static ArrayList<Integer> numberArray = new ArrayList<>();
    static ArrayList<Integer> oppositeNumberArray = new ArrayList<>();
    static ArrayList<Integer> freeNumber = new ArrayList<>();
    public static ArrayList<ArrayList> Combination = new ArrayList<>();
    public static ArrayList<Integer[]> combinationAnimal = new ArrayList<>();

    public static void comboWizard(int maxLevel) {//Wyznacza wszystkie możliwe kombinacje kolejności
        System.out.println("Callculation all combination...");
        foundAllCombination(maxLevel);
    }

    static int similarList(int maxLevel) {//Sprawdza czy osiągnięto odwrotność początkowej listy czyli koniec.
        int notFinish = 1;// 0  identyczne / 1 nie są identyczne
        int correct = 0;
        for (int i = 0; i < maxLevel; i++) {

            if (oppositeNumberArray.get(i).equals(numberArray.get(i))) {
                correct++;
            }
        }
        if (correct == maxLevel) {
            notFinish = 0;
        }
        return notFinish;
    }


    static void foundAllCombination(int maxLevel) {//Liczy wszystkie kombinacje
        numberCreate(maxLevel);
        createOppositeNumber(maxLevel);
        Combination.add(numberArray);
        Integer[] tab = new Integer[numberArray.size()];
        for (int i = 0; i < numberArray.size(); i++) {
            tab[i] = numberArray.get(i);
        }
        combinationAnimal.add(tab);
        int notFinish;

        do {
            repeatToFind();
            Integer[] tab2 = new Integer[numberArray.size()];
            Combination.add(numberArray);
            for (int i = 0; i < numberArray.size(); i++) {
                tab2[i] = numberArray.get(i);
            }
            combinationAnimal.add(tab2);
            notFinish = similarList(maxLevel);
        } while (notFinish == 1);
    }

    static void createOppositeNumber(int maxLevel) {//Ostatnią kombinację
        for (int i = maxLevel; i > 0; i--) {
            oppositeNumberArray.add(i);
        }
    }

    static void repeatToFind() {//usuwa ostatnią liczbę i szuka możliewj do zamiany
        int findNumber;
        do {
            removeLastNumber();
            findNumber = foundChangeToGreaterValue();
        } while (findNumber != 1);
        addNumber();

    }

    static void addNumber() {//Uzupelnia liczbę
        Collections.sort(freeNumber);
        while (freeNumber.size() != 0) {
            numberArray.add(freeNumber.get(0));
            freeNumber.remove(0);
        }
    }

    static int foundChangeToGreaterValue() {//Szuka większej z pośrud dostempnych
        int free_number_sieze = freeNumber.size();
        Collections.sort(freeNumber);
        int confirmTask = 0;//0 - Nie zmieniono wartości 1 - zmieniono wartość
        for (int i = 0; i < free_number_sieze; i++) {
            if (numberArray.get(numberArray.size() - 1) < freeNumber.get(i)) {
                int change_vlaue = freeNumber.get(i);
                freeNumber.remove(i);
                freeNumber.add(numberArray.get(numberArray.size() - 1));
                numberArray.remove(numberArray.size() - 1);
                numberArray.add(change_vlaue);
                confirmTask = 1;
                break;
            }
        }
        return confirmTask;
    }

    static void removeLastNumber() {//Usuwa ostatnią liczbę
        freeNumber.add(numberArray.get(numberArray.size() - 1));
        numberArray.remove(numberArray.size() - 1);
    }

    static void numberCreate(int maxLevel) {//Tworzy liczbę początkową
        for (int i = 1; i <= maxLevel; i++) {
            numberArray.add(i);
        }
    }

}
