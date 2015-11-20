package edu.csupomona.cs480.data;

public class Profile {
	
	private final String name;          //required
	private final String email;         //required
	private final String schoolName;    //optional
	private final String major; 		//optional
	private final float schoolGPA; 	    //optional
	private final float majorGPA; 	    //optional
	private final int courseYear; 	    //optional
	private final int age; 			    //optional
	
	private Profile(ProfileBuilder builder) {
		this.name = builder.name;
		this.email = builder.email;
		this.schoolName = builder.schoolName;
		this.major = builder.major ;
		this.schoolGPA = builder.schoolGPA;
		this.majorGPA = builder.majorGPA;
		this.courseYear = builder.courseYear;
		this.age = builder.age;
	}


	public String getName(){
		return name;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getSchoolName(){
		return schoolName;
	}
	
	public String getMajor(){
		return major;
	}
	
	public float getSchoolGPA(){
		return schoolGPA;
	}
	
	public float getMajorGPA(){
		return majorGPA;
	}
	
	public int getCourseYear(){
		return courseYear;
	}
	
	public int getAge(){
		return age;
	}
	
	 public static class ProfileBuilder {
		 private final String name;         
		 private final String email;         
		 private String schoolName;    
		 private String major; 		  
		 private float schoolGPA; 	  
		 private float majorGPA; 	  
		 private int courseYear; 	  
		 private int age;
		
		public ProfileBuilder(String name, String email) {
			this.name = name;
			this.email = email;
		}
		public ProfileBuilder schoolName(String schoolName) {
		    this.schoolName = schoolName;
		    return this;
		}
		public ProfileBuilder major(String major) {
		    this.major = major;
		    return this;
		}
		public ProfileBuilder schoolGPA(float schoolGPA) {
		    this.schoolGPA = schoolGPA;
		    return this;
		}
		public ProfileBuilder majorGPA(float majorGPA) {
		    this.majorGPA = majorGPA;
		    return this;
		}
		public ProfileBuilder courseYear(int courseYear) {
		    this.courseYear = courseYear;
		    return this;
		}
		public ProfileBuilder age(int age) {
		    this.age = age;
		    return this;
		}
		public Profile build() {
		    return new Profile(this);
		}

	 }
}