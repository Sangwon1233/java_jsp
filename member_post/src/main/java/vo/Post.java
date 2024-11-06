package vo;

import java.util.Date;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Post {
	 private final Long pno;
	 private final String title;
	 private final String writer;
	 private final String content;
	 private final Long viewCount;
	 private final Date regdate;
	 private final Date updatedate;
	 
//	 public Post() {}
//	 
//	 public Post(
//		private Long pno,
//		private String title,
//		private String writer,
//		private String content,
//		private Long view_count,
//		private Data regdate,
//		private Data updatedate)	 
//	 	{
//		 this.pno=pno;
//		 this.title=title;
//		 this.writer=writer;
//		 this.content=content;
//		 this.view_count=view_count;
//		 this.regdate=regdate;
//		 this.updatedate=updatedate;
//	 	}
//	 
//	 public static P builder() {
//		 return new P();
//	 }
//	 public static class P{
//		 Long pno;
//		 String title;
//		 String writer;
//		 String content;
//		 Long view_count;
//		 Date regdate;
//		 Date updatedate;
//		 
//		 public P pno(Long pno) {
//				this.pno = pno;
//				return this;
//			}
//		 public P title(String title) {
//			 this.title = title;
//			 return this;
//		 }
//		 public P writer(String writer) {
//			 this.writer = writer;
//			 return this;
//		 }
//		 public P content(String content) {
//			 this.content = content;
//			 return this;
//		 }
//		 public P view_count(Long view_count) {
//			 this.view_count = view_count;
//			 return this;
//		 }
//		 public P regdate(Date regdate) {
//			 this.regdate = regdate;
//			 return this;
//		 }
//		 public P updatedate(Date updatedate) {
//			 this.updatedate = updatedate;
//			 return this;
//		 }
//		 public Post build() {
//			 return new Post(pno,title,writer,content,view_count,regdate,updatedate);
//		 }
//		 
//	 }
}
