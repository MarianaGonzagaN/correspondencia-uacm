package uacm.edu.mx.security.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import uacm.edu.mx.exception.SpringUserException;

@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint {

	private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		logger.error("Unauthorized error: {}", authException.getMessage());
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: No autorizado");
	}
	
	@ExceptionHandler(value = {AccessDeniedException.class})
	public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
	                     AccessDeniedException accessDeniedException) throws IOException {
	    logger.error("AccessDenied error: {}", accessDeniedException.getMessage());
	    httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
	    httpServletResponse.getWriter().write(convertObjectToJson(new SpringUserException("Error: No tiene privilegios para este recurso")));
	}


	public String convertObjectToJson(Object object) throws JsonProcessingException {
	    if (object == null) {
	        return null;
	    }
	    ObjectMapper mapper = new ObjectMapper();
	    return mapper.writeValueAsString(object);
	}

}
