plugins {
    id("java")
}

group = "org.name16tuoimatem"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.hibernate:hibernate-core:6.1.7.Final")
    implementation("com.mysql:mysql-connector-j:8.0.32")
    implementation("org.apache.logging.log4j:log4j-core:2.20.0")
    compileOnly("org.projectlombok:lombok:1.18.26")
    annotationProcessor("org.projectlombok:lombok:1.18.26")

    implementation("com.google.code.gson:gson:2.10.1")


    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}