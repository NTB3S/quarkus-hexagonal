# Hexagonal Architecture (Ports and Adapters) in Development

## Introduction

Hexagonal Architecture, also known as Ports and Adapters, is a design pattern used in software development to create loosely coupled and maintainable systems. It was introduced by Alistair Cockburn in the early 2000s. This architectural style aims to isolate the core logic of an application from external concerns, such as user interfaces, databases, or third-party services, by using well-defined interfaces (ports) and their implementations (adapters).

## Key Concepts

### Core (Domain)

The core or domain is the heart of the application, containing the business logic. It is independent of any external systems or technologies. This ensures that changes in the external environment do not affect the core logic.

### Ports

Ports are interfaces that define how the core interacts with the outside world. They can be of two types:

- **Inbound Ports**: These ports define how external systems can interact with the core. They are typically implemented as interfaces or abstract classes.
- **Outbound Ports**: These ports define how the core can interact with external systems. They provide a way for the core to send data outwards or request data from external sources.

### Adapters

Adapters are implementations of the ports. They handle the details of communication with external systems. Adapters can be of two types:

- **Inbound Adapters**: These adapters convert input from external systems into a format that the core can understand. Examples include REST controllers, user interfaces, and message consumers.
- **Outbound Adapters**: These adapters convert the core's output into a format suitable for external systems. Examples include database repositories, external service clients, and message producers.

## Benefits

1. **Separation of Concerns**: By isolating the core logic from external systems, changes to one do not directly impact the other.
2. **Testability**: The core logic can be easily tested in isolation by mocking the ports.
3. **Flexibility**: The architecture allows for easy swapping of technologies and external systems without modifying the core logic.
4. **Maintainability**: Clear boundaries and separation of concerns lead to a more maintainable codebase.

## Implementation Steps

1. **Define Core Logic**: Implement the core business logic and ensure it is independent of any external systems.
2. **Create Ports**: Define interfaces (ports) that represent the communication points between the core and the external world.
3. **Implement Adapters**: Develop the inbound and outbound adapters to handle interactions with external systems.
4. **Compose the Application**: Wire together the core, ports, and adapters to form the complete application.

## Tests

1. **Domain**: Unit tests
2. **Adapter**/ Integration tests
3. **Application**: End-to-end tests

## Project Structure

```
my-hexagonal-app/
├── model/
│   └── src/main/java/com/example/model
│       └── (domain entities and value objects)
├── application/
│   └── src/main/java/com/example/application
│       └── (use cases and business logic)
├── adapters/
│   ├── src/main/java/com/example/adapters/in
│   │   └── (inbound adapters: controllers, APIs)
│   └── src/main/java/com/example/adapters/out
│       └── (outbound adapters: repositories, external services)
├── bootstraps/
│   └── src/main/java/com/example/bootstraps
│       └── (application entry points, dependency injection configuration)
├── pom.xml
```

## Module Details

### Model
The `model` module is the core of the application, containing the domain entities and value objects that represent the business logic. This module is independent of other parts of the system and should not depend on any external libraries or frameworks.

### Application
The `application` module holds the use cases and application services that encapsulate the business logic. This module orchestrates the interaction between the `model` module and the `adapters` module, ensuring that the core business rules are applied correctly. It is responsible for executing operations and managing the flow of data within the application.

### Adapters
The `adapters` module is divided into two main sub-modules: `in` and `out`.

- **In Adapters**: These adapters handle incoming requests from external systems, such as user interfaces, APIs, or message queues. They convert external data into a format that the application module can process and pass it to the appropriate application service.
  
- **Out Adapters**: These adapters manage outgoing interactions with external systems, such as databases, external APIs, or other services. They convert the data from the application module into a format suitable for external systems and handle the communication.

### Bootstraps
The `bootstraps` module contains the entry points and configuration for the application, including dependency injection setup. It initializes and wires together all the modules and their dependencies, preparing the application to run. This module ensures that all components are correctly instantiated and configured at startup.

## Conclusion

Hexagonal Architecture promotes a clean separation of concerns, making your application more modular, testable, and maintainable. By adhering to this pattern, you can develop systems that are resilient to change and easier to evolve over time.
