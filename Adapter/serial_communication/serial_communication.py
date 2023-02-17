from .readData import ReadData
from .generateMessage import GenerateMessage
from pubsub import pub


queue = []


def print_message(message):
    print(message)


def start():
    print("start")
    ReadData(queue)
    GenerateMessage(queue)

    pub.subscribe(print_message, 'message')
