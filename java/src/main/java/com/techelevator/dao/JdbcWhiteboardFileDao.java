package com.techelevator.dao;

import com.techelevator.model.WhiteboardFile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcWhiteboardFileDao implements WhiteboardFileDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcWhiteboardFileDao(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    @Override
    public WhiteboardFile getFileById(int fileId) {
        String sql =
                "SELECT file_id, file_name, file_path " +
                "FROM whiteboard_file " +
                "WHERE file_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, fileId);

        WhiteboardFile fileToReturn = mapRowToWhiteboardFile(results);

        return fileToReturn;

    }

    @Override
    public WhiteboardFile getFileByName(String fileName) {
        String sql =
                "SELECT file_id, file_name, file_path " +
                        "FROM whiteboard_file " +
                        "WHERE file_name = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, fileName);

        WhiteboardFile fileToReturn = mapRowToWhiteboardFile(results);

        return fileToReturn;

    }

    @Override
    public WhiteboardFile addFile(WhiteboardFile file) {

        String sql = "INSERT INTO whiteboard_file(file_name,file_path) " +
                     "VALUES (?,?)";
        jdbcTemplate.update(sql, file.getFileName(), file.getFilePath());

        return this.getFileByName(file.getFileName());

    }

    WhiteboardFile mapRowToWhiteboardFile(SqlRowSet rs) {
        WhiteboardFile whiteboardFile = new WhiteboardFile();
        whiteboardFile.setFileId(rs.getInt("file_id"));
        whiteboardFile.setFileName(rs.getString("file_name"));
        whiteboardFile.setFilePath(rs.getString("file_path"));
        return whiteboardFile;
    }
}
