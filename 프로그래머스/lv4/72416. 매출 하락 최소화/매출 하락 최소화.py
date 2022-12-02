def solution(sales, links):
    sales = [0] + sales
    tree = [[] for _ in range(len(sales)+1)]
    for a,b in links:
        tree[a].append(b)
    d = [[0,0] for _ in range(len(sales)+1)]
    dfs(1,d,tree,sales)
    return min(d[1])

def dfs(node,d,tree,sales):

    if not tree[node]:
        d[node][0] = sales[node]
        d[node][1] = 0
        return

    d[node][0] = sales[node]
    min_gap = float('inf')

    for i in tree[node]:
        dfs(i, d, tree, sales)
        d[node][0] += min(d[i])
        min_gap = min(min_gap,d[i][0]-d[i][1])
        if min_gap < 0:
            min_gap = 0

    d[node][1] = d[node][0] + min_gap - sales[node]