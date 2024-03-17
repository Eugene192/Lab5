package CommandProvider.Commands;

/**
 * StringParser class used in CommandManager class.
 */
public class StringParser {
    public final String string = "";

    /**
     * Method gets the command and value from the user string.
     *
     * @param value user string.
     * @return array with command and argument.
     */
    public String[] find(String value) {

        String[] values = value.trim().toLowerCase().split(" ");
        if (values.length == 2 && values[1].charAt(0) == '{' && values[1].charAt(values[1].length() - 1) == '}') {
            String argument = values[1].replaceAll("\\{", "").replaceAll("}", "");
            values[1] = argument;
            return values;
        }

        return values;
    }
}
