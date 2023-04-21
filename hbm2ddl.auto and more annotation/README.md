## hbm2ddl.auto configuration

The `hbm2ddl.auto` configuration option in Hibernate specifies the behavior of the `hbm2ddl` schema generation tool when the application starts up. It can be set to one of the following values:

- *`validate:`* This is the default value. It validates that the schema is in sync with the current mapping. It does not make any changes to the database schema.

- *`update:`* This updates an existing schema to match the current mapping. It will add missing tables, columns, and constraints, and will drop those that no longer exist in the mapping. However, it will not delete data in existing tables, and it may not be able to handle complex changes such as renaming columns.

- *`create:*` This creates a new schema from scratch based on the current mapping. It drops any existing schema and recreates it. It's useful for development, but not recommended for production use.

- *`create-drop:`* This creates a new schema from scratch based on the current mapping, and then drops it when the application shuts down. This is useful for development and testing.

- *`none:`* This disables the `hbm2ddl` schema generation tool. It does not validate, update, or create the schema.

These configuration options can be set in the Hibernate configuration file, the persistence.xml file, or programmatically in the code. It's important to choose the appropriate value for `hbm2ddl.auto` based on the requirements of the application and the database schema.


## Hibernate basic annotations

Hibernate provides a variety of annotations that can be used to configure the mapping between Java objects and database tables. Here are some of the most commonly used annotations in Hibernate:

- @Entity: This annotation is used to mark a Java class as an entity, which means that it corresponds to a database table.

- @Table: This annotation is used to specify the name of the database table that the entity corresponds to. It can also be used to specify other table-level properties such as indexes and constraints.

- @Id: This annotation is used to specify the primary key of the entity. It can be used with various types of primary keys such as auto-generated keys, composite keys, and custom keys.

- @GeneratedValue: This annotation is used to specify the strategy used to generate primary key values. Hibernate provides several strategies such as identity, sequence, and table.

- @Column: This annotation is used to specify the mapping between an entity attribute and a database column. It can be used to specify the name, type, length, and other properties of the database column.

- @OneToOne, @OneToMany, @ManyToOne, and @ManyToMany: These annotations are used to specify the mapping between associations or relationships between entities.

- @JoinColumn: This annotation is used to specify the join column used for a relationship between entities. It can be used to specify the name, nullable, and other properties of the join column.

- @Cascade: This annotation is used to specify the cascading behavior of operations such as save, update, and delete. It can be used to specify which operations should be cascaded to associated entities.

- @Transient: This annotation is used to mark an entity attribute as transient, which means that it should not be persisted to the database.

- @NamedQuery and @NamedQueries: These annotations are used to define named queries in the entity class. Named queries can be used to simplify the code required to execute common queries.

- @Cacheable and @Cache: These annotations are used to enable and configure caching for entities and queries. Hibernate provides several caching strategies such as LRU, time-based, and transactional.

- @Embeddable and @Embedded: These annotations are used to define and map composite value types. Composite value types allow you to group related attributes into a single object.

- @MapKey and @MapKeyColumn: These annotations are used to specify the key of a map collection in an entity. The `@MapKey` annotation can be used to specify the attribute of the entity that should be used as the map key, while `@MapKeyColumn` can be used to specify the name of the column that should be used as the map key.

- @JoinColumn and @JoinTable: These annotations are used to define the mapping of join columns in relationships between entities. `@JoinColumn` is used to map a foreign key column in an entity to a primary key column in another entity, while `@JoinTable` is used to map a many-to-many relationship using an intermediate join table.

- @SequenceGenerator and @TableGenerator: These annotations are used to define custom ID generators for entities. `@SequenceGenerator` is used to generate unique ID values using a database sequence, while `@TableGenerator` is used to generate unique ID values using a database table.

- @DiscriminatorColumn and @DiscriminatorValue: These annotations are used to implement inheritance mapping in Hibernate. The `@DiscriminatorColumn` annotation is used to specify the name of the column used to store the discriminator value in the database, while `@DiscriminatorValue` is used to specify the value of the discriminator column for a particular entity class.

