# AnvilCap

A tiny Paper plugin that gets rid of the anvil's "Too Expensive!" limit.

The vanilla client refuses any anvil result that costs 40 levels or more. AnvilCap lifts the
server-side limit and caps the shown and charged cost at 39 levels, so every combination the
server allows can actually be taken out of the anvil.

## Requirements

- Paper 26.3 (`api-version: 26.3`)
- Java 25

## Installation

Drop `AnvilCap-<version>.jar` into the server's `plugins/` folder and restart. There is no
configuration and there are no commands or permissions.

## Building

The build needs a JDK 25 with `javac`:

    JAVA_HOME=/path/to/jdk-25 ./gradlew build

The jar lands in `build/libs/AnvilCap-<version>.jar`. The plugin version is set once in
`build.gradle.kts` and copied into `plugin.yml` during the build.
