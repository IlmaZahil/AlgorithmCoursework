<h1 align="center"> Algorithm Coursework π₯ </h1> <br/>

<h3>Coursework Description: Network Flow</h3><br/>

<p>One often uses graphs to model transportation networksβnetworks whose edges carry some 
sort of traffic and whose nodes act as βswitchesβ passing traffic between different edges. 
Consider, for example, a highway system in which the edges are highways and the nodes are 
interchanges; or a computer network in which the edges are links that can carry packets and 
the nodes are switches; or a fluid network in which edges are pipes that carry liquid, and the 
nodes are junctures where pipes are plugged together. 
Network models of this type are directed graphs with some additional ingredients: </p>

<ol>
<li>A capacity π(π) on each edge π, indicating how much flow it can carry</li>
<li>Source nodes in the graph, which can generate flow</li>
<li>Target (aka sink or destination) nodes in the graph, which can absorb flow</li>
</ol><br/>

<p>An example of such a graph is given below. The nodes are numbered 0,1,2,3; node 0 is the 
source and node 3 the target. Each edge π is labelled with its capacity π(π).</p><br/>

<img width="234" alt="Capture" src="https://user-images.githubusercontent.com/66563618/114908631-e65b4e00-9e39-11eb-8595-211d41a0e610.PNG"><br/>

<h3>Defining Flows</h3><br/>

<p>Suppose our network contains one source node s and one target node t. We say that a flow
from s to t is a function π that maps each edge π to a nonnegative real number π(π), the 
amount of flow along edge π. A flow π must satisfy two properties:
<ol>
<li>Capacity conditions: For each edge π β π¬, we have π β€ π(π) β€ π(π). </li>
<li>Conservation conditions: For each node v except s and t, we have 
βπβππ(π) π(π) = βπβπππ(π) π(π) where ππ(π) and ππ’π‘(π) are the sets in edges into 
and out of π, respectively.</li><br/>

<p>In other words, the flow on an edge cannot exceed the capacity of the edge. For every node 
except the source and the sink, the amount of flow entering must equal the amount of flow 
leaving. The source has no entering edges but may have flow going out; in other words, it can 
generate flow. The target may have flow coming in but has no edges leaving it. 
The value of a flow π is defined to be the amount of flow generated at the source, which is 
the sum βπβπππ(π) π(π). The goal of this coursework is to implement an algorithm for
maximising this value, i.e. finding a maximum generated flow from s to t.<br/>


<h3>Tasks to be performed:</h3><br/>

Task 1 (10 marks). Set up a project (Java or C++) as you did for the tutorial exercises. <br/>

Task 2 (20 marks). Choose and implement a data structure which can represent a flow 
network. Assume that all capacities are integers, and you therefore only need to consider 
integer-valued flows. Explain the chosen data structure in the report accompanying your 
code. <br/>

Task 3 (20 marks). Add a simple parser which can read a description of a network from an 
input file. The structure of the files will look like the following example, representing the 
network in the above image (the comments are just added for clarification, they will not be 
in the actual input file and your parser does not have to be able to handle them):</p><br/>

<img width="415" alt="Capture2" src="https://user-images.githubusercontent.com/66563618/114909190-8022fb00-9e3a-11eb-8e24-a4af51724631.PNG"><br/>


<p>The first line contains the number n of nodes. Nodes are numbered starting from 0; node 0 is 
the source and node n-1 is the target. Each following line contains a triple of numbers a b c
meaning that there is an edge from node a to node b with capacity c. There are no other edges 
than these given ones.<br/>
Your parser should be able to handle all input files which have this format. We will provide 
benchmark examples for your performance analysis, but make sure to also create some 
yourself to test your implementation.<br/>

Task 4 (20 marks). Choose and implement an algorithm which computes a maximum flow for 
a network and outputs it along with additional information explaining how it was obtained 
(such as incremental improvements for iterative algorithms like Ford-Fulkerson). <br/>

Task 5 (30 marks). Write a brief report (no more than 2 A4 pages) containing the following:
a) A short explanation of your choice of data structure and algorithm.<br/>
b) A run of your algorithm on the smallest benchmark example. This should include the 
supporting information as described in Task 4.<br/>
c) A performance analysis of your algorithmic design and implementation. This can be 
based either on an empirical study, e.g., doubling hypothesis, or on purely
theoretical considerations, as discussed in the lectures and tutorials. It should 
include a suggested order-of-growth classification (Big-O notation).
</p>

