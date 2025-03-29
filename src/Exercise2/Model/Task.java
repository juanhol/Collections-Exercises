package Exercise2.Model;

import java.util.Objects;
import java.util.UUID;

public class Task {
    private String uniqueId;
    private String description;
    private State state;

    public Task(String description) {
        this.uniqueId=UUID.randomUUID().toString();
        this.description = description;
        this.state=State.ACTIVE;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        Task task = (Task) o;
        return Objects.equals(uniqueId, task.uniqueId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(uniqueId);
    }

    @Override
    public String toString() {
        return "Task{" +
                "uniqueId='" + uniqueId + '\'' +
                ", description='" + description + '\'' +
                ", state=" + state +
                '}';
    }
}
