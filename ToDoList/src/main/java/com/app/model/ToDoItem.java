package com.app.model;

/**
 * <p>
 * ToDoItem define the abstraction of individual item unit that is part
 * of the ToDoList.
 * </p>
 * <strong>Example</strong>
 * <p>
 * Define a to do item named "Read Java Core Book" with id equal to 1.
 * </p>
 * <p>
 * By default
 * <strong>completed</strong> property is equal to false, which means that the
 * item is not completed.
 * </p>
 * <p>
 * var item1 = new ToDoItem(1,"Read Java Core Book")
 * </p>
 *
 * @author Mauricio Bedoya
 * @since 1.0
 */
public class ToDoItem implements Comparable<ToDoItem>{
    private long id;
    private String name;
    private boolean completed;

    /**
     * Initialize a new uncompleted Item of the To Do List.
     *
     * @param id Number that identifies the Item id.
     * @param name Describes the name of the item.
     *
     * @since 1.0
     */
    public ToDoItem(long id, String name) {
        this.id = id;
        this.name = name;
        this.completed = false;
    }

    /**
     *
     * @param newName Replace the item description.
     *
     * @since 1.0
     */
    public void setName(String newName){
        this.name = newName;
    }
    /**
     * Change the status of the item to completed (true).
     *
     * @since 1.0
     */
    public void makeCompleted(){
        this.completed = true;
    }/**
     * Return the id identification of the item.
     *
     * @return id of the item.
     *
     * @since 1.0
     */
    public long getId(){
        return this.id;
    }
    /**
     * Change the id of the item.
     *
     * @param id of the item.
     *
     * @since 1.0
     */
    public void setId(long id){
        this.id = id;
    }
    @Override
    public String toString(){

        return this.id + " Item : " + this.name + ", status: " + this.completed;
    }

    @Override
    public int compareTo(ToDoItem t) {
        if(this.id == t.getId()){
            return 0;
        }else if(this.id > t.getId()){
            return 1;
        }else{
            return -1;
        }
    }

}
