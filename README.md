# JavaPractice
1. Write regexp matching strings having only letters a, but only of length which is composite number.
(example: aa -> True, aaaa -> False (not composite), aab -> False (not only a's))
2. BFS algorithm: what is memory complexity of BFS? I mean, what is the maximum size of queue during execution for graph of n vertices and m edges. Why?
3. Find smallest positive decimal number containing only digits 0 and 1 which is divisible by N.
(example: 7 -> 1001)
4. You have sequence A containing N numbers. Sequence B is obtained by taking multiplies of any pair of numbers from A (so you get exactly N^2 pairs [we count (A*B and B*A as different pair]). Find K-th smallest number in sequence B.
5. Implement queue using two stacks.
6. Find in linear time if array of length N containing integers from range [1; N] has duplicate using constant additional memory (not counting input array - you can write on it).
7. You have string containing only letters A and B. Find longest substring where A occurs twice as much as B.
(example of good substring: ABAABA)
8. Is it possible to create data structure providing operations Insert(x), Erase(x), FindMin() where each operation is o(log n)? Why not or how to do that? Note that x can be real number and assume you can compare in constant time.
9. You are given sequence of parentheses S and bunch of queries in form: Is S[i..j] correct?
(example: S = ()(()))(, query: (i = 3, j = 6)  => substring = (())  => answer Yes)
Provide an algorithm which can answer many queries (thousands) for large sequence (thousands of characters).
10. Binary search. You have N cells of sorted array. You want to find value x. However cost of reading value T[i] is i. Provide algorithm which is optimal in worst case.
(if there is way to always find x using queries of cost at most p in any case and your algorithm has greater cost - it is wrong)
11. (very interesting) You have K similar eggs and you want to determine their durability. Each egg has the same durability p (which you have to find). If egg is dropped from height <= p it will not break down, if it is dropped from height > p it will. You know that p is integer number and it is <= N.
Find algorithm which determines p using smallest number of drops (in worst case) if:
(a) N = 100, K = 10 (very easy)
(b) N = 100, K = 1 (very easy)
(c) N = 100, K = 2 (challenging)
(d) N = 1000, K = 5 (very challenging)
(e) N = 10^9, K = 15 (more than hard)
What is good about this problem: all of these five points (a) - (e) have different solutions.

PUZZLE: 
There is a Kingdom, a King, and a Queen. 
An carnival is scheduled after 35 days in the Kingdom. 
The King orders 1000 bottles of wine for the carnival . 
The Queen wants to kill the King.
Queen sends an assassin to mix poison in ONE of the 1000 bottles.
The effect of the poison is such that the person who took it, will die after 30 days.
Somehow the King happened to know about the conspiracy, and want to know about the poisonous bottle.
The King has 10 prisoners on whom he can use the wine to test, whether its poisonous.
How the King is going to find out the poisonous bottle within 35 days.
ALGO:
Find the intersection of two Linked List with lowest possible complexity(both time and space).????
Solution:
-----------
Option 1:
Label all 1000 bottles using 3 digits (000, 001, 002, 003, ... 997, 998, 999).
Now convert the labels into Binary. You will need 10 bits to do so.

Now number the 10 prisoners from 1 to 10.

Now have each of the 10 prisoners drink from a bottle if and only if the bit on that bottle which corresponds to the prisoner number is equal to 1.

Then just see which of the 10 prisoners die on day 31 and turn that into a binary number (prisoner dead --> 1, prisoner alive --> 0).  The binary number you get is the poisoned bottle.




Option 2:

Label all 1000 bottles using 3 digits (000, 001, 002, 003, ... 997, 998, 999)  Call these digits x, y, z  (x is the hundreds, y is the tens, and z is the ones).

example:
bottle(657).label.x would return 6
bottle(657).label.z would return 7
bottle(035).label.x would return 0
etc


Day 1:
For i = 0 to 9
   Prisoner(i).drinksfrom(all bottles where bottle.label.x == i)
Next i

Day 2:
For i = 0 to 9
   Prisoner(i).drinksfrom(all bottles where bottle.label.y == i)
Next i

Day 3:
For i = 0 to 9
   Prisoner(i).drinksfrom(all bottles where bottle.label.z == i)
Next i

Day 4:
For i = 0 to 9
   Prisoner(i).drinksfrom(all bottles where bottle.label.z == (i+1 % 10))
Next i

Day 5:
For i = 0 to 9
   Prisoner(i).drinksfrom(all bottles where bottle.label.z == (i+2 % 10))
Next i


After 30 days one prison dies and this tells us the x label of the poisoned bottle.

After 31 days, a second prisoner dies and this tells us the y label of the poisoned bottle. (note, if no one dies in day 31, then x == y)

After 32 days, a third prisoner dies and this tells us the z label of the poisoned bottle. (note, if no one dies in day 31 or day 32, then x == y == z)

Only remaining problem is if  x != y and no one dies on day 33 so either z == x OR z == y. For this special case we have the final 2 days where the final prisoner must die and will tell us the value of z+1 or z+2 and from there we get the value of z

