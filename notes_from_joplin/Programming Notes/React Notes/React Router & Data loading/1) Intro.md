- We have used React Router in past ( section 17 : building single page application )
    
- Now There are 3 modes React Router comes in ( varies based on how much control u want )
    
    - Declartive mode (using components to build layout such as BrowserRouter)
        
        ```js
        import React from "react";
        import ReactDOM from "react-dom/client";
        import { BrowserRouter , Routes , Route} from "react-router";
        import App from "./app";
        
        const root = document.getElementById("root");
        
        ReactDOM.createRoot(root).render(
          <BrowserRouter>
            <Routes>
              <Route path="/" element={<App />} />
            </Routes>
          </BrowserRouter>,
        );
        ```
        
    - Data Mode (using the createBrowserRouter )
        
        ```js
        import React from "react";
        import ReactDOM from "react-dom/client";
        import { createBrowserRouter } from "react-router";
        import { RouterProvider } from "react-router/dom";
        
        const router = createBrowserRouter([
          {
            path: "/",
            element: <div>Hello World</div>,
          },
        ]);
        
        const root = document.getElementById("root");
        
        ReactDOM.createRoot(root).render(
          <RouterProvider router={router} />,
        );
        
        ```
        
- **Will use the Data mode for React router from now**