# avaj-launcher

- Use the provided UML class diagram to implement the classes
- Must use OOP design patterns
    - Observer
    - Singleton
    - Factory
- Use Java
- Clean design, easy to read and understand, easy to update
- Try to compile Java code on your own, use a simple text editor like VSCode

## Todo list

**Main Program**

- [ ] Parse the scenario file
    - [ ] First line should be a **positive integer number**.
    - [ ] The following lines should follows this syntax:
        
        ```text
        TYPE NAME LONGITUDE LATITUDE HEIGHT
        ```

    - [ ] There are 3 `TYPE`, aka Aircrafts. JetPlane, Helicopter, Baloon.
    - [ ] Coordinates (`LONGITUDE`, `LATITUDE`, `HEIGHT`) are positive numbers.
    - [ ] Height is in the **0-100** range
    - [ ] **(OWN)** Allows any whitespaces. Leading, in between and trailing.

- [x] Tester
    - [x] Have a helper class to do testing
    - [x] Setup recipe in Makefile to run tests

## Setup

```text
src/
    main/
        java/
            com/fourtytwo/avajlauncher/
                util/
                [features]/
    test/
        java/
            com/fourtytwo/avajlauncher/
                [features]/
                    [FeatureTest.java]
                resources/
```

- All the main class will be residing in `main/` folder.
- All the test cases class will be resideing in `test/` folder.
- `src/main/java/.../util/` will have all the utilities class, including shared ones.
- The folder in `main/` and `test/` will be mirrored.
- All the test cases (eg: txt files) will be placed in `resources/` folder.

### Test setup

1. One main test suite class to serve as the entry point and execute each individual test class.
2. For each of the FeatureTestClass, will have a `runTests()` method to group all tests for each class.
3. Have a group of utility functions to do testing.
4. Group related test classes together in a folder.

### How to decide if a class should go in a `utils` folder or its own dedicated folder

1. Does it only contain static methods or helper methods? -> Place in `utils`.
2. Does it represent a core concept or entity in the application? -> Place in a domain-specific folder.
3. Is it used only within a specific module? -> Place it in that module's folder.
4. Does it provide generic functionality used across the application? -> Place in `utils`.

## General Instructions

- Use language features up to the latest Java LTS version
- No external libraries, build tools or code generators.
- Do not use the default package
- Create your own relevant packages following the Java package naming convetions
- Do not commit `.class` files
- `javac` and `java` should be available as commands in terminal
- Compile the project running the commands bellow in the root of your project folder:

```shell
find * -name "*.java" > sources.txt
javac @sources.txt
```

## Mandatory part

- Need to implement every detail provided in the diagram
- Can add more classes or include additional attributes if you think it is necessary, but do not change access modifiers or the class hierarchy for the classes provided in the diagram.

### Program behaviour

Program should take in one argument, which is the name of a text file that will contain the scenario that needs to be simulated. Example file is provided with the subject. Executing the program will generate a file `simulation.txt`that describes the outcome of the simulation.

### Scneario file

The first line of the file contains a **positive integer number**. This number represents the number of times the simulation is run.

## Concepts

### Dependency Injection (DI)

Dependency Injection is a design principle where an object (like a class) receives its dependencies from an external source rather than creating them itself. This improves modularity and makes the code easier to test, extend, and maintain by reducing direct coupling between classes.

#### How Dependency Injection Works

Let's say you have a `FileParser` that needs a `HeaderParser` and `ContentParser`. Without DI, `FileParser` would create instances of `HeaderParser` and `ContentParser` itself, directly coupling it to those specific implementations. DI separates this responsibility by "injecting" those dependencies into `FileParser`, either via the constructor or a setter method.

#### DI in Practice

1. **Constructor Injection**: Pass the dependencies as parameters in the constructor. This is ideal if the dependencies are essential for the object's function.
2. **Setter Injection**: Inject dependencies through setter mtehods. This allows the dependencies to be optional or configurable after the object is created.

