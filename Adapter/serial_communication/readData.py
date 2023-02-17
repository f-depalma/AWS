import serial
import subprocess
from threading import Thread


class ReadData(Thread):
    def __init__(self, queue):
        Thread.__init__(self)
        try:
            self.serial_port = \
                subprocess.run(["ls /dev/cu.usb*"], capture_output=True, shell=True).stdout.decode('utf-8')[:-1]
            self.serial_data = serial.Serial(self.serial_port, 9600)  # COM port object
        finally:
            self.queue = queue
            self.start()

    def run(self):
        print("Reading from the serial port " + self.serial_port)
        while True:
            # collect data from arduino and add to the queue (String)
            if self.serial_data.inWaiting() > 0:
                self.queue += self.serial_data.readline().decode("utf-8", 'ignore')
