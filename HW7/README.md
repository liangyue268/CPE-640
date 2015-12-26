##Question
TCP/IP Socket programming + Observer Design Pattern

Modify the application developed in the previous problem such that the host can accept connections from multiple guests (C1, C2, …) .


##Description
+ Messages typed by individual guests are visible on the host’s screen and the messages typed by the host are common to all the guests, but the guests’ messages are not visible to each other.
+ The clients can connect/disconnect from the host anytime.
+ In this case the “Status” text field just shows how many clients are currently subscribed to the host.
+ In order to solve the problem, maintain a list of observers(or clients) on the host, such that a any new client connecting to the chat is added to the list of observers to be notified. The clients can add or remove themselves from the list anytime.

![img](https://dl.dropbox.com/s/dr95ea4j62mz2k0/1.jpg  "Running application with one server and two clients")

![img](https://dl.dropbox.com/s/z9k7ndndplo7ihs/2.jpg "Server connected with two clients successfully")

![img](https://dl.dropbox.com/s/9z344y7y71r1g1q/3.jpg "Sending and receiving messages")

![img](https://dl.dropbox.com/s/w6l2197ilyeeyhn/4.jpg "One client disconnected form server")

![img](https://dl.dropbox.com/s/gocjj3448piy1hh/5.jpg "All clients disconnected from server")

![img](https://dl.dropbox.com/s/ejiiai6akrlts1v/6.jpg "One client connected with server again")