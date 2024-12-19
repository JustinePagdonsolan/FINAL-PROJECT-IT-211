# Pokémon PC System

<p align="center">
   <img src="https://static.vecteezy.com/system/resources/previews/027/127/571/non_2x/pokemon-logo-pokemon-icon-transparent-free-png.png"> 

## 📝 Project Description
The **Pokémon PC System** is a Java-based application integrated with a MySQL database to manage Pokémon storage. It allows users to:
- View stored Pokémon in different storage boxes.
- Deposit Pokémon into storage boxes.
- Withdraw Pokémon back into the party.
- Manage Pokémon details, including types, level, and held items.

This project demonstrates database management concepts, CRUD operations, and Java programming skills.

<p align="center">
   <img src="https://i.pinimg.com/originals/16/22/c5/1622c534aaf80e65a939e24b01e58d04.gif">

---

## 🖥️ Features
| Feature                     | Description                                                                 |
|-----------------------------|-----------------------------------------------------------------------------|
| **View Pokémon Storage**    | Displays Pokémon stored in each box, with their details like types and items. |
| **Deposit Pokémon**         | Allows users to deposit Pokémon into specific storage boxes.                |
| **Withdraw Pokémon**        | Enables users to withdraw Pokémon from storage boxes into the party.        |
| **Database Integration**    | Uses MySQL for data persistence, ensuring data is saved and retrievable.    |

---

## 📂 Project Structure
| File/Directory       | Description                                                                     |
|-----------------------|---------------------------------------------------------------------------------|
| `src/`               | Contains the Java source code for the project.                                 |
| `db/init.sql`        | SQL script for creating the database schema and populating initial data.        |
| `db/schema.png`      | Visual diagram of the database schema.                                          |
| `README.md`          | Documentation file for the project.                                            |

---

<p align="center">
   <img src= "https://poketouch.files.wordpress.com/2019/05/eevee_sparkles_gif.gif">

## ⚙️ Requirements
- **Java Development Kit (JDK)**: Version 8 or later
- **MySQL Server**: Version 5.7 or later
- **MySQL Connector/J**: JDBC driver for Java-MySQL integration

---
<p align="center">
   <img src= "https://static.tumblr.com/127d00a19811bf5d6c989d4ce391e370/45yz63s/qt1pe0gyc/tumblr_static_tumblr_static_4zgpa2d196gwwgos0k8gok4ok_focused_v3.gif">
   
## 📖 How to Run the Project

### 1️⃣ **Database Setup**
1. Open your MySQL client (Workbench or command line).
2. Run the SQL script located in `db/init.sql` to create the database schema:
   ```sql
   CREATE DATABASE pokemon_pc;
   USE pokemon_pc;

   CREATE TABLE boxes (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(50) NOT NULL
   );

   CREATE TABLE pokemons (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(50),
       type1 VARCHAR(20),
       type2 VARCHAR(20),
       level INT,
       held_item VARCHAR(50),
       box_id INT,
       FOREIGN KEY (box_id) REFERENCES boxes(id)
   );

   INSERT INTO boxes (name) VALUES ('Box 1'), ('Box 2'), ('Box 3');
Verify that the tables boxes and pokemons are created.

<p align="center">
   <img src="https://i.pinimg.com/originals/9f/1d/58/9f1d582d5a8045fec25f03530d73dd24.gif">

2️⃣ Application Setup
Download and add the MySQL Connector/J library to your Java project.

Update the database credentials in the DatabaseHelper class:

java
Copy code
private static final String URL = "jdbc:mysql://localhost:3306/pokemon_pc";
private static final String USER = "your_username";
private static final String PASSWORD = "your_password";
Compile and run the program using your IDE or command line.

3️⃣ Using the Application
Follow the on-screen menu to view storage, deposit Pokémon, or withdraw Pokémon.

✨ Key Takeaways
Demonstrates CRUD operations with a relational database.
Showcases database integration with a Java application.
Implements effective Pokémon management with data persistence.

🤝 Acknowledgments
Instructor: Mr. Owen Patrick F. Falculan
Institution: Batangas State University

🖋️ Author
Name: Justine A. Pagdonsolan
Course: IT211 - Database Management Systems

