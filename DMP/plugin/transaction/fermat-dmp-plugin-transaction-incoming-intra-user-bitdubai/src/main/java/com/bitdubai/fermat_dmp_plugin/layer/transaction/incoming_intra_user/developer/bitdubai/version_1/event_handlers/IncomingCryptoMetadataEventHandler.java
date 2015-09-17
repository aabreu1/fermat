package com.bitdubai.fermat_dmp_plugin.layer.transaction.incoming_intra_user.developer.bitdubai.version_1.event_handlers;

import com.bitdubai.fermat_api.FermatException;
import com.bitdubai.fermat_api.Service;
import com.bitdubai.fermat_api.layer.dmp_transaction.TransactionServiceNotStartedException;
import com.bitdubai.fermat_api.layer.dmp_transaction.incoming_intra_user.IncomingIntraUserManager;
import com.bitdubai.fermat_api.layer.all_definition.enums.ServiceStatus;
import com.bitdubai.fermat_dmp_plugin.layer.transaction.incoming_intra_user.developer.bitdubai.version_1.structure.IncomingIntraUserEventRecorderService;
import com.bitdubai.fermat_pip_api.layer.pip_platform_service.event_manager.interfaces.PlatformEvent;
import com.bitdubai.fermat_pip_api.layer.pip_platform_service.event_manager.interfaces.EventHandler;

/**
 * Created by loui on 23/02/15.
 */
public class IncomingCryptoMetadataEventHandler implements EventHandler {
    IncomingIntraUserEventRecorderService incomingIntraUserEventRecorderService;

    public IncomingCryptoMetadataEventHandler(IncomingIntraUserEventRecorderService incomingIntraUserEventRecorderService){
        this.incomingIntraUserEventRecorderService = incomingIntraUserEventRecorderService;
    }
    
    @Override
    public void handleEvent(PlatformEvent platformEvent) throws FermatException {
        if (this.incomingIntraUserEventRecorderService.getServiceStatus().equals(ServiceStatus.STARTED))
            this.incomingIntraUserEventRecorderService.saveEvent(platformEvent);
        else
            throw new TransactionServiceNotStartedException();
    }
}
