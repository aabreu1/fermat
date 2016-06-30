package com.bitdubai.fermat_bch_api.layer.crypto_network.fermat.interfaces;

import com.bitdubai.fermat_api.layer.all_definition.enums.BlockchainNetworkType;
import com.bitdubai.fermat_api.layer.all_definition.enums.CryptoCurrency;
import com.bitdubai.fermat_bch_api.layer.crypto_network.BlockchainNetworkSelector;

import org.bitcoinj.core.NetworkParameters;

/**
 * Created by rodrigo on 6/22/16.
 */
public interface FermatNetworkConfiguration {
    static final BlockchainNetworkType DEFAULT_NETWORK_TYPE = BlockchainNetworkType.PRODUCTION;
    static final CryptoCurrency CRYPTO_CURRENCY = CryptoCurrency.FERMAT;

}