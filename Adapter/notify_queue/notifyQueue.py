import requests

notified_queues = []


def send(queue, exchange):
    if queue not in notified_queues:
        url = 'http://localhost:8080/api/queue'
        payload = {
            'name': exchange + "." + queue
        }

        x = requests.post(url, json=payload)

        if x.status_code == 200:
            notified_queues.append(queue)
        print(x.status_code)

