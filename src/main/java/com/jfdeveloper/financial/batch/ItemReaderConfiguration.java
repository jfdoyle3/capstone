package com.jfdeveloper.financial.batch;

import com.jfdeveloper.financial.entities.Dataset;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ItemReaderConfiguration {

  public ItemReader<Dataset> itemReader(DataSource dataSource){
	JdbcPagingItemReader<Dataset>
  }






}
