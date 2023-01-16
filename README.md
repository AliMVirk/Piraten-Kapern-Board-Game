# A1 - Piraten Karpen

  * Author: Ali Virk
  * Email: virka9@mcmaster.ca

## Build and Execution

  * To clean your working directory:
    * `mvn clean`
  * To compile the project:
    * `mvn compile`
  * To run the project in development mode:
    * `mvn -q exec:java` (here, `-q` tells maven to be _quiet_)
  * To package the project as a turn-key artefact:
    * `mvn package`
  * To run the packaged delivery:
    * `java -jar target/piraten-karpen-jar-with-dependencies.jar` 

Remark: **We are assuming here you are using a _real_ shell (e.g., anything but PowerShell on Windows)**

## Feature Backlog

 * Status: 
   * Pending (P), Started (S), Blocked (B), Done (D)
 * Definition of Done (DoD):
   * A feature is done if it correctly performs the task it was meant to without any bugs. It should have the expected output for every test case.

### Backlog 

| MVP? | Id  | Feature                                       | Status  | Started  | Delivered |
|------|-----|-----------------------------------------------|---------|----------|-----------|
| x    | F01 | Roll a dice                                   | S       | 01/01/23 |           |
| x    | F02 | Roll eight dices                              | B (F01) |          |
| x    | F03 | End of turn with three skulls                 | P       |          |
| x    | F04 | Player keeping random dice at their turn      | B (F02) |          |
| x    | F05 | Score points: counting gold and diamond       | B (F03) |          | 
| x    | F06 | End of game when a player reaches 6000 points | B (F05) |          | 
|      | F07 | Play 42 games                                 | B (F06) |          |

