package kr.hkit.domain.human;

import java.util.Date;

import lombok.Data;

@Data
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
