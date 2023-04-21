# Hibernate Mappings

## Collection Mapping

Hibernate collection mapping is a feature of the Hibernate ORM (Object-Relational Mapping) framework that allows developers to map collections of related objects to relational database tables.

A collection in Hibernate can be a list, set, map, or array of related objects, and it can be mapped to a table using one of the available collection mapping strategies, such as:

- List Mapping: This strategy maps a collection to a table with a foreign key column in the table representing the index of the element in the list.

- Set Mapping: This strategy maps a collection to a table with a foreign key column in the table representing the primary key of the owning entity.

- Map Mapping: This strategy maps a collection to a table with two columns, one for the key and one for the value.

- Array Mapping: This strategy maps a collection to a table with a foreign key column in the table representing the index of the element in the array.

In order to use collection mapping in Hibernate, you need to define the collection as a property of your entity class using the appropriate annotations or XML mapping files. You also need to configure the collection mapping strategy and other properties in the Hibernate configuration file.

Overall, collection mapping in Hibernate is a powerful feature that allows developers to easily map and persist collections of related objects to a relational database, simplifying the development of database-driven applications.

## One-To-One Mapping

In Hibernate, a one-to-one mapping is used to associate one object of an entity class with exactly one object of another entity class. The two entities are linked by a primary key column, which can be either a primary key of the referenced entity or a unique column in the referenced entity.

To create a one-to-one mapping in Hibernate, you can use the @OneToOne annotation. This annotation is used to define the relationship between two entities. You can use this annotation in the following ways:

- @OneToOne without any parameters: This will map the two entities based on the default naming convention.

- @OneToOne with mappedBy parameter: This is used to specify the property in the referenced entity that will map back to the owning entity.

- @OneToOne with optional and fetch parameters: This is used to specify whether the association is optional or required, and the fetching strategy to use.

- @OneToOne with cascade parameter: This is used to specify the cascade behavior when the owning entity is saved, updated, or deleted.

Here is an example of how to create a one-to-one mapping using the @OneToOne annotation:

```
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    // getters and setters
}

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address_line1")
    private String line1;

    @Column(name = "address_line2")
    private String line2;

    // getters and setters
}
```

In this example, we have created a one-to-one mapping between the Employee and Address entities. The Employee entity has a foreign key column "address_id" that references the primary key of the Address entity. The cascade parameter is set to CascadeType.ALL, which means that any changes made to the Employee entity will be cascaded to the Address entity as well.

## One-To-Many Mapping

In Hibernate, one-to-many mapping is used to associate a single entity instance with multiple instances of another entity. This type of relationship is established using the @OneToMany annotation.

Here's an example of one-to-many mapping using Hibernate:

```
@Entity
public class Department {

   @Id
   private int id;
   private String name;

   @OneToMany(mappedBy = "department")
   private List<Employee> employees;

   // getters and setters
}

@Entity
public class Employee {

   @Id
   private int id;
   private String name;
   private int age;

   @ManyToOne
   @JoinColumn(name="dept_id")
   private Department department;

   // getters and setters
}
```

In this example, the Department entity has a one-to-many relationship with the Employee entity. The @OneToMany annotation is used on the Department class to indicate this relationship, and the mappedBy attribute is set to "department" to specify that the department field in the Employee entity is the owner of the relationship.

The Employee entity has a many-to-one relationship with the Department entity. The @ManyToOne annotation is used on the department field to indicate this relationship, and the @JoinColumn annotation is used to specify the foreign key column name (dept_id) in the Employee table that references the primary key column (id) in the Department table.

## Many-To-One Mapping

In Hibernate, Many-to-One mapping is used to map the relationship between two entities where many instances of one entity are associated with one instance of another entity.

For example, consider two entities "Employee" and "Department". One department can have many employees, but an employee can only belong to one department. This is a classic example of Many-to-One mapping.

To implement Many-to-One mapping in Hibernate, we use the @ManyToOne annotation in the child entity (Employee) and @OneToMany annotation in the parent entity (Department). Here is an example:

```
@Entity
@Table(name = "employee")
public class Employee {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column(name = "name")
    private String name;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;
 
    // getters and setters
}
```

```
@Entity
@Table(name = "department")
public class Department {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column(name = "name")
    private String name;
 
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
 
    // getters and setters
}
```

In the Employee entity, the @ManyToOne annotation specifies the relationship with the Department entity using the fetch attribute, which is set to LAZY to avoid loading the Department entity unless explicitly requested. The @JoinColumn annotation specifies the foreign key column name in the Employee table.

In the Department entity, the @OneToMany annotation specifies the relationship with the Employee entity using the mappedBy attribute, which indicates that the relationship is mapped by the "department" field in the Employee entity.

With this mapping, we can easily navigate from an Employee to its Department and from a Department to its Employees.


## Many-To-Many Mapping

Many-to-many mapping in Hibernate is used to map relationships between two entities where both entities can have multiple instances related to each other. In this mapping, a table is created to store the relationships between the two entities. This table is known as the join table, which contains foreign keys from both tables.

To implement many-to-many mapping in Hibernate, we need to use the @ManyToMany annotation. The @ManyToMany annotation can be used on either side of the relationship to establish the association. Here's an example:

```
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_course",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses = new HashSet<>();
}

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();
}
```

In this example, we have two entities, Student and Course, which have a many-to-many relationship with each other. The Student entity has a set of Course entities, and the Course entity has a set of Student entities.

The @ManyToMany annotation is used on both the Student.courses and Course.students fields to establish the association. The cascade attribute is set to CascadeType.ALL, which means that any changes made to the Student or Course entity will be propagated to the other entity. The @JoinTable annotation is used to define the join table name and the foreign key columns used to map the relationship.

In this example, the join table is named student_course, and it has two foreign keys, student_id and course_id, which reference the primary keys of the Student and Course entities, respectively. The inverseJoinColumns attribute is used to specify the foreign key column on the Course entity. The mappedBy attribute is used to indicate that the Course.students field is the owner of the association.
