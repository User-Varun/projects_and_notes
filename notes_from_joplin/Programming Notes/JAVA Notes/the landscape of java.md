- **Java SE (Standard Edition)** includes the core components for general-purpose Java development:
    
    - **Java Virtual Machine (JVM)**: Executes bytecode, enabling platform independence.
        
    - **Java Runtime Environment (JRE)**: Contains JVM and core libraries to run Java applications.
        
    - **Java Development Kit (JDK)**: Includes JRE plus development tools (compiler, debugger, `javadoc`).
        
    - **Core APIs**: `java.lang`, `java.util`, `java.io`, `java.net`, `JDBC`, `JNDI`, `RMI`.
        
    - **GUI Libraries**: AWT, Swing, JavaFX.
        
    - **Concurrency**: `java.util.concurrent`, threading support.
        
    - **Security**: Cryptography, authentication, and secure communication APIs.
        
    - **Deployment Tools**: Java Web Start, Java Plug-in (legacy).
        

&nbsp;

- With **Java SE only**, you can build:
  - **Command-line applications** (e.g., utilities, scripts)
    
  - **Desktop GUI apps** using **Swing**, **JavaFX**, or **AWT**
    
  - **File processing tools** (read/write files, CSV, JSON)
    
  - **Networking apps** using `java.net` (e.g., TCP/UDP clients/servers)
    
  - **Database applications** via **JDBC** (connect to MySQL, PostgreSQL, etc.)
    
  - **Multithreaded programs** using `java.util.concurrent`
    
  - **Simple HTTP servers** using `com.sun.net.httpserver` (built into Java 6+)
    

&nbsp;

- **Java EE (Enterprise Edition)**, now **Jakarta EE**, extends Java SE with enterprise-grade technologies:
    
    - **Web Technologies**:
        
        - **Servlets**, **JSP**, **JSF** for web UIs.
            
        - **WebSocket** for full-duplex communication.
            
        - **JAX-RS** for RESTful services.
            
        - **JAX-WS** for SOAP-based web services.
            
    - **Business & Integration**:
        
        - **EJB (Enterprise JavaBeans)**: Server-side components for business logic.
            
        - **JMS (Java Message Service)**: Messaging for distributed systems.
            
        - **JCA (Connector Architecture)**: Integration with enterprise systems.
            
    - **Data & Transactions**:
        
        - **JPA (Java Persistence API)**: ORM for database mapping.
            
        - **JTA (Java Transaction API)**: Distributed transaction management.
            
    - **Dependency & Context Management**:
        
        - **CDI (Contexts and Dependency Injection)**.
            
        - **DI (Dependency Injection for Java)**.
            
    - **Other Key APIs**:
        
        - **Bean Validation**, **Batch Processing**, **JSON Processing/Binding**, **XML Binding (JAXB)**.