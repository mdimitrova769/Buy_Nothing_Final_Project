package cs455_martina_final;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.QueryParam;

public interface BoundaryInterface {
	
	List<User> getAllUsers();
	User createAccount(User user);
	int updateAccount(String uid, User user);
	User updateAccountCheck(String uid);
	User activateAccount(String uid);
	List<User> searchAccountKey(String uid);
	List<User> searchAccountKeyStartEnd(String uid, String start_date, String end_date);
	void deleteUser(String lid);
	
	//Ask
	Ask createAsk(Ask ask);
	Ask viewAsk(String aid);
	int updateAsk(String uid,String aid, Ask ask);
	Ask deactivateAsk(String uid,String aid);
	ArrayList<Ask> getAllMyAsks(String uid);
	ArrayList<Ask> getAllMyAsksActive(String uid, String is_active);
	ArrayList<Ask> getAllActiveAsksByActive(String viewed_by_id, String is_active) ;
	ArrayList<Ask> getAllActiveAsksBy(String viewed_by_id) ;

	void deleteAsk(String uid, String aid);
	
	//Give
	Give createGive(String uid, Give give);
	int updateGive(String uid,String gid, Give give);
	Give verifyGiveUpdated(String gid);
	Give deactivateGive(String uid, String gid);
	ArrayList<Give> getAllGives(String uid);
	ArrayList<Give> getAllGivesActive(String uid, String b);
	ArrayList<Give> getAllActiveGivesBy(String uid);
	ArrayList<Give> getAllActiveGivesByActive(String uid, String is_active);

	//Thank
	Thank createThank(Thank thank);
	ArrayList<Thank> getAllMyThanks(String uid);
	ArrayList<Thank> getAllUserThanks(String uid);
	
	//Note
	Note createNote(Note note);
	int updateNote(String nid, Note note);
	ArrayList<Note> getAllNotes();
	
	//Reports
	ArrayList<Report> getAllReports();
	
	//Varia
	ArrayList<Note> searchNotes(String keyword, String start_date,String end_date);

}
