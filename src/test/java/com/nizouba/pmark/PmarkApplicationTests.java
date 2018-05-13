package com.nizouba.pmark;

import lombok.Getter;
import lombok.Setter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.plaf.ScrollPaneUI;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PmarkApplicationTests {

	@Test
	public void contextLoads() {

		class A{
			int userId;
			int createId;

			public A(int userId, int createId) {
				this.userId = userId;
				this.createId = createId;
			}
		}

		List<A> list = new ArrayList<>();

		list.add(new A(1,2));
		list.add(new A(2,2));
		list.add(new A(3,2));
		list.add(new A(4,2));
		list.add(new A(5,2));
		list.add(new A(6,2));

		System.out.println(1);
	}


}
