package com.company;
//Rodrigo Rivera
//Luis Villarroel
public abstract class Pet {
    private String tipo;
    private String color;
    private int age;
    private int id;
    private String name;
    private boolean show;
    //vanessa sanjinez
    public Pet (String tipo, String color, int age,String name){
        this.tipo = tipo;
        this.age = age;
        this.color = color;
        //this.id = id;
        this.name = name;
<<<<<<< HEAD
        this.show = true;
=======
        this.show=true;
>>>>>>> Add fufunction show all pets and modification in main
    }

    public String getTipo() {
        return tipo;
    }

    public boolean getShow() {
        return show;
    }

    public void setShow(boolean show) {
         this.show = show;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        return "tipo: " + tipo + "\n" +
                "color: " + color + "\n" +
                "id: " + id + "\n" +
                "age: " + age + "\n" +
                "name: " + name + "\n";
    }

    public abstract void sound();

    public void setId(int id) {
        this.id = id;
    }
}
