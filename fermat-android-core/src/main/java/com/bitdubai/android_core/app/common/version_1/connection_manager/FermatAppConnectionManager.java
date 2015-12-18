package com.bitdubai.android_core.app.common.version_1.connection_manager;

import android.app.Activity;

import com.bitdubai.fermat_android_api.layer.definition.wallet.interfaces.AppConnections;
import com.bitdubai.fermat_ccp_api.layer.module.intra_user.interfaces.IntraUserLoginIdentity;
import com.bitdubai.fermat_dap_android_sub_app_asset_factory_bitdubai.app_connection.AssetFactoryFermatAppConnection;
import com.bitdubai.fermat_dap_android_sub_app_asset_issuer_community_bitdubai.app_connection.CommunityAssetIssuerFermatAppConnection;
import com.bitdubai.fermat_dap_android_sub_app_asset_issuer_identity_bitdubai.app_connection.AssetIssuerFermatAppConnection;
import com.bitdubai.fermat_dap_android_sub_app_asset_user_community_bitdubai.app_connection.CommunityAssetUserFermatAppConnection;
import com.bitdubai.fermat_dap_android_sub_app_asset_user_identity_bitdubai.app_connection.AssetUserFermatAppConnection;
import com.bitdubai.fermat_dap_android_sub_app_redeem_point_community_bitdubai.app_connection.CommunityRedeemPointFermatAppConnection;
import com.bitdubai.fermat_dap_android_sub_app_redeem_point_identity_bitdubai.app_connection.RedeemPointFermatAppConnection;
import com.bitdubai.fermat_dap_android_wallet_asset_issuer_bitdubai.app_connection.WalletAssetIssuerFermatAppConnection;
import com.bitdubai.fermat_dap_android_wallet_asset_user_bitdubai.app_connection.WalletAssetUserFermatAppConnection;
import com.bitdubai.fermat_dap_android_wallet_redeem_point_bitdubai.app_connection.WalletRedeemPointFermatAppConnection;
import com.bitdubai.fermat_dap_api.layer.dap_identity.asset_issuer.interfaces.IdentityAssetIssuer;
import com.bitdubai.fermat_dap_api.layer.dap_identity.asset_user.interfaces.IdentityAssetUser;
import com.bitdubai.fermat_dap_api.layer.dap_identity.redeem_point.interfaces.RedeemPointIdentity;
import com.bitdubai.reference_niche_wallet.bitcoin_wallet.app_connection.BitcoinWalletFermatAppConnection;
import com.bitdubai.sub_app.crypto_broker_community.app_connection.CryptoBrokerCommunityFermatAppConnection;
import com.bitdubai.sub_app.developer.app_connection.DeveloperFermatAppConnection;
import com.bitdubai.sub_app.intra_user_community.app_connection.CryptoWalletUserCommunityFermatAppConnection;
import com.bitdubai.sub_app.intra_user_identity.app_connection.CryptoWalletUserFermatAppConnection;

/**
 * Created by Matias Furszyfer on 2015.12.09..
 */
public class FermatAppConnectionManager {


    public static AppConnections getFermatAppConnection(
            String publicKey,
            Activity activity,
            IntraUserLoginIdentity intraUserLoginIdentity,
            IdentityAssetIssuer identityAssetIssuer,
            IdentityAssetUser identityAssetUser,
            RedeemPointIdentity redeemPointIdentity) {

        switch (publicKey){
            //CCP WALLET
            case "reference_wallet":                        return new BitcoinWalletFermatAppConnection(activity,intraUserLoginIdentity);
            //CCP Sub Apps
            case "public_key_ccp_intra_user_identity":      return new CryptoWalletUserFermatAppConnection(activity);
            case "public_key_intra_user_commmunity":        return new CryptoWalletUserCommunityFermatAppConnection(activity);

            case "test_wallet":                             return null;//return new com.bitdubai.fermat_dmp_android_clone_reference_nich_wallet.fragmentFactory.ReferenceWalletFragmentFactory();

            case "crypto_broker_wallet":                    //fermatAppConnection = new CryptoBrokerWalletFragmentFactory();
                return null;
            case "crypto_customer_wallet":
//                fermatAppConnection = CryptoCustomerWalletFragmentFactory();
                break;

            //DAP WALLETS
            case "asset_issuer" :                           return new WalletAssetIssuerFermatAppConnection(activity, identityAssetIssuer);
            case "asset_user"   :                           return new WalletAssetUserFermatAppConnection(activity, identityAssetUser);
            case "redeem_point" :                           return new WalletRedeemPointFermatAppConnection(activity, redeemPointIdentity);
            //DAP Sub Apps
            case "public_key_dap_asset_issuer_identity":    return new AssetIssuerFermatAppConnection(activity);
            case "public_key_dap_asset_user_identity":      return new AssetUserFermatAppConnection(activity);
            case "public_key_dap_redeem_point_identity":    return new RedeemPointFermatAppConnection(activity);
            case "public_key_dap_factory":                  return new AssetFactoryFermatAppConnection(activity);
            case "public_key_dap_issuer_community":         return new CommunityAssetIssuerFermatAppConnection(activity);
            case "public_key_dap_user_community":           return new CommunityAssetUserFermatAppConnection(activity);
            case "public_key_dap_reedem_point_community":   return new CommunityRedeemPointFermatAppConnection(activity);

            //PIP Sub Apps
            case "public_key_pip_developer_sub_app":        return new DeveloperFermatAppConnection(activity);

            //CBP Sub Apps
            case "sub_app_crypto_broker_community":         return new CryptoBrokerCommunityFermatAppConnection(activity);
        }
        return null;
    }


}
