package com.entregas.nathy.adapter.exception.handler;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "ErrorResponse")
public class ErrorResponse {

    public String type;
    public String title;
    public int status;
    public String detail;
    public String instance;
}
