# Proxy Object

### What proxy objects mean?

A proxy object is an object that acts as an intermediary between a client object and a target object. In other words, a proxy object provides a surrogate or placeholder for another object and controls access to it.

When a client requests to access a target object, the request is intercepted by the proxy object, which can perform additional operations before or after forwarding the request to the target object. These additional operations may include checking permissions, caching results, or logging the request.

The use of a proxy object can provide several benefits, such as improving performance by reducing the number of direct calls to the target object or providing a layer of security by enforcing access control rules. Additionally, proxy objects can be used to implement other design patterns, such as the decorator pattern or the adapter pattern.

Proxy objects are commonly used in software systems, including web applications, distributed systems, and database management systems, among others.

## Fetching Strategies/Types

there are two types of the fetching strategies in the hibernate:

-  **Lazy Fetch type:** Lazy fetching means that the associated entities are not loaded from the database until they are actually accessed. This can be achieved by using the lazy keyword in the HQL or by specifying the FetchType.LAZY option in the annotations. Lazy fetching can be useful when the associated entities are not always needed and the amount of data is large, as it can improve performance by reducing the amount of data loaded from the database.

- **Eager Fetch type:** Eager fetching means that the associated entities are loaded from the database at the same time as the main entity is loaded. This can be achieved by using the fetch keyword in the HQL (Hibernate Query Language) or by specifying the FetchType.EAGER option in the @OneToMany, @ManyToOne, or @ManyToMany annotations. Eager fetching can be useful when the associated entities are needed frequently and the amount of data is small.