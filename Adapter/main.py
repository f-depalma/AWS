import serial
import subprocess
import threading
import socket
from datetime import datetime
import json


def read_serial(_serial_data, _queue):
    while True:
        # collect data from arduino and add to the queue (String)
        if _serial_data.inWaiting() > 0:
            _queue += _serial_data.readline().decode("utf-8", 'ignore')


def get_message(_message, _queue, server):
    while True:
        # get the first char from the string and add to the message
        if len(_queue) > 0:
            # \n means the end of the message
            if queue[0] == "\n":
                queue.pop(0)
                data = _message.replace("\r", "").split(":")
                json_data = {
                    "date_time": datetime.now().strftime("%d-%m-%Y %H.%M.%S"),
                    "name": data[0],
                    "value": data[1],
                    "unit": data[2]
                }
                json_obj = json.dumps(json_data, indent=4)
                print(json_obj)
                server.send(bytes(json_obj, encoding="utf-8"))
                _message = ""
            else:
                _message += _queue.pop(0)


if __name__ == "__main__":
    # find the serial port of arduino
    sPort = subprocess.run(["ls /dev/cu.usb*"], capture_output=True, shell=True).stdout.decode('utf-8')[:-1]
    serial_data = serial.Serial(sPort, 9600)  # COM port object

    # starting the client
    s = socket.socket()
    s.connect(('127.0.0.1', 12345))

    queue = []
    message = ""

    # start to read from arduino and send message to the server
    read = threading.Thread(target=read_serial, args=(serial_data, queue))
    write = threading.Thread(target=get_message, args=(message, queue, s))
    read.start()
    write.start()
