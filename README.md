# A* Pathfinding Algorithm

This is an implementation of the A* pathfinding algorithm created by Danielle Bottiger, Viktor Chekhovoi, Zack Johnson, and Micael Worrell. It was part of our CS 252 Algorithms Final at Carleton College. 

## Getting Started

Once you've unzipped the file with the java programs, you'll want to run Master.java. You'll need a text file as an input and it should be formated like this:
Please note that (0,0) is the top left hand corner. So (x-size, y-size) is the bottom right.

```
(Starting-x-cord, Starting-y-cord)  
(Target-x-cord, Target-y-cord)  
  
x-size y-size  
  
** Insert Graph here, where 0s are walls and any other number between 1 and 10 is an open space where the number is the diffuclty. This simulates terrain difficulty.**
```

Here is an example of what that should look like:

```
(0,0)
(3,0)
  
 4 4
  
 1 2 0 1
 1 3 0 1
 1 0 0 1
 1 1 1 1
```

The file returns the optimal path of nodes from start to target via a text line.

## Acknowledgments

* Layla Oesper, our professor who assisted us with this project.

