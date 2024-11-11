package dto;

import lombok.Data;

@Data
public class PageDto {
	private Criteria cri;
	private int total;
	private int startPage;
	private int endPage;
	private int pageCount;
	
	//이전 이후 계산용 필드
	private boolean prev;
	private boolean next;
	private boolean doublePrev;
	private boolean doubleNext;
	
	
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
		endPage =(cri.getPage() + pageCount-1) /pageCount * pageCount;
		startPage = endPage-pageCount + 1;
		
		int realEnd = (total + cri.getAmount()-1) /cri.getAmount(); //실제로 끝나는 페이지의 수

		
		if(realEnd < endPage) {
			endPage = realEnd;
		}
		//왼쪽 아이콘이 안보일때
		prev = cri.getPage() > 1;
		//next가 안보일 때
		next = cri.getPage() < realEnd;
		//
		doublePrev = startPage > 1;
		doubleNext = endPage < realEnd;
		
	}
	public static void main(String[] args) {
	
		PageDto dto =new PageDto(255); //페이지 , 게시판 수
		System.out.println(dto);
		
	}

}
