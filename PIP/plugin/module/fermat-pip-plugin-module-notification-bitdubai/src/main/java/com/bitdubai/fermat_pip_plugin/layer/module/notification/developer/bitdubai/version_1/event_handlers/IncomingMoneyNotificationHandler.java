package com.bitdubai.fermat_pip_plugin.layer.module.notification.developer.bitdubai.version_1.event_handlers;

import com.bitdubai.fermat_api.FermatException;
import com.bitdubai.fermat_api.Service;
import com.bitdubai.fermat_api.layer.all_definition.enums.ServiceStatus;
import com.bitdubai.fermat_pip_api.layer.pip_module.notification.interfaces.NotificationManagerMiddleware;
import com.bitdubai.fermat_pip_api.layer.pip_platform_service.event_manager.events.IncomingMoneyNotificationEvent;
import com.bitdubai.fermat_pip_api.layer.pip_platform_service.event_manager.interfaces.PlatformEvent;
import com.bitdubai.fermat_pip_api.layer.pip_platform_service.event_manager.interfaces.EventHandler;

/**
 * Created by Matias Furszyfer on 2015.08.18..
 */
public class IncomingMoneyNotificationHandler implements EventHandler {


    NotificationManagerMiddleware notificationManager;

    public IncomingMoneyNotificationHandler(final NotificationManagerMiddleware notificationManager) {
        this.notificationManager = notificationManager;
    }

    @Override
    public void handleEvent(PlatformEvent platformEvent) throws FermatException {

        IncomingMoneyNotificationEvent incomingMoneyNotificationEvent =(IncomingMoneyNotificationEvent)platformEvent;

        //NotificationEvent notificationEvent = new NotificationEvent();
        //notificationEvent.setAlertTitle(newNotificationEvent.getNotificationTitle());
        //notificationEvent.setTextTitle(newNotificationEvent.getNotificationTextTitle());
        //notificationEvent.setTextBody(newNotificationEvent.getNotificationTextBody());


        //TODO: falta ver si le seteo la activity (enum de las activities) o/y si le setio la public Key de la wallet


        System.out.println("PROBANDO EVENTO MATI, PARA NOTIFICACIONES");

        if (((Service) this.notificationManager).getStatus() == ServiceStatus.STARTED) {

            System.out.println("PROBANDO EVENTO MATI, PARA NOTIFICACIONES 2");
            //TODO: acá hay que implementar el add al pool de notificaciones
            notificationManager.addIncomingExtraUserNotification(incomingMoneyNotificationEvent.getSource(), incomingMoneyNotificationEvent.getWalletPublicKey(), incomingMoneyNotificationEvent.getAmount(), incomingMoneyNotificationEvent.getCryptoCurrency(), incomingMoneyNotificationEvent.getActorId(), incomingMoneyNotificationEvent.getActorType());
            //this.notificationManager.recordNavigationStructure(xmlText,link,filename,skinId);


        }

    }
}
