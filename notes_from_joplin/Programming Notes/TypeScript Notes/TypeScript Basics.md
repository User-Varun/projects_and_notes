&nbsp;

`"use strict";`

`// Basic Types`

`let id = 5;`

`let company = "Traversy Media";`

`let isPublished = true;`

`let x = "Hello"; // can be of any type and type can change later without error`

`// Array (can be of a specific type)`

`let ids = [1, 2, 3, 4, 5];`

`// ids.push("hello"); // This will cause an error because ids is defined as a number array`

`let arr = [1, true, "hello", { id: 1 }];`

`// Tuple (which is a fixed-length array with specific types)`

`let person = [1, "Brad", true];`

`// Array of Tuples`

`let employee = [`

`[1, "Brad"],`

`[2, "John"],`

`[3, "Jill"],`

`];`

`// Union Types ( one variable can have several types)`

`let pid;`

`pid = "22"; // This is valid because pid can be either a number or a string`

`pid = 22; // This is also valid`

`// Enum (a way to define a set(well defined collection of values) of named constants)`

`// Enums are useful when you have a set of related constants that you want to group together`

`// They can be numeric or string-based`

`// By default, enums are numeric and start from 0, but you can set the starting value or use string values`

`var Direction;`

`(function (Direction) {`

`Direction[Direction["Up"] = 1] = "Up";`

`Direction[Direction["Down"] = 2] = "Down";`

`Direction[Direction["Left"] = 3] = "Left";`

`Direction[Direction["Right"] = 4] = "Right";`

`})(Direction || (Direction = {}));`

`const user = {`

`id: 1,`

`name: "John",`

`};`

`// user.id = "2"; // This will cause an error because id is defined as a number`

`// Type Assertion (a way to tell the compiler to treat a variable as a specific type)`

`let cid = 1;`

`let customerId = cid; // Using angle-bracket syntax`

`let customerId2 = cid; // Using 'as' syntax`

`// Functions`

`function addNum(x, y) {`

`// this is the return type of the function`

`return x + y;`

`}`

`// return type void`

`function log(message) {`

`console.log(message);`

`}`

`const userIn = {`

`id: 1,`

`name: "John",`

`};`

`const add = (x, y) => x + y;`

`const sub = (x, y) => x - y;`

`// Classes`

`class Person {`

`// private id: number; // private properties can only be accessed within the class`

`// protected name: string; // protected properties can be accessed within the class and by subclasses (extended classees)`

`constructor(id, name) {`

`this.id = id;`

`this.name = name;`

`}`

`// Methods`

`register() {`

``return `${this.name} is now registered`;``

`}`

`}`

`const varun = new Person(1, "Varun");`

`console.log(varun.register());`

`// Extending a Class`

`// this is a subClass`

`class Employee extends Person {`

`constructor(id, name, position) {`

`super(id, name); // taking the value from the parent class`

`this.position = position;`

`}`

`}`

`const emp = new Employee(3, "Shawn", "Developer");`

`console.log(emp.name);`

`console.log(emp.register());`

`//  Generics  (a way to create reusable components that can work with any data type)`

`// the <T> syntax is used to define a generic type parameter(like a placeholder) that can be replaced with any type when the function is called`

`function getArray(items) {`

`return new Array().concat(items);`

`}`

`// Example usage of the generic function (type can be number , string or any other type)`

`let numArray = getArray([1, 2, 3, 4]);`

`let strArray = getArray(["Brad", "John", "Jill"]);`

`// numArray.push("hello"); // This will cause an error because numArray is defined as a number array`