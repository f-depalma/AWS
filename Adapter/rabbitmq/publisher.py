import json


class Publisher:
    def __init__(self, exchange, channel):
        self.EXCHANGE = exchange
        self.channel = channel

    def publish(self, data):
        json_data = json.dumps(data.__dict__, indent=4)

        self.channel.basic_publish(
            exchange=self.EXCHANGE,
            routing_key=data.name,
            body=json_data
        )

        print(json_data)
