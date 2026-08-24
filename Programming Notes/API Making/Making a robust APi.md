follow The REST API archetecture :- see the theory slides page.  
<br/>small titbits to follow when making api :-  
1\. always include version of api (api/v1/tours) so u can make changes simply by making v2 of your api  
2\. we can use readFileSync outside of any async or loop  
3\. use the jSend approach to send response of api  
4\. include 'results' field in your api response that shows no. of results as response.  
<br/>5\. usage of middlewares in express.js  
6\. use express router to route your requests chain multiple requests on single route ( see the natours project )  
<br/>4\. see the code for how get , post , patch , put , delete method in natours project if needs  
<br/>5\. object.assign() allows to create new object by merging two existing objects.  
<br/>6\. status code '200' for ok and '201' for resource created.  
<br/>7\. we can chain get or post or any other method using 'app.route' ( see natours code )  
<br/>