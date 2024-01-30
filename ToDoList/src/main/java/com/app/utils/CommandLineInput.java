package com.app.utils;


import com.app.model.ToDoItem;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Define functions and console messages to interact with the user via CLI.
 *
 * @author Mauricio Bedoya
 * @since 1.0
 */
public class CommandLineInput {
    private final Scanner scan = new Scanner(System.in);
    private String option = "go";

    /**
     * Display menu options in the CLI
     * @since 1.0
     */
    public void menu(){
        System.out.println("\n\n--- To Do App ---");
        System.out.println("Please make a choice:");
        System.out.println("(a)ll items");
        System.out.println("(f)ind a specific item");
        System.out.println("(i)nsert new item");
        System.out.println("(u)pdate an existing item");
        System.out.println("(d)elete and existing item");
        System.out.println("(e)xit");
        System.out.print("Option: ");
    }

    /**
     * Read user data input menu option
     *
     * @since 1.0
     */
    public void readOption(){
        this.option = scan.next();
    }

    /**
     * Retrieve the store user selection from the menu
     *
     * @return the option that user select from the menu
     * @since 1.0
     */
    public String getOption(){
        return this.option;
    }

    /**
     * Insert a new ToDoItem
     *
     * @return the TodoItem inserted by the user
     */
    public ToDoItem insertInput(){
        System.out.print("Item name: ");
        scan.nextLine();
        String itemName = scan.nextLine();

        return new ToDoItem(0,itemName);
    }

    /**
     * Retrieve a ToDoItem associate to the id
     *
     * @return the ToDoItem associate to the id if exists.
     */
    public int find(){
        System.out.print("Item to found: ");
        scan.nextLine();
        int id = -1;
        try{
            id = scan.nextInt();
        }catch(InputMismatchException ex){
            System.out.println("Error: Integer number expected !");
            scan.nextLine();
        }

        return id;
    }

    /**
     * Change the name for an existing ToDoItem
     *
     * @return new ToDoItem name
     */
    public String newItemName(){
        System.out.print("New item name: ");
        scan.nextLine();

        return scan.nextLine();
    }
}
