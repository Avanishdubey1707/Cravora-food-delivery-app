package in.putin.foodiesapi.service;

import org.springframework.security.core.Authentication;

public interface AuthenticationFacade {
     Authentication getAuthentication();
}
