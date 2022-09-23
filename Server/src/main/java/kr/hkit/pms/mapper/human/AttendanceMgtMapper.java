package kr.hkit.pms.mapper.human;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.hkit.pms.domain.common.Criteria;
import kr.hkit.pms.domain.human.AttendMgtDto;

@Mapper
public interface AttendanceMgtMapper {
	public List<AttendMgtDto> readList(Criteria cri);
	public AttendMgtDto read();
	
	public void create(AttendMgtDto attend);
	
	public void update();
	
	public void delete();
}
