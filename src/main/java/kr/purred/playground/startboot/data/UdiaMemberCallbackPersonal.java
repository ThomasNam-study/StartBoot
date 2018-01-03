package kr.purred.playground.startboot.data;

import lombok.Data;

@Data
public class UdiaMemberCallbackPersonal
{
	/**
	 * 이름
	 */
	private String name;

	/**
	 * 은행명
	 */
	private String bankName;

	/**
	 * 예금주
	 */
	private String bankOwnerName;

	/**
	 * 계좌 번호
	 */
	private String bankNum;

	/**
	 * E-mail
	 */
	private String email;

	/**
	 * 핸드폰번호
	 */
	private String mobile;
}
