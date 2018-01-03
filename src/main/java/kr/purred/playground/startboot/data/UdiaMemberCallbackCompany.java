package kr.purred.playground.startboot.data;

import lombok.Data;

@Data
public class UdiaMemberCallbackCompany
{
	/**
	 * 회사명
	 */
	private String companyName;

	/**
	 * 대표자명
	 */
	private String ceoName;

	/**
	 * 사업자 번호
	 */
	private String companyNo;

	/**
	 * 업체 연락처
	 */
	private String companyPhone;

	/**
	 * 업종
	 */
	private String type1;

	/**
	 * 업태
	 */
	private String type2;

	/**
	 * 담당자 이름
	 */
	private String contactName;

	/**
	 * 사용자 구분 코드
	 *
	 * 법인 : CORPORATE
	 * 개인사업자 : INDIVIDUAL
	 */
	private String companyClassType;

	/**
	 * 우편번호
	 */
	private String zipCode;

	/**
	 * 도로명 주소
	 */
	private String roadAddr;

	/**
	 * 디테일 주소
	 */
	private String detailAddr;

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
