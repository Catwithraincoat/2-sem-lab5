import collection.*;
import commands.*;
import exceptions.WrongArgsException;
import utils.FileOpener;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        String filename = String.join(" ", args);
        FileOpener fileOpener = new FileOpener();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        CollectionManager collectionManager = new CollectionManager();
        fileOpener.processInputFile(filename, collectionManager);
        HelpCommand help = new HelpCommand();
        help.execution(collectionManager, input);
        String[] strCommands  = {"add", "add_if_max", "clear", "execute_script", "exit", "help", "info", "print_field_descending_manufacturer",
                "remove_all_by_unit_of_measure", "remove_by_id", "remove_greater", "remove_lower", "save", "show", "update id"};
        CommandsKeeper commandsKeeper = new CommandsKeeper(new AddCommand(), new AddIfMaxCommand(), new ClearCommand(),
                new ExecuteScriptCommand(), new ExitCommand(), new InfoCommand(), new RemoveAllByUnitOfMeasure(), new RemoveByIdCommand(),
                new RemoveGreaterCommand(), new RemoveLowerCommand(), new SaveCommand(), new ShowCommand(), new UpdateIdCommand(), new PrintFieldDescendingmanufacturer());
        while (true) {
            System.out.println("Введите комманду");
            boolean error = true;
            if (collectionManager.isEmpty()) {
                while (error) {
                    try {
                        String newCom = input.readLine();
                        if (newCom.equals("add") || newCom.equals("exit") ) {
                            commandsKeeper.execute(newCom, collectionManager, input);
                        } else {
                            throw new WrongArgsException();
                        }
                        error = false;
                    } catch (WrongArgsException e) {
                        System.out.println("коллекция пуста вы можете только добавить элемент или выйти");
                    }
                }
            }
            else{
                while (error) {
                    try {
                        String newCom = input.readLine();
                        if ((Arrays.asList(strCommands).contains(newCom))) {
                            commandsKeeper.execute(newCom, collectionManager, input);
                        } else {
                            throw new WrongArgsException();
                        }
                        error = false;
                    } catch (WrongArgsException e) {
                        System.out.println("Неправильно введена комманда");
                    }
                }
            }

        }
    }
}
