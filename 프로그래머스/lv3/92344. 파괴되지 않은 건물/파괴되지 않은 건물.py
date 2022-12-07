def solution(board, skill):
    R,C = len(board),len(board[0])
    imos = [[0]*(R+1) for _ in range(C+1)]
    for type,r1,c1,r2,c2,degree in skill:
        if type == 1:
            imos[r1][c1] -= degree
            imos[r1][c2+1] += degree
            imos[r2+1][c1] += degree
            imos[r2+1][c2+1] -= degree
        if type == 2:
            imos[r1][c1] += degree
            imos[r1][c2+1] -= degree
            imos[r2+1][c1] -= degree
            imos[r2+1][c2+1] += degree

    for i in range(len(imos)):
        for j in range(1,len(imos[0])):
            imos[i][j] += imos[i][j-1]

    for i in range(len(imos[0])):
        for j in range(1,len(imos)):
            imos[j][i] += imos[j-1][i]

    answer = 0

    for i in range(R):
        for j in range(C):
            board[i][j] += imos[i][j]
            if board[i][j] > 0:
                answer += 1

    return answer