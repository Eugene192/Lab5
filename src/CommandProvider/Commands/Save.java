package CommandProvider.Commands;

import Data.DataProvider;
import SpaceMarines.SpaceMarine;

import java.util.LinkedHashSet;
import java.util.Vector;

import static SpaceMarines.JustScanner.Scan;

public class    Save {

    /**
     * save the collection to a file
     *
     * @param collection collection where we store SpaceMarine objects
     * @return name of the file to save
     * */

    public static void SaveCommand(LinkedHashSet<SpaceMarine> collection){
        DataProvider.Save(collection);
        System.out.println("Сохранено!");
    }
}
