package kr.hkit.domain.human;

import java.util.Date;

import lombok.Data;

@Data
public class AttendanceMgtDto {
	int idx;
	String atdNm;
	String atdSn;
	Date   atdGw;
	Date   ateLw;
	String atdBt;
	String atdBtDt;
	String atdBtCt;
	String atdDp;
	String atdDpDt;
	String spare1;
	String spare2;
	String spare3;
	String rgtrId;
	Date   rgtrDt;
	String mdfrId;
	Date   mdfrDt;
}
