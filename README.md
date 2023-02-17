<h1>AWS</h1>
<hr>
<h6>Advanced Weather Station</h6>

<h3>Adapter</h3>
<ul>
    <li>Python 3.11</li>
    <li>Socket client (JSON communication)</li>
    <li>Serial communication with Arduino</li>
</ul>
<h3>DataCollector</h3>
<ul>
    <li>Java</li>
    <li>Socket server (JSON communication)</li>
</ul>
<h3>Arduino</h3>
<ul>
    <li>Use Humidity and temperature sensor</li>
    <li>Connect the + pin to 5V</li>
    <li>Connect the - pin to GND</li>
    <li>Connect the out pin to the digital input 2</li>
    <li>Send message of this structure: &lt;name&gt;:&lt;value&gt;:&lt;unit&gt;\n</li>
</ul>