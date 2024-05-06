# DAA_FinalProject

# Employee Management 

## Project Overview
The Employee Management System (EMS) is a Java application designed to facilitate the management of employee data through an intuitive graphical user interface (GUI). The system caters to both employees and administrators, providing features for searching, updating, deleting, and inserting employee information. Additionally, administrators have access to a summary function that calculates potential monthly and yearly expenses for employee salaries based on the data stored in a CSV file.

## Key Feautures
- **Employee Information Retrieval:** Employees can search for their personal information stored in the system using predefined search criteria such as employee NO or employee ID. The GUI provides an intuitive interface for entering search queries and viewing search results.

- **Data Management for Administrators:** Administrators have comprehensive control over employee data, including the ability to update existing records, delete outdated entries, and insert new employee information. Data management operations are performed using file handling techniques, with employee data stored in a CSV file for easy manipulation.

- **Summary Functionality:** Administrators can generate summary reports detailing potential monthly and yearly expenses for employee salaries. The summary function calculates total salary expenditures based on the data stored in the CSV file, providing valuable insights for budget planning and financial analysis.

- **Graphical User Interface (GUI):** The EMS features a user-friendly GUI that simplifies navigation and interaction for both employees and administrators. The interface includes intuitive input forms, interactive search functions, and informative data displays to enhance the user experience.
## Implemented 2-3 Tree
The project utilizes a 2-3 Tree data structure to efficiently store and manage employee data. The 2-3 Tree is a type of balanced search tree that maintains sorted data and allows for quick retrieval and manipulation of information.

### Features of the 2-3 Tree
- **Balanced Structure:** The 2-3 Tree ensures that all leaf nodes are at the same level, leading to optimal performance for insertion, deletion, and search operations.
- **Efficient Search:** Searching for employee information is efficient due to the balanced nature of the tree, resulting in logarithmic time complexity for search operations.
- **Dynamic Adjustment:** The tree dynamically adjusts its structure during insertion and deletion operations to maintain balance and uphold the properties of a 2-3 Tree.

### Implementation Details
The 2-3 Tree implementation includes the following components:
- **Node Class:** Represents a node in the 2-3 Tree structure. It contains fields for storing employee keys and references to child nodes.
- **TwoThreeTree Class:** Represents the 2-3 Tree itself and provides methods for insertion, deletion, searching, and traversal of the tree.


## How to open the application
To run the application using an Integrated Development Environment (IDE) such as IntelliJ IDEA, Eclipse, or NetBeans, follow these steps:

1. Make sure you have Java installed on your computer. You can download and install Java from [Java's official website](https://www.java.com/en/download/).

2. Open your preferred IDE (IntelliJ IDEA, Eclipse, NetBeans, etc.).

3. Import the project into your IDE:
   - For IntelliJ IDEA: File > New > Project from Existing Sources, then select the project directory.
   - For Eclipse: File > Import > General > Existing Projects into Workspace, then select the project directory.
   - For NetBeans: File > Open Project, then select the project directory.

4. Once the project is imported, navigate to the `App.java` file.

5. Right-click on `App.java` and select "Run" or "Run As" > "Java Application" (the exact option may vary depending on the IDE).

Note: If you encounter any errors or issues during the import or execution process, please refer to the IDE's documentation or contact the developer for assistance.

## Other ways (Without IDE)
To run the Employee Management System, follow these steps:

1. Ensure that Java is installed on your computer. You can download and install Java from the [official website](https://www.java.com/en/download/).

2. Clone this repository to your local machine:

    ```bash
    git clone <repository-url>
    ```

3. Navigate to the project directory:

    ```bash
    cd EMS
    ```

4. Compile the Java files:

    ```bash
    javac *.java
    ```

5. Run the application:

    ```bash
    java App
    ```

### Contributors

### Contributors

| Role   | Name                    | GitHub Profile                            |
|--------|-------------------------|-------------------------------------------|
| Leader | Macorol, Renard B.      | [RenardMacorol](https://github.com/RenardMacorol) |
| Member | Sevilla, Vince Arnold Z.| [VinceSevilla](https://github.com/VinceSevilla) |
| Member | Pastores, Jabez Villan Cruz | [JabezPastores](https://github.com/JabezPastores) |
| Member | Lorica Edward Angel     | [nngel](https://github.com/nngel) |



