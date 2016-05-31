package com.bookshop.config;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by
 *
 * @author ivan
 *         On 5/31/16
 */

@Configuration
@EntityScan("com.bookshop.domain")
@EnableJpaRepositories("com.bookshop.repository")
public class JpaConfig {
}
