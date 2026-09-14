# smart-commerce

"What is @PrePersist?"

"@PrePersist is a JPA lifecycle callback that executes before an entity is initially persisted to the database. I can use it to automatically initialize fields such as createdAt and updatedAt."

What is @PreUpdate?
"@PreUpdate executes before an existing entity is updated, so I can automatically update fields such as updatedAt."

Product is an entity class because it represents data.

ProductRepository is a repository interface because it defines the database-access contract, while Spring provides the implementation.

@Service

tells Spring:

"This class contains business logic and should be managed as a Spring bean."

2. Why private final?
private final ProductRepository productRepository;

We're saying:

ProductService depends on ProductRepository.

And final means that once the repository is assigned, we don't replace it with another repository.

3. Constructor injection
public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
}

Spring sees that ProductRepository is required by ProductService and injects it automatically.

This is called Dependency Injection.

Conceptually:

Spring Container
      │
      ├── ProductRepository
      │
      └── ProductService
               │
               └── receives ProductRepository

Why do you prefer constructor injection?

Say:

"Constructor injection makes mandatory dependencies explicit, allows them to be declared as final, improves testability, and avoids hidden dependencies associated with field injection."

@RestController

Tells Spring:

"This class handles HTTP/REST requests and returns the response directly as JSON."

@RequestMapping
@RequestMapping("/api/products")

This establishes the base URL.

@RestControllerAdvice

What is this in Java?", you can say:

"this is a reference to the current object. It is commonly used to distinguish instance variables from local variables or constructor parameters when they have the same name."
