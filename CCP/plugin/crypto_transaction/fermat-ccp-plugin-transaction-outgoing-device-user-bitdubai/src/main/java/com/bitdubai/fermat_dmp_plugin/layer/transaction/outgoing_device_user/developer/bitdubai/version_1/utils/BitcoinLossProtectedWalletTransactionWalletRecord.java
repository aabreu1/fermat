package com.bitdubai.fermat_dmp_plugin.layer.transaction.outgoing_device_user.developer.bitdubai.version_1.utils;

import com.bitdubai.fermat_api.layer.all_definition.enums.Actors;
import com.bitdubai.fermat_api.layer.all_definition.enums.BlockchainNetworkType;
import com.bitdubai.fermat_api.layer.all_definition.money.CryptoAddress;
import com.bitdubai.fermat_dmp_plugin.layer.transaction.outgoing_device_user.developer.bitdubai.version_1.interfaces.BitcoinLossProtectedWalletTransactionRecord;

import java.util.UUID;

/**
 * Created by Joaquin Carrasquero on 17/03/16.
 */
public class BitcoinLossProtectedWalletTransactionWalletRecord implements BitcoinLossProtectedWalletTransactionRecord {



    CryptoAddress AddressFrom;

    UUID TransactionId;

    UUID RequestId;

    CryptoAddress AddressTo;

    long Amount;

    long Timestamp;

    String Memo;

    String TransactionHash;

    String ActorToPublicKey;

    String ActorFromPublicKey;

    Actors ActorToType;

    Actors ActorFromType;

    BlockchainNetworkType BlockchainNetworkType;


    public BitcoinLossProtectedWalletTransactionWalletRecord(UUID transactionId,
                                                             CryptoAddress addressFrom,
                                                             UUID requestId,
                                                             long amount,
                                                             CryptoAddress addressTo,
                                                             String memo,
                                                             long timestamp,
                                                             String transactionHash,
                                                             String actorFromPublicKey,
                                                             String actorToPublicKey,
                                                             Actors actorToType,
                                                             Actors actorFromType,
                                                             com.bitdubai.fermat_api.layer.all_definition.enums.BlockchainNetworkType blockchainNetworkType) {
        TransactionId = transactionId;
        AddressFrom = addressFrom;
        RequestId = requestId;
        Amount = amount;
        AddressTo = addressTo;
        Memo = memo;
        Timestamp = timestamp;
        TransactionHash = transactionHash;
        ActorFromPublicKey = actorFromPublicKey;
        ActorToPublicKey = actorToPublicKey;
        ActorToType = actorToType;
        ActorFromType = actorFromType;
        BlockchainNetworkType = blockchainNetworkType;
    }

    @Override
    public CryptoAddress getAddressFrom() {
        return AddressFrom;
    }

    @Override
    public UUID getTransactionId() {
        return TransactionId;
    }

    @Override
    public UUID getRequestId() {
        return RequestId;
    }

    @Override
    public CryptoAddress getAddressTo() {
        return AddressTo;
    }

    @Override
    public long getAmount() {
        return Amount;
    }

    @Override
    public long getTimestamp() {
        return Timestamp;
    }

    @Override
    public String getMemo() {
        return Memo;
    }

    @Override
    public String getTransactionHash() {
        return TransactionHash;
    }

    @Override
    public String getActorToPublicKey() {
        return ActorToPublicKey;
    }

    @Override
    public String getActorFromPublicKey() {
        return ActorFromPublicKey;
    }

    @Override
    public Actors getActorToType() {
        return ActorToType;
    }

    @Override
    public Actors getActorFromType() {
        return ActorFromType;
    }

    @Override
    public BlockchainNetworkType getBlockchainNetworkType() {
        return BlockchainNetworkType;
    }
}
