import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

import javax.inject.Inject



abstract class CustomTask extends DefaultTask {
    private final String msg

    @Inject
    CustomTask(String group, String descr, String msg) {
        // Task configuration
        setGroup(group)
        description = descr
        // Set task variables
        this.msg = msg

    }

    @TaskAction
    void start(){
        println msg
    }
}

