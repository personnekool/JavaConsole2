package com.app.repository;
import com.app.model.ToDoItem;
import java.util.List;

/**
 * Interface that define the CRUD operations in the ToDoList app
 *
 * @author Mauricio Bedoya
 *
 * @since 1.0
 */
public interface ToDoRepository {
    /**
     * Read the whole content of ToDoList items stored during the program session
     *
     * @return a list of items
     */
    List<ToDoItem> findAll();
    /**
     * Retrieve an item found in the ToDoList
     * @param id Number that identify an item
     * @return an item store in the ToDoList or null if does not exist
     */
    ToDoItem getById(long id);
    /**
     * Insert an item in the ToDoList
     * @param toDoItem Item to insert
     * @return toDoItem id
     */
    Long insert(ToDoItem toDoItem);
    /**
     * Update the item description of element found in the ToDoList
     * @param toDoItem Item to update
     */
    void update(ToDoItem toDoItem);
    /**
     * Delete and item from the ToDoList if exists
     * @param toDoItem Item to delete
     */
    void delete(ToDoItem toDoItem);

}

