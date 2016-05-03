package library.dataaccess;

import java.util.List;

import library.domain.Member;

public interface IMemberDao {

	void saveMember(Member member);

	List<Member> getRegisteredMembers();

	void updateMember(Member member);

	void unregisterMember(Integer id);

	Member findMember(Integer id);

}