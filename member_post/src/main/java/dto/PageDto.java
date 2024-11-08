package dto;

import lombok.Data;

@Data
public class PageDto {
	private Criteria cri;
	private int total;
	private int startpage;
	private int endpage;
	private int pageCount;
	
	
	//오버로딩
	public  PageDto(int total) {
		this(new Criteria(),total);
	}
	
	
	public  PageDto(Criteria cri, int total) {
		this(cri, total, 10);
	}		
	
	
	public  PageDto(Criteria cri, int total,int pageCount) {
		this.cri = cri;
		this.total=total;
		this.pageCount=pageCount;
		endpage =(cri.getPage() + pageCount-1) /pageCount * pageCount;
		startpage = endpage-pageCount + 11;
		
		int realEnd = (total + cri.getAmount()-1) /cri.getAmount(); //실제로 끝나는 페이지의 수
		System.out.println(realEnd);
		
		if(realEnd < endpage) {
			endpage = realEnd;
		}
		
		
		
	}
	public static void main(String[] args) {
	
		PageDto dto =new PageDto(255); //페이지 , 게시판 수
		System.out.println(dto);
		
	}

}
