# Minesweeper

<p align="center">
  <img src="https://github.com/user-attachments/assets/848e17e5-991d-4809-a10a-58dd400e26f3" alt="Saper - plansza startowa" width="265" />
  <img src="https://github.com/user-attachments/assets/d944730c-38f2-461e-9038-3add423370af" alt="Saper - plansza wygrana" width="265" />
  <img src="https://github.com/user-attachments/assets/4c3fceba-032b-43c7-a3b6-5c4a582d2c1f" alt="Saper - plansza przegrana" width="265" />
</p>

Minesweeper is a simple desktop puzzle game written in Java. The player uncovers fields on a grid while avoiding hidden mines. The interface is built with Swing and includes a mine counter, timer, difficulty menu, and three board sizes.
## How it works

- **Left-click** a covered field to reveal it.
- **Right-click** a covered field to cycle between placing a flag, a question mark, and clearing the mark.
- **Middle-click** (or press **Left + Right** mouse buttons simultaneously) on a numbered field to reveal the surrounding 3×3 area, provided the matching number of flags has already been placed around it.
- Numbers show how many mines are adjacent to that field.
- Revealing a mine ends the game.
- The goal is to reveal every field that does not contain a mine.
- Choose a difficulty or restart the current board from the **Plik** menu.

## Difficulty levels

| Level | Board | Mines |
|---|---:|---:|
| Easy | 9 × 9 | 10 |
| Intermediate | 16 × 16 | 40 |
| Expert | 30 × 16 | 100 |

### Easy board
<p align="center">
  <img width="388" height="509" alt="Saper - poziom łatwy" src="https://github.com/user-attachments/assets/de865cb6-3637-4b75-ab87-f50a61c49dec" />
</p>

### Intermediate board
<p align="center">
  <img width="668" height="789" alt="Saper - poziom średniozaawansowany" src="https://github.com/user-attachments/assets/7bacc9e5-4bda-44e1-b94a-4ad4aa25f215" />
</p>

### Expert board
<p align="center">
  <img width="1225" height="786" alt="Saper - poziom ekspert" src="https://github.com/user-attachments/assets/8e2742c8-4749-4b71-a985-15a1438c14a5" />
</p>

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
