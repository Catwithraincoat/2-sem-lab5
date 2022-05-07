package commands;



import collection.CollectionManager;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*execute_script file_name : считать и исполнить скрипт из
  указанного файла. В скрипте содержатся команды в таком же виде,
  в котором их вводит пользователь в интерактивном режиме.
 */
public class ExecuteScriptCommand implements Command{

    @Override
    public void execution(CollectionManager collectionManager, BufferedReader input) throws IOException {
        CommandsKeeper commandsKeeper = new CommandsKeeper(new AddCommand(), new AddIfMaxCommand(), new ExitCommand(), new InfoCommand(), new RemoveAllByUnitOfMeasure(),
                new RemoveByIdCommand(), new RemoveLowerCommand(), new ShowCommand(), new SaveCommand(), new UpdateIdCommand(), new RemoveGreaterCommand());
        System.out.println("ВВедите полный путь файла");
        String params = input.readLine();
        File file = new File(params);
        //if (!file.exists()) {'System.out.println("Файла не существует"); throw new ParamException();}
        //else if (file.exists() && !file.canRead()) {System.out.println("Файл существует, нет прав на чтение."); throw new ParamException();}
        //else if (file.exists() && !file.canExecute()) {System.out.println("Проверьте файл на выполнение"); throw new ParamException();}

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (true) {
            assert scanner != null;
            if (!scanner.hasNextLine()) break;
            String line = scanner.nextLine().trim();
            List<String> collection = Arrays.asList(line.split(" "));
            if (collection.get(0).equals("execute_script")) {
                System.out.println("В файле команда execute_script не выполняется");
            } else {
                try {
                    commandsKeeper.execute(collection.get(0), collectionManager, input);
                } catch (NullPointerException e) {
                    System.out.println("Комманды не считываемы");
                }
            }

        }
    }

    @Override
    public String getName() {
        return "execute_script";
    }

    @Override
    public String getDescription() {
        return "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }
}
