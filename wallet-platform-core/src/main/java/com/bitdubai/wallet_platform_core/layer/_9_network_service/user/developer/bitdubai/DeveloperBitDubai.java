package com.bitdubai.wallet_platform_core.layer._9_network_service.user.developer.bitdubai;

import com.bitdubai.wallet_platform_api.layer._9_network_service.NetworkService;
import com.bitdubai.wallet_platform_api.layer._9_network_service.NetworkServiceDeveloper;
import com.bitdubai.wallet_platform_core.layer._9_network_service.user.developer.bitdubai.version_1.UserService;

/**
 * Created by ciencias on 20.01.15.
 */
public class DeveloperBitDubai implements NetworkServiceDeveloper {

    NetworkService mNetworkService;

    @Override
    public NetworkService getNetworkService() {
        return mNetworkService;
    }

    public DeveloperBitDubai () {

        /**
         * I will choose from the different versions of my implementations which one to start. Now there is only one, so
         * it is easy to choose.
         */

        mNetworkService = new UserService();

    }
}
