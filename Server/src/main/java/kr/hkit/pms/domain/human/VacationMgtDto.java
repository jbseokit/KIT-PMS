package kr.hkit.pms.domain.human;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VacationMgtDto {
	int idx;
	String vacNm;
	String vacSn;
	Date   vacStr;
	Date   vacEnd;
	String vacType;
	int    vacCnt;
	String spare1;
	String spare2;
	String spare3;
	String spare4;
	String rgtrId;
	Date   rgtrDt;
	String mdfrId;
	Date   mdfrDt;
}
