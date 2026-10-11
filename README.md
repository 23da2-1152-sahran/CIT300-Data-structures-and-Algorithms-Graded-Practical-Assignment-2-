# Data Structure & Graph Performance Analyzer

**Module:** CIT300 Data Structures and Algorithms
**Assignment:** Graded Practical Assignment 2 (Week 12)
**Institution:** Sri Lanka Technology Campus (SLTC)
**Repository:** https://github.com/23da2-1152-sahran/CIT300-Data-structures-and-Algorithms-Graded-Practical-Assignment-2-

## Project Description
A Java console-based application that demonstrates the practical use of data structures,
algorithms, searching, graph traversal and algorithmic complexity. The user works with an
array, stack, queue, linked list, searching algorithms and a graph through menus, and the
system compares algorithm performance using the number of steps and execution time.

## Team Members

| No. | Student Name | Student ID | Assigned Responsibility |
|---|---|---|---|
| 1 | BM. Sahran (Team Leader) | 23DA2-1152 | Main menu, system integration, performance comparison, Linked List, repository management |
| 2 | M.L.F. Nufaisa | 23DA2-1115 | Graph component (vertex, edge, display, BFS, DFS) |
| 3 | J. Abinaya | 23DA2-0901 | Array operations and Searching (linear and binary) |
| 4 | IF. Asmija Banu | 23DA2-0636 | Stack and Queue |

## Individual Contributions

### 1. BM. Sahran (Team Leader)
- **Student ID:** 23DA2-1152
- **Assigned Responsibility:** Main menu, integration, performance comparison, Linked List
- **Individual Contribution:**
  - Implemented `Main.java` (main menu, all submenus, input validation, Display All Results)
  - Implemented `PerformanceAnalyzer.java` (Linear vs Binary search and BFS vs DFS steps/time comparison)
  - Implemented `MyLinkedList.java` (insert at beginning/end, delete, search, display)
  - Integrated all modules into one application and tested the complete system
  - Created and managed the GitHub repository, reviewed and merged pull requests

### 2. M.L.F. Nufaisa
- **Student ID:** 23DA2-1115
- **Assigned Responsibility:** Graph component
- **Individual Contribution:**
  - Implemented `Graph.java` using an adjacency list
  - Implemented add vertex, add edge and display graph
  - Implemented BFS (using a queue) and DFS (using a stack) with step counting and timing
  - Tested the graph module and integrated it with the main application

### 3. J. Abinaya
- **Student ID:** 23DA2-0901
- **Assigned Responsibility:** Array and Searching
- **Individual Contribution:**
  - Implemented `ArrayOps.java` (insert, insert at index, delete, search, display)
  - Implemented `SearchOps.java` (linear search and binary search with steps and time)
  - Tested both modules and integrated them with the main application

### 4. IF. Asmija Banu
- **Student ID:** 23DA2-0636
- **Assigned Responsibility:** Stack and Queue
- **Individual Contribution:**
  - Implemented `MyStack.java` (push, pop, peek, display, overflow/underflow handling)
  - Implemented `MyQueue.java` (enqueue, dequeue, front, display, empty-queue handling)
  - Tested both modules and integrated them with the main application

## Technologies Used
- Java (JDK 11 or later), console application
- Git and GitHub (branches, commits, pull requests, issues)

## Main System Features
- **Array:** insert, insert at index, delete by value, linear search, display
- **Stack:** push, pop, peek, display (overflow and underflow handled)
- **Queue:** enqueue, dequeue, front, display (empty queue handled)
- **Linked List:** insert at beginning/end, delete, search, display
- **Searching:** linear search and binary search with step count and time
- **Graph:** adjacency list, add vertex, add edge, display, BFS, DFS
- **Performance Comparison:** steps and execution time table
- **Display All Results** and validated input on every menu

## Project Structure
```
src/
├── Main.java                  Main menu and integration
├── ArrayOps.java              Array operations
├── MyStack.java               Stack
├── MyQueue.java               Queue
├── MyLinkedList.java          Linked list
├── SearchOps.java             Linear and binary search
├── Graph.java                 Graph, BFS, DFS
└── PerformanceAnalyzer.java   Performance comparison
```

## How to Run
1. Install JDK 11 or later (check with `javac -version`).
2. Clone the repository and open the `src` folder:
```
git clone https://github.com/23da2-1152-sahran/CIT300-Data-structures-and-Algorithms-Graded-Practical-Assignment-2-.git
cd CIT300-Data-structures-and-Algorithms-Graded-Practical-Assignment-2-/src
```
3. Compile and run:
```
javac *.java
java Main
```

## Complexity Summary

| Operation | Complexity |
|---|---|
| Array insert at end / insert at index / delete | O(1) / O(n) / O(n) |
| Stack push, pop, peek | O(1) |
| Queue enqueue, dequeue, front | O(1) |
| Linked list insert at beginning / insert at end / search / delete | O(1) / O(n) / O(n) / O(n) |
| Linear search | O(n) |
| Binary search (sorted data) | O(log n) |
| BFS and DFS (adjacency list) | O(V + E) |

## Collaboration
Each member worked on an individual feature branch, committed regularly with meaningful
messages, and merged through pull requests. Tasks were tracked using GitHub Issues.
