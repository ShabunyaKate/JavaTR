<<<<<<< HEAD
package by.javatr.task.entity;

import java.util.Objects;

public class InternetRate extends Rate {

    private int internet;

    public void setInternet(int internet) {
        this.internet = internet;
    }

    @Override
    public String toString() {
        return "InternetRate:" +"name=" + super.getName() + ", price=" + super.getPrice() +
                ", people=" + super.getPeople() +
                ", id=" + super.getId() +
                ",internet=" + internet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        InternetRate that = (InternetRate) o;
        return internet == that.internet;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), internet);
    }

    @Override
    public String toFileString() {
        return super.toFileString()+","+internet;
    }

}
=======
package by.javatr.task.entity;

import java.util.Objects;

public class InternetRate extends Rate {

    private int internet;

    public void setInternet(int internet) {
        this.internet = internet;
    }

    @Override
    public String toString() {
        return "InternetRate:" +"name=" + super.getName() + ", price=" + super.getPrice() +
                ", people=" + super.getPeople() +
                ", id=" + super.getId() +
                ",internet=" + internet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        InternetRate that = (InternetRate) o;
        return internet == that.internet;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), internet);
    }

    @Override
    public String toFileString() {
        return super.toFileString()+","+internet;
    }

}
>>>>>>> b8b1e858dae3e49ee4bc0f3e614209143df76551
