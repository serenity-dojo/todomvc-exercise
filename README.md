# Serenity Dojo: UI Testing

In this project, you will write tests for a simple web application (see http://todomvc.com/examples/react/#/)
One test has already been written to get you started.

## Getting started
### Get the code

Git:

    git clone https://github.com/serenity-bdd/serenity-junit-starter.git
    cd serenity-junit-starter

Or simply [download a zip](https://github.com/serenity-bdd/serenity-junit-starter/archive/master.zip) file.

### Use Maven

Open a command window and run:

    mvn clean verify

### Use Gradle

Open a command window and run:

    gradlew test 

### Viewing the reports

Both of the commands provided above will produce a Serenity test report in the `target/site/serenity` directory. Go take a look!

## Writing the tests

One `PageLayout` test has been written for you as an example.

Your task is to implement the following additional tests (do as many as you can):
* Adding a single item to the todo list and verify its presence
* Add several items and verify their presence
* Mark an item complete, and check that it is shown as crossed out
* Mark an item as complete, and filter the items to only show Active items
* Mark an item as complete, and filter the items to only show Completed items
* Mark an item as complete, and click on "Clear completed" - verify that the completed item is correctly removed
