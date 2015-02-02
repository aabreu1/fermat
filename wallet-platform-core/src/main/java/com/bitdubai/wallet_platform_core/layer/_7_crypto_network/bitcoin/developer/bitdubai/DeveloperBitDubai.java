package com.bitdubai.wallet_platform_core.layer._7_crypto_network.bitcoin.developer.bitdubai;

import com.bitdubai.wallet_platform_api.PlatformService;
import com.bitdubai.wallet_platform_api.layer._7_crypto_network.CryptoNetworkDeveloper;
import com.bitdubai.wallet_platform_core.layer._7_crypto_network.bitcoin.developer.bitdubai.version_1.BitcoinCryptoNetworkService;

/**
 * Created by ciencias on 20.01.15.
 */
public class DeveloperBitDubai implements CryptoNetworkDeveloper {

    PlatformService mCryptoNetworkService;

    @Override
    public PlatformService getCryptoNetwork() {
        return mCryptoNetworkService;
    }

    public DeveloperBitDubai () {

        /**
         * I will choose from the different versions of my implementations which one to start. Now there is only one, so
         * it is easy to choose.
         */

        mCryptoNetworkService = new BitcoinCryptoNetworkService();

    }


}
