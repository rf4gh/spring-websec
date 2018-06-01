# spring-websec
## - a Spring Boot application sample using Spring Security 5 andthymeleaf-extras-springsecurity4

This is a minimum Spring Boot 2 application with Spring Web MVC: an index HTML page and links to two dummy HTML pages page1 and page2. The view technology is Thymeleaf. The MVC configuration in WebMvcConfig.java is necessary to avoid having Java controller classes. The method configure(HttpSecurity) contains an example for using an `ObjectPostProcessor` , in this case to disable sending authorizedSuccess events.

The application is secured with Spring Security 5 as configured in SecurityConfig.java : in-memory with the following accounts:
| username | password | roles |
| --- | --- | --- |
| user | password | ROLE_USER |
| admin | password | ROLE_ADMIN, ROLE_USER |

The login page is contributed by spring-security-web .
