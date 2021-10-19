package io.gjorovski.noteit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

/**
 * @author Borjan Gjorovski
 * @version 1.0
 * @created 08/10/2021 - 11:59 PM
 * @project mindware
 */
@Configuration
public class WebLoggingConfiguration {

    @Bean
    public CommonsRequestLoggingFilter commonsRequestLoggingFilter() {
        CommonsRequestLoggingFilter commonsRequestLoggingFilter = new CommonsRequestLoggingFilter();
        commonsRequestLoggingFilter.setIncludeQueryString(true);
        commonsRequestLoggingFilter.setIncludePayload(true);
        commonsRequestLoggingFilter.setIncludeClientInfo(true);
        commonsRequestLoggingFilter.setMaxPayloadLength(10000);

        return commonsRequestLoggingFilter;
    }
}
