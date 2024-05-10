package model;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static tools.Scaning.*;

public class Animal {

    public static ArrayList<Integer[]> animal = new ArrayList<>();

    public static void initializationAnimal(String path) throws FileNotFoundException {
        System.out.println("Initialization Animal...");
        animal = scan_File(path);
        }
    }
