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

    @Override
    String toString(){
        println release
        return "$minor.$major${release?'':'-SNAPSHOT'}"
    }
}
