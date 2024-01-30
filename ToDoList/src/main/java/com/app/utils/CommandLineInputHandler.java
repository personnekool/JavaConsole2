package com.app.utils;


import com.app.model.ToDoItem;
import com.app.repository.InMemoryToDoRepository;
import static java.util.Objects.nonNull;

/**
 * Define the program response to user input in ToDoList program
 *
 * @author Mauricio Bedoya
 * @since 1.0
 */
public class CommandLineInputHandler {
    private final InMemoryToDoRepository data;
    private final CommandLineInput cmd;
    private String option;

    /**
     * Build the session repository and line input handler
     *
     * @since 1.0
     */
    public CommandLineInputHandler(){
        this.data = new InMemoryToDoRepository();
        this.cmd = new CommandLineInput();
        this.option = "";
    }

    /**
     * Start the ToDoList application
     *
     * @since 1.0
     */
    public void run(){
        while(!this.option.equals("e")){
            cmd.menu();
            cmd.readOption();
            this.option = cmd.getOption();
            handler();
        }
    }

    /**
     * Perform action according to user input (affects session ToDoList repo)
     *
     * @since 1.0
     */
    public void handler(){
        int id;
        ToDoItem result;
        switch(this.option){
            case "a":
                for(ToDoItem item: data.findAll()){
                    System.out.println(item);
                }
                break;
            case "f":
                System.out.println("Finding");
                id = cmd.find();
                if(id!=-1){
                    result = data.getById(id);
                    System.out.println((nonNull(result)?result:id +" not found !!"));
                }
                break;
            case "i":
                data.insert(cmd.insertInput());
                break;
            case "u":
                System.out.println("Updating");
                id = cmd.find();
                result = data.getById(id);
                if(nonNull(result)){
                    result.setName(cmd.newItemName());
                }else{
                    System.out.printf("Item %s not found\n",id);
                }
                break;
            case "d":
                System.out.println("Deleting");
                id = cmd.find();
                result = data.getById(id);
                if(nonNull(result)){
                    data.delete(result);
                    System.out.printf("Status changed for item %s to false.", id);
                }else{
                    System.out.printf("Item %s not found\n",id);
                }
                break;
            case "e":
                System.out.println("Byeeeee !!!");
                break;
            default:
                System.out.println("Incorrect option");
        }
    }
}