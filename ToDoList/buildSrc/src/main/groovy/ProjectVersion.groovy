import org.apache.commons.io.FileUtils
import org.gradle.api.GradleException

class ProjectVersion {
    private int minor
    private int major
    private boolean release

    static ProjectVersion readVersion(String filename){
        def versionFile = new File(filename)
        println "Reading $filename"
        if(!versionFile.exists()){
            throw new FileNotFoundException("Incorrect file path")
        }
        Properties versionProperties = new Properties()
        versionFile.withInputStream(data->versionProperties.load(data))

        return new ProjectVersion(versionProperties.minor.toInteger(),
                versionProperties.major.toInteger(),versionProperties.release.toBoolean())
    }

    ProjectVersion(int minor, int major){
        this.minor = minor
        this.major = major
        this.release = false
    }

    ProjectVersion(int minor, int major, boolean release){
        this(minor,major)
        this.release = release
    }

    ProjectVersion(File versionFile){
        if(!versionFile.exists()){
            throw new GradleException("File:${versionFile.toString()}, does not exists")
        }
        Properties versionProperties = new Properties()
        versionFile.withInputStream {stream->versionProperties.load(stream)}
        this.minor = versionProperties.minor.toInteger()
        this.major = versionProperties.major.toInteger()
        this.release = versionProperties.release.toBoolean()
    }
    void writeVersionFile(File versionFile){
        if(!versionFile.exists()){
            throw new GradleException("File:${versionFile.toString()} does not exists")
        }
        List<String> lines = FileUtils.readLines(versionFile,'UTF-8')
        for(int i = 0; i < lines.size(); i++){
            if(lines.get(i).startsWith("minor")){
                lines.set(i,"minor=${getMinor()}")
            }else if(lines.get(i).startsWith('major')){
                lines.set(i,"major=${getMajor()}")
            }
        }
        FileUtils.writeLines(versionFile,lines);

    }

    void increaseMinor(){
        this.minor++;
    }
    int getMinor(){
        return this.minor;
    }
    void increaseMajor(){
        this.major++;
    }
    int getMajor(){
        return this.major;
    }

    @Override
    String toString(){
        println release
        return "$minor.$major${release?'':'-SNAPSHOT'}"
    }
}
