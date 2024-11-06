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

- [ ] Tester
    - [ ] Have a helper class to do testing
    - [ ] Setup recipe in Makefile to run tests

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
