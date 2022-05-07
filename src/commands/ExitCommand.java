package commands;

import collection.CollectionManager;

import java.io.BufferedReader;
import java.io.IOException;

public class ExitCommand implements Command{
    @Override
    public void execution(CollectionManager collectionManager, BufferedReader input) throws IOException {
        System.out.println("Выход из программы");
        System.exit(0);
    }

    @Override
    public String getName() {return "exit";}

    @Override
    public String getDescription() {return "exit : завершить программу (без сохранения в файл)";}
}
