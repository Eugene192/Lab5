package CommandProvider.Commands;

import java.sql.SQLOutput;

public class Help{

    /**
     * display help on available commands
     * */
    public static void HelpCommand(){
        System.out.println("\n====================\n");
        System.out.println("help : вывести справку по доступным командам");
        System.out.println("info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        System.out.println("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        System.out.println("add {element} : добавить новый элемент в коллекцию");
        System.out.println("update id {element} : обновить значение элемента коллекции, id которого равен заданному");
        System.out.println("remove_by_id id : удалить элемент из коллекции по его id");
        System.out.println("clear : очистить коллекцию");
        System.out.println("save : сохранить коллекцию в файл");
        System.out.println("execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
        System.out.println("exit : завершить программу (без сохранения в файл)");
        System.out.println("add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции");
        System.out.println("remove_greater {element} : удалить из коллекции все элементы, превышающие заданный");
        System.out.println("remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный");
        System.out.println("max_by_id : вывести любой объект из коллекции, значение поля id которого является максимальным");
        System.out.println("count_greater_than_health health : вывести количество элементов, значение поля health которых больше заданного");
        System.out.println("print_field_descending_chapter : вывести значения поля chapter всех элементов в порядке убывания");
    }
}
