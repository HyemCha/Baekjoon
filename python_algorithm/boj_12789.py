import sys

def isStack():
  cnt = 1

  while graph:
    if cnt == graph[0]:
      cnt += 1
      graph.pop(0)
    else:
      stack.append(graph.pop(0))

    while stack:
      if cnt == stack[-1]:
        cnt += 1
        stack.pop()
      else:
        break


n = int(sys.stdin.readline())
graph = list(map(int, sys.stdin.readline().split()))
stack = []

isStack()

if len(stack) == 0:
  print("Nice")
else:
  print("Sad")
