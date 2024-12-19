
Here is the full markdown format with the additional content included:

markdown
Copy code
# Pokémon PC System

## 📝 Project Description
The **Pokémon PC System** is a Java-based application integrated with a MySQL database to manage Pokémon storage. It allows users to:
- View stored Pokémon in different storage boxes.
- Deposit Pokémon into storage boxes.
- Withdraw Pokémon back into the party.
- Manage Pokémon details, including types, level, and held items.

This project demonstrates database management concepts, CRUD operations, and Java programming skills.

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

## ⚙️ Requirements
- **Java Development Kit (JDK)**: Version 8 or later
- **MySQL Server**: Version 5.7 or later
- **MySQL Connector/J**: JDBC driver for Java-MySQL integration

---

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

🛠️ Database Schema
Below is the visual representation of the database schema:



🎥 Video Presentation
You can view the video presentation here (update this link with your video URL).

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

