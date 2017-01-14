package com.bonespike.sju;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.requireNonNull;

/**
 * Created by bonespike on 1/10/17.
 */
@Data
public class ApiGatewayResponse {

    static Gson gson = new GsonBuilder().setPrettyPrinting().create();




    public ApiGatewayResponse(){this("");};

    public ApiGatewayResponse(Object body){
        this(body, new HashMap<String, String>(), 200, false);
    }

    public ApiGatewayResponse(@javax.annotation.Nullable Object body, @Nonnull Map<String, String> headers,
                              int statusType, boolean base64Encoded) {
        requireNonNull(headers);
        requireNonNull(statusType);
        this.statusCode = statusType;
        this.body = gson.toJson(body);
        this.headers = Collections.unmodifiableMap(new HashMap<>(headers));
        this.base64Encoded = base64Encoded;

    }

    private String body;
    private Map<String, String> headers;
    private int statusCode;
    private boolean base64Encoded;

}
