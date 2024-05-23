package emaillist;

import java.util.Scanner;

import emaillist.dao.EmaillistDao;
import emaillist.dao.EmaillistVo;

public class EmailListApp {
	
	private static Scanner scanner = new Scanner(System.in);
	
	private static EmaillistDao dao = new EmaillistDao();

	public static void main(String[] args) {

		while(true) {
			System.out.println ("(l)ist (d)elete (i)nsert (q)uit > ");
			String command = scanner.nextLine();
			
			if ("l".equals(command)) {
				doList();
			}else if ("d".equals(command)) {
				doDelete();
			}else if ("i".equals(command)) {
				doInsert();
			}else if ("q".equals(command)) {
				break;
			}else {
				System.out.println("Invalid Command!!");
			}
		}
		
		if (scanner != null) {
			scanner.close();
		}
	
		
	}

	private static void doInsert() {
		System.out.println("성을 입력하세요: ");
		String firstName = scanner.nextLine();
		
		System.out.println("이름을 입력하세요: ");
		String lastName = scanner.nextLine();
		
		System.out.println("이메일을 입력하세요: ");
		String email = scanner.nextLine();
		
		EmaillistVo vo = new EmaillistVo(firstName,lastName,email);
		dao.insert(vo);
		
		doList();
		
		
		
		
		
	}

	private static void doDelete() {
		System.out.println("이메일을 입력하세요: ");
		
		String email = scanner.nextLine();
		dao.delete(email);
		doList();
		
	}

	private static void doList() {
		
		dao.findAll()
			.stream()
			.forEach(e->{
			System.out.println("이름:"+e.getFirstName()+e.getLastName()+" 이메일:"+e.getEmail());
		});

		
	}
}
