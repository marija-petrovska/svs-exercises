package library.dataaccess;

import java.util.List;

import library.domain.Member;

public interface IMemberDao {

	void saveMember(Member member);

	List<Member> getRegisteredMembers();

	void updateMember(Integer id, String email, String name);

	void unregisterMember(Integer id);

}