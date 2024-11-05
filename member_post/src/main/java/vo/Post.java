package vo;

import java.util.Date;
import lombok.Data;
import vo.Member.M;

@Data
public class Post {
	 private int pno;
	 private String title;
	 private String writer;
	 private String content;
	 private int view_count;
	 private Date regdate;
	 private Date updatedate;
	 
	 public Post() {}
	 
	 public Post(
		private int pno,
		private String title,
		private String writer,
		private String content,
		private int view_count,
		private Data regdate,
		private Data updatedate)
			 
	 {
		 this.pno=pno;
		 this.title=title;
		 this.writer=writer;
		 this.content=content;
		 this.view_count=view_count;
		 this.regdate=regdate;
		 this.updatedate=updatedate;
	 	}
	 
	 public static P builder() {
		 return new P();
	 }
	 public static class P{
		 int pno;
		 String title;
		 String writer;
		 String content;
		 int view_count;
		 Date regdate;
		 Date updatedate;
		 
		 public P pno(int pno) {
				this.pno = pno;
				return this;
			}
		 public P title(String title) {
			 this.title = title;
			 return this;
		 }
		 public P writer(String writer) {
			 this.writer = writer;
			 return this;
		 }
		 public P content(String content) {
			 this.content = content;
			 return this;
		 }
		 public P view_count(int view_count) {
			 this.view_count = view_count;
			 return this;
		 }
		 public P regdate(Date regdate) {
			 this.regdate = regdate;
			 return this;
		 }
		 public P updatedate(Date updatedate) {
			 this.updatedate = updatedate;
			 return this;
		 }
		 public Post build() {
			 return new Post(pno,title,writer,content,view_count,regdate,updatedate);
		 }
		 
	 }
}
