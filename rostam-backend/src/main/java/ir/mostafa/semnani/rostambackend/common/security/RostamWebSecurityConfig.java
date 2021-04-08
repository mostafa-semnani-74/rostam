package ir.mostafa.semnani.rostambackend.common.security;


import ir.mostafa.semnani.rostambackend.common.security.jwt.JwtRequestFilter;
import ir.mostafa.semnani.rostambackend.common.security.jwt.RostamUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class RostamWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    JwtRequestFilter jwtRequestFilter;
    @Autowired
    RostamUserDetailsService rostamUserDetailsService;
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(rostamUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public JwtRequestFilter authenticationTokenFilterBean() throws Exception {
        return new JwtRequestFilter();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(rostamUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                cors()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers("/authenticate").permitAll()
                .antMatchers("/admin/**").hasAuthority("role_admin")
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        ;
        http
                .addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class)
        ;
    }

    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
        webSecurity
                .ignoring()
                .antMatchers(
                        HttpMethod.POST,
                        "/authenticate"
                )
                .antMatchers(HttpMethod.OPTIONS, "/**")
        ;

    }
}
