package vo;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	
}
