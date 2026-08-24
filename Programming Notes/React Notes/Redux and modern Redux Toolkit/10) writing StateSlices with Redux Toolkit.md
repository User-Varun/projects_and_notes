- the idea of state slices ( account slice , customer slice  => each have their reducers + action creators ) is now baked into modern redux
- use `import {createSlice } from '@reduxjs/toolkit' ` 
- using createSlice gives us 3 benefits :-
    - automatic actionCreators by our useReducer
    - writing reducer fn now easy, no need of switch statement , and default case are already there
    - we can now mutate our state in reducers (they are converted behind the scenes by using immar library to immutable logic {like how they are originally} )
- Redux Toolkit way to create State slice 

```js
import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  balance: 0,
  loan: 0,
  loanPurpose: "",
  isLoading: false,
};

const AccountSlice = createSlice({
  name: "account",
  initialState,
  reducers: {
    deposit(state, action) {
      state.balance += action.payload;
    },
    withdraw(state, action) {
      state.balance -= action.payload;
    },
    requestLoan: {
      // if we need to pass multiple value into payload ( have to use this jugad)
      prepare(amount, purpose) {
        return {
          payload: { amount, purpose },
        };
      },

      reducer(state, action) {
        if (state.loan > 0) return; // we don't return the object in redux toolkit

        state.loan = action.payload.amount;
        state.loanPurpose = action.payload.purpose;
        state.balance += action.payload.amount;
      },
    },
    payLoan(state) {
      state.balance -= state.loan;
      state.loan = 0;
      state.loanPurpose = "";
    },
  },
});

export const { deposit, withdraw, requestLoan, payLoan } = AccountSlice.actions;

export default AccountSlice.reducer;

```

- use whichever style u like redux classic one or the new  redux-Toolkit using createSlice
- in order to use Thunk in redux toolkit way we can use `createAsyncThunk` fn ( but that's a lot of work) but it will be covered in later chapter, now using our action creator and the middleware way using thunk )