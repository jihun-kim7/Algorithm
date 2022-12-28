import sys
sys.setrecursionlimit(10**6)

def make_trie(trie, words):
    for word in words:
        cur = trie
        l = len(word)
        for w in word:
            if w in cur:
                cur = cur[w]
                cur['!'].append(l)
            else:
                cur[w] = {}
                cur = cur[w]
                cur['!'] = [l]
    return trie


def find_result(trie, query, length):
    cnt = 0
    if query[0] == '?':
        return trie['!'].count(length)
    elif query[0] in trie:
        cnt += find_result(trie[query[0]], query[1:], length)
    return cnt


def solution(words, queries):
    answer = []
    rev_words = []
    count_len_words = []
    for word in words:
        rev_words.append(word[::-1])
        count_len_words.append(len(word))

    trie = make_trie({}, words)
    rev_trie = make_trie({}, rev_words)

    for query in queries:
        if query[0] == '?' and query[-1] == '?':
            answer.append(count_len_words.count(len(query)))
        elif query[-1] == '?':
            answer.append(find_result(trie, query, len(query)))
        elif query[0] == '?':
            answer.append(find_result(rev_trie, query[::-1], len(query)))

    return answer