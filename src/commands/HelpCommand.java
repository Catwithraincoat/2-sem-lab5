package commands;

import collection.CollectionManager;

import java.io.BufferedReader;
import java.io.IOException;

public class HelpCommand implements Command{
    @Override
    public void execution(CollectionManager collectionManager, BufferedReader input) throws IOException {
        System.out.println("help : вывести справку по доступным командам\n" +
                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "add  : добавить новый элемент в коллекцию\n" +
                "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                "remove_by_id id : удалить элемент из коллекции по его id\n" +
                "clear : очистить коллекцию\n" +
                "save : сохранить коллекцию в файл\n" +
                "execute_script : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                "exit : завершить программу (без сохранения в файл)\n" +
                "add_if_max  : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции\n" +
                "remove_greater: удалить из коллекции все элементы, превышающие заданный\n" +
                "remove_lower : удалить из коллекции все элементы, меньшие, чем заданный\n" +
                "remove_all_by_unit_of_measure unitOfMeasure : удалить из коллекции все элементы, значение поля unitOfMeasure которого эквивалентно заданному\n" +
                "print_field_descending_manufacturer : вывести значения поля manufacturer всех элементов в порядке убывания");
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "help : вывести справку по доступным командам";
    }
}
