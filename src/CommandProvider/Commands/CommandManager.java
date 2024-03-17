package CommandProvider.Commands;

import CollectionManager.CollectionManager;
import SpaceMarines.SpaceMarine;

public class CommandManager {
    private final CollectionManager collectionManager;
    private final String file_name;

    public CommandManager() {
        this.collectionManager = new CollectionManager();
        this.file_name = System.getProperty("path");
    }

    public void findCommand(String user_value) {
        StringParser parser = new StringParser();
        String[] CommandAndArgument = parser.find(user_value);

        if (CommandAndArgument.length >= 1) {
            String command = CommandAndArgument[0].trim().toLowerCase();

            switch (command) {
                case ("help") -> {
                    Help.HelpCommand();
                }

                case ("exit") -> {
                    Exit.exit();
                }

                case ("save") -> {
                    Save.SaveCommand(collectionManager.get());
                }

                case ("execute_script") -> {
                    try {
                        String argument = CommandAndArgument[1];
                        ExecuteScript.ExecuteScriptCommand(argument);
                    } catch (Exception e) {
                        System.out.println("Unknown error!");
                    }
                }

                case ("info") -> {
                    System.out.println(this.collectionManager.info());
                }

                case ("show") -> {
                    for (SpaceMarine sp: this.collectionManager.show()) {
                        System.out.println(sp);
                        System.out.println();
                    }
                }

                case ("add") -> {
                    this.collectionManager.add();
                }

                case ("update_id") -> {
                    try {
                        String argument = CommandAndArgument[1];
                        Integer id = Integer.valueOf(argument);
                        this.collectionManager.update_id(id);
                    }
                    catch (Exception e) {
                        System.out.println("Unknown error!");
                    }
                }

                case ("remove_by_id") -> {
                    String argument = CommandAndArgument[1];
                    Integer id = Integer.valueOf(argument);
                    this.collectionManager.remove_by_id(id);
                }

                case ("clear") -> { this.collectionManager.clear(); }

                default -> {
                    System.out.println("Unknown command!");
                }
            }
        } else {
            System.out.println("\nYou can write command 'help' to see other commands.\n");

        }
    }
}