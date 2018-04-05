package com.company;
//Rodrigo Rivera
//Luis Villarroel
public abstract class Pet {
    private String type;
    private String color;
    private int age;
    private int id;
    private String name;
    private boolean show;
    //vanessa sanjinez
    public Pet (String type, String color, int age,String name){
        this.type = type;
        this.age = age;
        this.color = color;
        //this.id = id;
        this.name = name;
    }

    public Pet(){

    }

    public String getType() {
        return type;
    }

    public boolean getShow() {
        return show;
    }

    public void setShow(boolean show) {
         this.show = show;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "tipo: " + type + "\n" +
                "color: " + color + "\n" +
                "id: " + id + "\n" +
                "age: " + age + "\n";
    }

    public abstract void sound();

    public void setId(int id) {
        this.id = id;
    }
}
