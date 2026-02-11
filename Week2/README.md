🏦 𝐒𝐢𝐦𝐩𝐥𝐞 𝐁𝐚𝐧𝐤𝐢𝐧𝐠 𝐒𝐲𝐬𝐭𝐞𝐦 (𝐉𝐚𝐯𝐚 𝐂𝐨𝐧𝐬𝐨𝐥𝐞 𝐀𝐩𝐩𝐥𝐢𝐜𝐚𝐭𝐢𝐨𝐧)
________________________________________________________
📌 𝐏𝐫𝐨𝐣𝐞𝐜𝐭 𝐃𝐞𝐬𝐜𝐫𝐢𝐩𝐭𝐢𝐨𝐧
---
This is a console-based Banking System developed using Core Java and JDBC as part of my Java Developer Internship.

The application provides a real-time banking experience where users can manage their accounts through a menu-driven interface. This version uses a MySQL Database for professional data management and persistence.

🚀 𝐅𝐞𝐚𝐭𝐮𝐫𝐞𝐬
---
Create a new bank account with a 10-digit number

Deposit money with real-time balance updates

Withdraw money with automated balance verification

Display account details and current balance

Data stored permanently in a MySQL database

Robust error handling for large numeric inputs


🛠 𝐓𝐞𝐜𝐡𝐧𝐨𝐥𝐨𝐠𝐢𝐞𝐬 𝐔𝐬𝐞𝐝
---
Core Java (JDK 24)

MySQL Database (8.0+)

JDBC (Java Database Connectivity)

OOP Concepts (Abstraction, Inheritance, Encapsulation)

Exception Handling

📂 𝐏𝐫𝐨𝐣𝐞𝐜𝐭 𝐒𝐭𝐫𝐮𝐜𝐭𝐮𝐫𝐞
---
MainBankAccount: Abstract base class for account logic

SavingsAccount: Inherited class for specific account types

BankingSystem: Main execution class and JDBC controller

▶ 𝐇𝐨𝐰 𝐭𝐨 𝐑𝐮𝐧 𝐭𝐡𝐞 𝐏𝐫𝐨𝐣𝐞𝐜𝐭
---
Compile the program:
javac BankingSystem.java

Run the program:
java BankingSystem

Follow the menu options (1-5) in the console.

📁 𝐃𝐚𝐭𝐚 𝐒𝐭𝐨𝐫𝐚𝐠𝐞 𝐅𝐨𝐫𝐦𝐚𝐭
---
Account details are stored in the accounts table in MySQL:
accountNumber, holderName, balance, accountType

Example: 2301109763, Ayush Moon, 9700.0

📚 𝐂𝐨𝐧𝐜𝐞𝐩𝐭𝐬 𝐏𝐫𝐚𝐜𝐭𝐢𝐜𝐞𝐝
--
Object-Oriented Programming

Database CRUD Operations

Managing JDBC Connections

Console-Based Application Development
