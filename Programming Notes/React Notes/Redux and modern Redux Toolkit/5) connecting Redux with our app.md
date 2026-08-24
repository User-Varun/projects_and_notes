- Install the `react-redux` library
- Wrap the app component in &lt;Provider /&gt; from `react-redux`
- provide the store prop in there and now our whole app has access to the store. 
- it's quite genius tho, using useContext + a useReducer on steroids

```js
   import { Provider } from "react-redux";
   
   import store from "./store";
   
   const root = ReactDOM.createRoot(document.getElementById("root"));
   root.render(
     <React.StrictMode>
       <Provider store={store}>
         <App />
       </Provider>
     </React.StrictMode>
   );
   
   ```
```

- now to use, in component use `useSelector` to get data from store, it accepts a callback fn