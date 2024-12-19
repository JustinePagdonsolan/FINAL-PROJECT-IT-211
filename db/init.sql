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
