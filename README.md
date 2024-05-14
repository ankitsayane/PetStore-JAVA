**Pet Store Application**

This application is designed for a pet store, allowing both store owners (admins) and customers to interact with the system. It features user authentication, pet management, and order processing.

**Users**
    Admin User:
        Login ID: admin
        Password: admin
    Customer:
        Login ID: user
        Password: user
**Features**
1. Login
2. Add new pet (Admin Only)
3. Update Pet Details (Admin Only)
4. Display All available Pets
5 .Order a Pey
6. Check Order Status
7. Update Order Status
8. Display All Orders
9. Exit

**Prerequisites**
Ensure you have Java installed.
Running the Application
Compile the Java files.
Run the main class to start the application.
Use the menu-driven interface to navigate through the features.

**Core Classes**
Pet ( petId, name, category, unitPrice, stocks)
Category is an enum with values like (CAT, DOG, RABBIT, FISH)
Example:
  petId = 101, name=” Bull Dog”, category= DOG, unitPrice= 1000, stocks=50

Order (orderId, petId, quantity, status)
Status is an enum with values like (PLACED, IN_PROCESS, COMPLETED)
Example: 
   orderId=1, petId=101, quantity=5, status=PLACED
