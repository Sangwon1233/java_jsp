package vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Reply {
	 private final Long rno;
	 private final String content;
	 private final Date regdate;
	 private final Date updatedate;
	 private boolean hideen;
	 private int likes;
	 private String writer;
	 private Long pno;
	 

}
