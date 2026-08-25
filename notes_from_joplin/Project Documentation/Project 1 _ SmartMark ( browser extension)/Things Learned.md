## using Object.assign to add CSS

* * *

```js
Object.assign(newEl.style, {
    backgroundColor: "rebeccapurple",
    position: "relative",
    bottom: "39%",
    height: "46%",
    right: "2%",
    color: "#f1f1f1",
    borderRadius: "0.5rem",
    cursor: "pointer",
  });
```

&nbsp;

## MutationObserver

* * *

- Problem :- on single page applications ( SPA) , one of the benefits of them is that they don't reload the page when content is changed , but for making extensions that is a bad thing.
- Solution :- so to to able to know when content is changing ( and do actions based on that ) we need MutationObserver , it listens for changes in URL ( say , every second )
- A `MutationObserver` lets your script **watch the DOM** and run code when changes happen. { see code for implementation ( in version 1.0) }

&nbsp;

## How to Retrieve content from Youtube Video

* * *

- the most common method is to just rest the `textContent` from the element
- the other is to use the API from Youtube to get details ( complex to implement )

&nbsp;

## how to store and send data to frontend ( popup.html )

* * *

- The most common and reliable way is to store the data at `chrome.storage` and then both `contentScript` and `popup` have access to the data. one of the downsides that it has max limit of 5mb per extension
- **Use `chrome.runtime.sendMessage`** (For direct communication)
- the third way is to use `indexedDB ` 
- also can use mongodb atlas ( make backend ) to implement cloud sync
- or use firebase , supabase  for easier approach ( not need to make your own backend )

&nbsp;

## Designing the layout of the extension ( popup.html , popup.js )

* * *

- i decided to go with design that go into my mind ( better for small projects like mine )<img src="../../../_resources/ff2286ae80dcf49950c26286b06f5058.png" alt="ff2286ae80dcf49950c26286b06f5058.png" width="276" height="383" class="jop-noMdConv">
- also i rendered multiple card object by using array for objects , then loop over them

&nbsp;

Converting Time String into Seconds 

* * *

```js
// Function to getVideoTime in Seconds
function getTimeInSeconds(string) {
  let parts = string.split(":");

  let timeInSec = 0;

  if (parts.length == 2) {
    // Format : minutes:seconds
    timeInSec = parseInt(parts[0] * 60 + parseInt(parts[1]));
  } else if (parts.length == 3) {
    // Format : hours:minutes:seconds
    timeInSec = parseInt(
      parts[0] * 3600 + parseInt(parts[1] * 60) + parseInt(parts[2])
    );
  }

  return timeInSec;
}
```

- to utilize this Function , i passed the TimeString  as a data set in the html div element itself 
    
    ```js
     cardElement.dataset.time = currentTimeInSeconds; // Store current time in seconds
    ```
    
- then i used in the place were i need it ( inside the event listener ) 
    
    ```js
      const time = card.dataset.time; // Get the time in seconds from the dataset
    ```