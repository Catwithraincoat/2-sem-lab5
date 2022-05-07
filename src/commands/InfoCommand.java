package commands;

import collection.CollectionManager;

import java.io.BufferedReader;
import java.io.IOException;

public class InfoCommand implements Command{
    @Override
    public void execution(CollectionManager collectionManager, BufferedReader input) throws IOException {
        System.out.println("Тип коллекции: HashSet "+ "\n"
                +"Дата инициализации: " + collectionManager.getLocalDateTime().toString() +"\n"
                +"Количество элементов: " + collectionManager.getAllElements().size());
    }

    @Override
    public String getName() {return "info";}

    @Override
    public String getDescription() {return "info : вывести в стандартный поток вывода информацию о коллекции";}
}
