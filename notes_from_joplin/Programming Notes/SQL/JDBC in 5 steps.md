1.  Open the Driver  
    \- Class.forName("Driver String");  
    \- SQL :- com.mysql.cj.jdbc.Driver
2.   Create Connection  
    \- Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DatabaseName" , "username" , "password");
3.   Query ( 2 methods available )  
    \- Statement :- for static query ( data is 100% known )  
    \- PreparedStatement :- dynamic Query ( data is not known , will known at runtime )  
    \- Callable Statement :- PL-SQL
4.   get Result  
    \- ResultSet
5.  Close all connection