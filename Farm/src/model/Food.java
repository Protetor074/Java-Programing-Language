package model;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static tools.Scaning.*;

public class Food {

    public static ArrayList<Integer[]> food = new ArrayList<>();

    public static void initializationFood(String path) throws FileNotFoundException {
        System.out.println("Initialization Food...");
        food = scan_File(path);
    }
}
