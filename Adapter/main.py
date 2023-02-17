from serial_communication import serial_communication
import pika
import uuid


if __name__ == "__main__":
    serial_communication.start()
    # starting the client
    # s = socket.socket()
    # s.connect(('127.0.0.1', 12345))

    # start to read from arduino and send message to the server
