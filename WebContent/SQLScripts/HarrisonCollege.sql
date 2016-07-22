
drop table hstudentclassbridge;
drop table hclass;
drop table hstudent;
drop table hinstructor;
drop table hcourse;
drop table hmajor;
drop table hclassroom;
drop table hdepartment;
drop table huser;

drop sequence huser_id_seq;
drop sequence hdepartment_id_seq;
drop sequence hclassroom_id_seq;
drop sequence hmajor_id_seq;
drop sequence hcourse_id_seq;
drop sequence hinstructor_id_seq;
drop sequence hstudent_id_seq;
drop sequence hclass_id_seq;
drop sequence hstudentclassbridge_id_seq;


create sequence  huser_id_seq start with 1 increment by 1 nocache;
create sequence  hdepartment_id_seq start with 1 increment by 1 nocache;
create sequence  hclassroom_id_seq start with 1 increment by 1 nocache;
create sequence  hmajor_id_seq start with 1 increment by 1 nocache;
create sequence  hcourse_id_seq start with 1 increment by 1 nocache;
create sequence  hinstructor_id_seq start with 1 increment by 1 nocache;
create sequence  hstudent_id_seq start with 1 increment by 1 nocache;
create sequence  hclass_id_seq start with 1 increment by 1 nocache;
create sequence  hstudentclassbridge_id_seq start with 1 increment by 1 nocache;



create table huser (
userId integer primary key,
username varchar2(50) unique not null,
pwd varchar2(200) not null,
useremail varchar2(100) not null,
userrole integer not null
);

create table hdepartment (
departmentId integer primary key,
departmentname varchar2(50) unique not null
);

create table hclassroom (
classroomId integer primary key,
buildingname varchar2(50) not null,
roomnumber varchar2(50) not null,
maxcapacity integer not null
);


create table hmajor (
majorId integer primary key,
majorname varchar2(50) unique not null,
departmentId integer not null,
CONSTRAINT fk_major_departmentid FOREIGN KEY (departmentId) references hdepartment(departmentId)
);

create table hcourse (
courseId integer primary key,
coursename varchar2(50) unique not null,
subjectcode varchar2(50) not null,
coursedes varchar2(200) not null,
departmentId integer not null,
credits integer not null,
CONSTRAINT fk_course_departmentid FOREIGN KEY (departmentId) references hdepartment(departmentId)
);

create table hinstructor (
InstructorId integer primary key,
instructorname varchar2(50) not null,
officenumber varchar2(50) not null,
departmentId integer not null,
userId integer not null,
CONSTRAINT fk_instructor_departmentid FOREIGN KEY (departmentId) references hdepartment(departmentId),
CONSTRAINT fk_instructor_userid FOREIGN KEY (userId) references huser(userId)
);

create table hstudent (
studentId integer primary key,
studentname varchar2(50) not null,
majorId integer not null,
entryyear varchar2(50) not null,
userId integer not null,
CONSTRAINT fk_student_majorid FOREIGN KEY (majorId) references hmajor(majorId),
CONSTRAINT fk_student_userid FOREIGN KEY (userId) references huser(userId)
);


create table hclass (
classId integer primary key,
crnnumber varchar2(50) unique not null,
courseId integer not null,
instructorId integer not null,
classroomId integer not null,
weekday integer not null,
section integer not null,
classtime varchar2(100) not null,
studentcount integer default 0 not null,
CONSTRAINT fk_class_courseid FOREIGN KEY (courseId) references hcourse(courseId),
CONSTRAINT fk_class_instructorid FOREIGN KEY (instructorId) references hinstructor(instructorId),
CONSTRAINT fk_class_classroomid FOREIGN KEY (classroomId) references hclassroom(classroomId)
);


create table hstudentclassbridge (
bridgeId integer primary key,
studentId integer not null,
classId integer not null,
grade integer default 0 not null,
CONSTRAINT fk_bridge_studentid FOREIGN KEY (studentId) references hstudent(studentId),
CONSTRAINT fk_bridge_classid FOREIGN KEY (classId) references hclass(classId)
);

commit;

--Insertion for huser
Insert into huser  values (huser_id_seq.nextval,'student 1','password','student1@domain.com',1);
Insert into huser  values (huser_id_seq.nextval,'student 2','password','student2@domain.com',1);
Insert into huser  values (huser_id_seq.nextval,'studnet 3','password','student3@domain.com',1);



Insert into huser  values (huser_id_seq.nextval,'instructor 1','password','instructor1@domain.com',2);
Insert into huser  values (huser_id_seq.nextval,'instructor 2','password','instructor2@domain.com',2);
Insert into huser  values (huser_id_seq.nextval,'instructor 3','password','instructor3@domain.com',2);

Insert into huser  values (huser_id_seq.nextval,'student 4','password','student4@domain.com',1);
Insert into huser  values (huser_id_seq.nextval,'student 5','password','student5@domain.com',1);
Insert into huser  values (huser_id_seq.nextval,'studnet 6','password','student6@domain.com',1);

select * from huser;

--Insertion for hdepartment

Insert into hdepartment  values (hdepartment_id_seq.nextval,'Business School');
Insert into hdepartment  values (hdepartment_id_seq.nextval,'Engineering School');
Insert into hdepartment  values (hdepartment_id_seq.nextval,'Medical School');

select * from hdepartment;


--Insertion for hclassroom

Insert into hclassroom  values (hclassroom_id_seq.nextval,'SEH Building','1101',40);
Insert into hclassroom  values (hclassroom_id_seq.nextval,'Funger Hall','204',25);
Insert into hclassroom  values (hclassroom_id_seq.nextval,'Deques','108',35);
Insert into hclassroom  values (hclassroom_id_seq.nextval,'Rome Hall','308',50);


select * from hclassroom;

--Insertion for hmajor

Insert into hmajor  values (hmajor_id_seq.nextval,'Computer Science',2);
Insert into hmajor  values (hmajor_id_seq.nextval,'Finance',1);
Insert into hmajor  values (hmajor_id_seq.nextval,'EE',2);
Insert into hmajor  values (hmajor_id_seq.nextval,'Computer Engineering',2);
Insert into hmajor  values (hmajor_id_seq.nextval,'Nurse',3);
Insert into hmajor  values (hmajor_id_seq.nextval,'Accounting',1);


select * from hmajor;

--Insertion for hcourse

Insert into hcourse values (hcourse_id_seq.nextval,'Big Data','1','Big Data Analytics',2,3);
Insert into hcourse values (hcourse_id_seq.nextval,'Principles of program','2','Principles of programming language',2,3);
Insert into hcourse values (hcourse_id_seq.nextval,'Math','3','Math',1,3);
Insert into hcourse values (hcourse_id_seq.nextval,'Physics','4','Physics',3,3);
Insert into hcourse values (hcourse_id_seq.nextval,'Chemistry','5','Chemistry',2,3);

select * from hcourse;


--Insertion for hinstructor

Insert into hinstructor values (hinstructor_id_seq.nextval,'Dave Wolf','2024567890',2,4);
Insert into hinstructor values (hinstructor_id_seq.nextval,'Steven Kaisler','20222225',1,5);
Insert into hinstructor values (hinstructor_id_seq.nextval,'Mary Thompson','20222785',3,6);

select * from hinstructor;


--Insertion for hstudent


Insert into hstudent values (hstudent_id_seq.nextval,'Lucy Smith',1,'2016',1);
Insert into hstudent values (hstudent_id_seq.nextval,'Tommy Boeing',2,'2016',2);
Insert into hstudent values (hstudent_id_seq.nextval,'Cheryl He',3,'2016',3);
Insert into hstudent values (hstudent_id_seq.nextval,'Fred Smith',4,'2016',7);
Insert into hstudent values (hstudent_id_seq.nextval,'Harry Potter',5,'2016',8);
Insert into hstudent values (hstudent_id_seq.nextval,'Lily Wang',6,'2016',9);

select * from hstudent;

--Insertion for hclass

Insert into hclass values (hclass_id_seq.nextval,'11111',1,1,1,1,1,'8:00AM-10:10AM',0);

Insert into hclass values (hclass_id_seq.nextval,'21223',2,1,2,2,3,'1:00PM-3:10PM',0);

Insert into hclass values (hclass_id_seq.nextval,'32245',3,2,2,4,5,'6:00PM-8:10PM',0);

Insert into hclass values (hclass_id_seq.nextval,'43352',4,3,3,5,2,'10:30PM-12:40PM',0);

Insert into hclass values (hclass_id_seq.nextval,'51434',5,1,4,3,4,'3:30PM-5:40PM',0);


select * from hclass;


--Insertion for hstudentclassbridge

Insert into hstudentclassbridge values (hstudentclassbridge_id_seq.nextval,1,1,89);

Insert into hstudentclassbridge values (hstudentclassbridge_id_seq.nextval,1,2,65);

Insert into hstudentclassbridge values (hstudentclassbridge_id_seq.nextval,1,5,98);

Insert into hstudentclassbridge values (hstudentclassbridge_id_seq.nextval,2,3,60);

Insert into hstudentclassbridge values (hstudentclassbridge_id_seq.nextval,3,1,99);

Insert into hstudentclassbridge values (hstudentclassbridge_id_seq.nextval,3,2,45);

Insert into hstudentclassbridge values (hstudentclassbridge_id_seq.nextval,4,5,97);

Insert into hstudentclassbridge values (hstudentclassbridge_id_seq.nextval,5,4,60);

Insert into hstudentclassbridge values (hstudentclassbridge_id_seq.nextval,6,3,100);







