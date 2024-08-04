N,M = map(int,input().split())
paper = [list(map(int,input())) for _ in range(N)]
ans = 0


def bitmask():
    global ans
    for i in range(2**(N*M)):
        total = 0

        #가로 합
        for r in range(N):
            rowsum = 0
            for c in range(M):
                index = r*M+c
                if i & (1 << index):
                    rowsum = 10*rowsum + paper[r][c]
                else:
                    total += rowsum
                    rowsum = 0
            total += rowsum

        #세로 합
        for c in range(M):
            colsum = 0
            for r in range(N):
                index = r*M+c
                if not i & (1<<index):
                    colsum = 10*colsum + paper[r][c]
                else:
                    total += colsum
                    colsum = 0
            total += colsum
        ans = max(ans,total)

bitmask()
print(ans)