package collection;

public class Organization {

    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Integer employeesCount; //Поле может быть null, Значение поля должно быть больше 0
    private OrganizationType type; //Поле может быть null
    private static Long idOrder = Long.valueOf(1);
    public Organization(){
        this.id = idOrder;
        idOrder += 1;}
    public Organization(String name, Integer employeesCount, OrganizationType type){
        this.id = idOrder;
        this.name = name;
        idOrder += 1;
        this.employeesCount = employeesCount;
        this.type = type;
    }

    public void setEmployeesCount(Integer employeesCount) {this.employeesCount = employeesCount;}
    public void setType(OrganizationType type){this.type = type;}
    public void setName(String name){this.name = name;}

    public Long getId(){
        return id;
    }
    public String getName(){return name;}
    public Integer getEmployeesCount(){
        return employeesCount;
    }
    public OrganizationType getType(){
        return type;
    }


    @Override
    public String toString() {
        return "Organization:"
                + "id=" + id
                + ", name=" + name
                + ", employeesCount=" + employeesCount
                + ", type=" + type + '\n';
    }


}

