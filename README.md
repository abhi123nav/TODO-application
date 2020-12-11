# TODO-application
# Part one of project

# Assumptions:
TODO application has 3 columns in the database postgreSQL 
Database name : myhiberdb
Database password:12345  //dummy
Column details:-
•	1st ---id--- to unique identify a row or a activity
•	2nd—name---name of the activity
•	3rd---pname---details of the above name activity i.e prototype of name


# Approach to your solution
Approach was :
1.	A Controller class to handle all the request called –Todocontroller.java
2.	A Service class to handle the program logic called –TodoService.java
3.	A Repository interface to use database functions called- TodoRepository.java
4.	An Entity class to do the mapping of our variables and database column
5.	An application.properties file to do all configuration
Details of Controller class
In controller class we have 5 methods below is the details:

1 .  2 GET mapping functions
•	1st to read all TODO activity details
Mapping: @GetMapping("/todos")
Function name:- getTodos()
•	2nd to get details about a particular activity by passing id of activity
Mapping: @GetMapping("/todos/{id}")
Function name:- getTodos(@PathVariable("id") int id)

2 .  A POST mapping to add new activity details in the database myhiberdb
Mapping: @PostMapping("/todos")
Function name:- addtodos(@RequestBody Todo activity)

3.  A DELETE mapping to delete an activity from TODO database myhiberdb
Mapping: @DeleteMapping("/todos/{id}")
Function name:- deleteTodo(@PathVariable("id") int id)

4.  An UPDATE mapping to update an activity by providing the id number and new data that a person want to set to the activity
Mapping: @PutMapping("/todos/{id}")
Function name:- updateTodos(@RequestBody Todo todo,@PathVariable("id") int id)

# Steps to run this application :
1st  open the application using spring STS IDE.
2nd Right click on the project ->Run As->Spring Boot App

# Time Spent :- 4-5 hrs

# Work Done:- Part one of project




 
