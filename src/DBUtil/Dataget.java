package DBUtil;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.*;


public class Dataget {

	public static Huser getUserByEmail(String email) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Huser u " + "where u.useremail=:useremail";
		TypedQuery<Huser> q = em.createQuery(qString, Huser.class);
		q.setParameter("useremail", email);
		Huser user = null;
		try {
			user = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return user;
	}
	
	public static Hmajor getMajorByMajorName(String majorname) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Hmajor u " + "where u.majorname=:majorname";
		TypedQuery<Hmajor> q = em.createQuery(qString, Hmajor.class);
		q.setParameter("majorname", majorname);
		Hmajor major = null;
		try {
			major = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return major;
	}
	
	public static Hstudent getStudentByUserid(long userid) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Hstudent u " + "where u.huser.userid=:userid";
		TypedQuery<Hstudent> q = em.createQuery(qString, Hstudent.class);
		q.setParameter("userid", userid);
		Hstudent user = null;
		try {
			user = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return user;
	}
	
	public static Hinstructor getInstructorByUserid(long userid) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Hinstructor u " + "where u.huser.userid=:userid";
		TypedQuery<Hinstructor> q = em.createQuery(qString, Hinstructor.class);
		q.setParameter("userid", userid);
		Hinstructor user = null;
		try {
			user = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return user;
	}
	
	
	
	public static Huser getUserByName(String name) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Huser u where u.username = :name";
		TypedQuery<Huser> q = em.createQuery(qString, Huser.class);
		q.setParameter("name", name);
		Huser user = null;
		try {
			user = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return user;
	}
	
	public static Hclass getClassByClassid(long classid) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Hclass u where u.classid =:classid";
		TypedQuery<Hclass> q = em.createQuery(qString, Hclass.class);
		q.setParameter("classid", classid);
		Hclass user = null;
		try {
			user = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return user;
	}

	public static Hstudent getStudentByStudentid(long studentid) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Hstudent u where u.studentid =:studentid";
		TypedQuery<Hstudent> q = em.createQuery(qString, Hstudent.class);
		q.setParameter("studentid", studentid);
		Hstudent user = null;
		try {
			user = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return user;
	}
	public static Hinstructor getInstructorByInstructorid(long instructorid) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Hinstructor u where u.instructorid =:instructorid";
		TypedQuery<Hinstructor> q = em.createQuery(qString, Hinstructor.class);
		q.setParameter("instructorid", instructorid);
		Hinstructor user = null;
		try {
			user = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return user;
	}
	
	public static Hstudentclassbridge getstudentclassbridgeBytwoids(long classid, long studentid) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Hstudentclassbridge u where u.hclass.classid =:classid and u.hstudent.studentid=:studentid";
		TypedQuery<Hstudentclassbridge> q = em.createQuery(qString, Hstudentclassbridge.class);
		q.setParameter("classid", classid);
		q.setParameter("studentid", studentid);
		Hstudentclassbridge user = null;
		try {
			user = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return user;
	}
	
	public static boolean isValidUser(String email, String pass)
	{
		EntityManager em=DBUtil.getEmFactory().createEntityManager();
		String qString="Select count(b.userid) from Huser b "
				+"where b.useremail=:useremail"
				+ " and b.pwd=:userpass";
		TypedQuery<Long> q=em.createQuery(qString,Long.class);
		boolean result=false;
		q.setParameter("useremail", email);
		q.setParameter("userpass", pass);
		try
		{
			long userid=q.getSingleResult();
			if(userid>0)
			{
				result=true;
			}
		}catch(Exception e)
		{
			result=false;
		}
		finally
		{
			em.close();
		}
		return result;
	}

	public static List<Hcourse> getallcourse() {

		EntityManager em = DBUtil.getEmFactory().createEntityManager();

		String qString = "Select p from Hcourse p";

		Query q = em.createQuery(qString);

		List<Hcourse> post = new ArrayList<Hcourse>();

		try {
			post = q.getResultList();

		} catch (NoResultException e) {
			System.out.println(e);
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			em.close();
		}
		return post;
	}

	public static List<Hclass> getallclasses() {

		EntityManager em = DBUtil.getEmFactory().createEntityManager();

		String qString = "Select p from Hclass p";

		Query q = em.createQuery(qString);

		List<Hclass> post = new ArrayList<Hclass>();

		try {
			post = q.getResultList();

		} catch (NoResultException e) {
			System.out.println(e);
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			em.close();
		}
		return post;
	}
	
	public static List<Long> getallclassids() {

		EntityManager em = DBUtil.getEmFactory().createEntityManager();

		String qString = "Select p.classid from Hclass p";

		Query q = em.createQuery(qString);

		List<Long> post = new ArrayList<Long>();

		try {
			post = q.getResultList();

		} catch (NoResultException e) {
			System.out.println(e);
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			em.close();
		}
		return post;
	}
	public static List<Hclass> getallclassesbycourseid(long courseid) {

		EntityManager em = DBUtil.getEmFactory().createEntityManager();

		String qString = "Select p from Hclass p where p.hcourse.courseid=:courseid";

		Query q = em.createQuery(qString);
		q.setParameter("courseid", courseid);
		List<Hclass> post = new ArrayList<Hclass>();

		try {
			post = q.getResultList();

		} catch (NoResultException e) {
			System.out.println(e);
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			em.close();
		}
		return post;
	}
	
	public static List<Long> getallclassidsbycourseid(long courseid) {

		EntityManager em = DBUtil.getEmFactory().createEntityManager();

		String qString = "Select p.classid from Hclass p where p.hcourse.courseid=:courseid";

		Query q = em.createQuery(qString);
		q.setParameter("courseid", courseid);
		List<Long> post = new ArrayList<Long>();

		try {
			post = q.getResultList();

		} catch (NoResultException e) {
			System.out.println(e);
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			em.close();
		}
		return post;
	}
	 public static List<Hclass> searchClassesbycourse (String search, long courseid)
	 {
	     EntityManager em = DBUtil.getEmFactory().createEntityManager();
	     List<Hclass> searchposts = null;
	      String qString = "select b from Hclass b "
	                + "where b.crnnumber like :search and b.hcourse.courseid=:courseid";
	        
	        try{
	            TypedQuery<Hclass> query = em.createQuery(qString,Hclass.class);
	            query.setParameter("search", "%" + search + "%");
	            query.setParameter("courseid", courseid);
	            searchposts = query.getResultList();
	        }catch (Exception e){
	            e.printStackTrace();
	        }finally{
	            em.close();
	        }return searchposts;
	    }
	 
	 public static List<Long> searchClassidsbycourse (String search, long courseid)
	 {
	     EntityManager em = DBUtil.getEmFactory().createEntityManager();
	     List<Long> searchposts = null;
	      String qString = "select b.classid from Hclass b "
	                + "where b.crnnumber like :search and b.hcourse.courseid=:courseid";
	        
	        try{
	            Query query = em.createQuery(qString);
	            query.setParameter("search", "%" + search + "%");
	            query.setParameter("courseid", courseid);
	            searchposts = query.getResultList();
	        }catch (Exception e){
	            e.printStackTrace();
	        }finally{
	            em.close();
	        }return searchposts;
	    }
	 
	 public static List<Hcourse> searchallCourse (String search)
	 {
	     EntityManager em = DBUtil.getEmFactory().createEntityManager();
	     List<Hcourse> searchposts = null;
	      String qString = "select b from Hcourse b "
	                + "where b.coursename like :search";
	        
	        try{
	            TypedQuery<Hcourse> query = em.createQuery(qString,Hcourse.class);
	            query.setParameter("search", "%" + search + "%");
	            searchposts = query.getResultList();
	        }catch (Exception e){
	            e.printStackTrace();
	        }finally{
	            em.close();
	        }return searchposts;
	    }
	
	 public static List<Hclass> getallclassesbystudentid(long studentid) {

			EntityManager em = DBUtil.getEmFactory().createEntityManager();

			String qString = "Select p from Hclass p where p.classid in (select b.hclass.classid from Hstudentclassbridge b where b.hstudent.studentid=:studentid)";
			Query q = em.createQuery(qString);
			q.setParameter("studentid", studentid);
			List<Hclass> post = new ArrayList<Hclass>();

			try {
				post = q.getResultList();

			} catch (NoResultException e) {
				System.out.println(e);
			} catch (Exception e) {

				e.printStackTrace();
			} finally {
				em.close();
			}
			return post;
		}
	 
	 public static List<Hclass> searchClassesbystudentid (String search, long studentid)
	 {
	     EntityManager em = DBUtil.getEmFactory().createEntityManager();
	     List<Hclass> searchposts = null;
	      String qString = "Select p from Hclass p where p.classid in (select b.hclass.classid from Hstudentclassbridge b where b.hstudent.studentid=:studentid) "
	                + "and p.crnnumber like :search";
	        
	        try{
	            TypedQuery<Hclass> query = em.createQuery(qString,Hclass.class);
	            query.setParameter("search", "%" + search + "%");
	            query.setParameter("studentid", studentid);
	            searchposts = query.getResultList();
	        }catch (Exception e){
	            e.printStackTrace();
	        }finally{
	            em.close();
	        }return searchposts;
	    }
	
	 
	 public static List<Long> getallclassidsbystudentid(long studentid) {

			EntityManager em = DBUtil.getEmFactory().createEntityManager();

			String qString = "Select p.classid from Hclass p where p.classid in (select b.hclass.classid from Hstudentclassbridge b where b.hstudent.studentid=:studentid)";
			Query q = em.createQuery(qString);
			q.setParameter("studentid", studentid);
			List<Long> post = new ArrayList<Long>();

			try {
				post = q.getResultList();

			} catch (NoResultException e) {
				System.out.println(e);
			} catch (Exception e) {

				e.printStackTrace();
			} finally {
				em.close();
			}
			return post;
		}
	 
	 public static HashMap<Long, Long> getclassStatusforstudent(List<Long> allclassids, List<Long> allstudentclassids)
	 {
		 Set<Long> set =new HashSet<Long>(allstudentclassids);
		 HashMap<Long, Long> map=new HashMap<Long, Long>();
		 
		 for(long i: allclassids)
		 {
			 if(set.contains(i))
			 {
				 map.put(i, (long) 1);// Student has enrolled this class
			 }
			 else
			 {
				 map.put(i, (long) 0); // Student hasn't enrolled this class
			 }
		 }
		 return map;	 
		 
	 }
	 
	 public static boolean checktimeConflict(Hclass myclass, List<Hclass> enrolledclass)
	 {
		 boolean check=false;
		 for(Hclass i: enrolledclass)
		 {
			 if(i.getWeekday()==myclass.getWeekday()&&i.getSection()==myclass.getSection())
			 {
				 check=true;
			 }
			 
		 }
		 return check;
	 }
	 public static boolean checkcapacity(Hclass myclass)
	 {
		 boolean check=false;
		 if(myclass.getStudentcount()+1>myclass.getHclassroom().getMaxcapacity())
		 {
			 check=true;
		 }
		 return check;
	 }
	 
	public static void insert(Hstudentclassbridge user) {
	        EntityManager em = DBUtil.getEmFactory().createEntityManager();
	        EntityTransaction trans = em.getTransaction();
	        try {
	            trans.begin();
	            em.persist(user);
	            trans.commit();
	        } catch (Exception e) {
	            trans.rollback();
	        } finally {
	            em.close();
	        }
	    }
	public static void insert(Hstudent user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(user);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
	
	public static void insert(Huser user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(user);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
	public static void update(Hclass user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(user);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
	public static void update(Huser user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(user);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
	
	
	
	public static void enrollclass(long classid, long studentid)
	{
		 List<Hclass> enrolledclass=Dataget.getallclassesbystudentid(studentid);
		 Hclass myclass=Dataget.getClassByClassid(classid);
		 if(Dataget.checktimeConflict(myclass, enrolledclass)==false)
		 {
			 if(Dataget.checkcapacity(myclass)==false)
			 {
				 Hstudentclassbridge bridge=new Hstudentclassbridge();
				 
				 Hstudent student=Dataget.getStudentByStudentid(studentid);
				 
				 bridge.setHclass(myclass);
				 bridge.setHstudent(student);
				 bridge.setGrade(0);
				 
				 Dataget.insert(bridge);
				 
				 myclass.setStudentcount(myclass.getStudentcount()+1);
				 
				 Dataget.update(myclass);			 
				 
			 }
		 }
		 
	}
	
	 public static void delete(Hstudentclassbridge review) {
	        EntityManager em = DBUtil.getEmFactory().createEntityManager();
	        EntityTransaction trans = em.getTransaction();
	        try {
	            trans.begin();
	            em.remove(em.merge(review));
	            trans.commit();
	        } catch (Exception e) {
	            System.out.println(e);
	            trans.rollback();
	        } finally {
	            em.close();
	        }
	    }
	
	public static void dropclass(long classid, long studentid)
	{
		 
		 Hstudentclassbridge bridge=Dataget.getstudentclassbridgeBytwoids(classid, studentid);
		 Dataget.delete(bridge);
		 Hclass myclass=Dataget.getClassByClassid(classid);
		 myclass.setStudentcount(myclass.getStudentcount()-1);
		 Dataget.update(myclass);	 
	}
	
	public static HashMap<String, String> getSchedule(List<Hclass> enrolledclass)
	{
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("11", "");
		map.put("12", "");
		map.put("13", "");
		map.put("14", "");
		map.put("15", "");
		map.put("16", "");
		map.put("17", "");
		map.put("21", "");
		map.put("22", "");
		map.put("23", "");
		map.put("24", "");
		map.put("25", "");
		map.put("26", "");
		map.put("27", "");
		map.put("31", "");
		map.put("32", "");
		map.put("33", "");
		map.put("34", "");
		map.put("35", "");
		map.put("36", "");
		map.put("37", "");
		map.put("41", "");
		map.put("42", "");
		map.put("43", "");
		map.put("44", "");
		map.put("45", "");
		map.put("46", "");
		map.put("47", "");
		map.put("51", "");
		map.put("52", "");
		map.put("53", "");
		map.put("54", "");
		map.put("55", "");
		map.put("56", "");
		map.put("57", "");
		for(Hclass i: enrolledclass)
		{
			String schedule=i.getCrnnumber()+" "+i.getHcourse().getCoursename()+" "+i.getHinstructor().getInstructorname()+" "+i.getHclassroom().getBuildingname()+" "+i.getHclassroom().getRoomnumber();
			if(i.getWeekday()==1 &&i.getSection()==1)
			{
				map.put("11", schedule);	
			}
			else if(i.getWeekday()==2 &&i.getSection()==1)
			{
				map.put("12", schedule);
			}
			else if(i.getWeekday()==3 &&i.getSection()==1)
			{
				map.put("13", schedule);
			}
			else if(i.getWeekday()==4 &&i.getSection()==1)
			{
				map.put("14", schedule);
			}
			else if(i.getWeekday()==5 &&i.getSection()==1)
			{
				map.put("15", schedule);
			}
			else if(i.getWeekday()==6 &&i.getSection()==1)
			{
				map.put("16", schedule);
			}
			else if(i.getWeekday()==7 &&i.getSection()==1)
			{
				map.put("17", schedule);
			}
			else if(i.getWeekday()==1 &&i.getSection()==2)
			{
				map.put("21", schedule);
			}
			else if(i.getWeekday()==2 &&i.getSection()==2)
			{
				map.put("22", schedule);
			}
			else if(i.getWeekday()==3 &&i.getSection()==2)
			{
				map.put("23", schedule);
			}
			else if(i.getWeekday()==4 &&i.getSection()==2)
			{
				map.put("24", schedule);
			}
			else if(i.getWeekday()==5 &&i.getSection()==2)
			{
				map.put("25", schedule);
			}
			else if(i.getWeekday()==6 &&i.getSection()==2)
			{
				map.put("26", schedule);
			}
			else if(i.getWeekday()==7 &&i.getSection()==2)
			{
				map.put("27", schedule);
			}
			else if(i.getWeekday()==1 &&i.getSection()==3)
			{
				map.put("31", schedule);
			}
			else if(i.getWeekday()==2 &&i.getSection()==3)
			{
				map.put("32", schedule);
			}
			else if(i.getWeekday()==3 &&i.getSection()==3)
			{
				map.put("33", schedule);
			}
			else if(i.getWeekday()==4 &&i.getSection()==3)
			{
				map.put("34", schedule);
			}
			else if(i.getWeekday()==5 &&i.getSection()==3)
			{
				map.put("35", schedule);
			}
			else if(i.getWeekday()==6 &&i.getSection()==3)
			{
				map.put("36", schedule);
			}
			else if(i.getWeekday()==7 &&i.getSection()==3)
			{
				map.put("37", schedule);
			}
			else if(i.getWeekday()==1 &&i.getSection()==4)
			{
				map.put("41", schedule);
			}
			else if(i.getWeekday()==2 &&i.getSection()==4)
			{
				map.put("42", schedule);
			}
			else if(i.getWeekday()==3 &&i.getSection()==4)
			{
				map.put("43", schedule);
			}
			else if(i.getWeekday()==4 &&i.getSection()==3)
			{
				map.put("44", schedule);
			}
			else if(i.getWeekday()==5 &&i.getSection()==4)
			{
				map.put("45", schedule);
			}
			else if(i.getWeekday()==6 &&i.getSection()==4)
			{
				map.put("46", schedule);
			}
			else if(i.getWeekday()==7 &&i.getSection()==4)
			{
				map.put("47", schedule);
			}
			else if(i.getWeekday()==1 &&i.getSection()==5)
			{
				map.put("51", schedule);
			}
			else if(i.getWeekday()==2 &&i.getSection()==5)
			{
				map.put("52", schedule);
			}
			else if(i.getWeekday()==3 &&i.getSection()==5)
			{
				map.put("53", schedule);
			}
			else if(i.getWeekday()==4 &&i.getSection()==5)
			{
				map.put("54", schedule);
			}
			else if(i.getWeekday()==5 &&i.getSection()==5)
			{
				map.put("55", schedule);
			}
			else if(i.getWeekday()==6 &&i.getSection()==5)
			{
				map.put("56", schedule);
			}
			else if(i.getWeekday()==7 &&i.getSection()==5)
			{
				map.put("57", schedule);
			}
		}
		
		return map;
	}
	
	
	public static List<Hcourse> getCoursebyInstructor(long instructorid) {

		EntityManager em = DBUtil.getEmFactory().createEntityManager();

		String qString = "select c from Hcourse c where c.courseid in (select b.hcourse.courseid from Hclass b where b.hinstructor.instructorid=:instructorid)";

		Query q = em.createQuery(qString);
		q.setParameter("instructorid", instructorid);
		List<Hcourse> reviews = new ArrayList<Hcourse>();

		try {
			reviews = q.getResultList();

		} catch (NoResultException e) {
			System.out.println(e);
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			em.close();
		}
		return reviews;
	}
	
	public static List<Hcourse> searchcoursebyinstructor (String search, long instructorid)
	 {
	     EntityManager em = DBUtil.getEmFactory().createEntityManager();
	     List<Hcourse> searchposts = null;
	      String qString = "select c from Hcourse c where c.courseid in (select b.hcourse.courseid from Hclass b where b.hinstructor.instructorid=:instructorid) "
	                + "and c.coursename like :search";
	        
	        try{
	            TypedQuery<Hcourse> query = em.createQuery(qString,Hcourse.class);
	            query.setParameter("search", "%" + search + "%");
	            query.setParameter("instructorid", instructorid);
	            searchposts = query.getResultList();
	        }catch (Exception e){
	            e.printStackTrace();
	        }finally{
	            em.close();
	        }return searchposts;
	    }
	
	public static List<Hcourse> searchcourse (String search)
	 {
	     EntityManager em = DBUtil.getEmFactory().createEntityManager();
	     List<Hcourse> searchposts = null;
	      String qString = "select c from Hcourse c "
	                + "where c.coursename like :search";
	        
	        try{
	            TypedQuery<Hcourse> query = em.createQuery(qString,Hcourse.class);
	            query.setParameter("search", "%" + search + "%");
	            searchposts = query.getResultList();
	        }catch (Exception e){
	            e.printStackTrace();
	        }finally{
	            em.close();
	        }return searchposts;
	    }
	
	public static List<Hclass> searchclass (String search)
	 {
	     EntityManager em = DBUtil.getEmFactory().createEntityManager();
	     List<Hclass> searchposts = null;
	      String qString = "select c from Hclass c "
	                + "where c.crnnumber like :search";
	        
	        try{
	            TypedQuery<Hclass> query = em.createQuery(qString,Hclass.class);
	            query.setParameter("search", "%" + search + "%");
	            searchposts = query.getResultList();
	        }catch (Exception e){
	            e.printStackTrace();
	        }finally{
	            em.close();
	        }return searchposts;
	    }
	public static List<Long> searchclassids (String search)
	 {
	     EntityManager em = DBUtil.getEmFactory().createEntityManager();
	     List<Long> searchposts = null;
	      String qString = "select c.classid from Hclass c "
	                + "where c.crnnumber like :search";
	        
	        try{
	            Query query = em.createQuery(qString);
	            query.setParameter("search", "%" + search + "%");
	            searchposts = query.getResultList();
	        }catch (Exception e){
	            e.printStackTrace();
	        }finally{
	            em.close();
	        }return searchposts;
	    }
	
	public static List<Hclass> getallclassbycourseidinstructorid(long courseid, long instructorid) {

		EntityManager em = DBUtil.getEmFactory().createEntityManager();

		String qString = "Select p from Hclass p where p.hcourse.courseid=:courseid and p.hinstructor.instructorid=:instructorid";

		Query q = em.createQuery(qString);
		q.setParameter("courseid", courseid);
		q.setParameter("instructorid", instructorid);
		List<Hclass> post = new ArrayList<Hclass>();

		try {
			post = q.getResultList();

		} catch (NoResultException e) {
			System.out.println(e);
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			em.close();
		}
		return post;
	}
	public static List<Long> getallclassidsbycourseidinstructorid(long courseid, long instructorid) {

		EntityManager em = DBUtil.getEmFactory().createEntityManager();

		String qString = "Select p.classid from Hclass p where p.hcourse.courseid=:courseid and p.hinstructor.instructorid=:instructorid";

		Query q = em.createQuery(qString);
		q.setParameter("courseid", courseid);
		q.setParameter("instructorid", instructorid);
		List<Long> post = new ArrayList<Long>();

		try {
			post = q.getResultList();

		} catch (NoResultException e) {
			System.out.println(e);
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			em.close();
		}
		return post;
	}
	
	
	public static List<Hclass> searchclassbycourseidinstructorid (String search, long instructorid, long courseid)
	 {
	     EntityManager em = DBUtil.getEmFactory().createEntityManager();
	     List<Hclass> searchposts = null;
	      String qString = "Select p from Hclass p where p.hcourse.courseid=:courseid and p.hinstructor.instructorid=:instructorid "
	                + "and p.crnnumber like :search";
	        
	        try{
	            TypedQuery<Hclass> query = em.createQuery(qString,Hclass.class);
	            query.setParameter("search", "%" + search + "%");
	            query.setParameter("instructorid", instructorid);
	            query.setParameter("courseid", courseid);
	            searchposts = query.getResultList();
	        }catch (Exception e){
	            e.printStackTrace();
	        }finally{
	            em.close();
	        }return searchposts;
	    }
	public static List<Hstudentclassbridge> getstudentlistbyclassid(long classid)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();

		String qString = "Select p from Hstudentclassbridge p where p.hclass.classid=:classid";

		Query q = em.createQuery(qString);
		q.setParameter("classid", classid);
		List<Hstudentclassbridge> post = new ArrayList<Hstudentclassbridge>();

		try {
			post = q.getResultList();

		} catch (NoResultException e) {
			System.out.println(e);
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			em.close();
		}
		return post;
	}
	public static List<Hstudentclassbridge> searchstudentfromstudentlistbyclass (String search, long classid)
	 {
	     EntityManager em = DBUtil.getEmFactory().createEntityManager();
	     List<Hstudentclassbridge> searchposts = null;
	      String qString = "Select p from Hstudentclassbridge p where p.hclass.classid=:classid "
	                + "and p.hstudent.studentname like :search";
	        
	        try{
	            TypedQuery<Hstudentclassbridge> query = em.createQuery(qString,Hstudentclassbridge.class);
	            query.setParameter("search", "%" + search + "%");
	            query.setParameter("classid", classid);
	            searchposts = query.getResultList();
	        }catch (Exception e){
	            e.printStackTrace();
	        }finally{
	            em.close();
	        }return searchposts;
	    }
	
	public static List<Hclass> getallclassbyinstructorid(long instructorid) {

		EntityManager em = DBUtil.getEmFactory().createEntityManager();

		String qString = "Select p from Hclass p where p.hinstructor.instructorid=:instructorid";

		Query q = em.createQuery(qString);
		q.setParameter("instructorid", instructorid);
		List<Hclass> post = new ArrayList<Hclass>();

		try {
			post = q.getResultList();

		} catch (NoResultException e) {
			System.out.println(e);
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			em.close();
		}
		return post;
	}
	public static List<Long> getallclassidsbyinstructorid(long instructorid) {

		EntityManager em = DBUtil.getEmFactory().createEntityManager();

		String qString = "Select p.classid from Hclass p where p.hinstructor.instructorid=:instructorid";

		Query q = em.createQuery(qString);
		q.setParameter("instructorid", instructorid);
		List<Long> post = new ArrayList<Long>();

		try {
			post = q.getResultList();

		} catch (NoResultException e) {
			System.out.println(e);
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			em.close();
		}
		return post;
	}
	
	
	 public static HashMap<Long, Long> getclassStatusforinstructor(List<Long> allclassids, List<Long> allinstructorclassids)
	 {
		 Set<Long> set =new HashSet<Long>(allinstructorclassids);
		 HashMap<Long, Long> map=new HashMap<Long, Long>();
		 
		 for(long i: allclassids)
		 {
			 if(set.contains(i))
			 {
				 map.put(i, (long) 1);// Instructor has owned this class
			 }
			 else
			 {
				 map.put(i, (long) 0); // Instructor hasn't owned this class
			 }
		 }
		 return map;	 
		 
	 }
	 public static HashMap<Long, String> weekdayhashmap()
	 {
		 HashMap<Long, String> map=new HashMap<Long, String>();
		 
		 map.put((long) 1, "Monday");
		 map.put((long) 2, "Tuesday");
		 map.put((long) 3, "Wednesday");
		 map.put((long) 4, "Thursday");
		 map.put((long) 5, "Friday");
		 map.put((long) 6, "Saturday");
		 map.put((long) 7, "Sunday");
		 
		 return map;
	 }
	 
	
	
	


}
