# The Heavy Pill

You have 20 bottles of pills. 19 bottles have 1.0 gram pills, but one has pills of weight 1.1 grams. 
Given a scale that provides an exact measurement, how would you find the heavy bottle? 
You can only use the scale once.

## Solution

We need put n pill equal the bottle number to the scale. So if 9 bottle is heavy, than we receive weight:
expected + 0.9

Expected weight (if all pill equal each other): 1 + (n + 1) + ... 20 -> (a1 + aN)/2 * n -> (1 + 20)/2 * 20 -> 210 
