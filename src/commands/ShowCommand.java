package commands;

import collection.CollectionManager;

import java.io.BufferedReader;
import java.io.IOException;

public class ShowCommand implements Command{
    @Override
    public void execution(CollectionManager collectionManager, BufferedReader input) throws IOException {
        System.out.println(collectionManager.getAllElements());
    }

    @Override
    public String getName() {return "show";}

    @Override
    public String getDescription() {return "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";}
}
