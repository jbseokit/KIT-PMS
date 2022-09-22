package kr.hkit.pms.mapper.common;

import org.apache.ibatis.annotations.Mapper;

import kr.hkit.pms.domain.common.Criteria;

@Mapper
public interface PageNumMapper {
	public int getTotalCount(Criteria cri);
}
