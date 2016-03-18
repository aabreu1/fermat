/*
 * @#WsCommunicationsCloudClientManager.java - 2015
 * Copyright bitDubai.com., All rights reserved.
 * You may not modify, use, reproduce or distribute this software.
 * BITDUBAI/CONFIDENTIAL
 */
package com.bitdubai.fermat_p2p_api.layer.p2p_communication;

import com.bitdubai.fermat_api.layer.all_definition.common.system.interfaces.FermatManager;
import com.bitdubai.fermat_p2p_api.layer.p2p_communication.commons.client.CommunicationsClientConnection;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * The Class <code>com.bitdubai.fermat_p2p_api.layer.p2p_communication.WsCommunicationsCloudClientManager</code>
 * <p/>
 * Created by Roberto Requena - (rart3001@gmail.com) on 14/09/15.
 *
 * @version 1.0
 * @since Java JDK 1.7
 */
public interface WsCommunicationsCloudClientManager extends FermatManager {

    /**
     * Get the CommunicationsClientConnection
     *
     * @return CommunicationsClientConnection
     */
    public CommunicationsClientConnection getCommunicationsCloudClientConnection();

    /**
     * Get the disable server flag
     *
     * @return Boolean
     */
    public Boolean isDisable();

    /*
     * set Network State
     */
    void setNetworkState(boolean state);

    /*
     * set the ipAddress and the port to connect to the Cloud Server
     */
    void changeIpAndPortProperties(String ipAddress, Integer port);

    /*
     * change default values the ipAddress and the port to connect to the Cloud Server
     */
    void resetIpAndPortDefault();

    /**
     * Method that connect the client whit the server
     *
     * @throws Exception
     */
     void reloadConnectClient() throws Exception;

}
