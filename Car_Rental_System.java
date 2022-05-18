import java.sql.*;
import java.util.*;

public class Car_Rental_System {

    // CUSTOMER LOGIN PAGE
    public static void customer_login()
    {
        String email, pass;
        Scanner sc = new Scanner(System.in);
        boolean isDetailsCorrect = false;
       
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("\t\t\t-------------------");
        System.out.println("\t\t\tCustomer Login Page");
        System.out.println("\t\t\t-------------------");
        System.out.println();

        while(true){

            // Taking Email and Password as input
            System.out.print("\tEmail: ");
            email = sc.nextLine();
            System.out.println(); 
            System.out.print("\tPassword: ");
            pass = sc.nextLine();
            System.out.println();

            try{  
                Class.forName("com.mysql.jdbc.Driver");  
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental_system","root","Perin@3016");  
                
                Statement stmt=con.createStatement();  

                // Query to obtain all email and password form owner table
                String query="SELECT email, pass FROM customer";
                ResultSet rs=stmt.executeQuery(query);  
                
                while(rs.next()){

                    // Checking whether login details are correct or not
                    if(rs.getString(1).equals(email) &&  rs.getString(2).equals(pass)){
                        isDetailsCorrect = true;
                        break;
                    }  
                }
                
                if(isDetailsCorrect==false){
                    System.out.println("\n\n\tWrong Credentials\n\tPlease enter correct Email and Password\n");
                }
                con.close();  
                
            } catch(Exception e){ 
                System.out.println(e);
            }     
            
            if(isDetailsCorrect==true){
                break;
            } 
        }

        customer_page();
    }
        
    // OWNER LOGIN PAGE
    public static void owner_login()
    {
        String pass, email;
        Scanner sc = new Scanner(System.in);
        boolean isDetailsCorrect = false;
       
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("\t\t\t----------------");
        System.out.println("\t\t\tOwner Login Page");
        System.out.println("\t\t\t----------------");
        System.out.println();

        while(true){
            
            // Taking Email and Password as input
            System.out.print("\tEmail: ");
            email = sc.nextLine();
            System.out.println(); 
            System.out.print("\tPassword: ");
            pass = sc.nextLine();
            System.out.println();

            try{  
                Class.forName("com.mysql.jdbc.Driver");  
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental_system","root","Perin@3016");  
                
                Statement stmt=con.createStatement();  
                
                // Query to obtain all email and password form owner table
                String query="SELECT email, pass FROM owner";
                ResultSet rs=stmt.executeQuery(query);  
                
                while(rs.next()){

                    // Checking whether login details are correct or not
                    if(rs.getString(1).equals(email) &&  rs.getString(2).equals(pass)){
                        isDetailsCorrect = true;
                        break;
                    }  
                }
                
                if(isDetailsCorrect==false){
                    System.out.println("\n\n\tWrong Credentials\n\tPlease enter correct Email and Password\n");
                }
                con.close();  

            } catch(Exception e){ 
                System.out.println(e);
            }     
            
            if(isDetailsCorrect==true){
                break;
            } 
        }

        owner_page();
    }

    public static void customer_signUp() {
        String customer_name, customer_id, driving_license, address, email, pass;

        Scanner sc = new Scanner(System.in);
        
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("\t\t\t---------------------");
        System.out.println("\t\t\tSignup Page(Customer)");
        System.out.println("\t\t\t---------------------");
        System.out.println();
        
        System.out.print("\tCustomer ID: ");
        customer_id = sc.nextLine();
        System.out.println(); 
        System.out.print("\tCustomer Name: ");
        customer_name = sc.nextLine();
        System.out.println();
        System.out.print("\tDriving License No: ");
        driving_license = sc.nextLine();
        System.out.println();
        System.out.print("\tAddress : ");
        address = sc.nextLine();
        System.out.println();
        System.out.print("\tEmail: ");
        email = sc.nextLine();
        System.out.println();
        System.out.print("\tPassword: ");
        pass = sc.nextLine();
        System.out.println();
        
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental_system","root","Perin@3016");  
            
            Statement stmt = con.createStatement();

            // Query to insert Sign Up details into the Database;
            String q1="INSERT INTO customer VALUES ('"+customer_id+"' , '"+customer_name+"', '"+driving_license+"', '"+address+"' , '"+email+"', '"+pass+"')";
            
            stmt.executeUpdate(q1);
            con.close();  

        } catch(Exception e){ 
            System.out.println(e);
        }

        customer_login();
    }

    // OWNER SIGN UP PAGE
    public static void owner_signUp() {
	
        String owner_name, owner_id, email, pass, address, joining_date;
        Scanner sc = new Scanner(System.in);
       
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("\t\t\t------------------");
        System.out.println("\t\t\tSignup Page(Owner)");
        System.out.println("\t\t\t------------------");
        System.out.println();
        
        // Taking all Sign Up details as input
        System.out.print("\tOwner ID: ");
        owner_id = sc.nextLine();
        System.out.println(); 
        System.out.print("\tOwner Name: ");
        owner_name = sc.nextLine();
        System.out.println();
        System.out.print("\tJoining Date: ");
        joining_date = sc.nextLine();
        System.out.println();
        System.out.print("\tEmail: ");
        email = sc.nextLine();
        System.out.println();
        System.out.print("\tPassword: ");
        pass = sc.nextLine();
        System.out.println();
        System.out.print("\tAddress: ");
        address = sc.nextLine();
        System.out.println();

        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental_system","root","Perin@3016");  
            
            Statement stmt = con.createStatement();  

            // Query to insert Sign Up details into the Database
            String q1="INSERT INTO owner VALUES ('"+owner_id+"', '"+owner_name+"', '"+address+"', '"+email+"', '"+pass+"', '"+joining_date+"')";
    
            stmt.executeUpdate(q1);
            con.close(); 

        } catch(Exception e){ 
            System.out.println(e);
        }     
           
        owner_login();  
    }

    // OWNER PAGE
    public static void owner_page() {

        
        String owner_id;
        
        Scanner sc = new Scanner(System.in);

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("\t\t\t--------------------");
        System.out.println("\t\t\tVehicle Registration");
        System.out.println("\t\t\t--------------------");
        System.out.println();

        // Taking Owner ID as input
            System.out.print("\tOwner ID: ");
            owner_id  = sc.nextLine();
            System.out.println();
            String reservation = "R";

        while(true) {

            // Options available for Owner
            System.out.print("\tEnter 0 to list your Registered Vehicles\n\tEnter 1 to register a New Vehicle\n\tEnter 2 to list Booked Vehicles\n\tEnter 3 to Delete a Vehicle\n\tEnter -1 to Exit\n\t");
            int choice = sc.nextInt();
            sc.nextLine();
            System.out.println();
            
            // If owner want to exit the loop than choice=-1
            if(choice == -1)
            break;
            
            // If owner want to register a new Vehicle than choice=1
            if (choice == 1) {

                // Taking all details of Vehicle as input
                System.out.print("\tVehicle Model: ");
                String model  = sc.nextLine();
                System.out.println();
                System.out.print("\tDriving Licence No: ");
                String license_no  = sc.nextLine();
                System.out.println();
                System.out.print("\tVehicle Condition: ");
                String condition = sc.nextLine();
                System.out.println();
                System.out.print("\tVehicle Mileage: ");
                int mileage  = sc.nextInt();
                System.out.println();
                System.out.print("\tVehicle Rent Price: ");
                int rent_price = sc.nextInt();
                
                System.out.println();
                

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental_system", "root", "Perin@3016");
                    Statement stmt = con.createStatement();

                    // Query to insert the details of Vehicle in the Database
                    String q1 = "INSERT INTO vehicle(owner_id, model, license_no, mileage, rent_price, `condition`) VALUES ('" + owner_id + "' , '" + model + "' , '" + license_no + "' , '" + mileage  + "' , '" + rent_price  + "' , '" + condition + "')";

                    stmt.executeUpdate(q1);
                    con.close();

                } catch (Exception e) {
                    System.out.println(e);
                }
            } 

            // If owner want to see list of all Registered Vehicles than choice=0
            else if (choice == 0){

                    System.out.println("\t\t\t-------------------");
                    System.out.println("\t\t\tREGISTERED VEHICLES"); 
                    System.out.println("\t\t\t-------------------");
                    System.out.println();

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental_system", "root", "Perin@3016");

                    Statement stmt = con.createStatement();

                    
                    String q2 = "SELECT * FROM vehicle WHERE owner_id =\'" + owner_id + "\'" ;
                    ResultSet rs = stmt.executeQuery(q2);

                    if(!rs.next()) {
                        System.out.println("\tNo Registered Vehicles");
                        System.out.println();
                    }
                    while (rs.next()) {

                        // Printing details of the Registered Vehicles
                        System.out.println("\tVEHICLE ID: " + rs.getString(1) + "    MODEL: " 	                        
                                + rs.getString(3) + "    PLATE NO: " + rs.getString(4) + "    MILEAGE: " + rs.getString(5) + 	                      
                                "    RENT PRICE: " + rs.getString(6) + "    CONDITION: " + rs.getString(7));
                    }
                    System.out.println();
                    con.close();

                } catch (Exception e) {
                    System.out.println(e);
                }
            } 
            
            // If owner want to see list of all Booked Vehicles by customer than choice=2
            else if(choice==2) {
                System.out.println("\t\t\t---------------");
                System.out.println("\t\t\tBOOKED VEHICLES"); 
                System.out.println("\t\t\t---------------");
                System.out.println();

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental_system", "root", "Perin@3016");

                    Statement stmt = con.createStatement();

                    // Query to obtain list of all Vehicles which are reserved by the customer and belongs to logged in owner
                    String q2 = "SELECT * FROM vehicle WHERE reservation ='R' && owner_id=\'" + owner_id +"\'" ;
                    ResultSet rs = stmt.executeQuery(q2);

                    // Checking if there are any Booked Vehicles
                    if(!rs.next()) {
                        System.out.print("\tNo Booked Vehicles");
                        System.out.println();
                    }
                    while (rs.next()) {

                        // Printing details of the Booked Vehicles
                        System.out.println("\tVEHICLE ID: " + rs.getString(1) + "    MODEL: " 	                        
                                + rs.getString(3) + "    PLATE NO: " + rs.getString(4) + "    MILEAGE: " + rs.getString(5) + 	                      
                                "    RENT PRICE: " + rs.getString(6) + "    CONDITION: " + rs.getString(7));
                    }
                    System.out.println();
                    con.close();

                } catch (Exception e) {
                    System.out.println(e);
                }

            } 
            
            // If owner wants to delete Registered Vehicles than choice=3
            else if(choice==3) {

                System.out.print("\tVehicle ID: ");
                String vehicle_id  = sc.nextLine();
                System.out.println();

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental_system", "root", "Perin@3016");

                    Statement stmt = con.createStatement();

                    // Query to delete vehicle's reservation details of the customer which owner want to delete
                    String q1 = "DELETE FROM reservation_details WHERE vehicle_id=\'" + vehicle_id +"\'" ;
                    stmt.executeUpdate(q1);

                    // Query to delete vehicle's details which owner want to delete
                    String q2 = "DELETE FROM vehicle WHERE vehicle_id=\'" + vehicle_id +"\' && owner_id=\'" + owner_id + "\'" ;
                    stmt.executeUpdate(q2);
                    con.close();

                    System.out.println("\t\t\t--------------------");
                    System.out.println("\t\t\tDELETED SUCCESSFULLY");
                    System.out.println("\t\t\t--------------------");
                    System.out.println();

                } catch (Exception e) {
                    System.out.println("Please enter a correct Vehicle ID");
                }
            }
            
        }

    
    }

    // CUSTOMER PAGE
    public static void customer_page() {	
	   	
        Scanner sc = new Scanner(System.in);

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("\t\t\t --------------------");
        System.out.println("\t\t\t CAR RESERVATION PAGE");
        System.out.println("\t\t\t --------------------");

        while(true) {
            System.out.println();	                
            	
            // Options available for customer
            System.out.print("\tEnter 1 to Rent a Car\n\tEnter -1 to Exit\n\t");	           
            int choice = sc.nextInt();		            
            sc.nextLine();
            System.out.println();
            
            // If customer want to rent a Car than choice=1
            if(choice == 1) {
                System.out.println("\t\t\t-----------------------");
                System.out.println("\t\t\tLIST OF AVAILABLE CARS"); 
                System.out.println("\t\t\t-----------------------");
                System.out.println();
            {       
                try {	                        
                    Class.forName("com.mysql.cj.jdbc.Driver");	                       
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental_system", "root", "Perin@3016");	                       
                    Statement stmt = con.createStatement();	    
                    
                    // NR - Not Reserved
                    // R - Reserved
                    // Query to obtain all details of Vehicles which are not reserved
                    String q1 = "SELECT * FROM Vehicle WHERE reservation='NR'; ";	                       
                    ResultSet rs = stmt.executeQuery(q1);	

                    // To check for any availabe cars
                    if(!rs.next()) {
                        System.out.println("\tNo available Cars");
                        System.out.println();
                        break;
                    }                        	                     
                    while (rs.next()) {
                            
                        // Prints all details of Vehicles which are available for reservation
                        System.out.println("\tVEHICLE ID: " + rs.getString(1) + "    MODEL: " 	                        
                                + rs.getString(3) + "    LICENSE NO: " + rs.getString(4) + "    MILEAGE: " + rs.getString(5) + 	                      
                                "    RENT PRICE: " + rs.getString(6) + "    CONDITION: " + rs.getString(7));                        
                    }   	                      
                    con.close();    	                    
                } 	                   
                catch (Exception e) {	                                    		
                    System.out.println(e);	                    
                }	                   	                	           
            } 

            // Taking all reservation details as input
                System.out.println();
                System.out.print("\tCustomer Id: ");
                String  customer_id = sc.nextLine();
                System.out.println();
                System.out.print("\tVehicle Id: ");		
                String vehicle_id = sc.nextLine();
                System.out.println();
                System.out.print("\tRental Date: ");
                String  rental_date = sc.nextLine();
                System.out.println();
                System.out.print("\tPickup Date: ");
                String  pickup_date = sc.nextLine();
                System.out.println();
                System.out.print("\tReturn Date: ");		
                String return_date = sc.nextLine();
                System.out.println();
                System.out.print("\tNumber of Days: ");		
                int no_of_days = sc.nextInt();
                sc.nextLine();
                System.out.println();
                System.out.print("\tPickup Place: ");
                String  pickup_place = sc.nextLine();
                System.out.println();	  
                String reservation = "R";


                System.out.println("\t\t\t-----------------------");
                System.out.println("\t\t\tYour Reservation is Done"); 
                System.out.println("\t\t\t-----------------------");
                System.out.println();
                
                try {		                	
                    Class.forName("com.mysql.cj.jdbc.Driver");		               	 
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental_system", "root", "Perin@3016");		                	  
                    Statement stmt = con.createStatement();	 
                    
                    // Inserting reservation details to reservation_details table
                    String q2 = "INSERT INTO reservation_details(vehicle_id, customer_id, rental_date, pickup_date, return_date, no_of_days, pickup_place) VALUES ('" 
                            + vehicle_id + "' , '" + customer_id + "' , '" + rental_date + "' , '" 	                    		     
                            + pickup_date  + "' , '" + return_date  + "' , '" + no_of_days 
                            + "', '" + pickup_place + "')";  	
                      
                    // Updating reservation field in reservation_details table to reserved
                    String q3 = "UPDATE vehicle SET reservation=\'"+ reservation +"\' WHERE vehicle_id =\'" + vehicle_id + "\'";
                    stmt.executeUpdate(q2);
                    stmt.executeUpdate(q3);
                    con.close();	   

                } 	                		                 		        
                catch (Exception e) {
                    System.out.println(e);	               		                  
                }	           	                		          		           
            }    
            else if(choice == -1)
            break;
                                                  	       
        }	        	    	 
    }

    public static void main(String args[]) {

            System.out.println("\t\t\t###########################################################################");
	   		System.out.println("\t\t\t############                                                   ############");
	   		System.out.println("\t\t\t############           Welcome To Car Rental Service           ############");
	   		System.out.println("\t\t\t############                                                   ############");
	   		System.out.println("\t\t\t###########################################################################");
	   		System.out.println("\t\t\t---------------------------------------------------------------------------");
	   		System.out.println("\t\t\t---------------------------------------------------------------------------");
            System.out.println("\n\n\n");
        

        Scanner sc = new Scanner(System.in);
        System.out.print("\tEnter 1 to Login\n\tEnter 2 to Sign Up\n\t");
        int choice = sc.nextInt();
        System.out.println();
        
        // If user want to login than choice=1
        if(choice==1) {
            System.out.print("\tEnter 1 for Customer Login\n\tEnter 2 for Owner Login\n\t");
            int choice2 = sc.nextInt();
            System.out.println();

            // If customer want to login than choice2=1
            if(choice2==1)
            customer_login();

            // If owner want to login than choice2=2
            else if(choice2==2)
            owner_login();
        }
        
        // If user want to sign up than choice=2
        else if(choice==2) {
            System.out.print("\tEnter 1 for Customer SignUp\n\tEnter 2 for Owner SignUp\n\t");
            int choice2 = sc.nextInt();
            System.out.println();

            // If customer want to sign up than choice2=1
            if(choice2==1)
            customer_signUp();

            // If owner want to sign up than choice2=2
            else if(choice2==2)
            owner_signUp();
        }
        System.out.println("\t\t\t---------");
        System.out.println("\t\t\tThank You");
        System.out.println("\t\t\t---------");
    }

}