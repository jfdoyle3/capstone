package com.jfdeveloper.financial.batch;

import com.jfdeveloper.financial.entities.Dataset;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.support.MySqlPagingQueryProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ItemReaderConfiguration {

  @Bean
  public ItemReader<Dataset> itemReader(DataSource dataSource){

      JdbcPagingItemReader<Dataset> jdbcPagingItemReader=new JdbcPagingItemReader<>();
      jdbcPagingItemReader.setDataSource(dataSource);
      jdbcPagingItemReader.setPageSize(1000);



      return null;
  }
  private PagingQueryProvider createQuery(){
      MySqlPagingQueryProvider queryProvider=new MySqlPagingQueryProvider();
      queryProvider.setSelectClause("SELECT *");
      queryProvider.setFromClause("FROM DATASET");


      return null;
  }

  private Map<String>




}
