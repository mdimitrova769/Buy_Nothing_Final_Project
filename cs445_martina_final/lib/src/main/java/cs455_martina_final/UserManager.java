package cs455_martina_final;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class UserManager implements BoundaryInterface {
	
	private static ArrayList<User> Accounts = new ArrayList<User>();
	private static ArrayList<User> CSR_Accounts = new ArrayList<User>();
	private static ArrayList<Report> Reports = new ArrayList<Report>(); 
	private static ArrayList<User> AllAccounts = new ArrayList<User>();

	
	private User findById(String lid) {
    	System.out.println(lid);
        Iterator<User> li = AllAccounts.listIterator();
        while(li.hasNext()) {
            User l = li.next();
            if(l.matchesId(lid)) return(l);
        }
        return(new NullUser());
    }
	
	private boolean findUserExisting(String lid) {
    	System.out.println(lid);
        Iterator<User> li = Accounts.listIterator();
        while(li.hasNext()) {
            User l = li.next();
            if(l.matchesId(lid)) return(true);
        }
        Iterator<User> li2 = CSR_Accounts.listIterator();
        while(li2.hasNext()) {
            User l1 = li2.next();
            if(l1.matchesId(lid)) return(true);
        }
        return(false);
    }
	
	@Override
	public ArrayList<User> getAllUsers() {
		
		if (Accounts.isEmpty()) {
			  User user1 = new User("Virgil Bistriceanu", "10 West 31st ST", "60616", "http://example.com/images/virgil-bistriceanu.jpeg", "123-435-8654", true, "2022-03-13T17:56:13Z");
			  User user2 = new User("Jane Smith", "123 2nd ST", "60607", "http://example.com/images/jane-smith.jpeg", "217-456-7890", false, "2022-03-13T17:56:13Z");
			  User user3 = new User("CSR #1", "101 W Main St.", "60010", "http://example.com/images/csr-1.jpeg", "123-435-8654", true, "2022-03-13T17:56:13Z");
			
			  Accounts.add(user1);
			  AllAccounts.add(user1);
			  Accounts.add(user2);
			  AllAccounts.add(user2);
			  
			  CSR_Accounts.add(user3);
			  AllAccounts.add(user3);
			  
			  return(AllAccounts);
		}
		else {
		    return(AllAccounts);
		}
		
		
	}
	
	@Override
	public User createAccount(User il) {
		
		User user = new User(il);
		
		if (user.getName().contains("csr")) {
			return user;
		}
		else {
			
				if (findUserExisting(il.getUid()) == true) {
					return user;
				}
				else {
					Accounts.add(user);
					AllAccounts.add(user);
				}	
			
		}
		return user;
	}

	@Override
	public int updateAccount(String id, User user1) {
		User user = findById(id);
    	//update user stuff
		if ((user.getIs_active() == false) && (user1.getIs_active() == true)) {
			return 0;
		}
		
		else { 
			user.setAddress(user1.getAddress());
			user.setName(user1.getName());
			user.setPhone(user1.getPhone());
			user.setPicture(user1.getPicture());
			return 1;
		}
	}

	@Override
	public User updateAccountCheck(String lid) {
		User user1 = findById(lid);
		
		return user1;
		
	}
	
	@Override
	public User activateAccount(String id) {
		User user = findById(id);
		user.setIs_active(true);
		return user;
	}

	@Override
	public ArrayList<User> searchAccountKey(String keyword) {
		ArrayList<User> returnArrayWithKey = new ArrayList<User>();
		Iterator<User> next_user = AllAccounts.listIterator();
		
        while(next_user.hasNext()) {
            User user = next_user.next();
            if (user.getAddress().getStreet().toString().toLowerCase().contains(keyword.toLowerCase())) {
            	user.setPicture("here");
            	returnArrayWithKey.add(user);
            }
            else {
            	if (user.getAddress().getZip().toString().toLowerCase().contains(keyword.toLowerCase())) {
            		user.setPicture("here");
            		returnArrayWithKey.add(user);
                }
            	else {
            		if (user.getName().toString().toLowerCase().contains(keyword.toLowerCase())) {
            			user.setPicture("here");
            			returnArrayWithKey.add(user);
                    }
            		else {
            			if (user.getPhone().toString().toLowerCase().contains(keyword.toLowerCase())) {
            				user.setPicture("here");
            				returnArrayWithKey.add(user);
                        }
            		}
                    
            	}
                
            }
        }
        return returnArrayWithKey;
	}
	
	@Override
	public List<User> searchAccountKeyStartEnd(String keyword, String start_date, String end_date) {
		ArrayList<User> returnArrayWithKey = new ArrayList<User>();
		Iterator<User> next_user = AllAccounts.listIterator();
        return returnArrayWithKey;
	}
	
	@Override
	public void deleteUser(String lid) throws NoSuchElementException {
		User user = findById(lid);
    	if (user.isNil()) {
    		throw new NoSuchElementException();
    	} else {
    		Accounts.remove(user);
    		
    	}
		
	}

	
	//--------------------------------------------------------------------------------
	//ASK-------------------------------------------------------------------------------------------------------------
	
	@Override
	public Ask createAsk (Ask ask1) {
		User user = findById(ask1.getUid());
		if (user.getIs_active()) {
			Ask ask = new Ask(ask1);
			user.getAsks().add(ask);
			return ask;
		}
		else {
			Ask ask3 = new Ask();
			return ask3;
		}
		
	}

	@Override
	public Ask viewAsk(String aid) {
		for (int i=0; i<Accounts.size(); i++)
		{
			ArrayList<Ask> asks = Accounts.get(i).getAsks();
			for (int j=0; j<asks.size(); j++)
			{
				if (asks.get(j).getAid().equals(aid)) {
					return asks.get(j);
				}
			}
		}
		Ask ask = new Ask();
		return ask;
	}

	@Override
	public int updateAsk(String uid, String aid, Ask ask) {
		User user = findById(uid);
		int length = user.getAsks().size();
		for (int i=0; i<length; i++) {
			if (user.getAsks().get(i).getAid().equalsIgnoreCase(aid) && user.getAsks().get(i).getIs_active() == true) {
				user.getAsks().get(i).setType(ask.getType());
				user.getAsks().get(i).setDescription(ask.getDescription());
				user.getAsks().get(i).setStart_date(ask.getStart_date());
				user.getAsks().get(i).setEnd_date(ask.getEnd_date());
				user.getAsks().get(i).setExtra_zip(ask.getExtra_zip());
				return 1;
			}
		}
		return 0;
    	
			
			
		}

	@Override
	public Ask deactivateAsk(String uid, String aid) {
		User user = findById(uid);
		int length = user.getAsks().size();
		for (int i=0; i<length; i++) {
			if (user.getAsks().get(i).getAid().equalsIgnoreCase(aid) && user.getAsks().get(i).getIs_active() == true) {
				user.getAsks().get(i).setIs_active(false);
				return user.getAsks().get(i);
			}
		}
		return null;
	}

	@Override
	public ArrayList<Ask> getAllMyAsks(String uid) {
		
			User user = findById(uid);
			return user.getAsks();
    }
	
	@Override
	public ArrayList<Ask> getAllMyAsksActive(String uid, String is_active) {
		ArrayList<Ask> return_array = new ArrayList<Ask>();
		
		if (is_active.equalsIgnoreCase("true")) {
			User user = findById(uid);
			int length = user.getAsks().size();
			
			for (int i=0; i<length; i++) {
				if (user.getAsks().get(i).getIs_active()) {
					return_array.add(user.getAsks().get(i));
				}
			}
			return return_array;
		} else {
			if (is_active.equalsIgnoreCase("false")) {
				User user = findById(uid);
				int length = user.getAsks().size();
				
				for (int i=0; i<length; i++) {
					if (!user.getAsks().get(i).getIs_active()) {
						return_array.add(user.getAsks().get(i));
					}
				}
				return return_array;
			}
		}
		return null;
    }
	
	@Override
	public ArrayList<Ask> getAllActiveAsksBy(String viewed_by_id) {
				
				ArrayList<Ask> asks = new ArrayList<Ask>();
				User user = findById(viewed_by_id);
				
				if (user.getName().toLowerCase().contains("csr")) {
					
					for (int i=0; i<Accounts.size(); i++) {
						asks.addAll(Accounts.get(i).getAsks());
					}
					
					return asks;
				} else {
					//all visible to id
					String zip_to_look_for = user.getAddress().getZip();
					
					ArrayList<Ask> result_array = new ArrayList<Ask> ();
					result_array.addAll(user.getAsks());
					int length2;
					for (int i=0; i<Accounts.size(); i++) {
						//get every user asks
						
						ArrayList<Ask> ask_list_to_check = Accounts.get(i).getAsks();
						length2 = Accounts.get(i).getAsks().size();
						
						int zips = 0;
						
						for (int j=0; j<length2; j++) {
							zips = ask_list_to_check.get(j).getExtra_zip().size();
							for (int k=0; k<zips; k++) {
								if (ask_list_to_check.get(j).getExtra_zip().get(k).equalsIgnoreCase(zip_to_look_for) ){
									result_array.add(ask_list_to_check.get(j));
								}
							}
						}
					}
					return result_array;
				}
	}


	@Override
	public ArrayList<Ask> getAllActiveAsksByActive(String viewed_by_id, String is_active) {
	
		boolean active = false;
		if (is_active.equalsIgnoreCase("true")) {
			active = true;
		}
		if (is_active.equalsIgnoreCase("false")) {
			active = false;
		}
		
		if (viewed_by_id.equalsIgnoreCase(null)) {
			
			return null;
		}
		else {
			User user = findById (viewed_by_id);
			
			if (user.getName().toLowerCase().contains("csr")) {
				
				if (is_active.equalsIgnoreCase(null)) {
					//all asks
					ArrayList<Ask> asks = new ArrayList<Ask>();
					for (int i=0; i<Accounts.size(); i++) {
						asks.addAll(Accounts.get(i).getAsks());
					}
					return asks;
					
				}
				else {
					if (active) {
						//all active asks
						ArrayList<Ask> asks = new ArrayList<Ask>();
						int length; 
						for (int i=0; i<Accounts.size(); i++) {
							length = Accounts.get(i).getAsks().size();
							
							ArrayList<Ask> ask_list_to_check = Accounts.get(i).getAsks();
							for (int j=0; j<length; j++) {
								if (ask_list_to_check.get(j).getIs_active()) {
									asks.add(ask_list_to_check.get(j));
								}
							}
						}
						return asks;
					}
					else {
						//all inactive asks
						ArrayList<Ask> asks = new ArrayList<Ask>();
						int length; 
						for (int i=0; i<Accounts.size(); i++) {
							length = Accounts.get(i).getAsks().size();
							
							ArrayList<Ask> ask_list_to_check = Accounts.get(i).getAsks();
							for (int j=0; j<length; j++) {
								if (!ask_list_to_check.get(j).getIs_active()) {
									asks.add(ask_list_to_check.get(j));
								}
							}
						}
						return asks;
					}
				}
			}
			else {
				if (is_active.equalsIgnoreCase("")) {
					//all visible to id
					String zip_to_look_for = user.getAddress().getZip();
					
					ArrayList<Ask> result_array = new ArrayList<Ask> ();
					
					result_array.addAll(user.getAsks());
					
					int length2;
					for (int i=0; i<Accounts.size(); i++) {
						//get every user asks
						
						ArrayList<Ask> ask_list_to_check = Accounts.get(i).getAsks();
						length2 = Accounts.get(i).getAsks().size();
						
						int zips = 0;
						
						for (int j=0; j<length2; j++) {
							zips = ask_list_to_check.get(j).getExtra_zip().size();
							for (int k=0; k<zips; k++) {
								if (ask_list_to_check.get(j).getExtra_zip().get(k).equalsIgnoreCase(zip_to_look_for) ){
									result_array.add(ask_list_to_check.get(j));
								}
							}
						}
					}
					return result_array;
					
				}
				else {
					if (active) {
						//all active visible to id
						String zip_to_look_for = user.getAddress().getZip();
						
						ArrayList<Ask> result_array = new ArrayList<Ask> ();
						
						result_array.addAll(user.getAsks());
						
						int length2;
						for (int i=0; i<Accounts.size(); i++) {
							//get every user asks
							
							ArrayList<Ask> ask_list_to_check = Accounts.get(i).getAsks();
							length2 = Accounts.get(i).getAsks().size();
							
							int zips = 0;
							
							for (int j=0; j<length2; j++) {
								if (ask_list_to_check.get(j).getIs_active()) {
								zips = ask_list_to_check.get(j).getExtra_zip().size();
								for (int k=0; k<zips; k++) {
									if (ask_list_to_check.get(j).getExtra_zip().get(k).equalsIgnoreCase(zip_to_look_for) ){
										result_array.add(ask_list_to_check.get(j));
									}
								}
							}
							}
						}
						return result_array;
						
					}
					else {
						//all inactive visible to id
                        String zip_to_look_for = user.getAddress().getZip();
						
						ArrayList<Ask> result_array = new ArrayList<Ask> ();
						
						result_array.addAll(user.getAsks());
						
						int length2;
						for (int i=0; i<Accounts.size(); i++) {
							//get every user asks
							
							ArrayList<Ask> ask_list_to_check = Accounts.get(i).getAsks();
							length2 = Accounts.get(i).getAsks().size();
							
							int zips = 0;
							
							for (int j=0; j<length2; j++) {
								if (!ask_list_to_check.get(j).getIs_active()) {
								zips = ask_list_to_check.get(j).getExtra_zip().size();
								for (int k=0; k<zips; k++) {
									if (ask_list_to_check.get(j).getExtra_zip().get(k).equalsIgnoreCase(zip_to_look_for) ){
										result_array.add(ask_list_to_check.get(j));
									}
								}
							  }
						   }
						}
						return result_array;
					}
				}
			}
		}
}

	@Override
	public void deleteAsk(String uid, String aid) throws NoSuchElementException {
		User user = findById(uid);
    	
		int length = user.getAsks().size();
		
		for (int i=0; i<length; i++) {
			if (user.getAsks().get(i).getAid().equalsIgnoreCase(aid)) {
				if (user.isNil()) {
		    		throw new NoSuchElementException();
		    	} else {
		    		user.getAsks().remove(user.getAsks().get(i));
		    	}
				
			}
		}
		
	}

	
	
	//GIVE-------------------------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------------------
	
	@Override
	public Give createGive(String uid, Give give1) {
		Give give = new Give(give1);
		User user = findById(uid);
		if (user.getIs_active() == true ) {
			user.addGive(give);
			return give;
		}
		else {
			return null;
		}
		
		
	}

	@Override
	public int updateGive(String uid, String gid, Give give) {
		User user = findById(uid);
		int length = user.getGives().size();
		for (int i=0; i<length; i++) {
			if (user.getGives().get(i).getGid().equalsIgnoreCase(gid) && user.getAsks().get(i).getIs_active() == true) {
				user.getGives().get(i).setType(give.getType());
				user.getGives().get(i).setDescription(give.getDescription());
				user.getGives().get(i).setStart_date(give.getStart_date());
				user.getGives().get(i).setEnd_date(give.getEnd_date());
				user.getGives().get(i).setExtra_zip(give.getExtra_zip());
				return 1;
			}
		}
		return 0;
	}

	@Override
	public Give verifyGiveUpdated(String gid) {
		for (int i=0; i<Accounts.size(); i++)
		{
			ArrayList<Give> gives = Accounts.get(i).getGives();
			for (int j=0; j<gives.size(); j++)
			{
				if (gives.get(j).getGid().equals(gid)) {
					return gives.get(j);
				}
			}
		}
		return null;
	}

	@Override
	public Give deactivateGive(String uid, String gid) {
		for (int i=0; i<Accounts.size(); i++)
		{
			ArrayList<Give> gives = Accounts.get(i).getGives();
			for (int j=0; j<gives.size(); j++)
			{
				if (gives.get(j).getGid().equals(gid)) {
					gives.get(j).setIs_active(false);
					return gives.get(j);
				}
			}
		}
		return null;
	}
	
	
	@Override
	public ArrayList<Give> getAllGives(String uid) {
		User user = findById(uid);
		ArrayList<Give> gives = new ArrayList<Give>();
		return user.getGives();
	}
	
	
	@Override
	public ArrayList<Give> getAllActiveGivesBy(String uid) {
			User user = findById(uid);
			ArrayList<Give> array_csr = new ArrayList<Give>();
			ArrayList<Give> array_normal_user = new ArrayList<Give>();

			if (user.getName().toLowerCase().contains("csr")) {
				//return all gives 
				for (int i=0; i<Accounts.size(); i++) {
					array_csr.addAll(Accounts.get(i).getGives());
				}
				return array_csr;
			}
			else {
				String zip = user.getAddress().getZip();
				//return all gives for uid
				array_normal_user.addAll(user.getGives());
				//return all gives visible to uid
				for (int i=0; i<Accounts.size(); i++)
				{
					//I get one account
					//every account has one give array
					//now go through array
					for (int j=0; j<Accounts.get(i).getGives().size(); j++) {
						//now I get every give
						Give give = Accounts.get(i).getGives().get(j);
						//take the zip code array
						ArrayList<String> zips = Accounts.get(i).getGives().get(j).getExtra_zip();
						
						for (int k=0; k<zips.size(); k++) {
							if (zips.get(k).equalsIgnoreCase(zip)) {
								array_normal_user.add(give);
							}
						}
						
						
					}
				}
				return array_normal_user;
			}
	}

	@Override
	public ArrayList<Give> getAllActiveGivesByActive(String uid, String is_active) {
		
			ArrayList<Give> active_gives = new ArrayList<Give>();
			ArrayList<Give> non_active_gives = new ArrayList<Give>();
			ArrayList<Give> user_gives = getAllActiveGivesBy(uid);
			
			for (int i=0; i<user_gives.size(); i++)
			{
				if (user_gives.get(i).getIs_active()) {
					user_gives.get(i).setDate_created("now");
					active_gives.add(user_gives.get(i));
				}
				else {
					user_gives.get(i).setDate_created("now");
					non_active_gives.add(user_gives.get(i));

				}
			}
			
			if (is_active.equalsIgnoreCase("true")) {
				return active_gives;
			}
			else {
				return non_active_gives;
			}
		
		
		
		
	}


	
	//THANK-------------------------------
	//------------------------------------

	@Override
	public Thank createThank(Thank thank1) {
		Thank thank = new Thank(thank1);
		User user = findById(thank1.getUid());
		
			user.addThank(thank);
			return thank;
		
	}

	@Override
	public ArrayList<Thank> getAllMyThanks(String uid) {
		User user = findById(uid);
		return user.getThanks();
	}

	@Override
	public ArrayList<Thank> getAllUserThanks(String uid) {
		for (int i=0; i<Accounts.size(); i++)
		{
			User user = findById(uid);
			if (user.getUid().equals(uid)) {
				return user.getThanks();
			}
		}
		return null;
	}
	
	//NOTE--------------------------------------
	//-------------------------------------------

	@Override
	public Note createNote(Note note1) {
		Note note = new Note(note1);
		User user = findById(note1.getUid());
		
			user.addNote(note);
			return note;
	}

	@Override
	public int updateNote(String nid, Note note) {
		
	for(int j=0; j<Accounts.size(); j++) {
		User user = Accounts.get(j);
		int length = user.getNotes().size();
		for (int i=0; i<length; i++) {
			if (user.getNotes().get(i).getNid().equalsIgnoreCase(nid)) {
				user.getNotes().get(i).setTo_type(note.getTo_type());
				user.getNotes().get(i).setTo_user_id(note.getTo_user_id());
				user.getNotes().get(i).setDescription(note.getDescription());
				return 1;
			}
		}
		
	}
	return 0;
   }

	@Override
	public ArrayList<Note> getAllNotes() {
		
		ArrayList<Note> notes1 = new ArrayList<Note>();
		
		for(int j=0; j<Accounts.size(); j++) {
			User user = Accounts.get(j);
			notes1.addAll(user.getNotes());
		}
		return(notes1);
	}
	
	//REPORTS-------------------------------
	//-------------------------------------

	@Override
	public ArrayList<Report> getAllReports() {
		if (Reports.isEmpty()) {
			Report report1 = new Report("Asks/gives broken down by zip");  
			Report report2 = new Report("Asks/gives and communications for a user");  

			  Reports.add(report1);
			  Reports.add(report2);
			
			  
			 return Reports;
		}
		else {
		
			
		    return(Reports);
		  
		}
	}
	
	//VARIA--------------------------------

	@Override
	public ArrayList<Note> searchNotes(String keyword, String start_date, String end_date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Give> getAllGivesActive(String uid, String b) {
		// TODO Auto-generated method stub
		return null;
	}




	
	
	
}
