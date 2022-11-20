from collections import deque

def solution(r,c,k):
    global ans

    q1 = deque()
    q2 = deque()
    q1.append([r,c])
    board[r][c] = k

    while q1:
        r,c = q1.popleft()
        for d in dir:
            nr,nc = r+d[0],c+d[1]
            if 0<=nr<N and 0<=nc<N:
                if board[nr][nc] == k:
                    continue
                if board[nr][nc] == 0:
                    q2.append([nr,nc,1])
                    continue
                q1.append([nr,nc])
                board[nr][nc] = k


    def bridge(n):
        nonlocal q2
        while q2:
            r,c,dist = q2.popleft()
            if dist>=ans:
                return ans
            for d in dir:
                nr, nc = r + d[0], c + d[1]
                if 0 <= nr < N and 0 <= nc < N and not visited[nr][nc]:
                    if board[nr][nc] == n:
                        continue
                    if board[nr][nc] == 0:
                        q2.append([nr,nc,dist+1])
                        visited[nr][nc] = 1
                    elif board[nr][nc]:
                        return dist
        return ans

    distance = bridge(k)
    if distance < ans:
        ans = distance

N = int(input())
board = [list(map(int,input().split())) for _ in range(N)]
visited = [[0]*N for _ in range(N)]
dir = [[0,1],[0,-1],[1,0],[-1,0]]
k = 1
ans = 10**6

for r in range(N):
    for c in range(N):
        if board[r][c] == 1:
            k += 1
            solution(r,c,k)

print(ans)