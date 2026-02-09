# Java Character Banning Emulator

## Overview

This project implements a **character banning process** inspired by a competitive MOBA video game that I play. Two teams of players independently vote to ban characters from a shared pool. The system tallies votes and determines which characters are banned per team.

The **scope of this project is solely the banning mechanism**. All classes, objects, and design decisions are intentionally constrained to serve that single purpose.

This was built as a learning-focused Java project, emphasizing:
- Object modeling
- Encapsulation and scope control
- Data structures (arrays, HashMaps, records)
- Clear ownership of responsibilities between classes

---

## Core Concepts

- Each **Player** selects a character to ban.
- Players are divided into **two teams**.
- Each team’s votes are tallied independently.
- The two most-voted characters per team is banned.
- In the case of ties, the banned character is chosen randomly (this matches the banning functionality that I've observed from the game this project is inspired by).

---

## Project Structure & Design Decisions

### Player Design

- `Player` objects store:
  - A selected `Character` to ban
  - A turn order integer (`pickOrder`)
- The `banCharacter()` method:
  - Randomly selects a `Character`
  - Assigns it internally to the player  
- The method **does not accept a `Character` argument**, keeping player behavior self-contained.

> The idea of passing a banned character into the constructor was explored, but was later abandoned due to the actual flow of decision-making within `BanDecisions`.

---

### Team Separation

- Players are split into **two arrays**, one per team.
- A single combined list of all players was intentionally avoided.
- This allows:
  - Symmetric handling of both teams
  - Cleaner vote tallying
  - A more intuitive design

If combining all players ever became necessary, appending the arrays would be easy.

---

### TeamBuilder Responsibility

- `TeamBuilder`:
  - Internally creates all `Player` objects
  - Assigns them to their respective team arrays
  - Handles the execution of player ban selections

This decision was made because:
- The project will **not scale beyond banning**
- Players have no independent lifecycle outside this system
- All logic exists solely to support the banning process

If the project were larger in scope, this logic would be split into additional classes.

---

### CharacterPool

- `CharacterPool` creates **exactly 12 distinct `Character` objects**
- These objects are reused throughout the project

This avoids a previous issue where:
- Characters were generated from strings
- Multiple `Character` objects could unintentionally represent the same character

Now:
- Each character exists exactly once
- Equality and identity are unambiguous

---

### BanDecisions & Vote Tallying

- `BanDecisions`:
  - Accepts ban picks from both teams
  - Tallies votes using internal `HashMap<Character, Integer>` structures
- These HashMaps are **intentionally mutated** during processing (namely, removing the most-voted character after each ban)

This is acceptable because:
- The maps exist solely within `BanDecisions`
- They are not reused or exposed elsewhere
- Their only purpose is to aid in determining bans

---

### Pick Objects

- `Pick[]` objects are still used throughout `TeamBuilder` and `BanDecisions` even though this makes the files more verbose than the current state of the project necessitates
- While `pickOrder` is **not currently used for tie-breaking**, it is intentionally preserved to allow:
  - Future tie resolution in the banning process, if I choose to add such logic
  - Expansion without refactoring core structures

---

## Tie Handling Behavior

- There is **no tie-breaking logic implemented**, except for one case:
  - If all 5 players on a team vote for the same character, that character is banned
- For all other ties:
  - The banned character is chosen randomly
  - This is a side effect of iterating over the internal `HashMap` in `BanDecisions`

This behavior intentionally mirrors the game that inspired this system:
> Any character with the highest vote count may be banned, and ties are resolved randomly.

---

## Scope & Intent

- This project is **not** a full game
- It is **not** designed for extensibility or scalability
- Every class exists to support one goal: **character banning**

This constraint is intentional and reflected in the design.
