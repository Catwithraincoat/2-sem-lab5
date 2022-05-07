package commands;

import collection.CollectionManager;
import collection.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collections;

public class AddIfMaxCommand implements Command{
    @Override
    public void execution(CollectionManager collectionManager, BufferedReader input) throws IOException {
        System.out.println("Пожалуйста введите цену для сравнения с наибольшим объектом");
        String strPrice = input.readLine();
        Double Price = Double.valueOf(strPrice);
        Product product = Collections.max(collectionManager.getAllElements());
        if (product.getPrice() < Price){
            AddCommand addCommand = new AddCommand();
            addCommand.execution( collectionManager,input);
        }
    }

    @Override
    public String getName() {
        return "add_if_max";
    }

    @Override
    public String getDescription() {
        return "add_if_max : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции";
    }
}
