import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

import javax.inject.Inject



abstract class DefaultTask1 extends DefaultTask {
    @Inject
    DefaultTask1() {
        // Task configuration
        setGroup('Personal')
        description = 'Default task with no constructor arguments'
    }

    @TaskAction
    void start(){
        println getDescription()
    }
}

