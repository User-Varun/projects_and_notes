👉 The modern and preferred way of writing Redux code

👉 An opinionated approach, forcing us to use Redux best practices

👉 100% compatible with “classic” Redux, allowing us to use them together

👉 Allows us to write a lot less code to achieve the same result (less “boilerplate”)

👉 Gives us 3 big things (but there are many more…):

- We can write code that “mutates” state inside reducers (will be converted to immutable logic behind the scenes by “Immer” library)
- Action creators are automatically created
- Automatic setup of thunk middleware and DevTools

## **Getting Started :-**

- **install `npm i @reduxjs/toolkit`**
- `createStore  `    is deprecated now use configureStore ( it wraps around createStore and give use additonal functionalities like automatic middleware (thunk) setup , devToolsSetup, auto setup store)  from @reduxjs/toolkit
- it makes the job easy as :-

```js
/* After */
   
   import { configureStore } from "@reduxjs/toolkit";
   import AccountReducer from "./features/accounts/accountSlice";
   import CustomerReducer from "./features/customers/customerSlice";
   
   const store = configureStore({
     reducer: {
       account: AccountReducer,
       customer: CustomerReducer,
     },
   });
   
   export default store;
   
   
/* Before */
   
import { applyMiddleware, combineReducers, createStore } from "redux";
import AccountReducer from "./features/accounts/accountSlice";
import CustomerReducer from "./features/customers/customerSlice";

import { thunk } from "redux-thunk";

import { composeWithDevTools } from "@redux-devtools/extension";

const rootReducer = combineReducers({
  account: AccountReducer,
  customer: CustomerReducer,
});

const store = createStore(
  rootReducer,
  composeWithDevTools(applyMiddleware(thunk))
);

export default store;

```