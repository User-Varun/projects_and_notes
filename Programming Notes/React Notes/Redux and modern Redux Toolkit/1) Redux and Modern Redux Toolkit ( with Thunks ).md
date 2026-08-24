WHAT IS REDUX?

- 👉 3rd-party library to manage global state ( in a web app )
- 👉 Standalone library, but easy to integrate with React apps using react-redux library
- 👉 All global state is stored in one globally accessible store, which is easy to update using “actions” (like useReducer)
- 👉 It’s conceptually similar to using the Context API + useReducer
- 👉 Two “versions”: (1) Classic Redux, (2) Modern Redux Toolkit

&nbsp;

![f41cee792d6013e6f0cf22191f33704c.png](../../../../_resources/f41cee792d6013e6f0cf22191f33704c.png)

![f6e01e2b75a96608e99a79a85561bd18.png](../../../../_resources/f6e01e2b75a96608e99a79a85561bd18.png)

![83688cfd7b085800a2590c9a75e88c5a.png](../../../../_resources/83688cfd7b085800a2590c9a75e88c5a.png)

![ef2c702751b849bd2c5688813a50f486.png](../../../../_resources/ef2c702751b849bd2c5688813a50f486.png)

![b7e59bc1f69d4de4d50c894541359bde.png](../../../../_resources/b7e59bc1f69d4de4d50c894541359bde.png)

- Learning the Classic Redux ( in isolation ) 

```js
import { createStore } from "redux";
const initialState = {
  balance: 0,
  loan: 0,
  loanPurpose: "",
};

function reducer(state = initialState, action) {
  switch (action.type) {
    case "account/deposit":
      return { ...state, balance: state.balance + action.payload };
    case "account/withdraw":
      return { ...state, balance: state.balance - action.payload };
    case "account/requestLoan":
      if (state.loan > 0) return state;
      // Later
      return {
        ...state,
        loan: action.payload.amount,
        loanPurpose: action.payload.purpose,
        balance: state.balance + action.payload.amount,
      };

    case "account/payLoan":
      return {
        ...state,
        loan: 0,
        loanPurpose: "",
        balance: state.balance - state.loan,
      };
    default:
      return state;
  }
}

const store = createStore(reducer);

store.dispatch({ type: "account/deposit", payload: 500 });
store.dispatch({ type: "account/withdraw", payload: 200 });

console.log(store.getState());

store.dispatch({
  type: "account/requestLoan",
  payload: { amount: 1000, purpose: "Buy a Car" },
});
console.log(store.getState());

store.dispatch({ type: "account/payLoan" });
console.log(store.getState());

```

- createStore(reducer)  , getState() are from redux library
- it's also a convention to use start with domain/purpose of the type 
    
    ## \# in Redux we use action creator fn instead of manually writing dispatch 'type' 
    
     

&nbsp;