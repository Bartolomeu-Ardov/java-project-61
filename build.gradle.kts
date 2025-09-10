plugins {
    id("application")
    id("java")
    id("com.github.ben-manes.versions") version "0.51.0"
    id("org.sonarqube") version "6.2.0.5505"
    checkstyle
}

checkstyle {
    toolVersion = "10.12.5"
    config = resources.text.fromFile("sun_checks.xml")
    isIgnoreFailures = false
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

tasks.test {
    useJUnitPlatform()

}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

tasks.withType<Checkstyle>().configureEach {
    reports {
        xml.required = false
        html.required = true
        html.stylesheet = resources.text.fromFile("config/xsl/checkstyle-custom.xsl")
    }
}

sonar {
    properties {
        property("sonar.projectKey", "Bartolomeu-Ardov_java-project-61")
        property("sonar.organization", "bartolomeu-ardov")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}