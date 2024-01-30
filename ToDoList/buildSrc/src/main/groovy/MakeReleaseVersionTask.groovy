import org.apache.commons.io.FileUtils
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import javax.inject.Inject

class MakeReleaseVersionTask extends DefaultTask{
    @OutputFile
    File versionPropertyFile  // Not a constructor argument. Defined in the closure of the task
    @Input
    Boolean release  // Not a constructor argument. Defined in the closure of the task
    @Inject
    MakeReleaseVersionTask(){
        setGroup('Versioning')
        setDescription('Change release version property value')
    }
    @TaskAction
    void start(){
        println "Changing release value in version.properties to $release"
        if(versionPropertyFile.exists()){
            List<String> lines = FileUtils.readLines(versionPropertyFile,"UTF-8")
            if(release == true){
                lines.set(2,'release=true')
            }else if(release == false){
                lines.set(2, 'release=false')
            }else{
                throw new InputMismatchException('Incorrect release value (true / false)')
            }
            FileUtils.writeLines(versionPropertyFile,lines)
        }else{
            throw new FileNotFoundException("File not found")
        }
    }
}
