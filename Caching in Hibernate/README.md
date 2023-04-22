## Caching in Hibernate

Caching is an important aspect of any application that deals with a large amount of data. Caching is used to improve performance by storing frequently accessed data in memory so that it can be retrieved quickly without having to access the database each time. Hibernate provides two levels of caching:

- **`First-level cache (Session-level cache):`** The first-level cache is enabled by default in Hibernate. It is associated with the Session object and is used to store the entities that have been loaded from the database during the current session. The first-level cache is also known as the Session-level cache and is used to reduce the number of SQL queries executed by Hibernate.

- **`Second-level cache:`** The second-level cache is an optional cache that can be used to store entities across sessions. The second-level cache is shared by all the Sessions that use the same SessionFactory. Hibernate provides support for a number of second-level cache providers, including EHCache, Infinispan, and Redis.

To use seconde level caching in Hibernate, you need to configure the cache provider and specify which entities should be cached. Here's an example of how to enable caching for an entity:

```
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Product {
    // entity code
}
```

In this example, the `@Cacheable` annotation is used to indicate that the entity should be cached, and the `@Cache` annotation is used to specify the caching strategy. In this case, the `READ_WRITE` strategy is used, which means that the cache will be updated whenever the entity is modified.

You can also enable caching at the query level by using the `setCacheable` method on the Query object. For example:

```
Query query = session.createQuery("from Product p where p.price > :price");
query.setParameter("price", 100);
query.setCacheable(true);
List<Product> products = query.list();
```

In this example, the `setCacheable` method is used to enable caching for the query. The results of the query will be cached so that they can be retrieved quickly the next time the query is executed.

Overall, caching is an important feature of Hibernate that can significantly improve performance by reducing the number of database queries that need to be executed. By carefully configuring the caching settings, you can ensure that your application is fast and efficient, even when dealing with large amounts of data.

## Configuring Second level cache in Hibernate

To enable the second level cache in Hibernate, the following configuration properties need to be set in the Hibernate configuration file:

- Enable the second level cache:

```
<property name="hibernate.cache.use_second_level_cache">true</property>
```

- Specify the cache provider to be used:

```
<property name="hibernate.cache.region.factory_class">org.hibernate.cache.ehcache.EhCacheRegionFactory</property>
```

- **Note:-** The `org.hibernate.cache.ehcache.EhCacheRegionFactory` is the Ehcache provider class. There are other cache providers available as well, such as `net.sf.ehcache.hibernate.SingletonEhCacheRegionFactory` for Hibernate 3.

- Optionally, specify the cache configuration file location:

```
<property name="hibernate.cache.provider_configuration_file_resource_path">/ehcache.xml</property>
```

Here, /ehcache.xml is the location of the Ehcache configuration file. If not specified, Hibernate uses the default configuration.

- Optionally, enable query caching:

```
<property name="hibernate.cache.use_query_cache">true</property>
```

Enabling query caching can improve performance when the same query is executed multiple times with the same parameters.

- **Note:-** Different cache providers may have different configuration properties. The above configuration properties are for Ehcache.

## @Cache annotation

The `@Cache` annotation is used to configure the cache settings for a particular entity or collection in Hibernate.

This annotation has several attributes that can be used to configure the caching behavior:

- `usage:` Specifies the cache concurrency strategy to be used. The available options are `NONSTRICT_READ_WRITE`, `READ_WRITE`, `READ_ONLY`, `TRANSACTIONAL`.

- `region:` Specifies the name of the cache region to be used.

- `include:` Specifies whether or not the entity or collection should be included in the second-level cache.

- `evict:` Specifies whether or not the entity or collection should be evicted from the second-level cache.

Here's an example usage of the `@Cache` annotation:

```
@Entity
@Table(name = "product")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "productCache")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "quantity")
    private int quantity;

    // getters and setters
}
```

In this example, the `@Cacheable` annotation is used to indicate that this entity should be cached, and the `@Cache` annotation is used to configure the cache settings. The `usage` attribute is set to `READ_WRITE`, which means that the cache should be used for both reading and writing. The region attribute is set to `productCache`, which specifies the name of the cache `region` to be used.

## What is Query Cache

Query cache is a feature of Hibernate's second-level cache that allows the results of queries to be cached. When a query is executed, Hibernate checks if the same query has been executed before with the same parameters. If so, it retrieves the results from the cache instead of executing the query again. This can improve performance and reduce the number of database queries.

To use query cache, the `hibernate.cache.use_query_cache` configuration property should be set to `true`. Additionally, the query should be marked as cacheable using the `setCacheable(true)` method on the `Query` or `Criteria` object. The query cache can be configured with various properties such as the maximum number of cached queries and the time-to-live for cached queries.