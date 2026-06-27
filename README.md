<div align="center">

# 🛒 Java Store Management System

**A console-based store management system built in Java — featuring inventory control, customer management, and a full shopping cart workflow.**

<br/>

[![Java](https://img.shields.io/badge/Java-18-007396?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/technologies/javase/jdk18-archive-downloads.html)
[![Apache Ant](https://img.shields.io/badge/Apache%20Ant-A81C7D?style=for-the-badge&logo=apache&logoColor=white)](https://ant.apache.org/)
[![NetBeans](https://img.shields.io/badge/NetBeans%20IDE-1B6AC6?style=for-the-badge&logo=apache-netbeans-ide&logoColor=white)](https://netbeans.apache.org/)
[![Last Commit](https://img.shields.io/github/last-commit/aymanbismail/Java-2-Project?style=for-the-badge&color=blue)](https://github.com/aymanbismail/Java-2-Project/commits/master)
[![Stars](https://img.shields.io/github/stars/aymanbismail/Java-2-Project?style=for-the-badge&color=yellow)](https://github.com/aymanbismail/Java-2-Project/stargazers)
[![Forks](https://img.shields.io/github/forks/aymanbismail/Java-2-Project?style=for-the-badge&color=green)](https://github.com/aymanbismail/Java-2-Project/network/members)

</div>

---

## 📖 Table of Contents

- [About](#-about)
- [Demo](#-demo)
- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Architecture](#-architecture)
- [Folder Structure](#-folder-structure)
- [Prerequisites](#-prerequisites)
- [Installation & Build](#-installation--build)
- [Running the Application](#-running-the-application)
- [Usage](#-usage)
- [Roadmap](#-roadmap)
- [Contributing](#-contributing)
- [Author](#-author)
- [License](#-license)
- [Acknowledgements](#-acknowledgements)

---

## 📌 About

The **Java Store Management System** is a terminal-based Java application that simulates a retail store backend. It manages an in-memory inventory of items (books, shoes, and games), registers customers, and provides a complete shopping cart workflow from item selection through to checkout.

This project was built as a **Java 2 academic project** and demonstrates core object-oriented programming principles: inheritance, encapsulation, polymorphism, and clean separation of concerns across classes.

---

## 🎬 Demo

### Main Menu

```
-------[ Store Main Menu ]-------
1. Add a new Item to Store.
2. Add a new Customer to Store.
3. Add an item to Customer shopping cart.
4. Remove an item from Customer shopping cart.
5. View the items in Customer shopping cart.
6. End shopping and go to checkout.
7. Empty Customer shopping cart.
8. Modify customer data.
9. Exit the program.
(Enter the Number Twice for Function description)
---------------------------------
Please Enter the number of Operation you want :
```

### Adding an Item

```
[ Add Item Operation: ]
Please enter the item Number : 101
Please enter the item Name : Java Programming
Please enter the Quantity : 15
Please enter the Price : 29.99
Enter the type of item (B)Book, (s)shoes, (G)Game? : B
Enter the Book title: Java in Action
Enter the Book author name: John Doe
[DONE] > Item added Successfully
```

### Viewing Shopping Cart

```
The Customer No : 1, The Customer Name : Alice
The current items in the shopping cart :
Item no       Item name       Quantity       Unit price       Total price
101           Java Programming   2             29.99            59.98
                                                     Total price : 59.98
```

> **Note:** The terminal output uses ANSI color codes — yellow for headings, green for success messages, and red for errors. Color rendering depends on your terminal emulator.

---

## ✨ Features

### Inventory Management
- Add items to the store with a unique item number, name, quantity, and price
- Three item types supported: **Books** (with title and author), **Shoes**, and **Games**
- Inventory quantity is automatically decremented on checkout

### Customer Management
- Register new customers with unique customer IDs and names
- Modify existing customer number and name
- Customers are stored in memory for the session

### Shopping Cart
- Add items to any registered customer's cart with quantity validation
- Remove individual items from the cart
- View a formatted cart summary with unit prices and totals
- Empty a customer's cart (also removes the customer from the session)

### Checkout
- Validates stock availability at checkout time
- Deducts purchased quantities from the store inventory
- Displays a full itemized receipt with total price

### Input Validation
- Catches `InputMismatchException` on all numeric inputs — the program never crashes on bad input
- Validates uniqueness of item numbers and customer IDs
- Rejects negative quantities and prices with clear error messages
- Prompts `(y/n)` confirmations with re-prompt on invalid characters

### In-App Help System
- Enter any menu number **twice** (e.g., `11`, `22`, `33` …) to print a full description of that operation

---

## 🛠 Tech Stack

| Technology | Purpose |
|---|---|
| ![Java](https://img.shields.io/badge/Java%2018-007396?style=flat-square&logo=openjdk&logoColor=white) | Core language |
| ![Apache Ant](https://img.shields.io/badge/Apache%20Ant-A81C7D?style=flat-square&logo=apache&logoColor=white) | Build system |
| ![NetBeans](https://img.shields.io/badge/NetBeans%20IDE-1B6AC6?style=flat-square&logo=apache-netbeans-ide&logoColor=white) | Project structure & IDE |
| `java.util.ArrayList` | In-memory data storage |
| `java.util.Scanner` | Console input |
| `java.text.DecimalFormat` | Price formatting |
| ANSI escape codes | Colored terminal output |

No external libraries or frameworks are used. The project runs on the Java Standard Library alone.

---

## 🏛 Architecture

The application follows a **single-package OOP** design with clear class responsibilities:

```
StoreInfo  (abstract)
    └── JavaProject  (main entry point + shared state)
             │
             ├── Items  (inventory item base class)
             │     └── books  (Book subclass with title & author)
             │
             ├── Customer  (customer identity + per-customer cart)
             │
             └── ShoppingCart  (all cart & checkout operations)
```

**Key design decisions:**

- `JavaProject` holds two shared `static` `ArrayList` collections — `Customers` and `itemsList` — which act as the in-memory "database" for the session. All other classes import these via `static import`.
- `StoreInfo` is an `abstract` class whose sole role is to house static help-text methods, keeping descriptive output separate from logic.
- `books` extends `Items` and overrides nothing; it simply adds `bookTitle` and `bookAuthor` fields. The item type character `'b'` is used at runtime to cast `Items` references back to `books` where needed.
- All data is **in-memory only** — nothing is persisted to disk between runs.

---

## 📁 Folder Structure

```
Java-2-Project/
│
├── src/
│   └── javaproject/
│       ├── JavaProject.java     # Main class — entry point & main menu
│       ├── StoreInfo.java       # Abstract base — help text for each operation
│       ├── Items.java           # Store item model + AddItem() logic
│       ├── books.java           # Book subclass (adds title & author)
│       ├── Customer.java        # Customer model + AddCustomer/Modify logic
│       └── ShoppingCart.java    # Cart operations: add, remove, view, checkout, empty
│
├── nbproject/
│   ├── build-impl.xml           # NetBeans-generated Ant build implementation
│   ├── genfiles.properties      # NetBeans generated files metadata
│   ├── project.properties       # Project settings (Java 18, main class, paths)
│   └── project.xml              # NetBeans project type descriptor
│
├── build.xml                    # Apache Ant build script entry point
├── manifest.mf                  # JAR manifest (Main-Class set by Ant at build time)
├── java-Final-Project.pdf       # Project specification / assignment document
└── README.md
```

---

## ✅ Prerequisites

- **Java Development Kit (JDK) 18** or later
  - Download: [Oracle JDK 18](https://www.oracle.com/java/technologies/javase/jdk18-archive-downloads.html) or [OpenJDK](https://adoptium.net/)
- **Apache Ant 1.9+** *(required for the Ant build script)*
  - Download: [ant.apache.org](https://ant.apache.org/bindownload.cgi)
  - Or open directly in **Apache NetBeans IDE** (recommended — the project is a native NetBeans project)

Verify your installation:

```bash
java -version
# java version "18.0.x" ...

ant -version
# Apache Ant(TM) version 1.9.x ...
```

---

## ⚙️ Installation & Build

### Option 1 — NetBeans IDE (Recommended)

1. Clone the repository:
   ```bash
   git clone https://github.com/aymanbismail/Java-2-Project.git
   ```
2. Open **Apache NetBeans IDE**
3. Go to **File → Open Project** and select the `Java-2-Project` folder
4. NetBeans detects it as a Java SE project automatically
5. Click the **Build** button (or press `F11`) to compile and package the JAR

### Option 2 — Apache Ant (Command Line)

```bash
git clone https://github.com/aymanbismail/Java-2-Project.git
cd Java-2-Project

# Compile and build the JAR
ant jar
```

The compiled JAR is output to:
```
dist/JavaProject.jar
```

To clean build artifacts:
```bash
ant clean
```

---

## ▶️ Running the Application

### After building with Ant or NetBeans

```bash
java -jar dist/JavaProject.jar
```

### Directly from NetBeans

Press **Run** (F6) — NetBeans compiles and runs the project in the embedded terminal.

### From source (javac)

```bash
# From the project root
javac -d build/classes src/javaproject/*.java
java -cp build/classes javaproject.JavaProject
```

---

## 📋 Usage

Once the application starts, you are presented with a numbered main menu. Enter the corresponding number and follow the prompts.

| Option | Operation | Description |
|--------|-----------|-------------|
| `1` | Add Item | Add a new item (Book / Shoe / Game) to the store inventory |
| `2` | Add Customer | Register a new customer with a unique ID |
| `3` | Add to Cart | Add a store item to a specific customer's shopping cart |
| `4` | Remove from Cart | Remove an item from a customer's shopping cart |
| `5` | View Cart | Display all items in a customer's cart with a total |
| `6` | Checkout | Complete the purchase — deducts stock and clears the cart |
| `7` | Empty Cart | Remove all items from a customer's cart and delete the customer |
| `8` | Modify Customer | Update a customer's ID or name |
| `9` | Exit | Exit the program |

### Built-in Help

Enter any option number **twice** to print a full description of what that operation does:

| Input | Shows description for |
|-------|-----------------------|
| `11`  | Add Item |
| `22`  | Add Customer |
| `33`  | Add to Cart |
| `44`  | Remove from Cart |
| `55`  | View Cart |
| `66`  | Checkout |
| `77`  | Empty Cart |
| `88`  | Modify Customer |

### Item Types

When adding an item, you will be asked to select a type:

| Key | Type | Extra Fields |
|-----|------|--------------|
| `B` | Book | Title, Author |
| `S` | Shoes | — |
| `G` | Game | — |

---

## 🗺 Roadmap

- [ ] **File persistence** — save and load inventory and customer data between sessions (CSV or JSON)
- [ ] **Search functionality** — search items by name or number before adding to cart
- [ ] **Discount / coupon system** — apply percentage or fixed discounts at checkout
- [ ] **Multiple item types** — extend beyond books, shoes, and games (e.g., electronics, clothing)
- [ ] **Receipt generation** — print a formatted receipt to a text file on checkout
- [ ] **JUnit test suite** — unit tests for all core operations
- [ ] **Quantity update** — option to restock item quantities in the store
- [ ] **Customer purchase history** — track past checkouts per customer within a session

---

## 🤝 Contributing

Contributions are welcome! To contribute:

1. **Fork** the repository on GitHub
2. **Create a branch** for your feature or fix:
   ```bash
   git checkout -b feature/your-feature-name
   ```
3. **Commit** your changes with a clear message:
   ```bash
   git commit -m "Add: description of what you added"
   ```
4. **Push** to your fork:
   ```bash
   git push origin feature/your-feature-name
   ```
5. Open a **Pull Request** against the `master` branch

### Guidelines

- Keep changes focused — one feature or fix per PR
- Do not break existing menu behavior
- Follow the existing code style (Java naming conventions, ANSI color constants)
- Test your changes manually by running the full application before submitting

---

## 👤 Author

<div align="center">

**Ayman Ismail**

[![GitHub](https://img.shields.io/badge/GitHub-aymanbismail-181717?style=for-the-badge&logo=github)](https://github.com/aymanbismail)
[![Portfolio](https://img.shields.io/badge/Portfolio-aymanismail.com-0A0A0A?style=for-the-badge&logo=vercel&logoColor=white)](https://aymanismail.com)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-aymanbismail-0A66C2?style=for-the-badge&logo=linkedin)](https://linkedin.com/in/aymanbismail)

</div>

---

## 📄 License

This project was created as an academic assignment. It is shared publicly for educational and portfolio purposes. No license is currently attached — please contact the author before reusing or redistributing this code.

---

## 🙏 Acknowledgements

- [Oracle Java SE 18 Documentation](https://docs.oracle.com/en/java/javase/18/) — standard library reference
- [Apache Ant](https://ant.apache.org/) — build automation
- [Apache NetBeans IDE](https://netbeans.apache.org/) — project scaffolding and build configuration
- [shields.io](https://shields.io/) — badge generation
