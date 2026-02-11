# 🏦 𝐒𝐢𝐦𝐩𝐥𝐞 𝐁𝐚𝐧𝐤𝐢𝐧𝐠 𝐒𝐲𝐬𝐭𝐞𝐦 (𝐉𝐚𝐯𝐚 𝐂𝐨𝐧𝐬𝐨𝐥𝐞 𝐀𝐩𝐩𝐥𝐢𝐜𝐚𝐭𝐢𝐨𝐧)

## 📌 𝐏𝐫𝐨𝐣𝐞𝐜𝐭 𝐃𝐞𝐬𝐜𝐫𝐢𝐩𝐭𝐢𝐨𝐧
*This is a console-based Banking System developed using **Core Java** and **JDBC** as part of my **Task 2** for the Java Developer Internship at **WeIntern**.*

*The application provides a real-time banking experience where users can manage their accounts through a menu-driven interface. This version utilizes a **MySQL Database** for professional data management and persistence.*

## 🚀 𝐅𝐞𝐚𝐭𝐮𝐫𝐞𝐬
* *Create a new bank account with a unique 10-digit number.*
* *Deposit money with real-time database updates.*
* *Withdraw money with automated balance verification.*
* *Display account details including holder name and current balance.*
* *Data stored permanently in a MySQL database.*
* *Robust error handling for large numeric inputs (BIGINT).*

## 🛠 𝐓𝐞𝐜𝐡𝐧𝐨𝐥𝐨𝐠𝐢𝐞𝐬 𝐔𝐬𝐞𝐝
* **Core Java** (JDK 24)
* **MySQL Database** (8.0+)
* **JDBC** (Java Database Connectivity)
* **OOP Concepts** (Abstraction, Inheritance, Encapsulation)

## 📂 𝐏𝐫𝐨𝐣𝐞𝐜𝐭 𝐒𝐭𝐫𝐮𝐜𝐭𝐮𝐫𝐞
* **MainBankAccount**: *Abstract base class for account logic.*
* **SavingsAccount**: *Inherited class for specific account types.*
* **BankingSystem**: *Main execution class and JDBC controller.*

##▶ 𝐇𝐨𝐰 𝐭𝐨 𝐑𝐮𝐧 𝐭𝐡𝐞 𝐏𝐫𝐨𝐣𝐞𝐜𝐭
𝐃𝐚𝐭𝐚𝐛𝐚𝐬𝐞 𝐒𝐞𝐭𝐮𝐩: Run the SQL script provided in the schema.sql file to create the Banking_System database and accounts table.

𝐀𝐝𝐝 𝐋𝐢𝐛𝐫𝐚𝐫𝐲: Download the mysql-connector-j-9.6.0.jar and place it in your project folder.

𝐂𝐨𝐧𝐟𝐢𝐠𝐮𝐫𝐚𝐭𝐢𝐨𝐧: Open BankingSystem.java and update the USER and PASSWORD variables with your MySQL credentials.

𝐂𝐨𝐦𝐩𝐢𝐥𝐞 & 𝐑𝐮𝐧

java -cp ".;mysql-connector-j-9.6.0.jar" BankingSystem

𝐅𝐨𝐥𝐥𝐨𝐰 𝐌𝐞𝐧𝐮: Use the numeric options (1-5) displayed in the console to perform banking operations.

## 📁 𝐃𝐚𝐭𝐚 𝐒𝐭𝐨𝐫𝐚𝐠𝐞 𝐅𝐨𝐫𝐦𝐚𝐭
*Account details are stored in the **accounts** table in MySQL:*
*`accountNumber, holderName, balance, accountType`*

## 📚 𝐂𝐨𝐧𝐜𝐞𝐩𝐭𝐬 𝐏𝐫𝐚𝐜𝐭𝐢𝐜𝐞𝐝
* *Object-Oriented Programming (OOP)*
* *Database CRUD Operations*
* *Managing JDBC Connections & Handshakes*
* *Console-Based Application Development*

### 𝐉𝐚𝐯𝐚 𝐃𝐞𝐯𝐞𝐥𝐨𝐩𝐞𝐫 𝐈𝐧𝐭𝐞𝐫𝐧 | 𝐖𝐞I𝐧𝐭𝐞𝐫𝐧
