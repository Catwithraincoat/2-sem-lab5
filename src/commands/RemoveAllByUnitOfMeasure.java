package commands;

import collection.CollectionManager;
import collection.Product;
import collection.UnitOfMeasure;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class RemoveAllByUnitOfMeasure implements Command{
    @Override
    public void execution(CollectionManager collectionManager, BufferedReader input) throws IOException {
        System.out.println("Введите значение поля UnitOfMeasure по котором будет проивзедено удаление элементов");
        try {
            HashSet<Product> goods = collectionManager.getAllElements();
            String strMeasure = input.readLine().toUpperCase();
                if ((strMeasure.equals("GRAMS")) || (strMeasure.equals("MILLILITERS"))
                        || (strMeasure.equals("SQUARE_METERS"))) {
                    UnitOfMeasure unitOfMeasure = UnitOfMeasure.valueOf(strMeasure);
                    Iterator<Product> it = goods.iterator();
                    while (it.hasNext()) {
                        if (it.next().getUnitOfMeasure() == unitOfMeasure){it.remove();}
                    }}
                else {
                    throw new IllegalArgumentException();
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Данные введены не верно, пожалуйста попробуйте еще раз");
            }
        }


    @Override
    public String getName() {
        return "remove_all_by_unit_of_measure";
    }

    @Override
    public String getDescription() {
        return "remove_all_by_unit_of_measure unitOfMeasure : удалить из коллекции все элементы, значение поля unitOfMeasure которого эквивалентно заданному";
    }
}
