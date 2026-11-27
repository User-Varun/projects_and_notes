nov 27 
- add customer address endpoint 
- finished the add to cart method
- next check if add to cart functionality is working or needs more fixing



nov 25 
- created JwtAuthFilter that will validate (non public) http requests and validates them (contains jwt token or not and if it's valid )
- i choose to do auth with email & password , i could also have done using username & password
- now my requests are authenticating, role based interactions will need to be set (later)
- adding the product controller so i can add to product to system
- need to add swagger ui here (so can track of the routes and methods in the app)
nov 25 (1:23pm)
- request are now being authenticated
- product adding to inventory success
- next is user adding the product to the cart.


nov 24
- made progress in add to cart functionality , check the routes for add a product to customer cart (role base auth rules will add later)
- in the auth fix the issue of needing to read the access token when it comes from the request. (for requeest to be used, rn giving 403 on every request besides login and register)



## old 
- abhi product populate kar liya hai customer ke liye baseed on nearest location
- ab customer ko add to kart and search aur dena hai phir place order implement karunga
- then if when needed implement the simulation of packer and delivery
- and then make auth proper make routes available based on role.





# What i'm working on right now 
- working on customer module (make ordering happen by customer --big goal)


# What's currently implemented 

## Auth routes
   - login , signup are working , refresh needs work

## Customer 
  - 


## rough 
-- admin will crud the darkstores 
-- products will be crud by the store admin

A common split is:
- System admin / catalog admin: Create, update, or deactivate products in the global catalog. They also create and manage dark stores.
- Store admin / store manager: Manage that store’s inventory—add an existing product to the store,



# Project Scope

- simulated picker and delivery task using background workers
- live events updates using websockets

- A Frontend UI for the customer (browse products , add-to-cart, place order) order tracking , status
- per darkstore seperate inventory without any catalogs (using category)

- every darkstore has raduis of 5km , show customer real-time live inventory of nearest store.

- auth using JWT and OAuth2 ( start with jwt) with role (Customer, System Admin, Packer , Delivery Partner , Store_manager)

- stock reservation when customer places order

- duplicate request prevention ( idempontency )

- states in my system (PLACED --> PACKING --> PACKED --> OUT_FOR_DELIVERY --> DELIVERED)

- assign the order to available packer , delivery_partner from pool of packers and delivery drivers

- keep packer and delivery_partner as thin as possible ( besides tracking order history in both we tracking nothing about packer and rider such as payments , how many days they came , incentives and others , to keep the system short)

<br></br>
<br></br>

# Per User final requirements

## Customer

- browse nearest-store-inventory
- add-to-cart
- track-order-status
- order-history
- manage ADDRESSES (CRUD)
- pay online (mock payment system)

## Packer

- order-history

  ### Process Flow

- punch-in at store (packer active to work)
- recive order assignments
- pick items
- marks them as completed
- mark order as packed when all items are picked.

## Delivery Partner

- order history

  ### Process Flow

- punch-in at store (rider active to work)
- recive delivery assignments
- mark out for delivery
- reach at delivery store

## Store Manager

- manage inventory (CRUD)
- onboard new rider and packer

## System Admin

- Manage dark-store (CRUD)
- Add products to the system (that store manager uses to manage inventory)

## System Responsibilities

- automatic assignment of orders to packer and rider
- automatic show customer it's nearest darkstore's products.
- track the current state of the order (placed --> packing --> packed --> out_for_delivery --> delivered)

## Payments

- system handles payment (mock it) uses 3 states ( PENDING , SUCCESS , FAILED);
- customer click pay online, backend mocks it by and sends real-time updates to customer.

## Other Requirements

- should handle simultaneous customer orders
- prevent inventory overselling , duplicate packer , delivery assignments , customer orders
- concurrency tests
- rollback and exception handling

## Technologies to use

- websockets for real time updates
- redis for caching
- elastic search
- nginx
- postman , junit5 , Jenkins , mokito , jMeter (for testing , decides which tools is usefull for that)
- swagger for api doc
- aws , hostinger , vercel , or free vps ( to host )
- springboot , security , jpa , others as requried ( for backend )
- load testing of the system using k6

<br></br>
<br></br>

# Complete customer journey

1. Customer authentication

   Customer logs in and obtains a JWT.

2. Manage address

   Customer selects one of their saved addresses or creates a new one.

3. Browse products

   Display products available for the customer's delivery area.

4. Add to cart

   Add products and quantities. No inventory reservation yet.

5. Checkout

   Validate cart, select dark store, calculate prices, check inventory and reserve stock.

6. Order confirmed

   Create order, order items and packing task.
   ORDER CONFIRMED

7. Packer assignment

   Select an eligible packer and assign the task atomically.
   PACKING

8. Picking and packing

   Packer picks items and marks the order ready for pickup.

9. Driver assignment

   Select an eligible driver and assign the delivery.

10. Delivery

    Driver picks up the package, starts delivery and marks it delivered.
    DELIVERED
