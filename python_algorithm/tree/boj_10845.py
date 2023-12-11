import sys

graph = []
n = int(sys.stdin.readline())
for _ in range(n):
  command = list( sys.stdin.readline().split())
  if command[0] == 'push':
    graph.append(command[1])
  elif command[0] == 'pop':
    del graph[0]
  elif command[0] == 'size':
    len(graph)
  elif command[0] == 'empty':
    if len(graph) == 0:
      print('1')
    else:
      print('0')
  elif command[0] == 'front':
    if len(graph) == 0:
      print('-1')
    else:
      print(graph[0])
  elif command[0] == 'back':
    if len(graph) == 0:
      print('-1')
    else:
      print(graph[-1])