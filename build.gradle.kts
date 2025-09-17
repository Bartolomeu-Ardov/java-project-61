plugins {
    id("java")
    id("application")
    id("com.github.ben-manes.versions") version "0.51.0"
    id("org.sonarqube") version "5.0.0.4638"
    id("checkstyle")
}

checkstyle {
    toolVersion = "10.12.4"
    config = resources.text.fromFile("config/checkstyle/sun_checks.xml")
    isIgnoreFailures = false
    configProperties = mapOf("org.checkstyle.xsl" to "false")
}

application {
    mainClass.set("hexlet.code.App")
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.withType<Checkstyle>().configureEach {
    reports {
        xml.required.set(false)
        html.required.set(true)
        html.outputLocation.set(layout.buildDirectory.file("reports/checkstyle.html"))
    }
}

tasks.test {
    useJUnitPlatform()

}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

sonar {
    properties {
        property("sonar.projectKey", "Bartolomeu-Ardov_java-project-61")
        property("sonar.organization", "bartolomeu-ardov")
        property("sonar.host.url", "https://sonarcloud.io")
        property("sonar.java.checkstyle.reportPaths", "build/reports/checkstyle/main.xml")
        property("sonar.language", "java")
        property("sonar.sourceEncoding", "UTF-8")
        property("sonar.java.binaries", "build/classes/java/main")
    }
}