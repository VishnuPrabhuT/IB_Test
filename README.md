# IB_Test

IB - Vue &amp; Spring Boot

Ant -> Vue [IBTest => ant => dist(Contains Vue SPA files)]

Boot -> Spring [ Running at http://localhost:8085/ ]

    1) From CLI type 'mvn exec:java'
    2) Go to http://localhost:8085/ to see test the SPA

Note -> I have used Server Sent Events for streaming the File Details every 5 seconds instead of traditional Polling to be efficient.
