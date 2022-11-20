k = int(input())
arr = input().split()

max_li = [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
min_li = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]


def check(n, input_list):
    if n < 0:
        return
    if arr[n] == '<' and input_list[n] < input_list[n + 1]:
        return
    if arr[n] == '>' and input_list[n] > input_list[n + 1]:
        return

    input_list[n], input_list[n + 1] = input_list[n + 1], input_list[n]

    check(n - 1, input_list)


for i in range(k):
    check(i, max_li)
    check(i, min_li)

print(*max_li[:k + 1],sep='')
print(*min_li[:k + 1],sep='')