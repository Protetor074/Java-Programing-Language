package tools;

import model.Animal;

import java.util.ArrayList;

import static model.Farm.farm;
import static model.Food.food;
import static tools.CombinationWizard.*;
import static tools.CombinationWizard.combinationAnimal;


public class Assignment {


    public static Integer[] bestResult = new Integer[farm.size() + 2];
    static Integer[] farmAnimals = new Integer[farm.size() + 1];
    static ArrayList<Integer[]> farmClone = new ArrayList<>();

    public static void simulation() {//Sumulacja

        comboWizard(Animal.animal.size());//Przypisanie kombinacji zwierząt

        System.out.println(Combination.size());
        for (int animalComb = 0; animalComb < combinationAnimal.size(); animalComb++) {
            farmClone();
            matching(animalComb);
            results();
        }

        //Wyniki
        System.out.println("Najmniejszy niewykorzystany potencjał to: " + bestResult[0]);
        for (int i = 0; i < farm.size(); i++) {
            System.out.println("Do Farmy nr." + (i + 1) + " przypisano zwierzęta o id :" + bestResult[i + 1]);
        }


    }

    static void farmClone() {
        farmClone.removeAll(farmClone);
        for (Integer[] integers : farm) {
            Integer[] tab = new Integer[farm.get(0).length];
            System.arraycopy(integers, 0, tab, 0, farm.get(0).length);
            farmClone.add(tab);
        }
    }

    static void results() {
        if (bestResult[0] == null) {
            bestResult[0] = potential();
            System.arraycopy(farmAnimals, 0, bestResult, 1, farm.size());
        } else {
            if (bestResult[0] > potential()) {
                bestResult[0] = potential();
                System.arraycopy(farmAnimals, 0, bestResult, 1, farm.size());
            }
        }
    }

    static int potential() {
        int potential = 0;
        for (int i = 0; i < farm.size(); i++) {
            for (int j = 1; j < farmClone.get(0).length; j++) {
                potential = potential + farmClone.get(i)[j];
            }
        }
        return potential;
    }

    static void notWriteAnimals(int animalComb) {
        for (int i = 0; i < combinationAnimal.get(animalComb).length; i++) {
            if (combinationAnimal.get(animalComb)[i] != -1) {
                if (farmAnimals[farm.size()] != null) {
                    farmAnimals[farm.size()] = farmAnimals[farm.size()] * 10 + combinationAnimal.get(animalComb)[i];
                } else {
                    farmAnimals[farm.size()] = combinationAnimal.get(animalComb)[i];
                }
            }
        }
    }

    static void addAnimalToFarm(int farmId, int animalId) {
        if (farmAnimals[farmId] != null) {
            farmAnimals[farmId] = farmAnimals[farmId] * 10 + animalId;
        } else {
            farmAnimals[farmId] = animalId;
        }
    }

    static void removeAnimal(int animalIdRemove, int Combination_Id) {
        Integer[] tab = new Integer[combinationAnimal.get(Combination_Id).length];
        for (int i = 0; i < combinationAnimal.get(Combination_Id).length; i++) {
            if (animalIdRemove != combinationAnimal.get(Combination_Id)[i]) {
                tab[i] = combinationAnimal.get(Combination_Id)[i];
            } else {
                tab[i] = -1;
            }
        }
        combinationAnimal.set(Combination_Id, tab);
    }


    static void matching(int animalComb) {//Dobiera karzde zwierzę do karzdej farmy
        int animalType;
        int animalId;

        for (int farmId = 0; farmId < farm.size(); farmId++) {
            for (int Animal_id = 0; Animal_id < Combination.get(animalComb).size(); Animal_id++) {
                animalId = combinationAnimal.get(animalComb)[Animal_id] - 1;
                if (animalId != -2) {// -2 bo linijka wyżej odejmujemy 1
                    animalType = Animal.animal.get(animalId)[1];
                    if (tryMatch(animalType, farmId) == 1) {
                        calculateFarmFood(animalType, farmId);
                        removeAnimal(animalId + 1, animalComb);
                        addAnimalToFarm(farmId, animalId + 1);
                    }
                }
            }
        }
        notWriteAnimals(animalComb);
    }

    static void calculateFarmFood(int animalType, int farmId) {

        for (int j = 0; j < food.size(); j++) {
            if (animalType == food.get(j)[0]) {
                for (int i = 1; i <= farmClone.get(0).length - 1; i++) {
                    farmClone.get(farmId)[i] = farmClone.get(farmId)[i] - food.get(i + j - 1)[2];
                }
                break;
            }
        }
    }

    static int tryMatch(int animalType, int farmId) {
        int pass = 0;
        int passComplite = 0;
        for (int j = 0; j < food.size(); j++) {
            if (animalType == food.get(j)[0]) {
                for (int i = 1; i <= farmClone.get(0).length - 1; i++) {
                    if (farmClone.get(farmId)[i] >= food.get(i + j - 1)[2]) {
                        pass++;
                    }
                }
                break;
            }
        }

        if (pass == farmClone.get(0).length - 1) {
            passComplite = 1;
        }

        return passComplite;
    }
}
