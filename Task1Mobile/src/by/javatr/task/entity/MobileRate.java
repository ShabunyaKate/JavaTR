<<<<<<< HEAD
package by.javatr.task.entity;

import java.util.Objects;

public class MobileRate extends Rate {

    private int calls;

    public void setCalls(int calls) {
        this.calls = calls;
    }
    public int getCalls() { return calls; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MobileRate that = (MobileRate) o;
        return calls == that.calls;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), calls);
    }

    @Override
    public String toString() {
        return  "MobileRate:" +"name=" + super.getName() + ", price=" + super.getPrice() +
                ", people=" + super.getPeople() +
                ", id=" + super.getId() +",calls=" + calls;
    }

    @Override
    public String toFileString() {
        return super.toFileString()+","+calls;
    }

}
=======
package by.javatr.task.entity;

import java.util.Objects;

public class MobileRate extends Rate {

    private int calls;

    public void setCalls(int calls) {
        this.calls = calls;
    }
    public int getCalls() { return calls; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MobileRate that = (MobileRate) o;
        return calls == that.calls;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), calls);
    }

    @Override
    public String toString() {
        return  "MobileRate:" +"name=" + super.getName() + ", price=" + super.getPrice() +
                ", people=" + super.getPeople() +
                ", id=" + super.getId() +",calls=" + calls;
    }

    @Override
    public String toFileString() {
        return super.toFileString()+","+calls;
    }

}
>>>>>>> b8b1e858dae3e49ee4bc0f3e614209143df76551
