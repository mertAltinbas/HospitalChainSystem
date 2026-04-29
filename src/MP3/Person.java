package MP3;

import java.util.Objects;

public abstract class Person {
    private String name;

    public Person(String name) {
        Objects.requireNonNull(name);
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        Objects.requireNonNull(name);
        this.name = name;
    }

    public abstract float calculateFinalBill(float rawFee);
}
