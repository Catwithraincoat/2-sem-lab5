package commands;

import collection.CollectionManager;
import collection.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

import static java.lang.Long.parseLong;

public class RemoveByIdCommand implements Command{
    @Override
    public void execution(CollectionManager collectionManager, BufferedReader input) throws IOException {
        boolean error = true;
        while(error){
            try{
                System.out.println("Введите номер id");
                String id = input.readLine();

                HashSet<Product> goods = collectionManager.getAllElements();
                Iterator<Product> it = goods.iterator();
                while (it.hasNext()) {
                    if (it.next().getId() == Long.parseLong(id)){it.remove();}
                    error = false;
                }

            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не число попрбуйте еще раз");
            }
        }

    }

    @Override
    public String getName() {
        return "remove_by_id";
    }

    @Override
    public String getDescription() {
        return "remove_by_id id : удалить элемент из коллекции по его id";
    }
}
