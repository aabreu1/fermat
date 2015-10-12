package com.bitdubai.fermat_dap_plugin.layer.digital_asset_transaction.asset_issuing.developer.bitdubai.version_1.structure;

import com.bitdubai.fermat_api.layer.all_definition.transaction_transference_protocol.crypto_transactions.CryptoTransaction;
import com.bitdubai.fermat_api.layer.all_definition.util.XMLParser;
import com.bitdubai.fermat_api.layer.osa_android.file_system.PluginFileSystem;
import com.bitdubai.fermat_api.layer.osa_android.file_system.PluginTextFile;
import com.bitdubai.fermat_api.layer.osa_android.file_system.exceptions.CantCreateFileException;
import com.bitdubai.fermat_api.layer.osa_android.file_system.exceptions.CantPersistFileException;
import com.bitdubai.fermat_api.layer.osa_android.file_system.exceptions.FileNotFoundException;
import com.bitdubai.fermat_dap_api.layer.all_definition.digital_asset.DigitalAssetMetadata;
import com.bitdubai.fermat_dap_api.layer.all_definition.enums.AssetBalanceType;
import com.bitdubai.fermat_dap_api.layer.all_definition.exceptions.CantSetObjectException;
import com.bitdubai.fermat_dap_api.layer.dap_transaction.common.exceptions.CantCreateDigitalAssetFileException;
import com.bitdubai.fermat_dap_api.layer.dap_transaction.common.interfaces.DigitalAssetVault;
import com.bitdubai.fermat_dap_api.layer.dap_transaction.asset_issuing.exceptions.CantDeliverDigitalAssetToAssetWalletException;
import com.bitdubai.fermat_dap_api.layer.dap_wallet.asset_issuer_wallet.exceptions.CantRegisterCreditException;
import com.bitdubai.fermat_dap_api.layer.dap_wallet.asset_issuer_wallet.interfaces.AssetIssuerWallet;
import com.bitdubai.fermat_dap_api.layer.dap_wallet.asset_issuer_wallet.interfaces.AssetIssuerWalletBalance;
import com.bitdubai.fermat_dap_api.layer.dap_wallet.asset_issuer_wallet.interfaces.AssetIssuerWalletList;
import com.bitdubai.fermat_dap_api.layer.dap_wallet.asset_issuer_wallet.interfaces.AssetIssuerWalletManager;
import com.bitdubai.fermat_dap_api.layer.dap_transaction.common.exceptions.CantDeleteDigitalAssetFromLocalStorageException;
import com.bitdubai.fermat_dap_api.layer.dap_transaction.common.exceptions.CantGetDigitalAssetFromLocalStorageException;
import com.bitdubai.fermat_dap_api.layer.dap_wallet.asset_issuer_wallet.interfaces.AssetIssuerWalletTransaction;
import com.bitdubai.fermat_dap_api.layer.dap_wallet.common.enums.BalanceType;
import com.bitdubai.fermat_dap_api.layer.dap_wallet.common.exceptions.CantGetTransactionsException;
import com.bitdubai.fermat_dap_api.layer.dap_wallet.common.exceptions.CantLoadWalletException;
import com.bitdubai.fermat_pip_api.layer.pip_platform_service.error_manager.ErrorManager;

import java.util.List;
import java.util.UUID;

/**
 * Created by Manuel Perez (darkpriestrelative@gmail.com) on 01/10/15.
 * This class must be started with the AssetIssuing Plugin
 */
public class DigitalAssetMetadataVault extends DigitalAssetVault {

    AssetIssuerWalletManager assetIssuerWalletManager;
    ErrorManager errorManager;
    String walletPublicKey;
    //For testing I'm gonna use this type of privacy, change to PRIVATE in production release
    //private final FilePrivacy FILE_PRIVACY=FilePrivacy.PUBLIC;

    public DigitalAssetMetadataVault(UUID pluginId, PluginFileSystem pluginFileSystem, ErrorManager errorManager) throws CantSetObjectException {
        setPluginFileSystem(pluginFileSystem);
        setPluginId(pluginId);
        setErrorManager(errorManager);
    }

    public void setErrorManager(ErrorManager errorManager) throws CantSetObjectException{
        if(errorManager==null){
            throw new CantSetObjectException("ErrorManager is null");
        }
        this.errorManager=errorManager;
    }

    public void deliverDigitalAssetMetadataToAssetWallet(CryptoTransaction genesisTransaction, AssetBalanceType assetBalanceType)throws CantDeliverDigitalAssetToAssetWalletException{
        try{
            DigitalAssetMetadata digitalAssetMetadataToDeliver=getDigitalAssetMetadataFromLocalStorage(genesisTransaction.getTransactionHash());
            BalanceType balanceType;
            switch (assetBalanceType.getCode()){
                case "BOOK":
                    balanceType=BalanceType.BOOK;
                    break;
                case "AVAI":
                    balanceType=BalanceType.AVAILABLE;
                    break;
                default:
                    throw new CantDeliverDigitalAssetToAssetWalletException("Incorrect AssetBalanceType");
            }
            deliverDigitalAssetMetadata(digitalAssetMetadataToDeliver, genesisTransaction, balanceType);
        } catch (CantGetDigitalAssetFromLocalStorageException exception) {
            throw new CantDeliverDigitalAssetToAssetWalletException(exception,"Delivering DigitalAssetMetadata to Asset Wallet", "Cannot get the DigitalAssetMetadata from storage");
        } catch (CantGetTransactionsException exception) {
            throw new CantDeliverDigitalAssetToAssetWalletException(exception,"Delivering DigitalAssetMetadata to Asset Wallet", "Cannot get the Asset Transaction");
        } catch (CantLoadWalletException exception) {
            throw new CantDeliverDigitalAssetToAssetWalletException(exception,"Delivering DigitalAssetMetadata to Asset Wallet", "Cannot load the Asset Wallet");
        } catch (CantRegisterCreditException exception) {
            throw new CantDeliverDigitalAssetToAssetWalletException(exception,"Delivering DigitalAssetMetadata to Asset Wallet", "Cannot get the Asset Transaction");
        }
    }

    private void deliverDigitalAssetMetadata(DigitalAssetMetadata digitalAssetMetadata, CryptoTransaction genesisTransaction, BalanceType balanceType) throws CantLoadWalletException, CantGetTransactionsException, CantRegisterCreditException {
        AssetIssuerWallet assetIssuerWallet=this.assetIssuerWalletManager.loadAssetIssuerWallet(this.walletPublicKey);
        AssetIssuerWalletBalance assetIssuerWalletBalance= assetIssuerWallet.getBookBalance(balanceType);
        AssetIssuerWalletTransactionRecordWrapper assetIssuerWalletTransactionRecordWrapper=new AssetIssuerWalletTransactionRecordWrapper(
                digitalAssetMetadata,
                genesisTransaction,
                "testActorFromPublicKey",
                "testActorToPublicKey"
        );
        assetIssuerWalletBalance.credit(assetIssuerWalletTransactionRecordWrapper, balanceType);
    }


    public void setWalletPublicKey(String walletPublicKey) throws CantSetObjectException {
        if(walletPublicKey==null){
            throw new CantSetObjectException("walletPublicKey is null");
        }
        this.walletPublicKey=walletPublicKey;
    }

    public void setAssetIssuerWalletManager(AssetIssuerWalletManager assetIssuerWalletManager) throws CantSetObjectException {
        if(assetIssuerWalletManager==null){
            throw new CantSetObjectException("assetIssuerWalletManager is null");
        }
        this.assetIssuerWalletManager=assetIssuerWalletManager;
    }

    //Method unfinished, This method will check the asset transactions marked as available balance in asset wallet and update the transactionStatus as DELIVERED
    public void checkBalanceInAssetWallet(){
        //TODO: wait for this method in AssetIssuerWallet getTransactionsAll(BalanceType balanceType, String assetPublicKey)
    }

}
