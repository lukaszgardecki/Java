# Minesweeper

Minesweeper is a simple desktop puzzle game written in Java. The player uncovers fields on a grid while avoiding hidden mines. The interface is built with Swing and includes a mine counter, timer, difficulty menu, and three board sizes.

## How it works

- Left-click a field to reveal it.
- Numbers show how many mines are adjacent to that field.
- Revealing a mine ends the game.
- The goal is to reveal every field that does not contain a mine.
- Choose a difficulty from the **Plik** menu or restart the current board.

## Difficulty levels

| Level | Board | Mines |
|---|---:|---:|
| Początkujący (Easy) | 9 × 9 | 10 |
| Średniozaawansowany (Intermediate) | 16 × 16 | 40 |
| Ekspert (Expert) | 30 × 16 | 100 |

## Requirements

- Java 21 or newer
- Maven

## Run the project

Open a terminal in this folder and compile it:

```bash
mvn compile
```

Then start the application with:

```bash
java -cp target/classes game.Main
```

The program can also be launched directly from IntelliJ IDEA or another Java IDE:

1. Open `_MINI_Programy/Minesweeper` as a Maven project.
2. Wait for dependencies and project sources to load.
3. Run `src/main/java/game/Main.java`.

## Build

Create the compiled project output with:

```bash
mvn package
```

## Project structure

- `Main.java` starts the application and holds the selected level.
- `MainFrameSaper.java` creates the Swing window and icon.
- `MainContainer.java` organizes the menu and game area.
- `MainPanel.java` combines the board, timer, and score panels.
- `Game.java` manages difficulty, board size, mine count, and end-game state.
- `Level.java` defines the Easy, Intermediate, and Expert configurations.
- `MenuSaper.java` provides the Polish game menu and difficulty selection.
- `BoardButtonsPanel.java` and `FieldButton.java` represent the clickable minefield.
- `BoardLabelPanel.java` and `FieldLabel.java` represent the revealed field values.
- `ScoreTimePanel.java` displays the mine count and elapsed time.
- `images/` contains graphics used by the interface.
