# 🎓 College Admission System

A Java-based console application designed to manage the college admission process.  
The system handles student applications, course selection, merit-based admission, and admin approval.

---

## 📌 Features

- Student registration and application
- Course management
- Merit-based admission processing
- Admin approval system
- Database connectivity using JDBC
- CSV-based admission list handling

---

## 🛠️ Technologies Used

- Java (JDK 21)
- JDBC
- MySQL
- Eclipse / STS
- Git & GitHub

---

---

## ⚙️ Database Setup

```sql
CREATE DATABASE college_admission;

USE college_admission;

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    marks DOUBLE,
    course VARCHAR(50),
    status VARCHAR(20)
);
▶️ How to Run the Project

Open the project in Eclipse / Spring Tool Suite

Configure MySQL credentials in:

DBConnection.java


Ensure MySQL server is running

Run:

MainApp.java


Follow console instructions

👩‍💻 Author

Megha Rajan
Java Full Stack Developer

📜 License

This project is for educational purposes.


---

### ✅ Step 2: Commit README and push

```bash
git add README.md
git commit -m "Added README file"
git push


## 📂 Project Structure

