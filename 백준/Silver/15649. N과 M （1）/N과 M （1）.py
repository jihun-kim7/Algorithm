n, m = map(int,input().split())
check = [False]*n
answer = []

def dfs(depth,n,m):
    if depth == m:
        print(' '.join(map(str,answer)))
        return
    for i in range(n):
        if not check[i]:
            answer.append(i+1)
            check[i] = True
            dfs(depth+1,n,m)
            check[i] = False
            answer.pop()

dfs(0,n,m)