package com.jfdeveloper.financial.batch.configutation;

import com.jfdeveloper.financial.entities.DatasetHistory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class ItemWriterConfiguration {

  @Bean
  public ItemWriter<DatasetHistory> itemWriter(NamedParameterJdbcTemplate jdbcTemplate){
	 final String INSERT_QUERY="INSERT INTO DATASET_HISTORY (";
	JdbcBatchItemWriter<DatasetHistory> itemWriter=new JdbcBatchItemWriter<>();

	itemWriter.setSql(INSERT_QUERY);
	itemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
	itemWriter.setJdbcTemplate(jdbcTemplate);
	itemWriter.setAssertUpdates(false);

	return itemWriter;
  }
}
