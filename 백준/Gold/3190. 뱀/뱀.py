from collections import deque

N = int(input())
K = int(input())
appleLocation = [list(map(int, input().split())) for _ in range(K)]
board = [[0 for _ in range(N)] for _ in range(N)]
for apple in appleLocation:
    board[apple[0] - 1][apple[1] - 1] = 'apple'

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

L = int(input())
snake_dir_list = [list(map(str, input().split())) for _ in range(L)]
snake = []

def snake_move(nx, ny):
    snake.append([nx, ny])
    dir = 3
    cnt = 0
    while True:
        nx, ny = nx + dx[dir], ny + dy[dir]
        cnt += 1
        if [nx, ny] not in snake and 0 <= nx < N and 0 <= ny < N:
            if board[nx][ny] == 'apple':
                board[nx][ny] = 0
                snake.append([nx, ny])
            else:
                snake.append([nx, ny])
                snake.pop(0)
        else:
            return cnt

        if snake_dir_list:
            if cnt == int(snake_dir_list[0][0]):
                if snake_dir_list[0][1] == 'L':
                    if dir == 0:
                        dir = 2
                    elif dir == 1:
                        dir = 3
                    elif dir == 2:
                        dir = 1
                    elif dir == 3:
                        dir = 0
                elif snake_dir_list[0][1] == 'D':
                    if dir == 0:
                        dir = 3
                    elif dir == 1:
                        dir = 2
                    elif dir == 2:
                        dir = 0
                    elif dir == 3:
                        dir = 1
                snake_dir_list.pop(0)

print(snake_move(0,0))