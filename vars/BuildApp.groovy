def call() {
    echo 'Building Java application and running unit tests'
    sh '''
        set -e
        java -version
        mvn -B clean package
        test -d target
        ls -lh target/*.jar
    '''
}
