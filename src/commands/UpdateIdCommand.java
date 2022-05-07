package commands;

import collection.*;
import exceptions.WrongArgsException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class UpdateIdCommand implements Command{
    @Override
    public void execution(CollectionManager collectionManager, BufferedReader input) throws IOException {
        System.out.println("Введите значение id которое хотите обновить");
        String id = input.readLine();
        boolean error1 = true;
        while (error1) {
            try {
                boolean elementExists = false;
                boolean error = true;
                while(error){
                    try{
                        HashSet<Product> goods = collectionManager.getAllElements();
                        Iterator<Product> it = goods.iterator();
                        while (it.hasNext()) {
                            if (it.next().getId() == Long.parseLong(id)){it.remove();}
                            error = false;
                            elementExists = true;
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Вы ввели не число попрбуйте еще раз");
                    }
                }
                if (elementExists){
                    System.out.println("Такого id не существует");
                    break;}
                System.out.println("Введите название продукта");
                Organization organization = new Organization();
                Product product = new Product();
                input = new BufferedReader(new InputStreamReader(System.in));
                error = true;
                while (error) {
                    try {
                        String name = input.readLine();
                        if (name == null || name.equals("")) {
                            throw new WrongArgsException();
                        }
                        error = false;
                        product.setName(name);
                    } catch (WrongArgsException e) {
                        System.out.println("Строка пустая или содержит не желательные символы");
                    }
                }
                System.out.println("Введите координаты - два числа в 10 сс, с новой строки");
                error = true;
                while (error) {
                    try {
                        String coordinateX = input.readLine();
                        float floatCoordinatex = Float.parseFloat(coordinateX);
                        if (floatCoordinatex > 894) {
                            throw new NumberFormatException();
                        }
                        String coordinateY = input.readLine();
                        Float floatCoordinatey = Float.valueOf(coordinateY);
                        if (floatCoordinatey < -94) {
                            throw new NumberFormatException();
                        }
                        Coordinates coordinates = new Coordinates(floatCoordinatex, floatCoordinatey);
                        product.setCoordinates(coordinates);
                        error = false;
                    } catch (NumberFormatException e) {
                        System.out.println("Данные введены не верно, пожалуйста попробуйте еще раз");

                    }
                }
                error = true;
                System.out.println("Введите цену продукта");
                while (error) {
                    try {
                        String strPrice = input.readLine();
                        Double price = Double.valueOf(strPrice);
                        if (price < 0) {
                            throw new NumberFormatException();
                        }
                        product.setPrice(price);
                        error = false;
                    } catch (NumberFormatException e) {
                        System.out.println("Данные введены не верно, пожалуйста попробуйте еще раз");
                    }
                }
                System.out.println("Введите цену от организации");
                error = true;
                while (error) {
                    try {
                        String strManufactureCost = input.readLine();
                        Integer manufactureCost = Integer.valueOf(strManufactureCost);
                        if (manufactureCost <= 0) {
                            throw new NumberFormatException();
                        }
                        product.setManufactureCost(manufactureCost);
                        error = false;
                    } catch (NumberFormatException e) {
                        System.out.println("Данные введены не верно, пожалуйста попробуйте еще раз");
                    }
                }
                System.out.println("Введите систему в которой измеряется товар : GRAMS,MILLILITERS,SQUARE_METERS");
                error = true;
                while (error) {
                    try {
                        String strMeasure = input.readLine();
                        strMeasure = strMeasure.toUpperCase();
                        if (Objects.equals(strMeasure, "")) {
                            UnitOfMeasure unitOfMeasure = null;
                            product.setUnitOfMeasure(unitOfMeasure);
                        }
                        if ((strMeasure.equals("GRAMS")) || (strMeasure.equals("MILLILITERS"))
                                || (strMeasure.equals("SQUARE_METERS"))) {
                            UnitOfMeasure unitOfMeasure = UnitOfMeasure.valueOf(strMeasure);
                            product.setUnitOfMeasure(unitOfMeasure);
                            error = false;
                        } else {
                            throw new IllegalArgumentException();
                        }

                    } catch (IllegalArgumentException e) {
                        System.out.println("Данные введены не верно, пожалуйста попробуйте еще раз");
                    }
                }
                System.out.println("Введите данные о количестве рабочих");
                error = true;
                while (error) {
                    try {
                        Integer employeesCount;
                        String strEmployeesCount = input.readLine();
                        if (strEmployeesCount == null) {
                            employeesCount = null;
                        } else {
                            employeesCount = Integer.valueOf(strEmployeesCount);
                        }
                        if (employeesCount <= 0) {
                            throw new NumberFormatException();
                        }
                        organization.setEmployeesCount(employeesCount);
                        error = false;
                    } catch (NumberFormatException e) {
                        System.out.println("Данные введены не верно, пожалуйста попробуйте еще раз");
                    }
                }
                System.out.println("Введите тип компании : COMMERCIAL,GOVERNMENT," +
                        "TRUST,PRIVATE_LIMITED_COMPANY,OPEN_JOINT_STOCK_COMPANY");
                error = true;
                while (error) {
                    try {
                        String strType = input.readLine();
                        OrganizationType organizationType;
                        strType = strType.toUpperCase();
                        if ((Objects.equals(strType.toUpperCase(), "")) || (strType.equals("COMMERCIAL")) || (strType.equals("GOVERNMENT"))
                                || (strType.equals("PRIVATE_LIMITED_COMPANY")) || (strType.equals("TRUST")) || (strType.equals("OPEN_JOINT_STOCK_COMPANY"))) {
                            organizationType = OrganizationType.valueOf(strType);
                        } else {
                            throw new IllegalArgumentException();
                        }
                        organization.setType(organizationType);
                        error = false;

                    } catch (IllegalArgumentException e) {
                        System.out.println("Данные введены не верно, пожалуйста попробуйте еще раз");
                    }
                }
                System.out.println("Введите название организации");
                error = true;
                while (error) {
                    try {
                        String nameOfOrganization = input.readLine();
                        if (nameOfOrganization == null || nameOfOrganization.equals("")) {
                            throw new WrongArgsException();
                        }
                        organization.setName(nameOfOrganization);
                        error = false;
                    } catch (WrongArgsException e) {
                        System.out.println("Строка пустая или содержит не желательные символы");
                    }
                }
                product.setManufacturer(organization);
                product.setId2(Long.parseLong(id));

                collectionManager.add(product);
                error1 = false;

            } catch (NumberFormatException e) {
                System.out.println("Данные введены неверно введите число");
            }
        }
    }
    @Override
    public String getName() {
        return "update id";
    }

    @Override
    public String getDescription() {return "update id: обновить значение элемента коллекции, id которого равен заданному";}
}
