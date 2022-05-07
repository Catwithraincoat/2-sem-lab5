package commands;

import collection.CollectionManager;
import collection.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;

public interface Command {
    void execution(CollectionManager collectionManager, BufferedReader input) throws IOException ;


    String getName();

    String getDescription();
}
