def distribute(name,proceeds,recommender):
    if name == '-':
        recommender[name][1] += proceeds
        return
    if proceeds*0.1 < 1:
        recommender[name][1] += proceeds
    else:
        distribution = int(proceeds * 0.1)
        recommender[name][1] += proceeds - distribution
        distribute(recommender[name][0],distribution,recommender)
    return

def solution(enroll, referral, seller, amount):
    answer = []
    recommender = {}
    recommender['-'] = ['',0]
    for i in range(len(enroll)):
        recommender[enroll[i]] = [referral[i],0]
    for i in range(len(seller)):
        distribute(seller[i],amount[i]*100,recommender)
    for i in range(len(enroll)):
        answer.append(recommender[enroll[i]][1])
    return answer