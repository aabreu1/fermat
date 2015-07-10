package com.bitdubai.fermat_dmp_plugin.layer.basic_wallet.bitcoin_wallet.developer.bitdubai.version_1.structure;

import com.bitdubai.fermat_api.FermatException;
import com.bitdubai.fermat_api.layer.osa_android.database_system.Database;
import com.bitdubai.fermat_api.layer.osa_android.database_system.DatabaseDataType;
import com.bitdubai.fermat_api.layer.osa_android.database_system.DatabaseFactory;
import com.bitdubai.fermat_api.layer.osa_android.database_system.DatabaseTable;
import com.bitdubai.fermat_api.layer.osa_android.database_system.DatabaseTableFactory;
import com.bitdubai.fermat_api.layer.osa_android.database_system.DatabaseTableRecord;
import com.bitdubai.fermat_api.layer.osa_android.database_system.DealsWithPluginDatabaseSystem;
import com.bitdubai.fermat_api.layer.osa_android.database_system.PluginDatabaseSystem;
import com.bitdubai.fermat_api.layer.osa_android.database_system.exceptions.CantCreateDatabaseException;
import com.bitdubai.fermat_api.layer.osa_android.database_system.exceptions.CantCreateTableException;
import com.bitdubai.fermat_api.layer.osa_android.database_system.exceptions.CantInsertRecordException;
import com.bitdubai.fermat_api.layer.osa_android.database_system.exceptions.InvalidOwnerIdException;

import java.util.UUID;

/**
 * Created by eze on 2015.06.23..
 */
public class BitcoinWalletDatabaseFactory implements DealsWithPluginDatabaseSystem {

    /**
     * DealsWithPluginDatabaseSystem Interface member variables.
     */
    private PluginDatabaseSystem pluginDatabaseSystem;

    /**
     * DealsWithPluginDatabaseSystem Interface implementation.
     */
    @Override
    public void setPluginDatabaseSystem(PluginDatabaseSystem pluginDatabaseSystem) {
        this.pluginDatabaseSystem = pluginDatabaseSystem;
    }

    public Database createDatabase(UUID ownerId, UUID walletId) throws CantCreateDatabaseException {

        Database database;

        /**
         * I will create the database where I am going to store the information of this wallet.
         */
        database = this.pluginDatabaseSystem.createDatabase(ownerId, walletId.toString());

        /**
         * Next, I will add the needed tables.
         */
        try {

            DatabaseTableFactory table;

            /**
             * Then the value chunks table.
             */
            table = database.getDatabaseFactory().newTableFactory(ownerId, BitcoinWalletDatabaseConstants.BITCOIN_WALLET_TABLE_NAME);
            table.addColumn(BitcoinWalletDatabaseConstants.BITCOIN_WALLET_TABLE_ID_COLUMN_NAME, DatabaseDataType.STRING, 36,true);
            table.addColumn(BitcoinWalletDatabaseConstants.BBITCOIN_WALLET_TABLE_VERIFICATION_ID_COLUMN_NAME, DatabaseDataType.STRING,36,false);
            table.addColumn(BitcoinWalletDatabaseConstants.BITCOIN_WALLET_TABLE_ADDRESS_FROM_COLUMN_NAME, DatabaseDataType.STRING, 36,false);
            table.addColumn(BitcoinWalletDatabaseConstants.BITCOIN_WALLET_TABLE_ADDRESS_TO_COLUMN_NAME, DatabaseDataType.STRING, 36,false);
            table.addColumn(BitcoinWalletDatabaseConstants.BITCOIN_WALLET_TABLE_ACTOR_FROM_COLUMN_NAME, DatabaseDataType.STRING, 36, false);
            table.addColumn(BitcoinWalletDatabaseConstants.BITCOIN_WALLET_TABLE_ACTOR_TO_COLUMN_NAME, DatabaseDataType.STRING, 36, false);
            table.addColumn(BitcoinWalletDatabaseConstants.BITCOIN_WALLET_TABLE_ACTOR_FROM_TYPE_COLUMN_NAME, DatabaseDataType.STRING, 36, false);
            table.addColumn(BitcoinWalletDatabaseConstants.BITCOIN_WALLET_TABLE_ACTOR_TO_TYPE_COLUMN_NAME, DatabaseDataType.STRING, 36, false);
            table.addColumn(BitcoinWalletDatabaseConstants.BITCOIN_WALLET_TABLE_AMOUNT_COLUMN_NAME, DatabaseDataType.LONG_INTEGER, 0,false);
            table.addColumn(BitcoinWalletDatabaseConstants.BITCOIN_WALLET_TABLE_TYPE_COLUMN_NAME, DatabaseDataType.STRING, 20, false);
            table.addColumn(BitcoinWalletDatabaseConstants.BITCOIN_WALLET_TABLE_BALANCE_TYPE_COLUMN_NAME, DatabaseDataType.STRING, 20, false);
            table.addColumn(BitcoinWalletDatabaseConstants.BITCOIN_WALLET_TABLE_TIME_STAMP_COLUMN_NAME, DatabaseDataType.LONG_INTEGER, 0,false);
            table.addColumn(BitcoinWalletDatabaseConstants.BITCOIN_WALLET_TABLE_MEMO_COLUMN_NAME, DatabaseDataType.STRING, 200,false);
            table.addColumn(BitcoinWalletDatabaseConstants.BITCOIN_WALLET_TABLE_TRANSACTION_HASH_COLUMN_NAME, DatabaseDataType.STRING, 100,false);
            table.addColumn(BitcoinWalletDatabaseConstants.BITCOIN_WALLET_TABLE_RUNNING_BOOK_BALANCE_COLUMN_NAME, DatabaseDataType.LONG_INTEGER, 0,false);
            table.addColumn(BitcoinWalletDatabaseConstants.BITCOIN_WALLET_TABLE_RUNNING_AVAILABLE_BALANCE_COLUMN_NAME, DatabaseDataType.LONG_INTEGER, 0,false);

            try {
                database.getDatabaseFactory().createTable(ownerId, table);
            }
            catch (CantCreateTableException cantCreateTableException) {
                database.closeDatabase();
                throw new CantCreateDatabaseException();
            }


        }
        catch (InvalidOwnerIdException invalidOwnerId) {
            /**
             * This shouldn't happen here because I was the one who gave the owner id to the database file system,
             * but anyway, if this happens, I can not continue.
             * * *
             */
            database.closeDatabase();
            throw new CantCreateDatabaseException("I COUNLDN'T CREATE THE DATABASE",invalidOwnerId,"OwnerId: " + ownerId + FermatException.CONTEXT_CONTENT_SEPARATOR + "TableName: " + BitcoinWalletDatabaseConstants.BITCOIN_WALLET_TABLE_NAME,"");
        }



        /**
         * Next, I will add the needed tables.
         */
        try {

            DatabaseTableFactory table;

            /**
             * Then the value chunks table.
             */
            table = database.getDatabaseFactory().newTableFactory(ownerId, BitcoinWalletDatabaseConstants.BITCOIN_WALLET_BALANCE_TABLE_NAME);
            table.addColumn(BitcoinWalletDatabaseConstants.BITCOIN_WALLET_BALANCE_TABLE_ID_COLUMN_NAME, DatabaseDataType.STRING, 36,false);
            table.addColumn(BitcoinWalletDatabaseConstants.BITCOIN_WALLET_BALANCE_TABLE_AVAILABLE_BALANCE_COLUMN_NAME, DatabaseDataType.LONG_INTEGER, 0,false);
            table.addColumn(BitcoinWalletDatabaseConstants.BITCOIN_WALLET_BALANCE_TABLE_BOOK_BALANCE_COLUMN_NAME, DatabaseDataType.LONG_INTEGER, 0,false);

            try {
                database.getDatabaseFactory().createTable(ownerId, table);
            }
            catch (CantCreateTableException cantCreateTableException) {
                database.closeDatabase();
                throw new CantCreateDatabaseException();
            }

            /**
             * I will insert on first time a empty record with balances on cero
             */

            DatabaseTable bitcoinbalancewalletTable = database.getTable(BitcoinWalletDatabaseConstants.BITCOIN_WALLET_BALANCE_TABLE_NAME);

            DatabaseTableRecord balancesRecord = bitcoinbalancewalletTable.getEmptyRecord();

            UUID balanceRecordId = UUID.randomUUID();

            balancesRecord.setUUIDValue(BitcoinWalletDatabaseConstants.BITCOIN_WALLET_BALANCE_TABLE_ID_COLUMN_NAME, balanceRecordId);
            balancesRecord.setLongValue(BitcoinWalletDatabaseConstants.BITCOIN_WALLET_BALANCE_TABLE_AVAILABLE_BALANCE_COLUMN_NAME, 0);
            balancesRecord.setLongValue(BitcoinWalletDatabaseConstants.BITCOIN_WALLET_BALANCE_TABLE_BOOK_BALANCE_COLUMN_NAME, 0);


            try {
                bitcoinbalancewalletTable.insertRecord(balancesRecord);
            } catch (CantInsertRecordException e) {
                database.closeDatabase();
                throw new CantCreateDatabaseException("I COULDN'T CREATE THE DATABASE",e,"","Can't insert first empty balance record");
            }

        }
        catch (InvalidOwnerIdException invalidOwnerId) {
            /**
             * This shouldn't happen here because I was the one who gave the owner id to the database file system,
             * but anyway, if this happens, I can not continue.
             * * *
             */
            database.closeDatabase();
            throw new CantCreateDatabaseException("I COUNLDN'T CREATE THE DATABASE",invalidOwnerId,"OwnerId: " + ownerId + FermatException.CONTEXT_CONTENT_SEPARATOR + "TableName: " + BitcoinWalletDatabaseConstants.BITCOIN_WALLET_TABLE_NAME,"");
        }
        database.closeDatabase();
        return database;
    }

}
