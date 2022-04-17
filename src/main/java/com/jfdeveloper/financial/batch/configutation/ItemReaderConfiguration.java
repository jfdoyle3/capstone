package com.jfdeveloper.financial.batch.configutation;

import com.jfdeveloper.financial.entities.Dataset;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.Order;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.support.MySqlPagingQueryProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ItemReaderConfiguration {

  @Bean
  public ItemReader<Dataset> itemReader(DataSource dataSource){

      JdbcPagingItemReader<Dataset> jdbcPagingItemReader=new JdbcPagingItemReader<>();
      jdbcPagingItemReader.setDataSource(dataSource);
      jdbcPagingItemReader.setPageSize(1000);

      PagingQueryProvider queryProvider=createQuery();
      jdbcPagingItemReader.setQueryProvider(queryProvider);
      jdbcPagingItemReader.setRowMapper((new BeanPropertyRowMapper<>(Dataset.class)));

      return jdbcPagingItemReader;
  }
  private PagingQueryProvider createQuery(){
      MySqlPagingQueryProvider queryProvider=new MySqlPagingQueryProvider();
      queryProvider.setSelectClause("SELECT *");
      queryProvider.setFromClause("FROM DATASET");
      queryProvider.setSortKeys(sortByCreationDate());


      return null;
  }

  private Map<String,Order> sortByCreationDate(){
    Map<String,Order> stringOrderMap=new LinkedHashMap<>();
    stringOrderMap.put("CREATION DATE", Order.ASCENDING);
    return stringOrderMap;
  }




}
