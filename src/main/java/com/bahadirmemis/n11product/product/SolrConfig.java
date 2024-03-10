package com.bahadirmemis.n11product.product;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

/**
 * @author bahadirmemis
 */
@Configuration
@EnableSolrRepositories(
    basePackages = "com.bahadirmemis.n11product"
    , namedQueriesLocation = "classpath:solr-named-queries.properties"
)
@ComponentScan
public class SolrConfig {

  @Bean
  public SolrClient solrClient(){
    return new HttpSolrClient.Builder("http://localhost:8983/solr").build();
  }

  @Bean
  public SolrTemplate solrTemplate(SolrClient solrClient){
    return new SolrTemplate(solrClient);
  }
}
