package perondi.BeShuffle.dtos.login;

import feign.form.FormProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class LoginRequest {

    @FormProperty("grant_type")
    private String grantType;

    @FormProperty("client_id")
    private String clientId;

    @FormProperty("client_secret")
    private String clientSecret;
}
