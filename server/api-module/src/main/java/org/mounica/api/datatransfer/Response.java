package org.mounica.api.datatransfer;

public class Response {
	public String token;
    public String role;

    public Response(final String token, final String role) {
        this.token = token;
        this.role = role;
    }

}
