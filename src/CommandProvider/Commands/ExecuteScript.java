package CommandProvider.Commands;

import Data.DataProvider;

import java.util.Vector;

public class ExecuteScript {

    /**
     * execute script
     * <p>
     * read and execute the script from the specified file. The script contains commands in the same form in which the user enters them interactively.
     *
     * @param fileName name of the file to be execute
     * */
    public static void ExecuteScriptCommand(String fileName){
        CommandManager commandManager = new CommandManager();
        Vector<String> vector = DataProvider.LoadScript(fileName);
        for (String line: vector) {
            commandManager.findCommand(line);
        }

    }
}

