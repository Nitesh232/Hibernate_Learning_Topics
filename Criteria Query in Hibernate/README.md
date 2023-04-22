## Criteria Query in Hibernate

Criteria is an interface that provides an API for building type-safe, dynamic queries for retrieving entities from a database. It allows building queries dynamically based on different criteria, such as restrictions, projections, sorting, and pagination.

Criteria queries are mainly used to retrieve a set of entities based on some specific conditions, which can be applied by adding restrictions to the criteria object. The Criteria API also supports pagination and sorting, as well as projections to return only specific properties of the entities.

The Criteria API is a powerful feature of Hibernate that allows developers to write complex queries in a type-safe manner, avoiding issues like SQL injection, while still maintaining the flexibility and expressiveness of SQL.

## Restrictions in Criteria Query

Restrictions is a class that provides a set of methods to create criteria query conditions. Some of the commonly used methods in Restrictions class are:

- `eq(String propertyName, Object value):` Creates a criterion that compares the specified property value with the given value for equality.
- `ne(String propertyName, Object value):` Creates a criterion that compares the specified property value with the given value for inequality.
- `gt(String propertyName, Object value):` Creates a criterion that compares the specified property value with the given value for greater than.
- `ge(String propertyName, Object value):` Creates a criterion that compares the specified property value with the given value for greater than or equal to.
- `lt(String propertyName, Object value):` Creates a criterion that compares the specified property value with the given value for less than.
- `le(String propertyName, Object value):` Creates a criterion that compares the specified property value with the given value for less than or equal to.
- `like(String propertyName, String value):` Creates a criterion that performs a case-sensitive "like" comparison of the specified property value with the given value.
- `ilike(String propertyName, String value):` Creates a criterion that performs a case-insensitive "like" comparison of the specified property value with the given value.
- `isNull(String propertyName):` Creates a criterion that checks if the specified property value is null.
- `isNotNull(String propertyName):` Creates a criterion that checks if the specified property value is not null.
- `in(String propertyName, Object[] values):` Creates a criterion that checks if the specified property value is in the given array of values.
- `between(String propertyName, Object lo, Object hi):` Creates a criterion that checks if the specified property value is between the given lower and upper bounds.
- `and(Criterion lhs, Criterion rhs):` Creates a conjunction (AND) of two criterion.
- `or(Criterion lhs, Criterion rhs):` Creates a disjunction (OR) of two criterion.
- `not(Criterion expression):` Creates a negation of the given criterion.
These methods can be used to create complex criteria queries by combining them with logical operators such as AND, OR, and NOT.

## Projections in Criteria Query

Projection in Criteria Query is used to retrieve selective columns or fields from the entity objects. It provides a way to specify which fields to retrieve from an entity and helps to optimize performance by reducing the amount of data retrieved from the database.

Some of the commonly used Projection methods in Hibernate are:

- `Projections.property("propertyName"):` Used to retrieve a single property of the entity.
- `Projections.sum("propertyName"):` Used to retrieve the sum of values of a given property in the result set.
- `Projections.avg("propertyName"):` Used to retrieve the average of values of a given property in the result set.
- `Projections.max("propertyName"):` Used to retrieve the maximum value of a given property in the result set.
- `Projections.min("propertyName"):` Used to retrieve the minimum value of a given property in the result set.
- `Projections.groupProperty("propertyName"):` Used to group the result set based on a given property.
- `Projections.rowCount():` Used to retrieve the total number of rows in the result set.

For example, to retrieve the total count of users in the User entity, we can use the Projections.rowCount() method as follows:

```
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Long> query = builder.createQuery(Long.class);
Root<User> root = query.from(User.class);
query.select(builder.count(root));
Long count = session.createQuery(query).getSingleResult();
```

Similarly, to retrieve the sum of salaries of all employees in the Employee entity, we can use the Projections.sum("salary") method as follows:

```
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Double> query = builder.createQuery(Double.class);
Root<Employee> root = query.from(Employee.class);
query.select(builder.sum(root.get("salary")));
Double sum = session.createQuery(query).getSingleResult();
```