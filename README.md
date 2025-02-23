# CSC 207: Text Editor

**Author**: _(TODO: fill me in)_

## Resources Used

+ _(TODO: fill me in)_
+ ...
+ ...

## Analysis of SimpleStringBuffer
#insert method
- The relevant input to the insert method is n where n is the size of the string 
that is implicitly copied within any of the string manipulation methods. 
Because, each substing and concatenation is a copy,
they would each be treated as a their own critical operation. THERE ARE 3 OF THESE CRITICAL OPERATIONS

If we assume that every copy operation is a linear function with a function in the order of n,
then the mathematical model of the runtime is 3n

insert is O(n)


## Changelog

_(TODO: fill me in with a log of your committed changes)_
