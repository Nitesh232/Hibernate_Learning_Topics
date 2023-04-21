## Value types and object embedding

In Hibernate, there are two ways to persist an object, i.e., as an entity or a value type. An **entity** is a persistent object that has its own identity and is stored in a separate table in the database. On the other hand, a **value type** is a non-persistent object that is mapped to a single column in the table.

When we want to map a non-persistent object to the table, we can use the **Embeddable** annotation to indicate that the object is embedded within the entity. The **Embeddable** annotation is used to define a class whose instances are stored as an intrinsic part of the owning entity.

For example, consider a scenario where we have an entity called `Address` and we want to embed it in another entity called `Employee`. We can define the `Address` class as an embeddable object using the **`@Embeddable`** annotation as follows:

```@Embeddable
public class Address {
    private String street;
    private String city;
    private String state;
    private String zip;
    
    // getters and setters
}
```

Now, we can embed the `Address` object in the `Employee` entity as follows:

```
@Entity
public class Employee {
    @Id
    private Long id;
    private String name;
    
    @Embedded
    private Address address;
    
    // getters and setters
}
```

Here, the `@Embedded` annotation is used to indicate that the `Address` object is embedded in the `Employee` entity.

We can also use the `@AttributeOverride` and `@AttributeOverrides` annotations to override the column names of the embedded object in the owning entity.


```
@Entity
public class Employee {
    @Id
    private Long id;
    private String name;
    
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "street", column = @Column(name = "employee_street")),
        @AttributeOverride(name = "city", column = @Column(name = "employee_city")),
        @AttributeOverride(name = "state", column = @Column(name = "employee_state")),
        @AttributeOverride(name = "zip", column = @Column(name = "employee_zip"))
    })
    private Address address;
    
    // getters and setters
}
```

Here, we have used the `@AttributeOverride` and `@AttributeOverrides` annotations to override the column names of the `Address` object in the `Employee` entity.