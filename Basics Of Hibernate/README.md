# Basics of Hibernate.
  1. Introduction.
  2. Steps involved in writing an Hibernate Application.
  3. Writing Model Class and Hibernate configuration file(hibernate.cfg.xml).

## Introduction.

For Java applications, Hibernate is an open-source Object-Relational Mapping (ORM) tool. It gives developers the ability to work with databases using an object-oriented paradigm rather than SQL statements by providing a framework for mapping object-oriented domain models to relational databases.

By providing a simple API for performing CRUD (Create, Read, Update, Delete) operations on database tables, Hibernate manages the persistence of Java objects to relational databases. It also offers transactions, caching, and lazy loading, making it simpler for developers to create database applications that are both effective and dependable.

Java classes and Java objects are mapped to rows in database tables by Hibernate. XML or annotations are used to accomplish this mapping, which specifies how each class and its properties should be saved to the database. Based on these mappings, Hibernate generates and executes SQL statements against the database.

For Java developers who need to work with databases, Hibernate is a powerful and well-liked tool. It is a popular choice for a wide range of applications, from small projects to large enterprise systems, due to its user-friendliness and extensive feature set.



## What is need of Hibernate over JDBC ?


Hibernate is an ORM framework that provides a higher level of abstraction in comparison to JDBC. Hibernate outperforms JDBC in the following ways:

Mapping Oriented to Objects: Hibernate makes it possible to map Java objects to database tables without having to write your own JDBC code. This makes it possible to avoid having to do so. Object-oriented data manipulation is made simpler and development time and effort are reduced as a result.

Improved Querying: The powerful query language Hibernate Query Language (HQL), which is similar to SQL but is object-oriented, is provided by Hibernate. By allowing you to use object-oriented concepts like inheritance, polymorphism, and association when writing queries, HQL makes it easier to query data and less likely to make mistakes.

Improved Performance: To boost performance, Hibernate makes use of caching mechanisms, which also reduce the number of database queries needed to retrieve data. Applications can benefit greatly from this, especially when there are numerous nested objects and relationships in complex object graphs.

Database Portability: Hibernate lets you write code that is independent of the database. This makes it easier to switch databases without having to rewrite code. Additionally, Hibernate supports multiple databases, making it simpler to create applications that require interaction with multiple databases.

Management of transactions: Transaction management is provided by Hibernate, making it simpler to work with transactions in a consistent and dependable manner. Additionally, Hibernate supports transaction isolation levels, giving you control over your application's concurrency level.



## Steps involved in writing an Hibernate Application.

Here are the general steps for writing a Hibernate application:

  -Add Hibernate dependencies: Add the necessary Hibernate dependencies to your project, including the Hibernate core library and the JDBC driver for your database.

  -Create Hibernate configuration file: Create a Hibernate configuration file (usually named hibernate.cfg.xml) and configure Hibernate to connect to your database.

  -Create Hibernate model classes: Create the Java classes that will represent your database tables. Annotate these classes with Hibernate annotations to map them to the appropriate database tables and columns.

  -Create Hibernate session factory: Use the Hibernate configuration file to create a SessionFactory object. The SessionFactory is used to create Session objects, which allow you to interact with the database.

  -Create Hibernate transactions: Use Session objects to create transactions for database operations. Transactions ensure that database operations are atomic and consistent.

  -Use Hibernate Query Language (HQL) or Criteria API: Use either HQL or the Criteria API to create queries to retrieve data from the database.

  -Handle Hibernate exceptions: Handle Hibernate exceptions such as HibernateException and SQLException in your application code.

  -Close Hibernate resources: Finally, close any Hibernate resources that were opened, such as Session and SessionFactory objects.

These are the general steps for writing a Hibernate application. However, there may be additional steps depending on your specific use case.


## Writing Modal Class


'''

    @Entity
    @Table(name = "employees")
    public class Employee {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;

        @Column(name = "first_name")
        private String firstName;

        @Column(name = "last_name")
        private String lastName;

        @Column(name = "email")
        private String email;

        // getter, setter and toString methods for each property
    }

'''


## Hibernate configuration file(hibernate.cfg.xml).


'''

    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE hibernate-configuration SYSTEM
    "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">

    <hibernate-configuration>
      <session-factory>
        
        <property name="connection.driver_class">com.mysql.cj.jdbc.Driver</property>
        <property name="connection.url">jdbc:mysql://localhost:3306/example_db</property>
        <property name="connection.username">root</property>
        <property name="connection.password">root</property>
        <property name="dialect">org.hibernate.dialect.MySQL8Dialect</property>
        
        <property name="hbm2ddl.auto">create</property>
        <property name="show_sql">true</property>
        
        <mapping class="com.nitesh.hib.entity.Students"/>
        
        
      </session-factory>
    </hibernate-configuration>

'''
