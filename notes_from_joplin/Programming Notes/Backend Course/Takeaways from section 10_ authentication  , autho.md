- creating schema for users (see the natours userModel.js)
- we can create different router paths for unique resources like signup and login , which doesn't follow the rest architecture , but they are totally valid
- attaching validator on password_conform to match it with password
- using bcrypt to encrypt the password and set password_conform to undefined. (USERMODEL.JS)
- using object.create to only make new user with properties that we have decided , this helps so no user can create their user with extra properties , like making themselves admin (wish is serious flaw)
- use at least 32 character long string for JWT secret and store it in config.env

&nbsp;

## format of jwt sign object :-

```js
const token = jwt.sign({ id: newUser._id }, process.env.JWT_SECRET, {
expiresIn: process.env.JWT_EXPIRES_IN,
});
```

&nbsp;

## for loging in users :-

1.  CHECK IF EMAIL AND PASSWORD EXIST  
    <br/>// 2) CHECK IF USER EXISTS AND PASSWORD IS CORRECT  
    2.1 after checking the user's email in db  
    2.2 use dcrypt to compare the password that is in db with the password user provided ( look at userModel.js)  
    <br/>// 3) IF EVERYTHING OK , SEND TOKEN TO CLIENT  
    the route we create for login :-  
    router.post('/login', authController.login);  
    // hide the users password in userModel.js by using select : false  
    <br/>// there is a patern for setting up jwt in headers , by creating a property authorization and bearer and then token  
    <br/>// to protect a route , we use the middleware fn before the route fn. wich chekcs ofr these things :-  
    <br/>// 1) GETTING THE TOKEN AND CHECK IF IT'S THERE  
    <br/>// 2) VERIFICATION TOKEN  
    const decoded = await promisify(jwt.verify)(token, process.env.JWT_SECRET);  
    <br/>// 2.1 we delegate the error to global error handling middleware ( adding another fn to that errorController.js)  
    <br/>// 3) CHECK IF USER STILL EXISTS  
    <br/>// 4) CHECK IF USER CHANGED PASSWORD AFTER TOKEN FOR ISSUED  
    <br/>// 5) if everthing is right , the next middleware is called.  
    <br/><br/>// check advanced postman featues  
    <br/>// skipped 3 lectures for now ( lack of time , will watch later)  
    <br/>// authrization : user roles and permission ( only permitted role can delete tour)  
    <br/>// updateMyPassword feature ( updating the current user : password)  
    <br/>// updateMe feature ( updating username , email or anyOther )  
    <br/>// skipped 1 lectures for now ( lack of time , will watch later)  
    <br/>// security best practices  
    <br/>// sending JWT via a cookie for frontend

&nbsp;

## Password Resetting functionality : reset token

- Study function 1.forgotPassword inside authController.js also refer to lecture 135. Password Reset Functionality: Reset Token (on Udemy )

## Sending Emails via Nodemailer

- Study function 1.forgotPassword  2.resetPassword  inside authController.js also refer to lecture 136. Sending Emails via Nodemailer (on Udemy )
- email messaging service 1.sendGrid , 2.mailgun
- use Gmail for production app is not recommended  only get 500 mails a day ( and get send into spam)
- for now using MailTrap service : to see our email in dev environment by send it to real addresses ( and faking it to trap in our dev env ) :- https://mailtrap.io
- study lecture 135 , 136 , 137 to revise the forget and reset password process through email messaging
- find solution of a bug :- using the port 25 for the mailtrap service was not working, switching to port 500 and something.. did the trick.

&nbsp;

## 👉when to use Update and when use save in mongodb

- using update to create save update , have two major negatives , 1. it does not run validators , 2.it also does not run middleware fn ( your own made too in models )
- using save method does all this to request (run middleware , validators ) , if your some reason you wish to stop the validators use `{validateBeforeSave = false }`

👉check security best practices lecture 141

👉 **rate limiting** :- lec142 , ( implemented using express-rate-limit package , and as a global middleware in express , inside app.js )

- also learning securing headers ( by helmet package , making middleware ) (helmet)
- data sanitization , xss atack (xss-clean)
- parameter pollution hpp(http parameter polution) package

&nbsp;

👉 Data modeling introduction