package model;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static tools.Scaning.*;

public class Farm {

    public static ArrayList<Integer[]> farm = new ArrayList<>();

    public static void initializationFarm(String path) throws FileNotFoundException {
        System.out.println("Initialization Farm...");
        farm = scan_File(path);
    }
}
