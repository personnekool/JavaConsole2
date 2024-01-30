import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

import javax.inject.Inject

class DefaultTask2  extends DefaultTask{
    private final String msg
    @Inject
    DefaultTask2(String group, String descr, String msg){
        // Task configuration
        setGroup(group)
        setDescription(descr)
        // Task instance variables settings
        this.msg = msg
    }

    @TaskAction
    void start(){
        println getDescription()
        println this.msg
    }
}
