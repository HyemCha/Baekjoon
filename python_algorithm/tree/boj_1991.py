import sys

graph = {}
n = int(sys.stdin.readline())

for _ in range(n):
  item, left, right = sys.stdin.readline().strip().split()
  graph[item] = left, right

def preorder(node):
  if node != '.':
    print(node, end='')
    preorder(graph[node][0])
    preorder(graph[node][1])

def inorder(node):
  if node != ".":
    inorder(graph[node][0])
    print(node, end='')
    inorder(graph[node][1])

def postorder(node):
  if node != ".":
    postorder(graph[node][0])
    postorder(graph[node][1])         
    print(node, end='')

preorder('A')
print()
inorder('A')
print()
postorder('A')