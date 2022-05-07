package commands;

import collection.CollectionManager;

import java.io.BufferedReader;
import java.io.IOException;

public class SaveCommand implements Command{
    @Override
    public void execution(CollectionManager collectionManager, BufferedReader input) throws IOException {
        collectionManager.saveToFile();
    }

    @Override
    public String getName() {
        return "save";
    }

    @Override
    public String getDescription() {
        return "save : сохранить коллекцию в файл";
    }
}
