package logex.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@ResponseBody
	@GetMapping("/main")
	public String message() {
		return "안녕";
	}
	
	
	// 기본 설정 대로라면 Message Converter가 없어서 변환이 안된다
	@ResponseBody
	@GetMapping("/user")
	public UserVo userVo() {
		return new UserVo(1L,"hi");
	}
	
	
	public static class UserVo{
		public UserVo(Long no,String name) {
			this.no = no;
			this.name = name;
		}
		private Long no;
		private String name;
		public Long getNo() {
			return no;
		}
		public void setNo(Long no) {
			this.no = no;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	}
	
}
