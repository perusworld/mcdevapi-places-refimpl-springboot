package com.yosanai.web;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.mastercard.api.core.ApiConfig;
import com.mastercard.api.core.security.oauth.OAuthAuthentication;

@Component
@ConfigurationProperties
public class MastercardApiConfig {

	@Value("${mastercard.api.consumer.key}")
	private String consumerKey;

	@Value("${mastercard.api.key.alias}")
	private String keyAlias;

	@Value("${mastercard.api.keystore.password}")
	private String keyPassword;

	@Value("${mastercard.api.p12.path}")
	private Resource p12Path;

	@Value("${mastercard.api.sandbox}")
	private boolean sandbox;

	@Value("${mastercard.api.debug}")
	private boolean debug;

	@PostConstruct
	public void setupApiConfiguration() throws Exception {

		ApiConfig.setDebug(debug);
		ApiConfig.setSandbox(sandbox);

		ApiConfig.setAuthentication(
				new OAuthAuthentication(consumerKey, p12Path.getInputStream(), keyAlias, keyPassword));
	}
}
