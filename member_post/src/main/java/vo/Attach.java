package vo;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Attach {
	private String uuid;
	private String origin;
	private String path;
	private	boolean image;
	private Long pno;
	
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		List<Attach> attachs = new ArrayList<Attach>();
		attachs.add(Attach.builder().uuid("abcd").origin("tmp.txt").build());
		attachs.add(Attach.builder().uuid("efsdfas").origin("tmp.png").build());
		
		System.out.println(attachs);
		
		String s =  new ObjectMapper().writeValueAsString(attachs);
		System.out.println(s);
	}
}
