package mk.ukim.finki.localfix.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomUsernamePasswordAuthenticationProvider authenticationProvider;

    public WebSecurityConfig(CustomUsernamePasswordAuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/problems/**", "/problem/**", "/publish/**", "/problems", "/logout", "/profile/**").authenticated()
                .antMatchers("/person/register", "/").permitAll()
                .antMatchers("/problems/administrator", "/publish/problem/**", "/problems/administrator/**").hasRole("ADMIN")
                //.anyRequest()
                //.authenticated()
                .and()
                .formLogin()
                .loginPage("/person/login").permitAll()
                .failureUrl("/person/login?error=BadCredentials")
                .defaultSuccessUrl("/problems", true)
                .and()
                .logout()
                .logoutUrl("/person/logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/person/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider);
    }
}
