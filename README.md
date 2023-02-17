<h1>AWS</h1>
<hr>
<h6>Advanced Weather Station</h6>

<h3>Adapter</h3>
<ul>
    <li>Python 3.11</li>
    <li>Is a producer on RabbitMQ</li>
    <li>Serial communication with Arduino</li>
</ul>
<h3>DataServer</h3>
<ul>
    <li>Java</li>
    <li>Is a consumer on RabitMQ</li>
</ul>
<h3>Arduino</h3>
<ul>
    <li>Use Humidity and temperature sensor</li>
    <li>Connect the + pin to 5V</li>
    <li>Connect the - pin to GND</li>
    <li>Connect the out pin to the digital input 2</li>
    <li>Send message of this structure: &lt;name&gt;:&lt;value&gt;:&lt;unit&gt;\n</li>
    <li>Remember to install the library in Arduino IDE</li>
</ul>

<h3>RabbitMQ</h3>
<div margin-left="15px">
    execute the following step:
    <ul>
        <li>Install docker</li>
        <li>In terminal execute:
            <pre>docker pull rabbitmq</pre>
            <pre>docker run --rm -it --hostname my-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management</pre>
        </li>
    </ul>   
</div>

