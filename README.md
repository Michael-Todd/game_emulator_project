# Java Character Banning Emulator

## Overview

This project emulates a **character banning process** inspired by a competitive MOBA video game that I play. Two teams of players independently vote to ban characters from a common pool. The system tallies votes and determines which characters are banned per team.

The **scope of this project is solely the banning mechanism**. All classes, objects, and design decisions are geared toward serving that single purpose -- this is not a full game.

This project was built as a **learning-focused Java project** to showcase my general programming skills, focusing on:

- Object modeling
- Encapsulation and scope control
- Data structures (arrays, HashMaps, records)
- Clear ownership of responsibilities between classes
- Tallying, aggregation, and decision-making logic

---

## Core Concepts

- Each **Player** selects a character to ban.
- Players are divided into **two teams**.
- Each team’s votes are tallied independently.
- The two most-voted characters per team are banned.
- In the case of ties, the banned character is chosen randomly (this mirrors the behavior of the banning process in the game this project gleaned inspiration from).

---

## Project Structure

| Class | Responsibility |
|------|----------------|
| `Player` | Stores pick order and votes for a character to ban. |
| `Pick` | Record holding a player’s ban vote and pick order. |
| `Character` | Represents a playable character by its name. |
| `CharacterPool` | Static pool of unique characters used throughout the project. |
| `TeamBuilder` | Creates players, assigns teams, and gathers ban votes. |
| `BanDecisions` | Tallies votes and determines banned characters. |
| `Main` | Entry point for running and displaying the simulation. |

---

## Example Output

```
From the first team, ban pick 1 is char5
From the first team, ban pick 2 is char4
From the first team, ban pick 3 is char8
From the first team, ban pick 4 is char5
From the first team, ban pick 5 is char1

From the second team, ban pick 1 is char3
From the second team, ban pick 2 is char3
From the second team, ban pick 3 is char6
From the second team, ban pick 4 is char6
From the second team, ban pick 5 is char12

----------------------------------------------

char5 is banned.
char2 is banned.
char3 is banned.
char6 is banned.
```

---

## Skills Demonstrated

- **Java & Object-Oriented Programming**: Encapsulation, records, and separation of responsibilities  
- **Data Structures & Aggregation**: Arrays, HashMaps, Sets, and vote tallying logic  
- **Modeling Structured Data**: Representing players, teams, votes, and events with intentional constraints  
- **Decision-Making Logic**: Random selection, tie handling, and controlled mutation  
- **Code Documentation**: Javadocs and README explanations focused on intent and scope-related tradeoffs  

---

## Design Decisions

### Player Design

- `Player` objects store:
  - A selected `Character` to ban
  - A turn order integer (`pickOrder`)
- The `banCharacter()` method:
  - Randomly selects a `Character`
  - Assigns it internally to the player  
- The method **does not accept a `Character` argument**, keeping player behavior self-contained.

> The idea of passing a banned character into the constructor was explored but abandoned due to the actual flow of decision-making within `BanDecisions`.  
> Similarly, having `banCharacter()` accept a `Character` parameter was abandoned in favor of that responsibility being handled by `CharacterPool`.

---

### Team Separation

- Players are split into **two arrays**, one per team.
- This allows:
  - Symmetric handling of both teams
  - Cleaner vote tallying
  - A model closer to the true structure

> A single combined list of players was abandoned. If combining teams ever became necessary in future extensions, appending the arrays would be simple.

---

### TeamBuilder Responsibility

- `TeamBuilder`:
  - Internally creates all `Player` objects
  - Assigns them to their respective team arrays
  - Handles execution of player ban selections

This consolidation was intentional because:
- The project will **not scale beyond banning**
- Players have no independent lifecycle due to scope of project
- All logic exists solely to support the banning process

> If the project scope expanded, this responsibility would likely be split across multiple classes.

---

### CharacterPool

- `CharacterPool` creates **exactly 12 distinct `Character` objects**
- These objects are reused throughout the project

> This avoids a prior issue where:
> * Characters were generated from strings
> * Multiple `Character` objects could unintentionally represent the same character
>
>Now:
> * Each character exists exactly once
> * Equality and identity are unambiguous

---

### BanDecisions & Vote Tallying

- `BanDecisions`:
  - Accepts ban picks from both teams
  - Tallies votes using internal `HashMap<Character, Integer>` structures
- These maps are **intentionally mutated** during processing (the most-voted character is removed after each ban)

This is acceptable because:
- The maps exist only within `BanDecisions`
- They are not exposed or reused elsewhere
- Their only purpose is to aid in determining bans

> Initially, an ArrayList object internally held the banned characters; the type was later switched to LinkedHashSet in order to prevent duplicate insertions

---

### Pick Objects

- `Pick[]` objects are used throughout `TeamBuilder` and `BanDecisions`
- While `pickOrder` is **not currently used for tie-breaking**, it is intentionally preserved to allow:
  - Possible future tie-resolution logic
  - Expansion without refactoring core structures

---

## Tie Handling Behavior

- No explicit tie-breaking logic is implemented except in one case:
  - If all 5 players on a team vote for the same character, that character is banned
- For all other ties:
  - The banned character is chosen randomly
  - This is a result of iterating over the internal `HashMap` that stores the tallying results

This behavior intentionally mirrors the game that inspired this system:

> Any character with the highest and second-highest vote count is banned, and ties are resolved randomly.

---

## Scope & Intent

- This project is **not a full-game simulation**
- It is **not designed for large-scale extensibility**
- Every class exists to support a single goal: **character banning**

These constraints are intentional and reflected throughout the design.

---

## Possible Future Extensions

- Add a boolean `banned` field to the `Character` class:
  - Initialized to `false`
  - Set to `true` when banned
  - Useful if expanding into character selection or gameplay simulation
