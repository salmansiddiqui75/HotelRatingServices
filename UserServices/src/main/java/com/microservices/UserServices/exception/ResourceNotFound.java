package com.microservices.UserServices.exception;

public class ResourceNotFound extends RuntimeException
{
    public ResourceNotFound()
    {
        super("Resource not found on server");
    }
    public ResourceNotFound(String message)
    {
        super(message);
    }
}
