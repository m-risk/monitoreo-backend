package com.mrisk.monitoreo.infrastructure.point.db.springjdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.mrisk.monitoreo.application.repository.point.StorageRepository;
import com.mrisk.monitoreo.domain.point.Storage;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class StorageJdbcRepository implements StorageRepository {
	
	@Autowired
	private final JdbcTemplate jdbcTemplate;

	public List<Storage> getStorageAll(){
	  
		List<Storage> listStorage = new ArrayList<Storage>();
		return listStorage;
	}
	@Override
	public Storage findById(Integer id) {
		
		Storage storage = new Storage();
		storage.setId(1);
		storage.setName("Testing GIF");
		storage.setType("GIF");
		storage.setPointId(7);
		storage.setTenaId(1);
		return storage;
	}
	@Override
	public Storage save(Storage storage) {
	  
		final String sql = "INSERT INTO storage (tena_id, alive, creation_time, name, type, encoding, content_type, poin_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		final KeyHolder holder = new GeneratedKeyHolder();

      jdbcTemplate.update(new PreparedStatementCreator() {
    	  @Override
    	  public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
        	  
    		  final PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
              preparedStatement.setInt(1, storage.getTenaId());
              preparedStatement.setBoolean(2, storage.getAlive());
              preparedStatement.setTimestamp(3, new Timestamp(storage.getCreationTime().getTimeInMillis()));
              preparedStatement.setString(4, storage.getName());
              preparedStatement.setString(5, storage.getType());
              preparedStatement.setString(6, storage.getEncoding());
              preparedStatement.setString(7, storage.getContentType());
              preparedStatement.setInt(8, storage.getPointId());
              return preparedStatement;
          }
      }, holder);
      
      Storage storageNew = new Storage();
      
      Integer newId;
      if (holder.getKeys().size() > 1) {
          newId = (Integer)holder.getKeys().get("stor_id");
      } else {
          newId= holder.getKey().intValue();
      }
      
      storageNew.setId(newId);
      storageNew.setName(storage.getName());
      storageNew.setPointId(storage.getPointId());
      return storageNew;
  }
}