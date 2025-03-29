package Exercise2.Repositories;

import Exeptions.NotFoundException;
import Exercise2.Interfaces.TasksList;
import Exercise2.Model.State;
import Exercise2.Model.Task;

import java.util.LinkedList;
import java.util.List;

public class Tasks <T extends Task> implements TasksList {
    private List<T> tasksList;

    public Tasks() {
        this.tasksList=new LinkedList<>();
    }

    public List<T> getTasksList() {
        return tasksList;
    }

    public void setTasksList(List<T> tasksList) {
        this.tasksList = tasksList;
    }

    @Override
    public Boolean addTask(Task task){
        return tasksList.add((T)task);
    }

    @Override
    public void showAll() {
        tasksList.forEach(System.out::println);
    }

    @Override
    public boolean softDelete(Task task) throws NotFoundException {
        Task taskItem = tasksList.stream()
                .filter(t -> t.getUniqueId().equals(task.getUniqueId()))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("The task is not on the list"));
        taskItem.setState(State.DELETED);
        return true;
    }

    @Override
    public boolean modifyDescription(String id, String newDescription) throws NotFoundException {
        Task taskItem= tasksList.stream()
                .filter(t -> t.getUniqueId().equals(id))
                .findFirst()
                .orElseThrow(() ->new NotFoundException("The task is not on the list"));

        taskItem.setDescription(newDescription);
        return true;

    }

    @Override
    public int getTaskIndex(String id) throws NotFoundException {
        int index=0;
        for(T task:tasksList)
        {
            if (task.getUniqueId().equals(id)){
                return index;
            }
            index++;

        }
        throw new NotFoundException("The task is not on the list");
    }
}
