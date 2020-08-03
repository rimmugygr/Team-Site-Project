package team.back.configuration;



import com.auth0.spring.security.api.JwtWebSecurityConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Value(value = "${auth0.apiAudience}")
    private String apiAudience;
    @Value(value = "${auth0.issuer}")
    private String issuer;



    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.cors();
        JwtWebSecurityConfigurer
                .forRS256(apiAudience,issuer)
                .configure(http)
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/post**").permitAll()
                .antMatchers("/runner").permitAll()
                .antMatchers("/runner/**").permitAll()
                .mvcMatchers("/race**").authenticated()
                .mvcMatchers("/race/start").authenticated()
                .mvcMatchers("/race/start/**/**").authenticated()
                .antMatchers(HttpMethod.POST, "/post**").authenticated()
                .anyRequest().authenticated();

    }
}
