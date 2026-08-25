# 3 steps to implement Data loading (render as u fetch approach)

1.  create the loader fn ( convention is , create the loader fn (that will fetch data ) into the components it's fetching data for ex. menuComponent => menuLoader )
2.  we provide the data to the loader 
3.  we use the data in the component

```js
// the place where u have createBrowserRouter 

// Step - 2
import Menu, { loader as menuLoader } from './features/menu/Menu';

const router = createBrowserRouter([
  {
   
    element: <AppLayout />,
     // this way we can provide component that will be rendered on error, and react router will take care of loading.
    errorElement: <Error />,

    children: [
      {
        path: '/',
        element: <Home />,
      },
      {
        path: '/menu',
        element: <Menu />,
        loader: menuLoader,
        errorElement: <Error />,
      },
      ]
      }



// the  menu Component
function Menu() {
  // here when the menu url path hit, userLoaderData() get the data after it's ready
  
  // (step - 3)
  const menu = useLoaderData();

  return (
    <ul className="divide-y divide-stone-200 px-2">
      {menu.map((pizza) => (
        <MenuItem pizza={pizza} key={pizza.id} />
      ))}
    </ul>
  );
}

// the loader fn ( Step - 1)
export async function loader() {
  const menu = await getMenu();
  return menu;
}

export default Menu;
```