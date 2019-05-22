<<<<<<< HEAD
package by.javatr.task.entity;

import java.util.Objects;

public class Rate {

    private String name;
    private int price;
    private int people;
    private int id;

    public void setId(int id) {
        this.id = id;
    }
    public int getPeople() {
        return people;
    }
    public int getId(){ return id;}
    public String getName(){ return name;}
    public int getPrice() { return price; }
    public void setPeople(int people) {
        this.people = people;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  "Rate:" +"name=" + name + ", price=" + price +
                ", people=" + people +
                ", id=" + id ;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rate rate = (Rate) o;
        return price == rate.price  &&
                people == rate.people &&
                Objects.equals(name, rate.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, price, people,id);
    }

    public String toFileString() {
        return ""+name+","+price+","+people;
    }
}
=======
package by.javatr.task.entity;

import java.util.Objects;

public class Rate {

    private String name;
    private int price;
    private int people;
    private int id;

    public void setId(int id) {
        this.id = id;
    }
    public int getPeople() {
        return people;
    }
    public int getId(){ return id;}
    public String getName(){ return name;}
    public int getPrice() { return price; }
    public void setPeople(int people) {
        this.people = people;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  "Rate:" +"name=" + name + ", price=" + price +
                ", people=" + people +
                ", id=" + id ;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rate rate = (Rate) o;
        return price == rate.price  &&
                people == rate.people &&
                Objects.equals(name, rate.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, price, people,id);
    }

    public String toFileString() {
        return ""+name+","+price+","+people;
    }
}
>>>>>>> b8b1e858dae3e49ee4bc0f3e614209143df76551
