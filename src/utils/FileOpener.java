package utils;

import collection.*;

import java.io.*;
import java.nio.file.AccessDeniedException;
import java.util.*;

/**
 * Открывает файл
 */
public class FileOpener {
    private static final String DELIMETER = ";";

    /**
     * Открывает файл и заполняет коллекцию его значениями. Также происходит сортировка
     *
     *
     * @param filename
     * @param collectionManager коллекция, где хранятся элементы
     * @throws FileNotFoundException исключение, когда файл не найден
     * @throws AccessDeniedException исключение, когда к файлу нет доступа
     */
    public void processInputFile(String filename, CollectionManager collectionManager) throws FileNotFoundException, AccessDeniedException {
        try {
            File file = new File(filename);
            if (!file.exists()) throw new FileNotFoundException();
            if (file.length() == 0) {System.out.println("По этим данным нельзя создать экземпляр класса Product! Одно или несколько из полей null.");
                System.exit(-1);};
            if (!file.canRead()) throw new AccessDeniedException("Нет доступа");
            InputStream input = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(input));
            String line = "";
            String[] tempArr;

            while ((line = br.readLine()) != null) {
                tempArr = line.split(DELIMETER);
                Product product = new Product();
                product.setName(tempArr[0]);
                Coordinates coordinates = new Coordinates(Float.parseFloat(tempArr[1]), Float.parseFloat(tempArr[2]));
                product.setCoordinates(coordinates);
                product.setPrice(Double.parseDouble(tempArr[3]));
                product.setManufactureCost(Integer.parseInt(tempArr[4]));
                UnitOfMeasure unitOfMeasure = UnitOfMeasure.valueOf(tempArr[5]);
                product.setUnitOfMeasure(unitOfMeasure);
                Organization organization = new Organization();
                organization.setName(tempArr[6]);
                organization.setEmployeesCount(Integer.parseInt(tempArr[7]));
                OrganizationType organizationType = OrganizationType.valueOf(tempArr[8]);
                organization.setType(organizationType);
                product.setManufacturer(organization);
                collectionManager.add(product);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден. Проверьте путь и наличие файла");
        } catch (
                AccessDeniedException e) {
            System.out.println("Доступ к файлу запрещен");
        } catch (NullPointerException | IOException e) {
            e.printStackTrace();
        } catch (
                NoSuchElementException e) {
            System.out.println("Ошибка в синтаксисе файла");
        }
    }
}
