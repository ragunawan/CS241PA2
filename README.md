# CS241PA2
Shopping Management System

Project 2 Summary: Implement TreeMap using Binary Search Trees

1. Requirements: What did this project ask you to do? What was the input? How was the input processed? What was the output? 
The objective of this project was to implement MyTreeMap class using the Binary Search Tree (BST) data structure. There were no input files, however one of the goals was to integrate the developed MyTreeMap class with the code developed in Project 1 (which utilized items.txt and orders.txt as inputs). The test program would be the main method used to test the validity of the developed MyTreeMap class. The TestTreeMap class would submit actions to be processed by the MyTreeMap class. The output was the console output after the MyTreeMap class has processed the TestTreeMap class. 

2. Method: Describe the algorithm and data structures you used. 
The TestTreeMap class would use methods similar to the Map class. Implementing the BST into the MyTreeMap class. The MyTreeMap class has the containsKey, put, get, remove, and keySet methods which implement the private methods within the Element class of search, insert, search, delete and inorder methods respectively. The Element class stored a Key and Value variable which was associated with a particular tree node and could be accessed by the getRoot method of the BinaryTree class. Most of the heavy lifting of the code was performed through the private methods of the Element class. One particular method that took quite a bit of work was the delete method which required a unique approach to recursion in order to operate correctly. By analyzing the different possibilities that a user could delete a tree node, the integrity of the code was preserved to account for unique instances.

3. Implementation: Describe the structure of your code and the packages used. 
The only package used was the Math package for the max method to determine the height of the BST in the MyTreeMap class. The MyTreeMap class featured a private Element class which was utilized to store the key and value variables inside the node. The private Element class also had private search, insert, delete, promote, inorder and height methods which were called by the MyTreeMap public methods. Also implemented was the BinaryTree class which declared the private variables for the Element node as well as the left and right subtrees along with the getRoot, getLeft, getRight, setRoot, setLeft, setRight, toString and isLeaf methods. 

4. Testing: How did you make sure your implementation is correct? 
By utilizing the supplied TestTreeMap class and verifying the output through debug statements as well as the output from the TestTreeMap class. I verified this by drawing diagrams of the Binary Search Tree as more nodes were added and removed and compared those diagrams to the console output.

5. Findings: What did you learn from this project? Graphs and analysis that might be required for this section.
In this project I learned that about the Binary Search Tree and its unique properties. Because of how new nodes are inserted into the Binary Search Tree, it will always maintain the property of nodes with less value than a root node to be on the left and nodes with more value than a root node to be on the right. I also learned about the importance of recursion in order to make efficient code within the Element class.
