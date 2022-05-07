package collection;

import java.util.Date;

public class Product implements Comparable<Product>{
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Double price; //Поле не может быть null, Значение поля должно быть больше 0
    private String partNumber; //Значение этого поля должно быть уникальным, Поле не может быть null
    private Integer manufactureCost; //Поле не может быть null
    private UnitOfMeasure unitOfMeasure; //Поле может быть null
    private Organization manufacturer; //Поле не может быть null
    private static Long idOrder = Long.valueOf(1);
    private static String dict = "abcdefghijklmnopqrstuvwxyz1234567890"; //строка содержит все доступные символы
    private static String newNumberPart = "p";

    public Product(){
        this.id = idOrder;
        this.partNumber = newNumberPart;
        this.creationDate =  new Date();
        newNumberPart = newNumberPart + dict.charAt((int)(Math.random()*35));
        idOrder += 1;
    }
    public Product(String name, Coordinates coordinates, Double price,Integer manufactureCost,
                   UnitOfMeasure unitOfMeasure, Organization manufacturer){
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate =  new Date();
        this.price = price;
        this.partNumber = newNumberPart;
        this.manufactureCost = manufactureCost;
        this.unitOfMeasure = unitOfMeasure;
        this.manufacturer = manufacturer;
        this.id = idOrder;
        newNumberPart = newNumberPart + dict.charAt((int)(Math.random()*35));
        idOrder += 1;
    }

    public void setId2(long ID){this.id = ID;}
    public void setName(String name){this.name = name;}
    public void setCoordinates(Coordinates coordinates){this.coordinates = coordinates;}
    public void setPrice(Double price){this.price = price;}
    public void setCreationDate(){
        java.util.Date newDate = new Date();
        this.creationDate = newDate;}
    public void setManufactureCost(Integer manufactureCost){this.manufactureCost = manufactureCost;}
    public void setManufacturer(Organization organization){
        this.manufacturer = organization;
    }
    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure){this.unitOfMeasure = unitOfMeasure;}

    public Long getId() {return id;}
    public float getCoordinateX() {return coordinates.getX();}
    public Float getCoordinateY() {return coordinates.getY();}
    public String getName(){return name;}
    public Double getPrice(){
        return price;
    }
    public java.util.Date getCreationDate() {return creationDate;}
    public Organization getManufacturer(){
        return manufacturer;
    }
    public UnitOfMeasure getUnitOfMeasure() {return unitOfMeasure;}
    public String getPartNumber() {return partNumber;}
    public Integer getManufactureCost() {return manufactureCost;}
    public String[] getAll() {
        return new String[]{String.valueOf(this.id), String.valueOf(this.name), String.valueOf(this.coordinates),
                String.valueOf(this.creationDate), String.valueOf(this.price), String.valueOf(this.partNumber),String.valueOf(this.unitOfMeasure),String.valueOf(this.manufactureCost),
                String.valueOf(manufacturer.getId()), manufacturer.getName(), String.valueOf(manufacturer.getEmployeesCount()),
                String.valueOf(manufacturer.getType())};
    }

    @Override
    public String toString() {
        return "Product:"
                + "id=" + id
                + ", name=" + name
                + ", coordinateX=" + coordinates.getX()
                + ", coordinateY =" + coordinates.getY()
                + ", creationDate=" + creationDate
                + ", price="+ price
                + ", partNumber=" + partNumber
                + ", manufactureCost=" + manufactureCost
                + ", unitOfMeasure=" + unitOfMeasure
                + ", manufacturer" + manufacturer+'\n';
    }

    @Override
    public int compareTo(Product o) {
        if (this.price > o.getPrice()) {
            return 1;
        } else if (this.price < o.getPrice()) {
            return -1;
        }
        return 0;
    }

}

