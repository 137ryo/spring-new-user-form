package com.example.demo.request;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class ZipCodeRequest implements Serializable {

	/** 郵便番号 */
	@NotEmpty(message = "郵便番号を入力してください")
	@Pattern(regexp = "^[0-9]{7}$", message = "郵便番号の形式が正しくありません。ハイフンは入力しないでください。")
	private String zipcode;
}
