package kr.hkit.pms.service.human;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.hkit.pms.domain.human.*;
import kr.hkit.pms.mapper.human.*;

@Service
public class HumanResourcesServiceImpl implements HumanResourcesService {
	
	@Autowired
	HumanInfoMgtMapper hifmm;
	
	@Override
	public List<HumanInfoMgtDto> getList() {
		return hifmm.selectInfo();
	}

	
}
