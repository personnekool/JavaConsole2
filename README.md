# JavaConsole2
Java console application (ToDoList)

> [!IMPORTANT]
> Exercise from Gradle in Action (Benjamin Muschko)

## Exercise 1
Write a console ToDoApp that perform session CRUD operation.

### The original exercise solution does not indlude: testing + Exception handling

Implementation of the ToDoList app with input from console.

### Build the application
1. Open the project (ToDoList folder only) in IntellijIdea.
2. Execute the task: Ctrl + Ctrl + gradle clean build javadoc

### To Run the Program 
1. From IntelliJIdea:

- Ctrl + Ctrl + gradle run
- Ctrl + Ctrl + ./gradlew run

2. From terminal
- Go to build/libs folder and execute: java -jar 

## Exercise 2 (Gradle Tasks)
The following exercises are elaborated following gradle documentation.

All the task elaborated must belong to _Personal_ group. Verify with _gradle tasks_ the group creation.
1. Visualize gradle version in the console.
2. Identify gradle version in the console.
3. Define Task1 in ***build.gradle*** that prints "Hello"
4. Define Task2 in ***build.gradle*** that prints "World"
5. Add a group and description to task1 and task2. Run ***gradle tasks*** and identify the new task group.
6. Execute Task1 and Task2 independently. Now execute both at the same time
7. Make Task2 depends on Task1 and execute Task2 alone.
8. Type gradle -h and visualize the help menu of gradle.
9. Define two variables in gradle.property file: msg1 = "Hello" and msg2 = "World". Re-write Task1 and Task2 to use previous variables.
10. Define Task3 in ***build.gradle*** that execute Task1 and Task2. Next change the order of tasks execution to Task2 and Task1 (use _mustRunAfter_). (Task execution in gradle aren't deterministic.)
11. Use finalizeBy to define order of execution (Take care with circular dependency)
12. Create a task class _CustomTask1_ extending DefaultTask in _buildSrc/src/main/groovy_ folder with default constructor. Next create a _Task4_ of type _CustomTask1_ in _build.gradle_ and test the functionality. [See gradle doc](https://docs.gradle.org/current/userguide/more_about_tasks.html#sec:passing_arguments_to_a_task_constructor)
13. Create a task class _CustomTask2_ extending DefaultTask in _buildSrc/src/main/groovy_ folder with 3 arguments: group (String), description(String) and msg(String). Next, create a _Task5_ of type _CustomTask2_ in _build.gradle_ and test the functionality. [See gradle doc](https://docs.gradle.org/current/userguide/more_about_tasks.html#sec:passing_arguments_to_a_task_constructor)
14. Create a task class _CustomTask3_ extending DefaultTask in _buildSrc/src/main/groovy_ folder with 3 arguments: msg(String) and taskDependency (list). Next, create a _Task6_ of type _CustomTask3_ in _build.gradle_ and test the functionality. [See gradle doc](https://docs.gradle.org/current/userguide/more_about_tasks.html#sec:passing_arguments_to_a_task_constructor). Take care of circular dependecy.