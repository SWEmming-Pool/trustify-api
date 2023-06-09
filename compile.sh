#!/bin/bash

echo "Compilazione contratti"

contract_path="src/main/java/com/swemmingpool/TrustifyAPI/contracts/"
out_path="src/main/java/com/swemmingpool/TrustifyAPI/contracts/out"

solc $contract_path/ReviewSystem.sol --abi --bin --optimize --overwrite -o $out_path

echo "Esegui web3j"

./web3j generate solidity \
	-a $out_path/ReviewSystem.abi \
	-b $out_path/ReviewSystem.bin \
	-o src/main/java \
	-p com.swemmingpool.TrustifyAPI.api.model

echo "Fine"
