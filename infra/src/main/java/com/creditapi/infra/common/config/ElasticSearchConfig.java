package com.creditapi.infra.common.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import com.creditapi.infra.common.config.properties.ElasticSearchProperties;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@RequiredArgsConstructor
@EnableElasticsearchRepositories
public class ElasticSearchConfig {

    private final ElasticSearchProperties elasticSearchProperties;

    @Bean
    public ElasticsearchClient  initElasticsearchClient() {
        ElasticsearchTransport transport = new RestClientTransport(getRestClient(), new JacksonJsonpMapper());
        return new ElasticsearchClient(transport);
    }

    @Bean
    public RestClient getRestClient() {
        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,
                new UsernamePasswordCredentials(elasticSearchProperties.getUsername(), elasticSearchProperties.getPassword()));

        return RestClient.builder(new HttpHost(elasticSearchProperties.getHost(), elasticSearchProperties.getPort()))
                .setHttpClientConfigCallback(httpClientBuilder ->
                        httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider))
       .build();
}

}
