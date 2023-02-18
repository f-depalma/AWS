import pika
from .publisher import Publisher


class PublisherManager:

    def __init__(self, exchange):
        self.EXCHANGE = exchange
        self.publishers = {}
        connection = pika.BlockingConnection(pika.ConnectionParameters('localhost'))

        self.channel = connection.channel()

        self.channel.exchange_declare(
            exchange=self.EXCHANGE,
            exchange_type='direct'
        )

    def publish(self, data):
        if self.publishers.get(data.name) is None:
            queue = self.channel.queue_declare(
                queue=self.EXCHANGE + "." + data.name,
                arguments={'x-message-ttl': 60000}
            )
            self.channel.queue_bind(
                exchange=self.EXCHANGE,
                queue=queue.method.queue,
                routing_key=data.name
            )
            self.publishers[data.name] = Publisher(self.EXCHANGE, self.channel)

        self.publishers[data.name].publish(data)
