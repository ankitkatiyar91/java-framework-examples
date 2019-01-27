package ask.bean;

import java.util.ArrayList;
import java.util.List;

public class BeanFactory {

	@SuppressWarnings("serial")
	public static List<Article> createBeanCollection(){
		List<Article> articles = new ArrayList<Article>();
		Article article;
		for (int i = 0; i < 4; i++) {
			article=new Article();
			article.setContent("content"+i);
			article.setName("name"+i);
			article.setRoles(new ArrayList<String>(){{add("l");add("l2");}});
			article.setUser("user"+i);
			articles.add(article);
		}
		return articles;
		
	}
}
