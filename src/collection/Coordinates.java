package collection;

public class Coordinates {
    private float x; //Максимальное значение поля: 896
    private Float y; //Значение поля должно быть больше -94, Поле не может быть null
    public Coordinates(float x, Float y){
        this.x = x;
        this.y = y;
    }
    public void setX(float x){this.x = x;}
    public void setY(float y){this.y = y;}

    public float getX(){
        return x;
    }
    public Float getY() {
        return y;
    }
}
