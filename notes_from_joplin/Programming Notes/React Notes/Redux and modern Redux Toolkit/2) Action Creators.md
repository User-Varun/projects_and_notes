- this is not a redux feature and redux will work fine without, it's convention developer use when working with redux

```js
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

/* The Old Way */

// store.dispatch({ type: "account/deposit", payload: 500 });
// store.dispatch({ type: "account/withdraw", payload: 200 });

// console.log(store.getState());

// store.dispatch({
//   type: "account/requestLoan",
//   payload: { amount: 1000, purpose: "Buy a Car" },
// });

// store.dispatch({ type: "account/payLoan" });

/* With Action Creators */
function deposit(amount) {
  return { type: "account/deposit", payload: amount };
}

// function withdraw(){}
// function requestLoan(){}
// function payLoan(){}

store.dispatch(deposit(500));
console.log(store.getState());

```

- there is also convention on putting the type string into it's own variable and use in inside action creator + reducer

&nbsp;