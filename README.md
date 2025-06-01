# JDBC Batch Insert Demo

This Java program connects to a MySQL database and uses JDBC Batch Processing to insert multiple student records efficiently.

## Features
- Takes user input for `name`, `age`, and `marks`
- Uses `PreparedStatement` to prevent SQL injection
- Adds all records to a batch and executes together
- Efficient for bulk data entry

## Technologies
- Java
- JDBC
- MySQL

## How to Run
1. Replace database `url`, `username`, and `password` in `Main.java`.
2. Compile and run:
```bash
javac Main.java
java Main
