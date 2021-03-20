package com.ekosutrisno.searching.exceptions;

import java.util.Date;

/**
 * @author Eko Sutrisno
 * Saturday, 20/03/2021 9:31
 */
public class ExceptionHandlingResponse<T> {
    private int statusCode;
    private String status;
    private Date timestamp;
    private T error;

    public ExceptionHandlingResponse(int statusCode, String status, Date timestamp, T error) {
        this.statusCode = statusCode;
        this.status = status;
        this.timestamp = timestamp;
        this.error = error;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public T getError() {
        return error;
    }

    public void setError(T error) {
        this.error = error;
    }
}
