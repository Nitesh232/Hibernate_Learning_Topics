## Named Query in Hibernate

A named query is a pre-defined query in Hibernate that is defined with a name and stored in a configuration file or directly in an entity class. It allows developers to define a query once and use it multiple times without rewriting the query. Named queries are static and can be defined either in the mapping file or in the entity class using annotations.

Named queries can be invoked using the `createQuery()` method of the `Session` object or the `getNamedQuery()` method of the `SessionFactory` object. Named queries can also accept parameters, which can be set using the `setParameter()` method of the `Query` object.

Here's an example of a named query defined in an entity class using annotations:

```
@Entity
@NamedQuery(name = "findEmployeesByDepartment", query = "from Employee where department = :department")
public class Employee {
   // class definition
}
```

This named query can be invoked as follows:

```
Query query = session.getNamedQuery("findEmployeesByDepartment");
query.setParameter("department", "IT");
List<Employee> employees = query.list();
```