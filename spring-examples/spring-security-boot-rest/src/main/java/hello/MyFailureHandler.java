package hello;

import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class MyFailureHandler extends SimpleUrlAuthenticationFailureHandler {

}
