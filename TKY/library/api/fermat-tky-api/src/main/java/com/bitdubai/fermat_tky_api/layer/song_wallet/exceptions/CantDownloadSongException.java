package com.bitdubai.fermat_tky_api.layer.song_wallet.exceptions;

import com.bitdubai.fermat_tky_api.all_definitions.exceptions.TKYException;

/**
 * Created by Manuel Perez (darkpriestrelative@gmail.com) on 15/03/16.
 */
public class CantDownloadSongException extends TKYException {

    public static final String DEFAULT_MESSAGE = "CANNOT DOWNLOAD SONG";

    public CantDownloadSongException(
            final String message,
            final Exception cause,
            final String context,
            final String possibleReason) {
        super(message, cause, context, possibleReason);
    }

    public CantDownloadSongException(
            Exception cause,
            String context,
            String possibleReason) {
        super(DEFAULT_MESSAGE , cause, context, possibleReason);
    }

    public CantDownloadSongException(
            final String message,
            final Exception cause) {
        this(message, cause, "", "");
    }

    public CantDownloadSongException(final String message) {
        this(message, null);
    }

    public CantDownloadSongException(final Exception exception) {
        this(exception.getMessage());
        setStackTrace(exception.getStackTrace());
    }

    public CantDownloadSongException() {
        this(DEFAULT_MESSAGE);
    }
}


