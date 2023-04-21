## Hibernate Session and its method

**Session** interface is the primary interface for working with the Hibernate framework. It represents a single unit of work with the database and provides methods to query and manipulate persistent objects.

Some of the important methods of the **Session** interface are:

- **save(Object obj):** Saves the given object to the database and returns the generated ID.

- **persist(Object obj):** Persists the given object to the database.

- **update(Object obj):** Updates the given object in the database.
- **delete(Object obj):** Deletes the given object from the database.
- **get(Class<T> entityClass, Serializable id):** Returns the persistent instance of the given entity class with the given ID.
- **load(Class<T> entityClass, Serializable id):** Returns the persistent instance of the given entity class with the given ID, or a proxy if it doesn't exist.
- **createQuery(String hql):** Creates an HQL query object for the given HQL string.
- **createSQLQuery(String sql):** Creates an SQL query object for the given SQL string.
- **beginTransaction():** Starts a new transaction with the database.
- **commit():** Commits the current transaction to the database.
- **rollback():** Rolls back the current transaction.
- **close():** Closes the session.


These are just a few of the methods provided by the Session interface. There are many other methods available for querying and manipulating persistent objects, managing transactions, and working with the Hibernate cache.