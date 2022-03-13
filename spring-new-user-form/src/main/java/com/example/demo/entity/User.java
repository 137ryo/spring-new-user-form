package com.example.demo.entity;

import java.util.Date;

import lombok.Data;

@Data
public class User {

	/** 名前(姓) */
	private String firstName;

	/** 名前(名) */
	private String lastName;

	/** 名前(セイ) */
	private String firstKanaName;

	/** 名前(メイ) */
	private String lastKanaName;

	/** 性別 */
	private String gender;

	/** 生年月日 */
	private String year;
	private String month;
	private String day;

	/** メールアドレス */
	private String email;

	/** ユーザー名 */
	private String username;

	/** パスワード */
	private String password;

	/** 電話番号 */
	private String phone;

	/** 郵便番号 */
	private String zipcode;

    /** 都道府県コード */
	private String prefcode;

    /** 都道府県 */
	private String prefectures;

    /** 市区町村 */
	private String city;

    /** 地域 */
	private String region;

	/** 番地 */
	private String address1;

	/** 建物・部屋番号 */
	private String address2;

	/** メールマガジン */
	private String magazin;

	/** 利用規約 */
	private String agreeTeams;

	/** 作成日時 */
	private Date createDate;

	/** 更新日時 */
	private Date updateDate;
}
