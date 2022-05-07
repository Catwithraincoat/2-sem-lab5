package commands;

import collection.CollectionManager;
import collection.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;

public class PrintFieldDescendingmanufacturer implements Command{
    @Override
    public void execution(CollectionManager collectionManager, BufferedReader input) throws IOException {
       collectionManager.getManufacturer();
    }

    @Override
    public String getName() {
        return "print_field_descending_manufacturer";
    }

    @Override
    public String getDescription() {
        return "print_field_descending_manufacturer : вывести значения поля manufacturer всех элементов в порядке убывания";
    }
}
