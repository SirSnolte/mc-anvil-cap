plugins {
    java
}

group = "de.snolti"
version = "1.0.0"

repositories {
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    // Pinned to the Paper build the network runs (paper-26.3-190).
    compileOnly("io.papermc.paper:paper-api:26.3.build.190-stable")
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(25)
}

tasks.processResources {
    val props = mapOf("version" to project.version)
    inputs.properties(props)
    filesMatching("plugin.yml") {
        expand(props)
    }
}
