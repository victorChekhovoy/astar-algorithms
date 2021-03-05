# A* Pathfinding Algorithm

This is an implementation of the A* pathfinding algorithm created by Danielle Bottiger, Viktor Chekhovoi, Zack Johnson, and Micael Worrell. It was part of our CS 252 Algorithms Final at Carleton College. 

## Getting Started

Once you've unzipped the file with the java programs, you'll want to run Master.java. You'll need a text file as an input and it should be formated like this:

```
(Starting-x-cord, Starting-y-cord)  
(Target-x-cord, Target-y-cord)  
  
x-size y-size  
  
** Insert Graph here, where 0s are open spaces, and 1s are walls **
```

Here is an example of what that should look like:

```
(0,0)
(3,0)
  
 4 4
  
 0 0 1 0
 0 0 1 0
 0 1 1 0
 0 0 0 0
```

The file returns the optimal path of nodes from start to target via a text line.

## Acknowledgments

* Layla Oesper, our professor who assisted us with this project.

