import sys
from collections import deque


def bfs(x, y):
    queue = deque()
    queue.append((x, y))

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if graph[nx][ny] == '1' and visited[nx][ny] == 0:
                visited[nx][ny] = visited[x][y] + 1
                queue.append((nx, ny))


n, m = map(int, sys.stdin.readline().split())

graph = []
visited = [[0]*m for _ in range(n)]
for _ in range(n):
    graph.append(list(sys.stdin.readline().replace('\n', '')))

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

visited[0][0] = 1
bfs(0, 0)

print(visited[n-1][m-1])
