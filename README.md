# MULTITHREADED-CHAT-APPLICATION


Multithreaded Chat Application in Java - Explanation
A Multithreaded Chat Application allows multiple clients to communicate with each other through a central server. Each client runs on a separate thread, ensuring simultaneous messaging.

How It Works
Server:

Listens for client connections.
Creates a new thread for each connected client.
Forwards messages from one client to all other clients (broadcasting).
Removes disconnected clients from the active list.


Clients:
Connect to the server using a socket.
Send messages to the server.
Receive messages from the server (which are broadcasted from other clients).
Run on separate instances, allowing multiple users to chat.



Multithreading in Action
The server creates a new thread for each connected client.
Each client runs independently, allowing real-time messaging.
The server ensures synchronization so messages from different clients don’t clash.



Execution Flow
Start the server first.
Launch multiple clients (each runs in its own terminal).
When a client sends a message, the server receives it and broadcasts it to all connected clients.
Messages appear on all clients' screens, creating a chatroom effect.



Key Features
✔ Handles multiple clients using multithreading
✔ Real-time messaging between clients
✔ Scalable (can handle many clients)
✔ Synchronized communication using sockets

