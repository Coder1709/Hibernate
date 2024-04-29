# Understanding Object States in Hibernate

In Hibernate, an object can be in one of three states: transient, persistent, and detached. Let's understand each state and see examples of how to work with them.

## Theory

### Transient State

An object is in a transient state if it is just created but has no primary key (identifier) and is not associated with a session. It's simply a simple Java object, not a special object of Hibernate.

### Persistent State

An object is in a persistent state if the session is open, and you have either saved the instance in the database or retrieved the instance from the database.

### Detached State

An object is in a detached state if the session is closed. After the detached state, the object can come back to the persistent state if you call `lock()` or `update()` method.

## Code Examples

### Transient State

```java
// Creating a transient object
Customer customer = new Customer("John Doe", LocalDate.of(1990, 5, 15), "Engineer", "Senior Engineer", "ABC Company");

// Open a Hibernate session
Session session = sessionFactory.openSession();
session.beginTransaction();

// Save the customer instance
session.save(customer);

session.getTransaction().commit();
session.close();
// Open a new session
Session session = sessionFactory.openSession();
session.beginTransaction();

// Retrieve the customer instance
Customer retrievedCustomer = session.get(Customer.class, customerId);

session.getTransaction().commit();
session.close();

// Customer is now in detached state

// Re-attach the customer to a new session
Session newSession = sessionFactory.openSession();
newSession.beginTransaction();

newSession.update(retrievedCustomer); // or newSession.lock(retrievedCustomer, LockMode.NONE);

newSession.getTransaction().commit();
newSession.close();
