import kotlin.random.Random.Default
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

import javax.inject.Inject

class DefaultTask3 extends DefaultTask{
    private String msg;
    @Inject
    DefaultTask3(String msg, List dependencies){
        //Task configuration
        setGroup('Personal')
        setDescription('Personal task with dependencies')
        setDependsOn(dependencies)
        // Task instance variables
        this.msg = msg
    }
    @TaskAction
    void start(){
        println msg
    }
}
