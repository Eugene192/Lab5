package Data;

import SpaceMarines.SpaceMarine;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Vector;


/**
 * Data Class responsible for saving and unloading files
 * */
public class DataProvider {

    /**
     * Saving a collection to a file
     * */
    public static void Save(LinkedHashSet<SpaceMarine> collection){

        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(System.getProperty("path")));
            outputStream.writeObject(collection);
        } catch (Exception var4) {
            System.out.println("Нет доступа к файлу");
        }

    }

    /**
     * Load a collection from file
     *
     * @return collection where we store SpaceMarine objects
     * */
    public static LinkedHashSet<SpaceMarine> Load(){
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(System.getProperty("path")));
            LinkedHashSet<SpaceMarine> loadVector = (LinkedHashSet<SpaceMarine>) inputStream.readObject();
            System.out.println("Успешно загружено!");
            return loadVector;
        } catch (Exception e) {
            System.out.println("Ошибка!");
            return new LinkedHashSet<>();
        }
    }

    /**
     * Load a script from file
     *
     * @param fileName the name of the file from which the script should be loaded
     * @return collection where we store script
     * */
    public static Vector<String> LoadScript(String fileName){
        Vector<String> lines = new Vector<>();
        try{
            Scanner sc = new Scanner(new File(fileName));
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();//убираем пробелы
                lines.add(line);}
        }catch (FileNotFoundException e){
            System.out.println("К файлу нету доступа или он отсутствует!");
        }
        return lines;
    }

}
