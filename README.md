# FINAL-PROJECT-IT-211
Pokemon PC System

# Pokémon Storage System - An Educational Game

<p align="center">
   <img src="https://static.vecteezy.com/system/resources/previews/027/127/571/non_2x/pokemon-logo-pokemon-icon-transparent-free-png.png"> 
---

## Table of Contents
- [Overview](#overview)
- [OOP Principles Applied](#oop-principles-applied)
- [SDG Integration: SDG 12 - Responsible Consumption and Production](#sdg-integration-sdg-12---responsible-consumption-and-production)
- [Instructions for Running the Program](#instructions-for-running-the-program)
  - [What the Program Does](#what-the-program-does)
- [How the Game Works](#how-the-game-works)
- [Special Pokémon and Special Abilities](#special-pokémon-and-special-abilities)
- [Interaction with the Program](#interaction-with-the-program)

<p align="center">
   <img src="https://i.pinimg.com/originals/16/22/c5/1622c534aaf80e65a939e24b01e58d04.gif">

---

## Overview
The **Pokémon Storage System** is a console-based application that simulates a **Pokémon storage system**, allowing users to manage their Pokémon by depositing and withdrawing them into storage boxes. This project applies **Object-Oriented Programming (OOP)** principles and connects to **SDG 12: Responsible Consumption and Production**, promoting sustainable practices, responsible resource management, and waste reduction through an engaging Pokémon-themed interface.

---

## OOP Principles Applied

This project demonstrates several key **Object-Oriented Programming (OOP)** principles:

| **Principle**     | **Explanation**                                                                                                                                                                                                                                                                                                                                                                                                                            |
|--------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Encapsulation** | The **`Pokemon`** class encapsulates attributes such as name, types, level, and held items, while using methods (getters and setters) to control access. Fields in the `Pokemon` class are declared as private, restricting direct modification outside the class. Access is controlled through methods like `getName()`, `setHeldItem(String item)`, and `setTypes(String type2)`. The `PokemonStorage` class encapsulates storage logic, exposing interaction methods like `displayBoxContents(int boxIndex)`. |
| **Inheritance**   | The **`Pokemon`** class serves as a base for other Pokémon types, allowing for extension and customization. For example, the `SpecialPokemon` class extends the `Pokemon` class, inheriting fields (e.g., `name`, `types`, `level`, `heldItem`) and methods (e.g., `getName()`, `getLevel()`). Additionally, it adds specific behavior and fields like `specialAbility`. This demonstrates a derived class inheriting properties and behavior from a base class.                                   |
| **Polymorphism**  | Polymorphism is demonstrated through the **`SpecialPokemon`** class, which extends the **`Pokemon`** class. The `toString` method is overridden in the `SpecialPokemon` subclass to include a **special ability** attribute, enabling different behaviors depending on the object type.                                                                                                                                                  |
| **Abstraction**   | The **`Pokemon`** class is abstract, providing a blueprint for creating different types of Pokémon. Abstract classes cannot be instantiated directly (e.g., `new Pokemon()`) and require subclasses (e.g., `SpecialPokemon`) to implement additional functionality. Abstraction hides complexity; for instance, users of the `PokemonPCSystem` interact with methods like `depositPokemon()` without needing to know the internal storage details.                                 |


<p align="center">
   <img src= "https://poketouch.files.wordpress.com/2019/05/eevee_sparkles_gif.gif">

---

## SDG Integration: SDG 12 - Responsible Consumption and Production
This project is aligned with **SDG 12: Responsible Consumption and Production**, which focuses on **sustainable resource management** and **minimizing waste**. The **Pokémon Storage System** encourages players to manage their Pokémon efficiently, limiting the number of Pokémon that can be stored in a box at once and ensuring no overuse of space. This mirrors the real-world concept of **managing finite resources** in a sustainable and responsible manner.

### Key ways this project integrates SDG 12:
| **SDG Concept**            | **Project Application**                                                                 |
|----------------------------|-----------------------------------------------------------------------------------------|
| **Resource Management**    | Just as businesses must manage resources, the system enforces **limits on storage capacity**, ensuring that players cannot exceed the set capacity of the boxes. |
| **Waste Minimization**     | The system encourages players to make thoughtful decisions about what Pokémon to store or withdraw, minimizing waste by using storage efficiently.     |
| **Educational Value**      | The game helps children understand **sorting, managing, and reducing waste** in a fun and engaging way, teaching important life skills on sustainability and resource management. |

<p align="center">
   <img src= "https://static.tumblr.com/127d00a19811bf5d6c989d4ce391e370/45yz63s/qt1pe0gyc/tumblr_static_tumblr_static_4zgpa2d196gwwgos0k8gok4ok_focused_v3.gif">

---

### What the Program Does
The **Pokémon Storage System** allows players to manage their Pokémon through a **virtual Pokémon PC system**. The game is organized into three main actions: **Depositing Pokémon**, **Withdrawing Pokémon**, and **Managing Items**.

<p align="center">
   <img src="https://pngimg.com/uploads/pokeball/pokeball_PNG29.png" width="250" height="250">  <!-- Pokéball Icon -->

| **Action**                | **Description**                                                                                           |
|---------------------------|-----------------------------------------------------------------------------------------------------------|
| **View Pokémon Storage**  | Displays the current contents of the Pokémon boxes (up to 2 Pokémon per box).                              |
| **Deposit Pokémon**       | Allows the user to deposit a Pokémon from their party into one of the boxes, with a capacity of 2 Pokémon per box. |
| **Withdraw Pokémon**      | Lets the user withdraw a Pokémon from the box and add it back to the party, with a maximum of 6 Pokémon in the party. |
| **Deposit Item**          | Users can assign an item to a Pokémon in the party and transfer it to a Pokémon in the storage boxes.      |
| **Withdraw Item**         | Lets the user withdraw an item from a Pokémon in the storage box. The item can then be assigned to a Pokémon in the party or discarded. |
| **Exit**                  | Exits the program after a prompt confirming exit.                                                         |

---

## How the Game Works

| **Feature**               | **Description**                                                                 |
|---------------------------|---------------------------------------------------------------------------------|
| **Managing Pokémon**      | You can store up to 2 Pokémon per box (with 3 boxes in total). The game prevents you from exceeding this capacity, encouraging critical thinking about space management. |
| **Depositing & Withdrawing Pokémon** | You can deposit and withdraw Pokémon from your party into the storage system while maintaining balance and organization. |
| **Item Management**       | Items can be assigned to Pokémon, and the game allows swapping items between Pokémon in your party and storage, emphasizing efficient resource use. |

<p align="center">
   <img src="https://pa1.narvii.com/6201/fac18f22f6333faa69d85712e83266dedaa504f0_hq.gif">  <!-- Pokémon Storage Animation -->

---

## Special Pokémon and Special Abilities
In addition to basic Pokémon management, the system also demonstrates the use of **polymorphism** with the **`SpecialPokemon`** class. 

- **`SpecialPokemon`** is a subclass that extends the base **`Pokemon`** class.
- It introduces a unique attribute, the **special ability**, which can represent various special powers a Pokémon might possess (e.g., "Fire Blast", "Thunder Shock").
- The **`toString`** method is overridden in **`SpecialPokemon`** to display the special ability of each Pokémon, differentiating it from regular Pokémon. This allows for different behaviors based on the specific Pokémon type.

---
<p align="center">
   <img src="https://i.pinimg.com/originals/9f/1d/58/9f1d582d5a8045fec25f03530d73dd24.gif">
   
## Interaction with the Program

First in order to run the program make sure to:
    -Use Visual Studio Code (or any Java-supported IDE).

Below are the detailed interactions and possible outcomes when using the Pokémon Storage System:

| **Interaction**                              | **Description**                                                                                                                                                           |
|----------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Number of Pokémon in Party**               | Prompts user to enter how many Pokémon are in their party (1-6). Invalid inputs trigger retry prompts.                                                                  |
| **Entering Pokémon Details**                 | Collects Pokémon details such as name, type(s), level, and held item. Ensures validation for types and levels, prompting corrections for invalid inputs.                 |
| **Viewing Pokémon Storage**                  | Displays the contents of each storage box. Shows details of each Pokémon or displays "No Pokémon in this box" if the box is empty.                                      |
| **Depositing Pokémon**                       | Allows the user to deposit a Pokémon from their party into a storage box. Enforces box capacity limits (2 Pokémon per box) and validates inputs.                         |
| **Withdrawing Pokémon**                      | Enables withdrawal of Pokémon from a box to the party. Prevents withdrawal if the party already has 6 Pokémon or if the selected box is empty.                          |
| **Depositing Items**                         | Transfers an item from a Pokémon in the party to one in storage. Items are swapped if the storage Pokémon already holds an item, ensuring efficient item management.     |
| **Withdrawing Items**                        | Lets the user withdraw an item from a Pokémon in storage. Items can be reassigned to a party Pokémon or discarded, with swap functionality if a Pokémon is already holding an item. |
| **Special Pokémon Interaction**              | Displays special abilities of `SpecialPokemon` using polymorphism. Differentiates them from regular Pokémon through unique attributes.                                  |
| **Exiting the System**                       | Ends the session with a farewell message: "Thank you for using the Pokémon PC! Have a great adventure, Trainer!"                                                        |

---

