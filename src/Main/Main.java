package Main;

import CommandProvider.Commands.CommandManager;
import SpaceMarines.JustScanner;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File(args[0]);
            if (file.isFile()) {
                System.setProperty("path", args[0]);
                CommandManager commandManager = new CommandManager();

                while (true) {
                    commandManager.findCommand(JustScanner.Scan());
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Введите имя файла!");
        }
    }
}
