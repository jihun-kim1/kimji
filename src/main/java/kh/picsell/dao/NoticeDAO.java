package kh.picsell.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.picsell.dto.NoticeDTO;

@Repository
public class NoticeDAO {
	@Autowired
	private SqlSessionTemplate jdbc;

	
	// notice 리스트 출력
	public List<NoticeDTO> selectAll(){
		return jdbc.selectList("Notice.selectAll");
	}
}
