- we use Sate slices
- means we create folder called **features** inside **src** folder and then inside we create one folder for each feature in our app for example in the bank we have **accounts** & **customers**
- in each folder of features we also put all files related to that feature ( say createCustomer.jsx for customer feature )

![68ece30d85cd64c7334218c052098285.png](../../../../_resources/68ece30d85cd64c7334218c052098285.png)

- we also create "state **Slices**" all the state related to that feature will be there ( ex. customerSlice , accountSlice)
- in slices files (say accountSlice.js )
    - the initial state
    - reducers,
    - action creator stored
- To get this slices into the src/store.js ( our main store )
    - reducers == default export ( export default )
    - action creators == named export ( export)
- export default the store.js file then use the in our application 

```js
import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import App from "./App";

import store from "./store";

store.dispatch({ type: "account/deposit", payload: { balance: 500 } });

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);

```

&nbsp;