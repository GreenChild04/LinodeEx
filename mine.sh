#!/bin/bash

read -p "Worker Name: " worker

cd srbminer
chmod +x SRBMiner-MULTI

nohup ./SRBMiner-MULTI --disable-gpu --algorithm verushash --pool na.luckpool.net:3956 --wallet RLs9nMFAMRC2PphAzkaMp292JS12yz4xEY.$worker --password x < /dev/null >> ../res.log 2>&1 &
