package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.UserAddRequest;

@Service
public class UserAddService {

	/** ユーザー情報 */
	private UserRepository userRepository;

	/**
	 * 全検索
	 * @return
	 */
	public List<User> searchAll() {
		return userRepository.findAll();
	}

	public void insertUser(UserAddRequest userAddRequest) {
		Date now = new Date();
		User user = new User();

		user.setFirstName(userAddRequest.getFirstName());
		user.setLastName(userAddRequest.getLastName());
		user.setFirstKanaName(userAddRequest.getFirstKanaName());
		user.setLastKanaName(userAddRequest.getLastKanaName());
		user.setGender(userAddRequest.getGender());
		user.setYear(userAddRequest.getYear());
		user.setMonth(userAddRequest.getMonth());
		user.setDay(userAddRequest.getDay());
		user.setUsername(userAddRequest.getUsername());

		//TODO 暗号化
		user.setPassword(userAddRequest.getPassword());

		user.setPhone(userAddRequest.getPhone());
		user.setZipcode(userAddRequest.getZipcode());
		user.setPrefectures(userAddRequest.getPrefectures());
		user.setCity(userAddRequest.getCity());
		user.setRegion(userAddRequest.getRegion());
		user.setAddress1(userAddRequest.getAddress1());
		user.setAddress2(userAddRequest.getAddress2());

		//TODO マガジン,利用規約

//	    user.setName(userRequest.getName());
//	    user.setAddress(userRequest.getAddress());
//	    user.setPhone(userRequest.getPhone());

	    user.setCreateDate(now); //作成日時
	    user.setUpdateDate(now); //更新日時
	    userRepository.save(user);
	  }
}
