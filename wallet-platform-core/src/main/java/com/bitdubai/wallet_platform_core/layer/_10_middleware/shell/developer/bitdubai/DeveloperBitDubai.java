package com.bitdubai.wallet_platform_core.layer._10_middleware.shell.developer.bitdubai;

import com.bitdubai.wallet_platform_api.layer._10_middleware.MiddlewareEngine;
import com.bitdubai.wallet_platform_api.layer._10_middleware.MiddlewareEngineDeveloper;
import com.bitdubai.wallet_platform_core.layer._10_middleware.shell.developer.bitdubai.version_1.ShellMiddlewareEngine;

/**
 * Created by ciencias on 20.01.15.
 */
public class DeveloperBitDubai implements MiddlewareEngineDeveloper {

    MiddlewareEngine mMiddlewareEngine;

    @Override
    public MiddlewareEngine getMiddlewareEngine() {
        return mMiddlewareEngine;
    }

    public DeveloperBitDubai() {

        /**
         * I will choose from the different versions of my implementations which one to start. Now there is only one, so
         * it is easy to choose.
         */

        mMiddlewareEngine = new ShellMiddlewareEngine();

    }
}
