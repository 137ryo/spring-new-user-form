package com.example.demo.request;

import java.io.Serializable;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserAddRequest implements Serializable {

	/** 苗字 */
	@NotEmpty(message = "苗字を入力してください")
	private String firstName;

	/** 名前 */
	@NotEmpty(message = "名前を入力してください")
	private String lastName;

	/** 苗字(カナ) */
	@NotEmpty(message = "苗字(カナ)を入力してください")
	private String firstKanaName;

	/** 名前(カナ) */
	@NotEmpty(message = "名前(カナ)を入力してください")
	private String lastKanaName;

	/** 性別 */
	private int gender;

	/** 生年月日(年) */
	@NotEmpty(message = "生年月日(年)を入力してください")
	private int year;

	/** 生年月日(月) */
	@NotEmpty(message = "生年月日(月)を入力してください")
	private int month;

	/** 生年月日(日) */
	@NotEmpty(message = "生年月日(日)を入力してください")
	private int day;

	/** メールアドレス */
	@NotEmpty(message = "メールアドレスを入力してください")
	@Pattern(regexp = "^[a-zA-Z0-9_.+-]+@([a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9]*\\.)+[a-zA-Z]{2,}$",
	message = "メールアドレスの形式で入力してください")
	private String email;

	/** ユーザ名 */
	@NotEmpty(message = "ユーザ名を入力してください")
	@Size(max = 20, message = "ユーザ名は20字以内で入力してください")
	private String username;

	/** パスワード */
	@NotEmpty(message = "パスワードを入力してください")
	@Pattern(regexp = "^[a-z0-9_-]{8,16}$", message = "パスワードは8文字以上16文字以下で入力してください")
	private String password;

	/** パスワード(確認) */
	@NotEmpty(message = "確認のため、もう一度パスワードを入力してください")
	private String passwordConfirm;

	// パスワード一致確認
	@AssertTrue(message = "パスワードが一致しません")
	public boolean isPasswordValid() {
		if (password != null || !password.isEmpty()) {
			return password.equals(passwordConfirm);
		}
		return false;
	}

	/** 電話番号 */
	@NotEmpty(message = "電話番号を入力してください")
	@Pattern(regexp = "0\\d{1,4}-\\d{1,4}-\\d{4}", message = "電話番号の形式で入力してください")
	private String phone;

	/** 郵便番号 */
	@NotEmpty(message = "郵便番号を入力してください")
	@Pattern(regexp = "^[0-9]{7}$", message = "郵便番号の形式が正しくありません。ハイフンは入力しないでください。")
	private String zipcode;

	/** 都道府県 */
	@NotEmpty(message = "都道府県を入力してください")
	private String prefectures;

	/** 市区町村 */
	@NotEmpty(message = "市区町村を入力してください")
	private String city;

	/** 地域名 */
	@NotEmpty(message = "地域名を入力してください")
	private String region;

	/** 番地 */
	@NotEmpty(message = "番地を入力してください")
	private String address1;

	/** 建物名・部屋番号 */
	@NotEmpty(message = "建物名・部屋番号を入力してください")
	private String address2;

	/** メールマガジン */
	private int magazin;

	/** 利用規約 */
	@NotEmpty(message = "利用規約を確認してください")
	private int agreeTeam;
}
