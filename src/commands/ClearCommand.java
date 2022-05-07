package commands;

import collection.CollectionManager;

import java.io.BufferedReader;
import java.io.IOException;

public class ClearCommand implements Command{
    @Override
    public void execution(CollectionManager collectionManager, BufferedReader input) throws IOException {
        collectionManager.clear();
        System.out.println("коллекция очищена");
    }

    @Override
    public String getName() {return "clear";}

    @Override
    public String getDescription() {return "clear : очистить коллекцию";}
}
