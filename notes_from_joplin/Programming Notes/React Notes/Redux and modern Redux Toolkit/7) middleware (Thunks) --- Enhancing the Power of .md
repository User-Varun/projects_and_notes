- where to fetch data if not in components (useEffect ) or in Reducers ? answer :- middleware (thunks) or react query
- Thunks is a third party package.

![46abddc1756299a7e8205ddf17ccb860.png](../../../../_resources/46abddc1756299a7e8205ddf17ccb860.png)

![15ba2dfd29a5cbd165081b4b17762337.png](../../../../_resources/15ba2dfd29a5cbd165081b4b17762337.png)

# using Thunks in 3 steps

1.  install the package `redux-thunk`
2.  import thunk middleware and set it up ( applyMiddleware)

```js
    import { applyMiddleware, combineReducers, createStore } from "redux";
    
    import { thunk } from "redux-thunk";
    
    const rootReducer = combineReducers({
      account: AccountReducer,
      customer: CustomerReducer,
    });
    
    const store = createStore(rootReducer , applyMiddleware(thunk)); // we have plug the middleware
    
```

3\. use it.

```js
export function deposit(amount, currency) {
  if (currency === "USD") return { type: "account/deposit", payload: amount };

  // when the action creator sees a fn rather than a value, it treats it as middleware ( given that u are using Thunks, and have set it up correctly )
  return async function (dispatch) { // also have access to dispatch , getState method in this fn
    dispatch({ type: "account/convertingCurrency", payload: true });
    
    // and we can do our all side effect stuff here 
    const res = await fetch(
      `https://api.frankfurter.dev/v1/latest?base=${currency}&symbols=USD`
    )
      .then((res) => res.json())
      .catch((err) => console.error(err));

    const convertedCur = Number((res.rates.USD * amount).toFixed(2));
    console.log(convertedCur);

    dispatch({ type: "account/deposit", payload: convertedCur });
  };
}
```