# A* Pathfinding Algorithm

This is an implementation of the A* pathfinding algorithm created by Danielle Bottiger, Viktor Chekhovoi, Zack Johnson, and Micael Worrell. It was part of our CS 252 Algorithms Final at Carleton College. 

## Getting Started

Once you've unzipped the file with the java programs, you'll want to run Master.java.  
Please note that (0,0) is the top left hand corner and (x-size, y-size) is the bottom right.  
You'll need a text file as an input and it should be formated like this:


```
(Starting-x-cord, Starting-y-cord)  
(Target-x-cord, Target-y-cord)  
  
x-size y-size  
  
** Insert Graph here, where 0s are walls and any other number between 1 and 10 is an open space where the number is the difficulty. This simulates terrain difficulty.**
```

Here is an example of what that should look like:

```
(0,0)
(3,0)
  
 4 4
  
 1 2 0 1
 1 3 0 1
 5 0 0 1
 1 1 1 1
```

The file returns the optimal path of nodes from start to target via a text line along with the cost of the path. The cost includes the starting and ending nodes.  
There are a couple of example files provided to use in case you don't want to make your own.

## How each part works  
### ReadFile  
ReadFile is responsible reading a graph with a start and target and then running A\* on it. See graph.txt for an example on how this text file with that information is formatted. It creates all nodes (and ignores walls) and creates the necessary edges between them. It also parses the start and target information so we can later in Master actually assign that to a node.
### Node  
Node is a location on our graph, it stores all the location about like its difficulty and location. We also have a spot for the parent and where the parent is in relation to keep track of our path when the A\* algorithm is actually running.
### Graph  
Graph is a class that keeps track of all our nodes. It's what determines what a node's neighbors are and assigns the neighbors, too.
### Heuristic  
Our Heuristic is a simple class that uses the Manhattan distance with 2 dimensions to estimate the best path in A\*. The dx and dy values are the difference between the nodes' locations.
### Master  
Master is our class with the main function in it. It's what actually stores the A\* algorithm. We start by calling ReadFile to create our graph and then run the A\* algorithm. We finish by tracing back our path and the directions needed to get to that path to make it easier for the user.

