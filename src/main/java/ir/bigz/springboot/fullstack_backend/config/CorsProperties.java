package ir.bigz.springboot.fullstack_backend.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "web.cors")
public record CorsProperties (
        List<String> allowedOrigins,
        List<String> allowedHeaders,
        List<String> exposedHeaders,
        boolean allowCredentials,
        Map<String, String> allowedMethods,
        long maxAge) {
}

