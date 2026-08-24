// creating student table  
create table student(sid int(5) , sname varchar(50), sadd varchar(50) , mob int(10) , branch varchar(50) , unm varchar(40) , pw varchar(40) , status int(2), PRIMARY KEY (sid));  
<br/>// creating employee table  
create table emp(eid int(5) , ename varchar(50), loc varchar(50) , post varchar(10) , sal int(50) , jdate varchar(40) , mob int(10) , status int(2), PRIMARY KEY (eid));  
<br/>// inserting into student table  
INSERT INTO \`student\`(\`sid\`, \`sname\`, \`sadd\`, \`mob\`, \`branch\`, \`unm\`, \`pw\`, \`status\`) VALUES (  
insert into student values(101, 'jay','indore',9373863,'CA','jay' , '12345' ,0),  
insert into student values(102, 'varun','indore',9373863,'CA','varun' , '12345' ,0),  
insert into student values(103, 'pari','indore',9373863,'CA','pari' , '12345' ,0),  
insert into student values(104, 'riya','indore',9373863,'CA','riya' , '12345' ,0),  
insert into student values(105, 'neeraj','indore',9373863,'CA','neeraj' , '12345' ,0),  
insert into student values(106, 'vansh','indore',9373863,'CA','vansh' , '12345' ,0),  
insert into student values(107, 'mani','indore',9373863,'CA','mani' , '12345' ,0),  
insert into student values(108, 'sakshi','indore',9373863,'CA','sakshi' , '12345' ,0),  
insert into student values(109, 'saransh','indore',9373863,'CA','saransh' , '12345' ,0),  
insert into student values(110, 'sahil','indore',9373863,'CA','sahil' , '12345' , 0)  
<br/>);  
<br/><br/>// updating values in table  
update student set branch='CS' , mob=939393 where sid=102;  
<br/><br/><br/>// inserting into employee table  
INSERT INTO emp(eid, ename, loc, post, sal, jdate, mob, status) VALUES  
(201, 'Amit', 'Indore', 'manager', 55000, '05-05-2025', 9876543210, 0),  
(202, 'Priya', 'Bhopal', 'developer', 40000, '05-05-2025', 9123456780, 0),  
(203, 'Rohit', 'Delhi', 'developer', 30000, '05-05-2025', 9988776655, 0),  
(204, 'Sneha', 'Mumbai', 'tester', 45000, '05-05-2025', 9812345678, 1),  
(205, 'Karan', 'Pune', 'sales', 50000, '05-05-2025', 9876123456, 1),  
(206, 'Neha', 'Jaipur', 'sales', 25000, '05-05-2025', 9765432101, 0),  
(207, 'Suresh', 'Chennai', 'developer', 35000, '05-05-2025', 9123456799, 0),  
(208, 'Meera', 'Hyderabad', 'developer', 47000, '05-05-2025', 9898989898, 0),  
(209, 'Arjun', 'Kolkata', 'manager', 60000, '05-05-2025', 9001122334, 0),  
(210, 'Pooja', 'Ahmedabad', 'developer', 52000, '05-05-2025', 9345678901, 0);  
<br/><br/><br/>// update in emp , manager = head_manager , sales = salesman);  
update emp set post='head_manager' where post='manager';  
update emp set post='"sales_man" where post='sales' ;  
<br/><br/>// update empolyee  
update emp set sal=sal+(sal \* 0.07) where post='salesman' AND sal&lt;50000 AND sales&gt;200000 AND sdate>='1-apr-2024' AND sdate<='31-mar-2025'  
<br/>// update employee  
update emp set sal=sal+(sal\*0.10) where jdate>='1-jan-2016' AND jdate<='31-dec-2016' AND post='manager'  
<br/><br/>// updating employ salary by 7% when salary below 1lakh of developers  
update emp set sal=sal+(sal\*0.07) where post='developer' AND sal <100000;  
<br/><br/>// Select Queries  
select \* from student;  
select sname, mob from student;  
select sname,mob , branch from student where status=0;  
select sname , mob from student where branch='cs' AND feesDepo<20000;  
<br/><br/>// delete query  
delete from student where sid=101;  
<br/>