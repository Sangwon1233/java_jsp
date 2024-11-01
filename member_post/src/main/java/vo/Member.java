package vo;

import java.util.Date;

import lombok.Data;

@Data
public class Member {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String readAddr;
	private String detailAddr;
	private Date regdate;
}
