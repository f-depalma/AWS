from .publisher import Publisher
import pika


class PublisherManager:
    EXCHANGE = 'ws1'

    def __init__(self):
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
                queue=data.name,
                arguments={'x-message-ttl': 60000}
            )
            self.channel.queue_bind(
                exchange=self.EXCHANGE,
                queue=queue.method.queue,
                routing_key=data.name
            )
            self.publishers[data.name] = Publisher(self.EXCHANGE, self.channel)

        self.publishers[data.name].publish(data)
