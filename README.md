# Car_Rental_System
It is DBMS based project where cars is listed by the Owners and Customers can take the listed cars on rent. The technology used in this project is Java for the interface and MySQL for the database. The database includes four tables: 

1. Owner Table: It stores all the information regarding the owner such as Owner ID, Owner Name, Address, Email, Password and Joining Date.
2. Customer Table: It stores all the information regarding the customer such as Customer ID, Customer Name, Driving License, Address, Email and Password.
3. Vehicle: It stores all the details of the vehicles registered by the owner such as Vehicle ID, Owner ID, Model, Plate No, Mileage, Rent Price, Condition and Reservation. 
4. Reservation_details Table: It stores the information regarding which customer has booked which vehicle such as Reserve ID, Vehicle ID, Customer ID, Rental Date, Pickup Date, Return Date, Number of Days and Pickup Place.

**Note:** It does not includes any fuctionalities regarding payement or billing system. So in future it is hoped that it will be implemented.

## ER Diagram

![image](https://user-images.githubusercontent.com/79306200/169045003-098a8c4f-4c7d-4428-951b-0b36b2b3a083.png)
