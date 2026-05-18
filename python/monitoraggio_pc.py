# pip install pymongo psutil
from pymongo import MongoClient
import psutil
import socket
from datetime import datetime
import time

# Connessione MongoDB
client = MongoClient("mongodb://root:root@localhost:27017/")
db = client["monitoraggio_lab"]
collection = db["pc"]

nome_pc = socket.gethostname()

print("Monitoraggio avviato...")

while True:

    dati = {
        "pc": nome_pc,
        "timestamp": datetime.now(),

        "cpu_percent": psutil.cpu_percent(interval=1),

        "ram_percent": psutil.virtual_memory().percent,

        "disco_percent":
            psutil.disk_usage('/').percent
    }

    collection.insert_one(dati)

    print(dati)

    time.sleep(10)