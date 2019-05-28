package co.vincent.brdlibrary.dto;

public class JsonWebToken {
    private final String token;

    public JsonWebToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}