package commands;

import collection.CollectionManager;
import collection.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

public class RemoveLowerCommand implements Command{
    @Override
    public void execution(CollectionManager collectionManager, BufferedReader input) throws IOException {
        System.out.println("Введите цену меньше  которой нужно удалить товары");
        boolean error = true;
        try {
            while (error) {
                String price = input.readLine();
                HashSet<Product> goods = collectionManager.getAllElements();
                Iterator<Product> it = goods.iterator();
                while (it.hasNext()) {
                    if (it.next().getPrice() < Double.parseDouble(price)) {
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
        return "remove_lower";
    }

    @Override
    public String getDescription() {
        return "remove_lower: удалить из коллекции все элементы, меньшие, чем заданный";
    }
}
