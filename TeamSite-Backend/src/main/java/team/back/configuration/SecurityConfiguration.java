package team.back.configuration;

import com.auth0.spring.security.api.JwtWebSecurityConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Value(value = "${auth0.apiAudience}")
    private String apiAudience;
    @Value(value = "${auth0.issuer}")
    private String issuer;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        JwtWebSecurityConfigurer
                .forRS256(apiAudience,issuer)
                .configure(http)
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/post**").permitAll()
                .antMatchers("/runner").permitAll()
                .antMatchers("/runner/**").permitAll()
                .antMatchers("/race**").permitAll()
                .antMatchers("/race/start").permitAll()
                .antMatchers("/race/start/**/**").permitAll()
                .antMatchers(HttpMethod.POST, "/post**").permitAll()
                .anyRequest().authenticated();

    }
}
