package Exercise3.Model;

import Exercise2.Model.State;

import java.util.Objects;

public class Inscription {
    private String name;
    private State state;

    public Inscription(String name) {
        this.state=State.ACTIVE;
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inscription that = (Inscription) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Inscription{" +
                "name='" + name + '\'' +
                '}';
    }
}
