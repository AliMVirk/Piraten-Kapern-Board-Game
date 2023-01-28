# A1 - Piraten Karpen

  * Author: Ali Virk
  * Email: virka9@mcmaster.ca

## Build and Execution

  * To clean your working directory:
    * `mvn clean`
  * To compile the project:
    * `mvn compile`
  * To run the project in development mode (where each strategy can be either "random" or "combo"):
    * `mvn -q exec:java -Dexec.args="<player 1 strategy> <player 2 strategy>"` (here, `-q` tells maven to be _quiet_)
  * To package the project as a turn-key artefact:
    * `mvn package`
  * To run the packaged delivery (where each strategy can be either "random" or "combo"):
    * `java -jar target/piraten-karpen-jar-with-dependencies.jar <player 1 strategy> <player 2 strategy>`
  * To run the project in trace mode:
    * `mvn -q exec:java -Dexec.args="<player 1 strategy> <player 2 strategy> log"`
  * To run the packaged delivery in trace mode:
    * `java -jar target/piraten-karpen-jar-with-dependencies.jar <player 1 strategy> <player 2 strategy> log`

Remark: **We are assuming here you are using a _real_ shell (e.g., anything but PowerShell on Windows)**

## Feature Backlog

 * Status: 
   * Pending (P), Started (S), Blocked (B), Done (D)
 * Definition of Done (DoD):
   * A feature is done if it correctly performs the task it was meant to without any bugs. It should have the expected output for every test case.

### Backlog 

| MVP? | Id  | Feature                                                                             | Status | Started  | Delivered |
|------|-----|-------------------------------------------------------------------------------------|--------|----------|-----------|
| x    | F01 | Roll eight dices                                                                    | D      | 01/18/23 | 01/18/23  |
| x    | F02 | End of turn with three skulls                                                       | D      | 01/19/23 | 01/19/23  |
| x    | F03 | Player keeping random dice at their turn                                            | D      | 01/19/23 | 01/20/23  |
| x    | F04 | Score points: count gold, diamond, and combinations                                 | D      | 01/20/23 | 01/23/23  |
| x    | F05 | When a player reaches 6000 points, other player gets 1 more turn then the game ends | D      | 01/20/23 | 01/23/23  |
|      | F06 | Play 42 games                                                                       | D      | 01/21/23 | 01/21/23  |
|      | F07 | Display win percentage of each player                                               | D      | 01/21/23 | 01/21/23  |
|      | F08 | Player rerolls based on prioritizing combinations of dice                           | D      | 01/23/23 | 01/24/23  |
|      | F09 | Player strategies are passed in as command line arguments                           | D      | 01/24/23 | 01/24/23  |
|      | F10 | Fortune cards: sea battle card, monkey business card                                | D      | 01/27/23 | 01/28/23  |
|      | F11 | Shuffling deck of cards                                                             | D      | 01/27/23 | 01/28/23  |
|      | F12 | Score bonus points based on drawn fortune card                                      | D      | 01/27/23 | 01/28/23  |
|      | F13 | Player strategy change based on drawn fortune card                                  | D      | 01/27/23 | 01/28/23  |

