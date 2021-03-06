package com.incture.zp.ereturns.repositoriesimpl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.incture.zp.ereturns.dto.ResponseDto;
import com.incture.zp.ereturns.model.User;
import com.incture.zp.ereturns.repositories.UserRepository;
import com.incture.zp.ereturns.utils.GetReferenceData;
import com.incture.zp.ereturns.utils.ImportExportUtil;
import com.incture.zp.ereturns.utils.SequenceNumberGen;
import com.incture.zp.ereturns.utils.ServiceUtil;

@Repository()
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	ImportExportUtil importExportUtil;

	public String getNextSeqNumber(String referenceCode, int noOfDigits) {
		return SequenceNumberGen.getInstance().getNextSeqNumber(referenceCode, noOfDigits,
				sessionFactory.getCurrentSession());
	}

	@Override
	public ResponseDto addUser(User user) {
		ResponseDto responseDto = new ResponseDto();
		String userId = getNextSeqNumber(new GetReferenceData().execute("U"), 6);
		if (user.getUserId() == null || user.getUserId().equals("")) {
			user.setUserId(userId);
			responseDto.setMessage("User " + userId + " Created Successfully");
		}
		
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		responseDto.setMessage("User " + user.getUserId() + " Updated Successfully");
		responseDto.setStatus("OK");
		return responseDto;
	}

	@Override
	public User getUserById(String id) {
		User user = (User) sessionFactory.getCurrentSession().get(User.class, id);
		
		return user;
	}

	@Override
	public ResponseDto delete(User user) {
		ResponseDto responseDto = new ResponseDto();
		String queryStr = "DELETE User WHERE userId=:userId";
		if (!ServiceUtil.isEmpty(user)) {
			Query query = sessionFactory.getCurrentSession().createQuery(queryStr);
			query.setParameter("userId", user.getUserId());
			

			int result = query.executeUpdate();
			if (result > 0) {
				responseDto.setMessage("Deleted Successfully");
				responseDto.setStatus("OK");
			} else {
				responseDto.setMessage("Delete Unsuccessfully");
				responseDto.setStatus("ERROR");
			}
		}
		return responseDto;
	}

}
