(see the codebase of naturous backend to see how we implement this in code)  
1\. how to handle operational error and error cause by something else  
2\. how to debug node.js code using ndb package  
3\. how to setup global error handling  
4\. how to catch async error (better way)  
5\. differenciate error between production and development  
6\. handling mongoose or mongodb errors (making them operational)  
<br/>// learn how to effectively get data from objects , it's done using the object.values(obj).map(el => el.propertyUNeed)  
<br/>// handling unhandled rejection ( like mongodb sever crash error , etc) using the 'process.on("unhandled rejection" , err => { process.exit(1} ); also using .catch() to circulate the error to our global error handling middleware  
<br/>// handling uncaught exception is implemented as same as unhandled rejection , difference is that the uncaught expection the app needs to be shut down coz during that app remains in "unclean state". 'process.on("unhandled exeception" , err => { process.exit(1} );