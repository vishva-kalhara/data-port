# Data Port

Data Port is a Java library for handling database operations with ease. It provides a set of utilities and abstractions to interact with databases, manage credentials, and perform various database functions.

## Features

-   Simplified database operations
-   Customizable database functions
-   Exception handling for database operations
-   Support for different database implementations

## Installation

To use Data Port in your project, add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>io.github.vishva-kalhara</groupId>
    <artifactId>data-port</artifactId>
    <version>1.1.0</version>
</dependency>
```

## Usage

### Initializing Data-Port

```java
import io.github.vishva_kalhara.data_port.DataPort;
import io.github.vishva_kalhara.data_port.DBCredentials;

public class Main {
    public static void main(String[] args) {
        DBCredentials credentials = new DBCredentials("username", "password", "mydb");
        DataPort dataPort = new DataPort(credentials);

        // Use dataPort to perform database operations
    }
}
```

### Handling Exceptions

```java
import io.github.vishva_kalhara.data_port.DataPort;
import io.github.vishva_kalhara.data_port.DBCredentials;
import io.github.vishva_kalhara.data_port.DataPortException;

public class Main {
    public static void main(String[] args) {
        try {
            DBCredentials credentials = new DBCredentials("username", "password", "mydb");
            DataPort dataPort = new DataPort(credentials);

            // Perform database operations
        } catch (DataPortException e) {
            e.printStackTrace();
        }
    }
}
```

### Using Custom Database Functions

```java
import io.github.vishva_kalhara.data_port.DBFunctions;
import io.github.vishva_kalhara.data_port.impl.MySQLImpl;

public class Main {
    public static void main(String[] args) {
        DBFunctions dbFunctions = new MySQLImpl();

        // Use dbFunctions to perform custom database operations
    }
}
```

### Using Chooser

```java
import io.github.vishva_kalhara.data_port.chooser.ChooserRules;
import io.github.vishva_kalhara.data_port.chooser.ChooseType;
import io.github.vishva_kalhara.data_port.chooser.FileHandler;

public class Main {
    public static void main(String[] args) {
        ChooserRules chooserRules = new ChooserRules();
        FileHandler fileHandler = new FileHandler();

        // Use chooserRules and fileHandler to handle file operations
    }
}
```

## Documentation

### Classes and Packages

-   io.github.vishva_kalhara.data_port.DataPort: Main class for database operations.
-   io.github.vishva_kalhara.data_port.DBCredentials: Class for storing database credentials.
-   io.github.vishva_kalhara.data_port.DataPortException: Custom exception for database operations.
-   io.github.vishva_kalhara.data_port.DBFunctions: Base class for database functions.
-   io.github.vishva_kalhara.data_port.DBFunctionsBase: Abstract base class for custom database functions.
-   io.github.vishva_kalhara.data_port.chooser.ChooserException: Custom exception for chooser operations.
-   io.github.vishva_kalhara.data_port.chooser.ChooserRules: Class for defining chooser rules.
    io.github.vishva_kalhara.data_port.chooser.ChooseType: Enum for chooser types.
-   io.github.vishva_kalhara.data_port.chooser.FileHandler: Class for handling file operations.
-   io.github.vishva_kalhara.data_port.impl.MySQLImpl: Implementation of database functions for MySQL.

## License

This project is licensed under the Apache 2.0 License. See the [LICENSE](https://github.com/vishva-kalhara/data-port/blob/master/LICENSE) file for more details.
