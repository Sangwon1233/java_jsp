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
public class Post {
	 private final Long pno;
	 private final String title;
	 private final String writer;
	 private final String content;
	 private final Long viewCount;
	 private final Date regdate;
	 private final Date updatedate;
	 private final int  cno;
	 private final boolean  attachFlag;
	 
	 @Builder.Default
	 private List<Attach> attachs = new ArrayList<>(); //얘는 파이널 붙이면 안됨 셋터 써야함 대조해야함

	public Post(Long pno, String title, String writer, String content, Long viewCount, Date regdate, Date updatedate,
			int cno,boolean attachFlag) {
		super();
		this.pno = pno;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.viewCount = viewCount;
		this.regdate = regdate;
		this.updatedate = updatedate;
		this.cno = cno;
		this.attachFlag = attachFlag;
	}
	 

}

