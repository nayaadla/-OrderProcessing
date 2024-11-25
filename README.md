
# E-Commerce Order Processing System

This Java program simulates an order processing system for a fictional e-commerce business. Users can view inventory, place orders, and generate order details through a menu-driven interface.

## Features

- **Inventory Management**: 
  - Displays available products with their prices and stock levels.
  - Updates inventory upon successful order placement.

- **Order Processing**: 
  - Allows users to place orders for one or more products.
  - Validates stock availability before adding items to an order.
  - Automatically calculates the total price of the order.

- **Order Details**:
  - Displays detailed information about orders, including items, quantities, prices, and total cost.

- **Menu-Driven Interface**:
  - User-friendly console interface for navigation and interaction.

---

## Program Structure

The program is divided into the following classes:

1. **`Product`**:
   - Represents a product in the inventory.
   - Fields: `name`, `price`, `stock`.

2. **`Order`**:
   - Represents an order placed by a user.
   - Fields: `orderId`, `items`, `totalPrice`.
   - Methods: `addItem`, `displayOrderDetails`.

3. **`EcommerceSystem`**:
   - Main class handling user input and managing the order processing system.

---

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed on your system.

### Running the Program

1. Clone the repository or download the `EcommerceSystem.java` file.
2. Open a terminal and navigate to the directory containing the file.
3. Compile the program:
   ```bash
   javac EcommerceSystem.java
