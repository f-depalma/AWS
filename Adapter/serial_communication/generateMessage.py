from datetime import datetime
from threading import Thread
import json
from pubsub import pub


class GenerateMessage(Thread):
    def __init__(self, queue):
        Thread.__init__(self)
        self.queue = queue
        self.message = ""
        self.start()

    def run(self):
        while True:
            # get the first char from the string and add to the message
            if len(self.queue) > 0:
                # \n means the end of the message
                if self.queue[0] == "\n":
                    self.queue.pop(0)
                    data = self.message.replace("\r", "").split(":")

                    self.publish(data)

                    # server.send(bytes(json_obj, encoding="utf-8"))
                    self.message = ""
                else:
                    self.message += self.queue.pop(0)

    @staticmethod
    def publish(data):
        json_data = {
            "date_time": datetime.now().strftime("%d-%m-%Y %H.%M.%S"),
            "name": data[0],
            "value": data[1],
            "unit": data[2]
        }

        json_obj = json.dumps(json_data, indent=4)
        pub.sendMessage('message', message=json_obj)

