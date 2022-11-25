board_dict = {1:[[(0,0),(1,0),(1,1),(1,2)],[(0,1),(0,2)]],
              2:[[(0,0),(1,0),(2,-1),(2,0)],[(0,-1),(1,-1)]],
              3:[[(0,0),(1,0),(2,0),(2,1)],[(0,1),(1,1)]],
              4:[[(0,0),(1,-2),(1,-1),(1,0)],[(0,-2),(0,-1)]],
              5:[[(0,0),(1,-1),(1,0),(1,1)],[(0,-1),(0,1)]]}


def solution(board):
    answer = 0
    n  = len(board)

    def block_check(r, c, k):
        for block, d in board_dict.items():
            for dr, dc in d[0]:
                nr, nc = r + dr, c + dc
                if 0 <= nr < n and 0 <= nc < n:
                    if board[nr][nc] != k:
                        break
                else:
                    break
            else:
                return block
        else:
            return 0

    def remove(r, c, shape, k):
        nonlocal answer
        for dr, dc in board_dict[shape][1]:
            nr, nc = r + dr, c + dc
            while nr >= 0:
                if board[nr][nc] == 0:
                    nr -= 1
                else:
                    if [r,c,shape,k] not in temp:
                        temp.append([r, c, shape,k])
                    return False
        else:
            for dr, dc in board_dict[shape][0]:
                nr, nc = r + dr, c + dc
                board[nr][nc] = 0
            answer += 1
            return True

    never_list = []
    temp = []
    removed_list = []

    for i in range(n):
        for j in range(n):
            k = board[i][j]
            if k and k not in never_list and k not in removed_list:
                shape = block_check(i,j,k)
                if shape:
                    if remove(i,j,shape,k):
                        removed_list.append(k)
                        for [r,c,shape,key] in temp:
                            if remove(r,c,shape,key):
                                removed_list.append(k)
                                temp.remove([r,c,shape,key])
                else:
                    never_list.append(k)
    return answer