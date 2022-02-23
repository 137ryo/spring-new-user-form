package com.example.demo.request;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class UserAddRequest implements Serializable {

	/** 郵便番号 */
	@NotEmpty(message = "郵便番号を入力してください")
	@Pattern(regexp = "^[0-9]{7}$", message = "郵便番号の形式が正しくありません。ハイフンは入力しないでください。")
	private String zipcode;

//	/** ユーザID */
//	@NotEmpty(message = "ユーザIDを入力してください")
//	@Pattern(regexp = "^[a-z0-9_-]{4,16}$", message = "ユーザIDは4文字以上16文字以下で入力してください")
//	private String userId;
//
//	/** ユーザ名 */
//	@NotEmpty(message = "ユーザ名を入力してください")
//	@Size(max = 20, message = "ユーザ名は20字以内で入力してください")
//	private String username;
//
//	/** パスワード */
//	@NotEmpty(message = "パスワードを入力してください")
//	@Pattern(regexp = "^[a-z0-9_-]{8,16}$", message = "パスワードは8文字以上16文字以下で入力してください")
//	private String password;
//
//	/** パスワード(確認) */
//	@NotEmpty(message = "確認のため、もう一度パスワードを入力してください")
//	private String passwordConfirm;
//
//	/** パスワード一致確認 */
//	@AssertTrue(message = "パスワードが一致しません")
//	public boolean isPasswordValid() {
//		if (password != null || !password.isEmpty()) {
//			return password.equals(passwordConfirm);
//		}
//		return false;
//	}
//
//	/** 電話番号 */
//	@NotEmpty(message = "電話番号を入力してください")
//	@Pattern(regexp = "0\\d{1,4}-\\d{1,4}-\\d{4}", message = "電話番号の形式で入力してください")
//	private String phone;

}
