package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityJavaConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
	@Autowired
	private MySavedRequestAwareAuthenticationSuccessHandler mySuccessHandler;
	@Autowired
	private AuthenticationFailureHandler myFailureHandler;
	@Autowired
	private MyUserDetailsService userDetailsService;

	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
	   /* auth.inMemoryAuthentication()
	        .withUser("admin").password(encoder().encode("adminPass")).roles("ADMIN")
	        .and()
	        .withUser("user").password(encoder().encode("userPass")).roles("USER");*/
		auth.userDetailsService(userDetailsService);
	}
	 
	@Bean
	public PasswordEncoder  encoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception { 
		http.csrf().disable()
        .authorizeRequests()
        .and()
        .exceptionHandling()
        .authenticationEntryPoint(restAuthenticationEntryPoint)
        .and()
        .authorizeRequests()
        .antMatchers("/api/admin/**").hasRole("ADMIN")
        .and()
        .formLogin()
        .successHandler(mySuccessHandler)
        .failureHandler(myFailureHandler)
        .and()
        .httpBasic()
        .and()
        .logout();	
	}
}
