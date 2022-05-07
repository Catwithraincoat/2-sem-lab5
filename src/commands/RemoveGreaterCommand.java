package commands;

import collection.CollectionManager;
import collection.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class RemoveGreaterCommand implements Command{
    @Override
    public void execution(CollectionManager collectionManager, BufferedReader input) throws IOException {
        System.out.println("Введите цену больше  которой нужно удалить товары");
        boolean error = true;
        try {
            while (error) {
                String price = input.readLine();
                HashSet<Product> goods = collectionManager.getAllElements();
                Iterator<Product> it = goods.iterator();
                while (it.hasNext()) {
                    if (it.next().getPrice() > Double.parseDouble(price)) {
                        it.remove();
                    }
                }
                error = false;
            }
        }catch(NumberFormatException e){
                System.out.println("Данные введены неверно попробуйте еще раз");
            }
        }
    @Override
    public String getName() {
        return "remove_greater";
    }

    @Override
    public String getDescription() {
        return "remove_greater {element} : удалить из коллекции все элементы, превышающие заданный";
    }
}
