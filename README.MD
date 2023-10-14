#General Description
Implement your task and push to the public git repository. Share the link with the mentor. Create a simple java class that will read data from the console and will print results to console.

#Task 5 (Calculator, Math Challenge)
Have the function MathChallenge(str) take the str parameter being passed and evaluate the mathematical expression within it. 
For example, if str were **"2+(3-1)*3"** the output should be **8**. 
Another example: if str were **"(2-0)(6/2)" ** the output should be **6**.
There can be parenthesis within the string, so you must evaluate it properly according to the rules of arithmetic. The string will contain the operators: **+, -, /, *, (,** and **)**.
If you have a string like this: **#/#*#** or **#+#(#)/#**, then evaluate from left to right. 
So divide then multiply, and for the second one multiply, divide, then add.
The evaluations will be such that there will not be any decimal operations, so you do not need to account for rounding and whatnot.

**Examples**
Input: "6*(4/2)+3*1"
Output: 15

Input: "6/3-1"
Output: 1
