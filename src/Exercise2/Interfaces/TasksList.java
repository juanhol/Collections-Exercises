package Exercise2.Interfaces;

import Exeptions.NotFoundException;
import Exercise2.Model.Task;

public interface TasksList {

    Boolean addTask(Task task);

    void showAll();

    boolean softDelete(Task task)throws NotFoundException;

    boolean modifyDescription(String id,String newDescription)throws NotFoundException;

    int getTaskIndex(String id)throws NotFoundException;

}
