
# Hibernate_Learning_Topics



### Embedding in Hibernate 

Embedding allows you to group objects' related properties into a single object that is then mapped to a table. This is helpful when you need to gather specific properties of an item and store them in a different table without making a different element class for them.

Consider, for instance, a User entity with a number of properties, such as an address, first name, and last name. You can create a separate Address object that contains the address properties and map the Address object to a separate Address table rather than mapping each property to a separate column in the User table. The address properties can then be stored in the Address table and retrieved and updated alongside the User object by embedding the Address object into the User object.

Depending on whether the object is embedded directly in the entity or in another embedded object, you must annotate the properties of the embedded object with the **@Embedded** or **@Embeddable** annotation in order to use embedding in Hibernate. The mapping must also be set up in the Hibernate configuration file.



In general, embedding is a useful feature in Hibernate that lets you group similar properties of an object together and store them in a separate table while still keeping a logical connection between them. This can work on the planning of perplexing items to social information bases and further develop execution by decreasing the quantity of data set tables and questions expected to recover or refresh information.
