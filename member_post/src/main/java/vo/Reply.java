package vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reply {
	 private Long rno;
	 private String content;
	 private Date regdate;
	 private Date updatedate;
	 private boolean hideen;
	 private int likes;
	 private String writer;
	 private Long pno;
	 

}
