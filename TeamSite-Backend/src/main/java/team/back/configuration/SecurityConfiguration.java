package team.back.configuration;


//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
//import org.springframework.security.oauth2.core.OAuth2TokenValidator;
//import org.springframework.security.oauth2.jwt.*;

//
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Value("${auth0.audience}")
//    private String audience;
//
//    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
//    private String issuer;
//
//    @Bean
//    JwtDecoder jwtDecoder() {
//        NimbusJwtDecoder jwtDecoder = (NimbusJwtDecoder)
//                JwtDecoders.fromOidcIssuerLocation(issuer);
//
//        OAuth2TokenValidator<Jwt> audienceValidator = new AudienceValidator(audience);
//        OAuth2TokenValidator<Jwt> withIssuer = JwtValidators.createDefaultWithIssuer(issuer);
//        OAuth2TokenValidator<Jwt> withAudience = new DelegatingOAuth2TokenValidator<>(withIssuer, audienceValidator);
//
//        jwtDecoder.setJwtValidator(withAudience);
//
//        return jwtDecoder;
//    }
//
//
//
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .mvcMatchers(HttpMethod.GET, "/post**").authenticated()//post view for all
//                .mvcMatchers(HttpMethod.POST, "/post**").authenticated() //post add for memeber
//                .mvcMatchers("/runner**").authenticated()
//                .mvcMatchers("/runner/show**").permitAll()
//                .mvcMatchers("/race**").authenticated()
//                .mvcMatchers("/race/start").authenticated()
//                .mvcMatchers("/race/start/**/**").authenticated()
//
//                //.mvcMatchers("/api/private-scoped").hasAuthority("SCOPE_read:messages")
//                .and()
//                .oauth2ResourceServer().jwt();
//    }
//}


//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.oauth2ResourceServer().jwt();
//    }
//}
//
//


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


//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
//        configuration.setAllowedMethods(Arrays.asList("GET","POST"));
//        configuration.setAllowCredentials(true);
//        configuration.addAllowedHeader("Authorization");
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }



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
