# Basketball

You have a basketball hoop and someone says that you can play one of two games.
Game 1: You get one shot to make the hoop.
Game 2: You get three shots and you have to make two of three shots.
If p is the probability of making a particular shot, for which values of p should you pick one game or the other?

## Solution

P(game 1) = p
P(game 2) = P(2, 3) + P(3, 3)
P(3,3) = p^3
P(2,3) = P(making 1 and 2, missing 3) + P(making 1 and 3, missing 2) + P(making 2 and 3, missing 1) = 
= p * p * (1 - p) + p * (1 - p) * p + (1 - p) * p * p = 3*(1 - p) * p^2

P(game 2) = p^3 + 3 * (1 - p) * p^2 = p^3 + 3 * p^2 - 3 * p^3 = 3 * p^2 - 2 * p^3

When we should select game 1:

P(game 1) > P(game 2)
p > 3 * p^2 - 2 * p^3
1 > 3p - 2 * p^2
2 * p^2 - 3p + 1 > 0
(2p - 1)*(p - 1) > 0

p - 1 < 0 - because probability is always < 1

So when p > 0.5 we should select game 2, otherwise game 1