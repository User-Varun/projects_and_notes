- A store has multiple reducers, the way we create them is how.

```js
import { combineReducers, createStore } from "redux";     

function AccountReducer(state = initialStateAccount, action) {
  switch (action.type) {
    case "account/deposit":
      return { ...state, balance: state.balance + action.payload };
    default:
      return state;
  }
}

function CustomerReducer(state = initailStateCustomer, action) {
  switch (action.type) {
    case "customer/updateName":
      return { ...state, fullName: action.payload };
    default:
      return state;
  }
}

// here's how
const rootReducer = combineReducers({
  account: AccountReducer,
  customer: CustomerReducer,
});

const store = createStore(rootReducer);

/* Output 
{account: {…}, customer: {…}}
account
: 
{balance: 500, loan: 0, loanPurpose: ''}
customer
: 
{fullName: '', nationalId: '', createdAt: ''}

*/
```