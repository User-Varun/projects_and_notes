## The layered Architecture ( model  , Repository , service , controller )  ----- This is a Backend only Architecture

- It defines **how server code is organised**, NOT how your full stack app looks.
    
- It governs business logic
    
- It governs DB access
    
- It governs API endpoints
    
- It governs the backend internal structure
    

Frontend is not involved here at all.

&nbsp;

### Backend Architecture

➡ Layered / Clean / Hexagonal / Domain-Driven-Design etc.

### Frontend Architecture

➡ MVC / Model-View-ViewModel / Flux / Redux / Component architecture etc.

And the two connect via **API layer**:

`[Frontend architecture] ←→ REST / GraphQL/WebSockets/gRPC ←→ [Backend architecture]`

&nbsp;

- MVC was initially for server side rendered pages
- But now (React , View , Angular handles UI )
-  So UI becomes `Client-side MVC / MVVM / Component Architecture`
- MVC is NOT used anymore in the backend *unless you generate HTML pages*.