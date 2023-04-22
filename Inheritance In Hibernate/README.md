## Inheritance Mapping in Hibernate

Inheritance in Hibernate refers to the ability to map an inheritance hierarchy of Java classes onto a single table in a relational database. This means that a single table can contain columns that correspond to multiple Java classes in an inheritance hierarchy.

Hibernate supports three types of inheritance mapping strategies:

- Single Table Inheritance: In this strategy, all classes in an inheritance hierarchy are mapped to a single table in the database. The table has a discriminator column that stores the class type of each row.

- Joined Table Inheritance: In this strategy, each class in an inheritance hierarchy is mapped to a separate table in the database. The tables are joined by a foreign key relationship, and the subclass table has a foreign key that references the primary key of the superclass table.

- Table Per Class Inheritance: In this strategy, each class in an inheritance hierarchy is mapped to a separate table in the database. Each table has all the columns of its corresponding Java class.

Hibernate provides different annotations to map the inheritance hierarchy in Java classes onto the database tables. These annotations include:

- **`@Inheritance:`** This annotation is used to specify the type of inheritance strategy to be used. It is used at the superclass level of the inheritance hierarchy.

- **`@DiscriminatorColumn:`** This annotation is used to specify the name of the discriminator column in the database table.

- **`@DiscriminatorValue:`** This annotation is used to specify the value of the discriminator column for a particular subclass.

- **`@MappedSuperclass:`** This annotation is used to mark a superclass that is not meant to be instantiated on its own but is used to define the common state and behavior for its subclasses.

- **`@Entity:`** This annotation is used to mark a subclass that is meant to be instantiated on its own.

By using these annotations, we can define an inheritance hierarchy in Java classes and map it to the database tables in Hibernate.

## Single Table strategy

Below is an example code of single table inheritance mapping in Hibernate:

Suppose you have an application that manages different types of vehicles: cars, trucks, and motorcycles. You want to store information about each vehicle in a single table, but you also want to be able to retrieve the vehicles by their specific type.

1. Create a `Vehicle` class that serves as the base class for all vehicle types. This class should be annotated with `@Entity` to indicate that it is a persistent entity in the database:

```
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "vehicle_type")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String make;
    private String model;
    private int year;
    
    // Getters and setters 
}
```

In this example, we use the `@Inheritance` annotation with the `SINGLE_TABLE` strategy to indicate that we want to use a single table to store all vehicle types. We also use the `@DiscriminatorColumn` annotation to specify a discriminator column that will be used to differentiate between the different types of vehicles.

2. Create the subclasses `Car`, `Truck`, and `Motorcycle`, and annotate them with `@DiscriminatorValue` to specify the value of the discriminator column for each class:


```
@Entity
@DiscriminatorValue("CAR")
public class Car extends Vehicle {
    private int numDoors;
    
    // Getters and setters 

@Entity
@DiscriminatorValue("TRUCK")
public class Truck extends Vehicle {
    private int payloadCapacity;
    
    // Getters and setters
}

@Entity
@DiscriminatorValue("MOTORCYCLE")
public class Motorcycle extends Vehicle {
    private String style;
    
    // Getters and setters 
}
```

In this example, we use the `@DiscriminatorValue` annotation to specify the value of the discriminator column for each subclass.


## Joined Table strategy

Below is an example code of joined table inheritance mapping in Hibernate:

Suppose you have an application that manages different types of bank accounts: savings accounts and checking accounts. You want to store the common account information in a base table and the account-specific information in separate tables.

1. Create a `BankAccount` class that serves as the base class for all bank account types. This class should be annotated with `@Entity` to indicate that it is a persistent entity in the database:

```
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String owner;
    private double balance;
    
    // Getters and setters
}
```

In this example, we use the `@Inheritance` annotation with the `JOINED` strategy to indicate that we want to use separate tables for the common account information and the account-specific information.

2. Create the subclasses `SavingsAccount` and `CheckingAccount`, and annotate them with @Entity to indicate that they are also persistent entities in the database. These subclasses should also include the account-specific information, and use `@PrimaryKeyJoinColumn` to specify the primary key join column:

```
@Entity
@PrimaryKeyJoinColumn(name = "savings_account_id")
public class SavingsAccount extends BankAccount {
    private double interestRate;
    
    // Getters and setters
}

@Entity
@PrimaryKeyJoinColumn(name = "checking_account_id")
public class CheckingAccount extends BankAccount {
    private double overdraftLimit;
    
    // Getters and setters
}
```

In this example, we use `@PrimaryKeyJoinColumn` to specify the primary key join column for each subclass. This tells Hibernate to use the `id` column from the `BankAccount` table as the primary key for each subclass table.

## Table per class strategy

Below is an example code of table per class inheritance mapping in Hibernate:

Suppose you have an application that manages different types of vehicles: cars and trucks. You want to store the common vehicle information in a base table and the vehicle-specific information in separate tables.

1. Create a `Vehicle` class that serves as the base class for all vehicle types. This class should be annotated with `@Entity` to indicate that it is a persistent entity in the database:

```
@Entity
@Table(name = "vehicles")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "vehicle_id")
    private Long id;
    private String make;
    private String model;
    
    // Getters and setters
}
```

In this example, we use the `@Inheritance` annotation with the `TABLE_PER_CLASS` strategy to indicate that we want to use separate tables for the common vehicle information and the vehicle-specific information.

2. Create the subclasses `Car` and `Truck`, and annotate them with `@Entity` to indicate that they are also persistent entities in the database. These subclasses should also include the vehicle-specific information, and use `@PrimaryKeyJoinColumn` to specify the primary key join column:

```
@Entity
@Table(name = "cars")
@PrimaryKeyJoinColumn(name = "vehicle_id")
public class Car extends Vehicle {
    private int numDoors;
    
    // Getters and setters 
}

@Entity
@Table(name = "trucks")
@PrimaryKeyJoinColumn(name = "vehicle_id")
public class Truck extends Vehicle {
    private int cargoCapacity;
    
    // Getters and setters 
}
```

In this example, we use `@PrimaryKeyJoinColumn` to specify the primary key join column for each subclass. This tells Hibernate to use the `id` column from the `Vehicle` table as the primary key for each subclass table.