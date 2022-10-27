package kr.kwangan2.test;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kwangan2.domain.Author;

public class BlogTest {
	public static void main(String[] args) {
		String resource = "kr/kwangan2/conf/sqlMapConfig.xml";
		Reader reader;
		SqlSession session = null;
		try {
			reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			session = sqlMapper.openSession();

//			List<Blog> blogs = session.selectList("selectBlog");
//
//			for (Blog blog : blogs) {
//				System.out.println("--------------------------------------");
//				System.out.println("blog id : " + blog.getBlogId());
//				Author author = blog.getAuthor();
//				System.out.println("\t" + author);
//				List<Comm> comms = blog.getComms();
//				for (Comm comm : comms) {
//					System.out.println("\t" + comm);
//				}
//				System.out.println("--------------------------------------");
//			}
			/* insert */
			Author author = new Author();
			author.setAuthorName("innnnnnsert name");
			int result = session.insert("insertAuthor", author);
			System.out.println("--------------------------------------");
			if (result > 0) {
				System.out.println(author + "입력 성공!!");
			}
			session.commit();

			// update
//			Author author2 = new Author();
//			author2.setAuthorId(2);
//			author2.setAuthorName("uppppppppppdate name");
//			int result2 = session.update("updateAuthor", author2);
//			session.commit();
//			if (result2 > 0) {
//				System.out.println("2번 수정 완료!!");
//			}
//			
			
//			//Author delete
//			Author author = new Author();
//			int result2= session.delete("deleteAuthor",2);
//			session.commit();
//			if(result2>0) {
//				System.out.println("2번 캇!!!!!!!!!!!!!!!!!!!!!!!!!!");
//			}

//			CommSearcher commSearcher = new CommSearcher();
//			commSearcher.setBlogId(2);
//			commSearcher.setSearchkey("content");
//			commSearcher.setSearchValue("comm");
//			List<Comm> comms = session.selectList("selectCommsByBlogId", commSearcher);
//			for (Comm comm : comms) {
//				System.out.println(comm);
//			}
//			Comm comm = new Comm();
//			comm.setCommId(1);
//			comm.setCommTitle("update title");
//			comm.setCommContent("update content");
//			comm.setFkBlogId(1);
//			int result = session.update("updateComm", comm);
//			if (result > 0) {
//				System.out.println("업데이트 성공");
//			}
//			ArrayList<Integer> commIdlist = new ArrayList<Integer>();
//			commIdlist.add(2);// blog_id
//			commIdlist.add(2);
//			commIdlist.add(3);
//			commIdlist.add(21);
//			List<Comm> commList = session.selectList("selectCommsByCommIds", commIdlist);
//			for (Comm comm2 : commList) {
//				System.out.println(comm2);
//			}
//			session.commit();
		} catch (Exception e) {
//			session.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}
}// class