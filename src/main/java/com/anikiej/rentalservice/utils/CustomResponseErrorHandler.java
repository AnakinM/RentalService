package com.anikiej.rentalservice.utils;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;

@Component
public class CustomResponseErrorHandler extends DefaultResponseErrorHandler {

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if (response.getStatusCode().is4xxClientError() || response.getStatusCode().is5xxServerError()) {
            throw HttpClientErrorException.create(response.getStatusCode(), response.getStatusText(),
                    response.getHeaders(), null, null);
        }
    }
}
