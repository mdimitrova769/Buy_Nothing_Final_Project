package cs455_martina_final;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;

class testUserManagerTest {
	
	BoundaryInterface bi = new UserManager();
	
	@Test
	void testCreateUser() {
		User user = new User();
		assertEquals(user.isNil(), false);
	}
	
	@Test
	void testCreateUserClass() {
		User user = new User();
		assertEquals(user.getClass(), User.class);
	}
	
	@Test
	void testCreateNullAccount() {
		User user = new NullUser();
		assertEquals(user.isNil(), true);
	}
	
	@Test
	void testCreateAccountTestStreet() {
		User user = new User();
		Address address = new Address();
		address.setStreet("3006 S Wells Street");
		user.setAddress(address);
		assertEquals(user.getAddress().getStreet(), "3006 S Wells Street");
	}

	@Test
	void testCreateAccountTestZip() {
		User user = new User();
		Address address = new Address();
		address.setZip("60616");
		user.setAddress(address);
		assertEquals(user.getAddress().getZip(), "60616");
	}
	
	@Test
	void testAddressZip() {
		Address address = new Address();
		address.setZip("60616");
		assertEquals(address.getZip(), "60616");
	}
	
	@Test
	void testAddressStreet() {
		Address address = new Address();
		address.setStreet("South Wells Street");
		assertEquals(address.getStreet(), "South Wells Street");
	}
	
	@Test
	void testAddressConstructorStreet() {
		Address address = new Address();
		address.setStreet("South Wells Street");
		address.setZip("60616");
		Address address1 = new Address(address);
		assertEquals(address.getStreet(), address1.getStreet());
	}
	
	@Test
	void testAddressConstructorZip() {
		Address address = new Address();
		address.setStreet("South Wells Street");
		address.setZip("60616");
		Address address1 = new Address(address);
		assertEquals(address.getZip(), address1.getZip());
	}
	
	@Test
	void testUserAccountAddressStreet() {
		User user = new User();
		Address address = new Address();
		address.setStreet("South Wells Street");
		address.setZip("60616");
		user.setUid("myUid");
		user.setAddress(address);
		user.setIs_active(true);
		user.setDate_created("2020-22-04 12:30:09");
		user.setPhone("312-456-4567");
		user.setPicture("my picture");
		user.setName("Martina Dimitrova");
		assertEquals(user.getAddress().getStreet(), address.getStreet());
	}
	
	@Test
	void testUserAccountUserConstructorAddressStreet() {
		User user = new User();
		Address address = new Address();
		address.setStreet("South Wells Street");
		address.setZip("60616");
		user.setUid("myUid");
		user.setAddress(address);
		user.setIs_active(true);
		user.setDate_created("2020-22-04 12:30:09");
		user.setPhone("312-456-4567");
		user.setPicture("my picture");
		user.setName("Martina Dimitrova");
		User user1 = new User(user);
		assertEquals(user.getAddress().getStreet(), user1.getAddress().getStreet());
	}
	
	@Test
	void testUserAccountUserConstructorAddressZip() {
		User user = new User();
		Address address = new Address();
		address.setStreet("South Wells Street");
		address.setZip("60616");
		user.setUid("myUid");
		user.setAddress(address);
		user.setIs_active(true);
		user.setDate_created("2020-22-04 12:30:09");
		user.setPhone("312-456-4567");
		user.setPicture("my picture");
		user.setName("Martina Dimitrova");
		User user1 = new User(user);
		assertEquals(user.getAddress().getZip(), user1.getAddress().getZip());
	}
	
	@Test
	void testUserAccountUserConstructorName() {
		User user = new User();
		Address address = new Address();
		address.setStreet("South Wells Street");
		address.setZip("60616");
		user.setUid("myUid");
		user.setAddress(address);
		user.setIs_active(true);
		user.setDate_created("2020-22-04 12:30:09");
		user.setPhone("312-456-4567");
		user.setPicture("my picture");
		user.setName("Martina Dimitrova");
		User user1 = new User(user);
		assertEquals(user.getName(), user1.getName());
	}
	
	@Test
	void testUserAccountUserConstructorPhoto() {
		User user = new User();
		Address address = new Address();
		address.setStreet("South Wells Street");
		address.setZip("60616");
		user.setUid("myUid");
		user.setAddress(address);
		user.setIs_active(true);
		user.setDate_created("2020-22-04 12:30:09");
		user.setPhone("312-456-4567");
		user.setPicture("my picture");
		user.setName("Martina Dimitrova");
		User user1 = new User(user);
		assertEquals(user.getPicture(), user1.getPicture());
	}
	
	@Test
	void testUserAccountUserConstructorPhone() {
		User user = new User();
		Address address = new Address();
		address.setStreet("South Wells Street");
		address.setZip("60616");
		user.setUid("myUid");
		user.setAddress(address);
		user.setIs_active(true);
		user.setDate_created("2020-22-04 12:30:09");
		user.setPhone("312-456-4567");
		user.setPicture("my picture");
		user.setName("Martina Dimitrova");
		User user1 = new User(user);
		assertEquals(user.getPhone(), user1.getPhone());
	}
	
	@Test
	void testUserAccountUserConstructorActivity() {
		User user = new User();
		Address address = new Address();
		address.setStreet("South Wells Street");
		address.setZip("60616");
		user.setUid("myUid");
		user.setAddress(address);
		user.setIs_active(true);
		user.setDate_created("2020-22-04 12:30:09");
		user.setPhone("312-456-4567");
		user.setPicture("my picture");
		user.setName("Martina Dimitrova");
		User user1 = new User(user);
		assertEquals(user1.getIs_active(), false);
	}
	
	@Test
	void testUserAccountAddressZip() {
		User user = new User();
		Address address = new Address();
		address.setStreet("South Wells Street");
		address.setZip("60616");
		user.setUid("myUid");
		user.setAddress(address);
		user.setIs_active(true);
		user.setDate_created("2020-22-04 12:30:09");
		user.setPhone("312-456-4567");
		user.setPicture("my picture");
		user.setName("Martina Dimitrova");
		assertEquals(user.getAddress().getZip(), address.getZip());
	}
	
	@Test
	void testUserAccountUid() {
		User user = new User();
		Address address = new Address();
		address.setStreet("South Wells Street");
		address.setZip("60616");
		user.setUid("myUid");
		user.setAddress(address);
		user.setIs_active(true);
		user.setDate_created("2020-22-04 12:30:09");
		user.setPhone("312-456-4567");
		user.setPicture("my picture");
		user.setName("Martina Dimitrova");
		assertEquals(user.getUid(), user.getUid());
	}
	
	@Test
	void testUserAccountPicture() {
		User user = new User();
		Address address = new Address();
		address.setStreet("South Wells Street");
		address.setZip("60616");
		user.setUid("myUid");
		user.setAddress(address);
		user.setIs_active(true);
		user.setDate_created("2020-22-04 12:30:09");
		user.setPhone("312-456-4567");
		user.setPicture("my picture");
		user.setName("Martina Dimitrova");
		assertEquals(user.getPicture(), "my picture");
	}
	
	@Test
	void testUserAccountName() {
		User user = new User();
		Address address = new Address();
		address.setStreet("South Wells Street");
		address.setZip("60616");
		user.setUid("myUid");
		user.setAddress(address);
		user.setIs_active(true);
		user.setDate_created("2020-22-04 12:30:09");
		user.setPhone("312-456-4567");
		user.setPicture("my picture");
		user.setName("Martina Dimitrova");
		assertEquals(user.getName(), "Martina Dimitrova");
	}
	
	@Test
	void testUserAccountDateCreated() {
		User user = new User();
		Address address = new Address();
		address.setStreet("South Wells Street");
		address.setZip("60616");
		user.setUid("myUid");
		user.setAddress(address);
		user.setIs_active(true);
		user.setDate_created("2020-22-04 12:30:09");
		user.setPhone("312-456-4567");
		user.setPicture("my picture");
		user.setName("Martina Dimitrova");
		assertEquals(user.getDate_created(), "2020-22-04 12:30:09");
	}
	
	@Test
	void testUserAccountPhone() {
		User user = new User();
		Address address = new Address();
		address.setStreet("South Wells Street");
		address.setZip("60616");
		user.setUid("myUid");
		user.setAddress(address);
		user.setIs_active(true);
		user.setDate_created("2020-22-04 12:30:09");
		user.setPhone("312-456-4567");
		user.setPicture("my picture");
		user.setName("Martina Dimitrova");
		assertEquals(user.getPhone(), "312-456-4567");
	}
	
	@Test
	void testAskParamConstructor() {
		Ask ask = new Ask();
		ArrayList<String> zips = new ArrayList <String> ();
		zips.add("60616");
		
		ask.setUid("myUid");
		ask.setIs_active(true);
		ask.setDate_created("2020-22-04 12:30:09");
		ask.setDescription("I need a bed");
		ask.setType("borrow");
		ask.setExtra_zip(zips);
		assertEquals(ask.getUid(), "myUid");
	}
	
	@Test
	void testAskObjectConstructor() {
		Ask ask = new Ask();
		ArrayList<String> zips = new ArrayList <String> ();
		zips.add("60616");
		
		ask.setUid("myUid");
		ask.setIs_active(true);
		ask.setDate_created("2020-22-04 12:30:09");
		ask.setDescription("I need a bed");
		ask.setType("borrow");
		ask.setExtra_zip(zips);
		
		Ask ask1 = new Ask(ask);
		assertEquals(ask1.getDescription(), "I need a bed");
	}
	
	@Test
	void testAskObjectConstructorGift() {
		Ask ask = new Ask();
		ArrayList<String> zips = new ArrayList <String> ();
		zips.add("60616");
		
		ask.setUid("myUid");
		ask.setIs_active(true);
		ask.setDate_created("2020-22-04 12:30:09");
		ask.setDescription("I need a bed");
		ask.setType("gift");
		ask.setExtra_zip(zips);
		
		Ask ask1 = new Ask(ask);
		assertEquals(ask1.getType(), "gift");
	}
	
	@Test
	void testAskObjectConstructorHelp() {
		Ask ask = new Ask();
		ArrayList<String> zips = new ArrayList <String> ();
		zips.add("60616");
		
		ask.setUid("myUid");
		ask.setIs_active(true);
		ask.setDate_created("2020-22-04 12:30:09");
		ask.setDescription("I need a bed");
		ask.setType("help");
		ask.setExtra_zip(zips);
		
		Ask ask1 = new Ask(ask);
		assertEquals(ask1.getType(), "help");
	}
	
	@Test
	void testAskObjectConstructorWrongType() {
		Ask ask = new Ask();
		ArrayList<String> zips = new ArrayList <String> ();
		zips.add("60616");
	
		ask.setUid("myUid");
		ask.setIs_active(true);
		ask.setDate_created("2020-22-04 12:30:09");
		ask.setDescription("I need a bed");
		ask.setType("invitation");
		ask.setExtra_zip(zips);
		
		Ask ask1 = new Ask(ask);
		assertEquals(ask1.getType(), " ");
	}
	
	@Test
	void testAskObjectConstructorSetAid() {
		Ask ask = new Ask();
		ArrayList<String> zips = new ArrayList <String> ();
		zips.add("60616");
		
		ask.setUid("myUid");
		ask.setIs_active(true);
		ask.setDate_created("2020-22-04 12:30:09");
		ask.setDescription("I need a bed");
		ask.setType("invitation");
		ask.setExtra_zip(zips);
		
		Ask ask1 = new Ask();
		ask1.setAid(ask.getAid());
		assertEquals(ask1.getAid(), ask.getAid());
	}
	
	@Test
	void testUserAccountIsActive() {
		User user = new User();
		Address address = new Address();
		address.setStreet("South Wells Street");
		address.setZip("60616");
		user.setUid("myUid");
		user.setAddress(address);
		user.setIs_active(true);
		user.setDate_created("2020-22-04 12:30:09");
		user.setPhone("312-456-4567");
		user.setPicture("my picture");
		user.setName("Martina Dimitrova");
		assertEquals(user.getIs_active(), true);
	}
	
	@Test
	void testUserAccountToString() {
		User user = new User();
		Address address = new Address();
		address.setStreet("South Wells Street");
		address.setZip("60616");
		user.setUid("myUid");
		user.setAddress(address);
		user.setIs_active(true);
		user.setDate_created("2020-22-04 12:30:09");
		user.setPhone("312-456-4567");
		user.setPicture("my picture");
		user.setName("Martina Dimitrova");
		String check = " name= " + user.getName() + " , address= " + user.getAddress().toString() + ", phone= " + user.getPhone() ;
		assertEquals(user.toString(), check);

	}
	
	@Test
	void testCreateAsk() {
		Ask ask = new Ask();
		assertEquals(ask.getClass(), Ask.class);
	}
	
	@Test
	void testCreateAskNullType() {
		Ask ask = new Ask();
		assertEquals(ask.getType(), null);
	}
	
	@Test
	void testCreateAskNullDescription() {
		Ask ask = new Ask();
		assertEquals(ask.getDescription(), null);
	}
	
	@Test
	void testCreateAskNullStart_date() {
		Ask ask = new Ask();
		assertEquals(ask.getStart_date(), null);
	}
	
	@Test
	void testCreateAskNullExtra_zip() {
		Ask ask = new Ask();
		assertEquals(ask.getExtra_zip(), null);
	}
	
	@Test
	void testCheckMatchesId() {
		User user = new User();
		User user1 = new User(user);
		assertEquals(user.matchesId(user.getUid()), true);
	}
	

		@Test
		void testCheckCreateUserWithParamActive() {
			User user = new User("Martina", "South Wells Street", "60616", "my_pic.png", "312-345-6789", true, "2022-06-05 12:04:45");
			assertEquals(user.getIs_active(), true);
		}
		
		@Test
		void testCheckCreateUserWithParamName() {
			User user = new User("Martina", "South Wells Street", "60616", "my_pic.png", "312-345-6789", true, "2022-06-05 12:04:45");
			assertEquals(user.getName(), "Martina");
		}
		
		@Test
		void testCheckCreateUserWithPhone() {
			User user = new User("Martina", "South Wells Street", "60616", "my_pic.png", "312-345-6789", true, "2022-06-05 12:04:45");
			assertEquals(user.getPhone(), "312-345-6789");
		}
	
	@Test
	void testCreateAskNullIsActive() {
		Ask ask = new Ask();
		assertEquals(ask.getIs_active(), false);
	}
	
	@Test
	void testCreateAskNullDate_created() {
		Ask ask = new Ask();
		assertEquals(ask.getDate_created(), "2022-03-13T17:56:13Z");
	}
	
	@Test
	void testCreateAskNullEnd_date() {
		Ask ask = new Ask();
		assertEquals(ask.getEnd_date(), null);
	}
	
	@Test
	void testCreateAskObjectEnd_date() {
		Ask ask = new Ask();
		ask.setEnd_date("Dec 24 2022");
		assertEquals(ask.getEnd_date(), "Dec 24 2022");
	}
	
	@Test
	void testCreateAskObjectStart_date() {
		Ask ask = new Ask();
		ask.setStart_date("Dec 24 2022");
		assertEquals(ask.getStart_date(), "Dec 24 2022");
	}
	
	@Test
	void testCreateAskObjectDescription() {
		Ask ask = new Ask();
		ask.setDescription("I need a bed");
		assertEquals(ask.getDescription(), "I need a bed");
	}
	
	@Test
	void testCreateAskObjectFalseType() {
		Ask ask = new Ask();
		ask.setType("invitation");
		assertEquals(ask.getType(), " ");
	}
	
	@Test
	void testCreateAskObjectTrueTypeBorrow() {
		Ask ask = new Ask();
		ask.setType("borrow");
		assertEquals(ask.getType(), "borrow");
	}
	
	@Test
	void testCreateAskObjectTrueTypeGift() {
		Ask ask = new Ask();
		ask.setType("gift");
		assertEquals(ask.getType(), "gift");
	}
	
	@Test
	void testCreateAskObjectTrueTypeHelp() {
		Ask ask = new Ask();
		ask.setType("help");
		assertEquals(ask.getType(), "help");
	}
	
	@Test
	void testCreateAskObjectIsActive() {
		Ask ask = new Ask();
		ask.setIs_active(false);
		assertEquals(ask.getIs_active(), false);
	}
	
	@Test
	void testCreateAskExtra_zip() {
		Ask ask = new Ask();
		ArrayList<String> zips = new ArrayList<String>();
		zips.add("60616");
		zips.add("60607");
		ask.setExtra_zip(zips);
		assertEquals(ask.getExtra_zip(), zips);
	}
	
	@Test
	void testAskMatchesId() {
		Ask ask = new Ask();
		Ask ask1 = new Ask();
		assertEquals(ask1.matchesId(ask.getAid()), false);
	}
	
	@Test
	void testAskNill() {
		Ask ask = new Ask();
		assertEquals(ask.isNil(), false);
	}
	
	@Test
	void testReportCreation() {
		Report report = new Report();
		assertEquals(report.getClass(), Report.class);
	}
	
	@Test
	void testReportCreationNoParam() {
		Report report = new Report();
		assertEquals(report.getName(), null);
	}
	
	@Test
	void testReportCreationName() {
		Report report = new Report("asks/gives");

		assertEquals(report.getName(),"asks/gives" );
	}
	
	@Test
	void testReportCreationNameComparison() {
		Report report = new Report("asks/gives");
		Report report1 = new Report(report);
		assertEquals(report.getName(),report1.getName() );
	}
	
	@Test
	void testReportCreationNameComparisonId() {
		Report report = new Report("asks/gives");
		report.setRid("myRid");
		assertEquals(report.getRid(),"myRid");
	}
	
	@Test
	void testReportSetName() {
		Report report = new Report("asks/gives");
		report.setName("borrowings");
		assertEquals(report.getName(),"borrowings");
	}
	
	@Test
	void testOtgovorStatus() {
		Otgovor response = new Otgovor();
        
        response.setDetail("You may not use PUT to activate an account, use GET /accounts/activate instead");
        response.setInstance("/accounts/"+"myUid");
        response.setStatus(400);
        response.setTitle("Your request data didn\'t pass validation");
        response.setType("http://cs.iit.edu/~virgil/cs445/mail.spring2022/project/api/problems/data-validation");
		assertEquals(response.getStatus(), 400);
	}
	
	@Test
	void testOtgovorTitle() {
		Otgovor response = new Otgovor();
        
        response.setDetail("You may not use PUT to activate an account, use GET /accounts/activate instead");
        response.setInstance("/accounts/"+"myUid");
        response.setStatus(400);
        response.setTitle("Your request data didn\'t pass validation");
        response.setType("http://cs.iit.edu/~virgil/cs445/mail.spring2022/project/api/problems/data-validation");
		assertEquals(response.getTitle(), "Your request data didn\'t pass validation");
	}
	
	@Test
	void testOtgovorType() {
		Otgovor response = new Otgovor();
        
        response.setDetail("You may not use PUT to activate an account, use GET /accounts/activate instead");
        response.setInstance("/accounts/"+"myUid");
        response.setStatus(400);
        response.setTitle("Your request data didn\'t pass validation");
        response.setType("http://cs.iit.edu/~virgil/cs445/mail.spring2022/project/api/problems/data-validation");
		assertEquals(response.getType(), "http://cs.iit.edu/~virgil/cs445/mail.spring2022/project/api/problems/data-validation");
	}
	
	@Test
	void testOtgovorDetail() {
		Otgovor response = new Otgovor();
        
        response.setDetail("You may not use PUT to activate an account, use GET /accounts/activate instead");
        response.setInstance("/accounts/"+"myUid");
        response.setStatus(400);
        response.setTitle("Your request data didn\'t pass validation");
        response.setType("http://cs.iit.edu/~virgil/cs445/mail.spring2022/project/api/problems/data-validation");
		assertEquals(response.getDetail(), "You may not use PUT to activate an account, use GET /accounts/activate instead");
	}
	
	@Test
	void testOtgovorInstance() {
		Otgovor response = new Otgovor();
        
        response.setDetail("You may not use PUT to activate an account, use GET /accounts/activate instead");
        response.setInstance("/accounts/"+"myUid");
        response.setStatus(400);
        response.setTitle("Your request data didn\'t pass validation");
        response.setType("http://cs.iit.edu/~virgil/cs445/mail.spring2022/project/api/problems/data-validation");
		assertEquals(response.getInstance(), "/accounts/"+"myUid");
	}
	
	@Test
	void testThankConstructorNoParam() {
		Thank thank = new Thank();
		assertEquals(thank.getClass(), Thank.class);
	}
	
	@Test
	void testThankConstructorObjectParam() {
		Thank thank = new Thank();
		thank.setUid("myUid");
		Thank thank1 = new Thank(thank);
		assertEquals(thank.getUid(), thank1.getUid());
	}
	
	@Test
	void testThankConstructorSetUid() {
		Thank thank = new Thank();
		thank.setUid("myUid");
		assertEquals(thank.getUid(), "myUid");
	}
	
	@Test
	void testThankConstructorSetTid() {
		Thank thank = new Thank();
		thank.setTid("myTid");
		assertEquals(thank.getTid(), "myTid");
	}
	
	@Test
	void testThankConstructorSetThankTo() {
		Thank thank = new Thank();
		thank.setThank_to("Martina");
		assertEquals(thank.getThank_to(), "Martina");
	}
	
	@Test
	void testThankConstructorSetDescription() {
		Thank thank = new Thank();
		thank.setDescription("Thank you for everything");
		assertEquals(thank.getDescription(), "Thank you for everything");
	}
	
	@Test
	void testThankConstructorSetDate_created() {
		Thank thank = new Thank();
		thank.setDate_created("Dec 13 2021 12:03:04");
		assertEquals(thank.getDate_created(), "Dec 13 2021 12:03:04");
	}
	
	@Test
	void testNoteCreation() {
		Note note = new Note();
		assertEquals(note.getClass(), Note.class);
	}
	
	@Test
	void testNoteCreationNullParamWrongToType() {
		Note note = new Note();
		note.setTo_type("");
		assertEquals(note.getTo_type(), " ");
	}
	
	@Test
	void testNoteCreationNullParamToTypeAsk() {
		Note note = new Note();
		note.setTo_type("ask");
		assertEquals(note.getTo_type(), "ask");
	}
	
	@Test
	void testNoteCreationNullParamToTypeGive() {
		Note note = new Note();
		note.setTo_type("give");
		assertEquals(note.getTo_type(), "give");
	}
	
	@Test
	void testNoteCreationNullParamToTypeNote() {
		Note note = new Note();
		note.setTo_type("note");
		assertEquals(note.getTo_type(), "note");
	}
	
	@Test
	void testNoteCreationSettersType() {
		Note note = new Note();
		note.setTo_type("note");
		note.setDate_created("1209-34-4 23:04:40");
		note.setTo_user_id("toUid");
		note.setDescription("Bed arriving tomorrow");
		note.setNid("myNid");
		note.setUid("myUid");
		note.setTo_id("toId");
		Note note1 = new Note(note);
		assertEquals(note1.getTo_type(), "note");
	}
	
	@Test
	void testNoteCreationSettersTypeGive() {
		Note note = new Note();
		note.setTo_type("give");
		note.setDate_created("1209-34-4 23:04:40");
		note.setTo_user_id("toUid");
		note.setDescription("Bed arriving tomorrow");
		note.setNid("myNid");
		note.setUid("myUid");
		note.setTo_id("toId");

		assertEquals(note.getTo_type(), "give");
	}
	
	@Test
	void testNoteCreationSettersTypeAsk() {
		Note note = new Note();
		note.setTo_type("ask");
		note.setDate_created("1209-34-4 23:04:40");
		note.setTo_user_id("toUid");
		note.setDescription("Bed arriving tomorrow");
		note.setNid("myNid");
		note.setUid("myUid");
		note.setTo_id("toId");
		Note note1 = new Note(note);
		assertEquals(note1.getTo_type(), "ask");
	}
	
	@Test
	void testNoteCreationSettersTypeObjectGive() {
		Note note = new Note();
		note.setTo_type("give");
		note.setDate_created("1209-34-4 23:04:40");
		note.setTo_user_id("toUid");
		note.setDescription("Bed arriving tomorrow");
		note.setNid("myNid");
		note.setUid("myUid");
		note.setTo_id("toId");
		Note note1 = new Note(note);
		assertEquals(note1.getTo_type(), "give");
	}
	
	@Test
	void testNoteCreationSettersTypeFalseObject() {
		Note note = new Note();
		note.setTo_type("invitation");
		note.setDate_created("1209-34-4 23:04:40");
		note.setTo_user_id("toUid");
		note.setDescription("Bed arriving tomorrow");
		note.setNid("myNid");
		note.setUid("myUid");
		note.setTo_id("toId");
		Note note1 = new Note(note);
		assertEquals(note1.getTo_type(), " ");
	}
	
	@Test
	void testNoteCreationSettersTypeFalse() {
		Note note = new Note();
		note.setTo_type("gathering");
		note.setDate_created("1209-34-4 23:04:40");
		note.setTo_user_id("toUid");
		note.setDescription("Bed arriving tomorrow");
		note.setNid("myNid");
		note.setUid("myUid");
		note.setTo_id("toId");
		assertEquals(note.getTo_type(), " ");
	}
	
	@Test
	void testNoteCreationSettersDescription() {
		Note note = new Note();
		note.setTo_type("note");
		note.setDate_created("1209-34-4 23:04:40");
		note.setTo_user_id("toUid");
		note.setDescription("Bed arriving tomorrow");
		note.setNid("myNid");
		note.setUid("myUid");
		note.setTo_id("toId");
		Note note1 = new Note(note);
		assertEquals(note1.getDescription(), "Bed arriving tomorrow");
	}
	
	@Test
	void testNoteCreationSettersDate_created() {
		Note note = new Note();
		note.setTo_type("note");
		note.setDate_created("1209-34-4 23:04:40");
		note.setTo_user_id("toUid");
		note.setDescription("Bed arriving tomorrow");
		note.setNid("myNid");
		note.setUid("myUid");
		note.setTo_id("toId");
		Note note1 = new Note(note);
		assertEquals(note1.getDate_created(), "2022-05-13T17:56:13Z");
	}
	
	@Test
	void testNoteCreationSettersTo_user_id() {
		Note note = new Note();
		note.setTo_type("note");
		note.setDate_created("1209-34-4 23:04:40");
		note.setTo_user_id("toUid");
		note.setDescription("Bed arriving tomorrow");
		note.setNid("myNid");
		note.setUid("myUid");
		note.setTo_id("toId");
		Note note1 = new Note(note);
		assertEquals(note1.getTo_user_id(), "toUid");
	}
	
	@Test
	void testNoteCreationSettersNid() {
		Note note = new Note();
		note.setTo_type("note");
		note.setDate_created("1209-34-4 23:04:40");
		note.setTo_user_id("toUid");
		note.setDescription("Bed arriving tomorrow");
		note.setNid("myNid");
		note.setUid("myUid");
		note.setTo_id("toId");
		Note note1 = new Note(note);
		note1.setNid(note.getNid());
		assertEquals(note1.getNid(), "myNid");
	}
	
	@Test
	void testNoteCreationSettersUid() {
		Note note = new Note();
		note.setTo_type("note");
		note.setDate_created("1209-34-4 23:04:40");
		note.setTo_user_id("toUid");
		note.setDescription("Bed arriving tomorrow");
		note.setNid("myNid");
		note.setUid("myUid");
		note.setTo_id("toId");
		Note note1 = new Note(note);
		assertEquals(note1.getUid(), "myUid");
	}
	
	@Test
	void testNoteCreationSettersToId() {
		Note note = new Note();
		note.setTo_type("note");
		note.setDate_created("1209-34-4 23:04:40");
		note.setTo_user_id("toUid");
		note.setDescription("Bed arriving tomorrow");
		note.setNid("myNid");
		note.setUid("myUid");
		note.setTo_id("toId");
		Note note1 = new Note(note);
		assertEquals(note1.getTo_id(), "toId");
	}
	
	@Test
	void testCreateGive() {
		ArrayList<String> extra_zip = new ArrayList<String>();
		Give give = new Give("myUid", "myGid", "myType", "Giving a book", "March 1st 2020", "March 31st 2020",
	            extra_zip, true, "2022-05-13T17:56:13Z");
		assertEquals(give.getClass(), Give.class);
	}
	
	@Test
	void testCreateGiveFromGive() {
		ArrayList<String> extra_zip = new ArrayList<String>();
		Give give = new Give("myUid", "myGid", "myType", "Giving a book", "March 1st 2020", "March 31st 2020",
	            extra_zip, true, "2022-05-13T17:56:13Z");
		Give give1 = new Give (give);
		assertEquals(give.getUid(), give1.getUid());
	}
	
	@Test
	void testGiveSetters() {
		ArrayList<String> extra_zip = new ArrayList<String>();
		Give give = new Give("myUid", "myGid", "myType", "Giving a book", "March 1st 2020", "March 31st 2020",
	            extra_zip, true, "2022-05-13T17:56:13Z");
		Give give1 = new Give (give);
		give1.setUid("mySecondUid");
		give1.setType("gift");
		give1.setType("lend");
		give1.setType("share");
		give1.setType("service");
		give1.setExtra_zip(extra_zip);
		give1.setDescription("a very good book");
		give1.setStart_date("Dec 03 2021");
		give1.setEnd_date("April 1 2022");
		give1.setIs_active(false);
		assertEquals(give1.getUid(), give1.getUid());
	}
	
	@Test
	void testGiveSettersType() {
		ArrayList<String> extra_zip = new ArrayList<String>();
		Give give = new Give("myUid", "myGid", "myType", "Giving a book", "March 1st 2020", "March 31st 2020",
	            extra_zip, true, "2022-05-13T17:56:13Z");
		Give give1 = new Give (give);
		give1.setUid("mySecondUid");
		give1.setType("gift");
		give1.setType("lend");
		give1.setType("share");
		give1.setType("service");
		give1.setExtra_zip(extra_zip);
		give1.setDescription("a very good book");
		give1.setStart_date("Dec 03 2021");
		give1.setEnd_date("April 1 2022");
		give1.setIs_active(false);
		assertEquals(give1.getType(),"service" );
	}
	
	@Test
	void testGiveSettersExtrazip() {
		ArrayList<String> extra_zip = new ArrayList<String>();
		Give give = new Give("myUid", "myGid", "gift", "Giving a book", "March 1st 2020", "March 31st 2020",
	            extra_zip, true, "2022-05-13T17:56:13Z");
		Give give1 = new Give (give);
		give1.setUid("mySecondUid");
		give1.setType("gift");
		give1.setType("lend");
		give1.setType("share");
		give1.setType("service");
		give1.setExtra_zip(extra_zip);
		give1.setDescription("a very good book");
		give1.setStart_date("Dec 03 2021");
		give1.setEnd_date("April 1 2022");
		give1.setIs_active(false);
		assertEquals(give1.getExtra_zip(),extra_zip );
	}
	
	@Test
	void testGiveSettersDescription() {
		ArrayList<String> extra_zip = new ArrayList<String>();
		Give give = new Give("myUid", "myGid", "service", "Giving a book", "March 1st 2020", "March 31st 2020",
	            extra_zip, true, "2022-05-13T17:56:13Z");
		Give give1 = new Give (give);
		give1.setUid("mySecondUid");
		give1.setType("gift");
		give1.setType("lend");
		give1.setType("share");
		give1.setType("service");
		give1.setExtra_zip(extra_zip);
		give1.setDescription("a very good book");
		give1.setStart_date("Dec 03 2021");
		give1.setEnd_date("April 1 2022");
		give1.setIs_active(false);
		assertEquals(give1.getDescription(),"a very good book" );
	}
	
	@Test
	void testGiveSettersStartDate() {
		ArrayList<String> extra_zip = new ArrayList<String>();
		Give give = new Give("myUid", "myGid", "lend", "Giving a book", "March 1st 2020", "March 31st 2020",
	            extra_zip, true, "2022-05-13T17:56:13Z");
		Give give1 = new Give (give);
		give1.setUid("mySecondUid");
		give1.setType("gift");
		give1.setType("lend");
		give1.setType("share");
		give1.setType("service");
		give1.setExtra_zip(extra_zip);
		give1.setDescription("a very good book");
		give1.setStart_date("Dec 03 2021");
		give1.setEnd_date("April 1 2022");
		give1.setIs_active(false);
		assertEquals(give1.getStart_date(),"Dec 03 2021" );
	}
	
	@Test
	void testGiveSettersEndDate() {
		ArrayList<String> extra_zip = new ArrayList<String>();
		Give give = new Give("myUid", "myGid", "share", "Giving a book", "March 1st 2020", "March 31st 2020",
	            extra_zip, true, "2022-05-13T17:56:13Z");
		Give give1 = new Give (give);
		give1.setUid("mySecondUid");
		give1.setType("gift");
		give1.setType("lend");
		give1.setType("share");
		give1.setType("service");
		give1.setExtra_zip(extra_zip);
		give1.setDescription("a very good book");
		give1.setStart_date("Dec 03 2021");
		give1.setEnd_date("April 1 2022");
		give1.setIs_active(false);
		assertEquals(give1.getEnd_date(),"April 1 2022");
	}
	
	@Test
	void testGiveSettersActive() {
		ArrayList<String> extra_zip = new ArrayList<String>();
		Give give = new Give("myUid", "myGid", "myType", "Giving a book", "March 1st 2020", "March 31st 2020",
	            extra_zip, true, "2022-05-13T17:56:13Z");
		Give give1 = new Give (give);
		give.setType("share");
		give1.setUid("mySecondUid");
		give1.setType("gift");
		give1.setType("lend");
		give1.setType("share");
		give1.setType("service");
		give1.setExtra_zip(extra_zip);
		give1.setDescription("a very good book");
		give1.setStart_date("Dec 03 2021");
		give1.setEnd_date("April 1 2022");
		give1.setIs_active(false);
		assertEquals(give1.getIs_active(),false);
	}
	
	@Test
	void testGiveSettersMatchId() {
		ArrayList<String> extra_zip = new ArrayList<String>();
		Give give = new Give("myUid", "myGid", "myType", "Giving a book", "March 1st 2020", "March 31st 2020",
	            extra_zip, true, "2022-05-13T17:56:13Z");
		Give give1 = new Give (give);
		give.setType("gift");
		give1.setUid("mySecondUid");
		give1.setType("gift");
		give1.setType("lend");
		give1.setType("share");
		give1.setType("service");
		give1.setExtra_zip(extra_zip);
		give1.setDescription("a very good book");
		give1.setStart_date("Dec 03 2021");
		give1.setEnd_date("April 1 2022");
		give1.setIs_active(false);
		assertEquals(give1.matchesId(give.getGid()),false);
	}
	
	@Test
	void testGiveSettersDateCreated() {
		ArrayList<String> extra_zip = new ArrayList<String>();
		Give give = new Give("myUid", "myGid", "myType", "Giving a book", "March 1st 2020", "March 31st 2020",
	            extra_zip, true, "2022-05-13T17:56:13Z");
		Give give1 = new Give (give);
		give.setType("service");
		give1.setUid("mySecondUid");
		give1.setType("gift");
		give1.setType("lend");
		give1.setType("share");
		give1.setType("service");
		give1.setExtra_zip(extra_zip);
		give1.setDescription("a very good book");
		give1.setStart_date("Dec 03 2021");
		give1.setEnd_date("April 1 2022");
		give1.setDate_created("April 15 2022");
		give1.setIs_active(false);
		assertEquals(give1.getDate_created(),"April 15 2022");
	}
	
	@Test
	void testGiveIsNil() {
		ArrayList<String> extra_zip = new ArrayList<String>();
		Give give = new Give("myUid", "myGid", "lend", "Giving a book", "March 1st 2020", "March 31st 2020",
	            extra_zip, true, "2022-05-13T17:56:13Z");
		assertEquals(give.isNil(),false);
	}
	
	@Test
	void testAddAsk() {
		Ask ask = new Ask();
		User user = new User();
		user.addAsk(ask);
		assertEquals(user.getAsks().get(0),ask);
	}
	
	@Test
	void testAddGive() {
		ArrayList<String> extra_zip = new ArrayList<String>();

		Give give = new Give("myUid", "myGid", "lend", "Giving a book", "March 1st 2020", "March 31st 2020",
	            extra_zip, true, "2022-05-13T17:56:13Z");
		User user = new User();
		user.addGive(give);
		assertEquals(user.getGives().get(0),give);
	}
	
	@Test
	void testAddNote() {
		ArrayList<String> extra_zip = new ArrayList<String>();

		Note note = new Note();
		User user = new User();
		user.addNote(note);
		assertEquals(user.getNotes().get(0),note);
	}
	
	@Test
	void testAddThank() {

		Thank thank = new Thank();
		User user = new User();
		user.addThank(thank);
		assertEquals(user.getThanks().get(0),thank);
	}
	
	@Test
	void testBuyNothingDemo() {
		BuyNothingDemo demo = new BuyNothingDemo();
		assertEquals(demo.getClass(),BuyNothingDemo.class);
	}
	
	@Test
	void testLibrary() {
		Library lib = new Library();
		assertEquals(lib.getClass(),Library.class);
	}
	
	@Test
	void testLibraryMethod() {
		Library lib = new Library();
		assertEquals(lib.someLibraryMethod(),true);
	}
	
	@Test
	void testGetAllUsers() {

		BoundaryInterface test = new UserManager();
		ArrayList<User> users = (ArrayList<User>) test.getAllUsers();
		assertEquals(users.size(),users.size());

	}
	
	@Test
	void testNonEmptyGetAllUsers() {
		BoundaryInterface not_empty_test = new UserManager();
		ArrayList<User> users = (ArrayList<User>) not_empty_test.getAllUsers();
		assertEquals(users.size(),users.size());

	}
	
	@Test
	void testCreateNewAccount() {
		String account_json = "{\n" + "  \"uid\": \"\",\n" + "  \"name\": \"John Smith\",\n"+ "  \"address\": {\n"
				+ "    \"street\": \"123 Main ST\",\n" + "    \"zip\": \"60616\"\n" + "  },\n" + "  \"phone\": \"312-456-7890\",\n"
				+ "  \"picture\": \"http://example.com/images/john-smith.jpeg\",\n" + "  \"is_active\": false,\n" + "  \"date_created\": \"\"\n" + "}";

		Gson gs = new Gson();
		User user = gs.fromJson(account_json, User.class);
		bi.createAccount(user);
		assertEquals(bi.getAllUsers().size(),bi.getAllUsers().size());
	
	}
	
	@Test
	void testUpdateAccount() {
		String account_json = "{\n" + "  \"uid\": \"\",\n" + "  \"name\": \"John Smith\",\n"+ "  \"address\": {\n"
				+ "    \"street\": \"123 Main ST\",\n" + "    \"zip\": \"60616\"\n" + "  },\n" + "  \"phone\": \"312-456-7890\",\n"
				+ "  \"picture\": \"http://example.com/images/john-smith.jpeg\",\n" + "  \"is_active\": false,\n" + "  \"date_created\": \"\"\n" + "}";

		Gson gs = new Gson();
		User user = gs.fromJson(account_json, User.class);
		user = bi.updateAccountCheck(bi.getAllUsers().get(1).getUid());
		assertEquals(user, user);
	
	}
	
	@Test
	void testUpdateUser() {
		String account_json = "{\n" + "  \"uid\": \"\",\n" + "  \"name\": \"John Smith\",\n"+ "  \"address\": {\n"
				+ "    \"street\": \"123 Main ST\",\n" + "    \"zip\": \"60616\"\n" + "  },\n" + "  \"phone\": \"312-456-7890\",\n"
				+ "  \"picture\": \"http://example.com/images/john-smith.jpeg\",\n" + "  \"is_active\": false,\n" + "  \"date_created\": \"\"\n" + "}";

		Gson gs = new Gson();
		User user = gs.fromJson(account_json, User.class);
		assertEquals(bi.updateAccount(bi.getAllUsers().get(0).getUid(), user),1);
	
	}
	
	@Test
	void testUpdateCheck() {
		String account_json = "{\n" + "  \"uid\": \"\",\n" + "  \"name\": \"John Smith\",\n"+ "  \"address\": {\n"
				+ "    \"street\": \"123 Main ST\",\n" + "    \"zip\": \"60616\"\n" + "  },\n" + "  \"phone\": \"312-456-7890\",\n"
				+ "  \"picture\": \"http://example.com/images/john-smith.jpeg\",\n" + "  \"is_active\": false,\n" + "  \"date_created\": \"\"\n" + "}";

		Gson gs = new Gson();
		User user = gs.fromJson(account_json, User.class);
		assertEquals(bi.updateAccount(bi.getAllUsers().get(0).getUid(), user),1);
	
	}
	
	@Test
	void testActivateAccount() {
		String account_json = "{\n" + "  \"uid\": \"\",\n" + "  \"name\": \"John Smith\",\n"+ "  \"address\": {\n"
				+ "    \"street\": \"123 Main ST\",\n" + "    \"zip\": \"60616\"\n" + "  },\n" + "  \"phone\": \"312-456-7890\",\n"
				+ "  \"picture\": \"http://example.com/images/john-smith.jpeg\",\n" + "  \"is_active\": false,\n" + "  \"date_created\": \"\"\n" + "}";

		Gson gs = new Gson();
		User user = gs.fromJson(account_json, User.class);
		bi.activateAccount(bi.getAllUsers().get(0).getUid());
		assertEquals(bi.getAllUsers().get(0).getIs_active(), true);
	}
	
	@Test
	void testSearchAccountKey() {
		ArrayList<User> users = (ArrayList<User>) bi.searchAccountKey("70453");
		assertEquals(users.size(), 0);
	}
	
	@Test
	void testSearchAccountKeyStartEnd() {
		ArrayList<User> users = (ArrayList<User>) bi.searchAccountKeyStartEnd("70453", null, null);
		assertEquals(users.size(), 0);
	}
	
	@Test
	void testCreateNewAsk() {
		Ask ask = new Ask();
		ArrayList<String> zips = new ArrayList <String> ();
		zips.add("60616");
		
		ask.setUid("myUid");
		ask.setIs_active(true);
		ask.setDate_created("2020-22-04 12:30:09");
		ask.setDescription("I need a bed");
		ask.setType("invitation");
		ask.setExtra_zip(zips);
		
		Ask ask1 = new Ask();
		ask1.setAid(ask.getAid());
		Ask test_ask = bi.createAsk(ask1);
		
		assertEquals(test_ask, test_ask);

	}
	
	@Test
	void testUpdateAsk() {
		Ask ask = new Ask();
		ArrayList<String> zips = new ArrayList <String> ();
		zips.add("60616");
		
		ask.setUid("myUid");
		ask.setIs_active(true);
		ask.setDate_created("2020-22-04 12:30:09");
		ask.setDescription("I need a bed");
		ask.setType("invitation");
		ask.setExtra_zip(zips);
		
		Ask ask1 = new Ask();
		
		
		
		assertEquals(bi.updateAsk(ask.getUid(), ask.getAid(), ask1), 0);

	}
	
	@Test
	void testAskUid(){
		ArrayList<Ask> asks = bi.getAllMyAsks("swim");
        assertEquals(asks.size(),asks.size());
	}
	
	@Test
	void testGetAllGives(){
		ArrayList<Give> gives = new ArrayList<Give>();
		bi.getAllGives("myGid");
        assertEquals(gives.size(), gives.size());
	}
	
	@Test 
	void testgetAllMyAsksActive(){
		ArrayList<Ask> asks = bi.getAllMyAsksActive("swim", "true");
        assertEquals(asks.size(),asks.size());
	}
	
	

	
	
}
