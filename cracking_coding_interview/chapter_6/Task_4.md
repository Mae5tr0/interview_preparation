# Ants on a Triangle

There are three ants on different vertices of a triangle. What is the probability of collision 
(between any two or all of them) if they start walking on the sides of the triangle? 
Assume that each ant randomly picks a direction, with either direction being equally likely to be chosen, 
and that they walk at the same speed.

## Solution

Ants will not collide only if will go on the same direction. Probability for it:
P(clockwise): p^3
P(counter clockwise): p^3 
P(same direction): 2(p^3), where p = 1/2

P(collision) = 1 - P(same direction) = 1 - 2(1/2)^3 = 0.75

For n-vertex polygon everything almost the same expect n:
P(clockwise): p^n
P(counter clockwise): p^n 
P(same direction): 2(p^n), where p = 1/2

P(collision) = 1 - P(same direction) = 1 - 2(1/2)^n = 1 - (1/2)^(n-1)
