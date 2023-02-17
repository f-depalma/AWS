from serial_communication.serialCommunication import SerialCommunication
from rabbitmq.publisherManager import PublisherManager
from pubsub import pub

publisherManager = PublisherManager()


def start_app():
    pub.subscribe(publish, 'message')
    SerialCommunication().start()


def publish(data):
    publisherManager.publish(data)


if __name__ == "__main__":
    start_app()

    # starting the client
    # s = socket.socket()
    # s.connect(('127.0.0.1', 12345))

    # start to read from arduino and send message to the server
