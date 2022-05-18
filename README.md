# Car_Rental_System
It is DBMS based project where cars is listed by the Owners and Customers can take the listed cars on rent. The technology used in this project is Java for the interface and MySQL for the database. The database includes four tables: 

1. Owner Table: It stores all the information regarding the owner such as Owner ID, Owner Name, Address, Email, Password and Joining Date.
2. Customer Table: It stores all the information regarding the customer such as Customer ID, Customer Name, Driving License, Address, Email and Password.
3. Vehicle: It stores all the details of the vehicles registered by the owner such as Vehicle ID, Owner ID, Model, Plate No, Mileage, Rent Price, Condition and Reservation. 
4. Reservation_details Table: It stores the information regarding which customer has booked which vehicle such as Reserve ID, Vehicle ID, Customer ID, Rental Date, Pickup Date, Return Date, Number of Days and Pickup Place.

**Note:** It does not includes any fuctionalities regarding payement or billing system. So in future it is hoped that it will be implemented.

## ER Diagram

![image](https://user-images.githubusercontent.com/79306200/169045003-098a8c4f-4c7d-4428-951b-0b36b2b3a083.png)

## How to Install and Run the Project

First fork the repository in your local machine. Before running any file you have to do certain changes to run into your machine. Enter your MySQL password at root="Your_MySQL_Password" is present.

![image](https://user-images.githubusercontent.com/79306200/169061408-1ca3c138-8c76-41ed-9b45-01b4161df943.png)

Run the code present in sql file either in MySQL client or Workbench. Now you're ready to run the project. Run the Java file.
