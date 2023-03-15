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

    compileOnly("org.projectlombok:lombok:1.18.24")
    implementation("com.google.code.gson:gson:2.10.1")


    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}