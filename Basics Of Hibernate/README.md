# Hibernate_Learning_Topics.

Here I will be adding all topics and its projects while the course of learning Hibernate.

## Basics of Hibernate.
  1. Introduction.
  2. Writing a Hibernate application.
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